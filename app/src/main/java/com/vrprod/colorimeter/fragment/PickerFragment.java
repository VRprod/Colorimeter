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
import android.widget.Button;
import android.widget.ImageButton;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.FavoriteRecyclerViewAdapter;
import com.vrprod.colorimeter.databinding.FragmentFavoriteBinding;
import com.vrprod.colorimeter.databinding.FragmentPickerBinding;

public class PickerFragment extends Fragment {
    private static PickerFragment instance;

    public static PickerFragment getInstance() {
        if (instance == null) {
            instance = new PickerFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        // Init DataBinding
        FragmentPickerBinding binding = DataBindingUtil.inflate(
                inflater, R.layout.fragment_picker, container, false);

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

        return binding.getRoot();
    }
}
