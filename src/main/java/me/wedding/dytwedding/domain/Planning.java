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
    private Appointment coupleShotsLocation;
    private Appointment ReligiousCeremonyLocation;
    private Appointment townhallLocation;
    private Appointment civilCeremonyLocation;
    private Appointment cocktailLocation;
    private Appointment receptionLocation;
}
