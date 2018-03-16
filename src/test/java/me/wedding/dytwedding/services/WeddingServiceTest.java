package me.wedding.dytwedding.services;

import me.wedding.dytwedding.BootDatasTests;
import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.exceptions.WeddingNotFoundException;
import me.wedding.dytwedding.repositories.WeddingRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import static org.junit.jupiter.api.Assertions.assertThrows;

@ExtendWith(SpringExtension.class)
class WeddingServiceTest {

    @Mock
    private WeddingRepository weddingRepository;

    @InjectMocks
    private WeddingServiceImpl weddingService;

    private BootDatasTests datasForTest = new BootDatasTests();

    @Test
    void getAllWeddings() {
        Mockito.when(weddingRepository.findAll())
                .thenReturn(Flux.just(datasForTest.getWedding1(), datasForTest.getWedding2()));

        Flux<Wedding> weddingFlux = weddingService.getAllWeddings();

        StepVerifier.create(weddingFlux)
                .expectNextCount(2L)
                .verifyComplete();

        Mockito.verify(weddingRepository).findAll();
    }

    @Test
    void saveWedding() {
        Mockito.when(weddingRepository.save(ArgumentMatchers.any())).thenReturn(Mono.just(datasForTest.getWedding1()));

        StepVerifier.create(weddingService.saveWedding(datasForTest.getWedding1()))
                .expectNext(datasForTest.getWedding1())
                .verifyComplete();

        Mockito.verify(weddingRepository).save(ArgumentMatchers.any());
    }

    @Test
    void findWeddingById() {
        Mockito.when(weddingRepository.findById(ArgumentMatchers.anyString())).thenReturn(Mono.just(datasForTest.getWedding2()));

        StepVerifier.create(weddingService.findWeddingById(ArgumentMatchers.anyString()))
                .expectNext(datasForTest.getWedding2())
                .verifyComplete();

        Mockito.verify(weddingRepository).findById(ArgumentMatchers.anyString());
    }

    @Test
    void WeddingByIdNotFoundThrowWeddingNotFoundException() {
        Mockito.when(weddingRepository.findById("un")).thenThrow(new WeddingNotFoundException("Error"));

        assertThrows(WeddingNotFoundException.class, () -> weddingService.findWeddingById("un"));

        Mockito.verify(weddingRepository).findById("un");
    }
}