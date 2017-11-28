package com.reprezen.kaizen.editor.jsonschema.editor;

import java.net.URI;
import java.util.Collection;
import java.util.Collections;

import org.dadacoalition.yedit.editor.YEditSourceViewerConfiguration;
import org.eclipse.jface.text.IInformationControlCreator;
import org.eclipse.jface.text.contentassist.ContentAssistant;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.hyperlink.URLHyperlinkDetector;
import org.eclipse.jface.text.source.ISourceViewer;

import com.reprezen.kaizen.editor.jsonschema.Activator;
import com.reprezen.kaizen.editor.jsonschema.hyperlinks.JsonSchema4ReferenceHyperlinkDetector;
import com.reprezen.swagedit.core.assist.JsonContentAssistProcessor;
import com.reprezen.swagedit.core.editor.JsonDocument;
import com.reprezen.swagedit.core.editor.JsonEditor;
import com.reprezen.swagedit.core.editor.JsonSourceViewerConfiguration;
import com.reprezen.swagedit.core.json.references.JsonReferenceFactory;
import com.reprezen.swagedit.core.json.references.JsonReferenceValidator;
import com.reprezen.swagedit.core.schema.CompositeSchema;
import com.reprezen.swagedit.core.validation.SwaggerError;
import com.reprezen.swagedit.core.validation.Validator;

public class JsonSchema4Editor extends JsonEditor {

    public static final String ID = "com.reprezen.kaizen.editor.jsonschema.editor";

    public JsonSchema4Editor() {
        super(new JsonSchema4DocumentProvider(), Activator.getDefault().getPreferenceStore());
    }

    @Override
    protected YEditSourceViewerConfiguration createSourceViewerConfiguration() {
        sourceViewerConfiguration = new OpenApi3SourceViewerConfiguration();
        sourceViewerConfiguration.setEditor(this);
        return sourceViewerConfiguration;
    }

    public static class OpenApi3SourceViewerConfiguration extends JsonSourceViewerConfiguration {

        public OpenApi3SourceViewerConfiguration() {
            super(Activator.getDefault().getPreferenceStore());
        }

        @Override
        protected JsonContentAssistProcessor createContentAssistProcessor(ContentAssistant ca) {
            return super.createContentAssistProcessor(ca);
        }

        @Override
        public IHyperlinkDetector[] getHyperlinkDetectors(ISourceViewer sourceViewer) {
            return new IHyperlinkDetector[] { new URLHyperlinkDetector(), new JsonSchema4ReferenceHyperlinkDetector() };
        }

        @Override
        protected CompositeSchema getSchema() {
            return Activator.getDefault().getSchema();
        }

        @Override
        protected IInformationControlCreator getOutlineInformationControlCreator() {
            return getOutlineInformationControlCreator(JsonSchema4ContentDescriber.CONTENT_TYPE_ID);
        }

    }

    @Override
    protected Validator createValidator() {
        JsonReferenceValidator emptyReferenceValidator = new JsonReferenceValidator(new JsonReferenceFactory()) {
            @Override
            public Collection<? extends SwaggerError> validate(URI baseURI, JsonDocument doc) {
                // Do nothing, we don't validate the reference types
                return Collections.emptyList();
            }
        };
        return new Validator(emptyReferenceValidator);
    }

}
