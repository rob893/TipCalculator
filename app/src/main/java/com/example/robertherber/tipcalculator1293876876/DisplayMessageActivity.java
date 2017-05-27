package com.example.robertherber.tipcalculator1293876876;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextClock;
import android.widget.TextView;

public class DisplayMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_message);
        Intent intent = getIntent();
        String message = "Total Cost: $" + intent.getStringExtra("mealPriceKey");
        String message2 = "Tip Amount: $" + intent.getStringExtra("tipKey");

        TextView textView = (TextView) findViewById(R.id.totalCost);
        textView.setText(message);
        TextView textView2 = (TextView) findViewById(R.id.tipAmount);
        textView2.setText(message2);
    }

}
