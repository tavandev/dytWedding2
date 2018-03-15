package me.wedding.dytwedding.domain;

import lombok.*;

import java.time.LocalDateTime;
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Appointment {

    private LocalDateTime appointmentDate;

    private String appointmentLocation;

}
