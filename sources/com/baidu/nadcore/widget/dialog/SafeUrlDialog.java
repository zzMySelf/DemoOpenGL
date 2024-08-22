package com.baidu.nadcore.widget.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.nadcore.utils.DeviceUtils;
import com.baidu.nadcore.widget.R;
import com.baidu.nadcore.widget.dialog.AutoOrientationBtnDialog;
import com.baidu.nadcore.widget.txt.SelectorTextView;
import com.baidu.nadcore.widget.util.PorterDuffModeHelper;

public class SafeUrlDialog extends AutoOrientationBtnDialog {
    private TextView mContentView;
    /* access modifiers changed from: private */
    public Builder mSafeBuilder;
    private SelectorTextView mSubContentView;
    private View mView;

    protected SafeUrlDialog(Context context) {
        super(context);
    }

    public void setSafeBuilder(Builder builder) {
        this.mSafeBuilder = builder;
    }

    /* access modifiers changed from: protected */
    public View createContentView(ViewGroup parent) {
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.nad_view_safe_dialog, parent, false);
        this.mView = inflate;
        TextView textView = (TextView) inflate.findViewById(R.id.safe_dialog_content);
        this.mContentView = textView;
        textView.setTextColor(getContext().getResources().getColor(R.color.nad_safe_dialog_message));
        SelectorTextView selectorTextView = (SelectorTextView) this.mView.findViewById(R.id.safe_dialog_sub_content);
        this.mSubContentView = selectorTextView;
        selectorTextView.setTextColor(getContext().getResources().getColor(R.color.nad_safe_dialog_btn_blue));
        bindView();
        return this.mView;
    }

    private void bindView() {
        if (this.mSafeBuilder != null) {
            this.mContentView.setText(this.mContext.getText(this.mSafeBuilder.mMessageId));
            this.mContentView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    if (SafeUrlDialog.this.mSafeBuilder.mMessageClickListener != null) {
                        SafeUrlDialog.this.mSafeBuilder.mMessageClickListener.onItemClick(v);
                    }
                }
            });
            if (this.mSafeBuilder.mSubMessageId > 0) {
                this.mSubContentView.setVisibility(0);
                this.mSubContentView.setText(this.mContext.getText(this.mSafeBuilder.mSubMessageId));
                this.mSubContentView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view2) {
                        if (SafeUrlDialog.this.mSafeBuilder.mSubMessageClickListener != null) {
                            SafeUrlDialog.this.mSafeBuilder.mSubMessageClickListener.onItemClick(view2);
                        }
                    }
                });
            } else {
                this.mSubContentView.setVisibility(8);
            }
            if (this.mSafeBuilder.mSubContentDrawLeft > 0) {
                Drawable drawable = this.mContext.getResources().getDrawable(this.mSafeBuilder.mSubContentDrawLeft);
                PorterDuffModeHelper.decorateSrcATopMode(getContext(), drawable);
                drawable.setBounds(0, 0, DeviceUtils.ScreenInfo.dp2px(this.mContext, 12.0f), DeviceUtils.ScreenInfo.dp2px(this.mContext, 12.0f));
                this.mSubContentView.setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
            }
        }
    }

    public static class Builder extends AutoOrientationBtnDialog.Builder {
        public AutoOrientationBtnDialog.OnItemClickListener mMessageClickListener;
        /* access modifiers changed from: private */
        public int mMessageId;
        /* access modifiers changed from: private */
        public int mSubContentDrawLeft;
        public AutoOrientationBtnDialog.OnItemClickListener mSubMessageClickListener;
        /* access modifiers changed from: private */
        public int mSubMessageId;

        public Builder(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public BoxAlertDialog onCreateDialog(Context context) {
            return new SafeUrlDialog(context);
        }

        public Builder setTitle(int titleId) {
            super.setTitle(titleId);
            return this;
        }

        public Builder setMessage(int messageId) {
            this.mMessageId = messageId;
            return this;
        }

        public Builder setMessage(int messageId, AutoOrientationBtnDialog.OnItemClickListener listener) {
            this.mMessageId = messageId;
            this.mMessageClickListener = listener;
            return this;
        }

        public Builder setSubMessage(int subMessageId) {
            this.mSubMessageId = subMessageId;
            return this;
        }

        public Builder setSubMessage(int subMessageId, AutoOrientationBtnDialog.OnItemClickListener listener) {
            this.mSubMessageId = subMessageId;
            this.mSubMessageClickListener = listener;
            return this;
        }

        public Builder setSubMessageDrawLeft(int subContentDrawLeft) {
            this.mSubContentDrawLeft = subContentDrawLeft;
            return this;
        }

        public BoxAlertDialog create() {
            SafeUrlDialog dialog = (SafeUrlDialog) super.create();
            dialog.setSafeBuilder(this);
            return dialog;
        }
    }
}
