package com.meizu.g0;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.appsearch.lite.AppsearchNetService;
import com.baidu.searchbox.download.center.ui.doc.transcode.core.DocTranscodeConstants;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.platform.PlatformMessageSender;
import com.meizu.cloud.pushsdk.platform.message.UnRegisterStatus;
import com.meizu.d.c;
import com.meizu.f0.a;
import com.meizu.q0.b;
import java.util.concurrent.ScheduledExecutorService;

public class g extends c<UnRegisterStatus> {
    public g(Context context, a aVar, ScheduledExecutorService scheduledExecutorService) {
        this(context, (String) null, (String) null, aVar, scheduledExecutorService);
    }

    public g(Context context, a aVar, ScheduledExecutorService scheduledExecutorService, boolean z) {
        this(context, aVar, scheduledExecutorService);
        this.f4972g = z;
    }

    public g(Context context, String str, String str2, a aVar, ScheduledExecutorService scheduledExecutorService) {
        super(context, str, str2, aVar, scheduledExecutorService);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void b(UnRegisterStatus unRegisterStatus) {
        PlatformMessageSender.a(this.f4967b, !TextUtils.isEmpty(this.f4970e) ? this.f4970e : this.f4967b.getPackageName(), unRegisterStatus);
    }

    /* access modifiers changed from: protected */
    public boolean d() {
        return !TextUtils.isEmpty(this.f4968c) && !TextUtils.isEmpty(this.f4969d);
    }

    /* access modifiers changed from: protected */
    public Intent h() {
        Intent intent = new Intent();
        intent.putExtra("app_id", this.f4968c);
        intent.putExtra("app_key", this.f4969d);
        intent.putExtra("strategy_package_name", this.f4967b.getPackageName());
        intent.putExtra(AppsearchNetService.KEY_RECOMMEND_STRATEGY, j());
        return intent;
    }

    /* access modifiers changed from: protected */
    public int j() {
        return 32;
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public UnRegisterStatus a() {
        String str;
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        unRegisterStatus.setCode("20001");
        if (TextUtils.isEmpty(this.f4968c)) {
            str = "appId not empty";
        } else {
            if (TextUtils.isEmpty(this.f4969d)) {
                str = "appKey not empty";
            }
            return unRegisterStatus;
        }
        unRegisterStatus.setMessage(str);
        return unRegisterStatus;
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public UnRegisterStatus c() {
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public UnRegisterStatus e() {
        UnRegisterStatus unRegisterStatus = new UnRegisterStatus();
        if (TextUtils.isEmpty(b.g(this.f4967b, this.f4970e))) {
            unRegisterStatus.setCode("200");
            unRegisterStatus.setMessage("already unRegister PushId,don't unRegister frequently");
            unRegisterStatus.setIsUnRegisterSuccess(true);
            return unRegisterStatus;
        }
        String b2 = c.b(this.f4967b);
        String a2 = c.a(this.f4967b);
        if (!TextUtils.isEmpty(b2) || !TextUtils.isEmpty(a2)) {
            com.meizu.r.c d2 = this.f4971f.d(this.f4968c, this.f4969d, a2, b2);
            if (!d2.c()) {
                com.meizu.s.a a3 = d2.a();
                if (a3.c() != null) {
                    DebugLogger.e("Strategy", "status code=" + a3.b() + " data=" + a3.c());
                }
                unRegisterStatus.setCode(String.valueOf(a3.b()));
                unRegisterStatus.setMessage(a3.a());
                DebugLogger.e("Strategy", "unRegisterStatus " + unRegisterStatus);
                return unRegisterStatus;
            }
            UnRegisterStatus unRegisterStatus2 = new UnRegisterStatus((String) d2.b());
            DebugLogger.e("Strategy", "network unRegisterStatus " + unRegisterStatus2);
            if ("200".equals(unRegisterStatus2.getCode())) {
                b.g(this.f4967b, "", this.f4970e);
            }
            return unRegisterStatus2;
        }
        unRegisterStatus.setCode(DocTranscodeConstants.TRANSCODE_RESULT_CODE_PARAM_ERROR);
        unRegisterStatus.setMessage("deviceId is empty");
        return unRegisterStatus;
    }
}
