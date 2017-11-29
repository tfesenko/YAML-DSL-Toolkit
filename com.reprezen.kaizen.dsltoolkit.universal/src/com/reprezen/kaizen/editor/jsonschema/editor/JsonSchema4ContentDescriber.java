package com.reprezen.kaizen.editor.jsonschema.editor;

import com.reprezen.swagedit.core.editor.TextContentDescriber;

public class JsonSchema4ContentDescriber extends TextContentDescriber {
	
	public static final String CONTENT_TYPE_ID = "com.reprezen.kaizen.editor.jsonschema.contenttype.yaml";

    @Override
    protected boolean isSupported(String content) {
        // Supports any kind of YAML
        return true;
    }

}
