package com.vrprod.colorimeter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vrprod.colorimeter.fragment.TabEditFragment;
import com.vrprod.colorimeter.fragment.TabPickerFragment;
import com.vrprod.colorimeter.fragment.TabPredefinedFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new TabEditFragment();
            case 1:
                return new TabPredefinedFragment();
//            case 2:
//                return new TabPickerFragment();
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case 0:
                return "Edit";
            case 1:
                return "Predefined";
//            case 2:
//                return "Picker";
        }
        return null;
    }
}
