package com.example.tj2.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.util.ArrayList;

public class BattleCreation extends AppCompatActivity {

    //region LAYOUT COMPONENTS AND VARIABLES
    RadioButton radio2Players, radio3Players, radio4Players;
    EditText player1, player2, player3, player4;
    LinearLayout player3Field, player4Field;
    Intent startBattle;
    Button startBtn;
    boolean checkName1, checkName2, checkName3, checkName4 = false;
    int radioId;
    int selectedPlayers = 2;
    private ArrayList<String> playerNames = new ArrayList<>();
    //endregion

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //region CREATE VIEW
        super.onCreate(savedInstanceState);
        setContentView(R.layout.battlecreation);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.battle);
        startBattle = new Intent(this, Battle.class);
        //endregion

        //region DEFINITIONS
        player1 = (EditText) findViewById(R.id.competitor1);
        player2 = (EditText) findViewById(R.id.competitor2);
        player3 = (EditText) findViewById(R.id.competitor3);
        player4 = (EditText) findViewById(R.id.competitor4);
        player3Field = (LinearLayout) findViewById(R.id.players3Line);
        player4Field = (LinearLayout) findViewById(R.id.players4Line);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.playersRadio);
        radio2Players = (RadioButton) findViewById(R.id.radio2players);
        radio3Players = (RadioButton) findViewById(R.id.radio3players);
        radio4Players = (RadioButton) findViewById(R.id.radio4players);
        radioId = R.id.radio2players;
        startBtn = (Button) findViewById(R.id.startBtn);
        //endregion

        //region RADIO BUTTON LISTENER
        assert radioGroup != null;
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioId = checkedId;
                if (checkedId == R.id.radio2players){
                    player3Field.setVisibility(View.INVISIBLE);
                    player4Field.setVisibility(View.INVISIBLE);
                    player3.setText("");
                    player4.setText("");
                    selectedPlayers = 2;
                }
                else if (checkedId == R.id.radio3players){
                    player3Field.setVisibility(View.VISIBLE);
                    player4Field.setVisibility(View.INVISIBLE);
                    player4.setText("");
                    selectedPlayers = 3;
                }
                else if (checkedId == R.id.radio4players){
                    player3Field.setVisibility(View.VISIBLE);
                    player4Field.setVisibility(View.VISIBLE);
                    selectedPlayers = 4;
                }
                checkNameFields();
            }
        });
        //endregion

        //region NAME FIELD LISTENERS
        player1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkName1 = false;
                } else {
                    checkName1 = true;
                }
                checkNameFields();
            }
        });

        player2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkName2 = false;
                } else {
                    checkName2 = true;
                }
                checkNameFields();
            }
        });

        player3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkName3 = false;
                } else {
                    checkName3 = true;
                }
                checkNameFields();
            }
        });

        player4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {}
            @Override
            public void afterTextChanged(Editable s) {
                if(s.toString().trim().length()==0){
                    checkName4 = false;
                } else {
                    checkName4 = true;
                }
                checkNameFields();
            }
        });
        //endregion
    }

    //region CHECK NAME FIELDS
    // Checks that all selected name fields has name.
    public void checkNameFields(){
        if (radioId == R.id.radio2players){
            if (checkName1 && checkName2){
                startBtn.setEnabled(true);
            }
            else{
                startBtn.setEnabled(false);
            }
        }
        else if (radioId == R.id.radio3players){
            if (checkName1 && checkName2 && checkName3){
                startBtn.setEnabled(true);
            }
            else{
                startBtn.setEnabled(false);
            }
        }
        else if (radioId == R.id.radio4players){
            if (checkName1 && checkName2 && checkName3 && checkName4){
                startBtn.setEnabled(true);
            }
            else{
                startBtn.setEnabled(false);
            }
        }
    }
    //endregion1

    //region START BATTLE
    public void startBattle(View view) {
        playerNames.add(0, player1.getText().toString());
        playerNames.add(1, player2.getText().toString());
        if (selectedPlayers > 2){
            playerNames.add(2, player3.getText().toString());
        }
        if (selectedPlayers == 4){
            playerNames.add(3, player4.getText().toString());
        }
        startBattle.putStringArrayListExtra("Competitors", playerNames);
        startBattle.putExtra("PlayerCount", selectedPlayers);
        startActivity(startBattle);
    }
    //endregion
}