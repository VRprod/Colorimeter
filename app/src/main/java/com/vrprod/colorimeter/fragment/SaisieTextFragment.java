package com.vrprod.colorimeter.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.databinding.FragmentSaisieBinding;
import com.vrprod.colorimeter.databinding.WithTextBinding;

public class SaisieTextFragment extends SaisieFragment {

    private static SaisieTextFragment fragment;

    public static SaisieFragment newInstance() {
        if (fragment == null) {
            fragment = new SaisieTextFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        color = ((MainActivity) getActivity()).getTextColor();
        View view = super.onCreateView(inflater, container, savedInstanceState);

        WithTextBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.with_text, container, false);
        binding.setColor(color);
        ((FragmentSaisieBinding) DataBindingUtil.bind(view)).header.addView(binding.getRoot());
        return view;
    }
}
