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

import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Business;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Credit;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Image;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Marketing;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_ProductBrand;
import com.letsdowebsite.ambassadorsheilarenee.R;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Financial;
import com.letsdowebsite.ambassadorsheilarenee.ui.pop_up_screen.Popup_Symbis;

import java.util.ArrayList;

public class ServiceDetailsAdapter3 extends RecyclerView.Adapter<ServiceDetailsAdapter3.ViewHolder> {

    private ArrayList<DataModel> dataSet;
    Context context;
    View view;


    public ServiceDetailsAdapter3(ArrayList<DataModel> data) {
        this.dataSet = data;
      this.context = context;

    }

    @Override
    public ServiceDetailsAdapter3.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.cards_layout3, parent, false);
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
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Business.class));
                    if(pos==1)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Marketing.class));
                    if(pos==2)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_ProductBrand.class));
                    if(pos==3)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Image.class));
                    if(pos==4)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Symbis.class));
                    if(pos==5)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Financial.class));
                    if(pos==6)
                        view.getContext().startActivity(new Intent(view.getContext(), Popup_Credit.class));
                }
            });


        }

        @Override
        public void onClick(View v) {

        }
    }
}
