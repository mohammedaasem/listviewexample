package com.aasem.listviewexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity {

    ListView lvNames;
    String[] nameList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvNames=findViewById(R.id.lv_names);
        nameList=getResources().getStringArray(R.array.names);
        final ArrayList<String> arrayList=new ArrayList<>();
        arrayList.add("C");
        arrayList.add("C++");
        arrayList.add("Angular");
        arrayList.add("JS");
        arrayList.add("B");
        arrayList.add("Python");
        final ArrayAdapter adapter = new ArrayAdapter<String>(this, R.layout.custom_layout, arrayList);
        lvNames.setAdapter(adapter);
        lvNames.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String value= (String) adapter.getItem(i);
                if (value.equals("C")){
                    Collections.sort(arrayList);
                    lvNames.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                if (value.equals("C++")){
                    Collections.reverse(arrayList);
                    lvNames.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                }
                Toast.makeText(MainActivity.this, value, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
