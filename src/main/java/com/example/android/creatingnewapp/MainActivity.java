package com.example.android.creatingnewapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //Declare UI objects
    private TextView xmlIcon;
    private TextView javaIcon;
    private TextView scoreXMLText;
    private TextView scoreJavaText;

    //Declare and initialize global variables for scores
    int scoreXML = 0;
    int scoreJava = 0;

    //String constants for scores
    static final String STATE_XML = "scoreXML";
    static final String STATE_JAVA = "scoreJava";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialize objects
        xmlIcon = (TextView) findViewById(R.id.xmlIcon);
        javaIcon = (TextView) findViewById(R.id.javaIcon);
        scoreXMLText = (TextView) findViewById(R.id.xml_score);
        scoreJavaText = (TextView) findViewById(R.id.java_score);
    }

    /**
     * Display the given score and icon for XML
     */
    private void displayScoreForXML(int score) {
        scoreXMLText.setText(String.valueOf(score));
        changeIconXML(xmlIcon);
    }

    /**
     * Display the given score and icon for Java
     */
    private void displayScoreForJava(int score) {
        scoreJavaText.setText(String.valueOf(score));
        changeIconJava(javaIcon);
    }

    /**
     * Add 1 point to XML score for using learned concept
     */
    public void addOneForXML(View view) {
        scoreXML = scoreXML + 1;
        displayScoreForXML(scoreXML);
    }

    /**
     * Add 2 points to XML score for trying new concept
     */
    public void addTwoForXML(View view) {
        scoreXML = scoreXML + 2;
        displayScoreForXML(scoreXML);
    }

    /**
     * Add 1 point to Java score for using learned concept
     */
    public void addOneForJava(View view) {
        scoreJava = scoreJava + 1;
        displayScoreForJava(scoreJava);
    }

    /**
     * Add 2 points to Java score for trying new concept
     */
    public void addTwoForJava(View view) {
        scoreJava = scoreJava + 2;
        displayScoreForJava(scoreJava);
    }

    /**
     * Reset the scores for XML and Java to 0, when "Apply them!" button is pressed :D
     */
    public void applyThem(View view) {
        if(scoreXML > scoreJava) {
            Toast.makeText(this, R.string.xml_wins_message, Toast.LENGTH_SHORT).show();
        } else if (scoreXML < scoreJava) {
            Toast.makeText(this, R.string.java_wins_message, Toast.LENGTH_SHORT).show();
        } else if ((scoreXML == scoreJava) && (scoreJava != 0)) {
            Toast.makeText(this, R.string.tie_message, Toast.LENGTH_SHORT).show();
        }
        scoreXML = 0;
        scoreJava = 0;
        displayScoreForXML(scoreXML);
        displayScoreForJava(scoreJava);
        xmlIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cry_green, 0, 0);
        javaIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.cry_red, 0, 0);
    }

    /**
     * Change XML's emoticon according to its score
     */
    public void changeIconXML(View view) {
        if ((scoreXML >= 5)&&(scoreXML < 10)) {
            xmlIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.smiley_green, 0, 0);
        } else if (scoreXML >= 10) {
            xmlIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.happy_green, 0, 0);
        }
    }

    /**
     * Change Java's emoticon according to its score
     */
    public void changeIconJava(View view) {
        if ((scoreJava >= 5)&&(scoreJava < 10)) {
            javaIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.smiley_red, 0, 0);
        } else if (scoreJava >= 10) {
            javaIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.happy_red, 0, 0);
        }
    }

    /**
     * Reset scores for giving another try
     */
    public void resetScore(View view) {
        xmlIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sad_green, 0, 0);
        javaIcon.setCompoundDrawablesWithIntrinsicBounds(0, R.drawable.sad_red, 0, 0);
        scoreXML = 0;
        scoreJava = 0;
        displayScoreForXML(scoreXML);
        displayScoreForJava(scoreJava);
    }


    //Prevent the application from restarting when orientation is changed so that the scores don't reset.
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the current scores state
        savedInstanceState.putInt(STATE_XML, scoreXML);
        savedInstanceState.putInt(STATE_JAVA, scoreJava);

        // Call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    public void onRestoreInstanceState(Bundle savedInstanceState) {
        // Call the superclass so it can restore the view hierarchy
        super.onRestoreInstanceState(savedInstanceState);

        // Restore state members from saved instance
        scoreXML = savedInstanceState.getInt(STATE_XML);
        scoreJava = savedInstanceState.getInt(STATE_JAVA);
        displayScoreForXML(scoreXML);
        displayScoreForJava(scoreJava);
    }

}
