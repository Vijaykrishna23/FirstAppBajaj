package com.example.helloworld;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CountriesAdapter extends RecyclerView.Adapter<CountriesAdapter.CountriesViewHolder> {

    String[] mCountries;

    public CountriesAdapter(String[] mCountries) {
        this.mCountries = mCountries;
    }

    @NonNull
    @Override
    public CountriesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowPlank = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_item_row_plank,parent,false);
        return new CountriesViewHolder(rowPlank);     }

    @Override
    public void onBindViewHolder(@NonNull CountriesViewHolder holder, int position) {
        holder.rowTextView.setText(mCountries[position]);
    }

    @Override
    public int getItemCount() {
        return mCountries.length;
    }


    class CountriesViewHolder extends RecyclerView.ViewHolder {

        TextView rowTextView;
        public CountriesViewHolder(@NonNull View itemView) {
            super(itemView);
            rowTextView = itemView.findViewById(R.id.tvRow);
        }
    }
}
