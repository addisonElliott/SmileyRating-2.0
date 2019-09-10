package com.aelliott.smileyrating;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RatingBar;

public class SmileyFace
{
    int index;
    PointF location;
    Path path;
    int smileType;

    public SmileyFace(int index)
    {
        this.index = index;

        location = new PointF();
        path = new Path();
    }

    public void setup()
    {

    }
}
