package com.example.demoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Submit extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_submit);

        Button quit = findViewById(R.id.quit);
        Button score = findViewById(R.id.score);
        Button restart = findViewById(R.id.restart);

        TextView CorrectNumber = findViewById(R.id.correctscore);
        TextView IncorrectNumber = findViewById(R.id.incorrectscore);
        TextView TotalScore = findViewById(R.id.totalscore);
        TextView CorrectNumber1 = findViewById(R.id.correctanswer);
        TextView IncorrectNumber1 = findViewById(R.id.incorrectanswer);
        TextView TotalScore2 = findViewById(R.id.total);


        Intent Score = getIntent();
        String FinalScore = Score.getStringExtra("Score");
        String TotalCorrect = Score.getStringExtra("Correct");
        String TotalIncorrect = Score.getStringExtra("Incorrect");

        CorrectNumber.setText(TotalCorrect);
        IncorrectNumber.setText(TotalIncorrect);
        TotalScore.setText(FinalScore);

        Intent Name = getIntent();
        String name1 = Score.getStringExtra("Name");



        score.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                CorrectNumber.setVisibility(View.VISIBLE);
                CorrectNumber1.setVisibility(View.VISIBLE);
                IncorrectNumber.setVisibility(View.VISIBLE);
                IncorrectNumber1.setVisibility(View.VISIBLE);
                TotalScore.setVisibility(View.VISIBLE);
                TotalScore2.setVisibility(View.VISIBLE);
            }
        });
        quit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                finishAffinity();
            }
        });

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MainActivity = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(MainActivity);
            }
        });

    }
}