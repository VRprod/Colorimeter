package com.vrprod.colorimeter.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.FavoriteRecyclerViewAdapter;
import com.vrprod.colorimeter.databinding.FragmentFavoriteBinding;
import com.vrprod.colorimeter.model.Color;
import com.vrprod.colorimeter.service.IColorService;
import com.vrprod.colorimeter.service.impl.ColorService;

import java.util.List;

public class FavoriteFragment extends Fragment implements AddColorDialogFragment.AddColorDialogListener {
    private static FavoriteFragment instance;
    private IColorService colorService;
    private CoordinatorLayout fragmentFavorite;
    RecyclerView recyclerView;

    public static FavoriteFragment getInstance(Context context) {
        if (instance == null) {
            instance = new FavoriteFragment();
            instance.setColorService(new ColorService(context));
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Init DataBinding
        FragmentFavoriteBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_favorite, container, false);

        // Init CoordinatorLayout
        fragmentFavorite = binding.fragmentFavorite;

        // Init button Back
        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                MainActivity activity = (MainActivity) getActivity();
                if (activity != null && activity.getBottomNavigationView() != null) {
                    activity.getBottomNavigationView().setSelectedItemId(R.id.item_edit);
                    activity.showFragment(EditFragment.getInstance(activity.getApplicationContext()));
                }
            }
        });

        // Init RecyclerView
        final List<Color> lstColors = colorService.readAll();
        if (lstColors == null || lstColors.isEmpty()) {
            binding.lstColors.setVisibility(View.GONE);
            binding.emptyView.setVisibility(View.VISIBLE);
        } else {
            binding.lstColors.setVisibility(View.VISIBLE);
            binding.emptyView.setVisibility(View.GONE);
            recyclerView = binding.lstColors;
            recyclerView.setAdapter(new FavoriteRecyclerViewAdapter(lstColors));
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        }

        // Init FloatingActionButton
        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AddColorDialogFragment().show(FavoriteFragment.this.getChildFragmentManager(), "AddColorDialog");
            }
        });

        return binding.getRoot();
    }

    @Override
    public void onAddColorDialogPositiveClick(String name, String codeHexadecimal) {
        Color color = colorService.create(new Color(null, name, codeHexadecimal));
        ((FavoriteRecyclerViewAdapter) recyclerView.getAdapter()).getLstColors().add(color);
        recyclerView.getAdapter().notifyDataSetChanged();
        Snackbar.make(fragmentFavorite,R.string.color_saved, Snackbar.LENGTH_SHORT).show();
    }

    public void setColorService(IColorService colorService) {
        this.colorService = colorService;
    }
}
