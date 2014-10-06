package com.bbgatestudios.apitest;

import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;

/**
 * Created by John on 9/6/2014.
 */
public class SettingsFragment extends PreferenceFragment {
    @Override
    public void onCreate(Bundle _savedInstanceState) {
        super.onCreate(_savedInstanceState);

        // Load the preferences from our XML file.
        addPreferencesFromResource(R.xml.settings);
    }

    @Override
    public void onActivityCreated(Bundle _savedInstanceState) {
        super.onActivityCreated(_savedInstanceState);
        // Find preference by key
        Preference pref = findPreference("PREF_CLICK");
        pref.setOnPreferenceClickListener(new Preference.OnPreferenceClickListener() {
            @Override
            public boolean onPreferenceClick(Preference _pref) {
                // Do what you want
                return true;
            }
        });
    }
}
