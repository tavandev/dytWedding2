package me.wedding.dytwedding.domain;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String fistName;
    private String lastName;

    private List<String> phoneNumbers;
    private String email;
}
