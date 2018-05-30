package com.vrprod.colorimeter.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.ViewPagerAdapter;
import com.vrprod.colorimeter.databinding.BottomSheetFragmentBinding;

public class BottomSheetFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Init DataBinding
        BottomSheetFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.bottom_sheet_fragment, container, false);
        binding.setColor(((MainActivity) getActivity()).getBackgroundColor());

        // Init TabLayout/ViewPager
        ViewPager viewPager = binding.viewPager;
        if (viewPager != null) {
            viewPager.setAdapter(new ViewPagerAdapter(getActivity().getSupportFragmentManager()));
            binding.tabLayout.setupWithViewPager(viewPager);
        }

        return binding.getRoot();
    }
}
