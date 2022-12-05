package com.letsdowebsite.ambassadorsheilarenee.ui.services;

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

import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_BusinessNetworks;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Christian;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Conference;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_GroupFacilitator;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Personal;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_SelfEnhancement;
import com.letsdowebsite.ambassadorsheilarenee.R;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private ArrayList<DataModel> dataSet;
    Context context;
    View view;


    public CustomAdapter(ArrayList<DataModel> data) {
        this.dataSet = data;
      this.context = context;

    }

    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cards_layout, parent, false);
       ViewHolder viewHolder = new ViewHolder(listItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int listPosition) {

        TextView textViewName = holder.textViewName;
        TextView textViewVersion = holder.textViewVersion;
        ImageView imageView = holder.imageView;
        CardView card_view = holder.card_view;


        textViewName.setText(dataSet.get(listPosition).getName());
        textViewVersion.setText(dataSet.get(listPosition).getVersion());
        holder.imageView.setImageResource(dataSet.get(listPosition).getImage());




    }

  @Override
    public int getItemCount() {
        return dataSet.size();
    }



    public  class ViewHolder extends RecyclerView.ViewHolder  implements View.OnClickListener {

        TextView textViewName;
        TextView textViewVersion;
        ImageView imageView;
        CardView card_view;


        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);


            this.textViewName = (TextView) itemView.findViewById(R.id.textViewName);
            this.textViewVersion = (TextView) itemView.findViewById(R.id.textViewVersion);
            this.imageView = (ImageView) itemView.findViewById(R.id.imageView);
            card_view = (CardView) itemView.findViewById(R.id.card_view);

            card_view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int pos = getAdapterPosition();
                    if(pos==0)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_BusinessNetworks.class));
                    if(pos==1)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_SelfEnhancement.class));
                    if(pos==2)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Personal.class));
                    if(pos==3)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_GroupFacilitator.class));
                    if(pos==4)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Conference.class));
                    if(pos==5)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Christian.class));

                }
            });


        }

        @Override
        public void onClick(View v) {

        }
    }
}
