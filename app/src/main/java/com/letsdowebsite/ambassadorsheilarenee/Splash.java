package com.letsdowebsite.ambassadorsheilarenee;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;


public class Splash extends AppCompatActivity {

        /** Duration of wait **/
        private final int SPLASH_DISPLAY_LENGTH = 5000; //splash screen will be shown for 2 seconds

        /** Called when the activity is first created. */
        @Override
        public void onCreate(Bundle icicle) {
                super.onCreate(icicle);

                setContentView(R.layout.splash);
                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {

                                Intent mainIntent = new Intent(Splash.this, MainActivity.class);
                                startActivity(mainIntent);
                                finish();
                        }
                }, SPLASH_DISPLAY_LENGTH);
        }
}