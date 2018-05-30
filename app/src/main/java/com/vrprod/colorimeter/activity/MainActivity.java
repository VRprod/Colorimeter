package com.vrprod.colorimeter.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.databinding.ActivityMainBinding;
import com.vrprod.colorimeter.model.Color;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;
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

        // Init DrawerLayout
        drawerLayout = binding.drawerLayout;

        // Init Toolbar
        setSupportActionBar(binding.toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.predefined_colors:
                if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
                    drawerLayout.closeDrawer(GravityCompat.END);
                } else {
                    drawerLayout.openDrawer(GravityCompat.END);
                }
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.END)) {
            drawerLayout.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
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
