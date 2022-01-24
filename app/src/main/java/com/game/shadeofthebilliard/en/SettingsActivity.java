package com.game.shadeofthebilliard.en;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.game.shadeofthebilliard.R;

public class SettingsActivity extends AppCompatActivity {
    private RelativeLayout mSound;
    private RelativeLayout mLanguage;
    private Button mOff;
    private Button mOn;
    private LinearLayout mShowButtons;
    private ImageButton mBackButton;
    private ImageButton mLangButton;
    private Boolean isOn=true;
    private Boolean isOff=false;
    private MainMenuActivity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        mSound = (RelativeLayout) findViewById(R.id.soundlayout);
        mLanguage = (RelativeLayout) findViewById(R.id.Languagelayout);
        mShowButtons = (LinearLayout) findViewById(R.id.mute_layout);
        mOn = (Button) findViewById(R.id.on_btn);
        mOff = (Button) findViewById(R.id.off_btn);
        mBackButton = (ImageButton) findViewById(R.id.backbtn);
        mLangButton = (ImageButton) findViewById(R.id.eng);
        mActivity = new MainMenuActivity();


        mBackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SettingsActivity.this,
                        MainMenuActivity.class);
                startActivity(intent);
            }
        });

        mSound.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowButtons.setVisibility(View.VISIBLE);
            }
        });

        mOff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowButtons.setVisibility(View.INVISIBLE);
                if (mOn.equals(true) )
                    switchOff();

            }
        });

        mOn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mShowButtons.setVisibility(View.INVISIBLE);
                if (mOff.equals(true))
                    switchOn();
            }
        });

        mLanguage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLangButton.setVisibility(View.VISIBLE);
                // TODO;// set language from en to ru
            }
        });
        mLangButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mLangButton.setVisibility(View.INVISIBLE);
            }
        });


    }
    public void switchOn()
    {
        isOn=true;
        isOff= false;
        mActivity.mBackgroundMusic.start();
    }
    public void switchOff()
    {
        isOn=false;
        isOff = true;
        mActivity.mBackgroundMusic.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}