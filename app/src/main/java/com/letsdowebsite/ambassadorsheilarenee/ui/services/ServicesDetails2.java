package com.letsdowebsite.ambassadorsheilarenee.ui.services;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.letsdowebsite.ambassadorsheilarenee.MainActivity;
import com.letsdowebsite.ambassadorsheilarenee.R;

import java.util.ArrayList;

public class ServicesDetails2 extends AppCompatActivity implements View.OnClickListener{

    private static RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    private static RecyclerView recyclerView;
    private static ArrayList<DataModel> data;
    static View.OnClickListener myOnClickListener;
    private static ArrayList<Integer> removedItems;

    ImageView back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_services_details2);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(ServicesDetails2.this, MainActivity.class);
                startActivity(intent);
            }
        });



        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        data = new ArrayList<DataModel>();
        for (int i = 0; i < MyData2.nameArray.length; i++) {
            data.add(new DataModel(
                    MyData2.nameArray[i],
                    MyData2.versionArray[i],
                    MyData2.id_[i],
                    MyData2.drawableArray[i]
            ));
        }

        adapter = new ServiceDetailsAdapter2(data);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void onClick(View v) {

    }
}