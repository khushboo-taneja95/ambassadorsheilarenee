package com.letsdowebsite.ambassadorsheilarenee.ui.videos;

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
import com.letsdowebsite.ambassadorsheilarenee.ui.services.MyListData;
import com.letsdowebsite.ambassadorsheilarenee.ui.services.ServicesAdapter;

public class VideosFragment extends Fragment {
    private View view;
    Context ctx;

    com.letsdowebsite.ambassadorsheilarenee.ui.services.MyListData[] myListData = new com.letsdowebsite.ambassadorsheilarenee.ui.services.MyListData[] {
            new com.letsdowebsite.ambassadorsheilarenee.ui.services.MyListData("", R.drawable.video),
            new MyListData("", R.drawable.video1),
            new MyListData("", R.drawable.video2),
            new MyListData("", R.drawable.video3),



    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup viewGroup, Bundle savedInstanceState) {
        view = inflater.inflate( R.layout.services, viewGroup, false);
        RecyclerView metrostationlist = (RecyclerView)view.findViewById(R.id.recyclerView);
        VideosAdapter adapter = new VideosAdapter(myListData , getActivity());
        metrostationlist.setHasFixedSize(true);
        metrostationlist.setAdapter(adapter);
        metrostationlist.setLayoutManager(new LinearLayoutManager(getActivity()));


        return view;


    }
}