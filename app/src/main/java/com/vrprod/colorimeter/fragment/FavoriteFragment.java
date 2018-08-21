package com.vrprod.colorimeter.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.FavoriteRecyclerViewAdapter;
import com.vrprod.colorimeter.databinding.FragmentFavoriteBinding;
import com.vrprod.colorimeter.service.IColorService;
import com.vrprod.colorimeter.service.impl.ColorService;

public class FavoriteFragment extends Fragment {
    private static FavoriteFragment instance;
    private IColorService colorService;

    public static FavoriteFragment getInstance() {
        if (instance == null) {
            instance = new FavoriteFragment();
            instance.setColorService(new ColorService());
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Init DataBinding
        FragmentFavoriteBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_favorite, container, false);

        // Init button Back
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                if (activity != null && activity.getBottomNavigationView() != null) {
                    activity.getBottomNavigationView().setSelectedItemId(R.id.item_edit);
                    activity.showFragment(EditFragment.getInstance());
                }
            }
        });

        // Init RecyclerView
        RecyclerView recyclerView = binding.listColors;
        recyclerView.setAdapter(new FavoriteRecyclerViewAdapter(colorService.getAll()));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return binding.getRoot();
    }

    public IColorService getColorService() {
        return colorService;
    }

    public void setColorService(IColorService colorService) {
        this.colorService = colorService;
    }
}
