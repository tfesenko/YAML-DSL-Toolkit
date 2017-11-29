package com.reprezen.kaizen.editor.jsonschema.editor;

import org.eclipse.jface.text.IDocument;

import com.reprezen.kaizen.editor.jsonschema.Activator;
import com.reprezen.swagedit.core.editor.JsonDocumentProvider;

public class JsonSchema4DocumentProvider extends JsonDocumentProvider {

	public JsonSchema4DocumentProvider() {
		super(Activator.getDefault().getPreferenceStore());
	}

	@Override
	protected IDocument createEmptyDocument() {
		return new JsonSchema4Document();
	}

}
