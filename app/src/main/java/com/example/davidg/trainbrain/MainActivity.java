package com.example.davidg.trainbrain;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;


public class MainActivity extends AppCompatActivity implements OnClickListener {

    private static final String TAG = "Train";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        View continueButton = findViewById( R.id.cont );
        continueButton.setOnClickListener( this );
        View newButton = findViewById( R.id.newg );
        newButton.setOnClickListener( this );
        View aboutButton = findViewById( R.id.abt );
        aboutButton.setOnClickListener( this );
        View exitButton = findViewById( R.id.exit );
        exitButton.setOnClickListener( this );


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.abt:
                Intent i = new Intent( this, About.class );     //opening About box
                startActivity( i );
                break;

            case R.id.exit:
                finish();
                break;

            case R.id.newg:
                openNewGameDialog();
                break;
        }
    }


    private void openNewGameDialog() {     //opens a dialog where user needs to choose the level of difficulty.
        new AlertDialog.Builder( this )
                .setTitle( R.string.difflabel )
                .setItems( R.array.difficulty,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface
                                                        dialoginterface, int i) {
                                startGame( i );
                            }
                        } )
                .show();
        // TODO Auto-generated method stub

    }

    private void startGame(int i) {

        Log.d( TAG, "clicked on " + i );
        Intent intent = new Intent( this, Game.class );

        intent.putExtra( Game.diffkey, i );

        startActivity( intent );


    }

}
