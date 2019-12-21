package com.example.cardflippingmemorygame.ui;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.cardflippingmemorygame.Constants;
import com.example.cardflippingmemorygame.R;
import com.example.cardflippingmemorygame.SoundPlayer;

import nl.dionsegijn.konfetti.KonfettiView;
import nl.dionsegijn.konfetti.models.Shape;
import nl.dionsegijn.konfetti.models.Size;

public class Result extends Fragment {

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private int bestEasyScore, bestHardScore;

    public Result() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_result, container, false);
        KonfettiView konfettiView = view.findViewById(R.id.viewKonfetti);

        preferences = getActivity().getSharedPreferences("HighScore", 0);
        editor = preferences.edit();

        bestEasyScore = preferences.getInt(Constants.EASY_HIGH_KEY,32);
        bestHardScore = preferences.getInt(Constants.HARD_HIGH_KEY,42);

        Bundle bundle = getArguments();
        if(bundle.getString("Data").equals("win")) {
            konfettiView.build()
                    .addColors(Color.parseColor("#fce18a"), Color.parseColor("#ff726d"), Color.parseColor("#b48def"), Color.parseColor("#f4306d"))
                    .setDirection(0.0,359.0)
                    .setSpeed(4f,7f)
                    .setFadeOutEnabled(true)
                    .setTimeToLive(2000)
                    .addSizes(new Size(12,2f), new Size(16, 6f))
                    .addShapes(Shape.CIRCLE, Shape.RECT)
//                    .setPosition(-50f, konfettiView.getWidth() + 500f, -50f, -50f)
                    .setPosition(-50f, konfettiView.getWidth() + 1000f, -50f, -50f)
                    .stream(400,500000L);

            //TODO play music for a win
            new SoundPlayer(getContext()).playSound("winning_sound.mp3");

            if(Integer.valueOf(bundle.get("level").toString()) == Constants.LEVEL_EASY) {
                if (Integer.valueOf(bundle.get("Time").toString()) < bestEasyScore){
                    editor.putInt(Constants.EASY_HIGH_KEY,Integer.valueOf(bundle.get("Time").toString())).apply();
                    ((TextView) view.findViewById(R.id.newhigh)).setText("New High Score!");
                }
            } else if(Integer.valueOf(bundle.get("level").toString()) == Constants.LEVEL_HARD) {
                if (Integer.valueOf(bundle.get("Time").toString()) < bestHardScore){
                    editor.putInt(Constants.HARD_HIGH_KEY,Integer.valueOf(bundle.get("Time").toString())).apply();
                    ((TextView) view.findViewById(R.id.newhigh)).setText("New High Score!");
                }
            }

            ((TextView) view.findViewById(R.id.r1)).setText("N");
            ((TextView) view.findViewById(R.id.r2)).setText("I");
            ((TextView) view.findViewById(R.id.r3)).setText("C");
            ((TextView) view.findViewById(R.id.r4)).setText("E");
            ((TextView) view.findViewById(R.id.desc1)).setText("You won!");
            ((TextView) view.findViewById(R.id.desc2)).setText("Nice work, you can always improve your best time");
            ((TextView) view.findViewById(R.id.time)).setText("Your time : "+bundle.get("Time").toString());
        } else {
            ((TextView)view.findViewById(R.id.r1)).setText("L");
            ((TextView)view.findViewById(R.id.r2)).setText("O");
            ((TextView)view.findViewById(R.id.r3)).setText("S");
            ((TextView)view.findViewById(R.id.r4)).setText("T");
            ((TextView) view.findViewById(R.id.desc1)).setText("Nice  try, but you lost.");
            ((TextView) view.findViewById(R.id.desc2)).setText("Try improving the score to win");
            ((TextView) view.findViewById(R.id.time)).setText("Your time : "+bundle.get("Time").toString());
        }
        return view;
    }
}
