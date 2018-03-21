package me.wedding.dytwedding.services;

import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.exceptions.WeddingNotFoundException;
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
        return repository.findById(id).switchIfEmpty(Mono.error(new WeddingNotFoundException("Wedding " + id + " not found")));
    }

    @Override
    public Mono<Wedding> updateWedding(String id, Wedding wedding) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new WeddingNotFoundException("Wedding not found")))
                .map(p -> {
                    p.setCouple(wedding.getCouple());
                    return p;
                })
                .flatMap(p -> repository.save(p));
    }

    @Override
    public Mono<Void> deleteWedding(String id) {
        return repository.findById(id)
                .switchIfEmpty(Mono.error(new WeddingNotFoundException("Wedding not found")))
                .flatMap(w -> repository.delete(w));
    }
}
