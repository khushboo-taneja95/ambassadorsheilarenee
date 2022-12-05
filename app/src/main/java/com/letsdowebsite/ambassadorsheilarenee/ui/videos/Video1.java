package com.letsdowebsite.ambassadorsheilarenee.ui.videos;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.letsdowebsite.ambassadorsheilarenee.MainActivity;
import com.letsdowebsite.ambassadorsheilarenee.R;

import java.util.Vector;


public class Video1 extends AppCompatActivity {

    private ImageView back, lo;
    SwipeRefreshLayout swipe;
    TextView next , pre;
    ImageView img;

    RecyclerView recyclerView;
    Vector<YouTubeVideos> youtubeVideos = new Vector<YouTubeVideos>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.video );

        recyclerView = (RecyclerView) findViewById( R.id.recyclerView );
        recyclerView.setHasFixedSize( true );
        recyclerView.setLayoutManager( new LinearLayoutManager(this));

        youtubeVideos.add( new YouTubeVideos( "<iframe width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/8nVMj3c-uyw\" frameborder=\"0\" allowfullscreen></iframe>" ) );


        VideooAdapter videoAdapter = new VideooAdapter( youtubeVideos );

        recyclerView.setAdapter( videoAdapter );


        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(Video1.this, MainActivity.class);
            startActivity(i);

                }

        });



    }
}

