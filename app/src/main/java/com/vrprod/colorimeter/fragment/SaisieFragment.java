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
import com.vrprod.colorimeter.adapter.RecyclerViewAdapter;
import com.vrprod.colorimeter.databinding.FragmentSaisieBinding;
import com.vrprod.colorimeter.listener.SaisieFragmentListener;
import com.vrprod.colorimeter.model.Color;
import com.vrprod.colorimeter.util.ColorUtil;

import java.util.ArrayList;
import java.util.List;

public abstract class SaisieFragment extends Fragment {

    protected RecyclerView recyclerView;
    protected Color color;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        FragmentSaisieBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_saisie, container, false);
        binding.setColor(color);
        binding.setListener(getSaisieFragmentListener());
        View view = binding.getRoot();
        recyclerView = binding.listColors;
        recyclerView.setAdapter(new RecyclerViewAdapter(ColorUtil.getColors(), color));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), ((LinearLayoutManager) recyclerView.getLayoutManager()).getOrientation()));
        return view;
    }

    protected abstract SaisieFragmentListener getSaisieFragmentListener();
}
