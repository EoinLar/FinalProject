package com.eoinl.fantasygaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void checkEmailAddress(View v) {
        EditText et = (EditText) findViewById(R.id.etEmailAddress);
        TextView tv = (TextView) findViewById(R.id.tvValidEmail);
        String email = et.getText().toString();

        //Checks entered email address for validity and displays result in valid email text view
        if(android.util.Patterns.EMAIL_ADDRESS.matcher(et.getText()).matches()){
            tv.setText("Accepted email address.");

            Intent userTeam = new Intent(this, userTeamActivity.class);
            userTeam.putExtra("userEmail", email);
            startActivity(userTeam);

        } else {
            tv.setText("Email is not valid.");
        }
    }
}