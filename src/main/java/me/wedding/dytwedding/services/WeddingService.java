package me.wedding.dytwedding.services;

import me.wedding.dytwedding.domain.Wedding;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WeddingService {
    Flux<Wedding> getAllWeddings();

    Mono<Wedding> saveWedding(Wedding wedding);
}
