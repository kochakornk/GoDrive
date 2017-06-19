package com.example.suwan.godrivefinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class DriverActivity extends AppCompatActivity {
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_driver);

        TextView Name = (TextView) findViewById(R.id.nameDriver) ;
        TextView Phone = (TextView) findViewById(R.id.phoneDriver);
        ImageView Img = (ImageView) findViewById(R.id.driveImg);

        intent = getIntent();
        Name.setText(intent.getStringExtra("Name"));
        Phone.setText(intent.getStringExtra("number"));
        Img.setImageResource(intent.getIntExtra("Img",0));

    }

    public void requestDriver(View view) {
        Intent intent2 = new Intent(DriverActivity.this, ConfirmActivity.class);
        intent2.putExtra("Name",intent.getStringExtra("Name"));
        intent2.putExtra("number", intent.getStringExtra("number"));
        intent2.putExtra("Img", intent.getIntExtra("Img",0));
        intent2.putExtra("placeEdit",intent.getStringExtra("placeEdit"));
        intent2.putExtra("dateEdit",intent.getStringExtra("dateEdit"));
        intent2.putExtra("timeEdit",intent.getStringExtra("timeEdit"));
        startActivity(intent2);
    }

    public void backDriver(View view) {
        Intent intent3 = new Intent(DriverActivity.this, ListActivity.class);
        startActivity(intent3);
    }

    public void cancleDriver(View view) {
        Intent intent2 = new Intent(DriverActivity.this, WhereActivity.class);
        startActivity(intent2);
    }
}
