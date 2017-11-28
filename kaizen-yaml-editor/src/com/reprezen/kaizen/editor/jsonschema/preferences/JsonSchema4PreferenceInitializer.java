package com.reprezen.kaizen.editor.jsonschema.preferences;

import org.eclipse.jface.preference.IPreferenceStore;

import com.reprezen.kaizen.editor.jsonschema.Activator;
import com.reprezen.swagedit.core.preferences.JsonPreferenceInitializer;

public class JsonSchema4PreferenceInitializer extends JsonPreferenceInitializer {

    @Override
    public void initializeDefaultPreferences() {
        IPreferenceStore store = Activator.getDefault().getPreferenceStore();
        setColorPreferences(store);
    }

}
