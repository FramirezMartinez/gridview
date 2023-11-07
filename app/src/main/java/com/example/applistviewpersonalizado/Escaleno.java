package com.example.applistviewpersonalizado;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Escaleno extends AppCompatActivity implements  View.OnClickListener{
    private EditText etA, etB, etC;
    private TextView tvArea, tvPerimetro;
    private Button  Calcular, Limpiar;
    private ImageView escaleno,regresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escaleno);

        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);
        etC = findViewById(R.id.etC);
        // VISTA DE TEXTO
        tvArea = findViewById(R.id.Area);
        tvPerimetro = findViewById(R.id.Perimetro);

        // BOTONES
        Calcular = findViewById(R.id.btnCalcular);
        Limpiar = findViewById(R.id.btnLimpiar);
        regresar = findViewById(R.id.regresar);

        // REFERENCIA DEL EVENTO ONCLICKLISTENER
        Calcular.setOnClickListener(this);
        Limpiar.setOnClickListener(this);
        regresar.setOnClickListener(this);

        //IMÁGENES
        escaleno=findViewById(R.id.escaleno);

        escaleno.setVisibility(View.INVISIBLE);

    }

    @Override
    public void onClick(View v) {
            String textA = etA.getText().toString();
            String textB = etB.getText().toString();
            String textC = etC.getText().toString();
            double a = Double.parseDouble(textA);
            double b = Double.parseDouble(textB);
            double c = Double.parseDouble(textC);
            double s;
            double area, perimetro;
            if(v.getId() == R.id.btnCalcular){
                escaleno.setVisibility(View.VISIBLE);

                perimetro = a + b + c;
                s =  perimetro / 2;
                area = Math.sqrt((s*(s-a)*(s-b)*(s-c)));
                tvPerimetro.setText("Perímetro = " + String.format("%.2f",perimetro));
                tvArea.setText("Área = " +String.format("%.2f", area));
            } else if(v.getId() == R.id.btnLimpiar) {
               tvArea.setText("");
               tvPerimetro.setText("");
                etA.setText("");
                etB.setText("");
                etC.setText("");
                escaleno.setVisibility(View.INVISIBLE);


            } else if(v.getId() == R.id.regresar){
            Intent intent = new Intent(Escaleno.this, MainActivity.class);
            startActivity(intent);
        }
    }
}