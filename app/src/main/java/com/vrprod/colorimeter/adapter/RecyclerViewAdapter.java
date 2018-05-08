package com.vrprod.colorimeter.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vrprod.colorimeter.BR;
import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.listener.ColorLineListener;
import com.vrprod.colorimeter.model.Color;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private List<Color> data;
    private Color selectedColor;

    public RecyclerViewAdapter(List<Color> data, Color selectedColor) {
        this.data = data;
        this.selectedColor = selectedColor;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.color_line, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return (data == null) ? 0 : data.size();
    }

    private ColorLineListener getColorLineListener() {
        return new ColorLineListener() {
            @Override
            public void onClick(Color selectedColor, Color color) {
                if (selectedColor.isActive()) {
                    selectedColor.setName(color.getName());
                    selectedColor.setCodeHexadecimal(color.getCodeHexadecimal());
                }
            }
        };
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        private ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(Object color) {
            binding.setVariable(BR.color, color);
            binding.setVariable(BR.selectedColor, selectedColor);
            binding.setVariable(BR.listener, getColorLineListener());
            binding.executePendingBindings();
        }
    }
}
