package com.example.courseprojectandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    Button btn_a_up, btn_b_up, btn_c_up, btn_d_up,
            btn_a_down, btn_b_down, btn_c_down, btn_d_down;
    Button guess, restart;
    TextView numb_a, numb_b, numb_c, numb_d;
    TextView info_tview, output_tview;

    Random n;
    int guessA=1,guessB=2,guessC=3,guessD=4;
    int ranA,ranB,ranC,ranD;
    int bulls= 0,cows =0;
    int tries = 0;
    int wins = 0;

    String output = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btn_a_down = findViewById(R.id.btn_a_down);
        btn_b_down = findViewById(R.id.btn_b_down);
        btn_c_down = findViewById(R.id.btn_c_down);
        btn_d_down = findViewById(R.id.btn_d_down);

        btn_a_up = findViewById(R.id.btn_a_up);
        btn_b_up = findViewById(R.id.btn_b_up);
        btn_c_up = findViewById(R.id.btn_c_up);
        btn_d_up = findViewById(R.id.btn_d_up);

        guess = findViewById(R.id.guess);
        restart = findViewById(R.id.restart);

        numb_a = findViewById(R.id.numb_a);
        numb_b = findViewById(R.id.numb_b);
        numb_c = findViewById(R.id.numb_c);
        numb_d = findViewById(R.id.numb_d);

        info_tview = findViewById(R.id.info_tview);
        output_tview = findViewById(R.id.output_tview);

        n= new Random();

        randomNumbers();



        btn_a_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessA > 1)
                {
                    guessA--;
                }
                numb_a.setText("" + guessA);
            }
        });
        btn_b_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessB > 1)
                {
                    guessB--;
                }
                numb_b.setText("" + guessB);

            }
        });
        btn_c_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessC > 1)
                {
                    guessC--;
                }
                numb_c.setText("" + guessC);
            }
        });
        btn_d_down.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessD > 1)
                {
                    guessD--;
                }
                numb_d.setText("" + guessD);
            }
        });

        btn_a_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessA < 9)
                {
                    guessA++;
                }
                numb_a.setText("" + guessA);
            }
        });
        btn_b_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessB < 9 )
                {
                    guessB++;
                }
                numb_b.setText("" + guessB);
            }
        });
        btn_c_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessC < 9 )
                {
                    guessC++;
                }
                numb_c.setText("" + guessC);
            }
        });
        btn_d_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(guessD < 9 )
                {
                    guessD++;
                }
                numb_d.setText("" + guessD);
            }
        });


        //RESTARTS the Game
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_tview.setText("You lost, the number is: " + ranA + "" + ranB + "" + ranC + "" + ranD);
                randomNumbers();
                output = "";
                output_tview.setText(output);
                tries = 0;
                wins= 0;
            }
        });

        guess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info_tview.setText("");
                if (ranA == ranB || ranA == ranC || ranA == ranD ||
                                    ranB == ranC || ranB== ranD ||
                                                    ranC == ranD
                ){info_tview.setText("Wrong guess!");
                }else{
                    tries++;
                    bulls = 0;
                    cows = 0;
                    checkNumbers();
                    win();
                }
            }
        });
    }

    private void checkNumbers(){
        //bulls
        if(guessA == ranA){
        bulls++;
        }
        if(guessB == ranB){
            bulls++;
        }
        if(guessC == ranC){
            bulls++;
        }
        if(guessD == ranD){
            bulls++;
        }

        //cows
        if(guessA == ranB ||guessA ==ranC ||guessA==ranD){
            cows++;
        }
        if(guessB == ranA ||guessB ==ranC ||guessB==ranD){
            cows++;
        }
        if(guessC == ranB ||guessC ==ranA ||guessC==ranD){
            cows++;
        }
        if(guessD == ranB ||guessD ==ranC ||guessD==ranA){
            cows++;
        }

        output = output + "" + tries + ". "+ guessA + "" + guessB+ "" + guessC+ "" + guessD + " - Bulls: "+ bulls + " Cows:" + cows + "\n";
        output_tview.setText(output);
    }

    private void randomNumbers(){
        //generates the first digit
        ranA = n.nextInt(9) + 1;

        //second digit
        do {
            ranB=n.nextInt(9)+1;
        }while(ranB == ranA);

        //third digit
        do {
            ranC=n.nextInt(9)+1;
        }while(ranC == ranA || ranC==ranB);

        //fourth digit
        do {
            ranD=n.nextInt(9)+1;
        }while(ranD == ranA || ranD == ranB || ranD == ranC);
    }
    private void win(){
        if (bulls == 4){
            wins++;
            info_tview.setText("You won in: " + tries + " tries! Now you have: " + wins + " wins!");
            randomNumbers();
            output = "";
            output_tview.setText(output);
            tries = 0;
        }

    }
}