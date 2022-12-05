package com.letsdowebsite.ambassadorsheilarenee.ui.home;

import android.content.Context;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.letsdowebsite.ambassadorsheilarenee.Arraylist;
import com.letsdowebsite.ambassadorsheilarenee.R;

import java.util.ArrayList;


public class GetMotivate extends RecyclerView.Adapter<GetMotivate.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;
        TextView textView;
        CountDownTimer timer;
        LinearLayout linear;
        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
          this.textViewName = (TextView) itemView.findViewById(R.id.txtView);
            this.textView = (TextView) itemView.findViewById(R.id.txtView1);
            final Context context = itemView.getContext();
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.image);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getPosition()==0)
                    {


                    } if (getPosition()==1)
                {


                }   if (getPosition()==2)
                {


                }
                    if (getPosition()==3)
                    {


                    }
                    if (getPosition()==4)
                    {


                    }

                }
            });
        }
    }

    public GetMotivate(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public GetMotivate.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                       int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.getmotivate, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        GetMotivate.MyViewHolder myViewHolder = new GetMotivate.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final GetMotivate.MyViewHolder holder, final int listPosition) {

       TextView textViewName = holder.textViewName;
        TextView textView = holder.textView;

        // TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

       textViewName.setText(dataSet.get(listPosition).getName());
        textView.setText(dataSet.get(listPosition).getDescription());

        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());






    }




    @Override
    public int getItemCount() {
        return dataSet.size();
    }}

