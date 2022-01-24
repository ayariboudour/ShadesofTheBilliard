package com.game.shadeofthebilliard.en;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.RelativeLayout;

import com.game.shadeofthebilliard.R;

public class MainMenuActivity extends AppCompatActivity {
    private ImageButton mStartButton;
    private RelativeLayout mLevels;
    private RelativeLayout mSettings;
    public MediaPlayer mBackgroundMusic ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        mBackgroundMusic=  MediaPlayer.create(MainMenuActivity.this, R.raw.meny_game );
        mBackgroundMusic.start();
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
        mLevels.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,
                        LevelsActivity.class);
                startActivity(intent);
            }
        });
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainMenuActivity.this,
                        GamePlayActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();
        mBackgroundMusic.pause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        mBackgroundMusic.start();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBackgroundMusic.stop();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBackgroundMusic.stop();
    }

}