package com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

import com.letsdowebsite.ambassadorsheilarenee.BookNow1;
import com.letsdowebsite.ambassadorsheilarenee.MainActivity;
import com.letsdowebsite.ambassadorsheilarenee.R;
import com.letsdowebsite.ambassadorsheilarenee.ui.services.ServicesDetails;

public class Popup_GroupFacilitator extends AppCompatActivity {

    ImageButton ib_close;
    Button closePopupBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup__groupfacilitator);
     this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        ib_close = (ImageButton) findViewById(R.id.ib_close);
        ib_close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Popup_GroupFacilitator.this, ServicesDetails.class);
                startActivity(intent);
            }
        });

        closePopupBtn = (Button) findViewById(R.id.closePopupBtn);
        closePopupBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Popup_GroupFacilitator.this, BookNow1.class);
                startActivity(intent);
            }
        });


        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);

        int height = displayMetrics.heightPixels;
        int width  = displayMetrics.widthPixels;

        getWindow().setLayout((int) (width*.8), (int) (height*.8));

    }
}
