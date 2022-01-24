package com.game.shadeofthebilliard.en;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public class Character {
    private Bitmap image;
    public Character(Bitmap bmp){
        image=bmp;
    }
    public void draw(Canvas canvas){
        canvas.drawBitmap(image,200,200, null);
    }
}
