package com.example.suwan.godrivefinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class ConfirmActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        ImageView Img = (ImageView) findViewById(R.id.imgConfirm);
        TextView Name = (TextView) findViewById(R.id.driverConfirm);
        TextView Phone = (TextView) findViewById(R.id.phoneConfirm);
        TextView placeEdit = (TextView) findViewById(R.id.desConfirm);
        TextView dateEdit = (TextView) findViewById(R.id.dateConfirm);
        TextView timeEdit = (TextView) findViewById(R.id.timeConfirm);
        TextView useremail1 = (TextView) findViewById(R.id.useremail);

//        FirebaseAth.getInstance().getCurrentUser.getEmail();
//        FirebaseAth.getInstance().getCurrentUser.getEmail();

        String useremail = FirebaseAuth.getInstance().getCurrentUser().getEmail();
        useremail1.setText(useremail);


        Intent intent = getIntent();
        Name.setText(intent.getStringExtra("Name"));
        Phone.setText(intent.getStringExtra("number"));
        Img.setImageResource(intent.getIntExtra("Img",0));
        placeEdit.setText("Destination: "+intent.getStringExtra("placeEdit"));
        dateEdit.setText("Date: " +intent.getStringExtra("dateEdit"));
        timeEdit.setText("Time: " +intent.getStringExtra("timeEdit"));


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
