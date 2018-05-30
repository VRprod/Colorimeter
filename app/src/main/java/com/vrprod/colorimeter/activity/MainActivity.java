package com.vrprod.colorimeter.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.databinding.ActivityMainBinding;
import com.vrprod.colorimeter.model.Color;

public class MainActivity extends AppCompatActivity {
    private Color backgroundColor;
    private Color textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        backgroundColor = new Color("Black", "#000000");
        textColor = new Color("White", "#FFFFFF");

        // Init DataBinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setBackgroundColor(backgroundColor);
        binding.setTextColor(textColor);

        // Init Toolbar
        setSupportActionBar(binding.toolbar);

        // Init BottomSheet
        BottomSheetBehavior.from(binding.bottomSheet).setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        backgroundColor.setCodeHexadecimal(savedInstanceState.getString("backgroundColor.codeHexadecimal"));
        backgroundColor.setActive(savedInstanceState.getBoolean("backgroundColor.isActive"));
        textColor.setCodeHexadecimal(savedInstanceState.getString("textColor.codeHexadecimal"));
        textColor.setActive(savedInstanceState.getBoolean("textColor.isActive"));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("backgroundColor.codeHexadecimal", backgroundColor.getCodeHexadecimal());
        outState.putBoolean("backgroundColor.isActive", backgroundColor.isActive());
        outState.putString("textColor.codeHexadecimal", textColor.getCodeHexadecimal());
        outState.putBoolean("textColor.isActive", textColor.isActive());
    }

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
