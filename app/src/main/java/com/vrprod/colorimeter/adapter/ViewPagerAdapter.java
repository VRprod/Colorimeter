package com.vrprod.colorimeter.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.vrprod.colorimeter.fragment.SaisieBackgroundFragment;
import com.vrprod.colorimeter.fragment.SaisieTextFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {

    public ViewPagerAdapter(FragmentManager fragmentManager) {
        super(fragmentManager);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return SaisieBackgroundFragment.newInstance();
            case 1:
                return SaisieTextFragment.newInstance();
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
                return "BACKGROUND";
            case 1:
                return "TEXT";
        }
        return null;
    }
}
