package com.tera.scan.component.base.ui.widget;

import android.widget.Checkable;

public interface ICheckableItem extends Checkable {
    public static final int CHOICE_MODE_MULTIPLE = 2;
    public static final int CHOICE_MODE_NONE = 0;
    public static final int CHOICE_MODE_SINGLE = 1;

    void setChoiceMode(int i2);
}
