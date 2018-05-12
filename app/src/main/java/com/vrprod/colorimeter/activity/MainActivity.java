package com.vrprod.colorimeter.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.adapter.RecyclerViewAdapter;
import com.vrprod.colorimeter.adapter.ViewPagerAdapter;
import com.vrprod.colorimeter.databinding.ActivityMainBinding;
import com.vrprod.colorimeter.model.Color;
import com.vrprod.colorimeter.util.ColorUtil;

public class MainActivity extends AppCompatActivity {
    private Color backgroundColor;
    private Color textColor;

    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        backgroundColor = new Color("White", "#FFFFFF");
        textColor = new Color("Black", "#000000");

        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        binding.setBackgroundColor(backgroundColor);
        binding.setTextColor(textColor);

        // Init Toolbar
        setSupportActionBar(binding.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        drawerLayout = binding.drawerLayout;

        // Init RecyclerView
        RecyclerView recyclerView = binding.listColors;
        recyclerView.setAdapter(new RecyclerViewAdapter(ColorUtil.getColors(), backgroundColor));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.addItemDecoration(new DividerItemDecoration(this, ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation()));

        // Init TabLayout/ViewPager
        ViewPager viewPager = binding.viewpager;
        if (viewPager != null) {
            viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
            TabLayout tabLayout = findViewById(R.id.tab_layout);
            tabLayout.setupWithViewPager(viewPager);
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.END)) {
            drawer.closeDrawer(GravityCompat.END);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.END);
                return true;
        }
        return super.onOptionsItemSelected(item);
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
