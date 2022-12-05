package com.letsdowebsite.ambassadorsheilarenee;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;


public class CommunityAwareness extends AppCompatActivity {

        ImageView back;
        Button appointment,contactus;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.communityawareness);

                this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

                back = (ImageView) findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                Intent intent = new Intent( CommunityAwareness.this, MainActivity.class);
                                startActivity(intent);
                        }
                });

                appointment = (Button) findViewById(R.id.appointment);
                appointment.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                Intent intent = new Intent(CommunityAwareness.this, Appointment.class);
                                startActivity(intent);
                        }
                });

                contactus = (Button) findViewById(R.id.contactus);
                contactus.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                                Intent intent = new Intent(CommunityAwareness.this, Contact.class);
                                startActivity(intent);
                        }
                });

        }
}