package com.example.randomcolorevi;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonRandomColor;
    private TextView textViewColor;

    private RelativeLayout relativeLayout;
    private EditText editTextRed;
    private EditText editTextGreen;
    private EditText editTextBlue;
    private Button buttonFixColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        buttonRandomColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random random = new Random();
                int red = random.nextInt(256);
                int green = random.nextInt(256);
                int blue = random.nextInt(256);
                textViewColor.setText("("+red+","+green+","+blue+")");
                relativeLayout.setBackgroundColor(Color.rgb(red,green,blue));
                if (red + green + blue < 384) {
                    textViewColor.setTextColor(Color.WHITE);
                }else{
                    textViewColor.setTextColor(Color.BLACK);
                }
            }
        });

        buttonFixColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String redString= editTextRed.getText().toString();
                String greenString= editTextGreen.getText().toString();
                String blueString= editTextBlue.getText().toString();
                if (redString.isEmpty() || greenString.isEmpty() || blueString.isEmpty()) {
                    return;
                }
                int red=Integer.parseInt(redString);
                int green=Integer.parseInt(greenString);
                int blue=Integer.parseInt(blueString);
                textViewColor.setText("("+red+","+green+","+blue+")");
                relativeLayout.setBackgroundColor(Color.rgb(red,green,blue));
                if (red+green+blue<384){
                    textViewColor.setTextColor(Color.WHITE);
                }else{
                    textViewColor.setTextColor(Color.BLACK);
                }

            }
        });
    }

    private void init(){
        buttonRandomColor = findViewById(R.id.buttonRandomColor);
        textViewColor = findViewById(R.id.textViewColor);
        relativeLayout = findViewById(R.id.relativeLayout);
        editTextRed=findViewById(R.id.editTextRed);
        editTextRed=findViewById(R.id.editTextGreen);
        editTextRed=findViewById(R.id.editTextBlue);
        buttonFixColor=findViewById(R.id.buttonFixColor);
    }
}