package com.example.applistviewpersonalizado;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class Isosceles extends AppCompatActivity implements View.OnClickListener
{
    // Declaramos las variables que vamos a utilizar
    private EditText etA, etB;
    private TextView tvArea, tvPerimetro;
    private Button Calcular, Limpiar;

    private ImageView triangulo,regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_isosceles);
        // hacemos referenica a los elementos que tenemos del xml
        // EDIT TEXT DE TIPO NÚMERO
        etA = findViewById(R.id.etA);
        etB = findViewById(R.id.etB);

        // VISTA DE TEXTO
        tvArea = findViewById(R.id.tvArea);
        tvPerimetro = findViewById(R.id.tvPerimetro);

        // BOTONES
        Calcular = findViewById(R.id.Calcular);
        Limpiar = findViewById(R.id.Limpiar);
        regresar = findViewById(R.id.regresar);

        //IMÁGENES
        triangulo=findViewById(R.id.triangulo);

        // REFERENCIA DEL EVENTO ONCLICKLISTENER
        Calcular.setOnClickListener(this);
        Limpiar.setOnClickListener(this);
        regresar.setOnClickListener(this);

        triangulo.setVisibility(View.INVISIBLE);

    }


    @Override
    public void onClick(View view) {

        if(view.getId()==R.id.Calcular) {
            triangulo.setVisibility(View.VISIBLE);
            // CONVERSION A TEXTO
            String textA = etA.getText().toString();
            String textB = etB.getText().toString();
            // CONVERSION DE CADENA DE TEXTO A NUMERO ENTERO
            int a = Integer.parseInt(textA);
            int b = Integer.parseInt(textB);

            double area, perimetro;
            perimetro = (a * 2) + b;
            double s =  perimetro / 2;
            area = Math.sqrt((s*(s-a)*(s-a)*(s-b)));

            // Actualiza los TextViews con los resultados
            tvPerimetro.setText("Perímetro = " +String.format("%.2f",perimetro));
            tvArea.setText("Área = " +String.format("%.2f",area));
        }
        else if (view.getId()==R.id.Limpiar){

            tvArea.setText("");
            tvPerimetro.setText("");
            etA.setText("");
            etB.setText("");
            triangulo.setVisibility(View.INVISIBLE);

        }else if(view.getId()==R.id.regresar) {
            Intent intent = new Intent(Isosceles.this, MainActivity.class);
            startActivity(intent);
        }

    }

}