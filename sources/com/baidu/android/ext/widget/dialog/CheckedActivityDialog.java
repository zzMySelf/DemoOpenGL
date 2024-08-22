package com.baidu.android.ext.widget.dialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BaseActivityDialog;
import com.baidu.searchbox.aps.base.PluginManager;
import com.baidu.searchbox.aps.base.utils.BaseConfiger;
import com.baidu.searchbox.aps.sdk.aar.R;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;

public class CheckedActivityDialog extends BaseActivityDialog {
    private static final String KEY_FOR_BUILDER = "BOX_ACTIVITY_DIALOG_FOR_BUILDER";
    private static final String KEY_NIGHT_MODE = "BOX_ACTIVITY_DIALOG_NIGHT_MODE";
    private static final String TAG = "CheckedActivityDialog";
    /* access modifiers changed from: private */
    public BoxBuilder mBuilder;
    private CheckBox mCheckCbx;
    private LinearLayout mCheckLlt;
    private TextView mCheckTxt;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        if (BaseConfiger.isDebug()) {
            Log.e(TAG, "onCreate()");
        }
        String key = getIntent().getStringExtra(KEY_FOR_BUILDER);
        BoxBuilder builder = BoxBuilder.getBuilder(key);
        this.mBuilder = builder;
        BoxBuilder.setBuilder(key, builder);
        super.onCreate(savedInstanceState);
        if (this.mBuilder == null) {
            if (BaseConfiger.isDebug()) {
                Log.e(TAG, "going to finish, mBuilder=" + this.mBuilder);
            }
            finish();
            return;
        }
        BdEventBus.Companion.getDefault().register(this.mBuilder, BaseActivityDialog.Builder.EventObject.class, new Action<BaseActivityDialog.Builder.EventObject>() {
            public void call(BaseActivityDialog.Builder.EventObject eventObject) {
                CheckedActivityDialog.this.mBuilder.onEvent(eventObject);
            }
        });
        BdEventBus.Companion.getDefault().register(this.mBuilder, BoxBuilder.CheckedDismissEventObject.class, new Action<BoxBuilder.CheckedDismissEventObject>() {
            public void call(BoxBuilder.CheckedDismissEventObject dismissEventObject) {
                if (dismissEventObject.tag == CheckedActivityDialog.this.mBuilder.mTag) {
                    CheckedActivityDialog.this.dismiss();
                }
            }
        });
        initViews();
        setupViews();
        show();
        if (BaseConfiger.isDebug()) {
            Log.e(TAG, "going to show");
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        BoxBuilder boxBuilder = this.mBuilder;
        if (boxBuilder != null) {
            boxBuilder.release();
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void initViews() {
        super.initViews();
        if (this.mBuilder.checkedChangeListener != null && !TextUtils.isEmpty(this.mBuilder.checkText)) {
            FrameLayout fl = (FrameLayout) LayoutInflater.from(this).inflate(R.layout.aps_base_alert_dialog, (ViewGroup) null);
            if (fl != null) {
                LinearLayout ll = (LinearLayout) fl.findViewById(R.id.aps_base_dialog_check_llt);
                if (ll != null) {
                    LinearLayout.LayoutParams lp = (LinearLayout.LayoutParams) ll.getLayoutParams();
                    lp.bottomMargin /= 2;
                    lp.topMargin = lp.bottomMargin;
                    ViewParent apsVp = ll.getParent();
                    if (apsVp != null && (apsVp instanceof ViewGroup)) {
                        ((ViewGroup) apsVp).removeView(ll);
                    }
                    LinearLayout containerView = (LinearLayout) findViewById(com.baidu.android.common.ui.R.id.dialog_message_content);
                    if (containerView != null) {
                        containerView.addView(ll, lp);
                        this.mCheckLlt = (LinearLayout) findViewById(R.id.aps_base_dialog_check_llt);
                        this.mCheckCbx = (CheckBox) findViewById(R.id.aps_base_dialog_check_rdb);
                        this.mCheckTxt = (TextView) findViewById(R.id.aps_base_dialog_check_txt);
                        setCheckListenerAndText(this.mBuilder.checkedChangeListener, this.mBuilder.checkText);
                    } else if (BaseConfiger.isDebug()) {
                        Log.e(TAG, "onCreate. can't find dialog_message_content");
                    }
                } else if (BaseConfiger.isDebug()) {
                    Log.e(TAG, "onCreate. can't find aps_base_dialog_check_llt");
                }
            } else if (BaseConfiger.isDebug()) {
                Log.e(TAG, "onCreate. can't inflate aps_base_alert_dialog");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setCheckListenerAndText(CompoundButton.OnCheckedChangeListener listener, String text) {
        if (listener == null || TextUtils.isEmpty(text)) {
            this.mCheckLlt.setVisibility(8);
            return;
        }
        this.mCheckLlt.setVisibility(0);
        this.mCheckCbx.setOnCheckedChangeListener(listener);
        this.mCheckTxt.setText(text);
    }

    public static class BoxBuilder extends BaseActivityDialog.Builder {
        protected String checkText;
        /* access modifiers changed from: private */
        public CompoundButton.OnCheckedChangeListener checkedChangeListener;
        private Context mContext = PluginManager.getAppContext();
        public Object mTag;

        public BoxBuilder() {
            super(CheckedActivityDialog.class);
        }

        public static BoxBuilder getBuilder(String key) {
            BaseActivityDialog.Builder builder = BaseActivityDialog.Builder.getBuilder(key);
            if (BaseConfiger.isDebug()) {
                Log.e(CheckedActivityDialog.TAG, "getBuilder: key=" + key + "->" + builder);
            }
            return (BoxBuilder) builder;
        }

        static void setBuilder(String key, BaseActivityDialog.Builder builder) {
            if (BaseConfiger.isDebug()) {
                Log.e(CheckedActivityDialog.TAG, "setBuilder: key=" + key + "->" + builder);
            }
            BaseActivityDialog.Builder.setBuilder(key, builder);
        }

        public void setTag(Object tag) {
            this.mTag = tag;
            super.setTag(tag);
        }

        public BoxBuilder setCheckListener(int textResId, CompoundButton.OnCheckedChangeListener listener) {
            this.checkText = this.mContext.getString(textResId);
            this.checkedChangeListener = listener;
            return this;
        }

        public void release() {
            this.checkedChangeListener = null;
        }

        protected static class CheckedDismissEventObject extends BaseActivityDialog.Builder.DismissEventObject {
            public Object tag;

            public CheckedDismissEventObject(Object tag2) {
                super(tag2);
                this.tag = tag2;
            }
        }

        public void show() {
            show(false);
        }

        public void show(boolean forNightMode) {
            if (BaseConfiger.isDebug()) {
                Log.e(CheckedActivityDialog.TAG, "show before");
            }
            super.show(forNightMode);
            if (BaseConfiger.isDebug()) {
                Log.e(CheckedActivityDialog.TAG, "show after");
            }
        }
    }
}
