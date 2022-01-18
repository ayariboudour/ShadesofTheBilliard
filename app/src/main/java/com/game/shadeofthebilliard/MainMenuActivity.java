package com.game.shadeofthebilliard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

public class MainMenuActivity extends AppCompatActivity {
    private ImageButton mStartButton;
    private RelativeLayout mLevels;
    private RelativeLayout mSettings;
    public MediaPlayer mBackgroundMusic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        //start service and play music
        startService(new Intent(MainMenuActivity.this, SoundService.class));
        //Start Button
        mStartButton = (ImageButton) findViewById(R.id.start);
        // levels button
        mLevels = (RelativeLayout) findViewById(R.id.levelslayout);
        //setting button
        mSettings = (RelativeLayout) findViewById(R.id.settingslayout);

        mSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,
                        SettingsActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //stop service and stop music
        stopService(new Intent(MainMenuActivity.this, SoundService.class));
    }

}