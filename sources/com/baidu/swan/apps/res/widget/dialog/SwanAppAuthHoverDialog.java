package com.baidu.swan.apps.res.widget.dialog;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.swan.apps.res.widget.dialog.SwanAppAlertDialog;
import com.baidu.swan.apps.storage.sp.SwanAppSpHelper;
import com.baidu.swan.apps.ui.R;
import com.baidu.swan.apps.view.decorate.SwanAppDialogDecorate;

public class SwanAppAuthHoverDialog extends SwanAppAlertDialog {
    public static final String KEY_AUTH_NOT_TIP = "request_draw_overlays_deny";

    public interface AuthHoverListener {
        public static final int STATUS_CLICK_NEGATIVE_BUTTON = -2;
        public static final int STATUS_CLICK_POSITIVE_BUTTON = -1;
        public static final int STATUS_DIALOG_CANCEL = 0;
        public static final int STATUS_HAS_PERMISSION = 1;
        public static final int STATUS_IGNORE = 3;
        public static final int STATUS_NOT_SHOW_TIP = 2;

        void onResult(boolean z, int i2);
    }

    protected SwanAppAuthHoverDialog(Context context) {
        super(context, R.style.SwanAppNoTitleDialog);
        setEnableImmersion(false);
        Window window = getWindow();
        if (window != null) {
            window.setGravity(80);
            window.setLayout(-1, -2);
            window.setWindowAnimations(R.style.action_sheet_animation);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getBuilder().setDialogLayoutBackgroundResource(R.drawable.aiapps_action_sheet_bg).hideTitle(true).setBtnsVisible(false).removePadding().setDividerVisible(false);
    }

    public static class Builder extends SwanAppAlertDialog.Builder {
        private TextView mAuthKonwIt;
        private LinearLayout mAuthKonwItLayout;
        private LinearLayout mAuthLayout;
        private TextView mAuthNegative;
        private TextView mAuthPositive;
        private boolean mDialogType;
        /* access modifiers changed from: private */
        public CheckBox mNotTip;
        /* access modifiers changed from: private */
        public boolean mSaveNotTipStatus = true;

        public Builder(Context context) {
            super(context);
            setDecorate(new SwanAppDialogDecorate());
            ViewGroup rootView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.swan_app_auth_hover_dialog, getCustomContentParent(), false);
            setView(rootView);
            this.mAuthLayout = (LinearLayout) rootView.findViewById(R.id.auth_layout);
            this.mAuthNegative = (TextView) rootView.findViewById(R.id.auth_negative_button);
            this.mAuthPositive = (TextView) rootView.findViewById(R.id.auth_positive_button);
            this.mAuthKonwItLayout = (LinearLayout) rootView.findViewById(R.id.know_it_layout);
            this.mAuthKonwIt = (TextView) rootView.findViewById(R.id.auth_know_it);
            CheckBox checkBox = (CheckBox) rootView.findViewById(R.id.hover_dialog_not_tips);
            this.mNotTip = checkBox;
            checkBox.setCompoundDrawablesWithIntrinsicBounds(context.getResources().getDrawable(R.drawable.swanapp_hover_dialog_tip_selector), (Drawable) null, (Drawable) null, (Drawable) null);
            this.mNotTip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    int i2;
                    CheckBox access$000 = Builder.this.mNotTip;
                    if (isChecked) {
                        i2 = R.string.swanapp_hover_dialog_not_tip_checked;
                    } else {
                        i2 = R.string.swanapp_hover_dialog_not_tip;
                    }
                    access$000.setText(i2);
                }
            });
            removePadding();
        }

        /* access modifiers changed from: protected */
        public SwanAppAuthHoverDialog onCreateDialog(Context context) {
            return new SwanAppAuthHoverDialog(context);
        }

        public SwanAppAuthHoverDialog create() {
            return (SwanAppAuthHoverDialog) super.create();
        }

        public Builder setNegativeButton(final DialogInterface.OnClickListener listener) {
            if (this.mDialogType) {
                this.mAuthKonwIt.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Builder.this.mDialog.onButtonClick(-2);
                        Builder.this.mDialog.dismiss();
                        if (Builder.this.mSaveNotTipStatus) {
                            SwanAppSpHelper.getInstance().putBoolean(SwanAppAuthHoverDialog.KEY_AUTH_NOT_TIP, true);
                        }
                        DialogInterface.OnClickListener onClickListener = listener;
                        if (onClickListener != null) {
                            onClickListener.onClick(Builder.this.mDialog, -2);
                        }
                    }
                });
            } else {
                this.mAuthNegative.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        Builder.this.mDialog.onButtonClick(-2);
                        Builder.this.mDialog.dismiss();
                        if (Builder.this.mSaveNotTipStatus) {
                            SwanAppSpHelper.getInstance().putBoolean(SwanAppAuthHoverDialog.KEY_AUTH_NOT_TIP, Builder.this.mNotTip.isChecked());
                        }
                        DialogInterface.OnClickListener onClickListener = listener;
                        if (onClickListener != null) {
                            onClickListener.onClick(Builder.this.mDialog, -2);
                        }
                    }
                });
            }
            return this;
        }

        public Builder setPositiveButton(final DialogInterface.OnClickListener listener) {
            this.mAuthPositive.setOnClickListener(new View.OnClickListener() {
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

        public Builder setCancelable(boolean cancelable) {
            super.setCancelable(cancelable);
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener onCancelListener) {
            super.setOnCancelListener(onCancelListener);
            return this;
        }

        public Builder setDialogType(boolean type) {
            this.mDialogType = type;
            if (type) {
                this.mAuthLayout.setVisibility(8);
                this.mNotTip.setVisibility(8);
                this.mAuthKonwItLayout.setVisibility(0);
            } else {
                this.mAuthKonwItLayout.setVisibility(8);
                this.mAuthLayout.setVisibility(0);
                this.mNotTip.setVisibility(0);
            }
            return this;
        }

        public Builder saveNotTipStatus(boolean saveNotTipStatus) {
            this.mSaveNotTipStatus = saveNotTipStatus;
            return this;
        }
    }
}
