package com.vrprod.colorimeter.fragment;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vrprod.colorimeter.R;
import com.vrprod.colorimeter.databinding.FragmentEditBinding;
import com.vrprod.colorimeter.model.Color;
import com.vrprod.colorimeter.validator.EditTextValidator;

public class EditFragment extends Fragment {
    private static EditFragment instance;
    private Color backgroundColor;
    private Color textColor;

    public static EditFragment getInstance() {
        if (instance == null) {
            instance = new EditFragment();
        }
        return instance;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        if (backgroundColor == null) {
            backgroundColor = new Color(null,null, "#33B5E5");
        }
        if (textColor == null) {
            textColor = new Color(null, "White", "#FFFFFF");
        }

        // Init DataBinding
        final FragmentEditBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit, container, false);
        binding.setBackgroundColor(backgroundColor);
        binding.setTextColor(textColor);

        // Code hexadecimal
        if (binding.codeHexadecimal.getEditText() != null) {
            binding.codeHexadecimal.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
                @Override
                public void validate(View view) {
                    boolean isValid = EditFragment.this.validate(view);
                    if (isValid && binding.codeHexadecimal.getEditText().getText() != null) {
                        backgroundColor.setCodeHexadecimal(binding.codeHexadecimal.getEditText().getText().toString());
                    }
                }
            });
        }

        // Code RGB Red
        if (binding.codeRgbRed.getEditText() != null) {
            binding.codeRgbRed.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
                @Override
                public void validate(View view) {
                    boolean isValid = EditFragment.this.validate(view);
                    if (isValid && binding.codeRgbRed.getEditText().getText() != null) {
                        backgroundColor.setCodeRgbRed(Integer.valueOf(binding.codeRgbRed.getEditText().getText().toString()));
                    }
                }
            });
        }

        // Code RGB Green
        if (binding.codeRgbGreen.getEditText() != null) {
            binding.codeRgbGreen.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
                @Override
                public void validate(View view) {
                    boolean isValid = EditFragment.this.validate(view);
                    if (isValid && binding.codeRgbGreen.getEditText().getText() != null) {
                        backgroundColor.setCodeRgbGreen(Integer.valueOf(binding.codeRgbGreen.getEditText().getText().toString()));
                    }
                }
            });
        }

        // Code RGB Blue
        if (binding.codeRgbBlue.getEditText() != null) {
            binding.codeRgbBlue.getEditText().addTextChangedListener(new EditTextValidator(binding.getRoot()) {
                @Override
                public void validate(View view) {
                    boolean isValid = EditFragment.this.validate(view);
                    if (isValid && binding.codeRgbBlue.getEditText().getText() != null) {
                        backgroundColor.setCodeRgbBlue(Integer.valueOf(binding.codeRgbBlue.getEditText().getText().toString()));
                    }
                }
            });
        }

        return binding.getRoot();
    }

    private boolean validate(View view) {
        FragmentEditBinding binding = DataBindingUtil.findBinding(view);
        if (binding == null) {
            return false;
        }
        boolean isValid = true;

        // Code hexadecimal
        TextInputLayout editCodeHexadecimal = binding.codeHexadecimal;
        if (editCodeHexadecimal.getEditText() != null
                && editCodeHexadecimal.getEditText().getText() != null
                && editCodeHexadecimal.getEditText().getText().toString().matches(getString(R.string.codeHexadecimal_regex))) {
            editCodeHexadecimal.setError(null);
        } else {
            editCodeHexadecimal.setError(getString(R.string.codeHexadecimal_error));
            isValid = false;
        }

        // Code RGB Red
        TextInputLayout editCodeRgbRed = binding.codeRgbRed;
        if (editCodeRgbRed.getEditText() != null
                && editCodeRgbRed.getEditText().getText() != null
                && editCodeRgbRed.getEditText().getText().toString().matches(getString(R.string.codeRgb_regex))) {
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
        if (editCodeRgbGreen.getEditText() != null
                && editCodeRgbGreen.getEditText().getText() != null
                && editCodeRgbGreen.getEditText().getText().toString().matches(getString(R.string.codeRgb_regex))) {
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
        if (editCodeRgbBlue.getEditText() != null
                && editCodeRgbBlue.getEditText().getText() != null
                && editCodeRgbBlue.getEditText().getText().toString().matches(getString(R.string.codeRgb_regex))) {
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

    public Color getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(Color backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public Color getTextColor() {
        return textColor;
    }

    public void setTextColor(Color textColor) {
        this.textColor = textColor;
    }
}
