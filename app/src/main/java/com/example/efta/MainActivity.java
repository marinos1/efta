package com.example.efta;


import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
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
                ImageView x5x = findViewById(id.card3);
                ImageView  x56= findViewById(id.card4);

                    x56.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            setContentView(R.layout.activity_game_1);
                            ImageView home = findViewById(id.returnHome);
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
                                    findViewById(R.id.card36b),
                                    findViewById(R.id.card35b),
                                    findViewById(R.id.card34b),
                                    findViewById(R.id.card33b),
                                    findViewById(R.id.card32b),
                                    findViewById(R.id.card31b),
                                    findViewById(R.id.card30b),
                                    findViewById(id.card29b),
                                    findViewById(id.card28b),
                                    findViewById(R.id.card27b),
                                    findViewById(R.id.card26b),
                                    findViewById(R.id.card1b),
                                    findViewById(R.id.card2b),
                                    findViewById(R.id.card3b),
                                    findViewById(R.id.card4b),
                                    findViewById(R.id.card5b),
                                    findViewById(R.id.card6b),
                                    findViewById(R.id.card7b),
                                    findViewById(R.id.card8b),
                                    findViewById(id.card101b),
                                    findViewById(R.id.card102b),
                                    findViewById(R.id.card103b),
                                    findViewById(R.id.card104b),
                                    findViewById(R.id.card105b),
                                    findViewById(R.id.card106b),
                                    findViewById(R.id.card108b),
                                    findViewById(R.id.card109b),
                                    findViewById(R.id.card110b),
                                    findViewById(R.id.card111b),
                                    findViewById(R.id.card9b)


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
                            };




                            cardFlipped = new boolean[cards.length];
                            for (int i = 0; i < cards.length; i++) {
                                cardFlipped[i] = false;
                            }


                           shuffleCardImages();


                            ImageView cardView1 = findViewById(R.id.card1b);
                            ImageView cardView2 = findViewById(R.id.card2b);
                            ImageView cardView3 = findViewById(R.id.card3b);
                            ImageView cardView4 = findViewById(R.id.card4b);
                            ImageView cardView5 = findViewById(R.id.card5b);
                            ImageView cardView6 = findViewById(R.id.card6b);
                            ImageView cardView7 = findViewById(R.id.card7b);
                            ImageView cardView8 = findViewById(R.id.card8b);
                            ImageView cardView9 = findViewById(R.id.card9b);
                            ImageView cardView10 = findViewById(R.id.card101b);
                            ImageView cardView11 = findViewById(R.id.card102b);
                            ImageView cardView12 = findViewById(R.id.card103b);
                            ImageView cardView13 = findViewById(R.id.card104b);
                            ImageView cardView14 = findViewById(R.id.card105b);
                            ImageView cardView15 = findViewById(R.id.card106b);
                            ImageView cardView16 = findViewById(R.id.card108b);
                            ImageView cardView17 = findViewById(R.id.card109b);
                            ImageView cardView18 = findViewById(R.id.card110b);
                            ImageView cardView19 = findViewById(R.id.card111b);
                            ImageView cardView20 = findViewById(R.id.card36b);
                            ImageView cardView21 = findViewById(R.id.card35b);
                            ImageView cardView22 = findViewById(R.id.card34b);
                            ImageView cardView23 = findViewById(R.id.card33b);
                            ImageView cardView24 = findViewById(R.id.card32b);
                            ImageView cardView25 = findViewById(R.id.card31b);
                            ImageView cardView26 = findViewById(R.id.card30b);
                            ImageView cardView27 = findViewById(R.id.card29b);
                            ImageView cardView28 = findViewById(R.id.card28b);
                            ImageView cardView29 = findViewById(R.id.card27b);
                            ImageView cardView30 = findViewById(R.id.card26b);


                            int cardBackImage = R.drawable.card_back;

                            cardView1.setImageResource(cardImages[0]);
                            cardView2.setImageResource(cardImages[1]);
                            cardView3.setImageResource(cardImages[2]);
                            cardView4.setImageResource(cardImages[3]);
                            cardView5.setImageResource(cardImages[4]);
                            cardView6.setImageResource(cardImages[5]);
                            cardView7.setImageResource(cardImages[6]);
                            cardView8.setImageResource(cardImages[7]);
                            cardView9.setImageResource(cardImages[8]);
                            cardView10.setImageResource(cardImages[9]);
                            cardView11.setImageResource(cardImages[10]);
                            cardView12.setImageResource(cardImages[11]);
                            cardView13.setImageResource(cardImages[12]);
                            cardView14.setImageResource(cardImages[13]);
                            cardView15.setImageResource(cardImages[14]);
                            cardView16.setImageResource(cardImages[15]);
                            cardView17.setImageResource(cardImages[16]);
                            cardView18.setImageResource(cardImages[17]);
                            cardView19.setImageResource(cardImages[18]);
                            cardView20.setImageResource(cardImages[19]);
                            cardView21.setImageResource(cardImages[20]);
                            cardView22.setImageResource(cardImages[21]);
                            cardView23.setImageResource(cardImages[22]);
                            cardView24.setImageResource(cardImages[23]);
                            cardView25.setImageResource(cardImages[24]);
                            cardView26.setImageResource(cardImages[25]);
                            cardView27.setImageResource(cardImages[26]);
                            cardView28.setImageResource(cardImages[27]);
                            cardView29.setImageResource(cardImages[28]);
                            cardView30.setImageResource(cardImages[29]);






                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    // Hide the image after the specified duration

                                    cardView1.setImageResource(cardBackImage);
                                    cardView2.setImageResource(cardBackImage);
                                    cardView3.setImageResource(cardBackImage);
                                    cardView4.setImageResource(cardBackImage);
                                    cardView5.setImageResource(cardBackImage);
                                    cardView6.setImageResource(cardBackImage);
                                    cardView7.setImageResource(cardBackImage);
                                    cardView8.setImageResource(cardBackImage);
                                    cardView9.setImageResource(cardBackImage);
                                    cardView10.setImageResource(cardBackImage);
                                    cardView11.setImageResource(cardBackImage);
                                    cardView12.setImageResource(cardBackImage);
                                    cardView13.setImageResource(cardBackImage);
                                    cardView14.setImageResource(cardBackImage);
                                    cardView15.setImageResource(cardBackImage);
                                    cardView16.setImageResource(cardBackImage);
                                    cardView17.setImageResource(cardBackImage);
                                    cardView18.setImageResource(cardBackImage);
                                    cardView19.setImageResource(cardBackImage);
                                    cardView20.setImageResource(cardBackImage);
                                    cardView21.setImageResource(cardBackImage);
                                    cardView22.setImageResource(cardBackImage);
                                    cardView23.setImageResource(cardBackImage);
                                    cardView24.setImageResource(cardBackImage);
                                    cardView25.setImageResource(cardBackImage);
                                    cardView26.setImageResource(cardBackImage);
                                    cardView27.setImageResource(cardBackImage);
                                    cardView28.setImageResource(cardBackImage);
                                    cardView29.setImageResource(cardBackImage);
                                    cardView30.setImageResource(cardBackImage);


                                }

                            }, 900); // 3000 milliseconds (3 seconds)











                        }});

                    x5x.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View v) {
                            setContentView(R.layout.activity_game_4);
                            ImageView home = findViewById(id.returnHome);
                            home.setOnClickListener(new View.OnClickListener() {
                                public void onClick(View v) {

                                    // View menuView = getLayoutInflater().inflate(R.layout.menu_layout, null);
                                    //setContentView(menuView);
                                    // In your current activity or method

                                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

                                    startActivity(intent);

                                }
                            });
                        }});


                imageView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        setContentView(R.layout.activity_game3);

                      //  Button home1 = findViewById(id.returnHomeButton);
                        ImageView home = findViewById(id.returnHome);
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


                        ImageView cardView1 = findViewById(R.id.card1);
                        ImageView cardView2 = findViewById(R.id.card2);
                        ImageView cardView3 = findViewById(R.id.card3);
                        ImageView cardView4 = findViewById(R.id.card4);
                        ImageView cardView5 = findViewById(R.id.card5);
                        ImageView cardView6 = findViewById(R.id.card6);
                        ImageView cardView7 = findViewById(R.id.card7);
                        ImageView cardView8 = findViewById(R.id.card8);
                        ImageView cardView9 = findViewById(R.id.card9);
                        ImageView cardView10 = findViewById(R.id.card101);
                        ImageView cardView11 = findViewById(R.id.card102);
                        ImageView cardView12 = findViewById(R.id.card103);
                        ImageView cardView13 = findViewById(R.id.card104);
                        ImageView cardView14 = findViewById(R.id.card105);
                        ImageView cardView15 = findViewById(R.id.card106);
                        ImageView cardView16 = findViewById(R.id.card107);



                        int cardBackImage = R.drawable.card_back;




                        cardView1.setImageResource(cardImages[0]);
                        cardView2.setImageResource(cardImages[1]);
                        cardView3.setImageResource(cardImages[2]);
                        cardView4.setImageResource(cardImages[3]);
                        cardView5.setImageResource(cardImages[4]);
                        cardView6.setImageResource(cardImages[5]);
                        cardView7.setImageResource(cardImages[6]);
                        cardView8.setImageResource(cardImages[7]);
                        cardView9.setImageResource(cardImages[8]);
                        cardView10.setImageResource(cardImages[9]);
                        cardView11.setImageResource(cardImages[10]);
                        cardView12.setImageResource(cardImages[11]);
                        cardView13.setImageResource(cardImages[12]);
                        cardView14.setImageResource(cardImages[13]);
                        cardView15.setImageResource(cardImages[14]);
                        cardView16.setImageResource(cardImages[15]);





                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                // Hide the image after the specified duration

                                cardView1.setImageResource(cardBackImage);
                                cardView2.setImageResource(cardBackImage);
                                cardView3.setImageResource(cardBackImage);
                                cardView4.setImageResource(cardBackImage);
                                cardView5.setImageResource(cardBackImage);
                                cardView6.setImageResource(cardBackImage);
                                cardView7.setImageResource(cardBackImage);
                                cardView8.setImageResource(cardBackImage);
                                cardView9.setImageResource(cardBackImage);
                                cardView10.setImageResource(cardBackImage);
                                cardView11.setImageResource(cardBackImage);
                                cardView12.setImageResource(cardBackImage);
                                cardView13.setImageResource(cardBackImage);
                                cardView14.setImageResource(cardBackImage);
                                cardView15.setImageResource(cardBackImage);
                                cardView16.setImageResource(cardBackImage);


                            }

                        }, 900); // 3000 milliseconds (3 seconds)



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
                       // shuffleCardImages();
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
                        aa.setText("            :" + ac);

                    }
                }
            }
        }


          int ac=0;
          int ac3=0;
        private void checkForMatch () {
            if (cardImages[firstCardIndex] == cardImages[secondCardIndex]) {
                // Cards match, perform your match logic here
                // For example, hide both cards

                 int a=firstCardIndex;
                 int b=secondCardIndex;
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // Code to be executed after a 1-second delay

                        cards[a].setVisibility(View.INVISIBLE);
                        cards[b].setVisibility(View.INVISIBLE);
                    }
                }, 500); // Delay for 1 second (1000 milliseconds)







                ac++;
                ac3++;

                if (ac3==8){
                    Chronometer chronometer = findViewById(R.id.chronometer);
                    chronometer.stop();
                    Toast.makeText(getApplicationContext(), message, duration).show();
                }
                if (ac3==9){
                    Chronometer chronometer = findViewById(R.id.chronometer);
                    chronometer.start();
                }

            } else {
                int c=firstCardIndex;
                int d=secondCardIndex;
                cards[firstCardIndex].setVisibility(View.VISIBLE);
                cards[secondCardIndex].setVisibility(View.VISIBLE);
                if (ac3==9){
                    Chronometer chronometer = findViewById(R.id.chronometer);
                    chronometer.start();
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        cards[c].setImageResource(R.drawable.card_back);
                        cards[d].setImageResource(R.drawable.card_back);
                    }
                }, 500); // Delay for 1 second (1000 milliseconds)



                // Cards don't match, flip them back

                ac++;


            }

            // Reset card states
            cardFlipped[firstCardIndex] = false;
            cardFlipped[secondCardIndex] = false;
            firstCardIndex = -1;
            secondCardIndex = -1;
        }



    }















