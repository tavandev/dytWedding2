package me.wedding.dytwedding.domain;

import java.util.EnumSet;

public enum Forfait {
    FORFAIT1, FORFAIT2, FORFAIT3;

    public static EnumSet<WeddingOptions> getForfaitOptions(Forfait f) {
        switch (f) {
            case FORFAIT1:
                return EnumSet.of(
                        WeddingOptions.PREPARATIFS,
                        WeddingOptions.CLEUSBCOFFRET,
                        WeddingOptions.CEREMONIECIVILE,
                        WeddingOptions.CEREMONIELAIQUE,
                        WeddingOptions.CEREMONIERELIGIEUSE,
                        WeddingOptions.GALLERIEWEB,
                        WeddingOptions.PHOTOSDECOUPLE,
                        WeddingOptions.PHOTOSDEGROUPE,
                        WeddingOptions.SEANCEENGAGEMENT,
                        WeddingOptions.VINDHONNEUR,
                        WeddingOptions.DECOALLIANCE
                );
            case FORFAIT2:
                return EnumSet.of(
                        WeddingOptions.CLEUSBCOFFRET,
                        WeddingOptions.CEREMONIECIVILE,
                        WeddingOptions.CEREMONIELAIQUE,
                        WeddingOptions.CEREMONIERELIGIEUSE,
                        WeddingOptions.GALLERIEWEB,
                        WeddingOptions.PHOTOSDECOUPLE,
                        WeddingOptions.PHOTOSDEGROUPE,
                        WeddingOptions.SEANCEENGAGEMENT,
                        WeddingOptions.VINDHONNEUR,
                        WeddingOptions.DECOALLIANCE,
                        WeddingOptions.SOIREE
                );
            case FORFAIT3:
                return EnumSet.of(
                        WeddingOptions.CLEUSBCOFFRET,
                        WeddingOptions.PREPARATIFS,
                        WeddingOptions.CEREMONIECIVILE,
                        WeddingOptions.CEREMONIELAIQUE,
                        WeddingOptions.CEREMONIERELIGIEUSE,
                        WeddingOptions.GALLERIEWEB,
                        WeddingOptions.PHOTOSDECOUPLE,
                        WeddingOptions.PHOTOSDEGROUPE,
                        WeddingOptions.SEANCEENGAGEMENT,
                        WeddingOptions.VINDHONNEUR,
                        WeddingOptions.DECOALLIANCE,
                        WeddingOptions.SOIREE
                );
            default:
                return EnumSet.noneOf(WeddingOptions.class);
        }
    }
}
