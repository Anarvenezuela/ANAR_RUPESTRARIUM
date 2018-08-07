package com.anar.rupestrarium;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import java.util.Locale;

public class Creditos extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creditos);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/BAUHAUSM.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();


        ImageView icon = (ImageView) findViewById(R.id.title_bar_icon);
        TextView title = (TextView) findViewById(R.id.title_bar);

        String mtitle = getString(R.string.cred);
        title.setText(mtitle);
        icon.setImageResource(R.drawable.anar);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(Creditos.this, MainActivity.class)
                    .addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
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
            
            Intent presentacion = new Intent(Creditos.this, Tab.class);
            presentacion.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(presentacion);
            finish();
            
        } else if (id == R.id.nav_petroglifo2) {
            Intent petroglifo2 = new Intent(Creditos.this, Petroglifo2.class);
            petroglifo2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo2);
            finish();

        } else if (id == R.id.nav_pintura) {
            Intent pintura = new Intent(Creditos.this, Pintura.class);
            pintura.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura);
            finish();

        } else if (id == R.id.nav_pintura2) {
            Intent pintura2 = new Intent(Creditos.this, Pintura2.class);
            pintura2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura2);
            finish();

        } else if (id == R.id.nav_recapitula) {
            Intent recapitula = new Intent(Creditos.this, Recapitula.class);
            recapitula.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(recapitula);
            finish();

        } else if (id == R.id.nav_petroglifo) {
            Intent petroglifo = new Intent(Creditos.this, Petroglifo.class);
            petroglifo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo);
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