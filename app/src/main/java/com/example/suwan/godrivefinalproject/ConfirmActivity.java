package com.example.suwan.godrivefinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        ImageView Img = (ImageView) findViewById(R.id.driveImg);
        TextView Name = (TextView) findViewById(R.id.nameDriver);
        TextView Phone = (TextView) findViewById(R.id.phoneDriver);

        //Intent intent = getIntent();
        //Name.setText(intent.getStringExtra("Name"));
        //Phone.setText(intent.getStringExtra("number"));
        //Img.setImageResource(intent.getIntExtra("Img",0));
    }

    public void confirmConfirm(View view) {
        Intent intent = new Intent(ConfirmActivity.this, WhereActivity.class);
        startActivity(intent);
        Toast.makeText(ConfirmActivity.this,"Thank You!", Toast.LENGTH_SHORT).show();
    }

    public void cancleConfirm(View view) {
        Intent intent2 = new Intent(ConfirmActivity.this, WhereActivity.class);
        startActivity(intent2);
    }
}
