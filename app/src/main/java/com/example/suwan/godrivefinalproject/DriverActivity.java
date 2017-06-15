package com.example.suwan.godrivefinalproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DriverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        TextView Name = (TextView) findViewById(R.id.nameDriver) ;
        TextView Phone = (TextView) findViewById(R.id.phoneDriver);
        ImageView Img = (ImageView) findViewById(R.id.driveImg);

        Intent intent = getIntent();
        Name.setText(intent.getStringExtra("Name"));
        Phone.setText(intent.getStringExtra("number"));
        Img.setImageResource(intent.getIntExtra("Img",0));
    }
}
