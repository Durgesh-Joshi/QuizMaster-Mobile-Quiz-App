package com.example.demoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button rules = findViewById(R.id.Button_Rules);
        Button start= findViewById(R.id.Button_Start);

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent Rules = new Intent(getApplicationContext(), Rules.class);
                startActivity(Rules);



            }
        });

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent start  = new Intent(getApplicationContext(),Start.class);

                startActivity(start);
            }
        });

    }


}