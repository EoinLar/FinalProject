package com.eoinl.fantasygaa;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Dialog box when establishing a connection
        dialog = ProgressDialog.show(this, "", "Connecting", true);
        new Connection().execute("");
    }

    // Checks entered email to see if its in correct format ( x@y.z )
    public void checkEmailAddress(View v) {
        EditText et = (EditText) findViewById(R.id.etEmailAddress);
        TextView tv = (TextView) findViewById(R.id.tvValidEmail);
        String email = et.getText().toString();

        // Checks entered email address for validity and displays result in valid email text view
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(et.getText()).matches()){
            tv.setText("Accepted email address.");

            Intent userTeam = new Intent(this, userTeamActivity.class);
            userTeam.putExtra("userEmail", email);
            startActivity(userTeam);

        } else {
            tv.setText("Email is not valid, try again:");
        }
    }

    // Opens fixture activity page to display fixtures
    public void viewFixtures(View v) {
        Intent fixtures = new Intent(this, fixturesActivity.class);
        startActivity(fixtures);
    }

    // Connect to server using aSync task.
    private class Connection extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            client clientSocket = new client();
            String data = clientSocket.seeData();
            return data;
            // Currently not returning anything
        }

        @Override
        protected void onPostExecute(String s) {

            // Will display returned data in a text view
            dialog.dismiss();
        }
    }
}