package com.letsdowebsite.ambassadorsheilarenee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {

    ImageView back;
    private static final int NUM_COLUMNS = 2;

    private ArrayList<String> ImageUrl = new ArrayList<>();
    private ArrayList<String> Title = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.events);


        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(EventsActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });


        initImageBitmap();
    }

    private void initImageBitmap() {

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING1-2.png");
        Title.add("Wailing WarriorWomen, INC & Men with Manna Intercessory Prayer Ministries" );

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING2-1.png");
        Title.add("2009 Wailing Warrior Women presents: From Boyz to Kings with Karl Collins Tulsa, OK" );

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING3-1.png");
        Title.add("Ambassador sings Praise and Worship in Tulsa, OK with Chaneniah Ministries Aughusy 1, 2009");

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING3-2.png");
        Title.add("August 14, 2009 Wailing Warrior Inaugural Summit Broken Arrow Oklahoma Tivoli Inn"
        );

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING4-1.png");
        Title.add("Pastor Mary Jones has faithful an committed Supporter of WW, IGM since 2015 when re relocated to Savannah, Ga. 2016");

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING5-1.png");
        Title.add("Trained by the best, My mom, Dr. J. C, Skinner");

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING6-1.png");
        Title.add("Wailing Warrior Women, INC and GOR Messenger Annette Carswell 2010");

        ImageUrl.add("https://ambassadorsheilarenee.com/wp-content/uploads/2019/12/WALLING7-1.png");
        Title.add("My “Spiritual Father” Bishop, Apostle Calvin B. Johnson speaking into my life.GOR, LCPM");



        initRecyclerView();
    }

    private void initRecyclerView() {

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        StaggeredRecyclerViewAdapter staggeredRecyclerViewAdapter =
                new StaggeredRecyclerViewAdapter(this, Title, ImageUrl);

        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager( NUM_COLUMNS,
                LinearLayoutManager.VERTICAL);



        recyclerView.setLayoutManager(staggeredGridLayoutManager);
        recyclerView.setAdapter(staggeredRecyclerViewAdapter);
    }
}