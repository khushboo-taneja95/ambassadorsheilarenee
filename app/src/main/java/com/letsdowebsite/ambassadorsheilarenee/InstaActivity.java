package com.letsdowebsite.ambassadorsheilarenee;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.http.SslError;
import android.os.Bundle;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class InstaActivity extends AppCompatActivity {

    private WebView mWebview;
    SwipeRefreshLayout swipe;
    ImageView lo, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.instagram );


        swipe = (SwipeRefreshLayout) findViewById( R.id.swipe );
        swipe.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        } );

        WebAction();


    }


    public void WebAction() {

        mWebview = (WebView) findViewById( R.id.webview );
        mWebview.getSettings().setJavaScriptEnabled( true );
        mWebview.getSettings().setAppCacheEnabled( true );
        mWebview.loadUrl( "https://www.instagram.com/ambassadorsheila/" );
        swipe.setRefreshing( true );
        mWebview.setWebViewClient( new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                mWebview.loadUrl( "file:///android_asset/error.html" );

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing( false );




                back = (ImageView) findViewById( R.id.back );
                back.setOnClickListener( new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mWebview.canGoBack()) {
                            mWebview.goBack();
                        } else {
                            Intent intent = new Intent(InstaActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }

        });
    }
}



