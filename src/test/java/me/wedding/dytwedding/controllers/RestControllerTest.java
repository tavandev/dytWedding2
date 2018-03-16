package me.wedding.dytwedding.controllers;

import me.wedding.dytwedding.BootDatasTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;
import org.springframework.web.reactive.function.BodyInserters;

@ExtendWith(SpringExtension.class)
@SpringBootTest
class RestControllerTest {

    private WebTestClient webTestClient;

    @Autowired
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
        webTestClient.get().uri("/api/wedding/{id}", "id")
                .exchange()
                .expectStatus().isOk();
    }
}