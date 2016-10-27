package com.example.anoim.regist;

import android.app.Activity;
import android.content.Intent;
import android.hardware.SensorEventCallback;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends Activity {
    protected EditText  first_name,last_name,input_password,email_address,user_name;
    Spinner spinner;
    String firstname,lastname,password,email,username;
    Button regist;
    ArrayAdapter<CharSequence> adapter;
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
        first_name=(EditText) findViewById(R.id.first_name);
        last_name=(EditText) findViewById(R.id.last_name);
        email_address=(EditText) findViewById(R.id.email_address);
        user_name=(EditText) findViewById(R.id.user_name);
        input_password=(EditText) findViewById(R.id.input_password);
        regist=(Button) findViewById(R.id.regist);
        regist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                register();
            }
        });
    }
    public void register()
    {
        intialize();
        if(!validate()){
            Toast.makeText(this, "Registration has failed",Toast.LENGTH_SHORT).show();
        }
        else{
            onSignupSuccess();
        }
    }
    public void onSignupSuccess(){
        Intent intent = new Intent(this, SecondActivity.class);
        intent.putExtra("firstname",firstname);
        intent.putExtra("lastname",lastname);
        intent.putExtra("email",email);
        intent.putExtra("password",password);
        intent.putExtra("username",username);
        startActivity(intent);
    }
    public boolean validate(){
        boolean valid=true;
        if(firstname.isEmpty()||firstname.length()<3){
            first_name.setError("Please Enter Valid First Name");
            valid=false;
        }
        if(lastname.isEmpty()||last_name.length()<3){
            last_name.setError("Please Enter Valid Last Name");
            valid=false;
        }
        if(username.isEmpty()||username.length()<5){
            user_name.setError("Please Enter Valid Username");
            valid=false;
        }
        if(password.isEmpty()||password.length()<8){
            input_password.setError("Please Enter Valid Password");
            valid=false;
        }
        if(email.isEmpty()||!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            email_address.setError("Please Enter valid Email Addres");
            valid=false;
        }

        return valid;
    }
    private void intialize() {
        firstname=first_name.getText().toString().trim();
        lastname=last_name.getText().toString().trim();
        email=email_address.getText().toString().trim();
        password=input_password.getText().toString().trim();
        username=user_name.getText().toString().trim();
    }
}
