package com.vrprod.colorimeter.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vrprod.colorimeter.BR;
import com.vrprod.colorimeter.R;
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
        final Color color = data.get(position);
        holder.bind(color);
    }

    @Override
    public int getItemCount() {
        return (data == null) ? 0 : data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        public ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(Object color) {
            binding.setVariable(BR.color, color);
            binding.setVariable(BR.selectedColor, selectedColor);
            binding.executePendingBindings();
        }
    }
}
