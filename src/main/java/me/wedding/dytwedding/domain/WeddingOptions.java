package me.wedding.dytwedding.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WeddingOptions {
    ESSAYAGEROBEMARIEE(109.00, "Essayage robe de la mariée", 1),
    SEANCEENGAGEMENT(108.00, "Séance engagement", 2),
    PREPARATIFS(100.00, "Séance préparatifs", 3),
    PHOTOSDECOUPLE(101.00, "Photos de couple", 4),
    CEREMONIECIVILE(102.00, "Cérémonie civile", 5),
    CEREMONIERELIGIEUSE(103.00, "Cérémonie religieuse", 6),
    CEREMONIELAIQUE(104.00, "Cérémonie laïque", 7),
    VINDHONNEUR(105.00, "Vin d'honneur", 8),
    PHOTOSDEGROUPE(106.00, "Photos de groupe", 9),
    DECOALLIANCE(117.00, "Photos de la déco, bouquet alliances", 10),
    SOIREE(107.00, "Couverture de la soirée", 11),
    GALLERIEWEB(112.00, "Galerie web", 12),
    CLEUSBCOFFRET(113.00, "Clé usb + coffret + tirages", 13),
    PHOTOBOOTH(115.00, "Photobooth", 14),
    LIVRELUXE(114.00, "livre photo luxe", 15),
    SEANCEDAYAFTER(110.00, "Séance photo de couple après le mariage", 16),
    SEANCETRASHTHEDRESS(111.00, "Séance trash the dress", 17),
    LARGEPRINT(116.00, "Grand tirage sur toile", 18);


    private Double price;
    private String description;
    private int order;
}