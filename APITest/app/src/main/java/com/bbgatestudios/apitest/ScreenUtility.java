package com.bbgatestudios.apitest;

import android.app.Activity;
import android.util.DisplayMetrics;
import android.view.Display;

/**
 * Created by John on 9/12/2014.
 */
public class ScreenUtility {

    private Activity activity;
    private float dpWidth;
    private float dpHeight;

    public ScreenUtility(Activity activity){
        this.activity = activity;

        Display display = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics outMetrics = new DisplayMetrics();
        display.getMetrics(outMetrics);

        float density = activity.getResources().getDisplayMetrics().density;
        dpHeight = outMetrics.heightPixels / density;
        dpWidth = outMetrics.widthPixels / density;
    }

    public float getWidth() { return dpWidth; }

    public float getHeight() { return dpHeight; }
}