package com.vrprod.colorimeter.validator;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;

public abstract class EditTextValidator implements TextWatcher {
    private View view;

    public EditTextValidator(View view) {
        this.view = view;
    }

    public abstract void validate(View view);

    @Override
    final public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    final public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    final public void afterTextChanged(Editable s) {
        validate(view);
    }
}
