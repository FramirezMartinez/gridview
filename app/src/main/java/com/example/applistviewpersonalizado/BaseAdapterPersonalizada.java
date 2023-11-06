package com.example.applistviewpersonalizado;

import android.content.Context;
import android.graphics.Typeface;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class BaseAdapterPersonalizada extends BaseAdapter {
    private Context context;
    private int listaImagenes[];
    private String listaPerimetros[];
    private String listaAreas[];

    public BaseAdapterPersonalizada(Context context, int listaImagenes[], String listaPerimetros[], String listaAreas[]) {
        this.context = context;
        this.listaImagenes = listaImagenes;
        this.listaPerimetros = listaPerimetros;
        this.listaAreas = listaAreas;
    }

    @Override
    public int getCount() {
        return listaImagenes.length;
    }

    @Override
    public Object getItem(int position) {
        return listaImagenes[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imageView);
        TextView textView1 = convertView.findViewById(R.id.perimetros);
        TextView textView2 = convertView.findViewById(R.id.areas);

        imageView.setImageResource(listaImagenes[position]);

        // Texto del perímetro con estilo de negrita para las primeras 8 letras
        String periText = listaPerimetros[position];
        SpannableString negritaP = new SpannableString(periText);
        negritaP.setSpan(new StyleSpan(Typeface.BOLD), 0, Math.min(9, negritaP.length()), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Texto del área con estilo de negrita para las primeras 5 letras
        String areaText = listaAreas[position];
        SpannableString negritaA = new SpannableString(areaText);
        negritaA.setSpan(new StyleSpan(Typeface.BOLD), 0, Math.min(5, negritaA.length()), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Establecer el texto formateado en los TextViews
        textView1.setText(negritaP);
        textView2.setText(negritaA);

        return convertView;
    }

}
