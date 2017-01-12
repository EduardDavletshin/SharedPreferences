package com.example.eddy.sharedpreferences;

import android.content.SharedPreferences;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by eddy on 1/12/2017.
 */

public class MyTextWatcher implements TextWatcher {

    private SharedPreferences sharedPreferences;
    private String string;
    private EditText editText;

    public MyTextWatcher(SharedPreferences sharedPreferences, String string, EditText editText) {
        this.editText = editText;
        this.string = string;
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
        sharedPreferences.edit().putString(string, editText.getText().toString()).apply();
    }
}
