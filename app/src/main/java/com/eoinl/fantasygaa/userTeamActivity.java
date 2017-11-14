package com.eoinl.fantasygaa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class userTeamActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_team);

        Intent i = getIntent();
        String userEmail = i.getStringExtra("userEmail");

        TextView tvTeamName = (TextView) findViewById(R.id.userTeamName);
        tvTeamName.setText(userEmail);
    }

    public void selectPlayer(View v) {

    }
}
