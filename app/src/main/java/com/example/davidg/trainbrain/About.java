package com.example.davidg.trainbrain;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by DavidG on 24/08/2018.
 */

public class About extends Activity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_about );

        Button buttonOK = (Button) findViewById( R.id.buttonOKabt );

        buttonOK.setOnClickListener( this );
    }

    @Override
    public void onClick(View v) {
        finish();
    }
    }
