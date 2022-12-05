package com.letsdowebsite.ambassadorsheilarenee;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;


public class GrowBusiness extends AppCompatActivity {

    private WebView mWebview;
    ImageView lo, back;
    SwipeRefreshLayout swipe;
    private String currentUrl="https://ambassadorsheilarenee.com/business-consultant/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.growbusiness);


        swipe = (SwipeRefreshLayout) findViewById( R.id.swipe );
        swipe.setOnRefreshListener( new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                WebAction();
            }
        } );

        WebAction();

        if (savedInstanceState != null)
            ((WebView)findViewById(R.id.webview)).restoreState(savedInstanceState);

        mWebview = (WebView) findViewById(R.id.webview);
        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.loadUrl(currentUrl);
        mWebview.setPadding(0, 0, 0, 0);
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setUseWideViewPort(true);
    //    mWebview.getSettings().setSupportZoom(true);
        //    mWebview.getSettings().setPluginsEnabled(true);
    //    mWebview.setWebChromeClient(new ChromeClient());

        mWebview.getSettings().setJavaScriptEnabled(true);
        mWebview.getSettings().setAppCacheEnabled(true);
       // mWebview.getSettings().setBuiltInZoomControls(true);
        mWebview.getSettings().setSaveFormData(true);
    }

    public void WebAction() {
        mWebview = (WebView) findViewById( R.id.webview );
        mWebview.getSettings().setJavaScriptEnabled( true );
        mWebview.getSettings().setDomStorageEnabled(true);
        mWebview.getSettings().setAppCacheEnabled( true );
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setUseWideViewPort(true);
   //     mWebview.getSettings().setBuiltInZoomControls(true);
        mWebview.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.NORMAL);
        mWebview.setHorizontalScrollBarEnabled(false);
        mWebview.setVerticalScrollBarEnabled(false);
        mWebview.setVerticalScrollbarPosition( 850 );
        mWebview.getSettings().setUseWideViewPort(true);
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setSavePassword(true);
        mWebview.getSettings().setSaveFormData(true);
        mWebview.getSettings().setAllowFileAccess(true);
        mWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebview.getSettings().setSupportMultipleWindows(true);
        mWebview.getSettings().setGeolocationEnabled(true);
        //  mWebview.getSettings().setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);


        if (Build.VERSION.SDK_INT < 8) {

        } else {

            mWebview.getSettings().setPluginState( WebSettings.PluginState.ON);

        }

        //  mWebview.setWebChromeClient(chromeClient);
        //   mWebview.setWebViewClient(wvClient);
        mWebview.getSettings().setPluginState( WebSettings.PluginState.ON);
        //  mWebview.loadUrl(url);

        mWebview.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
        mWebview.getSettings().setPluginState(WebSettings.PluginState.ON);
        mWebview.getSettings().setMediaPlaybackRequiresUserGesture(false);
        mWebview.setWebChromeClient(new WebChromeClient());

        mWebview.getSettings().setJavaScriptEnabled(true);
        // Watch the sdk level here, < 12 requires 'false
        // Wanted to force HTML5/264/mp4, you may want flash
        //    where still available
        mWebview.getSettings().setPluginState( WebSettings.PluginState.OFF);
        mWebview.getSettings().setLoadWithOverviewMode(true);
        mWebview.getSettings().setUseWideViewPort(true);


        mWebview.getSettings().setAllowFileAccess(true);
        //    mWebview.getSettings().setPluginsEnabled(true);
        mWebview.setScrollBarStyle(View.SCROLLBARS_OUTSIDE_OVERLAY);
        if (Build.VERSION.SDK_INT < 8) {
            //  mWebview.getSettings().setPluginsEnabled(true);
        } else {
            mWebview.getSettings().setPluginState( WebSettings.PluginState.ON);
        }
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int height = displaymetrics.heightPixels;
        int wwidth = displaymetrics.widthPixels;

        Log.e("h & w",500+"-"+800);



        mWebview.loadUrl( "https://ambassadorsheilarenee.com/business-consultant/" );
        swipe.setRefreshing( true );


        mWebview.setWebViewClient( new WebViewClient() {

            ProgressDialog progressDialog;



            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                mWebview.loadUrl( "file:///android_asset/error.html" );
            }
            @Override
            public void onReceivedSslError(WebView view, final SslErrorHandler handler, SslError error) {
                final AlertDialog.Builder builder = new AlertDialog.Builder(GrowBusiness.this);
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

                currentUrl=url;
                return super.shouldOverrideUrlLoading(view, url);

              //  return true;
                //   return super.shouldOverrideUrlLoading(view, url);

            }

            public void onLoadResource (WebView view, String url) {
                if (progressDialog == null) {
                    // in standard case YourActivity.this
                    progressDialog = new ProgressDialog( GrowBusiness.this );
                    progressDialog.setMessage( "Loading..." );
                    progressDialog.show();
                }
            }
            public void onPageFinished(WebView view, String url) {

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


               mWebview.loadUrl("javascript:(function() { " +
                        "var sub = document.getElementsByClassName('mkdf-title-wrapper')[0].style.display='none'; " +
                       "})()");

            }

        } );


        back = (ImageView) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mWebview.canGoBack()) {
                    mWebview.goBack();
                } else {
                    Intent intent = new Intent(GrowBusiness.this, MainActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mWebview.destroy();
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

