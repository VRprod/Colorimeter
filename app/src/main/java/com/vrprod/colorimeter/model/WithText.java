package com.vrprod.colorimeter.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.vrprod.colorimeter.util.ColorUtil;


public class WithText extends BaseObservable {
    private boolean withText;

    public WithText(boolean withText) {
        this.withText = withText;
    }

    @Bindable
    public boolean isWithText() {
        return withText;
    }

    public void setWithText(boolean withText) {
        this.withText = withText;
        notifyPropertyChanged(BR.withText);
    }
}
