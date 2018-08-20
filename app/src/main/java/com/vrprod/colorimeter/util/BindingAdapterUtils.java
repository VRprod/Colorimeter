package com.vrprod.colorimeter.util;

import android.graphics.Color;
import android.graphics.Typeface;
import android.widget.TextView;

public abstract class BindingAdapterUtils {

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

    @android.databinding.BindingAdapter("app:text")
    public static void setCodeRgb(TextView v, String codeHexadecimal) {
        v.setText(new StringBuilder()
                .append("(")
                .append(Color.red(Color.parseColor(codeHexadecimal))).append(",")
                .append(Color.green(Color.parseColor(codeHexadecimal))).append(",")
                .append(Color.blue(Color.parseColor(codeHexadecimal)))
                .append(")")
                .toString());
    }
}
