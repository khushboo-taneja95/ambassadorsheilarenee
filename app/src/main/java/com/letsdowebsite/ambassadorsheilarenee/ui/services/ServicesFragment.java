package com.letsdowebsite.ambassadorsheilarenee.ui.services;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.letsdowebsite.ambassadorsheilarenee.R;

public class ServicesFragment extends Fragment {
    private View view;
    Context ctx;

    MyListData[] myListData = new MyListData[] {
            new MyListData("Inspirational / Motivational Services", R.drawable.ser1),
            new MyListData("Men's Prayer Ministry", R.drawable.ser2),
            new MyListData("Ministry Service", R.drawable.ser3),



    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.services, viewGroup, false);
        RecyclerView metrostationlist = (RecyclerView)view.findViewById(R.id.recyclerView);
        ServicesAdapter adapter = new ServicesAdapter(myListData , getActivity());
        metrostationlist.setHasFixedSize(true);
        metrostationlist.setAdapter(adapter);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;


    }
}