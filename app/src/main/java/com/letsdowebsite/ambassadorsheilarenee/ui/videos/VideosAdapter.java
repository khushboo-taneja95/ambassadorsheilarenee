package com.letsdowebsite.ambassadorsheilarenee.ui.videos;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.letsdowebsite.ambassadorsheilarenee.R;
import com.letsdowebsite.ambassadorsheilarenee.ui.services.MyListData;

import java.security.AccessController;

public class VideosAdapter extends RecyclerView.Adapter<VideosAdapter.ViewHolder> {
    private com.letsdowebsite.ambassadorsheilarenee.ui.services.MyListData[] listdata;
    Context context;
    View view;


    // RecyclerView recyclerView;
    public VideosAdapter(com.letsdowebsite.ambassadorsheilarenee.ui.services.MyListData[] listdata, Context context) {

        this.context = context;
        this.listdata = listdata;
    }

    @Override
    public VideosAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.videos_images, parent, false);
        VideosAdapter.ViewHolder viewHolder = new VideosAdapter.ViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MyListData myListData = listdata[position];
       // holder.txtTitle1.setText(listdata[position].getDescription());
        holder.imageView.setImageResource(listdata[position].getImgId());

        holder.card_view.setOnClickListener(new View.OnClickListener() {

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
        CardView card_view;

        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);

        //  this.txtTitle1 = (TextView) itemView.findViewById(R.id.txtTitle1);
            this.card_view = (CardView) itemView.findViewById(R.id.card_view);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = getAdapterPosition();
                    AccessController view;
                    if (pos == 0)
                        context.startActivity( new Intent( context, Video.class ) );
                    if (pos == 1)
                        context. startActivity(new Intent(context, Video1.class));
                    if (pos == 2)
                        context. startActivity(new Intent(context, Video2.class));
                    if (pos == 3)
                        context. startActivity(new Intent(context, Video3.class));
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
    }
}

