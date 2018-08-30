package com.example.davidg.trainbrain;


import java.util.Random;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity implements OnClickListener {

    private Random random;

    public static final String diffkey = "com.example.trainyourbrain.difficulty";

    public static final int novdiff = 0;

    public static final int easydiff = 1;

    public static final int meddiff = 2;

    public static final int gurudiff = 3;

    int level;

    private int answer = 0;

    private int operator = 0;

    private int operand1 = 0;

    private int operand2 = 0;

    private final int ADD_OPERATOR = 0, SUBTRACT_OPERATOR = 1,
            MULTIPLY_OPERATOR = 2, DIVIDE_OPERATOR = 3;

    private String[] operators = {"+", "-", "x", "/"};

    private TextView question, answerTxt, scoreTxt;

    private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn0;

    private Button btnEnter, btndlt;

    private int[][] levelMin = {{1, 11, 21}, {1, 5, 10}, {2, 5, 10},
            {2, 3, 5}};
    private int[][] levelMax = {{10, 25, 50}, {10, 20, 30}, {5, 10, 15},
            {10, 50, 100}};


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.gamescreen );
        question = (TextView) findViewById( R.id.question );
        answerTxt = (TextView) findViewById( R.id.answerTxt );

        scoreTxt = (TextView) findViewById( R.id.scoreTxt );



        btn1 = (Button) findViewById( R.id.one );
        btn2 = (Button) findViewById( R.id.two );
        btn3 = (Button) findViewById( R.id.three );
        btn4 = (Button) findViewById( R.id.four );
        btn5 = (Button) findViewById( R.id.five );
        btn6 = (Button) findViewById( R.id.six );
        btn7 = (Button) findViewById( R.id.seven );
        btn8 = (Button) findViewById( R.id.eight );
        btn9 = (Button) findViewById( R.id.nine );
        btn0 = (Button) findViewById( R.id.zero );
        btnEnter = (Button) findViewById( R.id.enter );
        btndlt = (Button) findViewById( R.id.dlt );

        btn1.setOnClickListener( this );
        btn2.setOnClickListener( this );
        btn3.setOnClickListener( this );
        btn4.setOnClickListener( this );
        btn5.setOnClickListener( this );
        btn6.setOnClickListener( this );
        btn7.setOnClickListener( this );
        btn8.setOnClickListener( this );
        btn9.setOnClickListener( this );
        btn0.setOnClickListener( this );
        btndlt.setOnClickListener( this );
        btnEnter.setOnClickListener( this );

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            int passedLevel = extras.getInt( "level", -1 );
            if (passedLevel >= 0)
                level = passedLevel;
        }

        random = new Random();
        // play
        chooseQuestion();


    }

    private void chooseQuestion() {

        answerTxt.setText( "=?" );

        operator = random.nextInt( operators.length );

        operand1 = getOperand();
        operand2 = getOperand();

        // checks for operators
        if (operator == SUBTRACT_OPERATOR) {
            // no negative answers
            while (operand2 > operand1) {
                operand1 = getOperand();
                operand2 = getOperand();
            }
        } else if (operator == DIVIDE_OPERATOR) {
            // whole numbers only
            while ((((double) operand1 / (double) operand2) % 1 > 0)
                    || (operand1 == operand2)) {
                operand1 = getOperand();
                operand2 = getOperand();
            }
        }

        // calculate answer
        switch (operator) {
            case ADD_OPERATOR:
                answer = operand1 + operand2;
                break;
            case SUBTRACT_OPERATOR:
                answer = operand1 - operand2;
                break;
            case MULTIPLY_OPERATOR:
                answer = operand1 * operand2;
                break;
            case DIVIDE_OPERATOR:
                answer = operand1 / operand2;
                break;
            default:
                break;
        }

        // show question
        question.setText( operand1 + " " + operators[operator] + " " + operand2 );

    }

    private int getOperand() {

        return random.nextInt( levelMax[operator][level]
                - levelMin[operator][level] + 1 )
                + levelMin[operator][level];
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {

            case R.id.enter:
                String answerContent = answerTxt.getText().toString();
                // check we have an answer
                if (!answerContent.endsWith( "?" )) {
                    // get number
                    int enteredAnswer = Integer.parseInt( answerContent );
                    // get score
                    int exScore = getScore();
                    // check answer
                    if (enteredAnswer == answer) {
                        // correct
                        scoreTxt.setText (exScore + 1);
                    } else {
                        // incorrect
                        scoreTxt.setText(exScore);
                    }
                }

                chooseQuestion();  //change to different question.

                break;


            case R.id.dlt:
                answerTxt.setText( "=?" );
                break;

            case R.id.one:
                if (answerTxt.getText().toString().endsWith( "?" )) // check if the answer box has question mark or not
                    answerTxt.setText( "= " + "1" );   // replacing the question mark
                else
                    answerTxt.append( "" + "1" );      //add the number to existing number if no question mark.

                break;

            case R.id.two:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "2" );
                else
                    answerTxt.append( "" + "2" );
                break;

            case R.id.three:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "3" );
                else
                    answerTxt.append( "" + "3" );
                break;

            case R.id.four:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "4" );
                else
                    answerTxt.append( "" + "4" );
                break;

            case R.id.five:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "5" );
                else
                    answerTxt.append( "" + "5" );
                break;

            case R.id.six:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "6" );
                else
                    answerTxt.append( "" + "6" );
                break;
            case R.id.seven:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "7" );
                else
                    answerTxt.append( "" + "7" );
                break;
            case R.id.eight:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "8" );
                else
                    answerTxt.append( "" + "8" );
                break;
            case R.id.nine:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "9" );
                else
                    answerTxt.append( "" + "9" );
                break;
            case R.id.zero:
                if (answerTxt.getText().toString().endsWith( "?" ))
                    answerTxt.setText( "= " + "0" );
                else
                    answerTxt.append( "" + "0" );
                break;
        }
    }

    private int getScore() {
        // TODO Auto-generated method stub
        String scoreStr = scoreTxt.getText().toString();
        int scoreInt = Integer.parseInt( scoreStr );
        return scoreInt;
    }
}
