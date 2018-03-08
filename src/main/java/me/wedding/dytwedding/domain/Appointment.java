package me.wedding.dytwedding.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {

    private LocalDateTime appointmentDate;
    private String appointmentLocation;

}
