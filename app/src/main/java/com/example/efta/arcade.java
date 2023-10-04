package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.efta.R;

import java.util.Random;

public class arcade extends AppCompatActivity {

    private ImageView[] cards;
    private int[] cardImages;
    private boolean[] cardFlipped;
    private boolean isCardFlipped = false;
    private int firstCardIndex = -1;
    private int secondCardIndex = -1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_1);

        cards = new ImageView[] {
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
        cardImages = new int[] {
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

    public void onCardClick(View view) {
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
                }
            }
        }
    }

    private void checkForMatch() {
        if (cardImages[firstCardIndex] == cardImages[secondCardIndex]) {
            // Cards match, perform your match logic here
            // For example, hide both cards
            cards[firstCardIndex].setVisibility(View.VISIBLE);
            cards[secondCardIndex].setVisibility(View.VISIBLE);
        } else {
            // Cards don't match, flip them back
            cards[firstCardIndex].setImageResource(R.drawable.card_back);
            cards[secondCardIndex].setImageResource(R.drawable.card_back);
        }

        // Reset card states
        cardFlipped[firstCardIndex] = false;
        cardFlipped[secondCardIndex] = false;
        firstCardIndex = -1;
        secondCardIndex = -1;
    }

    private void shuffleCardImages() {
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




}
