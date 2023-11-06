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

public class Trapecio extends AppCompatActivity  implements View.OnClickListener{
private Button btnCalcular, btnlimpiar;

private ImageView trapecio,regresar;
private TextView tvarea, tvperimetro;
private EditText base1, base2, lado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trapecio);
    base1=findViewById(R.id.base1);
    base2=findViewById(R.id.base2);
    lado=findViewById(R.id.lado);
    tvarea=findViewById(R.id.tvarea);
    tvperimetro=findViewById(R.id.tvperimetro);
    trapecio=findViewById(R.id.trapecio);

    btnCalcular=findViewById(R.id.btnCalcular);
    btnlimpiar=findViewById(R.id.btnlimpiar);
    regresar=findViewById(R.id.regresar);

    btnCalcular.setOnClickListener(this);
    btnlimpiar.setOnClickListener(this);
    regresar.setOnClickListener(this);

    trapecio.setVisibility(View.INVISIBLE);
    base1.requestFocus();
    }

    @Override
    public void onClick(View v) {
        String basem1 = base1.getText().toString();
        String basem2 = base2.getText().toString();
        String lados =lado.getText().toString();
        double a = Double.parseDouble(basem1);
        double b = Double.parseDouble(basem2);
        double c = Double.parseDouble(lados);
        double area, perimetro;

        if(v.getId() == R.id.btnCalcular){
            trapecio.setVisibility(View.VISIBLE);

            perimetro = a + b * c;

            area =((a+b)*c)/2;

            tvperimetro.setText("Perímetro = " +String.format("%.2f", perimetro));
           tvarea.setText("Área = " + String.format("%.2f",area));


        }  else if (v.getId()==R.id.btnlimpiar) {
            tvarea.setText("");
            tvperimetro.setText("");
            base1.setText("");
            base2.setText("");
            lado.setText("");
            trapecio.setVisibility(View.INVISIBLE);
            base1.requestFocus();
        }
        else if(v.getId() == R.id.regresar){
            Intent intent = new Intent(Trapecio.this, MainActivity.class);
            startActivity(intent);
        }
  }
}