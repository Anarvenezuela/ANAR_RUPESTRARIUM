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
import android.util.Log;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;
import android.view.ViewGroup;
import org.w3c.dom.Text;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Petroglifo2 extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private int a = 0;
    private int b = 0;
    private int c = 0;
    private int i = 0;
    private int j = 0;
    private int k = 0;
    private String def;
    private String nombre;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_petroglifo2);

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

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView icon = (ImageView) findViewById(R.id.title_bar_icon);
        TextView title = (TextView) findViewById(R.id.title_bar);

        String mtitle = getString(R.string.petro2);
        title.setText(mtitle);
        icon.setImageResource(R.drawable.petroglifo_ico);

        TextView figura = (TextView) findViewById(R.id.figura_petro2);
        figura.setText(R.string.zoomorfa);
        Button refresh = (Button) findViewById(R.id.refresh);
        refresh.performClick();
        refresh.callOnClick();

        final Integer[] superior_adapter = {R.drawable.cabeza_zoo_petro2, R.drawable.cabeza_antro_petro2,
                R.drawable.cabeza_geo_petro2};
        final Integer[] medio_adapter = {R.drawable.cuerpo_zoo_petro2, R.drawable.cuerpo_antro_petro2,
                R.drawable.cuerpo_geo_petro2};
        final Integer[] inferior_adapter =  {R.drawable.inferior_zoo_petro2, R.drawable.inferior_antro_petro2,
                R.drawable.inferior_geo_petro2};

        Gallery superior = (Gallery)findViewById(R.id.superior_petro2);
        Gallery medio = (Gallery)findViewById(R.id.medio_petro2);
        Gallery inferior = (Gallery)findViewById(R.id.inferior_petro2);

        GalleryAdapter sup = new GalleryAdapter(this,superior_adapter,0);
        GalleryAdapter med = new GalleryAdapter(this,medio_adapter,1);
        GalleryAdapter inf = new GalleryAdapter(this,inferior_adapter,2);
        figura.setText(getString(R.string.zoomorfa));
        superior.setAdapter(sup);
        superior.setSelection(Integer.MAX_VALUE/2);
        medio.setAdapter(med);
        medio.setSelection(Integer.MAX_VALUE/2);
        inferior.setAdapter(inf);
        inferior.setSelection(Integer.MAX_VALUE/2);
        figura.refreshDrawableState();
        figura.setText(getString(R.string.zoomorfa));
    }

    // Button start
    public void first_click(View v){
        TextView first = (TextView) findViewById(R.id.first);
        final TextView figura = (TextView) findViewById(R.id.figura_petro2);
        first.setVisibility(View.GONE);
        figura.setText(getString(R.string.zoomorfa));
        TextView desc = (TextView)findViewById(R.id.descripetro2);
        desc.setText(def);
        desc.setVisibility(View.VISIBLE);
    }

    //Button refresh, gets the name of the figure
    public void click(View v){
        final TextView figura = (TextView) findViewById(R.id.figura_petro2);
        nombre=generator(a,b,c);
        figura.setVisibility(View.GONE);
        figura.refreshDrawableState();
        figura.setVisibility(View.VISIBLE);
        figura.setText(nombre);
    }

    //Display the description of the figure
    public void figura_click(View v){
        TextView desc = (TextView)findViewById(R.id.descripetro2);
        if (desc.getVisibility() == View.VISIBLE){
            desc.setVisibility(View.INVISIBLE);
        }
        else {
            desc.setVisibility(View.VISIBLE);
            desc.setText(def);
        }
    }

    public String generator(int a,int b, int c) {
        String s;
        switch (a) {
            case 0:
                switch (b) {
                    case 0:
                        switch (c) {
                            case 0:
                                s = getString(R.string.zoomorfa);
                                def = getString(R.string.desc_zoomorfa);
                                break;
                            case 1:
                                s = getString(R.string.zooantropomorfa);
                                def = getString(R.string.desc_zooantropomorfa);
                                break;
                            case 2:
                                s = getString(R.string.zoogeometrica);
                                def = getString(R.string.desc_zoogeometrica);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    case 1:
                        switch (c) {
                            case 0:
                                s = getString(R.string.zooantropomorfa);
                                def = getString(R.string.desc_zooantropomorfa);
                                break;
                            case 1:
                                s = getString(R.string.zooantropomorfa);
                                def = getString(R.string.desc_zooantropomorfa);
                                break;
                            case 2:
                                s = getString(R.string.zooantropogeometrica);
                                def = getString(R.string.desc_zooantropogeometrica);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    case 2:
                        switch (c) {
                            case 0:
                                s = getString(R.string.zoogeometrica);
                                def = getString(R.string.desc_zoogeometrica);
                                break;
                            case 1:
                                s = getString(R.string.zoogeoantropomorfa);
                                def = getString(R.string.desc_zoogeoantropomorfa);
                                break;
                            case 2:
                                s = getString(R.string.zoogeometrica);
                                def = getString(R.string.desc_zoogeometrica);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    default:
                        s = "Definiendo...";
                }
                break;
            case 1:
                switch (b) {
                    case 0:
                        switch (c) {
                            case 0:
                                s = getString(R.string.antropozoomorfa);
                                def = getString(R.string.desc_antropozoomorfa);
                                break;
                            case 1:
                                s = getString(R.string.antropozoomorfa);
                                def = getString(R.string.desc_antropozoomorfa);
                                break;
                            case 2:
                                s = getString(R.string.antropozoogeometrica);
                                def = getString(R.string.desc_antropozoogeometrica);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    case 1:
                        switch (c) {
                            case 0:
                                s = getString(R.string.antropozoomorfa);
                                def = getString(R.string.desc_antropozoomorfa);
                                break;
                            case 1:
                                s = getString(R.string.antropomorfa);
                                def = getString(R.string.desc_antropomorfa);
                                break;
                            case 2:
                                s = getString(R.string.antropogeometrica);
                                def = getString(R.string.desc_antropogeometrica);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    case 2:
                        switch (c) {
                            case 0:
                                s = getString(R.string.antropogeozoomorfa);
                                def = getString(R.string.desc_antropogeozoomorfa);
                                break;
                            case 1:
                                s = getString(R.string.antropogeometrica);
                                def = getString(R.string.desc_antropogeometrica);
                                break;
                            case 2:
                                s = getString(R.string.antropogeometrica);
                                def = getString(R.string.desc_antropogeometrica);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    default:
                        s = "Definiendo...";
                }
                break;
            case 2:
                switch (b) {
                    case 0:
                        switch (c) {
                            case 0:
                                s = getString(R.string.geozoomorfa);
                                def = getString(R.string.desc_geozoomorfa);
                                break;
                            case 1:
                                s = getString(R.string.geozooantropomorfa);
                                def = getString(R.string.desc_geozooantropomorfa);
                                break;
                            case 2:
                                s = getString(R.string.geozoomorfa);
                                def = getString(R.string.desc_geozoomorfa);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    case 1:
                        switch (c) {
                            case 0:
                                s = getString(R.string.geoantropozoomorfa);
                                def = getString(R.string.desc_geoantropozoomorfa);
                                break;
                            case 1:
                                s = getString(R.string.geoantropomorfa);
                                def = getString(R.string.desc_geoantropomorfa);
                                break;
                            case 2:
                                s = getString(R.string.geoantropomorfa);
                                def = getString(R.string.desc_geoantropomorfa);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    case 2:
                        switch (c) {
                            case 0:
                                s = getString(R.string.geozoomorfa);
                                def = getString(R.string.desc_geozoomorfa);
                                break;
                            case 1:
                                s = getString(R.string.geoantropomorfa);
                                def = getString(R.string.desc_geoantropomorfa);
                                break;
                            case 2:
                                s = getString(R.string.geometrica);
                                def = getString(R.string.desc_geometrica);
                                break;
                            default:
                                s = "Definiendo...";
                        }
                        break;
                    default:
                        s = "Definiendo...";
                }
                break;
            default:
                s = "Definiendo...";
        }
        return s;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(Petroglifo2.this, MainActivity.class)
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
            
            Intent presentacion = new Intent(Petroglifo2.this, Tab.class);
            presentacion.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(presentacion);
            finish();

        } else if (id == R.id.nav_petroglifo) {
            Intent petroglifo = new Intent(Petroglifo2.this, Petroglifo.class);
            petroglifo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo);
            finish();

        } else if (id == R.id.nav_pintura) {
            Intent pintura = new Intent(Petroglifo2.this, Pintura.class);
            pintura.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura);
            finish();

        } else if (id == R.id.nav_pintura2) {
            Intent pintura2 = new Intent(Petroglifo2.this, Pintura2.class);
            pintura2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura2);
            finish();

        } else if (id == R.id.nav_recapitula) {
            Intent recapitula = new Intent(Petroglifo2.this, Recapitula.class);
            recapitula.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(recapitula);
            finish();

        } else if (id == R.id.nav_creditos) {
            Intent creditos = new Intent(Petroglifo2.this, Creditos.class);
            creditos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(creditos);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    public class GalleryAdapter extends BaseAdapter {

        private Context context;
        private Integer[] gallery;
        int gallery_type; //superior, medio, inferior

        public GalleryAdapter(Context c, Integer[] g, int p) {
            this.context = c;
            this.gallery = g;
            this.gallery_type = p;
        }

        public int getCount() {
            if (this.gallery != null) {
                return Integer.MAX_VALUE;
            } else {
                return 0;
            }
        }

        public Object getItem(int position) {
            if (position >= this.gallery.length) {
                position = position % this.gallery.length;
            }
            return position;
        }

        public long getItemId(int position) {
            if (position >= this.gallery.length) {
                position = position % this.gallery.length;
            }
            return position;
        }

        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            TextView figura = (TextView) findViewById(R.id.figura_petro2);
            Button refresh = (Button) findViewById(R.id.refresh);
            if (position >= this.gallery.length) {
                position = position % this.gallery.length;
            }
            refresh.performClick();
            refresh.callOnClick();
            figura.setText(nombre);

            i = a;
            j = b;
            k = c;

            switch (gallery_type) {
                case 0: //tipo superior
                    a = position; //actual position of superior
                    break;
                case 1: //tipo medio
                    b = position;   //actual position of medio
                    break;
                case 2: //tipo inferior
                    c = position;   //actual position of inferior
                    break;
                default:
                    a = 0;
            }


            final TextView desc = (TextView)findViewById(R.id.descripetro2);
            if (i != a || j != b || k !=c ) {
                desc.setVisibility(View.INVISIBLE);
            }

            imageView.setImageResource(this.gallery[position]);
            imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            nombre = generator(a,b,c);
            refresh.performClick();
            refresh.callOnClick();
            figura.setText(nombre);
            figura.refreshDrawableState();
            refresh.performClick();
            refresh.callOnClick();
            figura.setText(nombre);
            return imageView;
        }


        public int checkPosition(int position) {
            if (position >= this.gallery.length) {
                position = position % this.gallery.length;
            }
            return position;
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
