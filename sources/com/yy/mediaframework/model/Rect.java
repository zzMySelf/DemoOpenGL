package com.yy.mediaframework.model;

import java.util.Locale;

public class Rect {
    public float bottom;
    public float left;
    public float right;
    public float top;

    public Rect(float l, float t, float r, float b2) {
        this.left = l;
        this.top = t;
        this.right = r;
        this.bottom = b2;
    }

    public void update(float l, float t, float r, float b2) {
        this.left = l;
        this.top = t;
        this.right = r;
        this.bottom = b2;
    }

    public String toString() {
        return String.format(Locale.getDefault(), "Rect::left: %f, right %f, top %f, bottom %f", new Object[]{Float.valueOf(this.left), Float.valueOf(this.right), Float.valueOf(this.top), Float.valueOf(this.bottom)});
    }

    public boolean valueEquals(Rect rect) {
        if (rect != null && this.left == rect.left && this.bottom == rect.bottom && this.right == rect.right && this.top == rect.top) {
            return true;
        }
        return false;
    }
}
