package com.tera.scan.business.textrecognition.translate;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import androidx.lifecycle.LiveData;
import com.mars.kotlin.service.Extra;
import com.mars.kotlin.service.LiveResultReceiver;
import com.mars.kotlin.service.Result;
import com.mars.kotlin.service.extension.ContextKt;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateResponse;
import fe.mmm.qw.p030switch.de.qw.ad;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AiTranslateTextManager implements IAiTranslateText {
    @NotNull
    public final Context qw;

    public AiTranslateTextManager(@NotNull Context context) {
        this.qw = context;
    }

    @NotNull
    public LiveData<Result<AiTranslateResponse>> qw(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4) {
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("com.baidu.aiscan", "com.tera.scan.main.service.NetdiskService"));
        AnonymousClass1 r1 = new LiveResultReceiver<AiTranslateResponse>() {
            public AiTranslateResponse getData(Bundle bundle) {
                return (AiTranslateResponse) bundle.getParcelable(Extra.RESULT);
            }
        };
        intent.putExtra("android.os.ResultReceiverresultReceiver", r1);
        intent.setAction("com.tera.scan.business.textrecognition.translate.ACTION_AITRANSLATETEXT");
        intent.addCategory("AiTranslateTextService");
        intent.putExtra("__java.lang.String__appKey", str);
        intent.putExtra("__java.lang.String__fromLanguage", str2);
        intent.putExtra("__java.lang.String__toLanguage", str3);
        intent.putExtra("__java.lang.String__jsonList", str4);
        ContextKt.startService(this.qw, intent, "com.baidu.aiscan", "com.tera.scan.main.service.NetdiskJobService", ad.ad());
        return r1.asLiveData();
    }
}
