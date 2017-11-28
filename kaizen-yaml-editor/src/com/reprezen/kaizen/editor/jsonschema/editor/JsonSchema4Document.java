package com.reprezen.kaizen.editor.jsonschema.editor;

import com.reprezen.kaizen.editor.jsonschema.Activator;
import com.reprezen.kaizen.editor.jsonschema.schema.JsonSchema4Schema;
import com.reprezen.swagedit.core.editor.JsonDocument;

public class JsonSchema4Document extends JsonDocument {

	public JsonSchema4Document() {
        this(Activator.getDefault().getSchema());
	}

    public JsonSchema4Document(JsonSchema4Schema schema) {
        super(io.swagger.util.Yaml.mapper(), schema);
    }

}
