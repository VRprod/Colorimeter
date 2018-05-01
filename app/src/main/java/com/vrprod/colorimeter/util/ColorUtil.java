package com.vrprod.colorimeter.util;

public class ColorUtil {

    public static String generateCodeHexadecimal(int codeRgbRed, int codeRgbGreen, int codeRgbBlue) {
        return new StringBuilder("#")
                .append(String.format("%02X", codeRgbRed))
                .append(String.format("%02X", codeRgbGreen))
                .append(String.format("%02X", codeRgbBlue))
                .toString();
    }

    public static int generateCodeRgbRed(String codeHexadecimal) {
        return android.graphics.Color.red(android.graphics.Color.parseColor(codeHexadecimal));
    }

    public static int generateCodeRgbGreen(String codeHexadecimal) {
        return android.graphics.Color.green(android.graphics.Color.parseColor(codeHexadecimal));
    }

    public static int generateCodeRgbBlue(String codeHexadecimal) {
        return android.graphics.Color.blue(android.graphics.Color.parseColor(codeHexadecimal));
    }
}
