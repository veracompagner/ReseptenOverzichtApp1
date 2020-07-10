package com.example.reseptenoverzichtapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class ReceptAdapter extends RecyclerView.Adapter<ReceptAdapter.ReceptViewHolder> {
    private Recept[] recepten;


    public static class ReceptViewHolder extends RecyclerView.ViewHolder{
        public TextView textView;

        public ReceptViewHolder(View v){
            super(v);
            textView = v.findViewById(R.id.textView);

        }
    }

    public ReceptAdapter(Recept[] recepten){
        this.recepten = recepten;
    }

    @NonNull
    @Override
    public ReceptViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //create new view
        View v = (CardView) LayoutInflater.from(parent.getContext()).inflate(R.layout.recept_card, parent, false);
        ReceptViewHolder receptViewHolder = new ReceptViewHolder(v);
        return receptViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ReceptViewHolder holder, int position) {
        holder.textView.setText(recepten[position].getGerecht());

    }

    @Override
    public int getItemCount() {
        return recepten.length;
    }



}
