package me.wedding.dytwedding.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Person {
    private String firstName;
    private String lastName;

    private List<String> phoneNumbers;
    private String email;
}
