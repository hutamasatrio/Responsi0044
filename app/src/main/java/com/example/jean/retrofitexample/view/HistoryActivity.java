package com.example.jean.retrofitexample.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.jean.retrofitexample.R;
import com.example.jean.retrofitexample.model.HistoryItem;

import java.util.ArrayList;
import java.util.List;

public class HistoryActivity extends AppCompatActivity {
    private List<HistoryItem> historyItem = new ArrayList<>();
    ListView LV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        TextView nama = (TextView) findViewById(R.id.getnama);


        LV = (ListView) findViewById(R.id.LV_item);
        Bundle b = getIntent().getExtras();
        historyItem = b.getParcelableArrayList("item");



       ArrayAdapter itemsAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, historyItem);
       LV.setAdapter(itemsAdapter);

}}
