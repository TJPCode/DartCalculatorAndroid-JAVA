package com.example.tj2.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TabHost;

public class TopScores extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.toplist);

        TabHost tabHost = (TabHost) findViewById(R.id.tabHost);
        tabHost.setup();

        TabHost.TabSpec tabSpec = tabHost.newTabSpec("Darts");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Tabi1");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Tabi2");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Tabi2");
        tabHost.addTab(tabSpec);

        tabSpec = tabHost.newTabSpec("Tabi3");
        tabSpec.setContent(R.id.tab1);
        tabSpec.setIndicator("Tabi3");
        tabHost.addTab(tabSpec);
    }
}
