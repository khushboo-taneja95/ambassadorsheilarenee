package com.letsdowebsite.ambassadorsheilarenee.ui.videos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

import androidx.recyclerview.widget.RecyclerView;


import com.letsdowebsite.ambassadorsheilarenee.R;

import java.util.List;

public class VideooAdapter extends RecyclerView.Adapter<VideooAdapter.VideoViewHolder> {

    List<YouTubeVideos> youtubeVideoList;

    public VideooAdapter() {
    }

    public VideooAdapter(List<YouTubeVideos> youtubeVideoList) {
        this.youtubeVideoList = youtubeVideoList;
    }

    @Override
    public VideooAdapter.VideoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from( parent.getContext()).inflate( R.layout.videos, parent, false);

        return new VideooAdapter.VideoViewHolder(view);

    }

    @Override
    public void onBindViewHolder(VideooAdapter.VideoViewHolder holder, int position) {

        holder.videoWeb.loadData( youtubeVideoList.get(position).getVideoUrl(), "text/html" , "utf-8" );

    }

    @Override
    public int getItemCount() {
        return youtubeVideoList.size();
    }

    public class VideoViewHolder extends RecyclerView.ViewHolder{

        WebView videoWeb;

        public VideoViewHolder(View itemView) {
            super(itemView);

            videoWeb = (WebView) itemView.findViewById(R.id.videoWebView);

            videoWeb.getSettings().setJavaScriptEnabled(true);
            videoWeb.setWebChromeClient(new WebChromeClient() {

            } );
        }
    }
}
