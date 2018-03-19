package me.wedding.dytwedding.domain;


import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Planning {

    // Locations and hours
    private Appointment gettingReady;
    private Appointment coupleShots;
    private Appointment religiousCeremony;
    private Appointment townhall;
    private Appointment civilCeremony;
    private Appointment cocktail;
    private Appointment reception;
}
