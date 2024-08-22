package com.baidu.android.ext.widget.dialog;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.android.support.appcompat.ScreenOrientationCompat;
import com.baidu.android.common.ui.R;
import com.baidu.android.ext.widget.ioc.BasicDialogRuntime;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.android.util.devices.DeviceUtil;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.skin.ioc.SkinResourcesRuntime;
import java.util.ArrayList;
import java.util.HashMap;

public class BaseActivityDialog extends Activity implements DialogInterface {
    private static final boolean DEBUG = false;
    private static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    public static final String KEY_FROM = "BOX_ACTIVITY_DIALOG_FROM";
    private static final String KEY_NIGHT_MODE = "BOX_ACTIVITY_DIALOG_NIGHT_MODE";
    private static final String TAG = "BaseActivityDialog";
    private int mBtnHeight;
    private LinearLayout mBtnPanelLayout;
    /* access modifiers changed from: private */
    public Builder mBuilder;
    private FrameLayout mDialogContent;
    private FrameLayout mDialogCustomPanel;
    protected RelativeLayout mDialogLayout;
    private View mDivider2;
    private View mDivider3;
    private View mDivider4;
    private Handler mHandler;
    private ImageView mIcon;
    private TextView mMessage;
    private LinearLayout mMessageContent;
    private TextView mNegativeButton;
    private TextView mNeutralButton;
    private TextView mPositiveButton;
    private BoxScrollView mScrollView;
    private TextView mTitle;
    public LinearLayout mTitlePanel;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        int orientation = ScreenOrientationCompat.releaseFixedOrientation(this);
        super.onCreate(savedInstanceState);
        ScreenOrientationCompat.fixedOrientation(this, orientation);
        BasicDialogRuntime.getBasicDialogIOC().changeScreenOrientation(this);
        setContentView(R.layout.searchbox_alert_dialog);
        getWindow().setLayout(-1, -1);
        Intent intent = getIntent();
        if (intent != null) {
            this.mBuilder = Builder.getBuilder(intent.getStringExtra(KEY_FOR_BUILDER));
        }
        if (this.mBuilder == null) {
            finish();
            return;
        }
        BdEventBus.Companion.getDefault().register(this.mBuilder, Builder.EventObject.class, new Action<Builder.EventObject>() {
            public void call(Builder.EventObject eventObject) {
                BaseActivityDialog.this.mBuilder.onEvent(eventObject);
            }
        });
        BdEventBus.Companion.getDefault().register(this.mBuilder, Builder.DismissEventObject.class, new Action<Builder.DismissEventObject>() {
            public void call(Builder.DismissEventObject dismissEventObject) {
                if (dismissEventObject.tag == BaseActivityDialog.this.mBuilder.mTag) {
                    BaseActivityDialog.this.dismiss();
                }
            }
        });
        initViews();
        show();
        setupViews();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        release();
        super.onDestroy();
    }

    public void cancel() {
        DialogInterface.OnCancelListener listener;
        Builder builder = this.mBuilder;
        if (!(builder == null || (listener = builder.cancelListener) == null)) {
            listener.onCancel(this);
        }
        finish();
    }

    public void dismiss() {
        onDismiss();
        finish();
    }

    public void onBackPressed() {
        DialogInterface.OnCancelListener listener;
        Builder builder = this.mBuilder;
        if (!(builder == null || (listener = builder.cancelListener) == null)) {
            listener.onCancel(this);
        }
        onDismiss();
        super.onBackPressed();
    }

    /* access modifiers changed from: protected */
    public void hideTitle(boolean bHide) {
        this.mTitlePanel.setVisibility(bHide ? 8 : 0);
    }

    /* access modifiers changed from: protected */
    public void onDismiss() {
        DialogInterface.OnDismissListener listener;
        Builder builder = this.mBuilder;
        if (builder != null && (listener = builder.dismissListener) != null) {
            listener.onDismiss(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onButtonClick(int which) {
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        this.mTitlePanel = (LinearLayout) findViewById(R.id.title_panel);
        this.mTitle = (TextView) findViewById(R.id.dialog_title);
        this.mMessage = (TextView) findViewById(R.id.dialog_message);
        this.mMessageContent = (LinearLayout) findViewById(R.id.dialog_message_content);
        this.mPositiveButton = (TextView) findViewById(R.id.positive_button);
        this.mNegativeButton = (TextView) findViewById(R.id.negative_button);
        this.mNeutralButton = (TextView) findViewById(R.id.neutral_button);
        this.mDivider3 = findViewById(R.id.divider3);
        this.mDivider4 = findViewById(R.id.divider4);
        this.mDialogContent = (FrameLayout) findViewById(R.id.dialog_custom_content);
        this.mIcon = (ImageView) findViewById(R.id.dialog_icon);
        this.mDialogLayout = (RelativeLayout) findViewById(R.id.searchbox_alert_dialog);
        this.mDivider2 = findViewById(R.id.divider2);
        this.mScrollView = (BoxScrollView) findViewById(R.id.message_scrollview);
        this.mBtnPanelLayout = (LinearLayout) findViewById(R.id.btn_panel);
        this.mDialogCustomPanel = (FrameLayout) findViewById(R.id.dialog_customPanel);
        this.mBtnHeight = getResources().getDimensionPixelSize(com.baidu.android.common.ui.style.R.dimen.dialog_btns_height);
        if (this.mBuilder.mScrollViewHeight > 0) {
            this.mScrollView.getLayoutParams().height = this.mBuilder.mScrollViewHeight;
        }
        if (DeviceUtil.OSInfo.isGingerbread() || DeviceUtil.OSInfo.isGingerbreadmr1()) {
            int textPadding = this.mMessage.getResources().getDimensionPixelSize(com.baidu.android.common.ui.style.R.dimen.dialog_text_padding);
            this.mMessage.setPadding(textPadding, 0, textPadding, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void setupViews() {
        if (this.mBuilder != null) {
            Builder builder = this.mBuilder;
            setTitle(builder.title);
            setIcon(builder.icon);
            setMessage(builder.message);
            setView(builder.contentView);
            setPositiveEnable(builder.positiveEnabled);
            setPositiveTextColor(builder.positiveTextColor);
            setPositiveButton(builder.positiveText);
            setNegativeButton(builder.negativeText);
            setBtnsPanlVisible(builder.hideBtnsPanel);
            hideTitle(builder.hideTitle);
            if (builder.customPanelMarginLayoutParams != null) {
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.mDialogCustomPanel.getLayoutParams();
                layoutParams.setMargins(builder.customPanelMarginLayoutParams[0], builder.customPanelMarginLayoutParams[1], builder.customPanelMarginLayoutParams[2], builder.customPanelMarginLayoutParams[3]);
                this.mDialogCustomPanel.setLayoutParams(layoutParams);
            }
            if (builder.mDialogBackGroundDrawable != null) {
                this.mDialogLayout.setBackground(builder.mDialogBackGroundDrawable);
            }
            if (builder.mPositiveBackGroundDrawable != null) {
                this.mPositiveButton.setBackground(builder.mPositiveBackGroundDrawable);
            }
            if (builder.mNegativeBackGroundDrawable != null) {
                this.mNegativeButton.setBackground(builder.mNegativeBackGroundDrawable);
            }
        }
    }

    public TextView ifOnlyOneBtnGetIt() {
        int count = 0;
        TextView oneBtnCache = null;
        TextView textView = this.mPositiveButton;
        if (textView != null && textView.getVisibility() == 0) {
            count = 0 + 1;
            oneBtnCache = this.mPositiveButton;
        }
        TextView textView2 = this.mNegativeButton;
        if (textView2 != null && textView2.getVisibility() == 0) {
            count++;
            oneBtnCache = this.mNegativeButton;
        }
        TextView textView3 = this.mNeutralButton;
        if (textView3 != null && textView3.getVisibility() == 0) {
            count++;
            oneBtnCache = this.mNeutralButton;
        }
        if (count != 1) {
            return null;
        }
        return oneBtnCache;
    }

    /* access modifiers changed from: protected */
    public void show() {
        Resources res = getResources();
        if (!isValidView() || res == null) {
            finish();
            return;
        }
        int dialogTitleColor = res.getColor(com.baidu.android.common.ui.style.R.color.dialog_title_text_color);
        int dialogMessageColor = res.getColor(com.baidu.android.common.ui.style.R.color.box_dialog_message_text_color);
        int dialogGrayLineColor = res.getColor(com.baidu.android.common.ui.style.R.color.dialog_gray);
        this.mDialogLayout.setBackground(res.getDrawable(com.baidu.android.common.ui.style.R.drawable.dialog_bg_white));
        this.mTitle.setTextColor(dialogTitleColor);
        this.mMessage.setTextColor(dialogMessageColor);
        this.mPositiveButton.setTextColor(dialogTitleColor);
        this.mPositiveButton.setBackground(res.getDrawable(com.baidu.android.common.ui.style.R.drawable.alertdialog_button_day_bg_right_selector));
        this.mNegativeButton.setTextColor(dialogTitleColor);
        this.mNegativeButton.setBackground(res.getDrawable(com.baidu.android.common.ui.style.R.drawable.alertdialog_button_day_bg_left_selector));
        this.mNeutralButton.setTextColor(dialogTitleColor);
        this.mNeutralButton.setBackground(res.getDrawable(com.baidu.android.common.ui.style.R.drawable.alertdialog_button_day_bg_selector));
        this.mDivider2.setBackgroundColor(dialogGrayLineColor);
        this.mDivider3.setBackgroundColor(dialogGrayLineColor);
        this.mDivider4.setBackgroundColor(dialogGrayLineColor);
        TextView btn = ifOnlyOneBtnGetIt();
        if (btn != null) {
            btn.setBackground(res.getDrawable(com.baidu.android.common.ui.style.R.drawable.alertdialog_button_day_bg_all_selector));
        }
    }

    /* access modifiers changed from: protected */
    public void setTitle(String title) {
        this.mTitle.setText(title);
    }

    /* access modifiers changed from: protected */
    public void setIcon(Drawable icon) {
        this.mIcon.setImageDrawable(icon);
        this.mIcon.setVisibility(icon != null ? 0 : 8);
    }

    /* access modifiers changed from: protected */
    public void setMessage(CharSequence message) {
        this.mMessage.setText(message);
        this.mMessageContent.setVisibility(!TextUtils.isEmpty(message) ? 0 : 8);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
        params.addRule(3, R.id.dialog_message_content);
        this.mBtnPanelLayout.setLayoutParams(params);
    }

    /* access modifiers changed from: protected */
    public void setView(View view2) {
        FrameLayout frameLayout = this.mDialogContent;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
            if (view2 != null) {
                this.mDialogContent.addView(view2);
                this.mMessageContent.setVisibility(8);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, this.mBtnHeight);
                params.addRule(3, R.id.dialog_customPanel);
                this.mBtnPanelLayout.setLayoutParams(params);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setPositiveEnable(boolean enabled) {
        this.mPositiveButton.setEnabled(enabled);
    }

    /* access modifiers changed from: protected */
    public void setPositiveTextColor(int color) {
        if (color != 0) {
            this.mPositiveButton.setTextColor(color);
        }
    }

    /* access modifiers changed from: protected */
    public void setPositiveButton(String text) {
        this.mPositiveButton.setText(text);
        this.mPositiveButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BaseActivityDialog.this.onButtonClick(-1);
                BdEventBus.Companion.getDefault().post(new Builder.EventObject(BaseActivityDialog.this, -1));
                BaseActivityDialog.this.dismiss();
            }
        });
        if (TextUtils.isEmpty(text)) {
            this.mPositiveButton.setVisibility(8);
            if (this.mNegativeButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(8);
                return;
            }
            return;
        }
        this.mPositiveButton.setVisibility(0);
        if (this.mNegativeButton.getVisibility() == 0) {
            this.mDivider3.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setNegativeButton(String text) {
        this.mNegativeButton.setText(text);
        this.mNegativeButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                BaseActivityDialog.this.onButtonClick(-2);
                BaseActivityDialog.this.dismiss();
                BdEventBus.Companion.getDefault().post(new Builder.EventObject(BaseActivityDialog.this, -2));
            }
        });
        if (TextUtils.isEmpty(text)) {
            this.mNegativeButton.setVisibility(8);
            if (this.mPositiveButton.getVisibility() == 0) {
                this.mDivider3.setVisibility(8);
                return;
            }
            return;
        }
        this.mNegativeButton.setVisibility(0);
        if (this.mPositiveButton.getVisibility() == 0) {
            this.mDivider3.setVisibility(0);
        }
    }

    /* access modifiers changed from: protected */
    public void setBtnsPanlVisible(boolean isHide) {
        if (isHide) {
            this.mBtnPanelLayout.setVisibility(8);
            this.mDivider2.setVisibility(8);
        }
    }

    /* access modifiers changed from: protected */
    public void post(Runnable action) {
        if (action != null) {
            if (this.mHandler == null) {
                this.mHandler = new Handler(Looper.getMainLooper());
            }
            this.mHandler.post(action);
        }
    }

    private void release() {
        if (this.mBuilder != null) {
            BdEventBus.Companion.getDefault().unregister(this.mBuilder);
            this.mBuilder.release();
            this.mBuilder = null;
        }
        setView((View) null);
    }

    public Resources getResources() {
        Resources skin = SkinResourcesRuntime.getSkinResourceContext().getSkinResources();
        if (skin != null) {
            return skin;
        }
        return super.getResources();
    }

    private boolean isValidView() {
        if (this.mDialogLayout == null || this.mTitle == null || this.mMessage == null || this.mPositiveButton == null || this.mNegativeButton == null || this.mNeutralButton == null || this.mDivider2 == null || this.mDivider3 == null || this.mDivider4 == null) {
            return false;
        }
        return true;
    }

    public static class Builder {
        public static final int DIALOG_NEGATIVE_TEXT_CANCEL = com.baidu.android.common.ui.style.R.string.dialog_negative_title_cancel;
        public static final int DIALOG_POSITIVE_TEXT_OK = com.baidu.android.common.ui.style.R.string.dialog_positive_title_ok;
        private static HashMap<String, Builder> sBuilderMap = new HashMap<>();
        private static ArrayList sDialogList = new ArrayList();
        /* access modifiers changed from: private */
        public DialogInterface.OnCancelListener cancelListener;
        /* access modifiers changed from: private */
        public View contentView;
        /* access modifiers changed from: private */
        public int[] customPanelMarginLayoutParams;
        /* access modifiers changed from: private */
        public DialogInterface.OnDismissListener dismissListener;
        /* access modifiers changed from: private */
        public Bundle extras;
        /* access modifiers changed from: private */
        public String from;
        /* access modifiers changed from: private */
        public boolean hideBtnsPanel;
        /* access modifiers changed from: private */
        public boolean hideTitle;
        /* access modifiers changed from: private */
        public Drawable icon;
        /* access modifiers changed from: private */
        public Context mContext;
        /* access modifiers changed from: private */
        public Drawable mDialogBackGroundDrawable;
        /* access modifiers changed from: private */
        public Class<? extends Activity> mDialogClass;
        public Drawable mNegativeBackGroundDrawable;
        public Drawable mPositiveBackGroundDrawable;
        /* access modifiers changed from: private */
        public int mScrollViewHeight;
        /* access modifiers changed from: private */
        public Object mTag;
        /* access modifiers changed from: private */
        public CharSequence message;
        private DialogInterface.OnClickListener negativeListener;
        /* access modifiers changed from: private */
        public String negativeText;
        /* access modifiers changed from: private */
        public boolean positiveEnabled;
        private DialogInterface.OnClickListener positiveListener;
        /* access modifiers changed from: private */
        public String positiveText;
        /* access modifiers changed from: private */
        public int positiveTextColor;
        /* access modifiers changed from: private */
        public String title;

        public Builder() {
            this(BaseActivityDialog.class);
        }

        public Builder(Class<? extends Activity> dialogClass) {
            this.positiveEnabled = true;
            this.mScrollViewHeight = -1;
            if (this.mContext == null) {
                this.mContext = AppRuntime.getAppContext();
            }
            this.mDialogClass = dialogClass;
        }

        static Builder getBuilder(String key) {
            Builder remove;
            if (TextUtils.isEmpty(key)) {
                return null;
            }
            synchronized (sBuilderMap) {
                remove = sBuilderMap.remove(key);
            }
            return remove;
        }

        static void setBuilder(String key, Builder builder) {
            if (!TextUtils.isEmpty(key) && builder != null) {
                synchronized (sBuilderMap) {
                    sBuilderMap.put(key, builder);
                }
            }
        }

        public Builder setTitle(int titleId) {
            return setTitle(this.mContext.getString(titleId));
        }

        public Builder setTitle(String text) {
            this.title = text;
            return this;
        }

        public Builder setMessage(int messageId) {
            return setMessage(this.mContext.getString(messageId));
        }

        public Builder setMessage(CharSequence text) {
            this.message = text;
            return this;
        }

        public Builder setMessage(String text) {
            this.message = text;
            return this;
        }

        public Builder setMessageHeight(int dix) {
            this.mScrollViewHeight = dix;
            return this;
        }

        public Builder setPositiveButton(int textId, DialogInterface.OnClickListener listener) {
            return setPositiveButton(this.mContext.getString(textId), listener);
        }

        public Builder setPositiveButton(String text, DialogInterface.OnClickListener listener) {
            this.positiveText = text;
            this.positiveListener = listener;
            return this;
        }

        public Builder setNegativeButton(int textId, DialogInterface.OnClickListener listener) {
            return setNegativeButton(this.mContext.getString(textId), listener);
        }

        public Builder setNegativeButton(String text, DialogInterface.OnClickListener listener) {
            this.negativeText = text;
            this.negativeListener = listener;
            return this;
        }

        public Builder setIcon(int iconId) {
            return setIcon(this.mContext.getResources().getDrawable(iconId));
        }

        public Builder setIcon(Drawable drawable) {
            this.icon = drawable;
            return this;
        }

        public Builder setView(View view2) {
            this.contentView = view2;
            return this;
        }

        public Builder setView(View view2, int viewSpacingLeft, int viewSpacingTop, int viewSpacingRight, int viewSpacingBottom) {
            this.contentView = view2;
            return this;
        }

        public Builder setOnCancelListener(DialogInterface.OnCancelListener listener) {
            this.cancelListener = listener;
            return this;
        }

        public Builder setOnDismissListener(DialogInterface.OnDismissListener listener) {
            this.dismissListener = listener;
            return this;
        }

        public Builder setPositiveEnabled(boolean enabled) {
            this.positiveEnabled = enabled;
            return this;
        }

        public Builder setPositiveTextColor(int color) {
            this.positiveTextColor = color;
            return this;
        }

        public Builder setCustomPanelMargin(int left, int top, int right, int bottom) {
            this.customPanelMarginLayoutParams = new int[]{left, top, right, bottom};
            return this;
        }

        public Builder setDialogBackGroundDrawable(Drawable dialogBackGroundDrawable) {
            this.mDialogBackGroundDrawable = dialogBackGroundDrawable;
            return this;
        }

        public Builder setPositiveBackGroundDrawable(Drawable backGroundDrawable) {
            this.mPositiveBackGroundDrawable = backGroundDrawable;
            return this;
        }

        public Builder setNegativeBackGroundDrawable(Drawable backGroundDrawable) {
            this.mNegativeBackGroundDrawable = backGroundDrawable;
            return this;
        }

        public Builder setBundle(Bundle bundle) {
            this.extras = bundle;
            return this;
        }

        public Builder setFrom(String from2) {
            this.from = from2;
            return this;
        }

        public Builder setContext(Context context) {
            this.mContext = context;
            return this;
        }

        public void setTag(Object tag) {
            this.mTag = tag;
            sDialogList.add(tag);
        }

        public void setHideBtnsPanel(boolean hideBtnsPanel2) {
            this.hideBtnsPanel = hideBtnsPanel2;
        }

        public boolean isShowing(Object tag) {
            return sDialogList.contains(tag);
        }

        public Builder hideTitle(boolean hideTitle2) {
            this.hideTitle = hideTitle2;
            return this;
        }

        /* access modifiers changed from: package-private */
        public void release() {
            sDialogList.remove(this.mTag);
            this.positiveListener = null;
            this.negativeListener = null;
            this.cancelListener = null;
            this.dismissListener = null;
            this.contentView = null;
            this.icon = null;
        }

        public void show() {
            show(false);
        }

        public void show(final boolean forNightMode) {
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                public void run() {
                    if (Builder.this.mContext == null) {
                        Context unused = Builder.this.mContext = AppRuntime.getAppContext();
                    }
                    if (Builder.this.mDialogClass == null) {
                        Class unused2 = Builder.this.mDialogClass = BaseActivityDialog.class;
                    }
                    Intent intent = new Intent(Builder.this.mContext, Builder.this.mDialogClass);
                    intent.putExtra(BaseActivityDialog.KEY_NIGHT_MODE, forNightMode);
                    String key = String.valueOf(intent.hashCode());
                    intent.putExtra(BaseActivityDialog.KEY_FOR_BUILDER, key);
                    if (!TextUtils.isEmpty(Builder.this.from)) {
                        intent.putExtra("BOX_ACTIVITY_DIALOG_FROM", Builder.this.from);
                    }
                    if (Builder.this.extras != null) {
                        intent.putExtras(Builder.this.extras);
                    }
                    Builder.setBuilder(key, Builder.this);
                    intent.addFlags(268435456);
                    try {
                        ActivityUtils.startActivitySafely(Builder.this.mContext, intent);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            });
        }

        public void onEvent(EventObject event) {
            if (event != null) {
                DialogInterface.OnClickListener listener = null;
                switch (event.which) {
                    case -2:
                        listener = this.negativeListener;
                        break;
                    case -1:
                        listener = this.positiveListener;
                        break;
                }
                if (listener != null) {
                    listener.onClick(event.dialog, event.which);
                }
            }
        }

        static class EventObject {
            /* access modifiers changed from: private */
            public DialogInterface dialog;
            /* access modifiers changed from: private */
            public int which;

            public EventObject(DialogInterface d2, int w) {
                this.dialog = d2;
                this.which = w;
            }
        }

        static class DismissEventObject {
            /* access modifiers changed from: private */
            public Object tag;

            public DismissEventObject(Object tag2) {
                this.tag = tag2;
            }
        }
    }
}
