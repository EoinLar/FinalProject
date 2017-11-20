package com.eoinl.fantasygaa;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class fixturesActivity extends AppCompatActivity {

    TextView text1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fixtures);

        text1 = (TextView) findViewById(R.id.tv1);
        Button button1 = (Button)findViewById(R.id.but1);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new scrape().execute();
            }
        });
    }

    public class scrape extends AsyncTask<Void,Void,Void> {

        String webPage;
        @Override
        protected Void doInBackground(Void... voids) {

            try{
                Document doc = Jsoup.connect("http://www.paddypower.com/bet/gaa-sports/gaa-matches/leinster-championship-hurling-matches").get();

                webPage = doc.text();

            }catch (Exception e){e.printStackTrace();}

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            text1.setText(webPage);
        }
    }
}
