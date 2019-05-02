package com.dictionaryapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import helper.MyHelper;

public class MainActivity extends AppCompatActivity {
    private Button btnOpen,btnList;
    private ListView lstDictionary;
    private Map<String,String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOpen = findViewById(R.id.btnOpen);
        btnList = findViewById(R.id.btnOpenList);



        btnList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        lstDictionary = findViewById(R.id.lstDictionary);
        dictionary = new HashMap<>();
        readFromFile();


        final ArrayAdapter adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,new ArrayList<String>(dictionary.keySet()));
        lstDictionary.setAdapter(adapter);
//        btnOpen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
//                intent.putExtra("myMessage","This is my message");
//                startActivity(intent);
//            }
//        });

        lstDictionary.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String key = parent.getItemAtPosition(position).toString();
                String meaning = dictionary.get(key);


                Intent intent = new Intent(MainActivity.this,AnotherActivity.class);
                intent.putExtra("meaning",meaning);
                startActivity(intent);
            }
        });

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddWordActivity.class);

                startActivity(intent);
            }
        });
    }

    private void readFromFile(){
        try {
            FileInputStream fos = openFileInput("words.txt");
            InputStreamReader isr = new InputStreamReader(fos);
            BufferedReader br = new BufferedReader(isr);
            String line = "";
                while ((line = br.readLine()) != null){
                    String[] parts = line.split(" => ");
                    dictionary.put(parts[0],parts[1]);
                }

        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
