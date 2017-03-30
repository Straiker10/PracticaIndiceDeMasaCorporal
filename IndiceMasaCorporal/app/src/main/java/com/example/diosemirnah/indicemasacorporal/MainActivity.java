package com.example.diosemirnah.indicemasacorporal;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    EditText peso, altura;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button calcular = (Button) findViewById(R.id.calcular);
        calcular.setOnClickListener(this);

        Button salir = (Button) findViewById(R.id.salir);
        salir.setOnClickListener(this);

        peso = (EditText) findViewById(R.id.peso);
        altura = (EditText) findViewById(R.id.altura);

    }

    //En este metodo se limpian los EditText despues de hacer un calculo
    public void limpiar(){
        peso.setText("");
        altura.setText("");
    }

    //Este metodo sirve para calcular el IMC segun los datos ingresados
    public void CalcularIMC(){

        float kg = Float.parseFloat(peso.getText().toString());
        float cm = Float.parseFloat(altura.getText().toString());
        float m = (cm / 100);
        float bmi = (kg / (m * m));

        if (bmi < 18.5) {
            Toast.makeText(MainActivity.this,
                    "Tu IMC es " + bmi + "\n" + "Estas delgado",
                    Toast.LENGTH_SHORT).show();
            limpiar();
        } else {
            if (bmi < 24.9) {
                Toast.makeText(
                        MainActivity.this,
                        "Tu IMC es " + bmi + "\n"
                                + "Tu peso es normal",
                        Toast.LENGTH_SHORT).show();
                limpiar();
            } else {
                if (bmi < 29.9) {
                    Toast.makeText(
                            MainActivity.this,
                            "Tu IMC es " + bmi + "\n"
                                    + "Tienes sobrepeso",
                            Toast.LENGTH_SHORT).show();
                    limpiar();

                } else {
                    if (bmi > 30) {
                        Toast.makeText(
                                MainActivity.this,
                                "Tu IMC es " + bmi + "\n"
                                        + "Padeces obesidad",
                                Toast.LENGTH_SHORT).show();
                        limpiar();
                    }
                }
            }
        }
    }

    //En este metodo se ejecutan los eventos de los dos botones colocados
    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.salir:
                System.exit(0);
                break;
            case R.id.calcular:
                if (peso.getText().toString().trim().length() == 0) {
                    peso.requestFocus();

                    Toast.makeText(MainActivity.this,
                            "El campo peso esta vacio", Toast.LENGTH_SHORT)
                            .show();
                } else if (altura.getText().toString().trim().length() == 0) {
                    altura.requestFocus();

                    Toast.makeText(MainActivity.this,
                            "El campo altura esta vacio",
                            Toast.LENGTH_SHORT).show();
                } else {
                    CalcularIMC();
                    break;
                }
        }
    }
}
