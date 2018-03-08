package me.wedding.dytwedding.services;

import me.wedding.dytwedding.domain.Wedding;
import reactor.core.publisher.Flux;

public interface WeddingService {
    Flux<Wedding> getAllWeddings();
}
