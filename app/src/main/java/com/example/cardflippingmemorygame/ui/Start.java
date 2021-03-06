package com.example.cardflippingmemorygame.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cardflippingmemorygame.R;
import com.google.android.material.button.MaterialButton;
import com.wajahatkarim3.easyflipview.EasyFlipView;

public class Start extends Fragment {

    public Start() {}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_start, container, false);
        EasyFlipView flipView = rootView.findViewById(R.id.tile_line2);
        final TextView easy = rootView.findViewById(R.id.easy);
        final TextView hard = rootView.findViewById(R.id.hard);
        final Button button = rootView.findViewById(R.id.leaderboard);

        flipView.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                easyFlipView.setFlipEnabled(false);

                easy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragmentTransaction(new EasyLevel());
                    }
                });

                hard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        fragmentTransaction(new HardLevel());
                    }
                });
            }
        });

        //TODO Add leaderBoard onClick
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(getContext(), "Clicked", Toast.LENGTH_SHORT).show();
                fragmentTransaction(new Leaderboard());
            }
        });
        return rootView;
    }

    private void fragmentTransaction(Fragment fragment) {
        FragmentTransaction transaction = getFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
