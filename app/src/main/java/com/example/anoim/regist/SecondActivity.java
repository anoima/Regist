package com.example.anoim.regist;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class SecondActivity extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
        setContentView(R.layout.content_second);
        Intent intent =getIntent();
        String first_name=intent.getStringExtra("firstname");
        String last_name=intent.getStringExtra("lastname");

        Toast.makeText(this, "Successfully Registration!", Toast.LENGTH_LONG).show();
        textView=(TextView) findViewById(R.id.first_name);
        textView.setText(first_name);
        textView=(TextView) findViewById(R.id.last_name);
        textView.setText(last_name);
    }

}
