package me.wedding.dytwedding.domain;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;

public class ForfaitSerializer extends JsonSerializer<Forfait> {
    @Override
    public void serialize(Forfait value, JsonGenerator gen, SerializerProvider serializers) throws IOException {
        String res;
        switch (value) {
            case FORFAIT1: res = "Forfait 1"; break;
            case FORFAIT2: res = "Forfait 2"; break;
            case FORFAIT3: res = "Forfait 3"; break;
            default: res = "Forfait inconnu"; break;
        }
        gen.writeString(res);
    }
}
