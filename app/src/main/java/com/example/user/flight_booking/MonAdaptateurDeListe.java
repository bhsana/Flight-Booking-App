package com.example.user.flight_booking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MonAdaptateurDeListe extends ArrayAdapter<String> {

    private Integer[] tab_images_pour_la_liste = {
            R.drawable.tunisie,
            R.drawable.inde,
            R.drawable.tailand,
            R.drawable.korea,
            R.drawable.swiss,
            R.drawable.canada,
            R.drawable.france,
            R.drawable.italie,
            R.drawable.tirquie,
            R.drawable.espagne,
            R.drawable.uk,
            R.drawable.mexique,
            R.drawable.almagne

    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.rowlayout, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        textView.setText(getItem(position));


            imageView.setImageResource(tab_images_pour_la_liste[position]);


        return rowView;
    }

    public MonAdaptateurDeListe(Context context, String[] values) {
        super(context, R.layout.rowlayout, values);
    }
}