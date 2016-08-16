package com.example.tj2.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Menu extends AppCompatActivity {

    Intent openCalculator, openBattleCreation, openTopScores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //region CREATE VIEW
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.reddarts);
        openCalculator = new Intent(this, Calculator.class);
        openBattleCreation = new Intent(this, BattleCreation.class);
        openTopScores = new Intent(this, TopScores.class);
        //endregion
    }

    //region VIEW SELECTIONS
    // Opens 25 dart view.
    public void select25darts(View view) {
        openCalculator.putExtra("selectScreen", 1);
        startActivity(openCalculator);
    }

    // Opens 50 dart view.
    public void select50darts(View view) {
        openCalculator.putExtra("selectScreen", 2);
        startActivity(openCalculator);
    }

    // Opens 125 dart view.
    public void select125darts(View view) {
        openCalculator.putExtra("selectScreen", 3);
        startActivity(openCalculator);
    }

    // Opens 250 dart view.
    public void select250darts(View view) {
        openCalculator.putExtra("selectScreen", 4);
        startActivity(openCalculator);
    }

    // Opens battle creation view.
    public void selectBattle(View view) {
        startActivity(openBattleCreation);
    }

    // Opens top scores view. Not implemented.
   /* public void selectTopScores(View view) {
        startActivity(openBattleCreation);
    }*/
    //endregion
}