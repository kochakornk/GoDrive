package com.example.suwan.godrivefinalproject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        ListView list1 = (ListView) findViewById(R.id.list1);

        String[] dataList = {
                "Thitipoom Saingthong",
                "Kochakorn keitiwattanapong",
                "Monsieur jarn tae"
        };
        Integer[] imgicon = {
                R.drawable.sky,
                R.drawable.nam,
                R.drawable.tae,

        };
        String[] nearby = {
                "Nearby love",
                "Nearby 800 metre",
                "Nearby 1 km",
        };

        CustomListAdapter adapter = new CustomListAdapter(this, dataList, imgicon, nearby);
        list1.setAdapter(adapter);



//        final Context context = this;
//        list1.
    }
    public void listCancle (View view){
        Intent intent = new Intent (this,WhereActivity.class);
        startActivity(intent);
    }
}
