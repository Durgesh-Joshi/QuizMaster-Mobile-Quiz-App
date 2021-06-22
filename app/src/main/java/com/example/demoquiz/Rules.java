package com.example.demoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Rules extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        TextView Rules=findViewById(R.id.rules);

        Rules.setText("1. Do Not Copy \n\n" +
                "2. Do Not Use Internet \n\n" +
                "3. Do Not Move Forward Without Selecting Any \t\t Option \n\n" +
                "4. You Cannot Visit Previous Question \n\n" +
                "5. Do Not Press Back Button on Quiz Window \n\n" +
                "6. Use Quit Button on Submit Window to Quit App \n\n" +
                "7. There are 15 Questions In Exam \n\n" +
                "8. All Questions Are Compulsory \n\n" +
                "9. Each Question Have 10 Marks \n\n" +
                "10. If Any Problems Occours Contact Our Team"

        );



        Button Back=findViewById(R.id.back);
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(MainActivity);
            }
        });
    }



}