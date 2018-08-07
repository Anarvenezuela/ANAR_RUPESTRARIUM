package com.anar.rupestrarium;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/BAUHAUSM.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarMain);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        final ImageView es = (ImageView) findViewById(R.id.es);
        final ImageView en = (ImageView)findViewById(R.id.en);

        es.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String languageToLoad = "es"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);

            }
        });

        en.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String languageToLoad = "en"; // your language
                Locale locale = new Locale(languageToLoad);
                Locale.setDefault(locale);
                Configuration config = new Configuration();
                config.locale = locale;
                getBaseContext().getResources().updateConfiguration(config,
                        getBaseContext().getResources().getDisplayMetrics());
                Intent i = getBaseContext().getPackageManager()
                        .getLaunchIntentForPackage( getBaseContext().getPackageName() );
                i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        });
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            finish();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        /*
         * Handle Navigation View Item Clicks Here
         */

        int id = item.getItemId();

        if (id == R.id.nav_presentacion) {

            Intent presentacion = new Intent(MainActivity.this, Tab.class);
            presentacion.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(presentacion);
            finish();
        } else if (id == R.id.nav_petroglifo2) {
            Intent petroglifo2 = new Intent(MainActivity.this, Petroglifo2.class);
            petroglifo2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo2);
            finish();
        } else if (id == R.id.nav_pintura) {
            Intent pintura = new Intent(MainActivity.this, Pintura.class);
            pintura.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura);
            finish();

        } else if (id == R.id.nav_pintura2) {
            Intent pintura2 = new Intent(MainActivity.this, Pintura2.class);
            pintura2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura2);
            finish();

        } else if (id == R.id.nav_petroglifo) {
            Intent petroglifo = new Intent(MainActivity.this, Petroglifo.class);
            petroglifo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo);
            finish();

        } else if (id == R.id.nav_recapitula) {
            Intent recapitula = new Intent(MainActivity.this, Recapitula.class);
            recapitula.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(recapitula);
            finish();

        } else if (id == R.id.nav_creditos) {
            Intent creditos = new Intent(MainActivity.this, Creditos.class);
            creditos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(creditos);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }
}
