package me.wedding.dytwedding.domain;


import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import org.springframework.data.annotation.AccessType;

import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Contract {
    @Getter
    @Setter
    @NonNull
    @JsonSerialize(using = ForfaitSerializer.class)
    @JsonDeserialize(using = ForfaitDeserializer.class)
    private Forfait forfait;

    @Getter
    @Setter
    @Builder.Default
    @JsonSerialize(using = WeddingOptionsSerializer.class)
    @JsonDeserialize(using = WeddingOptionsDeserializer.class)
    private EnumSet<WeddingOptions> options = EnumSet.noneOf(WeddingOptions.class);


    @Getter
    @Setter
    @Builder.Default
    private Double deposit = 0.0;

    @Getter
    @Setter
    @Builder.Default
    private Double remise = 0.0;

    private double price;
    private List<String> details;

    @AccessType(AccessType.Type.PROPERTY)
    public double getPrice() {
        return (Forfait.getForfaitOptions(Objects.requireNonNull(forfait)).stream().mapToDouble(WeddingOptions::getPrice).sum()
                + options.stream().mapToDouble(WeddingOptions::getPrice).sum())
                - remise;
    }

    @AccessType(AccessType.Type.PROPERTY)
    public List<String> getDetails() {
        return Stream.concat(
                Forfait.getForfaitOptions(Objects.requireNonNull(forfait)).stream().map(WeddingOptions::getDescription),
                options.stream().map(WeddingOptions::getDescription))
                .distinct()
                .collect(Collectors.toList());
    }
}
