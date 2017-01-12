package com.example.eddy.sharedpreferences;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;

/**
 * Created by eddy on 1/12/2017.
 */

public class SavedPreferencesTextWatcher implements TextWatcher {

    private SharedPreferences sharedPreferences;
    private String key;

    public SavedPreferencesTextWatcher(SharedPreferences sharedPreferences, String key) {
        this.key = key;
        this.sharedPreferences = sharedPreferences;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        sharedPreferences.edit().putString(key, s.toString()).apply();
    }
}
