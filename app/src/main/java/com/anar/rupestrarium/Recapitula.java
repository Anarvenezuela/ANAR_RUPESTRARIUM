package com.anar.rupestrarium;

import android.support.v7.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.content.Context;
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
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.Gallery;
import android.widget.TextView;
import android.view.ViewGroup;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class Recapitula extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    int score = 0;
    int x = 0;
    int id = 1;
    String erradas = "";
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recapitula);

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setDefaultFontPath("fonts/BAUHAUSM.TTF")
                .setFontAttrId(R.attr.fontPath)
                .build()
        );

        context = this;
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.navView);
        navigationView.setNavigationItemSelectedListener(this);

        ImageView icon = (ImageView) findViewById(R.id.title_bar_icon);
        TextView title = (TextView) findViewById(R.id.title_bar);

        String mtitle = getString(R.string.recap);
        title.setText(mtitle);
        icon.setImageResource(R.drawable.recapitula_ico);

        final TextView preg = (TextView) findViewById(R.id.pregunta);
        final RadioGroup rg =(RadioGroup) findViewById(R.id.rg);
        final RadioButton rda =(RadioButton)findViewById(R.id.rdbOne);
        final RadioButton rdb =(RadioButton)findViewById(R.id.rdbTwo);
        final RadioButton rdc =(RadioButton)findViewById(R.id.rdbThree);
        final RadioButton rdd =(RadioButton)findViewById(R.id.rdbFour);
        final ImageButton butNext =(ImageButton)findViewById(R.id.siguiente);
        final Button butFin = (Button)findViewById(R.id.finalizar);

        butFin.setVisibility(View.INVISIBLE);

        Pregunta p1 = new Pregunta(getString(R.string.p1),getString(R.string.p1a),getString(R.string.p1b),
                getString(R.string.p1c),getString(R.string.p1d),getString(R.string.s1));

        Pregunta p2 = new Pregunta(getString(R.string.p2),getString(R.string.p2a),getString(R.string.p2b),
                getString(R.string.p2c),getString(R.string.p2d),getString(R.string.s2));

        Pregunta p3 = new Pregunta(getString(R.string.p3),getString(R.string.p3a),getString(R.string.p3b),
                getString(R.string.p3c),getString(R.string.p3d),getString(R.string.s3));

        Pregunta p4 = new Pregunta(getString(R.string.p4),getString(R.string.p4a),getString(R.string.p4b),
                getString(R.string.p4c),getString(R.string.p4d),getString(R.string.s4));

        Pregunta p5 = new Pregunta(getString(R.string.p5),getString(R.string.p5a),getString(R.string.p5b),
                getString(R.string.p5c),getString(R.string.p5d),getString(R.string.s5));

        Pregunta p6 = new Pregunta(getString(R.string.p6),getString(R.string.p6a),getString(R.string.p6b),
                getString(R.string.p6c),getString(R.string.p6d),getString(R.string.s6));

        Pregunta p7 = new Pregunta(getString(R.string.p7),getString(R.string.p7a),getString(R.string.p7b),
                getString(R.string.p7c),getString(R.string.p7d),getString(R.string.s7));

        final Pregunta[] preguntas = {p1,p2,p3,p4,p5,p6,p7};
        preg.setText(preguntas[x].pregunta);
        rda.setText(preguntas[x].opA);
        rdb.setText(preguntas[x].opB);
        rdc.setText(preguntas[x].opC);
        rdd.setText(preguntas[x].opD);

        butNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if ((rda.isChecked()==true) && preguntas[x].opA.equals(preguntas[x].respuesta) ||
                        (rdb.isChecked()==true) && preguntas[x].opB.equals(preguntas[x].respuesta) ||
                        (rdc.isChecked()==true) && preguntas[x].opC.equals(preguntas[x].respuesta) ||
                        (rdd.isChecked()==true) && preguntas[x].opD.equals(preguntas[x].respuesta)){
                    score++;
                } else {
                    erradas += " "+Integer.toString(id);
                }
                x++;
                id++;
                rg.clearCheck();
                if (x < preguntas.length){
                    preg.setText(preguntas[x].pregunta);
                    rda.setText(preguntas[x].opA);
                    rdb.setText(preguntas[x].opB);
                    rdc.setText(preguntas[x].opC);
                    rdd.setText(preguntas[x].opD);

                } else {
                    butNext.setVisibility(v.GONE);
                    butFin.setVisibility(v.VISIBLE);

                    butFin.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            //AQUI SE GENERA EL DIALOG

                            final Dialog dialog = new Dialog(Recapitula.this);
                            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                            //dialog.setContentView(getLayoutInflater().inflate(R.layout.letra_recapitula, null));
                            dialog.setContentView(R.layout.letra_recapitula);

                            TextView text = (TextView) dialog.findViewById(R.id.letra_recap);
                            TextView text2 = (TextView) dialog.findViewById(R.id.letra_recap2);
                            TextView text3 = (TextView) dialog.findViewById(R.id.letra_recap3);
                            TextView text4 = (TextView) dialog.findViewById(R.id.letra_recap4);

                            text3.setText(getString(R.string.resultados));

                            if (score < 4 && score >0) {
                                text.setText(getString(R.string.r1_3)+erradas + "\n");
                            } else if (score == 0){
                                text.setText(getString(R.string.r0));
                            } else if (score == 7) {
                                text.setText(getString(R.string.r7)+ " " + score + " " + getString(R.string.puntos));
                            } else {
                                text.setText(getString(R.string.r4_6a) + score + " " +getString(R.string.puntos) +"\n\n"+
                                        getString(R.string.r4_6b) + erradas + "\n");
                            };

                            text2.setText(getString(R.string.intento));

                            text2.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    dialog.dismiss();
                                    startActivity(new Intent(Recapitula.this,Recapitula.class));
                                    finish();
                                }
                            });

                            text4.setText(getString(R.string.enviar));
                            text4.setOnClickListener(new View.OnClickListener() {
                                @Override
                                public void onClick(View v) {
                                    //dialog.dismiss();
                                    //Recapitula recapitula = new Recapitula();
                                    //FragmentTransaction ft = getFragmentManager().beginTransaction();
                                    //ft.replace(R.id.fragment_container, recapitula, "RECAPITULA");
                                    //ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                                    //ft.commit();


                                    String[] to = { "email@ejemplo.com" };
                                    String[] cc = { "anarvenezuela1@gmail.com" };
                                    enviar(to, cc, getString(R.string.asunto), getString(R.string.resultados)
                                            + "\n"+ getString(R.string.puntaje) + score + "\n"
                                            + getString(R.string.erradas) + erradas + "\n\n"
                                            + getString(R.string.mensaje));

                                }
                            });

                            dialog.show();

                            //aqui termina el dialog

                        }
                    });

                }
            }

            //aqui termina el boton
        });

    //aqui el oncreate
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            startActivity(new Intent(Recapitula.this, MainActivity.class)
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
            
            Intent presentacion = new Intent(Recapitula.this, Tab.class);
            presentacion.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(presentacion);
            finish();
        } else if (id == R.id.nav_petroglifo2) {
            Intent petroglifo2 = new Intent(Recapitula.this, Petroglifo2.class);
            petroglifo2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo2);
            finish();

        } else if (id == R.id.nav_pintura) {
            Intent pintura = new Intent(Recapitula.this, Pintura.class);
            pintura.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura);
            finish();

        } else if (id == R.id.nav_pintura2) {
            Intent pintura2 = new Intent(Recapitula.this, Pintura2.class);
            pintura2.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(pintura2);
            finish();

        } else if (id == R.id.nav_petroglifo) {
            Intent petroglifo = new Intent(Recapitula.this, Petroglifo.class);
            petroglifo.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(petroglifo);
            finish();

        } else if (id == R.id.nav_creditos) {
            Intent creditos = new Intent(Recapitula.this, Creditos.class);
            creditos.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(creditos);
            finish();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


    private void enviar(String[] to, String[] cc,String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }


    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }


}

