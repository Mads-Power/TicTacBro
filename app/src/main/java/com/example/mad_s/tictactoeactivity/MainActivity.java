package com.example.mad_s.tictactoeactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btnMultiplayer;
    private Button btnSingleplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Intent intent = new Intent();


       btnMultiplayer = findViewById(R.id.btn_multiplayer);
       btnSingleplayer = findViewById(R.id.btn_singleplayer);

        btnMultiplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent1 = new Intent(getApplicationContext(),Multiplayer.class);
                startActivity(intent1);
            }
        });

        btnSingleplayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent2 = new Intent(getApplicationContext(),Singleplayer.class);
                startActivity(intent2);
            }
        });

    }
}
