package com.aelliott.smileyrating;


import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.os.Build;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class SmileyRating extends View
{
    private int numSmileyFaces = 5;
    private List<SmileyFace> smileyFaces = new ArrayList<>(numSmileyFaces);

    public SmileyRating(Context context)
    {
        this(context, null);
    }

    public SmileyRating(Context context, @Nullable AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public SmileyRating(Context context, @Nullable AttributeSet attrs, int defStyleAttr)
    {
        super(context, attrs, defStyleAttr);

        init();
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public SmileyRating(Context context, @Nullable AttributeSet attrs, int defStyleAttr,
            int defStyleRes)
    {
        super(context, attrs, defStyleAttr, defStyleRes);

        init();
    }

    private void init()
    {
        // Create smiley faces
        for (int i = 0; i < numSmileyFaces; ++i)
            smileyFaces.add(new SmileyFace(i));
    }

    private void setupSmileyFaces()
    {
        for (SmileyFace smileyFace : smileyFaces)
        {
//            smileyFace.location.y = mCenterY;
//            getSmiley(mSmileys, smileyFace.index * 0.25f, divisions, mFromRange, mToRange, smileyFace.location, smileyFace.path,
//                    mCenterY);

            smileyFace.setup();
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        final int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        final int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        final int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        final int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        int desiredWidth = 100;
        int desiredHeight = 100;

        int width, height;
        boolean resizeWidth = true, resizeHeight = true;

        if (widthMode == MeasureSpec.EXACTLY)
        {
            width = widthSize;
            resizeWidth = false;
        }
        else if (widthMode == MeasureSpec.AT_MOST)
        {
            width = Math.min(desiredWidth, widthSize);
        }
        else
        {
            width = desiredWidth;
        }

        if (heightMode == MeasureSpec.EXACTLY)
        {
            height = heightSize;
            resizeHeight = false;
        }
        else if (heightMode == MeasureSpec.AT_MOST)
        {
            height = Math.min(desiredHeight, heightSize);
        }
        else
        {
            height = desiredHeight;
        }

        // Now, if the aspect ratio currently is not satisfied, fix it
        if (resizeWidth || resizeHeight)
        {
            // Check if aspect ratio currently is okay, if not change width/height
        }

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas)
    {

    }
}