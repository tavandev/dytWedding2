package me.wedding.dytwedding.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import me.wedding.dytwedding.domain.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class CustomLocalDateTimeSerializerTest {

    private Appointment appointment;

    @BeforeEach
    void setUp() {
        appointment = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 15, 10))
                .appointmentLocation("Londres")
                .build();
    }

    @Test
    void serialize() throws JsonProcessingException {
        ObjectMapper map = new ObjectMapper();
        String json = "{\"appointmentDate\":\"2018-01-01T15:10:00.000Z\",\"appointmentLocation\":\"Londres\"}";
        String x = map.writeValueAsString(appointment);
        assertThat(x).isEqualToIgnoringCase(json);
    }
}