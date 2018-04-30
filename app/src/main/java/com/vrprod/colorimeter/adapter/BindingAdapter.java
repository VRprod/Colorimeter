package com.vrprod.colorimeter.adapter;

import android.graphics.Typeface;
import android.widget.TextView;

public abstract class BindingAdapter {

    @android.databinding.BindingAdapter("android:typeface")
    public static void setTypeface(TextView v, String style) {
        if ("normal".equals(style)) {
            v.setTypeface(null, Typeface.NORMAL);
        } else if ("bold".equals(style)) {
            v.setTypeface(null, Typeface.BOLD);
        } else if ("italic".equals(style)) {
            v.setTypeface(null, Typeface.ITALIC);
        } else if ("bold|italic".equals(style)) {
            v.setTypeface(null, Typeface.BOLD_ITALIC);
        }
    }
}
