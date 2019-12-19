package com.example.cardflippingmemorygame.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardflippingmemorygame.R;
import com.example.cardflippingmemorygame.ui.HardLevel;

import java.util.ArrayList;

public class HardLevelAdapter extends RecyclerView.Adapter<HardLevelAdapter.ViewHolder> {

    private ArrayList<Integer> cardFront;

    public HardLevelAdapter(ArrayList<Integer> cardFront) { this.cardFront = cardFront;}

    @Override
    public HardLevelAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HardLevelAdapter.ViewHolder holder, int position) {
        holder.cardFr.setImageResource(cardFront.get(position));
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView cardFr;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardFr = itemView.findViewById(R.id.cardfront);
        }
    }
}
