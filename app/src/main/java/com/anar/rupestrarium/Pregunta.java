package com.anar.rupestrarium;

import android.app.Presentation;

/**
 * Created by Sahid on 19/9/2016.
 */
public class Pregunta {
    int id;
    String pregunta;
    String opA;
    String opB;
    String opC;
    String opD;
    String respuesta;
    int pto;
/*
    public Pregunta(){
        id = 0;
        pregunta = "";
        opA = "";
        opB = "";
        opC = "";
        opD = "";
        respuesta = "";
        pto = 0;
    }
*/
    public Pregunta(String preg, String a, String b, String c, String d, String resp){
        id = 0;
        pregunta = preg;
        opA = a;
        opB = b;
        opC = c;
        opD = d;
        respuesta = resp;
        pto = 0;
    }
}


