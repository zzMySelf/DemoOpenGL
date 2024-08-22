package com.baidu.wallet.base.controllers;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.wallet.base.iddetect.IdCardDetectionH5Activity;
import com.baidu.wallet.base.iddetect.IdentityCardDetectionActivity;
import com.baidu.wallet.core.NoProguard;

public class IdCardDetectionController {
    public IIdCardDetectionListener mIdCardResultListener;

    public interface IIdCardDetectionListener extends NoProguard {
        void onDetectFailed(int i2, String str);

        void onDetectOK(Bundle bundle);
    }

    public static class SingletonHolder {
        public static final IdCardDetectionController sInstance = new IdCardDetectionController();
    }

    public static final IdCardDetectionController getInstance() {
        return SingletonHolder.sInstance;
    }

    public void IdCardDeteFailed(int i2, String str) {
        IIdCardDetectionListener iIdCardDetectionListener = this.mIdCardResultListener;
        if (iIdCardDetectionListener != null) {
            iIdCardDetectionListener.onDetectFailed(i2, str);
        }
        this.mIdCardResultListener = null;
    }

    public void IdCardDeteSuccess(Bundle bundle) {
        IIdCardDetectionListener iIdCardDetectionListener = this.mIdCardResultListener;
        if (iIdCardDetectionListener != null) {
            iIdCardDetectionListener.onDetectOK(bundle);
        }
        this.mIdCardResultListener = null;
    }

    public void clearIdCardResultCallback() {
        this.mIdCardResultListener = null;
    }

    public IIdCardDetectionListener getIdCardDetectionListener() {
        return this.mIdCardResultListener;
    }

    public void startIdcarddetect(Context context, int i2, boolean z, IIdCardDetectionListener iIdCardDetectionListener, boolean z2) {
        this.mIdCardResultListener = iIdCardDetectionListener;
        if (i2 == 5 || i2 == 6) {
            Intent intent = new Intent(context, IdCardDetectionH5Activity.class);
            intent.putExtra("step", i2);
            if (z) {
                intent.putExtra("fromLangbridge", true);
            }
            if (!(context instanceof Activity)) {
                intent.setFlags(268435456);
            }
            context.startActivity(intent);
            return;
        }
        Intent intent2 = new Intent(context, IdentityCardDetectionActivity.class);
        intent2.putExtra("step", i2);
        if (z) {
            intent2.putExtra("fromLangbridge", true);
        }
        intent2.putExtra("show_album", z2);
        if (!(context instanceof Activity)) {
            intent2.setFlags(268435456);
        }
        context.startActivity(intent2);
    }

    public IdCardDetectionController() {
    }
}
