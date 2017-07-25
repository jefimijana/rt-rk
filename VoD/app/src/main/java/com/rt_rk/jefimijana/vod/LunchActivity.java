package com.rt_rk.jefimijana.vod;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

public class LunchActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_lunch);
    }


    @Override
    protected void onResume() {
        super.onResume();

        //Wait for 5 seconds and then display MainActivity
        new Thread() {
            public void run() {
                try {
                    sleep(5000);

                    //Display MainActivity
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(intent);

                    //Once MainActivity is started, dismiss lunch screen
                    finish();
                } catch (Exception e) {
                }
            }
        }.start();
    }
}

