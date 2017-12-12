package com.eoinl.fantasygaa;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class fixturesActivity extends AppCompatActivity {

    String url = "https://www.rte.ie/sport/results/gaa/2018/6120/fixtures/";
    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        Button getFixturesBtn = (Button) findViewById(R.id.getFixturesBtn);

        // Capture button click
        getFixturesBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0) {
                // Execute Title AsyncTask
                new fixtures().execute();
            }
        });
    }

    // Title AsyncTask
    private class fixtures extends AsyncTask<Void, Void, Void> {
        String title, date;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            mProgressDialog = new ProgressDialog(fixturesActivity.this);
            mProgressDialog.setTitle("Android Basic JSoup Tutorial");
            mProgressDialog.setMessage("Loading...");
            mProgressDialog.setIndeterminate(false);
            mProgressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... params) {
            try {
                // Connect to the web site
                Document doc = Jsoup.connect(url).get();
                // Get the html document title
                title = doc.title();
                Elements dates = doc.getAllElements();
                date = dates.html();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            // Set title into TextView
            TextView fixturesTextView = (TextView) findViewById(R.id.tv);
            //fixturesTextView.setText(title);
            fixturesTextView.setText(date);
            mProgressDialog.dismiss();
        }
    }
}
