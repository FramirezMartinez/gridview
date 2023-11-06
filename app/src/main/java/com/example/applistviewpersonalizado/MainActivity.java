package com.example.applistviewpersonalizado;

import static com.example.applistviewpersonalizado.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    private int listaImagenes[] = {
            R.drawable.isoceles2,
            R.drawable.escaleno,
            R.drawable.trapecio,
            R.drawable.cilindros2

    };
    private String areasFiguras[] = {
            "Área = √s(s-a)(s-a)(s-b)",
            "Área = √s(s-a)(s-b)(s-c)",
            "Área=((Bmayor+Bmenor)*h)/2",
            " "

    };

    private String perimetrosFiguras[] = {
            "Perímetro = a + a + b",

            "Perímetro = a + b + c",

            "Perímetro=(Bmayor+Bmenor+2*lado)",

            "Volumen  =πr²h"


    };
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        listView = findViewById(R.id.listviewPersonalizado);

        // instanceamos la clase para cargar las imagenes
        BaseAdapterPersonalizada adapter = new BaseAdapterPersonalizada(this, listaImagenes, perimetrosFiguras, areasFiguras);
        listView.setAdapter(adapter);
        // Dentro evento comparamos cuando se detecte una posicion
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
                                        {
                                            @Override
                                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                                if(position==0) {
                                                    Intent intent = new Intent(MainActivity.this, Isosceles.class);
                                                    startActivity(intent);
                                                } else if (position==1) {
                                                    Intent intent = new Intent(MainActivity.this, Escaleno.class);
                                                    startActivity(intent);
                                                }

                                                else if (position==2) {
                                                    Intent intent = new Intent(MainActivity.this, Trapecio.class);
                                                    startActivity(intent);
                                                }

                                                else if (position==3) {
                                                    Intent intent = new Intent(MainActivity.this,Cilindro.class);
                                                    startActivity(intent);
                                                }
                                                  Toast.makeText(MainActivity.this, "Seleccionaste la figura " + (position + 1), Toast.LENGTH_SHORT).show();
                                            }
                                        }
        );
    }
}