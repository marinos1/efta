package com.example.efta;


import static java.util.concurrent.TimeUnit.SECONDS;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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


    private ViewGroup container;

    private ImageView[] cards;


    int duration = Toast.LENGTH_SHORT;



    String message = "This is Cool"+"this is the best move";

    public int[] cardImages;
    public int[] cardImages3;
    public int[] cardImages2;
    public int[] cardImages1;
    private boolean[] cardFlipped;
    private boolean isCardFlipped = false;
    private int firstCardIndex = -1;
    private int secondCardIndex = -1;


    private int moveCount = 0;

    game game = new game();

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

        ImageView btnlevels = menuView.findViewById(R.id.levels);

        ImageView btnExit = menuView.findViewById(R.id.exit);
        ImageView btnset = menuView.findViewById(id.music_setting);
        ImageView share = menuView.findViewById(id.share);
        Intent intent = new Intent(MainActivity.this, MainActivity.class);


        btnlevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Instructions" button click
                // Show instructions or navigate to the instructions screen

                setContentView(R.layout.activity_levels);

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

            }
        });


        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "Exit" button click
                finish(); // Close the app
            }
        });
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "New Game" button click
                // Start a new game or navigate to the game screen

                setContentView(R.layout.menu_arcade);
            }

        });

        btnset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle "New Game" button click
                // Start a new game or navigate to the game screen

                setContentView(R.layout.menu_arcade);
            }

        });

        // Set click listeners for the buttons
        btnNewGame.setOnClickListener(new View.OnClickListener() {
                                          @Override
                                          public void onClick(View v) {
                                              // Handle "New Game" button click
                                              // Start a new game or navigate to the game screen

                                              setContentView(R.layout.menu_arcade);

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

                                              ImageView imageView = findViewById(id.card11);
                                              ImageView imageView1 = findViewById(id.card2);
                                              ImageView x5x = findViewById(id.card3);
                                              ImageView x56 = findViewById(id.card4);

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
                                                              findViewById(R.id.c1),
                                                              findViewById(R.id.c2),
                                                              findViewById(R.id.c3),
                                                              findViewById(R.id.c4),
                                                              findViewById(R.id.c5),
                                                              findViewById(R.id.c6),
                                                              findViewById(R.id.c7),
                                                              findViewById(R.id.c8),
                                                              findViewById(R.id.c9),
                                                              findViewById(R.id.c10),
                                                              findViewById(R.id.c11),
                                                              findViewById(R.id.c12),
                                                              findViewById(R.id.c13),
                                                              findViewById(R.id.c14),
                                                              findViewById(R.id.c15),
                                                              findViewById(R.id.c16),
                                                              findViewById(R.id.c17),
                                                              findViewById(R.id.c18),
                                                              findViewById(R.id.c19),
                                                              findViewById(R.id.c20),
                                                              findViewById(R.id.c21),
                                                              findViewById(R.id.c22),
                                                              findViewById(R.id.c23),
                                                              findViewById(R.id.c24),
                                                              findViewById(R.id.c25),
                                                              findViewById(R.id.c26),
                                                              findViewById(R.id.c27),
                                                              findViewById(R.id.c28),
                                                              findViewById(R.id.c29),
                                                              findViewById(R.id.c30)


                                                              // Add two more cards here
                                                      };
                                                      int sac = 0;
                                                      // Initialize your card images (pairs)
                                                      cardImages1 = new int[]{
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
                                                              R.drawable.a7,
                                                              R.drawable.a1,
                                                              R.drawable.a2,
                                                              R.drawable.a3,
                                                              R.drawable.a4,
                                                              R.drawable.a5,
                                                              R.drawable.a6,

                                                      };


                                                      cardFlipped = new boolean[cards.length];
                                                      for (int i = 0; i < cards.length; i++) {
                                                          cardFlipped[i] = false;
                                                      }

                                                      game.shuffleCardImages(cardImages1);
                                                      game.shuffleCardImages(cardImages1);

                                                      ImageView ccardView1 = findViewById(R.id.c1);
                                                      ImageView ccardView2 = findViewById(R.id.c2);
                                                      ImageView ccardView3 = findViewById(R.id.c3);
                                                      ImageView ccardView4 = findViewById(R.id.c4);
                                                      ImageView ccardView5 = findViewById(R.id.c5);
                                                      ImageView ccardView6 = findViewById(R.id.c6);
                                                      ImageView ccardView7 = findViewById(R.id.c7);
                                                      ImageView ccardView8 = findViewById(R.id.c8);
                                                      ImageView ccardView9 = findViewById(R.id.c9);
                                                      ImageView ccardView10 = findViewById(R.id.c10);
                                                      ImageView ccardView11 = findViewById(R.id.c11);
                                                      ImageView ccardView12 = findViewById(R.id.c12);
                                                      ImageView ccardView13 = findViewById(R.id.c13);
                                                      ImageView ccardView14 = findViewById(R.id.c14);
                                                      ImageView ccardView15 = findViewById(R.id.c15);
                                                      ImageView ccardView16 = findViewById(R.id.c16);
                                                      ImageView ccardView17 = findViewById(R.id.c17);
                                                      ImageView ccardView18 = findViewById(R.id.c18);
                                                      ImageView ccardView19 = findViewById(R.id.c19);
                                                      ImageView ccardView20 = findViewById(R.id.c20);
                                                      ImageView ccardView21 = findViewById(R.id.c21);
                                                      ImageView ccardView22 = findViewById(R.id.c22);
                                                      ImageView ccardView23 = findViewById(R.id.c23);
                                                      ImageView ccardView24 = findViewById(R.id.c24);
                                                      ImageView ccardView25 = findViewById(R.id.c25);
                                                      ImageView ccardView26 = findViewById(R.id.c26);
                                                      ImageView ccardView27 = findViewById(R.id.c27);
                                                      ImageView ccardView28 = findViewById(R.id.c28);
                                                      ImageView ccardView29 = findViewById(R.id.c29);
                                                      ImageView ccardView30 = findViewById(R.id.c30);


                                                      int cardBackImage = R.drawable.card_back;

                                                      ccardView1.setImageResource(cardImages1[0]);
                                                      ccardView2.setImageResource(cardImages1[1]);
                                                      ccardView3.setImageResource(cardImages1[2]);
                                                      ccardView4.setImageResource(cardImages1[3]);
                                                      ccardView5.setImageResource(cardImages1[4]);
                                                      ccardView6.setImageResource(cardImages1[5]);
                                                      ccardView7.setImageResource(cardImages1[6]);
                                                      ccardView8.setImageResource(cardImages1[7]);
                                                      ccardView9.setImageResource(cardImages1[8]);
                                                      ccardView10.setImageResource(cardImages1[9]);
                                                      ccardView11.setImageResource(cardImages1[10]);
                                                      ccardView12.setImageResource(cardImages1[11]);
                                                      ccardView13.setImageResource(cardImages1[12]);
                                                      ccardView14.setImageResource(cardImages1[13]);
                                                      ccardView15.setImageResource(cardImages1[14]);
                                                      ccardView16.setImageResource(cardImages1[15]);
                                                      ccardView17.setImageResource(cardImages1[16]);
                                                      ccardView18.setImageResource(cardImages1[17]);
                                                      ccardView19.setImageResource(cardImages1[18]);
                                                      ccardView20.setImageResource(cardImages1[19]);
                                                      ccardView21.setImageResource(cardImages1[20]);
                                                      ccardView22.setImageResource(cardImages1[21]);
                                                      ccardView23.setImageResource(cardImages1[22]);
                                                      ccardView24.setImageResource(cardImages1[23]);
                                                      ccardView25.setImageResource(cardImages1[24]);
                                                      ccardView26.setImageResource(cardImages1[25]);
                                                      ccardView27.setImageResource(cardImages1[26]);
                                                      ccardView28.setImageResource(cardImages1[27]);
                                                      ccardView29.setImageResource(cardImages1[28]);
                                                      ccardView30.setImageResource(cardImages1[29]);


                                                      new Handler().postDelayed(new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              // Hide the image after the specified duration

                                                              ccardView1.setImageResource(cardBackImage);
                                                              ccardView2.setImageResource(cardBackImage);
                                                              ccardView3.setImageResource(cardBackImage);
                                                              ccardView4.setImageResource(cardBackImage);
                                                              ccardView5.setImageResource(cardBackImage);
                                                              ccardView6.setImageResource(cardBackImage);
                                                              ccardView7.setImageResource(cardBackImage);
                                                              ccardView8.setImageResource(cardBackImage);
                                                              ccardView9.setImageResource(cardBackImage);
                                                              ccardView10.setImageResource(cardBackImage);
                                                              ccardView11.setImageResource(cardBackImage);
                                                              ccardView12.setImageResource(cardBackImage);
                                                              ccardView13.setImageResource(cardBackImage);
                                                              ccardView14.setImageResource(cardBackImage);
                                                              ccardView15.setImageResource(cardBackImage);
                                                              ccardView16.setImageResource(cardBackImage);
                                                              ccardView17.setImageResource(cardBackImage);
                                                              ccardView18.setImageResource(cardBackImage);
                                                              ccardView19.setImageResource(cardBackImage);
                                                              ccardView20.setImageResource(cardBackImage);
                                                              ccardView21.setImageResource(cardBackImage);
                                                              ccardView22.setImageResource(cardBackImage);
                                                              ccardView23.setImageResource(cardBackImage);
                                                              ccardView24.setImageResource(cardBackImage);
                                                              ccardView25.setImageResource(cardBackImage);
                                                              ccardView26.setImageResource(cardBackImage);
                                                              ccardView27.setImageResource(cardBackImage);
                                                              ccardView28.setImageResource(cardBackImage);
                                                              ccardView29.setImageResource(cardBackImage);
                                                              ccardView30.setImageResource(cardBackImage);


                                                          }

                                                      }, 900); // 3000 milliseconds (3 seconds)


                                                  }
                                              });


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

                                                      Chronometer chronometer = findViewById(R.id.chronometer);
                                                      chronometer.setBase(SystemClock.elapsedRealtime());
                                                      chronometer.start();
                                                      cards = new ImageView[]{
                                                              findViewById(R.id.e1),
                                                              findViewById(R.id.e2),
                                                              findViewById(R.id.e3),
                                                              findViewById(R.id.e4),
                                                              findViewById(R.id.e5),
                                                              findViewById(R.id.e6),
                                                              findViewById(R.id.e7),
                                                              findViewById(R.id.e8),
                                                              findViewById(R.id.e9),
                                                              findViewById(R.id.e10),
                                                              findViewById(R.id.e11),
                                                              findViewById(R.id.e12),
                                                              findViewById(R.id.e13),
                                                              findViewById(R.id.e14),
                                                              findViewById(R.id.e15),
                                                              findViewById(R.id.e16),
                                                              findViewById(R.id.e17),
                                                              findViewById(R.id.e18),
                                                              findViewById(R.id.e19),
                                                              findViewById(R.id.e20),


                                                              // Add two more cards here
                                                      };

                                                      // Initialize your card images (pairs)
                                                      cardImages3 = new int[]{
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
                                                              R.drawable.a7,
                                                              R.drawable.a8,
                                                              R.drawable.a7,
                                                              R.drawable.a8,

                                                      };


                                                      cardFlipped = new boolean[cards.length];
                                                      for (int i = 0; i < cards.length; i++) {
                                                          cardFlipped[i] = false;
                                                      }


                                                      game.shuffleCardImages(cardImages3);
                                                      game.shuffleCardImages(cardImages3);

                                                      ImageView ecardView1 = findViewById(R.id.e1);
                                                      ImageView ecardView2 = findViewById(R.id.e2);
                                                      ImageView ecardView3 = findViewById(R.id.e3);
                                                      ImageView ecardView4 = findViewById(R.id.e4);
                                                      ImageView ecardView5 = findViewById(R.id.e5);
                                                      ImageView ecardView6 = findViewById(R.id.e6);
                                                      ImageView ecardView7 = findViewById(R.id.e7);
                                                      ImageView ecardView8 = findViewById(R.id.e8);
                                                      ImageView ecardView9 = findViewById(R.id.e9);
                                                      ImageView ecardView10 = findViewById(R.id.e10);
                                                      ImageView ecardView11 = findViewById(R.id.e11);
                                                      ImageView ecardView12 = findViewById(R.id.e12);
                                                      ImageView ecardView13 = findViewById(R.id.e13);
                                                      ImageView ecardView14 = findViewById(R.id.e14);
                                                      ImageView ecardView15 = findViewById(R.id.e15);
                                                      ImageView ecardView16 = findViewById(R.id.e16);
                                                      ImageView ecardView17 = findViewById(R.id.e17);
                                                      ImageView ecardView18 = findViewById(R.id.e18);
                                                      ImageView ecardView19 = findViewById(R.id.e19);
                                                      ImageView ecardView20 = findViewById(R.id.e20);


                                                      int cardBackImage = R.drawable.card_back;


                                                      ecardView1.setImageResource(cardImages3[0]);
                                                      ecardView2.setImageResource(cardImages3[1]);
                                                      ecardView3.setImageResource(cardImages3[2]);
                                                      ecardView4.setImageResource(cardImages3[3]);
                                                      ecardView5.setImageResource(cardImages3[4]);
                                                      ecardView6.setImageResource(cardImages3[5]);
                                                      ecardView7.setImageResource(cardImages3[6]);
                                                      ecardView8.setImageResource(cardImages3[7]);
                                                      ecardView9.setImageResource(cardImages3[8]);
                                                      ecardView10.setImageResource(cardImages3[9]);
                                                      ecardView11.setImageResource(cardImages3[10]);
                                                      ecardView12.setImageResource(cardImages3[11]);
                                                      ecardView13.setImageResource(cardImages3[12]);
                                                      ecardView14.setImageResource(cardImages3[13]);
                                                      ecardView15.setImageResource(cardImages3[14]);
                                                      ecardView16.setImageResource(cardImages3[15]);
                                                      ecardView17.setImageResource(cardImages3[16]);
                                                      ecardView18.setImageResource(cardImages3[17]);
                                                      ecardView19.setImageResource(cardImages3[18]);
                                                      ecardView20.setImageResource(cardImages3[19]);


                                                      new Handler().postDelayed(new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              // Hide the image after the specified duration

                                                              ecardView1.setImageResource(cardBackImage);
                                                              ecardView2.setImageResource(cardBackImage);
                                                              ecardView3.setImageResource(cardBackImage);
                                                              ecardView4.setImageResource(cardBackImage);
                                                              ecardView5.setImageResource(cardBackImage);
                                                              ecardView6.setImageResource(cardBackImage);
                                                              ecardView7.setImageResource(cardBackImage);
                                                              ecardView8.setImageResource(cardBackImage);
                                                              ecardView9.setImageResource(cardBackImage);
                                                              ecardView10.setImageResource(cardBackImage);
                                                              ecardView11.setImageResource(cardBackImage);
                                                              ecardView12.setImageResource(cardBackImage);
                                                              ecardView13.setImageResource(cardBackImage);
                                                              ecardView14.setImageResource(cardBackImage);
                                                              ecardView15.setImageResource(cardBackImage);
                                                              ecardView16.setImageResource(cardBackImage);
                                                              ecardView17.setImageResource(cardBackImage);
                                                              ecardView18.setImageResource(cardBackImage);
                                                              ecardView19.setImageResource(cardBackImage);
                                                              ecardView20.setImageResource(cardBackImage);


                                                          }

                                                      }, 900); // 3000 milliseconds (3 seconds)


                                                  }
                                              });


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


                                                      game.shuffleCardImages(cardImages);
                                                      game.shuffleCardImages(cardImages);

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
                                                              findViewById(R.id.d1),
                                                              findViewById(R.id.d2),
                                                              findViewById(R.id.d3),
                                                              findViewById(R.id.d4),
                                                              findViewById(R.id.d5),
                                                              findViewById(R.id.d6),
                                                              findViewById(R.id.d7),
                                                              findViewById(R.id.d8),
                                                              findViewById(R.id.d9),
                                                              findViewById(R.id.d10),
                                                              findViewById(R.id.d11),
                                                              findViewById(R.id.d12),
                                                              findViewById(R.id.d13),
                                                              findViewById(R.id.d14),
                                                              findViewById(R.id.d15),
                                                              findViewById(R.id.d16),
                                                              findViewById(R.id.d17),
                                                              findViewById(R.id.d18),
                                                              findViewById(R.id.d19),
                                                              findViewById(R.id.d20),
                                                              findViewById(R.id.d21),
                                                              findViewById(R.id.d22),
                                                              findViewById(R.id.d23),
                                                              findViewById(R.id.d24),
                                                              findViewById(R.id.d25),
                                                              findViewById(R.id.d26),
                                                              findViewById(R.id.d27),
                                                              findViewById(R.id.d28),
                                                              findViewById(R.id.d29),
                                                              findViewById(R.id.d30),
                                                              findViewById(R.id.d31),
                                                              findViewById(R.id.d32),
                                                              findViewById(R.id.d33),
                                                              findViewById(R.id.d34),
                                                              findViewById(R.id.d35),
                                                              findViewById(R.id.d36),

                                                              // Add two more cards here
                                                      };

                                                      // Initialize your card images (pairs)
                                                      cardImages2 = new int[]{
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
                                                              R.drawable.a8,
                                                              R.drawable.a6,
                                                              R.drawable.a6,
                                                              R.drawable.a8,
                                                              R.drawable.a8,
                                                      };


                                                      cardFlipped = new boolean[cards.length];
                                                      for (int i = 0; i < cards.length; i++) {
                                                          cardFlipped[i] = false;
                                                      }


                                                      game.shuffleCardImages(cardImages2);
                                                      game.shuffleCardImages(cardImages2);

                                                      ImageView dcardView1 = findViewById(R.id.d1);
                                                      ImageView dcardView2 = findViewById(R.id.d2);
                                                      ImageView dcardView3 = findViewById(R.id.d3);
                                                      ImageView dcardView4 = findViewById(R.id.d4);
                                                      ImageView dcardView5 = findViewById(R.id.d5);
                                                      ImageView dcardView6 = findViewById(R.id.d6);
                                                      ImageView dcardView7 = findViewById(R.id.d7);
                                                      ImageView dcardView8 = findViewById(R.id.d8);
                                                      ImageView dcardView9 = findViewById(R.id.d9);
                                                      ImageView dcardView10 = findViewById(R.id.d10);
                                                      ImageView dcardView11 = findViewById(R.id.d11);
                                                      ImageView dcardView12 = findViewById(R.id.d12);
                                                      ImageView dcardView13 = findViewById(R.id.d13);
                                                      ImageView dcardView14 = findViewById(R.id.d14);
                                                      ImageView dcardView15 = findViewById(R.id.d15);
                                                      ImageView dcardView16 = findViewById(R.id.d16);
                                                      ImageView dcardView17 = findViewById(R.id.d17);
                                                      ImageView dcardView18 = findViewById(R.id.d18);
                                                      ImageView dcardView19 = findViewById(R.id.d19);
                                                      ImageView dcardView20 = findViewById(R.id.d20);
                                                      ImageView dcardView21 = findViewById(R.id.d21);
                                                      ImageView dcardView22 = findViewById(R.id.d22);
                                                      ImageView dcardView23 = findViewById(R.id.d23);
                                                      ImageView dcardView24 = findViewById(R.id.d24);
                                                      ImageView dcardView25 = findViewById(R.id.d25);
                                                      ImageView dcardView26 = findViewById(R.id.d26);
                                                      ImageView dcardView27 = findViewById(R.id.d27);
                                                      ImageView dcardView28 = findViewById(R.id.d28);
                                                      ImageView dcardView29 = findViewById(R.id.d29);
                                                      ImageView dcardView30 = findViewById(R.id.d30);
                                                      ImageView dcardView31 = findViewById(R.id.d31);
                                                      ImageView dcardView32 = findViewById(R.id.d32);
                                                      ImageView dcardView33 = findViewById(R.id.d33);
                                                      ImageView dcardView34 = findViewById(R.id.d34);
                                                      ImageView dcardView35 = findViewById(R.id.d35);
                                                      ImageView dcardView36 = findViewById(R.id.d36);


                                                      int cardBackImage = R.drawable.card_back;


                                                      dcardView1.setImageResource(cardImages2[0]);
                                                      dcardView2.setImageResource(cardImages2[1]);
                                                      dcardView3.setImageResource(cardImages2[2]);
                                                      dcardView4.setImageResource(cardImages2[3]);
                                                      dcardView5.setImageResource(cardImages2[4]);
                                                      dcardView6.setImageResource(cardImages2[5]);
                                                      dcardView7.setImageResource(cardImages2[6]);
                                                      dcardView8.setImageResource(cardImages2[7]);
                                                      dcardView9.setImageResource(cardImages2[8]);
                                                      dcardView10.setImageResource(cardImages2[9]);
                                                      dcardView11.setImageResource(cardImages2[10]);
                                                      dcardView12.setImageResource(cardImages2[11]);
                                                      dcardView13.setImageResource(cardImages2[12]);
                                                      dcardView14.setImageResource(cardImages2[13]);
                                                      dcardView15.setImageResource(cardImages2[14]);
                                                      dcardView16.setImageResource(cardImages2[15]);
                                                      dcardView17.setImageResource(cardImages2[16]);
                                                      dcardView18.setImageResource(cardImages2[17]);
                                                      dcardView19.setImageResource(cardImages2[18]);
                                                      dcardView20.setImageResource(cardImages2[19]);
                                                      dcardView21.setImageResource(cardImages2[20]);
                                                      dcardView22.setImageResource(cardImages2[21]);
                                                      dcardView23.setImageResource(cardImages2[22]);
                                                      dcardView24.setImageResource(cardImages2[23]);
                                                      dcardView25.setImageResource(cardImages2[24]);
                                                      dcardView26.setImageResource(cardImages2[25]);
                                                      dcardView27.setImageResource(cardImages2[26]);
                                                      dcardView28.setImageResource(cardImages2[27]);
                                                      dcardView29.setImageResource(cardImages2[28]);
                                                      dcardView30.setImageResource(cardImages2[29]);
                                                      dcardView31.setImageResource(cardImages2[30]);
                                                      dcardView32.setImageResource(cardImages2[31]);
                                                      dcardView33.setImageResource(cardImages2[32]);
                                                      dcardView34.setImageResource(cardImages2[33]);
                                                      dcardView35.setImageResource(cardImages2[34]);
                                                      dcardView36.setImageResource(cardImages2[35]);


                                                      new Handler().postDelayed(new Runnable() {
                                                          @Override
                                                          public void run() {
                                                              // Hide the image after the specified duration

                                                              dcardView1.setImageResource(cardBackImage);
                                                              dcardView2.setImageResource(cardBackImage);
                                                              dcardView3.setImageResource(cardBackImage);
                                                              dcardView4.setImageResource(cardBackImage);
                                                              dcardView5.setImageResource(cardBackImage);
                                                              dcardView6.setImageResource(cardBackImage);
                                                              dcardView7.setImageResource(cardBackImage);
                                                              dcardView8.setImageResource(cardBackImage);
                                                              dcardView9.setImageResource(cardBackImage);
                                                              dcardView10.setImageResource(cardBackImage);
                                                              dcardView11.setImageResource(cardBackImage);
                                                              dcardView12.setImageResource(cardBackImage);
                                                              dcardView13.setImageResource(cardBackImage);
                                                              dcardView14.setImageResource(cardBackImage);
                                                              dcardView15.setImageResource(cardBackImage);
                                                              dcardView16.setImageResource(cardBackImage);
                                                              dcardView17.setImageResource(cardBackImage);
                                                              dcardView18.setImageResource(cardBackImage);
                                                              dcardView19.setImageResource(cardBackImage);
                                                              dcardView20.setImageResource(cardBackImage);
                                                              dcardView21.setImageResource(cardBackImage);
                                                              dcardView22.setImageResource(cardBackImage);
                                                              dcardView23.setImageResource(cardBackImage);
                                                              dcardView24.setImageResource(cardBackImage);
                                                              dcardView25.setImageResource(cardBackImage);
                                                              dcardView26.setImageResource(cardBackImage);
                                                              dcardView27.setImageResource(cardBackImage);
                                                              dcardView28.setImageResource(cardBackImage);
                                                              dcardView29.setImageResource(cardBackImage);
                                                              dcardView30.setImageResource(cardBackImage);
                                                              dcardView31.setImageResource(cardBackImage);
                                                              dcardView32.setImageResource(cardBackImage);
                                                              dcardView33.setImageResource(cardBackImage);
                                                              dcardView34.setImageResource(cardBackImage);
                                                              dcardView35.setImageResource(cardBackImage);
                                                              dcardView36.setImageResource(cardBackImage);
                                                              ;


                                                          }

                                                      }, 900); // 3000 milliseconds (3 seconds)


                                                  }
                                              });






                                          }});

    }

                int ac = 0;
                int ac3 = 0;
                int sac = 0;

                public void onCardClick (View view){
                    if (!isCardFlipped) {
                        int cardIndex = -1;
                        for (int i = 0; i < cards.length; i++) {
                            if (cards[i] == view) {
                                cardIndex = i;
                                break;
                            }
                        }
                        if (cards.length == 16) {
                            if (cardIndex != -1 && !cardFlipped[cardIndex]) {
                                ((ImageView) view).setImageResource(cardImages[cardIndex]);
                                cardFlipped[cardIndex] = true;

                                if (firstCardIndex == -1) {
                                    firstCardIndex = cardIndex;
                                } else {
                                    secondCardIndex = cardIndex;

                                    checkForMatch();


                                    int a = game.firstCardIndex;
                                    int b = game.secondCardIndex;
                                    TextView aa = findViewById(R.id.moveCountTextView);
                                    aa.setText("             :" + ac);
                                }

                            }
                        }
                        if (cards.length == 30) {
                            if (cardIndex != -1 && !cardFlipped[cardIndex]) {
                                ((ImageView) view).setImageResource(cardImages1[cardIndex]);
                                cardFlipped[cardIndex] = true;

                                if (firstCardIndex == -1) {
                                    firstCardIndex = cardIndex;
                                } else {
                                    secondCardIndex = cardIndex;


                                    checkForMatch1();


                                    int a = game.firstCardIndex;
                                    int b = game.secondCardIndex;
                                    TextView aa = findViewById(R.id.moveCountTextView);
                                    aa.setText("             :" + ac);
                                }

                            }
                        }
                        if (cards.length == 36) {
                            if (cardIndex != -1 && !cardFlipped[cardIndex]) {
                                ((ImageView) view).setImageResource(cardImages2[cardIndex]);
                                cardFlipped[cardIndex] = true;

                                if (firstCardIndex == -1) {
                                    firstCardIndex = cardIndex;
                                } else {
                                    secondCardIndex = cardIndex;


                                    checkForMatch2();


                                    int a = game.firstCardIndex;
                                    int b = game.secondCardIndex;
                                    TextView aa = findViewById(R.id.moveCountTextView);
                                    aa.setText("             :" + ac);
                                }

                            }
                        }
                        if (cards.length == 20) {
                            if (cardIndex != -1 && !cardFlipped[cardIndex]) {
                                ((ImageView) view).setImageResource(cardImages3[cardIndex]);
                                cardFlipped[cardIndex] = true;

                                if (firstCardIndex == -1) {
                                    firstCardIndex = cardIndex;
                                } else {
                                    secondCardIndex = cardIndex;


                                    checkForMatch3();


                                    int a = game.firstCardIndex;
                                    int b = game.secondCardIndex;
                                    TextView aa = findViewById(R.id.moveCountTextView);
                                    aa.setText("             :" + ac);
                                }

                            }
                        }



                    }
                }


                private void checkForMatch () {
                    if (cardImages[firstCardIndex] == cardImages[secondCardIndex]) {
                        // Cards match, perform your match logic here
                        // For example, hide both cards

                        int a = firstCardIndex;
                        int b = secondCardIndex;
                        for (int n=0; n<15; )
                        {
                            n++;
                            cards[n].setFocusable(false);
                            cards[n].setClickable(false);

                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //   Code to be executed after a 1-second delay

                                cards[a].setVisibility(View.INVISIBLE);
                                cards[b].setVisibility(View.INVISIBLE);
                                for (int n=0; n<15; )
                                {
                                    n++;
                                    cards[n].setFocusable(true);
                                    cards[n].setClickable(true);

                                }
                            }
                        }, 400); // Delay for 1 second (1000 milliseconds)


                        ac++;
                        ac3++;

                        if (ac3 == 8) {
                            Chronometer chronometer = findViewById(R.id.chronometer);
                            chronometer.stop();
                            Toast.makeText(getApplicationContext(), message, duration).show();
                            sac++;
                            SharedPreferences preferences = getSharedPreferences("GameStats", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = preferences.edit();

                            String time = chronometer.getText().toString();
                            String gameTime = time; // Example time in milliseconds
                            int totalMoves = ac;  // Example number of moves

                            editor.putString("Time", gameTime);
                            editor.putInt("Moves", totalMoves);

                            editor.apply(); // or editor.commit() if you want immediate write


                        }


                    } else {
                        int c = firstCardIndex;
                        int d = secondCardIndex;
                        cards[firstCardIndex].setVisibility(View.VISIBLE);
                        cards[secondCardIndex].setVisibility(View.VISIBLE);

                      for (int n=0; n<15; )
                        {
                            n++;
                            cards[n].setFocusable(false);
                            cards[n].setClickable(false);

                        }
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cards[c].setImageResource(R.drawable.card_back);
                                cards[d].setImageResource(R.drawable.card_back);
                                for (int n=0; n<15; )
                                {
                                    n++;
                                    cards[n].setFocusable(true);
                                    cards[n].setClickable(true);

                                }
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



                private void checkForMatch1 () {
                    if (cardImages1[firstCardIndex] == cardImages1[secondCardIndex]) {
                        // Cards match, perform your match logic here
                        // For example, hide both cards

                        int a = firstCardIndex;
                        int b = secondCardIndex;
                        for (int n=0; n<29; )
                        {
                            n++;
                            cards[n].setFocusable(false);
                            cards[n].setClickable(false);

                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //   Code to be executed after a 1-second delay

                                cards[a].setVisibility(View.INVISIBLE);
                                cards[b].setVisibility(View.INVISIBLE);
                                for (int n=0; n<29; )
                                {
                                    n++;
                                    cards[n].setFocusable(true);
                                    cards[n].setClickable(true);

                                }
                            }
                        }, 400); // Delay for 1 second (1000 milliseconds)


                        ac++;
                        ac3++;

                        if (ac3 == 15) {
                            Chronometer chronometer = findViewById(R.id.chronometer);
                            chronometer.stop();
                          Toast.makeText(getApplicationContext(), message, duration).show();


                        }


                    } else {
                        int c = firstCardIndex;
                        int d = secondCardIndex;
                        cards[firstCardIndex].setVisibility(View.VISIBLE);
                        cards[secondCardIndex].setVisibility(View.VISIBLE);

                        for (int n=0; n<29; )
                        {
                            n++;
                            cards[n].setFocusable(false);
                            cards[n].setClickable(false);

                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cards[c].setImageResource(R.drawable.card_back);
                                cards[d].setImageResource(R.drawable.card_back);
                                for (int n=0; n<29; )
                                {
                                    n++;
                                    cards[n].setFocusable(true);
                                    cards[n].setClickable(true);

                                }
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

                private void checkForMatch2 () {
                    if (cardImages2[firstCardIndex] == cardImages2[secondCardIndex]) {
                        // Cards match, perform your match logic here
                        // For example, hide both cards

                        int a = firstCardIndex;
                        int b = secondCardIndex;
                        for (int n=0; n<35; )
                        {
                            n++;
                            cards[n].setFocusable(false);
                            cards[n].setClickable(false);

                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                //   Code to be executed after a 1-second delay

                                cards[a].setVisibility(View.INVISIBLE);
                                cards[b].setVisibility(View.INVISIBLE);
                                for (int n=0; n<35; )
                                {
                                    n++;
                                    cards[n].setFocusable(true);
                                    cards[n].setClickable(true);

                                }
                            }
                        }, 400); // Delay for 1 second (1000 milliseconds)


                        ac++;
                        ac3++;

                        if (ac3 == 18) {
                            Chronometer chronometer = findViewById(R.id.chronometer);
                            chronometer.stop();
                           Toast.makeText(getApplicationContext(), message, duration).show();


                        }


                    } else {
                        int c = firstCardIndex;
                        int d = secondCardIndex;
                        cards[firstCardIndex].setVisibility(View.VISIBLE);
                        cards[secondCardIndex].setVisibility(View.VISIBLE);
                        for (int n=0; n<35; )
                        {
                            n++;
                            cards[n].setFocusable(false);
                            cards[n].setClickable(false);

                        }

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                cards[c].setImageResource(R.drawable.card_back);
                                cards[d].setImageResource(R.drawable.card_back);
                                for (int n=0; n<35; )
                                {
                                    n++;
                                    cards[n].setFocusable(true);
                                    cards[n].setClickable(true);

                                }
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


    private void checkForMatch3 () {
        if (cardImages3[firstCardIndex] == cardImages3[secondCardIndex]) {
            // Cards match, perform your match logic here
            // For example, hide both cards

            int a = firstCardIndex;
            int b = secondCardIndex;
            for (int n=0; n<19; )
            {
                n++;
                cards[n].setFocusable(false);
                cards[n].setClickable(false);

            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    //   Code to be executed after a 1-second delay

                    cards[a].setVisibility(View.INVISIBLE);
                    cards[b].setVisibility(View.INVISIBLE);
                    for (int n=0; n<19; )
                    {
                        n++;
                        cards[n].setFocusable(true);
                        cards[n].setClickable(true);

                    }

                }
            }, 400); // Delay for 1 second (1000 milliseconds)


            ac++;
            ac3++;

            if (ac3 == 10) {
                Chronometer chronometer = findViewById(R.id.chronometer);
                chronometer.stop();
               Toast.makeText(getApplicationContext(), message, duration).show();


            }


        } else {
            int c = firstCardIndex;
            int d = secondCardIndex;
            cards[firstCardIndex].setVisibility(View.VISIBLE);
            cards[secondCardIndex].setVisibility(View.VISIBLE);
            for (int n=0; n<19; )
            {
                n++;
                cards[n].setFocusable(false);
                cards[n].setClickable(false);

            }

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    cards[c].setImageResource(R.drawable.card_back);
                    cards[d].setImageResource(R.drawable.card_back);
                    for (int n=0; n<19; )
                    {
                        n++;
                        cards[n].setFocusable(true);
                        cards[n].setClickable(true);

                    }

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


















