package com.example.davidg.trainbrain;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        View continueButton = findViewById(R.id.cont);
        continueButton.setOnClickListener(this);
        View newButton = findViewById(R.id.newg);
        newButton.setOnClickListener(this);
        View aboutButton = findViewById(R.id.abt);
        aboutButton.setOnClickListener(this);
        View exitButton = findViewById(R.id.exit);
        exitButton.setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.abt:
                Intent i = new Intent(this, About.class);     //opening About box
                startActivity(i);
                break;

            case R.id.exit:
                finish();
                break;

//            case R.id.newg:
//                openNewGameDialog();
//                break;
    }
}


}
