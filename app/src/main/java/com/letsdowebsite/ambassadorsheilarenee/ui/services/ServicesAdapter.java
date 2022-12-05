package com.letsdowebsite.ambassadorsheilarenee.ui.services;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.recyclerview.widget.RecyclerView;

import com.letsdowebsite.ambassadorsheilarenee.Appointment;
import com.letsdowebsite.ambassadorsheilarenee.InstaActivity;
import com.letsdowebsite.ambassadorsheilarenee.R;

import java.security.AccessController;

public class ServicesAdapter extends RecyclerView.Adapter<ServicesAdapter.ViewHolder> {
    private MyListData[] listdata;
    Context context;
    View view;


    // RecyclerView recyclerView;
    public ServicesAdapter(MyListData[] listdata, Context context) {

        this.context = context;
        this.listdata = listdata;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.service_images, parent, false);
        ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
        holder.txtTitle1.setText(listdata[position].getDescription());
        holder.imageView.setImageResource(listdata[position].getImgId());

        holder.txtTitle1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {


            }
        });

    }


    @Override
    public int getItemCount() {
        return listdata.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public ImageView imageView;
        public TextView txtTitle1;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

            this.txtTitle1 = (TextView) itemView.findViewById(R.id.txtTitle1);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    AccessController view;
                    if (pos == 0)
                        context.startActivity( new Intent( context, ServicesDetails.class ) );
                    if (pos == 1)
                        context. startActivity(new Intent(context, ServicesDetails2.class));
                    if (pos == 2)
                        context. startActivity(new Intent(context, ServicesDetails3.class));

                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}



