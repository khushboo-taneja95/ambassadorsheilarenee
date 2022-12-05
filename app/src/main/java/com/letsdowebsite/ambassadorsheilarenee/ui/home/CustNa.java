package com.letsdowebsite.ambassadorsheilarenee.ui.home;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.letsdowebsite.ambassadorsheilarenee.Appointment;
import com.letsdowebsite.ambassadorsheilarenee.Arraylist;
import com.letsdowebsite.ambassadorsheilarenee.FeaturedBusiness;
import com.letsdowebsite.ambassadorsheilarenee.R;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Public;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_PublicHome;

import java.util.ArrayList;


public class CustNa extends RecyclerView.Adapter<CustNa.MyViewHolder> {

    private ArrayList<Arraylist> dataSet;

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView textViewName;

        ImageView imageViewIcon;

        public MyViewHolder(View itemView) {
            super(itemView);
           // this.textViewName = (TextView) itemView.findViewById(R.id.txtView);
            final Context context = itemView.getContext();
            this.imageViewIcon = (ImageView) itemView.findViewById(R.id.image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v)
                {
                    if (getPosition()==0)
                    {
                        context.startActivity( new Intent( context, FeaturedBusiness.class ) );

                    } if (getPosition()==1) {
                  context.startActivity( new Intent( context, Appointment.class ) );
                }
                }
            });
        }
    }

    public CustNa(ArrayList<Arraylist> data) {
        this.dataSet = data;
    }

    @Override
    public CustNa.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                  int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.prodct, parent, false);

        //view.setOnClickListener(MainActivity.myOnClickListener);

        CustNa.MyViewHolder myViewHolder = new CustNa.MyViewHolder(view);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(final CustNa.MyViewHolder holder, final int listPosition) {

     //   TextView textViewName = holder.textViewName;
        // TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageViewIcon;

     //   textViewName.setText(dataSet.get(listPosition).getName());
        //textViewVersion.setText(dataSet.get(listPosition).getVersion());
        imageView.setImageResource(dataSet.get(listPosition).getImage());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }}

