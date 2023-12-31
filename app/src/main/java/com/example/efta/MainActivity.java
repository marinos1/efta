package com.example.efta;


import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.efta.R.id;

import java.util.Random;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private ViewGroup container;

    private ImageView[] cards;

    String message = "This is Cool";
    int duration = Toast.LENGTH_SHORT;



    private int[] cardImages;
    private boolean[] cardFlipped;
    private boolean isCardFlipped = false;
    private int firstCardIndex = -1;
    private int secondCardIndex = -1;

    private int moveCount = 0;
    GameActivity ga = new GameActivity();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Inflate the menu layout
        //View menuView = getLayoutInflater().inflate(R.layout.menu_layout, null);
        View menuView = getLayoutInflater().inflate(R.layout.new_menu_2, null);
        setContentView(menuView);

        // Find the buttons by their IDs
        //Button btnNewGame = menuView.findViewById(R.id.btn_new_game);
        ImageView btnNewGame = menuView.findViewById(R.id.btn_new_game);
        //Button btnInstructions = menuView.findViewById(R.id.btn_instructions);
        ImageView btnInstructions = menuView.findViewById(R.id.btn_new_game1);
       // Button btnExit = menuView.findViewById(R.id.btn_exit);
        ImageView btnExit = menuView.findViewById(R.id.btn_new_game2);
        ImageView btnset = menuView.findViewById(id.music_setting);
        ImageView share = menuView.findViewById(id.share);
        Intent intent = new Intent(MainActivity.this, MainActivity.class);

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                // Handle "New Game" button click
                // Start a new game or navigate to the game screen

                setContentView(R.layout.menu_arcade);
            }

            });

        btnset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                // Handle "New Game" button click
                // Start a new game or navigate to the game screen

                setContentView(R.layout.menu_arcade);
            }

        });

            // Set click listeners for the buttons
        btnNewGame.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // Handle "New Game" button click
                // Start a new game or navigate to the game screen

                setContentView(R.layout.menu_arcade);

                ImageView imageView = findViewById(id.card11);
                ImageView imageView1 = findViewById(id.card2);


                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.activity_game3);

                        Button home = findViewById(id.returnHomeButton);

                        home.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {

                               // View menuView = getLayoutInflater().inflate(R.layout.menu_layout, null);
                                //setContentView(menuView);
                                // In your current activity or method

                               intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                               startActivity(intent);



                            }
                        });
                        Chronometer chronometer = findViewById(R.id.chronometer);
                        chronometer.setBase(SystemClock.elapsedRealtime());
                        chronometer.start();
                        cards = new ImageView[]{
                                findViewById(R.id.card1),
                                findViewById(R.id.card2),
                                findViewById(R.id.card3),
                                findViewById(R.id.card4),
                                findViewById(R.id.card5),
                                findViewById(R.id.card6),
                                findViewById(R.id.card7),
                                findViewById(R.id.card8),
                                findViewById(R.id.card9),
                                findViewById(R.id.card101),
                                findViewById(R.id.card102),
                                findViewById(R.id.card103),
                                findViewById(R.id.card104),
                                findViewById(R.id.card105),
                                findViewById(R.id.card106),
                                findViewById(R.id.card107),

                                // Add two more cards here
                        };

                        // Initialize your card images (pairs)
                        cardImages = new int[]{
                                R.drawable.a1,
                                R.drawable.a2,
                                R.drawable.a3,
                                R.drawable.a4,
                                R.drawable.a5,
                                R.drawable.a6,
                                R.drawable.a7,
                                R.drawable.a8,
                                R.drawable.a1,
                                R.drawable.a2,
                                R.drawable.a3,
                                R.drawable.a4,
                                R.drawable.a5,
                                R.drawable.a6,
                                R.drawable.a7,
                                R.drawable.a8,
                        };

                        cardFlipped = new boolean[cards.length];
                        for (int i = 0; i < cards.length; i++) {
                            cardFlipped[i] = false;
                        }
                        shuffleCardImages();
                    }
                });

                imageView1.setOnClickListener(new View.OnClickListener() {


                    public void onClick(View v) {
                        setContentView(R.layout.activity_game_2);
                        cards = new ImageView[]{


                                // Add two more cards here
                        };

                        // Initialize your card images (pairs)
                        cardImages = new int[]{
                                R.drawable.card_front1,
                                R.drawable.card_front1,
                                R.drawable.card_front2,
                                R.drawable.card_front2,


                        };

                        cardFlipped = new boolean[cards.length];
                        for (int i = 0; i < cards.length; i++) {
                            cardFlipped[i] = false;
                        }
                        shuffleCardImages();
                    }


                });


            }
            });


       btnInstructions.setOnClickListener(new View.OnClickListener()

        {
                @Override
                public void onClick (View v){
                // Handle "Instructions" button click
                // Show instructions or navigate to the instructions screen

            }
            });

        btnExit.setOnClickListener(new View.OnClickListener()

            {
                @Override
                public void onClick (View v){
                // Handle "Exit" button click
                finish(); // Close the app
            }
            });


        }

        public void onCardClick (View view){
            if (!isCardFlipped) {
                int cardIndex = -1;
                for (int i = 0; i < cards.length; i++) {
                    if (cards[i] == view) {
                        cardIndex = i;
                        break;
                    }
                }

                if (cardIndex != -1 && !cardFlipped[cardIndex]) {
                    ((ImageView) view).setImageResource(cardImages[cardIndex]);
                    cardFlipped[cardIndex] = true;

                    if (firstCardIndex == -1) {
                        firstCardIndex = cardIndex;
                    } else {
                        secondCardIndex = cardIndex;
                        checkForMatch();

                        TextView aa= findViewById(R.id.moveCountTextView);
                        aa.setText("Moves: " + ac);

                    }
                }
            }
        }
        private void shuffleCardImages () {
            // Implement your shuffling logic here
            // You can use any shuffling algorithm to randomize cardImages
            Random random = new Random();

            for (int i = cardImages.length - 1; i > 0; i--) {
                int j = random.nextInt(i + 1);

                // Swap cardImages[i] and cardImages[j]
                int temp = cardImages[i];
                cardImages[i] = cardImages[j];
                cardImages[j] = temp;
            }


        }
          int ac=0;
          int ac3=0;
        private void checkForMatch () {
            if (cardImages[firstCardIndex] == cardImages[secondCardIndex]) {
                // Cards match, perform your match logic here
                // For example, hide both cards
                cards[firstCardIndex].setVisibility(View.INVISIBLE);

                cards[secondCardIndex].setVisibility(View.INVISIBLE);

                ac++;
                ac3++;
                if (ac3==8){
                    Chronometer chronometer = findViewById(R.id.chronometer);
                    chronometer.stop();
                    Toast.makeText(getApplicationContext(), message, duration).show();


                }
            } else {
                // Cards don't match, flip them back
                cards[firstCardIndex].setImageResource(R.drawable.card_back);
                cards[secondCardIndex].setImageResource(R.drawable.card_back);
                ac++;

            }

            // Reset card states
            cardFlipped[firstCardIndex] = false;
            cardFlipped[secondCardIndex] = false;
            firstCardIndex = -1;
            secondCardIndex = -1;
        }




}










