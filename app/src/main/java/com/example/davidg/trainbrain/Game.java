package com.example.davidg.trainbrain;


import java.util.Random;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Game extends AppCompatActivity {

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

    private String[] operators = { "+", "-", "x", "/" };


}
