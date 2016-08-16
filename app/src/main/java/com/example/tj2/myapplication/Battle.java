package com.example.tj2.myapplication;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;

public class Battle extends AppCompatActivity {

    //region LAYOUT COMPONENTS AND VARIABLES
    EditText dartField1, dartField2, dartField3, dartField4, dartField5;
    TextView playerName1, playerName2, playerName3, playerName4, roundName;
    TextView p1round1, p1round2, p1round3, p1round4, p1round5;
    TextView p2round1, p2round2, p2round3, p2round4, p2round5;
    TextView p3round1, p3round2, p3round3, p3round4, p3round5;
    TextView p4round1, p4round2, p4round3, p4round4, p4round5;
    TextView p1sum, p2sum, p3sum, p4sum;
    LinearLayout player3data, player4data, row3, row4;
    Button readyBtn, resetBtn;
    boolean checkField1, checkField2, checkField3, checkField4, checkField5;
    int dartValue1, dartValue2, dartValue3, dartValue4, dartValue5, roundPoints;
    int p1TempPoints, p2TempPoints, p3TempPoints, p4TempPoints;
    int p1FinalPoints, p2FinalPoints, p3FinalPoints, p4FinalPoints = 0;
    int player = 1;
    int round = 1;
    int playerCount;
    private ArrayList<Integer> player1Points = new ArrayList<>();
    private ArrayList<Integer> player2Points = new ArrayList<>();
    private ArrayList<Integer> player3Points = new ArrayList<>();
    private ArrayList<Integer> player4Points = new ArrayList<>();
    AlertDialog.Builder dlgAlert;
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //region CREATE VIEW
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.battle);
        dlgAlert  = new AlertDialog.Builder(this);
        setContentView(R.layout.battle);
        Intent startActivity = getIntent();
        final ArrayList playerNames = startActivity.getExtras().getStringArrayList("Competitors");
        final int playersInGame = startActivity.getExtras().getInt("PlayerCount");
        playerCount = playersInGame;
        //endregion

        //region DEFINITIONS
        roundName  = (TextView) findViewById(R.id.roundLabel);
        dartField1 = (EditText) findViewById(R.id.dart1);
        dartField2 = (EditText) findViewById(R.id.dart2);
        dartField3 = (EditText) findViewById(R.id.dart3);
        dartField4 = (EditText) findViewById(R.id.dart4);
        dartField5 = (EditText) findViewById(R.id.dart5);
        playerName1 = (TextView) findViewById(R.id.p1name);
        playerName2 = (TextView) findViewById(R.id.p2name);
        playerName3 = (TextView) findViewById(R.id.p3name);
        playerName4 = (TextView) findViewById(R.id.p4name);
        p1round1 = (TextView) findViewById(R.id.p1round1);
        p1round2 = (TextView) findViewById(R.id.p1round2);
        p1round3 = (TextView) findViewById(R.id.p1round3);
        p1round4 = (TextView) findViewById(R.id.p1round4);
        p1round5 = (TextView) findViewById(R.id.p1round5);
        p2round1 = (TextView) findViewById(R.id.p2round1);
        p2round2 = (TextView) findViewById(R.id.p2round2);
        p2round3 = (TextView) findViewById(R.id.p2round3);
        p2round4 = (TextView) findViewById(R.id.p2round4);
        p2round5 = (TextView) findViewById(R.id.p2round5);
        p3round1 = (TextView) findViewById(R.id.p3round1);
        p3round2 = (TextView) findViewById(R.id.p3round2);
        p3round3 = (TextView) findViewById(R.id.p3round3);
        p3round4 = (TextView) findViewById(R.id.p3round4);
        p3round5 = (TextView) findViewById(R.id.p3round5);
        p4round1 = (TextView) findViewById(R.id.p4round1);
        p4round2 = (TextView) findViewById(R.id.p4round2);
        p4round3 = (TextView) findViewById(R.id.p4round3);
        p4round4 = (TextView) findViewById(R.id.p4round4);
        p4round5 = (TextView) findViewById(R.id.p4round5);

        player3data = (LinearLayout) findViewById(R.id.player3);
        player4data = (LinearLayout) findViewById(R.id.player4);
        row3 = (LinearLayout) findViewById(R.id.row3);
        row4 = (LinearLayout) findViewById(R.id.row4);

        p1sum = (TextView) findViewById(R.id.player1sum);
        p2sum = (TextView) findViewById(R.id.player2sum);
        p3sum = (TextView) findViewById(R.id.player3sum);
        p4sum = (TextView) findViewById(R.id.player4sum);
        readyBtn = (Button) findViewById(R.id.readyBtn);
        resetBtn = (Button) findViewById(R.id.resetBtn);
        //endregion

        //region SHOW PLAYER NAMES
        playerName1.setTextColor(Color.YELLOW);
        playerName1.setText(playerNames.get(0).toString());
        playerName2.setText(playerNames.get(1).toString());

        if (playerCount > 2){
            row3.setVisibility(View.VISIBLE);
            playerName3.setText(playerNames.get(2).toString());
        }
        if (playerCount == 4){
            row4.setVisibility(View.VISIBLE);
            playerName4.setText(playerNames.get(3).toString());
        }
        //endregion

        //region THROW POINT LISTENERS
        // Observes is 1. point field filled.
        dartField1.addTextChangedListener(new TextWatcher() {
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
        dartField2.addTextChangedListener(new TextWatcher() {
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
        dartField3.addTextChangedListener(new TextWatcher() {
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
        dartField4.addTextChangedListener(new TextWatcher() {
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
        dartField5.addTextChangedListener(new TextWatcher() {
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
                dartValue1 = Integer.parseInt(dartField1.getText().toString());
                dartValue2 = Integer.parseInt(dartField2.getText().toString());
                dartValue3 = Integer.parseInt(dartField3.getText().toString());
                dartValue4 = Integer.parseInt(dartField4.getText().toString());
                dartValue5 = Integer.parseInt(dartField5.getText().toString());
                roundPoints = dartValue1 + dartValue2 + dartValue3 + dartValue4 + dartValue5;

                if (player == 1){
                    player1Points.add(roundPoints);
                    for (int i = 0; i < player1Points.size(); i++) {
                        p1TempPoints += player1Points.get(i);
                    }
                    p1sum.setText(Integer.toString(p1TempPoints));
                    p1FinalPoints = p1TempPoints;
                    p1TempPoints = 0;
                }
                else if (player == 2){
                    player2Points.add(roundPoints);
                    for (int i = 0; i < player2Points.size(); i++) {
                        p2TempPoints += player2Points.get(i);
                    }
                    p2sum.setText(Integer.toString(p2TempPoints));
                    p2FinalPoints = p2TempPoints;
                    p2TempPoints = 0;
                }
                else if (player == 3 && playerCount > 2){
                    player3Points.add(roundPoints);
                    for (int i = 0; i < player3Points.size(); i++) {
                        p3TempPoints += player3Points.get(i);
                    }
                    p3sum.setText(Integer.toString(p3TempPoints));
                    p3FinalPoints = p3TempPoints;
                    p3TempPoints = 0;
                }
                else if (player == 4  && playerCount > 3){
                    player4Points.add(roundPoints);
                    for (int i = 0; i < player4Points.size(); i++) {
                        p4TempPoints += player4Points.get(i);
                    }
                    p4sum.setText(Integer.toString(p4TempPoints));
                    p4FinalPoints = p4TempPoints;
                    p4TempPoints = 0;
                }
                fillRoundData();
                dartField1.setText("");
                dartField2.setText("");
                dartField3.setText("");
                dartField4.setText("");
                dartField5.setText("");
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
    // Fills round data. Depends on which round and which players turn is it.
    public void fillRoundData(){

        if (round == 1) {
            if (player == 1){
                p1round1.setText(Integer.toString(roundPoints));
            }
            else if (player == 2){
                p2round1.setText(Integer.toString(roundPoints));
            }
            else if (player == 3){
                p3round1.setText(Integer.toString(roundPoints));
            }
            else if (player == 4){
                p4round1.setText(Integer.toString(roundPoints));
            }
            checkPlayerAndRound();
        }
        else if (round == 2) {
            if (player == 1){
                p1round2.setText(Integer.toString(roundPoints));
            }
            else if (player == 2){
                p2round2.setText(Integer.toString(roundPoints));
            }
            else if (player == 3){
                p3round2.setText(Integer.toString(roundPoints));
            }
            else if (player == 4){
                p4round2.setText(Integer.toString(roundPoints));
            }
            checkPlayerAndRound();
        }
        else if (round == 3) {
            if (player == 1){
                p1round3.setText(Integer.toString(roundPoints));
            }
            else if (player == 2){
                p2round3.setText(Integer.toString(roundPoints));
            }
            else if (player == 3){
                p3round3.setText(Integer.toString(roundPoints));
            }
            else if (player == 4){
                p4round3.setText(Integer.toString(roundPoints));
            }
            checkPlayerAndRound();
        }
        else if (round == 4) {
            if (player == 1){
                p1round4.setText(Integer.toString(roundPoints));
            }
            else if (player == 2){
                p2round4.setText(Integer.toString(roundPoints));
            }
            else if (player == 3){
                p3round4.setText(Integer.toString(roundPoints));
            }
            else if (player == 4){
                p4round4.setText(Integer.toString(roundPoints));
            }
            checkPlayerAndRound();
        }
        else if (round == 5) {
            if (player == 1){
                p1round5.setText(Integer.toString(roundPoints));
            }
            else if (player == 2){
                p2round5.setText(Integer.toString(roundPoints));
            }
            else if (player == 3){
                p3round5.setText(Integer.toString(roundPoints));
            }
            else if (player == 4){
                p4round5.setText(Integer.toString(roundPoints));
            }
            checkPlayerAndRound();
        }
    }
    //endregion

    //region CHECK PLAYER AND ROUND
    public void checkPlayerAndRound() {
        playerName1.setTextColor(Color.WHITE);
        playerName2.setTextColor(Color.WHITE);
        playerName3.setTextColor(Color.WHITE);
        playerName4.setTextColor(Color.WHITE);

        if(playerCount == player){
            round++;
            player = 1;
            roundName.setText(Integer.toString(round) + ". kierros");
            playerName1.setTextColor(Color.YELLOW);
        }
        else{
            player++;
            if (player == 2){
                playerName2.setTextColor(Color.YELLOW);
            }
            else if (player == 3){
                playerName3.setTextColor(Color.YELLOW);
            }
            else if (player == 4){
                playerName4.setTextColor(Color.YELLOW);
            }
        }
        if (round > 5) {
            playerName1.setTextColor(Color.WHITE);
            endBattle();
        }
    }
    //endregion

    //region END BATTLE
    // Ends battle after last round and finds winner.
    public void endBattle() {
        if (p1FinalPoints > p2FinalPoints &&  p1FinalPoints > p3FinalPoints && p1FinalPoints > p4FinalPoints){
            roundName.setText("Voittaja: " + playerName1.getText());
        }
        else if (p2FinalPoints > p1FinalPoints && p2FinalPoints > p3FinalPoints && p2FinalPoints > p4FinalPoints){
            roundName.setText("Voittaja: " + playerName2.getText());
        }
        else if (p3FinalPoints > p1FinalPoints && p3FinalPoints > p2FinalPoints && p3FinalPoints > p4FinalPoints){
            roundName.setText("Voittaja: " + playerName3.getText());
        }
        else if (p4FinalPoints > p1FinalPoints && p4FinalPoints > p2FinalPoints && p4FinalPoints > p3FinalPoints){
            roundName.setText("Voittaja: " + playerName4.getText());
        }
        else {
            roundName.setText(R.string.draw);
        }
        dartField1.setEnabled(false);
        dartField2.setEnabled(false);
        dartField3.setEnabled(false);
        dartField4.setEnabled(false);
        dartField5.setEnabled(false);
        readyBtn.setEnabled(false);
    }
    //endregion
}