package com.vrprod.colorimeter.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.databinding.ActivityMainBinding;
import com.vrprod.colorimeter.fragment.EditFragment;
import com.vrprod.colorimeter.fragment.FavoriteFragment;
import com.vrprod.colorimeter.fragment.PickerFragment;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Init DataBinding
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        // Init Toolbar
        toolbar = binding.toolbar;
        setSupportActionBar(toolbar);

        // Init BottomNavigationView
        binding.bottomNavigation.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()){
                            case R.id.item_edit:
                                showFragment(EditFragment.getInstance());
                                return true;
                            case R.id.item_picker:
                                showFragment(PickerFragment.getInstance());
                                return true;
                            case R.id.item_favorite:
                                showFragment(FavoriteFragment.getInstance());
                                return true;
                        }
                        return false;
                    }
                });

        showFragment(EditFragment.getInstance());
    }

    private void showFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
    }
}
