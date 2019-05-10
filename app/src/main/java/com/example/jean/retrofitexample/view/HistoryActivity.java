package com.example.jean.retrofitexample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.jean.retrofitexample.R;

public class HistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView nama = (TextView) findViewById(R.id.getnama);

        Intent intent = getIntent();
        final String getnama = intent.getExtras().getString("nama");


        nama.setText(getnama);
    }
}
