package com.example.myrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataSet; //המערך רשומות
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; //ההגדרות שלו (למעלה למטה\שמאל ימין)
    private CustomeAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet=new ArrayList<>();
        recyclerView=findViewById(R.id.resview);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator()); // add data to your array

        for (int i=0;i<MyData.drawableArray.length;i++) //רץ על הקובץ ובונה אובייקטים (תמונה ו2 טקסט)
        {
            dataSet.add(new DataModel (
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.drawableArray[i]
            ));
        }

        adapter=new CustomeAdapter (dataSet);
        recyclerView.setAdapter(adapter);
    }
}