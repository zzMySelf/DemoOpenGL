package com.baidu.searchbox.security.view;

import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BaseActivityDialog;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.privacy.R;

public class RepackageTipDialogProxy {
    BaseActivityDialog.Builder mBuilder;
    /* access modifiers changed from: private */
    public OnDialogListener mOnDialogListener;

    public interface OnDialogListener {
        void onNegative(DialogInterface dialogInterface);

        void onPositive(DialogInterface dialogInterface);
    }

    private void init() {
        BaseActivityDialog.Builder builder = new BaseActivityDialog.Builder();
        this.mBuilder = builder;
        builder.setPositiveTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.security_positive_btn_text_color));
        View view2 = LayoutInflater.from(AppRuntime.getAppContext()).inflate(R.layout.security_repackage, (ViewGroup) null);
        ((TextView) view2.findViewById(R.id.security_dialog_content)).setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.security_dialog_content_color));
        ((TextView) view2.findViewById(R.id.security_dialog_title)).setTextColor(AppRuntime.getAppContext().getResources().getColor(R.color.security_dialog_title_color));
        ((ImageView) view2.findViewById(R.id.security_dialog_warn_img)).setImageDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.security_warn));
        this.mBuilder.setView(view2).hideTitle(true);
        this.mBuilder.setCustomPanelMargin(0, 0, 0, 0);
        this.mBuilder.setDialogBackGroundDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.security_dialog_background));
        this.mBuilder.setPositiveBackGroundDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.security_dialog_positive_btn_selector));
        this.mBuilder.setNegativeBackGroundDrawable(AppRuntime.getAppContext().getResources().getDrawable(R.drawable.security_dialog_negative_btn_selector));
        this.mBuilder.setNegativeButton(R.string.security_kill_process, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (RepackageTipDialogProxy.this.mOnDialogListener != null) {
                    RepackageTipDialogProxy.this.mOnDialogListener.onNegative(dialogInterface);
                }
            }
        }).setPositiveButton(R.string.security_redown, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                if (RepackageTipDialogProxy.this.mOnDialogListener != null) {
                    RepackageTipDialogProxy.this.mOnDialogListener.onPositive(dialogInterface);
                }
            }
        });
        this.mBuilder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialogInterface) {
                if (RepackageTipDialogProxy.this.mOnDialogListener != null) {
                    RepackageTipDialogProxy.this.mOnDialogListener.onNegative(dialogInterface);
                }
            }
        });
    }

    public void show() {
        init();
        BaseActivityDialog.Builder builder = this.mBuilder;
        if (builder != null) {
            builder.show();
        }
    }

    public void setDialogListener(OnDialogListener listener) {
        this.mOnDialogListener = listener;
    }
}
