package com.example.suwan.godrivefinalproject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);
    }

    public void desRequest(View view) {
        Intent intent = new Intent(this,ListActivity.class);
        startActivity(intent);
    }

    public void desCancle(View view) {
        Intent intent = new Intent(this,WhereActivity.class);
        startActivity(intent);
    }
}
