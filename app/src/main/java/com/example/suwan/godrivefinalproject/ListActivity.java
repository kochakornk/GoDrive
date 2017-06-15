package com.example.suwan.godrivefinalproject;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {
    private String[] dataList = {
            "Thitipoom Saingthong",
            "Kochakorn keitiwattanapong",
            "Monsieur jarn tae"
    };

    private Integer[] imgicon = {
            R.drawable.sky,
            R.drawable.nam,
            R.drawable.tae,

    };
    private String[] nearby = {
            "Nearby love",
            "Nearby 800 metre",
            "Nearby 1 km",

    };
    private String[] phone = {
            "0819999999",
            "0999999999",
            "0888888888",
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list1 = (ListView) findViewById(R.id.list1);

        CustomListAdapter adapter = new CustomListAdapter(this, dataList, imgicon, nearby);
        list1.setAdapter(adapter);

        final Context context = this;
        list1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ListActivity.this , DriverActivity.class);
                intent.putExtra("Name",dataList[position]);
                intent.putExtra("Img", imgicon[position]);
                intent.putExtra("number", phone[position]);
                startActivity(intent);
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
