package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.baidu.android.common.ui.style.R;

public class BottomCloseBtnDialog extends BaseDialog {
    /* access modifiers changed from: private */
    public ImageView mCloseBtn;
    /* access modifiers changed from: private */
    public OnCloseListener mOnCloseListener;
    private ViewGroup mUpperContainer;

    public interface OnCloseListener {
        void onClose();
    }

    public BottomCloseBtnDialog(Context context) {
        super(context, R.style.NoTitleDialog);
        initView();
        getWindow().setLayout(-1, -1);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setCancelable(true);
        setCanceledOnTouchOutside(false);
        setOnCancelListener(new DialogInterface.OnCancelListener() {
            public void onCancel(DialogInterface dialog) {
                if (BottomCloseBtnDialog.this.mOnCloseListener != null) {
                    BottomCloseBtnDialog.this.mOnCloseListener.onClose();
                }
            }
        });
    }

    private void initView() {
        setContentView(com.baidu.searchbox.common.res.R.layout.bottom_close_btn_dialog_layout);
        this.mUpperContainer = (ViewGroup) findViewById(com.baidu.searchbox.common.res.R.id.upper_container);
        ImageView imageView = (ImageView) findViewById(com.baidu.searchbox.common.res.R.id.close_btn);
        this.mCloseBtn = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view2) {
                BottomCloseBtnDialog.this.dismiss();
                if (BottomCloseBtnDialog.this.mOnCloseListener != null) {
                    BottomCloseBtnDialog.this.mOnCloseListener.onClose();
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void setUpperView(int layoutId) {
        this.mUpperContainer.removeAllViews();
        LayoutInflater.from(getContext()).inflate(layoutId, this.mUpperContainer, true);
    }

    /* access modifiers changed from: protected */
    public void setUpperView(View view2, ViewGroup.LayoutParams layoutParams) {
        this.mUpperContainer.removeAllViews();
        this.mUpperContainer.addView(view2, layoutParams);
    }

    public View getUpperView() {
        if (this.mUpperContainer.getChildCount() > 0) {
            return this.mUpperContainer.getChildAt(0);
        }
        return null;
    }

    public static class Builder {
        private BottomCloseBtnDialog mDialog;

        public Builder(Context context) {
            this.mDialog = new BottomCloseBtnDialog(context);
        }

        public Builder setCloseBtnTopMargin(int topMargin) {
            LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) this.mDialog.mCloseBtn.getLayoutParams();
            lp.topMargin = topMargin;
            this.mDialog.mCloseBtn.setLayoutParams(lp);
            return this;
        }

        public Builder setUpperView(View view2, ViewGroup.LayoutParams layoutParams) {
            this.mDialog.setUpperView(view2, layoutParams);
            return this;
        }

        public Builder setUpperView(int resId) {
            this.mDialog.setUpperView(resId);
            return this;
        }

        public Builder setOnCloseListener(OnCloseListener onCloseListener) {
            OnCloseListener unused = this.mDialog.mOnCloseListener = onCloseListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mDialog.setOnDismissListener(onDismissListener);
            return this;
        }

        public BottomCloseBtnDialog show() {
            BottomCloseBtnDialog bottomCloseBtnDialog = this.mDialog;
            if (bottomCloseBtnDialog != null && !bottomCloseBtnDialog.isShowing()) {
                this.mDialog.show();
            }
            return this.mDialog;
        }
    }
}
