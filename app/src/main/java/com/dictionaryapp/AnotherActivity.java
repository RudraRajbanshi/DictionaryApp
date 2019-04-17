package com.dictionaryapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class AnotherActivity extends AppCompatActivity {
    private TextView tvOutput;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_another);

        tvOutput = findViewById(R.id.tvOutput);
        Bundle bundle = getIntent().getExtras();
//        if(bundle != null){
//            String msg = bundle.getString("myMessage");
//            tvOutput.setText(msg);
//        }else{
//            Toast.makeText(this,"No message",Toast.LENGTH_LONG).show();
//        }

        if(bundle!=null){
            String meaning = bundle.getString("meaning");
            tvOutput.setText(meaning);
        }else{
            Toast.makeText(this,"No message",Toast.LENGTH_LONG).show();
        }

    }
}
