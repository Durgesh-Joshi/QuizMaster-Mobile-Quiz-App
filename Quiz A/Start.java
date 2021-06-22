package com.example.demoquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class Start extends AppCompatActivity {
    int i=1,score=0;
    Button reset,next,submit;
    TextView question;
    RadioGroup radioGroup;
    RadioButton option1,option2,option3,option4;
    ProgressBar status;

    @Override
    public void onBackPressed(){

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        question = findViewById(R.id.questions);
        radioGroup = findViewById(R.id.radioGroup);
        option1 = findViewById(R.id.O1);
        option2 = findViewById(R.id.O2);
        option3 = findViewById(R.id.O3);
        option4 = findViewById(R.id.O4);
        reset = findViewById(R.id.reset);
        next = findViewById(R.id.next);
        submit = findViewById(R.id.Submit);
//        status=findViewById(R.id.progressBar);

        String[][] QuestionAnswer = {
                {"Who founded “MATHAS’ in the four corners of India","Madhavacharya", "Shankaracharya", "Bhaskaracharya", "Ramanujacharya", "Shankaracharya"},
                {"Who was the founder of the Gupta Dynasty?","Chandragupta", "Samudragupta", "Kumaragupta", "Maharaja Sri Gupta", "Chandragupta"},
                {"The number of Vedas is","Eight", "Four", "Ten", "Two", "Four"},
                {"In which year did Alexander invade India?","623 BC", "236 BC", "326 BC", "362 BC", "326 BC"},
                {"Which of the following is the oldest monument?","Qutub Minar", "Ajanta Caves", "Taj Mahal", "Khajuraho", "Ajanta Caves"},
                {"Which language did Buddha preach in?","Pali", "Magadhi", "Prakrit", "Sauraseni", "Pali"},
                {"Original name of Lord Buddha was","Vardhamana", "Sidhartha", "Kumara", "Bhodrabahu", "Sidhartha"},
                {"Lord Buddha was born in","Vaishali", "Lumbini", "Kashi", "Patliputra", "Lumbini"},
                {"When was the Battle of Kalinga fought?","540 AD", "273 BC", "262 BC", "712 AD", "262 BC"},
                {"Chandragupta Maurya built the first great empire in India with the help of?","Seleucus", "Mahapadmananda", "Bindusara", "Kautilya", "Kautilya"},
                {"Who, among the following, is credited with the invention of Algebra?","Bhaskra", "Apastamba", "Aryabhatta", "Medhatithi", "Aryabhatta"},
                {"In which language did Kalidas compose his works?","Brahmi", "Pali", "Prakrit", "Sanskrit", "Sanskrit"},
                {"After which war did Ashoka renounce war?","Kalinga", "Avanti", "Magadha", "Malwa", "Kalinga"},
                {"‘Buddha’ means","The Enlightened one", "The Religious Preacher", "The Genius", "The Powerful", "The Enlightened one"},
                {"The tax which the kings used to collect from the people in the Vedic period was called","Kara", "Varman", "Bali", "Vidatha", "Bali"},





        };

        question.setText(QuestionAnswer[0][0]);
        option1.setText(QuestionAnswer[0][1]);
        option2.setText(QuestionAnswer[0][2]);
        option3.setText(QuestionAnswer[0][3]);
        option4.setText(QuestionAnswer[0][4]);
        next.setEnabled(false);


        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(i < 15)
                    next.setEnabled(true);
                else{
                    submit.setEnabled(true);
                }
            }
        });


        reset.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                radioGroup.clearCheck();
                if(i < 15)
                    next.setEnabled(false);
                else
                    submit.setEnabled(false);
            }
        });

        next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){


                int selectId = radioGroup.getCheckedRadioButtonId();

                RadioButton radioButton = (RadioButton) findViewById(selectId);
                if(radioButton.getText() == QuestionAnswer[i - 1][5]){
                    score += 10;
                }

                radioGroup.clearCheck();

                if(i == 14){
                    next.setVisibility(View.INVISIBLE);
                    submit.setVisibility(View.VISIBLE);
                    submit.setEnabled(false);
                }

                question.setText(QuestionAnswer[i][0]);
                option1.setText(QuestionAnswer[i][1]);
                option2.setText(QuestionAnswer[i][2]);
                option3.setText(QuestionAnswer[i][3]);
                option4.setText(QuestionAnswer[i][4]);
                i += 1;

//
                next.setEnabled(false);
            }



        });

        submit.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int selectId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton =  findViewById(selectId);
                if(radioButton.getText() == QuestionAnswer[14][5]){
                    score += 10;
                }



                Intent Submit = new Intent(getApplicationContext(), Submit.class);
                Submit.putExtra("Score", Integer.toString(score));
                Submit.putExtra("Correct", Integer.toString(score/10));
                Submit.putExtra("Incorrect", Integer.toString(15 - score/10));
                startActivity(Submit);
            }
        });

    }
}