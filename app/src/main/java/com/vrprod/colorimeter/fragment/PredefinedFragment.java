package com.vrprod.colorimeter.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.PredefinedRecyclerViewAdapter;
import com.vrprod.colorimeter.databinding.FragmentPickerBinding;
import com.vrprod.colorimeter.databinding.FragmentPredefinedBinding;
import com.vrprod.colorimeter.util.ColorUtils;

public class PredefinedFragment extends Fragment {

    private static PredefinedFragment instance;

    public static PredefinedFragment getInstance() {
        if (instance == null) {
            instance = new PredefinedFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Init DataBinding
        FragmentPredefinedBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_predefined, container, false);

        // Init RecyclerView
        RecyclerView recyclerView = binding.listColors;
        recyclerView.setAdapter(new PredefinedRecyclerViewAdapter(ColorUtils.getColors(), null));
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

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

        return binding.getRoot();
    }
}
