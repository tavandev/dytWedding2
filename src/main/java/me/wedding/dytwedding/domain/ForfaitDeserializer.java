package me.wedding.dytwedding.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.TextNode;

import java.io.IOException;

public class ForfaitDeserializer extends JsonDeserializer<Forfait> {
    @Override
    public Forfait deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, RuntimeException {
        final ObjectCodec oc = p.getCodec();
        final TextNode node = oc.readTree(p);
        final String value = node.asText();

        if (value.equalsIgnoreCase("Forfait1") || value.equalsIgnoreCase("Forfait 1")) {
            return Forfait.FORFAIT1;
        } else if (value.equalsIgnoreCase("Forfait2") || value.equalsIgnoreCase("Forfait 2")) {
            return Forfait.FORFAIT2;
        } else if (value.equalsIgnoreCase("Forfait3") || value.equalsIgnoreCase("Forfait 3")) {
            return Forfait.FORFAIT3;
        } else {
            throw new RuntimeException("Wrong kind of Forfait");
        }
    }
}
