package com.baidu.mms.voicesearch.mmsvoicesearchv2.controller;

import android.app.Activity;
import android.os.Bundle;
import com.baidu.mms.voicesearch.invoke.voicerecognition.MMSVoiceRecognitionManager;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.IMicPermissionDialog;
import com.baidu.mms.voicesearch.mmsvoicesearchv2.uikit.MicPermissionDialog;
import com.baidu.searchbox.appframework.pad.OrientationMgrKt;
import com.baidu.speechbundle.R;

public class MicPermissionActivity extends Activity implements IMicPermissionDialog {
    private String mCurrentEntry;
    private MicPermissionDialog mMicPermissionDialog;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mms_voice_activity_empty);
        OrientationMgrKt.changeScreenOrientation(this);
        callUpMicPermissionDialog();
    }

    public void setmCurrentEntry(String mCurrentEntry2) {
        this.mCurrentEntry = mCurrentEntry2;
    }

    private void callUpMicPermissionDialog() {
        MicPermissionDialog micPermissionDialog = this.mMicPermissionDialog;
        if (micPermissionDialog == null) {
            MicPermissionDialog micPermissionDialog2 = new MicPermissionDialog(this);
            this.mMicPermissionDialog = micPermissionDialog2;
            micPermissionDialog2.setmIMicPermissionDialogCallBack(this);
            this.mMicPermissionDialog.setCancelable(false);
            this.mMicPermissionDialog.show();
        } else if (!micPermissionDialog.isShowing()) {
            this.mMicPermissionDialog.show();
        }
        this.mMicPermissionDialog.changeSkin();
    }

    public void pressBtnIKnown() {
        MMSVoiceRecognitionManager.getInstance().pressBtnIKnown();
        finish();
    }

    public void pressBtnCancle() {
        MMSVoiceRecognitionManager.getInstance().pressBtnCancle();
        finish();
    }

    public void pressBtnMicSetting() {
        MMSVoiceRecognitionManager.getInstance().pressBtnMicSetting();
        finish();
    }

    public void micDialogDismiss() {
    }

    public void jumpToMicAuthorityGuideUrl() {
        MMSVoiceRecognitionManager.getInstance().jumpToMicAuthorityGuideUrl();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (this.mMicPermissionDialog != null) {
            this.mMicPermissionDialog = null;
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
