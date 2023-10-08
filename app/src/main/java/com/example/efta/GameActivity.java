package com.example.efta;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class GameActivity extends AppCompatActivity {

    private CountDownTimer timer;
    private int score = 0;
    private ImageView card1, card2; // Example: ImageViews representing cards
    private boolean isCard1FaceUp = false;
    private boolean isCard2FaceUp = false;
    private int[] cardImages;
    private boolean[] cardFlipped;
    private ImageView[] cards;
    private boolean isCardFlipped = false;
    private int firstCardIndex = -1;
    private int secondCardIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game3);

        // Initialize UI elements
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

       // Button endGameButton = findViewById(R.id.btn_exit); // Button to end the game
       // endGameButton.setOnClickListener(new View.OnClickListener() {
         //   @Override
        //    public void onClick(View v) {
       //         endGame();
         //   }
       // });

        // Start the game when the activity is created
        startGame();
    }

    private void startGame() {
        // Initialize game variables, shuffle cards, and start the timer
        // Example: shuffleCards();

    }}

