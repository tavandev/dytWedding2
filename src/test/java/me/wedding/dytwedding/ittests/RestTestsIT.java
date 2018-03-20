package me.wedding.dytwedding.ittests;

import me.wedding.dytwedding.BootDatasTests;
import me.wedding.dytwedding.controllers.WeddingRestController;
import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.repositories.WeddingRepository;
import me.wedding.dytwedding.services.WeddingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class RestTestsIT {

    private WebTestClient client;

    @Autowired
    private WeddingRestController controller;

    @Autowired
    private WeddingService service;

    @Autowired
    private WeddingRepository repository;

    private BootDatasTests datasTests;

    @BeforeEach
    void setUp() {
        client = WebTestClient.bindToController(controller).build();

        datasTests = new BootDatasTests();

        StepVerifier.create(repository.deleteAll()).verifyComplete();

        StepVerifier.create(repository.saveAll(Flux.just(datasTests.getWedding1(), datasTests.getWedding2())))
                .expectNextCount(2L)
                .verifyComplete();
    }

    @Test
    void findAll() {
        client.get().uri("/api/wedding/all")
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$[0].couple.groom.firstName").isEqualTo("Romeo");
    }

    @Test
    void findById() {
        String id = repository.findAll().blockFirst().getWeddingId();

        client.get().uri("/api/wedding/{id}", id)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$.couple.groom.firstName").isEqualTo("Romeo");
    }

    @Test
    void addWedding() {
        Wedding weddingToAdd = datasTests.getWedding1();

        client.post().uri("/api/wedding/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(weddingToAdd))
                .exchange()
                .expectStatus().isCreated()
                .expectBody()
                .jsonPath("$.couple.groom.firstName").isEqualTo("Romeo");
    }
}
