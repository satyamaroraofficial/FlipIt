package com.example.cardflippingmemorygame.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardflippingmemorygame.R;

import java.util.ArrayList;

public class EasyLevelAdapter extends RecyclerView.Adapter<EasyLevelAdapter.ViewHolder> {

    private ArrayList<Integer> cardFront;

    public EasyLevelAdapter(ArrayList<Integer> cardFront) {
        this.cardFront = cardFront;
    }

    @NonNull
    @Override
    public EasyLevelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        view.setMinimumWidth(parent.getMeasuredWidth() / 3);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EasyLevelAdapter.ViewHolder holder, int position) {
        holder.cardFr.setImageResource(cardFront.get(position));
    }

    @Override
    public int getItemCount() {
        return cardFront.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView cardFr;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cardFr = itemView.findViewById(R.id.cardfront);
        }
    }
}
