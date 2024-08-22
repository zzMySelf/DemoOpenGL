package com.baidu.searchbox.aps.base.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.View;

public interface IDialogBuilder<T> {
    <T> T getBuilderEntity();

    DialogInterface.OnCancelListener getCancelListener();

    DialogInterface.OnDismissListener getDismissListener();

    DialogInterface.OnClickListener getNegativeListener();

    DialogInterface.OnClickListener getPositiveListener();

    void release();

    IDialogBuilder setContentHeight(int i2);

    IDialogBuilder setIcon(int i2);

    IDialogBuilder setIcon(Drawable drawable);

    IDialogBuilder setMessage(int i2);

    IDialogBuilder setMessage(String str);

    IDialogBuilder setNegativeButton(int i2, DialogInterface.OnClickListener onClickListener);

    IDialogBuilder setNegativeButton(String str, DialogInterface.OnClickListener onClickListener);

    IDialogBuilder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener);

    IDialogBuilder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener);

    IDialogBuilder setPositiveButton(int i2, DialogInterface.OnClickListener onClickListener);

    IDialogBuilder setPositiveButton(String str, DialogInterface.OnClickListener onClickListener);

    IDialogBuilder setPositiveEnabled(boolean z);

    IDialogBuilder setPositiveTextColor(int i2);

    IDialogBuilder setTitle(int i2);

    IDialogBuilder setTitle(String str);

    IDialogBuilder setView(View view2);

    IDialogBuilder setView(View view2, int i2, int i3, int i4, int i5);

    void show(Context context);
}
