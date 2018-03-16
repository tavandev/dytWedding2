package me.wedding.dytwedding.controllers;

import me.wedding.dytwedding.BootDatasTests;
import me.wedding.dytwedding.domain.Wedding;
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
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@ExtendWith(SpringExtension.class)
class RestControllerTest {

    private WebTestClient webTestClient;

    @Mock
    private WeddingService weddingService;

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
        Mockito.when(weddingService.getAllWeddings()).thenReturn(Flux.just());

        webTestClient.get().uri("/api/wedding/all")
                .exchange()
                .expectStatus().isOk();

        Mockito.verify(weddingService).getAllWeddings();
    }

    @Test
    void addWedding() {
        Wedding wedding = bootDatasTests.getWedding1();

        Mockito.when(weddingService.saveWedding(ArgumentMatchers.any())).thenReturn(Mono.just(wedding));

        webTestClient.post().uri("/api/wedding/add")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .body(BodyInserters.fromObject(wedding))
                .exchange()
                .expectStatus().isCreated();

        Mockito.verify(weddingService).saveWedding(ArgumentMatchers.any());
    }
}