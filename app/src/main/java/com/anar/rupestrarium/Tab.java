package com.anar.rupestrarium;

import android.content.Context;
import android.content.Intent;
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
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.ViewGroup;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;
import android.graphics.Typeface;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;

public class Tab extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private TabLayout tabLayout;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/BAUHAUSM.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        context = this;

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBarTab);
        //RelativeLayout toolbar = (RelativeLayout) findViewById(R.id.toolBarTab1);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        SectionsPagerAdapter mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        ViewPager mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        changeTabsFont();
    }


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(Tab.this, MainActivity.class)
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
        
        if (id == R.id.nav_petroglifo) {
            
            Intent petroglifo = new Intent(Tab.this, Petroglifo.class);
            petroglifo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo);
            finish();
        } else if (id == R.id.nav_petroglifo2) {
            Intent petroglifo2 = new Intent(Tab.this, Petroglifo2.class);
            petroglifo2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo2);
            finish();

        } else if (id == R.id.nav_pintura) {
            Intent pintura = new Intent(Tab.this, Pintura.class);
            pintura.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura);
            finish();

        } else if (id == R.id.nav_pintura2) {
            Intent pintura2 = new Intent(Tab.this, Pintura2.class);
            pintura2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura2);
            finish();

        } else if (id == R.id.nav_recapitula) {
            Intent recapitula = new Intent(Tab.this, Recapitula.class);
            recapitula.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(recapitula);
            finish();

        } else if (id == R.id.nav_creditos) {
            Intent creditos = new Intent(Tab.this, Creditos.class);
            creditos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(creditos);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    /**
     * Method that changes the font family of the text in the tabs
     * Makes an iteration in the tabs of the tab layout
     * then takes the view child of the tabs and cast it into a TextView
     * and applies the new font
     */
    private void changeTabsFont() {
        Typeface tf = Typeface.createFromAsset(Tab.this.getAssets(), "fonts/BAUHAUSM.TTF");
        ViewGroup vg = (ViewGroup) tabLayout.getChildAt(0);
        int tabsCount = vg.getChildCount();
        for (int j = 0; j < tabsCount; j++) {
            ViewGroup vgTab = (ViewGroup) vg.getChildAt(j);
            int tabChildsCount = vgTab.getChildCount();
            for (int i = 0; i < tabChildsCount; i++) {
                View tabViewChild = vgTab.getChildAt(i);
                if (tabViewChild instanceof TextView) {
                    ((TextView) tabViewChild).setTypeface(tf);
                }
            }
        }
    }


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    private class SectionsPagerAdapter extends FragmentPagerAdapter {

        SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0 : return new Presentacion();
                case 1 : return new Introduccion();
                case 2 : return new Instrucciones();
            }
            return null;
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.present);
                case 1:
                    return getString(R.string.intro);
                case 2:
                    return getString(R.string.instr);
            }
            return null;
        }
    }

    /**
     * Method of the Calligraphy Library to insert the font family in the context of the Activity
     * @param newBase the new base context of the Activity
     */
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

}
