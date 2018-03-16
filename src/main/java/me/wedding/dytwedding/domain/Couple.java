package me.wedding.dytwedding.domain;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Couple {

    private Person groom;
    private Person bride;

    private Address address;
    private Address addressAfterWedding;
}
