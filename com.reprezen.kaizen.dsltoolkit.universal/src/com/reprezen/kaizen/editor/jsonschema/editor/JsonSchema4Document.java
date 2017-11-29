package com.reprezen.kaizen.editor.jsonschema.editor;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.reprezen.kaizen.editor.jsonschema.Activator;
import com.reprezen.kaizen.editor.jsonschema.schema.JsonSchema4Schema;
import com.reprezen.swagedit.core.editor.JsonDocument;

public class JsonSchema4Document extends JsonDocument {

	public JsonSchema4Document() {
        this(Activator.getDefault().getSchema());
	}

    public JsonSchema4Document(JsonSchema4Schema schema) {
        super(new ObjectMapper(new YAMLFactory()), schema);
    }

}
