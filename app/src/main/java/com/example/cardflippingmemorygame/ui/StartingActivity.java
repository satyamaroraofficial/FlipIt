package com.example.cardflippingmemorygame.ui;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.cardflippingmemorygame.R;
import com.wajahatkarim3.easyflipview.EasyFlipView;

public class StartingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView easy = findViewById(R.id.easy);

        EasyFlipView flipView = findViewById(R.id.tile_line2);

        flipView.setOnFlipListener(new EasyFlipView.OnFlipAnimationListener() {
            @Override
            public void onViewFlipCompleted(EasyFlipView easyFlipView, EasyFlipView.FlipState newCurrentSide) {
                easyFlipView.setEnabled(false);

                easy.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        startActivity(new Intent(StartingActivity.this, EasyLevel.class));
                    }
                });
            }
        });
    }
}
