package me.wedding.dytwedding.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.util.EnumSet;

public class WeddingOptionsSerializer extends JsonSerializer<EnumSet<WeddingOptions>> {
    @Override
    public void serialize(EnumSet<WeddingOptions> value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        gen.writeStartArray();

        for (WeddingOptions weddingOptions : value) {
            String description = weddingOptions.getDescription();
            gen.writeString(description);
        }

        gen.writeEndArray();
    }
}
