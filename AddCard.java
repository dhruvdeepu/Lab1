package com.example.du.flashyappy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class AddCard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_card);

        ((EditText)findViewById(R.id.questionBox)).setText(getIntent().getStringExtra("question"));
        ((EditText)findViewById(R.id.answerBox)).setText(getIntent().getStringExtra("answer"));

        findViewById(R.id.xSign).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AddCard.this, MainActivity.class);
                AddCard.this.startActivity(intent);
            }
        });

        findViewById(R.id.saveSign).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                String question = ((EditText)findViewById(R.id.questionBox)).getText().toString();
                String answer = ((EditText)findViewById(R.id.answerBox)).getText().toString();
                if(question.equals("") || answer.equals(""))
                {
                    Toast t = Toast.makeText(getApplicationContext(), "You must enter and question and an answer!", Toast.LENGTH_SHORT);
                    t.setGravity(Gravity.CENTER_VERTICAL,0,0);
                    t.show();
                }
                else
                {
                    Intent data = new Intent();
                    data.putExtra("string1", question);
                    data.putExtra("string2", answer);
                    setResult(RESULT_OK, data);
                    finish();

                }
            }
        });
    }
}
