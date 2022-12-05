package com.letsdowebsite.ambassadorsheilarenee;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;

public class Gallery extends AppCompatActivity {

    ImageView back;

    private ArrayList<Integer> images;
    private BitmapFactory.Options options;
    private ViewPager viewPager;
    private View btnNext, btnPrev;
    private FragmentStatePagerAdapter adapter;
    private LinearLayout thumbnailsContainer;
    private final static int[] resourceIDs = new int[]{

            R.drawable.gallery1, R.drawable.gallery2, R.drawable.gallery3,
            R.drawable.gallery4, R.drawable.gallery5, R.drawable.gallery6,
            R.drawable.gallery7, R.drawable.gallery8, R.drawable.gallery9,
            R.drawable.gallery10, R.drawable.gallery11, R.drawable.gallery12,
            R.drawable.gallery13, R.drawable.gallery14, R.drawable.gallery15,
            R.drawable.gallery16, R.drawable.gallery17, R.drawable.gallery18,
            R.drawable.gallery19, R.drawable.gallery20, R.drawable.gallery21,
            R.drawable.gallery22, R.drawable.gallery23
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        images = new ArrayList<>();


        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                    Intent intent = new Intent(Gallery.this, MainActivity.class);
                    startActivity(intent);
                }
            });



        //find view by id
        viewPager = (ViewPager) findViewById(R.id.view_pager);
        thumbnailsContainer = (LinearLayout) findViewById(R.id.container);
        btnNext = findViewById(R.id.next);
        btnPrev = findViewById(R.id.prev);

        btnPrev.setOnClickListener(onClickListener(0));
        btnNext.setOnClickListener(onClickListener(1));

        setImagesData();

        // init viewpager adapter and attach
        adapter = new ViewPagerAdapter(getSupportFragmentManager(), images);
        viewPager.setAdapter(adapter);

        inflateThumbnails();
    }

    private View.OnClickListener onClickListener(final int i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i > 0) {
                    //next page
                    if (viewPager.getCurrentItem() < viewPager.getAdapter().getCount() - 1) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                    }
                } else {
                    //previous page
                    if (viewPager.getCurrentItem() > 0) {
                        viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
                    }
                }
            }
        };
    }

    private void setImagesData() {
        for (int i = 0; i < resourceIDs.length; i++) {
            images.add(resourceIDs[i]);
        }
    }

    private void inflateThumbnails() {
        for (int i = 0; i < images.size(); i++) {
            View imageLayout = getLayoutInflater().inflate(R.layout.item_image, null);
            ImageView imageView = (ImageView) imageLayout.findViewById(R.id.image);
            imageView.setOnClickListener(onChagePageClickListener(i));

            options = new BitmapFactory.Options();
            options.inSampleSize = 3;
            options.inDither = false;
            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), images.get(i), options );
            imageView.setImageBitmap(bitmap);
            //set to image view
            imageView.setImageBitmap(bitmap);
            //add imageview
            thumbnailsContainer.addView(imageLayout);
        }
    }

    private View.OnClickListener onChagePageClickListener(final int i) {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewPager.setCurrentItem(i);
            }
        };
    }
}