package com.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {
    private EditText etWord,etMeaning;
    private Button btnAddWord;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);

        etWord = findViewById(R.id.etWord);
        etMeaning = findViewById(R.id.etMeaning);
        btnAddWord = findViewById(R.id.btnAddWord);


        btnAddWord.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save(){
        PrintStream printStream = null;
        try {
            printStream = new PrintStream(openFileOutput("words.txt",MODE_PRIVATE | MODE_APPEND));
            printStream.println(etWord.getText().toString() + " => " + etMeaning.getText().toString());
            Toast.makeText(this,"saved to " +getFilesDir(), Toast.LENGTH_LONG).show();
            printStream.close();
        } catch (FileNotFoundException e) {
            Log.d("Dictionary app" , "Error: "+e.toString());
            e.printStackTrace();
        }

    }
}
