package com.example.finalproject4_busticketingapp.utils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.finalproject4_busticketingapp.R;
import com.example.finalproject4_busticketingapp.list.Trip;

import java.util.List;

public class TripAdapter extends ArrayAdapter<Trip> {
    Context context;
    List<Trip> arrayListTrip;


    public TripAdapter(@NonNull Context context, List<Trip> arrayListTrip) {
        super(context, R.layout.list_bus, arrayListTrip);
        this.context = context;
        this.arrayListTrip = arrayListTrip;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_bus, null, true);

        TextView hargaBus = view.findViewById(R.id.hargaBus);
        TextView idBus = view.findViewById(R.id.tv_id);
        TextView namaBus = view.findViewById(R.id.namaBus);

        idBus.setText(arrayListTrip.get(position).getIdTrip());
        namaBus.setText(arrayListTrip.get(position).getNamaBus());
        hargaBus.setText(arrayListTrip.get(position).getHarga());




        return view;
    }

}
