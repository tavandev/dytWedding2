package me.wedding.dytwedding.controllers;

import me.wedding.dytwedding.BootDatasTests;
import me.wedding.dytwedding.exceptions.WeddingNotFoundException;
import me.wedding.dytwedding.services.WeddingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
class RestControllerTest {

    private WebTestClient webTestClient;

    @Mock
    private WeddingService service;

    @InjectMocks
    private WeddingRestController controller;

    private BootDatasTests bootDatasTests;


    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToController(controller).build();
        bootDatasTests = new BootDatasTests();
    }

    @Test
    void all() {
        webTestClient.get().uri("/api/wedding/all")
                .exchange()
                .expectStatus().isOk();
    }

    @Test
    void addWedding() {
        webTestClient.post().uri("/api/wedding/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(bootDatasTests.getWedding1()))
                .exchange()
                .expectStatus().isCreated();
    }

    @Test
    void findWeddingById() {
        Mockito.when(service.findWeddingById(ArgumentMatchers.anyString())).thenReturn(Mono.just(bootDatasTests.getWedding1()));

        webTestClient.get().uri("/api/wedding/{id}", "id")
                .exchange()
                .expectStatus().isOk();

        Mockito.verify(service).findWeddingById(ArgumentMatchers.anyString());
    }


    @Test
    void weddingNotFoundThrow404() {
        Mockito.when(service.findWeddingById("n")).thenThrow(new WeddingNotFoundException("Error"));

        webTestClient.get().uri("/api/wedding/{id}", "n")
                .exchange()
                .expectStatus().isNotFound();

        Mockito.verify(service).findWeddingById("n");
    }
}