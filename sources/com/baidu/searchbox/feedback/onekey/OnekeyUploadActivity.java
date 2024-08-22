package com.baidu.searchbox.feedback.onekey;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.android.ext.widget.dialog.BoxAlertDialog;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.android.util.android.WrappedClipboardManager;
import com.baidu.searchbox.SearchBox;
import com.baidu.searchbox.appframework.ActionBarBaseActivity;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.deprecation.R;
import com.baidu.searchbox.feedback.onekey.utils.OnekeyUploadInfoManager;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.socialshare.bean.BaiduShareContent;

public class OnekeyUploadActivity extends ActionBarBaseActivity {
    private static final boolean DEBUG = SearchBox.GLOBAL_DEBUG;
    public static final String ONEKEY_UPLOAD_FAIL_NUMBER = "0";
    public static final String ONEKEY_UPLOAD_SCHEMA = "bdbox://bug";
    private static final String TAG = "OnekeyUploadActivity";
    /* access modifiers changed from: private */
    public Context mContext;
    private TextView mFeedbackButton;
    private FeedbackButtonStatus mFeedbackButtonStatus = FeedbackButtonStatus.UPLOAD;
    /* access modifiers changed from: private */
    public ImageView mFeedbackIcon;
    /* access modifiers changed from: private */
    public TextView mFeedbackResultNum;
    /* access modifiers changed from: private */
    public TextView mFeedbackResultTitle;
    private TextView mFeedbackTip;

    private enum FeedbackButtonStatus {
        UPLOAD,
        SHARECOPY,
        DISABLE
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_onekey_upload);
        setActionBarTitle(R.string.onekey_upload);
        init();
    }

    private void init() {
        this.mContext = this;
        this.mFeedbackIcon = (ImageView) findViewById(R.id.onekey_upload_feedback_icon);
        this.mFeedbackResultTitle = (TextView) findViewById(R.id.onekey_upload_feedback_num_title);
        this.mFeedbackResultNum = (TextView) findViewById(R.id.onekey_upload_feedback_num);
        this.mFeedbackTip = (TextView) findViewById(R.id.onekey_upload_feedback_tip);
        this.mFeedbackButton = (TextView) findViewById(R.id.onekey_upload_feedback_button);
        this.mFeedbackIcon.setVisibility(0);
        this.mFeedbackResultTitle.setVisibility(8);
        this.mFeedbackResultNum.setVisibility(8);
        this.mFeedbackTip.setText(R.string.onekey_upload_feedback_tip);
        this.mFeedbackTip.setVisibility(0);
        this.mFeedbackButton.setVisibility(0);
        this.mFeedbackButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                OnekeyUploadActivity.this.handleClickByStatus();
            }
        });
        updateFeedbackButton(FeedbackButtonStatus.UPLOAD);
        BdEventBus.Companion.getDefault().lazyRegister(this, OnekeyUploadEvent.class, 1, new Action<OnekeyUploadEvent>() {
            public void call(OnekeyUploadEvent onekeyUploadEvent) {
                if (onekeyUploadEvent == null || TextUtils.equals(onekeyUploadEvent.getFeedbackNum(), "0")) {
                    UniversalToast.makeText(OnekeyUploadActivity.this.getApplicationContext(), R.string.onekey_upload_feedback_error_tip).showToast();
                    OnekeyUploadActivity.this.updateFeedbackButton(FeedbackButtonStatus.UPLOAD);
                    return;
                }
                OnekeyUploadActivity.this.mFeedbackIcon.setVisibility(8);
                OnekeyUploadActivity.this.mFeedbackResultTitle.setVisibility(0);
                OnekeyUploadActivity.this.mFeedbackResultNum.setText(onekeyUploadEvent.getFeedbackNum());
                OnekeyUploadActivity.this.mFeedbackResultNum.setVisibility(0);
                OnekeyUploadActivity.this.updateFeedbackButton(FeedbackButtonStatus.SHARECOPY);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        BdEventBus.Companion.getDefault().unregister(this);
    }

    /* renamed from: com.baidu.searchbox.feedback.onekey.OnekeyUploadActivity$5  reason: invalid class name */
    static /* synthetic */ class AnonymousClass5 {
        static final /* synthetic */ int[] $SwitchMap$com$baidu$searchbox$feedback$onekey$OnekeyUploadActivity$FeedbackButtonStatus;

        static {
            int[] iArr = new int[FeedbackButtonStatus.values().length];
            $SwitchMap$com$baidu$searchbox$feedback$onekey$OnekeyUploadActivity$FeedbackButtonStatus = iArr;
            try {
                iArr[FeedbackButtonStatus.UPLOAD.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feedback$onekey$OnekeyUploadActivity$FeedbackButtonStatus[FeedbackButtonStatus.SHARECOPY.ordinal()] = 2;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$com$baidu$searchbox$feedback$onekey$OnekeyUploadActivity$FeedbackButtonStatus[FeedbackButtonStatus.DISABLE.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /* access modifiers changed from: private */
    public void handleClickByStatus() {
        switch (AnonymousClass5.$SwitchMap$com$baidu$searchbox$feedback$onekey$OnekeyUploadActivity$FeedbackButtonStatus[this.mFeedbackButtonStatus.ordinal()]) {
            case 1:
                updateFeedbackButton(FeedbackButtonStatus.DISABLE);
                new OnekeyUploadInfoManager().upload();
                return;
            case 2:
                final String feedbackNo = this.mFeedbackResultNum.getText().toString();
                new BoxAlertDialog.Builder(this.mContext).setTitle(R.string.onekey_upload_feedback_result_text).setMessage(R.string.onekey_upload_feedback_dialog_content).setPositiveButton(R.string.onekey_upload_feedback_dialog_positive, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        WrappedClipboardManager.newInstance(OnekeyUploadActivity.this.mContext).setText(feedbackNo);
                    }
                }).setNegativeButton(R.string.onekey_upload_feedback_dialog_negative, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        BDShare.getInstance().share(OnekeyUploadActivity.this.mContext, (View) null, new BaiduShareContent.Builder().setTextContent(OnekeyUploadActivity.this.getText(R.string.onekey_upload_feedback_number).toString() + feedbackNo).setSource("other_other").setShareType(9).create());
                    }
                }).create().show();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    public void updateFeedbackButton(FeedbackButtonStatus status) {
        this.mFeedbackButtonStatus = status;
        switch (AnonymousClass5.$SwitchMap$com$baidu$searchbox$feedback$onekey$OnekeyUploadActivity$FeedbackButtonStatus[this.mFeedbackButtonStatus.ordinal()]) {
            case 1:
                this.mFeedbackButton.setText(R.string.onekey_upload_feedback_title_text);
                this.mFeedbackButton.setEnabled(true);
                return;
            case 2:
                this.mFeedbackButton.setText(R.string.onekey_upload_feedback_result_text);
                this.mFeedbackButton.setEnabled(true);
                return;
            case 3:
                this.mFeedbackButton.setEnabled(false);
                return;
            default:
                return;
        }
    }
}
