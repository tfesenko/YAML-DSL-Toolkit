package com.reprezen.kaizen.editor.jsonschema.hyperlinks;

import org.eclipse.core.resources.IFile;
import org.eclipse.jface.text.IRegion;

import com.fasterxml.jackson.core.JsonPointer;
import com.reprezen.kaizen.editor.jsonschema.editor.JsonSchema4Document;
import com.reprezen.swagedit.core.editor.JsonDocument;
import com.reprezen.swagedit.core.hyperlinks.JsonFileHyperlink;
import com.reprezen.swagedit.core.hyperlinks.JsonReferenceHyperlinkDetector;

public class JsonSchema4ReferenceHyperlinkDetector extends JsonReferenceHyperlinkDetector {

	@Override
	protected JsonFileHyperlink createFileHyperlink(IRegion linkRegion, String label, IFile file, JsonPointer pointer) {
		return new SwaggerFileHyperlink(linkRegion, label, file, pointer);
	}
	
	public static class SwaggerFileHyperlink extends JsonFileHyperlink {

		public SwaggerFileHyperlink(IRegion linkRegion, String label, IFile file, JsonPointer pointer) {
			super(linkRegion, label, file, pointer);
		}

		@Override
		protected JsonDocument createDocument() {
			return new JsonSchema4Document();
		}
		
	}

}
