package com.example.anoim.regist;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorEventCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    Spinner spinner;
    EditText message_text;
    ArrayAdapter<CharSequence> adapter;
    public final static String MESSAGE_KEY="com.example.anoim.regist.message_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spinner =(Spinner)findViewById(R.id.spinner);
        adapter=ArrayAdapter.createFromResource(this, R.array.country_names,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected",Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void regist(View views)
    {
        message_text=(EditText)findViewById(R.id.first_name);
        String message=message_text.getText().toString();
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("fname",message);
        startActivity(intent);
        }
    }
