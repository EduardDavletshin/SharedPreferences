package com.example.eddy.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.edit_text_name)
    EditText editText_name;
    @BindView(R.id.edit_text_lastname)
    EditText editText_lastName;
    @BindView(R.id.edit_text_middlename)
    EditText editText_middlName;
    @BindView(R.id.edit_text_age)
    EditText editText_age;
    String name = "name";
    String lastName = "lastname";
    String middlename = "middlename";
    String age = "age";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        editText_name.setText(sharedPreferences.getString(name, ""));
        editText_lastName.setText(sharedPreferences.getString(lastName, ""));
        editText_middlName.setText(sharedPreferences.getString(middlename, ""));
        editText_age.setText(sharedPreferences.getString(age, ""));

        editText_name
                .addTextChangedListener(new SavedPreferencesTextWatcher(sharedPreferences, name));
        editText_lastName
                .addTextChangedListener(new SavedPreferencesTextWatcher(sharedPreferences, lastName));
        editText_middlName
                .addTextChangedListener(new SavedPreferencesTextWatcher(sharedPreferences, middlename));
        editText_age
                .addTextChangedListener(new SavedPreferencesTextWatcher(sharedPreferences, age));
    }
}

