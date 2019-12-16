package com.example.cardflippingmemorygame.ui;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.cardflippingmemorygame.R;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.layoutFragment, new Start());
        transaction.commit();
    }

    int counter = 0;

    @Override
    public void onBackPressed() {
        Fragment currentFragment = getSupportFragmentManager().findFragmentById(R.id.layoutFragment);

        counter++;
        if (currentFragment instanceof Start) {
            new MaterialAlertDialogBuilder(this, R.style.Theme_MaterialComponents_DayNight_Dialog_Alert)
                    .setTitle("Do you really want to go?")
                    .setPositiveButton("Yes, please", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("Umm, I can stay", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(HomeActivity.this, "Welcome back", Toast.LENGTH_SHORT).show();
                        }
                    })
                    .show();
            //TODO else if with result fragment
        } else {
            super.onBackPressed();
        }
    }
}
