package com.reprezen.kaizen.editor.jsonschema.schema;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonPointer;
import com.fasterxml.jackson.databind.JsonNode;
import com.reprezen.swagedit.core.schema.CompositeSchema;
import com.reprezen.swagedit.core.schema.JsonSchema;
import com.reprezen.swagedit.core.schema.ObjectTypeDefinition;

public class JsonSchema4Schema extends CompositeSchema {

    public JsonSchema4Schema() {

        JsonNode content;
        try {
            content = mapper.readTree(getClass().getResourceAsStream("schema.json"));
        } catch (IOException e) {
            return;
        }

        swaggerType = new JsonSchema(content, this);
        swaggerType.setType(new ObjectTypeDefinition(swaggerType, JsonPointer.compile(""), content));

    }

}
