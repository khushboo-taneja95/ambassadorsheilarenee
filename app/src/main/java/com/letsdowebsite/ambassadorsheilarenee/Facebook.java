package com.letsdowebsite.ambassadorsheilarenee;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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

public class Facebook extends AppCompatActivity {


    private WebView mWebview;
    SwipeRefreshLayout swipe;
    ImageView lo, back;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.facebook);

        swipe = (SwipeRefreshLayout) findViewById(R.id.swipe);
        swipe.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        });

        WebAction();


    }


    public void WebAction() {

        mWebview = (WebView) findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.getSettings().setAppCacheEnabled(true);
        mWebview.loadUrl("https://www.facebook.com/Ambassadorsheilarenee-105202820878671/?modal=admin_todo_tour");
        swipe.setRefreshing(true);
        mWebview.setWebViewClient(new WebViewClient() {

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {

                mWebview.loadUrl("file:///android_asset/error.html");

            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("tel:")) {
                    Intent intent = new Intent(Intent.ACTION_DIAL,
                            Uri.parse(url));
                    startActivity(intent);
                }else if(url.startsWith("http:") || url.startsWith("https:")) {
                    view.loadUrl(url);
                }

             //   currentUrl=url;
                return super.shouldOverrideUrlLoading(view, url);

                //  return true;
                //   return super.shouldOverrideUrlLoading(view, url);

            }

            public void onPageFinished(WebView view, String url) {
                // do your stuff here
                swipe.setRefreshing(false);


                back = (ImageView) findViewById(R.id.back);
                back.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (mWebview.canGoBack()) {
                            mWebview.goBack();
                        } else {
                            Intent intent = new Intent(Facebook.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                });
            }

        });
    }
}

