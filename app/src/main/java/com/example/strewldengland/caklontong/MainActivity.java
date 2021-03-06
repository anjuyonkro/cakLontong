package com.example.strewldengland.caklontong;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button mSubmit, mHelp;
    private TextView mSoal, mClue, mJawab;

    private String mAnswer;
    private int operation = 0;
    private Question[] mQuestionLibrary = new Question[]{
            new Question(R.string.soal, "diphk")
    };
    private Clues[] mCluesCorrect = new Clues[]{
            new Clues(R.string.clues)
    };

    private int mQuestionNumber = 0;
    private int mCluesNumber = 0;

    private void checkAnswer(String answerTrue){
        String answerIsTrue = mQuestionLibrary[mQuestionNumber].isCorrectAnswer();
        if (answerTrue.equalsIgnoreCase(answerIsTrue)){
                int clue = mCluesCorrect[mCluesNumber].getClues();
                mClue.setText(clue);
        }else {
            Toast.makeText(MainActivity.this, "SALAH", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSoal = (TextView)findViewById(R.id.soal);
        mClue = (TextView)findViewById(R.id.hasil);
        mSubmit = (Button)findViewById(R.id.submit);
        mHelp = (Button)findViewById(R.id.help);
        mJawab = (EditText)findViewById(R.id.jawab);

        int question = mQuestionLibrary[mQuestionNumber].getQuestion();
        mSoal.setText(question);

        mSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                mAnswer = mJawab.getText().toString();
                checkAnswer(mAnswer);
            }
        });
    }

    public void clear(View V){
        mJawab.setText("");
        operation = 0;
    }
}
