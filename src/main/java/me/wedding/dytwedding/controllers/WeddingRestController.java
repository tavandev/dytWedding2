package me.wedding.dytwedding.controllers;

import me.wedding.dytwedding.domain.Wedding;
import me.wedding.dytwedding.services.WeddingService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping("/api")
public class WeddingRestController {

    private WeddingService weddingService;

    public WeddingRestController(WeddingService weddingService) {
        this.weddingService = weddingService;
    }

    @GetMapping("/wedding/all")
    public Flux<Wedding> allWeddings() {
        return weddingService.getAllWeddings();
    }
}
