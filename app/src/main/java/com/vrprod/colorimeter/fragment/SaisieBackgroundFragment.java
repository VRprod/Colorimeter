package com.vrprod.colorimeter.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.RecyclerViewAdapter;
import com.vrprod.colorimeter.listener.RecyclerItemClickListener;
import com.vrprod.colorimeter.model.Color;

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
        View view = super.onCreateView(inflater, container, savedInstanceState);
        if (recyclerView != null) {
            recyclerView.setAdapter(new RecyclerViewAdapter(getColors(), ((MainActivity) getActivity()).getBackgroundColor()));
            recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), (RecyclerView) view.findViewById(R.id.listColors), new RecyclerItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {
                    Color backgroundColor = ((MainActivity) getActivity()).getBackgroundColor();
                    backgroundColor.setName(((TextView) view.findViewById(R.id.color_line_name)).getText().toString());
                    backgroundColor.setCodeHexadecimal(((TextView) view.findViewById(R.id.color_line_codeHexadecimal)).getText().toString());
                }
                @Override public void onLongItemClick(View view, int position) {}
            }));
        }
        return view;
    }
}
