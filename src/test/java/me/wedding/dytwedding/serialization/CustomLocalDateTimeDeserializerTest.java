package me.wedding.dytwedding.serialization;

import com.fasterxml.jackson.databind.ObjectMapper;
import me.wedding.dytwedding.domain.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.IOException;
import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
class CustomLocalDateTimeDeserializerTest {

    private Appointment appointment;

    @BeforeEach
    void setUp() {
        appointment = Appointment.builder()
                .appointmentDate(LocalDateTime.of(2018, 1, 1, 15, 10))
                .appointmentLocation("Londres")
                .build();
    }

    @Test
    void deserialize() throws IOException {
        ObjectMapper map = new ObjectMapper();
        String json = "{\"appointmentDate\":\"01/01/2018 15:10\",\"appointmentLocation\":\"Londres\"}";
        Appointment x = map.readValue(json, Appointment.class);
        assertThat(x).isEqualTo(appointment);
    }
}