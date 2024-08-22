package com.baidu.wallet.base.iddetect;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.wallet.core.NoProguard;

public class IdCardController {
    public IIdCardRecognizeListener mIdCardResultListener;

    public interface IIdCardRecognizeListener extends NoProguard {
        void onFail(int i2, Bundle bundle);

        void onSuccess(Bundle bundle);
    }

    public static class SingletonHolder {
        public static IdCardController sInstance = new IdCardController();
    }

    public static IdCardController getInstance() {
        return SingletonHolder.sInstance;
    }

    public void fail(int i2, Bundle bundle) {
        IIdCardRecognizeListener iIdCardRecognizeListener = this.mIdCardResultListener;
        if (iIdCardRecognizeListener != null) {
            iIdCardRecognizeListener.onFail(i2, bundle);
        }
        this.mIdCardResultListener = null;
    }

    public void startIdcarddetect(Context context, IIdCardRecognizeListener iIdCardRecognizeListener) {
        this.mIdCardResultListener = iIdCardRecognizeListener;
        Intent intent = new Intent(context, IdCardActivity.class);
        if (!(context instanceof Activity)) {
            intent.setFlags(268435456);
        }
        context.startActivity(intent);
    }

    public void success(Bundle bundle) {
        IIdCardRecognizeListener iIdCardRecognizeListener = this.mIdCardResultListener;
        if (iIdCardRecognizeListener != null) {
            iIdCardRecognizeListener.onSuccess(bundle);
        }
        this.mIdCardResultListener = null;
    }

    public IdCardController() {
    }
}
