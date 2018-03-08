package me.wedding.dytwedding.controllers;

import me.wedding.dytwedding.services.WeddingService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Flux;

@ExtendWith(SpringExtension.class)
class RestControllerTest {

    private WebTestClient webTestClient;

    @Mock
    private WeddingService weddingService;

    @InjectMocks
    private WeddingRestController controller;


    @BeforeEach
    void setUp() {
        webTestClient = WebTestClient.bindToController(controller).build();

    }

    @Test
    void all() {
        Mockito.when(weddingService.getAllWeddings()).thenReturn(Flux.just());

        webTestClient.get().uri("/api/wedding/all")
                .exchange()
                .expectStatus().isOk();

        Mockito.verify(weddingService).getAllWeddings();
    }
}