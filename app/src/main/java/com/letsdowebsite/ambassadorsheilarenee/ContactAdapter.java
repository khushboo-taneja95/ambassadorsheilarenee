package com.letsdowebsite.ambassadorsheilarenee;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class ContactAdapter extends RecyclerView.Adapter<ContactAdapter.TempleViewHolder>{
    Context context ;
    ArrayList<AboutData> myList;

    public ContactAdapter(Context context, ArrayList<AboutData> myList) {
        this.myList = myList;
        this.context = context;
    }
    @Override
    public ContactAdapter.TempleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate( R.layout.activity_contact,parent,false);
        return new ContactAdapter.TempleViewHolder( view );
    }

    @Override
    public void onBindViewHolder(ContactAdapter.TempleViewHolder holder, int size) {
        AboutData title = myList.get(size);
        holder.textView.setText(title.getName());

    }
    @Override
    public int getItemCount()
    {
        return myList.size();
    }
    public class TempleViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        ImageView imageicon;
        Button btn;
        Button buttonCall;
        Button butt;

        public TempleViewHolder(View itemView) {
            super( itemView );


            btn =(Button) itemView.findViewById( R.id.btn );
            btn.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Uri gmmIntentUri = Uri.parse("geo:32.0429992, -81.1254501?q=Counselor");
                    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
                    mapIntent.setPackage("com.google.android.apps.maps");
                    context.startActivity(mapIntent);
                }
            } );


            buttonCall  =(Button) itemView.findViewById( R.id.buttonCall );
            buttonCall.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:9122280440"));
                   context .startActivity(intent);
                }
            } );

            butt =(Button) itemView.findViewById( R.id.butt );
            butt.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("message/rfc822");
                    i.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@example.com"});
                    i.putExtra(Intent.EXTRA_SUBJECT, "subject of email");
                    i.putExtra(Intent.EXTRA_TEXT   , "body of email");
                    try {
                      //  startActivity(Intent.createChooser(i, "Send mail..."));
                    } catch (android.content.ActivityNotFoundException ex) {
                     //   Toast.makeText(MyActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                    }


                }
            } );

        }
    }
}
