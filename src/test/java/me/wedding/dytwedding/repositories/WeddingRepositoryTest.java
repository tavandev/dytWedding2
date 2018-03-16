package me.wedding.dytwedding.repositories;

import me.wedding.dytwedding.BootDatasTests;
import me.wedding.dytwedding.domain.Wedding;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
@DataMongoTest
class WeddingRepositoryTest {

    @Autowired
    private WeddingRepository repository;

    private BootDatasTests bootDatasTests;


    @BeforeEach
    void setUp() {
        bootDatasTests = new BootDatasTests();
        Wedding wedding1 = bootDatasTests.getWedding1();
        Wedding wedding2 = bootDatasTests.getWedding2();

        StepVerifier.create(repository.deleteAll()).verifyComplete();

        StepVerifier.create(Flux.just(wedding1, wedding2).flatMap(repository::save))
                .expectNextCount(2L)
                .verifyComplete();
    }

    @Test
    void findAll() {
        StepVerifier.create(repository.findAll())
                .expectNextCount(2L)
                .verifyComplete();
    }

    @Test
    void saveWedding() {
        StepVerifier.create(repository.deleteAll()).verifyComplete();

        StepVerifier.create(repository.save(bootDatasTests.getWedding1()))
                .expectNext(bootDatasTests.getWedding1())
                .verifyComplete();
    }

    @Test
    void findWeddingById() {
        Wedding wedding1 = repository.findAll().blockFirst();
        String id = wedding1.getWeddingId();

        StepVerifier.create(repository.findById(id))
                .expectNext(wedding1)
                .verifyComplete();
    }
}