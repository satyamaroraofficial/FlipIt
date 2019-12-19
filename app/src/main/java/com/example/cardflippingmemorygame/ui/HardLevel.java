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

public class HardLevel extends Fragment {

    private RecyclerView HardLevelRecyclerView;
    private ArrayList<Integer> cards;
    private int CARDS[] = {
            R.drawable.card1,
            R.drawable.card2,
            R.drawable.card3,
            R.drawable.card4,
            R.drawable.card5,
            R.drawable.card6,
            R.drawable.card7,
            R.drawable.card8,
            R.drawable.card1,
            R.drawable.card2,
            R.drawable.card3,
            R.drawable.card4,
            R.drawable.card5,
            R.drawable.card6,
            R.drawable.card7,
            R.drawable.card8,
    };
    EasyFlipView flippedCard;
    private Bundle bundle;
    public long RemainingTime;
    public boolean isPaused, isCancelled;
    private SharedPreferences preferences;
    int pos, count, bestScore;

    public HardLevel() {}

    public void shuffle(int cards[], int n) {
        Random random = new Random();

        for(int i=0; i<n; i++) {
            int r = random.nextInt(n-i);

            int temp = cards[r];
            cards[r] = cards[i];
            cards[i] = temp;
        }
    }

    public void fragmentTransaction(Bundle bundle) {
        final FragmentTransaction transaction = getFragmentManager().beginTransaction();
        final Result r = new Result();
        r.setArguments(bundle);
        transaction.replace(R.id.layoutFragment, r);
        transaction.commit();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_hard_level, container, false);

        HardLevelRecyclerView = view.findViewById(R.id.hardlevelview);
        bundle=new Bundle();
        bundle.putInt("level", Constants.LEVEL_HARD);

        preferences = getActivity().getSharedPreferences(Constants.PREF_NAME,0);
        bestScore = preferences.getInt(Constants.HARD_HIGH_KEY, (int) (Constants.HARD_TIME/Constants.TIMER_INTERVAL));

        ((TextView) view.findViewById(R.id.bestHard)).append(bestScore+"");


        RecyclerView.LayoutManager lm= new GridLayoutManager(getContext(),4, LinearLayoutManager.VERTICAL,false);
        HardLevelRecyclerView.setLayoutManager(lm);

        cards = new ArrayList<>();

        //card shuffle here
        shuffle(CARDS,Constants.HARD_NO_OF_CARDS);
        shuffle(CARDS,Constants.HARD_NO_OF_CARDS);
        for (int card : CARDS){
            cards.add(card);
        }
        HardLevelRecyclerView.setAdapter(new EasyLevelAdapter(cards));

        isPaused = false;
        isCancelled = false;


        return view;
    }
}
