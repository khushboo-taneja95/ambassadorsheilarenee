package com.letsdowebsite.ambassadorsheilarenee.ui.home;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.letsdowebsite.ambassadorsheilarenee.Arraylist;
import com.letsdowebsite.ambassadorsheilarenee.CommunityAwareness;
import com.letsdowebsite.ambassadorsheilarenee.Facebook;
import com.letsdowebsite.ambassadorsheilarenee.GrowBusiness;
import com.letsdowebsite.ambassadorsheilarenee.InstaActivity;
import com.letsdowebsite.ambassadorsheilarenee.R;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_PublicHome;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    private CustomNavi horizontalAdapter;
    private CustNavi horizontal;
    private OfferAdapter hori;
    private CustNa hor;
    GetMotivate get;
    CircleIndicator indicator;
    private MensNavi horizontle;
    private FeaturesNavi horizontla;
    private IgniteYourWorth igniteyourworth;
    private  FixAndMaximise fixandmaximise;

    ImageView imageViewItem , image , imageView;
    private ArrayList<Arraylist> horizontalList;
    private RecyclerView horizontal_recycler_view;
    View view;
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();
    private static ViewPager mPager;
    private static final Integer[] IMAGES = {R.drawable.slider, R.drawable.slider4, R.drawable.slider1, R.drawable.slider2};
    private static int NUM_PAGES = 0;
    Context context;
    private static int currentPage = 0;
    private MenWomen horii;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        view = inflater.inflate(R.layout.fragment_home, null);


        ImageView imageViewItem = (ImageView) view.findViewById(R.id.imageViewItem);
//        imageViewItem.setOnClickListener((View.OnClickListener) this);


        context = this.getActivity();
        context = this.getActivity();
        init();

        return view;

    }



    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        imageViewItem = (ImageView) getView().findViewById(R.id.imageViewItem);
        imageViewItem.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
               Intent mainIntent = new Intent(getActivity(), CommunityAwareness.class);
                startActivity(mainIntent);
            }
        });

        image = (ImageView) getView().findViewById(R.id.image);
        image.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
                Intent mainIntent = new Intent(getActivity(),
                        GrowBusiness.class);
                startActivity(mainIntent);
            }
        });


        imageView = (ImageView) getView().findViewById(R.id.imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            // Start new list activity
            public void onClick(View v) {
              //  Intent mainIntent = new Intent(getActivity(),Popup_PublicHome.class);
              //  startActivity(mainIntent);
            }
        });


    }


    private void init() {

        for (int i = 0; i < IMAGES.length; i++)
            ImagesArray.add(IMAGES[i]);
        mPager = (ViewPager) view.findViewById(R.id.pager);
        mPager.setAdapter(new MyAdapter2(getActivity(), ImagesArray));
     //   indicator = view.findViewById(R.id.indicator);
       // indicator.setViewPager(mPager);
        NUM_PAGES = IMAGES.length;

        final Handler handle = new Handler();
        final Runnable update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handle.post(update);
            }
        }, 3000, 3000);

        mPager.setAdapter(new MyAdapter2(getActivity(), ImagesArray));


        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.nameArrey.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.nameArray[i], MyData.nameArrey[i],
                    MyData.drawableArrey[i]
            ));
            //horizontal recyler view product

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview);
            horizontalAdapter = new CustomNavi(horizontalList);
            GridLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(horizontalAdapter);
        }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.name.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.name[i], MyData.name[i],
                    MyData.drawable[i]
            ));
            //horizontal recyler view product

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview1);
            horizontla = new FeaturesNavi(horizontalList);
            GridLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(horizontla);
        }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.arrey.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.arrey[i], MyData.arrey[i],
                    MyData.Draw[i]
            ));
            //horizontal recyler view product

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview2);
            horizontle = new MensNavi(horizontalList);
            GridLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(horizontle);
        }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.Arrey.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.nameArray[i], MyData.Arrey[i],
                    MyData.draw[i]
            ));

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview3);
            hor = new CustNa(horizontalList);
            GridLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(hor);

        }



        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.nameArray.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.nameArray[i],
                    MyData.description[i],
                    MyData.drawableArray[i]
            ));

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview4);
            get = new GetMotivate(horizontalList);
            LinearLayoutManager horizontalLayoutManagaer
                    = new LinearLayoutManager(getActivity(), LinearLayoutManager.HORIZONTAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(get);

        }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.Arreyy.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.Arreyy[i], MyData.Arreyy[i],
                    MyData.draww[i]
            ));

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview5);
            igniteyourworth = new IgniteYourWorth(horizontalList);
            GridLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(igniteyourworth);

        }

        horizontalList = new ArrayList<Arraylist>();
        for (int i = 0; i < MyData.Arrez.length; i++) {
            horizontalList.add(new Arraylist(
                    MyData.Arrez[i], MyData.Arrez[i],
                    MyData.drav[i]
            ));

            horizontal_recycler_view = (RecyclerView) view.findViewById(R.id.recylerview6);
            fixandmaximise = new FixAndMaximise(horizontalList);
            GridLayoutManager horizontalLayoutManagaer
                    = new GridLayoutManager(getActivity(), 2, GridLayoutManager.VERTICAL, false);

            horizontal_recycler_view.setLayoutManager(horizontalLayoutManagaer);
            horizontal_recycler_view.setAdapter(fixandmaximise);

        }

    }



}


