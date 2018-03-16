package me.wedding.dytwedding.services;

import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.repositories.WeddingRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class WeddingServiceImpl implements WeddingService {
    private WeddingRepository repository;

    public WeddingServiceImpl(WeddingRepository repository) {
        this.repository = repository;
    }

    @Override
    public Flux<Wedding> getAllWeddings() {
        return repository.findAll();
    }

    @Override
    public Mono<Wedding> saveWedding(Wedding wedding) {
        return repository.save(wedding);
    }

    @Override
    public Mono<Wedding> findWeddingById(String id) {
        return repository.findById(id);
    }
}
