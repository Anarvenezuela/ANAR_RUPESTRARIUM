package com.anar.rupestrarium;

import android.content.Intent;
import android.content.res.Configuration;
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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarMain);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView icon = (ImageView) findViewById(R.id.app_name_bar);
        //icon.setImageResource(R.drawable.petroglifo_ico);

        String language = Locale.getDefault().getLanguage();
        Drawable titulo_rupest = getResources().getDrawable(R.drawable.rupestrarium1);
        Drawable titulo_rock = getResources().getDrawable(R.drawable.rockartium);
        Drawable fondo_rupes = getResources().getDrawable(R.drawable.portada_rupest);
        Drawable fondo_rock = getResources().getDrawable(R.drawable.portada_rock);
        RelativeLayout presentacion_layout = (RelativeLayout) findViewById(R.id.main);

        if (language == "en") {

            if (Build.VERSION.SDK_INT >= 16){
                icon.setImageDrawable(titulo_rock);
                presentacion_layout.setBackground(fondo_rock);
            }
        } else if (language == "es") {

            if (Build.VERSION.SDK_INT >= 16){
                icon.setImageDrawable(titulo_rupest);
                presentacion_layout.setBackground(fondo_rupes);
            }
        }

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
            //startActivity(new Intent(MainActivity.this, MainActivity.class)
              //      .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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
}
