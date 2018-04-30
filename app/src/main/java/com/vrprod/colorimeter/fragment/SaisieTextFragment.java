package com.vrprod.colorimeter.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.adapter.RecyclerViewAdapter;
import com.vrprod.colorimeter.listener.RecyclerItemClickListener;
import com.vrprod.colorimeter.model.Color;

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
        if (recyclerView != null) {
            recyclerView.setAdapter(new RecyclerViewAdapter(getColors(), ((MainActivity) getActivity()).getTextColor()));
            recyclerView.addOnItemTouchListener(new RecyclerItemClickListener(getActivity(), (RecyclerView) view.findViewById(R.id.listColors), new RecyclerItemClickListener.OnItemClickListener() {
                @Override public void onItemClick(View view, int position) {
                    Color textColor = ((MainActivity) getActivity()).getTextColor();
                    textColor.setName(((TextView) view.findViewById(R.id.color_line_name)).getText().toString());
                    textColor.setCodeHexadecimal(((TextView) view.findViewById(R.id.color_line_codeHexadecimal)).getText().toString());
                }
                @Override public void onLongItemClick(View view, int position) {}
            }));
        }

        // TODO => Data Binding
        View withTextView = inflater.inflate(R.layout.with_text, null);
        CheckBox withText = withTextView.findViewById(R.id.withtext);
        withText.setChecked(((MainActivity) getActivity()).getWithText().isWithText());
        withText.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                ((MainActivity) getActivity()).getWithText().setWithText(isChecked);
            }
        });
        RelativeLayout headerView = view.findViewById(R.id.header);
        headerView.addView(withTextView);
        return view;
    }
}
