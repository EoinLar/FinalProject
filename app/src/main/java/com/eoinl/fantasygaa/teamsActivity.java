package com.eoinl.fantasygaa;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

public class teamsActivity extends AppCompatActivity {

    ListView teamList;
    //TextView teamList;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teams);

        teamList = (ListView) findViewById(R.id.teamView);

        dialog = ProgressDialog.show(this, "", "Please wait...", true);
        new Connection().execute("");

    }

    public void showListView(String varSocket) {

        Spinner dropdown = (Spinner) findViewById(R.id.spinner1);

        String teams[] = varSocket.split("#");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,teams);
        teamList.setAdapter(adapter);
        //dropdown.setAdapter(adapter);

/*
        String team[] = varSocket.split("#");
        TextView TVteams = (TextView) findViewById(R.id.teamList);
        //TVteams.setMovementMethod(new ScrollingMovementMethod());
        TVteams.append("\n" + varSocket);
*/
    }

    // Connect to server using aSync task.
    private class Connection extends AsyncTask<String, Void, String> {

        @Override
        protected String doInBackground(String... params) {
            client clientSocket = new client();
            String data = clientSocket.seeData();
            return data;
        }

        @Override
        protected void onPostExecute(String s) {

            // Will display returned data in a text view
            showListView(s);
            dialog.dismiss();
        }
    }
}
