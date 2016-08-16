package com.example.tj2.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collections;

public class Calculator extends AppCompatActivity {

    //region LAYOUT COMPONENTS AND VARIABLES
    EditText dart1Field, dart2Field, dart3Field, dart4Field, dart5Field;
    TextView round1, round2, round3, round4, round5, round6, round7, round8, round9, round10;
    TextView round11, round12, round13, round14, round15, round16, round17, round18, round19, round20;
    TextView round21, round22, round23, round24, round25;
    LinearLayout roundRow1, roundRow2, roundRow3, roundRow4, roundRow5, roundRow6, roundRow7, roundRow8, roundRow9, roundRow10;
    LinearLayout roundRow11, roundRow12, roundRow13, roundRow14, roundRow15, roundRow16, roundRow17, roundRow18, roundRow19, roundRow20;
    LinearLayout roundRow21, roundRow22, roundRow23, roundRow24, roundRow25;
    TextView roundSum1, roundSum2, roundSum3, roundSum4, roundSum5, roundSum6, roundSum7, roundSum8, roundSum9, roundSum10;
    TextView roundSum11, roundSum12, roundSum13, roundSum14, roundSum15, roundSum16, roundSum17, roundSum18, roundSum19, roundSum20;
    TextView roundSum21, roundSum22, roundSum23, roundSum24, roundSum25, roundTxt;
    Button readyBtn, resetBtn;
    int dartValue1, dartValue2, dartValue3, dartValue4, dartValue5, roundPoints, finalPoints;
    int throwRound = 1;
    boolean checkField1, checkField2, checkField3, checkField4, checkField5, isEnd;
    private ArrayList<Integer> totalPoints = new ArrayList<>();
    private ArrayList<Integer> helperArray = new ArrayList<>();
    AlertDialog.Builder dlgAlert;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //region CREATE VIEW
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.reddarts);
        dlgAlert  = new AlertDialog.Builder(this);
        //endregion

        //region VIEW SELECTION
        Intent startActivity = getIntent();
        final int screen = startActivity.getExtras().getInt("selectScreen");

        if (screen == 1){
            setContentView(R.layout.darts25);
            setTitle(R.string.darts_25_title);
        }
        else if (screen == 2){
            setContentView(R.layout.darts50);
            setTitle(R.string.darts_50_title);
        }
        else if (screen == 3){
            setContentView(R.layout.darts125);
            setTitle(R.string.darts_125_title);
        }
        else if (screen == 4){
            setContentView(R.layout.darts125);
            setTitle(R.string.darts_250_title);
        }
        //endregion

        //region DEFINITIONS
        roundTxt = (TextView) findViewById(R.id.kierrosText);
        dart1Field = (EditText) findViewById(R.id.heitto1);
        dart2Field = (EditText) findViewById(R.id.heitto2);
        dart3Field = (EditText) findViewById(R.id.heitto3);
        dart4Field = (EditText) findViewById(R.id.heitto4);
        dart5Field = (EditText) findViewById(R.id.heitto5);
        round1 = (TextView) findViewById(R.id.kierros1);
        round2 = (TextView) findViewById(R.id.kierros2);
        round3 = (TextView) findViewById(R.id.kierros3);
        round4 = (TextView) findViewById(R.id.kierros4);
        round5 = (TextView) findViewById(R.id.kierros5);
        round6 = (TextView) findViewById(R.id.kierros6);
        round7 = (TextView) findViewById(R.id.kierros7);
        round8 = (TextView) findViewById(R.id.kierros8);
        round9 = (TextView) findViewById(R.id.kierros9);
        round10 = (TextView) findViewById(R.id.kierros10);
        round11 = (TextView) findViewById(R.id.kierros11);
        round12 = (TextView) findViewById(R.id.kierros12);
        round13 = (TextView) findViewById(R.id.kierros13);
        round14 = (TextView) findViewById(R.id.kierros14);
        round15 = (TextView) findViewById(R.id.kierros15);
        round16 = (TextView) findViewById(R.id.kierros16);
        round17 = (TextView) findViewById(R.id.kierros17);
        round18 = (TextView) findViewById(R.id.kierros18);
        round19 = (TextView) findViewById(R.id.kierros19);
        round20 = (TextView) findViewById(R.id.kierros20);
        round21 = (TextView) findViewById(R.id.kierros21);
        round22 = (TextView) findViewById(R.id.kierros22);
        round23 = (TextView) findViewById(R.id.kierros23);
        round24 = (TextView) findViewById(R.id.kierros24);
        round25 = (TextView) findViewById(R.id.kierros25);
        roundRow1 = (LinearLayout) findViewById(R.id.kiekka1);
        roundRow2 = (LinearLayout) findViewById(R.id.kiekka2);
        roundRow3 = (LinearLayout) findViewById(R.id.kiekka3);
        roundRow4 = (LinearLayout) findViewById(R.id.kiekka4);
        roundRow5 = (LinearLayout) findViewById(R.id.kiekka5);
        roundRow6 = (LinearLayout) findViewById(R.id.kiekka6);
        roundRow7 = (LinearLayout) findViewById(R.id.kiekka7);
        roundRow8 = (LinearLayout) findViewById(R.id.kiekka8);
        roundRow9 = (LinearLayout) findViewById(R.id.kiekka9);
        roundRow10 = (LinearLayout) findViewById(R.id.kiekka10);
        roundRow11 = (LinearLayout) findViewById(R.id.kiekka11);
        roundRow12 = (LinearLayout) findViewById(R.id.kiekka12);
        roundRow13 = (LinearLayout) findViewById(R.id.kiekka13);
        roundRow14 = (LinearLayout) findViewById(R.id.kiekka14);
        roundRow15 = (LinearLayout) findViewById(R.id.kiekka15);
        roundRow16 = (LinearLayout) findViewById(R.id.kiekka16);
        roundRow17 = (LinearLayout) findViewById(R.id.kiekka17);
        roundRow18 = (LinearLayout) findViewById(R.id.kiekka18);
        roundRow19 = (LinearLayout) findViewById(R.id.kiekka19);
        roundRow20 = (LinearLayout) findViewById(R.id.kiekka20);
        roundRow21 = (LinearLayout) findViewById(R.id.kiekka21);
        roundRow22 = (LinearLayout) findViewById(R.id.kiekka22);
        roundRow23 = (LinearLayout) findViewById(R.id.kiekka23);
        roundRow24 = (LinearLayout) findViewById(R.id.kiekka24);
        roundRow25 = (LinearLayout) findViewById(R.id.kiekka25);
        roundSum1 = (TextView) findViewById(R.id.yht1);
        roundSum2 = (TextView) findViewById(R.id.yht2);
        roundSum3 = (TextView) findViewById(R.id.yht3);
        roundSum4 = (TextView) findViewById(R.id.yht4);
        roundSum5 = (TextView) findViewById(R.id.yht5);
        roundSum6 = (TextView) findViewById(R.id.yht6);
        roundSum7 = (TextView) findViewById(R.id.yht7);
        roundSum8 = (TextView) findViewById(R.id.yht8);
        roundSum9 = (TextView) findViewById(R.id.yht9);
        roundSum10 = (TextView) findViewById(R.id.yht10);
        roundSum11 = (TextView) findViewById(R.id.yht11);
        roundSum12 = (TextView) findViewById(R.id.yht12);
        roundSum13 = (TextView) findViewById(R.id.yht13);
        roundSum14 = (TextView) findViewById(R.id.yht14);
        roundSum15 = (TextView) findViewById(R.id.yht15);
        roundSum16 = (TextView) findViewById(R.id.yht16);
        roundSum17 = (TextView) findViewById(R.id.yht17);
        roundSum18 = (TextView) findViewById(R.id.yht18);
        roundSum19 = (TextView) findViewById(R.id.yht19);
        roundSum20 = (TextView) findViewById(R.id.yht20);
        roundSum21 = (TextView) findViewById(R.id.yht21);
        roundSum22 = (TextView) findViewById(R.id.yht22);
        roundSum23 = (TextView) findViewById(R.id.yht23);
        roundSum24 = (TextView) findViewById(R.id.yht24);
        roundSum25 = (TextView) findViewById(R.id.yht25);
        readyBtn = (Button) findViewById(R.id.ready);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        //endregion

        //region THROW POINT LISTENERS
        // Observes is 1. point field filled.
        dart1Field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkField1 = false;
                } else {
                    checkField1 = true;
                }
                checkFields();
            }
        });
        // Observes is 2. point field filled.
        dart2Field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkField2 = false;
                } else {
                    checkField2 = true;
                }
                checkFields();
            }
        });
        // Observes is 3. point field filled.
        dart3Field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkField3 = false;
                } else {
                    checkField3 = true;
                }
                checkFields();
            }
        });
        // Observes is 4. point field filled.
        dart4Field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkField4 = false;
                } else {
                    checkField4 = true;
                }
                checkFields();
            }
        });
        // Observes is 5. point field filled.
        dart5Field.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkField5 = false;
                } else {
                    checkField5 = true;
                }
                checkFields();
            }
        });
        //endregion

        //region READY BUTTON
        readyBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dartValue1 = Integer.parseInt(dart1Field.getText().toString());
                dartValue2 = Integer.parseInt(dart2Field.getText().toString());
                dartValue3 = Integer.parseInt(dart3Field.getText().toString());
                dartValue4 = Integer.parseInt(dart4Field.getText().toString());
                dartValue5 = Integer.parseInt(dart5Field.getText().toString());
                roundPoints = dartValue1 + dartValue2 + dartValue3 + dartValue4 + dartValue5;
                totalPoints.add(roundPoints);
                sortArray();
                fillRoundData(screen);
                throwRound++;
                roundTxt.setText(Integer.toString(throwRound) + ".kierros");
                if (isEnd) {
                    roundTxt.setText("Yhteispisteet " + Integer.toString(finalPoints));
                }
                dart1Field.setText("");
                dart2Field.setText("");
                dart3Field.setText("");
                dart4Field.setText("");
                dart5Field.setText("");
            }
        });
        //endregion

        //region RESET BUTTON
        resetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dlgAlert.setMessage(R.string.confirm_reset);
                dlgAlert.setTitle(R.string.reset_title);
                dlgAlert.setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = getIntent();
                        finish();
                        startActivity(intent);
                    }
                });
                dlgAlert.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {}
                });
                dlgAlert.setCancelable(true);
                dlgAlert.create().show();
            }
        });
        //endregion
    }

    //region CHECK POINT FIELDS
    // Checks all five point fields. All fields needs to have value to enable readyBtn btnMenu.
    public void checkFields(){
        if (checkField1 && checkField2 && checkField3 && checkField4 && checkField5){
            readyBtn.setEnabled(true);
        }
        else{
            readyBtn.setEnabled(false);
        }
    }
    //endregion1

    //region FILL ROUND DATA
    // Fills round data. Rounds depends on which view was selected.
    public void fillRoundData(int screen){
        if (throwRound == 1) {
            round1.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum1.setText(Integer.toString(roundPoints));
            roundRow1.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 2) {
            round2.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum2.setText(Integer.toString(roundPoints));
            roundRow2.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 3) {
            round3.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum3.setText(Integer.toString(roundPoints));
            roundRow3.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 4) {
            round4.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum4.setText(Integer.toString(roundPoints));
            roundRow4.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 5) {
            round5.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum5.setText(Integer.toString(roundPoints));
            roundRow5.setBackgroundColor(Color.rgb(0,70,5));
            if (screen == 1){
                calculateSum();
            }
        }
        else if (throwRound == 6) {
            round6.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum6.setText(Integer.toString(roundPoints));
            roundRow6.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 7) {
            round7.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum7.setText(Integer.toString(roundPoints));
            roundRow7.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 8) {
            round8.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum8.setText(Integer.toString(roundPoints));
            roundRow8.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 9) {
            round9.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum9.setText(Integer.toString(roundPoints));
            roundRow9.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 10) {
            round10.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum10.setText(Integer.toString(roundPoints));
            roundRow10.setBackgroundColor(Color.rgb(0,80,5));

            if (screen == 2){
                calculateSum();
            }
        }
        else if (throwRound == 11) {
            round11.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum11.setText(Integer.toString(roundPoints));
            roundRow11.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 12) {
            round12.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum12.setText(Integer.toString(roundPoints));
            roundRow12.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 13) {
            round13.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum13.setText(Integer.toString(roundPoints));
            roundRow13.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 14) {
            round14.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum14.setText(Integer.toString(roundPoints));
            roundRow14.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 15) {
            round15.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum15.setText(Integer.toString(roundPoints));
            roundRow15.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 16) {
            round16.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum16.setText(Integer.toString(roundPoints));
            roundRow16.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 17) {
            round17.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum17.setText(Integer.toString(roundPoints));
            roundRow17.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 18) {
            round18.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum18.setText(Integer.toString(roundPoints));
            roundRow18.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 19) {
            round19.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum19.setText(Integer.toString(roundPoints));
            roundRow19.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 20) {
            round20.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum20.setText(Integer.toString(roundPoints));
            roundRow20.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 21) {
            round21.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum21.setText(Integer.toString(roundPoints));
            roundRow21.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 22) {
            round22.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum22.setText(Integer.toString(roundPoints));
            roundRow22.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 23) {
            round23.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum23.setText(Integer.toString(roundPoints));
            roundRow23.setBackgroundColor(Color.rgb(0,70,5));
        }
        else if (throwRound == 24) {
            round24.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum24.setText(Integer.toString(roundPoints));
            roundRow24.setBackgroundColor(Color.rgb(0,80,5));
        }
        else if (throwRound == 25) {
            round25.setText(Integer.toString(dartValue1) +  " , " + Integer.toString(dartValue2) +  " , " + Integer.toString(dartValue3) +  " , "  + Integer.toString(dartValue4) +  " , "  + Integer.toString(dartValue5));
            roundSum25.setText(Integer.toString(roundPoints));
            roundRow25.setBackgroundColor(Color.rgb(0,70,5));
            if (screen == 3){
                calculateSum();
            }
        }
    }
    //endregion

    //region CALCULATE TOTAL POINTS
    public void calculateSum(){
        for (int i = 0; i < totalPoints.size(); i++) {
            finalPoints += totalPoints.get(i);
        }
        isEnd = true;
        dart1Field.setEnabled(false);
        dart2Field.setEnabled(false);
        dart3Field.setEnabled(false);
        dart4Field.setEnabled(false);
        dart5Field.setEnabled(false);
        readyBtn.setEnabled(false);
    }
    //endregion

    //region SORT SINGLE ROUND POINTS IN DESCENDING ORDER
    public void sortArray(){
        helperArray.add(dartValue1);
        helperArray.add(dartValue2);
        helperArray.add(dartValue3);
        helperArray.add(dartValue4);
        helperArray.add(dartValue5);
        Collections.sort(helperArray);
        Collections.reverse(helperArray);
        dartValue1 = helperArray.get(0);
        dartValue2 = helperArray.get(1);
        dartValue3 = helperArray.get(2);
        dartValue4 = helperArray.get(3);
        dartValue5 = helperArray.get(4);
        helperArray.clear();
    }
    //endregion
}