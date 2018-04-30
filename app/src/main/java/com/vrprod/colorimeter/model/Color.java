package com.vrprod.colorimeter.model;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

import com.android.databinding.library.baseAdapters.BR;
import com.vrprod.colorimeter.util.ColorUtil;


public class Color extends BaseObservable {
    private String name;
    private String codeHexadecimal;
    private int codeRgbRed;
    private int codeRgbGreen;
    private int codeRgbBlue;

    public Color(String name, String codeHexadecimal) {
        this.name = name;
        this.codeHexadecimal = codeHexadecimal;
        this.codeRgbRed = ColorUtil.generateCodeRgbRed(this.codeHexadecimal);
        this.codeRgbGreen = ColorUtil.generateCodeRgbGreen(this.codeHexadecimal);
        this.codeRgbBlue = ColorUtil.generateCodeRgbBlue(this.codeHexadecimal);
    }

    public Color(String name, String codeHexadecimal, int codeRgbRed, int codeRgbGreen, int codeRgbBlue) {
        this.name = name;
        this.codeHexadecimal = codeHexadecimal;
        this.codeRgbRed = codeRgbRed;
        this.codeRgbGreen = codeRgbGreen;
        this.codeRgbBlue = codeRgbBlue;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getCodeHexadecimal() {
        return codeHexadecimal;
    }

    public void setCodeHexadecimal(String codeHexadecimal) {
        this.codeHexadecimal = codeHexadecimal;
        this.codeRgbRed = ColorUtil.generateCodeRgbRed(this.codeHexadecimal);
        this.codeRgbGreen = ColorUtil.generateCodeRgbGreen(this.codeHexadecimal);
        this.codeRgbBlue = ColorUtil.generateCodeRgbBlue(this.codeHexadecimal);
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
        this.codeHexadecimal = ColorUtil.generateCodeHexadecimal(this.codeRgbRed, this.codeRgbGreen, this.codeRgbBlue);
        notifyPropertyChanged(BR.codeRgbRed);
        notifyPropertyChanged(BR.codeHexadecimal);
    }

    @Bindable
    public int getCodeRgbGreen() {
        return codeRgbGreen;
    }

    public void setCodeRgbGreen(int codeRgbGreen) {
        this.codeRgbGreen = codeRgbGreen;
        this.codeHexadecimal = ColorUtil.generateCodeHexadecimal(this.codeRgbRed, this.codeRgbGreen, this.codeRgbBlue);
        notifyPropertyChanged(BR.codeRgbGreen);
        notifyPropertyChanged(BR.codeHexadecimal);
    }

    @Bindable
    public int getCodeRgbBlue() {
        return codeRgbBlue;
    }

    public void setCodeRgbBlue(int codeRgbBlue) {
        this.codeRgbBlue = codeRgbBlue;
        this.codeHexadecimal = ColorUtil.generateCodeHexadecimal(this.codeRgbRed, this.codeRgbGreen, this.codeRgbBlue);
        notifyPropertyChanged(BR.codeRgbBlue);
        notifyPropertyChanged(BR.codeHexadecimal);
    }
}
