package com.example.marcel.eRegister;

import android.annotation.SuppressLint;
import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class SchoolSelectionActivity extends ListActivity {

    @SuppressLint("ByteOrderMark")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_school_selection);

        String[] schools = {"Deak Ferenc High School", "Fucking Bullshit High School", "Kill Me High School", "Daddy High School"};
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, schools);
        ListView listView = (ListView)findViewById(R.id.ListView);
        listView.setAdapter(adapter);

    }
}
