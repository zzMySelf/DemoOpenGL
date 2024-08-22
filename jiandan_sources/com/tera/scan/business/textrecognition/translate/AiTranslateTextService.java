package com.tera.scan.business.textrecognition.translate;

import android.content.Context;
import android.content.Intent;
import android.os.ResultReceiver;
import androidx.lifecycle.LiveData;
import com.mars.kotlin.service.IHandlable;
import com.mars.kotlin.service.Result;
import com.tera.scan.business.textrecognition.translate.model.AiTranslateResponse;
import fe.mmm.qw.a.yj.qw.de;
import fe.mmm.qw.rg.de.rrr.qw.qw;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class AiTranslateTextService implements IAiTranslateText, IHandlable<IAiTranslateText> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public final Context f6823ad;
    @Nullable

    /* renamed from: de  reason: collision with root package name */
    public ResultReceiver f6824de;
    @NotNull
    public final de qw;

    public AiTranslateTextService(@NotNull de deVar, @NotNull Context context) {
        this.qw = deVar;
        this.f6823ad = context;
    }

    public void onHandle(@NotNull Intent intent) {
        String action = intent.getAction();
        if (action != null) {
            char c = 65535;
            if (action.hashCode() == 1333086060 && action.equals("com.tera.scan.business.textrecognition.translate.ACTION_AITRANSLATETEXT")) {
                c = 0;
            }
            if (c == 0) {
                try {
                    ClassLoader classLoader = intent.getExtras().getClassLoader();
                    if (classLoader == null) {
                        classLoader = getClass().getClassLoader();
                        intent.setExtrasClassLoader(classLoader);
                    }
                    classLoader.loadClass(ResultReceiver.class.getName());
                } catch (Throwable unused) {
                }
                this.f6824de = (ResultReceiver) intent.getParcelableExtra("android.os.ResultReceiverresultReceiver");
                qw(intent.getStringExtra("__java.lang.String__appKey"), intent.getStringExtra("__java.lang.String__fromLanguage"), intent.getStringExtra("__java.lang.String__toLanguage"), intent.getStringExtra("__java.lang.String__jsonList"));
            }
        }
    }

    @NotNull
    public LiveData<Result<AiTranslateResponse>> qw(@NotNull String str, @Nullable String str2, @NotNull String str3, @NotNull String str4) {
        this.qw.qw(new qw(this.f6823ad, str, str2, str3, str4, this.f6824de));
        this.f6824de = null;
        return null;
    }
}
