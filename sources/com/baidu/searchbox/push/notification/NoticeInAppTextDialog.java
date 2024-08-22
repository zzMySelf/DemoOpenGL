package com.baidu.searchbox.push.notification;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BaseDialog;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.push.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.skin.callback.NightModeChangeListener;

public class NoticeInAppTextDialog extends BaseDialog {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    /* access modifiers changed from: private */
    public Builder mBuilder;

    protected NoticeInAppTextDialog(Context context) {
        super(context);
        init();
    }

    protected NoticeInAppTextDialog(Context context, boolean cancelable, DialogInterface.OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        init();
    }

    protected NoticeInAppTextDialog(Context context, int theme) {
        super(context, theme);
        init();
    }

    /* access modifiers changed from: protected */
    public void onButtonClick(int which) {
    }

    /* access modifiers changed from: protected */
    public void init() {
        setContentView(R.layout.message_app_text_dialog);
        getWindow().setLayout(-1, -1);
    }

    public Builder getBuilder() {
        return this.mBuilder;
    }

    /* access modifiers changed from: package-private */
    public void setBuilder(Builder builder) {
        this.mBuilder = builder;
    }

    public void setMessage(String message) {
        Builder builder = this.mBuilder;
        if (builder != null) {
            builder.setMessage(message);
        }
    }

    public static class Builder {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = R.string.message_app_dialog_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = R.string.message_app_dialog_ok;
        protected int mBtnHeight;
        private Context mContext;
        protected final NoticeInAppTextDialog mDialog;
        protected final DialogElement mDialogElement;

        public Builder(Context context) {
            NoticeInAppTextDialog onCreateDialog = onCreateDialog(context);
            this.mDialog = onCreateDialog;
            onCreateDialog.setBuilder(this);
            DialogElement dialogElement = new DialogElement((ViewGroup) onCreateDialog.getWindow().getDecorView());
            this.mDialogElement = dialogElement;
            this.mContext = context;
            this.mBtnHeight = context.getResources().getDimensionPixelSize(com.baidu.android.common.ui.style.R.dimen.dialog_btns_height);
            dialogElement.mDialogIcon.setImageDrawable(context.getResources().getDrawable(R.drawable.dialog_in_app_icon));
        }

        /* access modifiers changed from: protected */
        public NoticeInAppTextDialog onCreateDialog(Context context) {
            return new NoticeInAppTextDialog(context, R.style.NoTitleDialog);
        }

        public Builder setTitle(int titleId) {
            this.mDialogElement.mTitle.setText(this.mContext.getText(titleId));
            return this;
        }

        public Builder setTitle(CharSequence title) {
            if (title != null) {
                this.mDialogElement.mTitle.setText(title);
            }
            return this;
        }

        public Builder hideTitle(boolean bHide) {
            this.mDialogElement.mTitlePanel.setVisibility(bHide ? 8 : 0);
            return this;
        }

        public Builder setMessage(int messageId) {
            if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                this.mDialogElement.mMessageContent.setVisibility(0);
            }
            this.mDialogElement.mMessage.setText(this.mContext.getText(messageId));
            return this;
        }

