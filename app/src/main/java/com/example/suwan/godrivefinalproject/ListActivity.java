package com.example.suwan.godrivefinalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private Intent intent;
    private String[] dataList = {
            "Thitipoom Saingthong",
            "Kochakorn keitiwattanapong",
            "Monsieur jarn tae",
            "Tachakarn Loududomkul"
    };

    private Integer[] imgicon = {
            R.drawable.sky,
            R.drawable.nam,
            R.drawable.tae,
            R.drawable.gon

    };

    private String[] nearby = {
            "Nearby love",
            "Nearby 800 metre",
            "Nearby 1 km",
            "Nearby 2 km"

    };

    private String[] phone = {
            "0819999999",
            "0999999999",
            "0888888888",
            "0819998289"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list1 = (ListView) findViewById(R.id.list1);

        CustomListAdapter adapter = new CustomListAdapter(this, dataList, imgicon, nearby);
        list1.setAdapter(adapter);

        intent = getIntent();


        final Context context = this;
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent2 = new Intent(ListActivity.this , DriverActivity.class);
                intent2.putExtra("Name",dataList[position]);
                intent2.putExtra("Img", imgicon[position]);
                intent2.putExtra("number", phone[position]);
                intent2.putExtra("placeEdit",intent.getStringExtra("placeEdit"));
                intent2.putExtra("dateEdit",intent.getStringExtra("dateEdit"));
                intent2.putExtra("timeEdit",intent.getStringExtra("timeEdit"));
                startActivity(intent2);
            }
        });

//        final Context context = this;
//        list1.
    }
    public void listCancle (View view){
        Intent intent = new Intent (this,WhereActivity.class);
        startActivity(intent);
    }

}
