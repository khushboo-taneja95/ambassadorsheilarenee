package com.letsdowebsite.ambassadorsheilarenee.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.letsdowebsite.ambassadorsheilarenee.Arraylist;
import com.letsdowebsite.ambassadorsheilarenee.R;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;


public class CustAdapter extends RecyclerView.Adapter<CustAdapter.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
          this.textViewName = (TextView) itemView.findViewById(R.id.txtView);
            final Context context = itemView.getContext();
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getPosition()==0)
                    {


                    }
                    if (getPosition()==1)
                {


                }
                    if (getPosition()==2)
                {


                } if (getPosition()==3)
                {


                }

                }
            });
        }
    }

    public CustAdapter(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public CustAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.image_hori, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        CustAdapter.MyViewHolder myViewHolder = new CustAdapter.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final CustAdapter.MyViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        // TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

        textViewName.setText(dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }}

