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

        editText_name.addTextChangedListener(new MyTextWatcher(sharedPreferences, name, editText_name));
        editText_lastName.addTextChangedListener(new MyTextWatcher(sharedPreferences, lastName, editText_lastName));
        editText_middlName.addTextChangedListener(new MyTextWatcher(sharedPreferences, middlename, editText_middlName));
        editText_age.addTextChangedListener(new MyTextWatcher(sharedPreferences, age, editText_age));
    }
}

