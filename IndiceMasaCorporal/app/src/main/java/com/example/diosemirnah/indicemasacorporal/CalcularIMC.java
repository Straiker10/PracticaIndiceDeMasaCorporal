package com.example.diosemirnah.indicemasacorporal;

import android.widget.Toast;

/**
 * Created by Diosemir Nah on 30/03/2017.
 */

public class CalcularIMC extends MainActivity {

    public double calcular(float kg,float cm) {


        float m = (cm / 100);
        float bmi = (kg / (m * m));
        return bmi;
    }
}
