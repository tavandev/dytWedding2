package me.wedding.dytwedding.services;

import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.repositories.WeddingRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

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
}
