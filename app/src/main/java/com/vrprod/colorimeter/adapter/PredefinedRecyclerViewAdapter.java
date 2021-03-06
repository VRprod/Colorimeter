package com.vrprod.colorimeter.adapter;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vrprod.colorimeter.BR;
import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.listener.PredefinedColorLineListener;
import com.vrprod.colorimeter.model.Color;

import java.util.List;

public class PredefinedRecyclerViewAdapter extends RecyclerView.Adapter<PredefinedRecyclerViewAdapter.ViewHolder> {
    private List<Color> data;
    private Color color;

    public PredefinedRecyclerViewAdapter(List<Color> data, Color color) {
        this.data = data;
        this.color = color;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.line_color_predefined, parent, false);
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

    private PredefinedColorLineListener getPredefinedColorLineListener() {
        return new PredefinedColorLineListener() {
            @Override
            public void onClick(Color color, Color colorLine) {
                if (color != null && color.isActive()) {
                    color.setCodeHexadecimal(colorLine.getCodeHexadecimal());
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

        private void bind(Object colorLine) {
            binding.setVariable(BR.colorLine, colorLine);
            binding.setVariable(BR.color, color);
            binding.setVariable(BR.listener, getPredefinedColorLineListener());
            binding.executePendingBindings();
        }
    }
}
