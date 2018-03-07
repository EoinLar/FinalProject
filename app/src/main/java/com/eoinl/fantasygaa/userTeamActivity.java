package com.eoinl.fantasygaa;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class userTeamActivity extends AppCompatActivity implements View.OnClickListener{

    //TextView FFselect = (TextView) findViewById(R.id.FFselect);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_team);

        Intent i = getIntent();
        String userEmail = i.getStringExtra("userEmail");

        TextView tvTeamName = (TextView) findViewById(R.id.userTeamName);
        tvTeamName.setText(userEmail);

        Button gkBtn = (Button) findViewById(R.id.btnGK);
        gkBtn.setOnClickListener(this);
        Button lfbBtn = (Button) findViewById(R.id.btnLFB);
        lfbBtn.setOnClickListener(this);
        Button cfbBtn = (Button) findViewById(R.id.btnCFB);
        cfbBtn.setOnClickListener(this);
        Button rfbBtn = (Button) findViewById(R.id.btnRFB);
        rfbBtn.setOnClickListener(this);
        Button lhbBtn = (Button) findViewById(R.id.btnLHB);
        lhbBtn.setOnClickListener(this);
        Button chbBtn = (Button) findViewById(R.id.btnCHB);
        chbBtn.setOnClickListener(this);
        Button rhbBtn = (Button) findViewById(R.id.btnRHB);
        rhbBtn.setOnClickListener(this);
        Button lmBtn = (Button) findViewById(R.id.btnLM);
        lmBtn.setOnClickListener(this);
        Button rmBtn = (Button) findViewById(R.id.btnRM);
        rmBtn.setOnClickListener(this);
        Button lhfBtn = (Button) findViewById(R.id.btnLHF);
        lhfBtn.setOnClickListener(this);
        Button chfBtn = (Button) findViewById(R.id.btnCHF);
        chfBtn.setOnClickListener(this);
        Button rhfBtn = (Button) findViewById(R.id.btnRHF);
        rhfBtn.setOnClickListener(this);
        Button lffBtn = (Button) findViewById(R.id.btnLFF);
        lffBtn.setOnClickListener(this);
        Button cffBtn = (Button) findViewById(R.id.btnCFF);
        cffBtn.setOnClickListener(this);
        Button rffBtn = (Button) findViewById(R.id.btnRFF);
        rffBtn.setOnClickListener(this);
        ImageButton imageBtn1 = (ImageButton) findViewById(R.id.imageBtn1);
        imageBtn1.setOnClickListener(this);
    }

    //implement the onClick method here
    public void onClick(View v) {
        // Perform action on click
        switch(v.getId()) {
            case R.id.btnGK:
                //Open Goalkeeper menu, position 1
                selectPlayer(1);
                break;
            case R.id.btnLFB:
            case R.id.btnCFB:
            case R.id.btnRFB:
                //Open Full Back menu, position 2
                selectPlayer(2);
                break;
            case R.id.btnLHB:
            case R.id.btnCHB:
            case R.id.btnRHB:
                //Open Half Back menu, position 3
                selectPlayer(3);
                break;
            case R.id.btnLM:
            case R.id.btnRM:
                //Open Midfield menu, position 4
                selectPlayer(4);
                break;
            case R.id.btnLHF:
            case R.id.btnCHF:
            case R.id.btnRHF:
                //Open Half Forward menu, position 5
                selectPlayer(5);
                break;
            case R.id.btnLFF:
            case R.id.btnCFF:
            case R.id.btnRFF:
            case R.id.imageBtn1:
                //Open Full Forward menu, position 6
                selectPlayer(6);
                break;
            default:
                break;
        }
    }

    public void selectPlayer(int position) {

        final TextView FFselect = (TextView) findViewById(R.id.FFselect);
        final CharSequence numbers[] = new CharSequence[] {"Number 1", "Number 2", "Number 3", "Number 4"};
        final CharSequence players[] = new CharSequence[] {};
        AlertDialog.Builder builder;

        switch (position) {
            case 1:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Goalkeeper Pick a player");
                builder.setItems(numbers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int GKselection) {
                        // the user clicked on selection
                    }
                });
                builder.show();
                break;
            case 2:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Full Backs Pick a player");
                builder.setItems(numbers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int FBselection) {
                        // the user clicked on selection
                    }
                });
                builder.show();
                break;
            case 3:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Half Backs Pick a player");
                builder.setItems(numbers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int HBselection) {
                        // the user clicked on selection
                    }
                });
                builder.show();
                break;
            case 4:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Midfield Pick a player");
                builder.setItems(numbers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int Mselection) {
                        // the user clicked on selection
                    }
                });
                builder.show();
                break;
            case 5:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Half Forward Pick a player");
                builder.setItems(numbers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int HFselection) {
                        // the user clicked on selection
                    }
                });
                builder.show();
                break;
            case 6:
                builder = new AlertDialog.Builder(this);
                builder.setTitle("Full Forward Pick a player");
                builder.setItems(numbers, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int FFselection) {
                        // the user clicked on colors[which]
                        FFselect.setText(numbers[FFselection]);
                    }
                });
                builder.show();
                break;
        }
    }
}
