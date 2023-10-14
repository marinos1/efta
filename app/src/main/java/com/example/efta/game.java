package com.example.efta;

import android.os.Handler;
import android.view.View;
import android.widget.Chronometer;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.util.Random;



public class game {
    private boolean[] cardFlipped;
    private boolean isCardFlipped = false;
    public int firstCardIndex = -1;
    public int secondCardIndex = -1;
    public void shuffleCardImages(int[] cardImages) {


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

    int sac=0;




}
