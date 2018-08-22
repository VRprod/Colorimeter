package com.vrprod.colorimeter.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.databinding.DialogColorAddBinding;

public class AddColorDialogFragment extends DialogFragment {

    private AddColorDialogListener addColorDialogListener;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            addColorDialogListener = (AddColorDialogListener) getParentFragment();
        } catch (ClassCastException e) {
            throw new ClassCastException("Calling fragment must implement AddColorDialogListener");
        }
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final DialogColorAddBinding binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_color_add, null, false);

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.add_color_dialog_fragment_title)
                .setView(binding.getRoot())
                .setPositiveButton(R.string.add_color_dialog_fragment_button_save, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String name = binding.name.getEditText().getText().toString();
                        String codeHexadecimal = binding.codeHexadecimal.getEditText().getText().toString();
                        addColorDialogListener.onAddColorDialogPositiveClick(name, codeHexadecimal);
                    }
                })
                .setNegativeButton(R.string.add_color_dialog_fragment_button_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        AddColorDialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }

    public interface AddColorDialogListener {
        void onAddColorDialogPositiveClick(String name, String codeHexadecimal);
    }
}
