package com.example.cardflippingmemorygame.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.example.cardflippingmemorygame.R;

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
        super.onBackPressed();
    }
}
