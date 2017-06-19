package com.example.suwan.godrivefinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);
    }

    public void confirmConfirm(View view) {
        Intent intent = new Intent(ConfirmActivity.this, WhereActivity.class);
        startActivity(intent);
    }

    public void cancleConfirm(View view) {
        Intent intent2 = new Intent(ConfirmActivity.this, WhereActivity.class);
        startActivity(intent2);
    }
}
