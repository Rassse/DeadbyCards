package com.example.deadbycards;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class SurvivorLoadoutManager extends RecyclerView.Adapter<SurvivorViewHolder> {

    private Context context;
    private ArrayList<Survivor> survivors;

    public SurvivorLoadoutManager(Context context, ArrayList<Survivor> survivors) {
        this.context = context;
        this.survivors = survivors;
    }

    @NonNull
    @Override
    public SurvivorViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SurvivorViewHolder(LayoutInflater.from(context).inflate(R.layout.survivor_view_holder, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull SurvivorViewHolder holder, int position) {
        holder.
    }

    @Override
    public int getItemCount() {
        return 0;
    }
}
