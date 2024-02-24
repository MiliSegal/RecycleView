package com.example.myrs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.SearchView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<DataModel> dataSet; //המערך רשומות
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager; //ההגדרות שלו (למעלה למטה\שמאל ימין)
    private CustomeAdapter adapter;
    private SearchView searchView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataSet=new ArrayList<>();
        recyclerView=findViewById(R.id.resview);
        linearLayoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator()); // add data to your array

        searchView = findViewById(R.id.search);


        for (int i=0;i<MyData.drawableArray.length;i++) //רץ על הקובץ ובונה אובייקטים (תמונה ו2 טקסט)
        {
            dataSet.add(new DataModel (
                    MyData.nameArray[i],
                    MyData.versionArray[i],
                    MyData.drawableArray[i],
                    MyData.sumArray[i]
            ));
        }

        adapter=new CustomeAdapter (dataSet);
        recyclerView.setAdapter(adapter);

    // Get the SearchView from the layout
    searchView = findViewById(R.id.search);

    // Set up search functionality
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
        @Override
        public boolean onQueryTextSubmit(String query) {
            // Handle search submission (if needed)
            return false;
        }

        @Override
        public boolean onQueryTextChange(String newText) {
            // Handle text changes in the search view
            filter(newText); // Implement your filtering logic
            return true;
        }
    });
}
    private void filter(String query) {
        adapter.getFilter().filter(query);
    }
}