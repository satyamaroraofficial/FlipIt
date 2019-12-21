package com.example.cardflippingmemorygame;

import android.content.Context;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;

public class SoundPlayer {
    Context context;

    public SoundPlayer(Context context) {
        this.context = context;
    }

    MediaPlayer player = null;
    public void playSound(String fileName) {
        player = new MediaPlayer();
        try{
            AssetFileDescriptor assetFileDescriptor = context.getAssets().openFd(fileName);
            player.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
            assetFileDescriptor.close();
            player.prepare();
        } catch (Exception e) {
            e.printStackTrace();
        }
        player.start();
    }
}
