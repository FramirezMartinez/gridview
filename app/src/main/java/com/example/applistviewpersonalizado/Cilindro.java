package com.example.applistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class Cilindro extends AppCompatActivity  implements View.OnClickListener{
 private EditText r, h;

private ImageView cilindro, regresar;
private TextView resultado;

private Button calcular, btnlimpiar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cilindro);

        r=findViewById(R.id.radio);
        h=findViewById(R.id.altura);
        regresar=findViewById(R.id.regresar);
        calcular=findViewById(R.id.btnCalcular);
        btnlimpiar=findViewById(R.id.btnlimpiar);
        cilindro=findViewById(R.id.imgCilindro);
        resultado=findViewById(R.id.volumen);

        calcular.setOnClickListener(this);
        btnlimpiar.setOnClickListener(this);
        regresar.setOnClickListener(this);

        cilindro.setVisibility(View.INVISIBLE);
        r.requestFocus();
    }

    @Override
    public void onClick(View v) {

        String altura = h.getText().toString();
        String radio = r.getText().toString();

        double a = Double.parseDouble(radio);
        double b = Double.parseDouble(altura);

        double volumens;

        if(v.getId() == R.id.btnCalcular){

            cilindro.setVisibility(View.VISIBLE);

            volumens=Math.PI*Math.pow(a,2)*b;

            resultado.setText("Volumen = " + String.format("%.2f", volumens));
        } else if(v.getId() == R.id.btnlimpiar) {


            r.setText("");
            h.setText("");
            resultado.setText("");
            cilindro.setVisibility(View.INVISIBLE);
            r.requestFocus();

        }

        else if(v.getId() == R.id.regresar){
            Intent intent = new Intent(Cilindro.this, MainActivity.class);
            startActivity(intent);
        }
    }
}