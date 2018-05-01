package com.vrprod.colorimeter.activity;

import android.databinding.DataBindingUtil;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.adapter.ViewPagerAdapter;
import com.vrprod.colorimeter.databinding.ActivityMainBinding;
import com.vrprod.colorimeter.model.Color;

public class MainActivity extends AppCompatActivity {
    private Color backgroundColor;
    private Color textColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        backgroundColor = new Color("White", "#FFFFFF");
        textColor = new Color("Black", "#000000");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setBackgroundColor(backgroundColor);
        binding.setTextColor(textColor);

        // Init tabs
        ViewPager viewPager = binding.viewpager;
        if (viewPager != null) {
            viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
            TabLayout tabLayout = findViewById(R.id.tabs);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("backgroundColor.name", backgroundColor.getName());
        outState.putString("backgroundColor.codeHexadecimal", backgroundColor.getCodeHexadecimal());
        outState.putString("textColor.name", textColor.getName());
        outState.putString("textColor.codeHexadecimal", textColor.getCodeHexadecimal());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        backgroundColor.setName(savedInstanceState.getString("backgroundColor.name"));
        backgroundColor.setCodeHexadecimal(savedInstanceState.getString("backgroundColor.codeHexadecimal"));
        textColor.setName(savedInstanceState.getString("textColor.name"));
        textColor.setCodeHexadecimal(savedInstanceState.getString("textColor.codeHexadecimal"));
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
