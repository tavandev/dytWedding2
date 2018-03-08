package me.wedding.dytwedding.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document
public class Wedding {

    private String weddingId;

    private Couple couple;

    private LocalDate weddingDate;

    private List<Appointment> appointments;

    private EngagementSession engagementSession;

    private List<Person> witnesses;

    private Planning weddingPlanning;

    private Contract contract;

    private String notes;
}
