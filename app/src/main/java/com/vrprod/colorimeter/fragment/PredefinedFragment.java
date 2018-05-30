package com.vrprod.colorimeter.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.RecyclerViewAdapter;
import com.vrprod.colorimeter.databinding.PredefinedFragmentBinding;
import com.vrprod.colorimeter.util.ColorUtils;

public class PredefinedFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Init DataBinding
        PredefinedFragmentBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.predefined_fragment, container, false);

        // Init RecyclerView
        RecyclerView recyclerView = binding.listColors;
        recyclerView.setAdapter(new RecyclerViewAdapter(ColorUtils.getColors(), ((MainActivity) getActivity()).getBackgroundColor()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation()));

        return binding.getRoot();
    }
}
