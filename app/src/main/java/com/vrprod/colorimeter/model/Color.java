package com.vrprod.colorimeter.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.vrprod.colorimeter.util.ColorUtils;

public class Color extends BaseObservable {
    private Long id;
    private String name;
    private String codeHexadecimal;
    private int codeRgbRed;
    private int codeRgbGreen;
    private int codeRgbBlue;
    private boolean isActive;

    public Color(Long id, String name, String codeHexadecimal) {
        this.id = id;
        this.name = name;
        this.codeHexadecimal = codeHexadecimal;
        this.codeRgbRed = ColorUtils.generateCodeRgbRed(this.codeHexadecimal);
        this.codeRgbGreen = ColorUtils.generateCodeRgbGreen(this.codeHexadecimal);
        this.codeRgbBlue = ColorUtils.generateCodeRgbBlue(this.codeHexadecimal);
        this.isActive = true;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Bindable
    public String getCodeHexadecimal() {
        return codeHexadecimal;
    }

    public void setCodeHexadecimal(String codeHexadecimal) {
        this.codeHexadecimal = codeHexadecimal;
        this.codeRgbRed = ColorUtils.generateCodeRgbRed(this.codeHexadecimal);
        this.codeRgbGreen = ColorUtils.generateCodeRgbGreen(this.codeHexadecimal);
        this.codeRgbBlue = ColorUtils.generateCodeRgbBlue(this.codeHexadecimal);
        notifyPropertyChanged(BR.codeHexadecimal);
        notifyPropertyChanged(BR.codeRgbRed);
        notifyPropertyChanged(BR.codeRgbGreen);
        notifyPropertyChanged(BR.codeRgbBlue);
    }

    @Bindable
    public int getCodeRgbRed() {
        return codeRgbRed;
    }

    public void setCodeRgbRed(int codeRgbRed) {
        this.codeRgbRed = codeRgbRed;
        this.codeHexadecimal = ColorUtils.generateCodeHexadecimal(this.codeRgbRed, this.codeRgbGreen, this.codeRgbBlue);
        notifyPropertyChanged(BR.codeRgbRed);
        notifyPropertyChanged(BR.codeHexadecimal);
    }

    @Bindable
    public int getCodeRgbGreen() {
        return codeRgbGreen;
    }

    public void setCodeRgbGreen(int codeRgbGreen) {
        this.codeRgbGreen = codeRgbGreen;
        this.codeHexadecimal = ColorUtils.generateCodeHexadecimal(this.codeRgbRed, this.codeRgbGreen, this.codeRgbBlue);
        notifyPropertyChanged(BR.codeRgbGreen);
        notifyPropertyChanged(BR.codeHexadecimal);
    }

    @Bindable
    public int getCodeRgbBlue() {
        return codeRgbBlue;
    }

    public void setCodeRgbBlue(int codeRgbBlue) {
        this.codeRgbBlue = codeRgbBlue;
        this.codeHexadecimal = ColorUtils.generateCodeHexadecimal(this.codeRgbRed, this.codeRgbGreen, this.codeRgbBlue);
        notifyPropertyChanged(BR.codeRgbBlue);
        notifyPropertyChanged(BR.codeHexadecimal);
    }

    @Bindable
    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean isActive) {
        this.isActive = isActive;
        notifyPropertyChanged(BR.active);
    }
}
