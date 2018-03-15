package me.wedding.dytwedding.services;

import me.wedding.dytwedding.BootDatasTests;
import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.repositories.WeddingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.test.StepVerifier;

@ExtendWith(SpringExtension.class)
class WeddingServiceTest {

    @Mock
    private WeddingRepository weddingRepository;

    @InjectMocks
    private WeddingServiceImpl weddingService;

    private BootDatasTests datasForTest = new BootDatasTests();

    @Test
    void getAllWeddings() {
        Mockito.when(weddingRepository.findAll()).thenReturn(Flux.just(datasForTest.getWedding1(), datasForTest.getWedding2()));

        Flux<Wedding> weddingFlux = weddingService.getAllWeddings();

        StepVerifier.create(weddingFlux)
                .expectNextCount(2L)
                .verifyComplete();

        Mockito.verify(weddingRepository).findAll();
    }
}