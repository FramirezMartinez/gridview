package com.example.applistviewpersonalizado;

import static com.example.applistviewpersonalizado.R.layout.activity_main;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
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
            "Área ",
            "Área ",
            "Área ",
            " "

    };
    private String areasFormulas[] = {
            "√s(s-a)(s-a)(s-b)",
            "√s(s-a)(s-b)(s-c)",
            "((B1+B2)*h)/2",
            " "

    };

    private String perimetrosFiguras[] = {
            "Perímetro",

            "Perímetro",

            "Perímetro",

            "Volumen  "


    };
    private String perimetrosFormulas[] = {
             "a + a + b",

             "a + b + c",

             "B1+B2+2*L",

             "πR²h"


    };
    private GridView gridView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(activity_main);
        gridView = findViewById(R.id.gridview);

        // instanceamos la clase para cargar las imagenes
        BaseAdapterPersonalizada adapter = new BaseAdapterPersonalizada(this, listaImagenes, perimetrosFiguras, perimetrosFormulas, areasFiguras, areasFormulas);
        gridView.setAdapter(adapter);
        // Dentro evento comparamos cuando se detecte una posicion
        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener()
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