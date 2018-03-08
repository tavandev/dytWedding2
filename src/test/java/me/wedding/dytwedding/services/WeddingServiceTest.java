//package me.wedding.dytwedding.services;
//
//import me.wedding.dytwedding.DatasForTest;
//import me.wedding.dytwedding.domain.Wedding;
//import me.wedding.dytwedding.repositories.WeddingRepository;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.api.extension.ExtendWith;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.springframework.test.context.junit.jupiter.SpringExtension;
//import reactor.core.publisher.Flux;
//import reactor.test.StepVerifier;
//
//@ExtendWith(SpringExtension.class)
//class WeddingServiceTest {
//
//    @Mock
//    private WeddingRepository weddingRepository;
//
//    @InjectMocks
//    private WeddingServiceImpl weddingService;
//
//    private DatasForTest datasForTest = new DatasForTest();
//
//    @Test
//    void getAllWeddings() {
//        Mockito.when(weddingRepository.findAll()).thenReturn(Flux.just(datasForTest.wedding1));
//
//        Flux<Wedding> weddingFlux = weddingService.getAllWeddings();
//
//        StepVerifier.create(weddingFlux)
//                .expectNextCount(1L)
//                .verifyComplete();
//
//        Mockito.verify(weddingRepository).findAll();
//    }
//}