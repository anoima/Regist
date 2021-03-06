package com.example.anoim.regist;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

public class SecondActivity extends Activity {
  TextView textView;
  private GoogleApiClient client;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.content_second);
    Intent intent = getIntent();
    String username = intent.getStringExtra("username");
    String firstname = intent.getStringExtra("firstname");
    String lastname = intent.getStringExtra("lastname");
    String password = intent.getStringExtra("password");
    String email = intent.getStringExtra("email");
    String gender = intent.getStringExtra("gender");
    String country = intent.getStringExtra("country");
    String notification = intent.getStringExtra("notification");
    Button backbutton = (Button) findViewById(R.id.back);
    backbutton.setOnClickListener(new View.OnClickListener() {

      @Override
      public void onClick(View v) {
        Intent intent  = new Intent(getBaseContext(), MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
      }
    });

    Toast.makeText(this, "Successfully Registration!", Toast.LENGTH_LONG).show();
    textView = (TextView) findViewById(R.id.user_name);
    textView.setText(username);
    textView = (TextView) findViewById(R.id.first_name);
    textView.setText(firstname);
    textView = (TextView) findViewById(R.id.last_name);
    textView.setText(lastname);
    textView = (TextView) findViewById(R.id.input_password);
    textView.setText(password);
    textView = (TextView) findViewById(R.id.email_address);
    textView.setText(email);
    textView = (TextView) findViewById(R.id.gender);
    textView.setText(gender);
    textView = (TextView) findViewById(R.id.country);
    textView.setText(country);
    textView = (TextView) findViewById(R.id.notification);
    textView.setText(notification);

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    client = new GoogleApiClient.Builder(this).addApi(AppIndex.API).build();
  }

  /**
   * ATTENTION: This was auto-generated to implement the App Indexing API.
   * See https://g.co/AppIndexing/AndroidStudio for more information.
   */
  public Action getIndexApiAction() {
    Thing object = new Thing.Builder()
            .setName("Second Page") // TODO: Define a title for the content shown.
            // TODO: Make sure this auto-generated URL is correct.
            .setUrl(Uri.parse("http://[ENTER-YOUR-URL-HERE]"))
            .build();
    return new Action.Builder(Action.TYPE_VIEW)
            .setObject(object)
            .setActionStatus(Action.STATUS_TYPE_COMPLETED)
            .build();
  }

  @Override
  public void onStart() {
    super.onStart();

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    client.connect();
    AppIndex.AppIndexApi.start(client, getIndexApiAction());
  }

  @Override
  public void onStop() {
    super.onStop();

    // ATTENTION: This was auto-generated to implement the App Indexing API.
    // See https://g.co/AppIndexing/AndroidStudio for more information.
    AppIndex.AppIndexApi.end(client, getIndexApiAction());
    client.disconnect();
  }
}
