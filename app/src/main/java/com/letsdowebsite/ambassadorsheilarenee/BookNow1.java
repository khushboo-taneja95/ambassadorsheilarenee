package com.letsdowebsite.ambassadorsheilarenee;

import android.app.ProgressDialog;
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

public class BookNow1 extends AppCompatActivity {

    private WebView mWebview;
    ImageView lo, back;
    SwipeRefreshLayout swipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.booknow);


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
        mWebview.loadUrl( "https://ambassadorsheilarenee.com/events/inspirational-motivational-products-and-services/" );
        swipe.setRefreshing( true );
        mWebview.setWebViewClient( new WebViewClient() {
            ProgressDialog progressDialog;

            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                mWebview.loadUrl( "file:///android_asset/error.html" );
            }
            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(BookNow1.this);
                builder.setMessage(R.string.notification_error_ssl_cert_invalid);
                builder.setPositiveButton("continue", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.proceed();
                    }
                });
                builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        handler.cancel();
                    }
                });
                final AlertDialog dialog = builder.create();
                dialog.show();
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
                return true;
                //   return super.shouldOverrideUrlLoading(view, url);
            }

            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog( BookNow1.this );
                    progressDialog.setMessage( "Loading..." );
                    progressDialog.show();
                }
            }

            public void onPageFinished(android.webkit.WebView view, String url) {
                try{
                    if (progressDialog.isShowing()) {
                        progressDialog.dismiss();
                        progressDialog = null;
                    }
                }catch(Exception exception){
                    exception.printStackTrace();
                }
                // do your stuff here
                swipe.setRefreshing( false );

                mWebview.loadUrl("javascript:(function() { " +
                        "var head = document.getElementsByClassName('mkdf-mobile-header-inner')[0].style.display='none'; " +
                        "})()");


                mWebview.loadUrl("javascript:(function() { " +
                        "var holiday = document.getElementsByClassName('mkdf-footer-top-holder')[0].style.display='none'; " +
                        "})()");

                mWebview.loadUrl("javascript:(function() { " +
                        "var bread = document.getElementsByClassName('mkdf-footer-bottom-holder')[0].style.display='none'; " +
                        "})()");

                mWebview.loadUrl("javascript:(function() { " +
                        "var sort = document.getElementsByClassName('mkdf-title-image')[0].style.display='none'; " +
                        "})()");


                //     mWebview.loadUrl("javascript:(function() { " +
                //          "var sub = document.getElementsByClassName('subcategories')[0].style.display='none'; " +
                //        "})()");

            }

        } );






        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWebview.canGoBack()) {
                    mWebview.goBack();
                } else {
                    Intent intent = new Intent(BookNow1.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }
    public void onBackPressed () {
        if (mWebview.canGoBack()) {
            mWebview.goBack();
        } else {
            // Let the system handle the back button
            super.onBackPressed();
        }
    }

}

