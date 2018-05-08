package com.vrprod.colorimeter.fragment;

import android.app.Dialog;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.activity.MainActivity;
import com.vrprod.colorimeter.databinding.DialogFragmentSaisieBinding;
import com.vrprod.colorimeter.model.Color;
import com.vrprod.colorimeter.validator.EditTextValidator;

public class SaisieDialogFragment extends DialogFragment {
    private String title;
    private Color color;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final DialogFragmentSaisieBinding binding = DataBindingUtil.inflate(
                getActivity().getLayoutInflater(), R.layout.dialog_fragment_saisie, null, false);
        binding.setColor(new Color(null, color.getCodeHexadecimal()));

        final Dialog dialog =  new AlertDialog.Builder(getActivity())
                .setTitle(title)
                .setView(binding.getRoot())
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        String v = binding.codeHexadecimal.getEditText().getText().toString();
                        color.setCodeHexadecimal(v);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {}
                })
                .create();

        // Code hexadecimal
        binding.codeHexadecimal.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
            @Override
            public void validate(View view) {
                boolean isValid = SaisieDialogFragment.this.validate(view);
                if (isValid) {
                    DialogFragmentSaisieBinding binding = DataBindingUtil.findBinding(view);
                    binding.getColor().setCodeHexadecimal(binding.codeHexadecimal.getEditText().getText().toString());
                }
                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(isValid);
            }
        });

        // Code RGB Red
        binding.codeRgbRed.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
            @Override
            public void validate(View view) {
                boolean isValid = SaisieDialogFragment.this.validate(view);
                if (isValid) {
                    DialogFragmentSaisieBinding binding = DataBindingUtil.findBinding(view);
                    binding.getColor().setCodeRgbRed(Integer.valueOf(binding.codeRgbRed.getEditText().getText().toString()));
                }
                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(isValid);
            }
        });

        // Code RGB Green
        binding.codeRgbGreen.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
            @Override
            public void validate(View view) {
                boolean isValid = SaisieDialogFragment.this.validate(view);
                if (isValid) {
                    DialogFragmentSaisieBinding binding = DataBindingUtil.findBinding(view);
                    binding.getColor().setCodeRgbGreen(Integer.valueOf(binding.codeRgbGreen.getEditText().getText().toString()));
                }
                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(isValid);
            }
        });

        // Code RGB Blue
        binding.codeRgbBlue.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
            @Override
            public void validate(View view) {
                boolean isValid = SaisieDialogFragment.this.validate(view);
                if (isValid) {
                    DialogFragmentSaisieBinding binding = DataBindingUtil.findBinding(view);
                    binding.getColor().setCodeRgbBlue(Integer.valueOf(binding.codeRgbBlue.getEditText().getText().toString()));
                }
                ((AlertDialog) dialog).getButton(AlertDialog.BUTTON_POSITIVE).setEnabled(isValid);
            }
        });
        return dialog;
    }

    private boolean validate(View view) {
        boolean isValid = true;
        DialogFragmentSaisieBinding binding = DataBindingUtil.findBinding(view);

        // Code hexadecimal
        TextInputLayout editCodeHexadecimal = binding.codeHexadecimal;
        if (editCodeHexadecimal.getEditText().getText().toString().matches(getString(R.string.codeHexadecimal_regex))) {
            editCodeHexadecimal.setError(null);
        } else {
            editCodeHexadecimal.setError(getString(R.string.codeHexadecimal_error));
            isValid = false;
        }

        // Code RGB Red
        TextInputLayout editCodeRgbRed = binding.codeRgbRed;
        if (editCodeRgbRed.getEditText().getText().toString().matches(getString(R.string.codeRgb_regex))) {
            int codeRgbRed = Integer.valueOf(editCodeRgbRed.getEditText().getText().toString());
            if (codeRgbRed >= 0 && codeRgbRed <= 255) {
                editCodeRgbRed.setError(null);
            } else {
                editCodeRgbRed.setError(getString(R.string.codeRgb_error));
                isValid = false;
            }
        } else {
            editCodeRgbRed.setError(getString(R.string.codeRgb_error));
            isValid = false;
        }

        // Code RGB Green
        TextInputLayout editCodeRgbGreen = binding.codeRgbGreen;
        if (editCodeRgbGreen.getEditText().getText().toString().matches(getString(R.string.codeRgb_regex))) {
            int codeRgbGreen = Integer.valueOf(editCodeRgbGreen.getEditText().getText().toString());
            if (codeRgbGreen >= 0 && codeRgbGreen <= 255) {
                editCodeRgbGreen.setError(null);
            } else {
                editCodeRgbGreen.setError(getString(R.string.codeRgb_error));
                isValid = false;
            }
        } else {
            editCodeRgbGreen.setError(getString(R.string.codeRgb_error));
            isValid = false;
        }

        // Code RGB Blue
        TextInputLayout editCodeRgbBlue = binding.codeRgbBlue;
        if (editCodeRgbBlue.getEditText().getText().toString().matches(getString(R.string.codeRgb_regex))) {
            int codeRgbBlue = Integer.valueOf(editCodeRgbBlue.getEditText().getText().toString());
            if (codeRgbBlue >= 0 && codeRgbBlue <= 255) {
                editCodeRgbBlue.setError(null);
            } else {
                editCodeRgbBlue.setError(getString(R.string.codeRgb_error));
                isValid = false;
            }
        } else {
            editCodeRgbBlue.setError(getString(R.string.codeRgb_error));
            isValid = false;
        }

        return isValid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
