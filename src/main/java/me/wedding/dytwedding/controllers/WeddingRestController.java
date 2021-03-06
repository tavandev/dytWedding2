package me.wedding.dytwedding.controllers;

import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.exceptions.WeddingNotFoundException;
import me.wedding.dytwedding.services.WeddingService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api")
public class WeddingRestController {

    private WeddingService weddingService;

    public WeddingRestController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    @CrossOrigin
    @GetMapping("/wedding/all")
    public Flux<Wedding> allWeddings() {
        return weddingService.getAllWeddings();
    }

    @CrossOrigin
    @PostMapping("/wedding/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public Mono<Wedding> addWedding(@RequestBody Wedding wedding) {
        return weddingService.saveWedding(wedding);
    }

    @CrossOrigin
    @GetMapping("/wedding/{id}")
    public Mono<Wedding> findWeddingById(@PathVariable String id) {
        return weddingService.findWeddingById(id);
    }

    @PutMapping("/wedding/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Mono<Wedding> updateWedding(@PathVariable String id, @RequestBody Wedding wedding) {
        return weddingService.updateWedding(id, wedding);
    }

    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ExceptionHandler({WeddingNotFoundException.class})
    public String okl(Exception ex) {
        return ex.getMessage();
    }

    @DeleteMapping("/wedding/{id}")
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public Mono<Void> deleteWedding(@PathVariable String id) {
        return weddingService.deleteWedding(id);
    }


}
