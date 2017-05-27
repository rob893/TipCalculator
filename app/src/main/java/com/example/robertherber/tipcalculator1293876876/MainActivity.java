package com.example.robertherber.tipcalculator1293876876;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.robertherber.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sendMessage(View view){ //works ish
        RadioButton roundDown = (RadioButton) findViewById(R.id.roundDown);
        RadioButton roundUp = (RadioButton) findViewById(R.id.roundUp);

        Intent intent = new Intent(this, DisplayMessageActivity.class);

        EditText price = (EditText) findViewById(R.id.mealPrice);
        EditText tip = (EditText) findViewById(R.id.tip);

        if(price.getText().length() == 0){
            Toast.makeText(this, "Enter a valid number for price!", Toast.LENGTH_LONG).show();
        } else if(tip.getText().length() == 0){
            Toast.makeText(this, "Enter a valid number for tip!", Toast.LENGTH_LONG).show();
        } else {

            double mealAmount = Double.parseDouble(price.getText().toString());
            double tipAmount = Double.parseDouble(tip.getText().toString());

            tipAmount = tipAmount / 100;
            double totalTip = mealAmount * tipAmount;
            double totalCost = mealAmount + totalTip;

            double tipRound = Math.round(totalTip * 100.0) / 100.0;
            double costRound = Math.round(totalCost * 100.0) / 100.0;

            if (roundDown.isChecked() && (roundUp.isChecked() == false)) {
                costRound = Math.floor(costRound);
                tipRound = costRound - mealAmount;
                tipRound = Math.round(tipRound * 100.0) / 100.0;
            } else if (roundUp.isChecked() && (roundDown.isChecked() == false)) {
                costRound = Math.ceil(costRound);
                tipRound = costRound - mealAmount;
                tipRound = Math.round(tipRound * 100.0) / 100.0;
            } else if(roundDown.isChecked() && roundUp.isChecked()){
                Toast.makeText(this, "You can't round up AND down, silly! So no rounding for you!", Toast.LENGTH_LONG).show();
            }

            price.setText(String.valueOf(costRound));
            tip.setText(String.valueOf(tipRound));

            String priceMessage = price.getText().toString();
            String tipMessage = tip.getText().toString();

            intent.putExtra("mealPriceKey", priceMessage);
            intent.putExtra("tipKey", tipMessage);
            startActivity(intent);
        }
    }

    public void youSuck(View view){
        Toast.makeText(this, "You suck!", Toast.LENGTH_LONG).show();
    }
}
