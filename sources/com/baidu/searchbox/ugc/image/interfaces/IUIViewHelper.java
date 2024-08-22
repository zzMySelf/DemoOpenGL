package com.baidu.searchbox.ugc.image.interfaces;

import android.content.Context;

public interface IUIViewHelper {
    int getResDrawableByType(int i2);

    int getSlideDownOutBottomAnimRes();

    int getSlideUpInAnimRes();

    void messageToast(String str);

    void showCommonDialog(Context context, String str, String str2, String str3, String str4, IDialogClickListener iDialogClickListener, int i2, int i3);

    void showCommonDialog(String str, String str2, String str3, String str4, IDialogClickListener iDialogClickListener, int i2, int i3);
}
