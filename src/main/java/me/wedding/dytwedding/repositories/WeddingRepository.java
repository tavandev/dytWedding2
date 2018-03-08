package me.wedding.dytwedding.repositories;

import me.wedding.dytwedding.domain.Wedding;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface WeddingRepository extends ReactiveMongoRepository<Wedding, String> {
}
