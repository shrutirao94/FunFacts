package com.example.shruti.funfacts;

import android.app.Activity;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;


public class FunFactsActivity extends Activity {

    public static final String TAG = "FunFactsActivity";

    private FactBook mFactBook = new FactBook();
    private ColorWheel mColorWheel = new ColorWheel();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun_facts);

        //Declare our view variables and assign the views from the layout file.
        final TextView factlabel = (TextView) findViewById(R.id.factTextView);
        final Button showFactButton = (Button) findViewById(R.id.showFactButton);

        final RelativeLayout relativelayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String fact = mFactBook.getFact();
                //update the table with our dynamic table
                factlabel.setText(fact);

                int color = mColorWheel.getColor();
                relativelayout.setBackgroundColor(color);
                showFactButton.setTextColor(color);
            }

        };
        showFactButton.setOnClickListener(listener);

     //Toast.makeText(this, "The activity works fine", Toast.LENGTH_LONG).show();
        Log.d("FunFactsActivity", "We are logging from the onCreate() method");


    }
}
