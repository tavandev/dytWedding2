package me.wedding.dytwedding.domain;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.*;
import me.wedding.dytwedding.serialization.CustomLocalDateTimeDeserializer;
import me.wedding.dytwedding.serialization.CustomLocalDateTimeSerializer;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Appointment {

    @JsonSerialize(using = CustomLocalDateTimeSerializer.class)
    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    private LocalDateTime appointmentDate;

    private String appointmentLocation;

}
