package com.example.deadbycards;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SurvivorViewHolder extends RecyclerView.ViewHolder {
    ImageView imageView;
    TextView survivorName, survivorPerkOne, survivorPerkTwo, survivorPerkThree, survivorPerkFour;

    public SurvivorViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView = itemView.findViewById(R.id.imageView);
        survivorName = itemView.findViewById(R.id.textViewName);
        survivorPerkOne = itemView.findViewById(R.id.textViewPerkOne);
        survivorPerkTwo = itemView.findViewById(R.id.textViewPerkTwo);
        survivorPerkThree = itemView.findViewById(R.id.textViewPerkThree);
        survivorPerkFour = itemView.findViewById(R.id.textViewPerkFour);
    }
}
