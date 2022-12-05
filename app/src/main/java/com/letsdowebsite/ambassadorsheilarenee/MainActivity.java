package com.letsdowebsite.ambassadorsheilarenee;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.navigation.NavigationView;
import com.letsdowebsite.ambassadorsheilarenee.ui.home.HomeFragment;
import com.letsdowebsite.ambassadorsheilarenee.ui.services.ServicesFragment;
import com.letsdowebsite.ambassadorsheilarenee.ui.videos.VideosFragment;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {


    private AppBarConfiguration mAppBarConfiguration;
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener;
    private static long back_pressed;
    Fragment fragment = null;
    private TextView tvTitle;


    public static TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("");

        setSupportActionBar(toolbar);
        tvTitle = (TextView) findViewById( R.id.tvTitle );
        fragment = new HomeFragment();
       fragmentReplace(fragment);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        drawer.addDrawerListener(toggle);
        toggle.syncState();

        com.github.clans.fab.FloatingActionButton menu1,menu2,menu3 ;

        menu1 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.subFloatingMenu1) ;
        menu3 = (com.github.clans.fab.FloatingActionButton)findViewById(R.id.subFloatingMenu3) ;

        menu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData( Uri.parse("tel:912 228 0440"));
                startActivity(intent);

            }
        });

        menu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Appointment.class);
                startActivity(i);


            }
        });


        NavigationView navigationView = (NavigationView) findViewById( R.id.nav_view );
        navigationView.setNavigationItemSelectedListener( this );
        fragment = new HomeFragment();
        fragmentReplace( fragment );
        navigationView.setItemIconTintList( null );
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        if (drawer.isDrawerOpen( GravityCompat.START )) {
            drawer.closeDrawer( GravityCompat.START );
        } else {
            if (back_pressed + 2000 > System.currentTimeMillis()) {
                super.onBackPressed();
            } else {
                Toast.makeText( this, "Press once  again to exit!", Toast.LENGTH_SHORT ).show();
            }
            back_pressed = System.currentTimeMillis();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }



    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            tvTitle.setText( "Videos" );
            fragment = new VideosFragment();
            fragmentReplace( fragment );
        }
        return super.onOptionsItemSelected( item );
    }


    @SuppressWarnings("StatementWithEmptyBody")

    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            tvTitle.setText( "Home" );
            fragment = new HomeFragment();
            fragmentReplace( fragment );

     //   } else if (id == R.id.nav_gallery) {
     //       Intent i = new Intent(MainActivity.this, Gallery.class);
      //      startActivity(i);


        } else if (id == R.id.faith) {
            Intent i = new Intent(MainActivity.this, Faith.class);
            startActivity(i);

        } else if (id == R.id.prayer) {
            Intent i = new Intent(MainActivity.this, Prayer.class);
            startActivity(i);

        } else if (id == R.id.education) {
            Intent i = new Intent(MainActivity.this, Education.class);
            startActivity(i);
        } else if (id == R.id.community) {
            Intent i = new Intent(MainActivity.this, CommunityAwareness.class);
            startActivity(i);
        } else if (id == R.id.financial) {
        } else if (id == R.id.expand) {
            Intent i = new Intent(MainActivity.this, GrowBusiness.class);
            startActivity(i);
        } else if (id == R.id.men) {
            Intent i = new Intent(MainActivity.this, MensMotivational.class);
            startActivity(i);

        } else if (id == R.id.women) {
        } else if (id == R.id.family) {
        } else if (id == R.id.featured) {
            Intent i = new Intent(MainActivity.this, FeaturedBusiness.class);
            startActivity(i);
        }  else if (id == R.id.appointment) {

            Intent i = new Intent(MainActivity.this, Appointment.class);
            startActivity(i);

        } else if (id == R.id.nav_services) {
            tvTitle.setText( "Services" );
            fragment = new ServicesFragment();
            fragmentReplace( fragment );



        } else if (id == R.id.nav_events) {

            Intent i = new Intent(MainActivity.this, EventsActivity.class);
            startActivity(i);

        }  else if (id == R.id.nav_appointment) {

            Intent i = new Intent(MainActivity.this, Appointment.class);
            startActivity(i);



        }  else if (id == R.id.nav_contact) {

            fragment = new ContactFragment();
            fragmentReplace( fragment );
            tvTitle.setText( "Contact Us" );

        } else if (id == R.id.visitwebsite) {

                Intent i = new Intent(MainActivity.this, VisitWebsite.class);
                startActivity(i);

            } else if (id == R.id.nav_facebook) {

            Intent i = new Intent(MainActivity.this, Facebook.class);
            startActivity(i);

        }
        else if (id == R.id.nav_instagram) {

            Intent i = new Intent(MainActivity.this, InstaActivity.class);
            startActivity(i);

        }
        else if (id == R.id.nav_share) {
            Intent sendIntent = new Intent();
            sendIntent.setAction( Intent.ACTION_SEND );
            sendIntent.putExtra( Intent.EXTRA_TEXT,
                    "Hey check out my app at: https://play.google.com/store/apps/details?id=com.letsdowebsite.ambassadorsheilarenee" );
            sendIntent.setType( "text/plain" );
            startActivity( sendIntent );
            return true;




        }

        DrawerLayout drawer = (DrawerLayout) findViewById( R.id.drawer_layout );
        drawer.closeDrawer( GravityCompat.START );
        return true;
    }

    public void fragmentReplace (Fragment fragment){

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace( R.id.main_fragment, fragment );
        transaction.commit();
    }
}

