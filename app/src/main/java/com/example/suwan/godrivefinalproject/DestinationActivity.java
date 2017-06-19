package com.example.suwan.godrivefinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import static com.example.suwan.godrivefinalproject.R.id.placeEdit;

public class DestinationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_destination);

    }

    public void desRequest(View view) {
        TextView place = (TextView) findViewById(placeEdit);
        TextView date = (TextView) findViewById(R.id.dateEdit);
        TextView time = (TextView) findViewById(R.id.timeEdit);

        String placeText = place.getText().toString();
        String dateText = date.getText().toString();
        String timeText = time.getText().toString();

        if( !placeText.matches("")
                && !dateText.matches("")
                && !timeText.matches(""))
        {
            Intent intent3 = new Intent(DestinationActivity.this, ListActivity.class);
            intent3.putExtra("placeEdit",placeText);
            intent3.putExtra("dateEdit",dateText);
            intent3.putExtra("timeEdit",timeText);
            startActivity(intent3);

        }

    }

    public void desCancle(View view) {
        Intent intent2 = new Intent(DestinationActivity.this, WhereActivity.class);
        startActivity(intent2);
    }
}
