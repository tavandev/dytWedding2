package me.wedding.dytwedding.domain;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode
public class Address {

    private String street1;
    private String street2;
    private Integer zipCode;
    private String city;
}
