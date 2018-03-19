package me.wedding.dytwedding.domain;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.io.IOException;
import java.util.Arrays;
import java.util.EnumSet;
import java.util.List;
import java.util.stream.Collectors;

public class WeddingOptionsDeserializer extends JsonDeserializer<EnumSet<WeddingOptions>> {
    @Override
    public EnumSet<WeddingOptions> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        final ObjectCodec oc = p.getCodec();
        final ArrayNode node = oc.readTree(p);

        final List<String> val = Arrays.asList(oc.treeToValue(node, String[].class));

        final List<WeddingOptions> res = Arrays.stream(WeddingOptions.values())
                        .filter(i -> val.stream().anyMatch(i.getDescription()::equalsIgnoreCase))
                        .collect(Collectors.toList());

        return EnumSet.copyOf(res);
    }
}