        public Builder setMessage(CharSequence message) {
            if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                this.mDialogElement.mMessageContent.setVisibility(0);
            }
            if (message != null) {
                this.mDialogElement.mMessage.setText(message);
            }
            return this;
        }

        public Builder setMessage(String message) {
            if (this.mDialogElement.mMessageContent.getVisibility() != 0) {
                this.mDialogElement.mMessageContent.setVisibility(0);
            }
            if (message != null) {
                this.mDialogElement.mMessage.setText(message);
            }
            return this;
        }

        public Builder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
            return setPositiveButton(this.mContext.getText(textId), listener);
        }

        public Builder setPositiveButton(CharSequence text, final DialogInterface.OnClickListener listener) {
            if (TextUtils.isEmpty(text)) {
                this.mDialogElement.mPositiveButton.setVisibility(8);
                return this;
            }
            this.mDialogElement.mPositiveButton.setVisibility(0);
            this.mDialogElement.mPositiveButton.setText(text);
            this.mDialogElement.mRoot.findViewById(R.id.searchbox_alert_dialog).setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Builder.this.mDialog.onButtonClick(-1);
                    Builder.this.mDialog.dismiss();
                    DialogInterface.OnClickListener onClickListener = listener;
                    if (onClickListener != null) {
                        onClickListener.onClick(Builder.this.mDialog, -1);
                    }
                }
            });
            this.mDialogElement.mPositiveButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Builder.this.mDialog.onButtonClick(-1);
                    Builder.this.mDialog.dismiss();
                    DialogInterface.OnClickListener onClickListener = listener;
                    if (onClickListener != null) {
                        onClickListener.onClick(Builder.this.mDialog, -1);
                    }
                }
            });
            return this;
        }

        public Builder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
            return setNegativeButton(this.mContext.getText(textId), listener);
        }

        public Builder setNegativeButton(CharSequence text, final DialogInterface.OnClickListener listener) {
            if (TextUtils.isEmpty(text)) {
                this.mDialogElement.mNegativeButton.setVisibility(8);
                return this;
            }
            this.mDialogElement.mNegativeButton.setVisibility(0);
            this.mDialogElement.mNegativeButton.setText(text);
            this.mDialogElement.mNegativeButton.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    Builder.this.mDialog.onButtonClick(-2);
                    Builder.this.mDialog.dismiss();
                    DialogInterface.OnClickListener onClickListener = listener;
                    if (onClickListener != null) {
                        onClickListener.onClick(Builder.this.mDialog, -2);
                    }
                }
            });
            return this;
        }

        public Builder setCancelable(boolean cancelable) {
            this.mDialogElement.mCancelable = Boolean.valueOf(cancelable);
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            this.mDialogElement.mOnCancelListener = onCancelListener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener onDismissListener) {
            this.mDialogElement.mOnDismissListener = onDismissListener;
            return this;
        }

        public Builder setOnShowListener(DialogInterface.OnShowListener onShowListener) {
            this.mDialogElement.mOnShowListener = onShowListener;
            return this;
        }

        public Builder setOnKeyListener(DialogInterface.OnKeyListener onKeyListener) {
            this.mDialogElement.mOnKeyListener = onKeyListener;
            return this;
        }

        public NoticeInAppTextDialog create() {
            this.mDialog.setCancelable(this.mDialogElement.mCancelable.booleanValue());
            if (this.mDialogElement.mCancelable.booleanValue()) {
                this.mDialog.setCanceledOnTouchOutside(false);
            }
            this.mDialog.setOnCancelListener(this.mDialogElement.mOnCancelListener);
            this.mDialog.setOnDismissListener(this.mDialogElement.mOnDismissListener);
            this.mDialog.setOnShowListener(this.mDialogElement.mOnShowListener);
            if (this.mDialogElement.mOnKeyListener != null) {
                this.mDialog.setOnKeyListener(this.mDialogElement.mOnKeyListener);
            }
            this.mDialog.setBuilder(this);
            return this.mDialog;
        }

        public NoticeInAppTextDialog show() {
            initUiResources();
            NoticeInAppTextDialog dialog = create();
            try {
                dialog.show();
            } catch (Exception e2) {
                if (NoticeInAppTextDialog.DEBUG) {
                    e2.printStackTrace();
                }
            }
            return dialog;
        }

        public void initUiResources() {
            this.mDialogElement.mDialogLayout.setBackground(this.mContext.getResources().getDrawable(R.drawable.rounded_corner_dialog_bg));
            this.mDialogElement.mPositiveButton.setBackground(this.mContext.getResources().getDrawable(com.baidu.searchbox.common.res.R.drawable.alertdialog_button_day_bg_right_selector));
            this.mDialogElement.mNegativeButton.setBackground(this.mContext.getResources().getDrawable(com.baidu.searchbox.common.res.R.drawable.alertdialog_button_day_bg_left_selector));
            this.mDialogElement.mNegativeButton.setTextColor(this.mContext.getResources().getColor(R.color.push_dialog_btn_cancel_text));
            this.mDialogElement.mPositiveButton.setTextColor(this.mContext.getResources().getColor(R.color.push_dialog_btn_action_text));
            if (this.mDialogElement.mTitle != null) {
                this.mDialogElement.mTitle.setTextColor(this.mContext.getResources().getColor(R.color.push_dialog_title));
            }
            if (this.mDialogElement.mMessage != null) {
                this.mDialogElement.mMessage.setTextColor(this.mContext.getResources().getColor(R.color.push_dialog_content));
            }
            this.mDialogElement.mHDivider.setBackgroundColor(this.mContext.getResources().getColor(R.color.push_dialog_divider));
            this.mDialogElement.mVDivider.setBackgroundColor(this.mContext.getResources().getColor(R.color.push_dialog_divider));
        }
    }

    public static class DialogElement {
        public LinearLayout mBtnPanelLayout;
        public Boolean mCancelable = true;
        public ImageView mDialogIcon;
        public RelativeLayout mDialogLayout;
        public View mHDivider;
        public TextView mMessage;
        public LinearLayout mMessageContent;
        public TextView mNegativeButton;
        public DialogInterface.OnCancelListener mOnCancelListener;
        public DialogInterface.OnDismissListener mOnDismissListener;
        public DialogInterface.OnKeyListener mOnKeyListener;
        public DialogInterface.OnShowListener mOnShowListener;
        public TextView mPositiveButton;
        public ViewGroup mRoot;
        public TextView mTitle;
        public LinearLayout mTitlePanel;
        public View mVDivider;

        public DialogElement(ViewGroup root) {
            this.mRoot = (ViewGroup) root.findViewById(R.id.dialog_root);
            this.mTitlePanel = (LinearLayout) root.findViewById(R.id.title_panel);
            this.mTitle = (TextView) root.findViewById(R.id.dialog_title);
            this.mDialogIcon = (ImageView) root.findViewById(R.id.dialog_icon);
            this.mMessage = (TextView) root.findViewById(R.id.dialog_message);
            this.mMessageContent = (LinearLayout) root.findViewById(R.id.dialog_message_content);
            this.mPositiveButton = (TextView) root.findViewById(R.id.positive_button);
            this.mNegativeButton = (TextView) root.findViewById(R.id.negative_button);
            this.mDialogLayout = (RelativeLayout) root.findViewById(R.id.searchbox_alert_dialog);
            this.mBtnPanelLayout = (LinearLayout) root.findViewById(R.id.btn_panel);
            this.mHDivider = root.findViewById(R.id.divider1);
            this.mVDivider = root.findViewById(R.id.divider2);
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        NightModeHelper.subscribeNightModeChangeEvent(this, new NightModeChangeListener() {
            public void onNightModeChanged(boolean isNightMode) {
                if (NoticeInAppTextDialog.this.mBuilder != null) {
                    NoticeInAppTextDialog.this.mBuilder.initUiResources();
                }
            }
        });
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        NightModeHelper.unsubscribeNightModeChangedEvent(this);
    }
}
