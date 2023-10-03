package com.example.efta;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.efta.R.id;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ViewGroup container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate the menu layout
        View menuView = getLayoutInflater().inflate(R.layout.menu_layout, null);
        setContentView(menuView);

        // Find the buttons by their IDs
        Button btnNewGame = menuView.findViewById(R.id.btn_new_game);
        Button btnInstructions = menuView.findViewById(R.id.btn_instructions);
        Button btnExit = menuView.findViewById(R.id.btn_exit);



        // Set click listeners for the buttons
        btnNewGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "New Game" button click
                // Start a new game or navigate to the game screen

                setContentView(R.layout.menu_arcade);

                ImageView imageView=findViewById(id.card11);
                imageView.setOnClickListener(new View.OnClickListener(){

                    @Override
                        public void onClick(View v) {
                        setContentView(R.layout.activity_game_1);


            }});
        }});


        btnInstructions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Instructions" button click
                // Show instructions or navigate to the instructions screen

            }
        });

        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Exit" button click
                finish(); // Close the app
            }
        });
    }






}










