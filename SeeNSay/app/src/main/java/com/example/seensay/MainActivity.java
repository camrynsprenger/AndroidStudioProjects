package com.example.seensay;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import android.graphics.Color;

import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    ImageView cow4;
    ImageView cow2;
    ImageView cow5;
    ImageView cow6;
    ImageView cow7;
    ImageView cow8;
    ImageView cow9;
    ImageView cow10;
    ImageView cow11;
    ImageView cow12;
    ImageView cow13;
    ImageView cow14;
    ImageView cow2pane;
    ImageView cow4pane;
    ImageView cow5pane;
    ImageView cow6pane;
    ImageView cow7pane;
    ImageView cow8pane;
    ImageView cow9pane;
    ImageView cow10pane;
    ImageView cow11pane;
    ImageView cow12pane;
    ImageView cow13pane;
    ImageView cow14pane;
    ImageView[] cows;
    int rando1;




    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cow2 = findViewById(R.id.cow2);
        cow4 = findViewById(R.id.cow4);
        cow5 = findViewById(R.id.cow5);
        cow6 = findViewById(R.id.cow6);
        cow7 = findViewById(R.id.cow7);
        cow8 = findViewById(R.id.cow8);
        cow9 = findViewById(R.id.cow9);
        cow10 = findViewById(R.id.cow10);
        cow11 = findViewById(R.id.cow11);
        cow12 = findViewById(R.id.cow12);
        cow13 = findViewById(R.id.cow13);
        cow14 = findViewById(R.id.cow14);

        button1 = findViewById(R.id.button1);

        cow2pane = findViewById(R.id.cow2pane);
        cow4pane = findViewById(R.id.cow4pane);
        cow5pane = findViewById(R.id.cow5pane);
        cow6pane = findViewById(R.id.cow6pane);
        cow7pane = findViewById(R.id.cow7pane);
        cow8pane = findViewById(R.id.cow8pane);
        cow9pane = findViewById(R.id.cow9pane);
        cow10pane = findViewById(R.id.cow10pane);
        cow11pane = findViewById(R.id.cow11pane);
        cow12pane = findViewById(R.id.cow12pane);
        cow13pane = findViewById(R.id.cow13pane);
        cow14pane = findViewById(R.id.cow14pane);

        cows = new ImageView[12];
        cows[0] = cow2pane;
        cows[1] = cow4pane;
        cows[2] = cow5pane;
        cows[3] = cow6pane;
        cows[4] = cow7pane;
        cows[5] = cow8pane;
        cows[6] = cow9pane;
        cows[7] = cow10pane;
        cows[8] = cow11pane;
        cows[9] = cow12pane;
        cows[10] = cow13pane;
        cows[11] = cow14pane;
        button1.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.M)

            @Override
            public void onClick(View v) {
                rando1 = 0;
                button1.setClickable(false);
                for (int i = 0; i < 12; i++) {
                    cows[i].setBackgroundColor(-65281);
                    cows[i].getBackground().setAlpha(0);
                }

                final Runnable flash = new Runnable() {
                    public void run() {
                        cows[rando1].setBackgroundColor(-65281);
                        cows[rando1].getBackground().setAlpha(0);
                        int rando2 = (int) (Math.random() * (12));
                        while (rando2 == rando1) {
                            rando2 = (int) (Math.random() * (12));
                        }
                        rando1 = rando2;
                        cows[rando1].setBackgroundColor(-65281);
                        cows[rando1].getBackground().setAlpha(50);
                        Vibrator vib = (Vibrator) getSystemService(VIBRATOR_SERVICE);
                        vib.vibrate(VibrationEffect.createOneShot(5, 255));

                    }
                };

                new Timer().scheduleAtFixedRate(new TimerTask() {
                    int q = 0;

                    @Override
                    public void run() {
                        if (q < 20) {
                            runOnUiThread(flash);
                            q++;
                        } else

                            cancel();
                    }

                }, 0, 200);

            }
        });
    }


}