package com.example.cardflippingmemorygame.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cardflippingmemorygame.Constants;
import com.example.cardflippingmemorygame.R;
import com.example.cardflippingmemorygame.adapters.EasyLevelAdapter;
import com.wajahatkarim3.easyflipview.EasyFlipView;

import java.util.ArrayList;
import java.util.Random;

public class EasyLevel extends Fragment{

    private RecyclerView EasyLevelRecyclerView;
    public ArrayList<Integer> cards;
    public int CARDS[] = {
            R.drawable.card1,
            R.drawable.card2,
            R.drawable.card3,
            R.drawable.card4,
            R.drawable.card5,
            R.drawable.card6,
            R.drawable.card1,
            R.drawable.card2,
            R.drawable.card3,
            R.drawable.card4,
            R.drawable.card5,
            R.drawable.card6
    };
    EasyFlipView flippedCard;
    public long RemainingTime;
    public boolean isPaused, isCancelled;
    Bundle bundle;
    private SharedPreferences preferences;
    int pos, count, bestScore;

    public EasyLevel() {}

    public void fragmentTransaction(Bundle bundle) {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
//        final Result result = new Result();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_easy_level, container, false);

        EasyLevelRecyclerView = rootView.findViewById(R.id.easylevelview);
        bundle = new Bundle();
        bundle.putInt("level", Constants.LEVEL_EASY);
        preferences = getActivity().getSharedPreferences(Constants.PREF_NAME, 0);
        bestScore = preferences.getInt(Constants.EASY_HIGH_KEY, (int) (Constants.EASY_TIME / Constants.TIME_INTERVAL));

        ((TextView) rootView.findViewById(R.id.bestEasy)).append(bestScore + "");

        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getContext(), 3, LinearLayoutManager.VERTICAL, false);
        EasyLevelRecyclerView.setLayoutManager(layoutManager);
        EasyLevelRecyclerView.setAdapter(new EasyLevelAdapter(cards));

        cards = new ArrayList<>();
        //TODO shuffle cards
        shuffle(CARDS,Constants.EASY_NO_OF_CARDS);
        shuffle(CARDS,Constants.EASY_NO_OF_CARDS);//Double shuffle
        for(int card : CARDS) {
            cards.add(card);
        }

//        isPaused = false;
//        isCancelled = false;

        return rootView;
    }

    public void shuffle(int cards[], int n) {
        Random random = new Random();
        for(int i=0; i<n; i++) {
            int r = random.nextInt(n-i);
            int temp = cards[r];
            cards[r] = cards[i];
            cards[i] = temp;
        }
    }
}





