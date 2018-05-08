package com.vrprod.colorimeter.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.listener.SaisieFragmentListener;

public class SaisieBackgroundFragment extends SaisieFragment {

    private static SaisieBackgroundFragment fragment;

    public static  SaisieFragment newInstance() {
        if (fragment == null) {
            fragment = new SaisieBackgroundFragment();
        }
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        color = ((MainActivity) getActivity()).getBackgroundColor();
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    protected SaisieFragmentListener getSaisieFragmentListener() {
        return new SaisieFragmentListener() {
            @Override
            public void showDialogSaisie() {
                SaisieDialogFragment dialog = new SaisieDialogFragment();
                dialog.setTitle(getString(R.string.background_color));
                dialog.setColor(((MainActivity) getActivity()).getBackgroundColor());
                dialog.show(getFragmentManager(), "SaisieBackgroundDialog");
            }
        };
    }
}
