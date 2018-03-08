//package me.wedding.dytwedding.repositories;
//
//import me.wedding.dytwedding.DatasForTest;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import reactor.core.publisher.Flux;
//import reactor.test.StepVerifier;
//
//@ExtendWith(SpringExtension.class)
//@DataMongoTest
//class WeddingRepositoryTest {
//
//    @Autowired
//    private WeddingRepository repository;
//
//    private DatasForTest datasForTest = new DatasForTest();
//
//    @BeforeEach
//    void setUp() {
//    }
//
//    @Test
//    void findAll() {
//        StepVerifier.create(repository.deleteAll()).verifyComplete();
//
//        StepVerifier.create(repository.saveAll(Flux.just(datasForTest.wedding1)))
//                .expectNextCount(1L)
//                .verifyComplete();
//
//        StepVerifier.create(repository.findAll())
//                .expectNextCount(1L)
//                .verifyComplete();
//    }
//}