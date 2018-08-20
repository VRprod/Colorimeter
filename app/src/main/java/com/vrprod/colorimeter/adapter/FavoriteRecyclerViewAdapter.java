package com.vrprod.colorimeter.adapter;

import android.content.Context;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.vrprod.colorimeter.BR;
import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.FavoriteActivity;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.fragment.FavoriteFragment;
import com.vrprod.colorimeter.listener.FavoriteColorLineListener;
import com.vrprod.colorimeter.listener.PredefinedColorLineListener;
import com.vrprod.colorimeter.model.Color;

import java.util.List;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class FavoriteRecyclerViewAdapter extends RecyclerView.Adapter<FavoriteRecyclerViewAdapter.ViewHolder> {
    private Context context;
    private List<Color> data;

    public FavoriteRecyclerViewAdapter(List<Color> data) {
        this.data = data;
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
        holder.bind(data.get(position));
    }

    @Override
    public int getItemCount() {
        return (data == null) ? 0 : data.size();
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
}
