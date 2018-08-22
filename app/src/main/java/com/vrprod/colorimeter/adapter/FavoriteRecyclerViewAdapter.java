package com.vrprod.colorimeter.adapter;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.vrprod.colorimeter.BR;
import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.FavoriteActivity;
import com.vrprod.colorimeter.listener.FavoriteColorLineListener;
import com.vrprod.colorimeter.model.Color;

import java.util.List;

public class FavoriteRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewAdapter.ViewHolder> {
    private List<Color> lstColors;

    public FavoriteRecyclerViewAdapter(List<Color> lstColors) {
        this.lstColors = lstColors;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        ViewDataBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.line_color_favorite, parent, false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(lstColors.get(position));
    }

    @Override
    public int getItemCount() {
        return (lstColors == null) ? 0 : lstColors.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private final ViewDataBinding binding;

        private ViewHolder(ViewDataBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        private void bind(Object colorLine) {
            binding.setVariable(BR.colorLine, colorLine);
            binding.setVariable(BR.listener, new FavoriteColorLineListener() {
                @Override
                public void onClick(Color color) {
                    Intent intent = new Intent(binding.getRoot().getContext(), FavoriteActivity.class);
                    intent.putExtra("name", color.getName());
                    intent.putExtra("codeHexadecimal", color.getCodeHexadecimal());
                    binding.getRoot().getContext().startActivity(intent);
                }
            });
            binding.executePendingBindings();
        }
    }

    public List<Color> getLstColors() {
        return lstColors;
    }
}
