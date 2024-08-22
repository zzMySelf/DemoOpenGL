package com.meizu.p;

import android.content.Context;
import android.content.Intent;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.handler.MessageV3;
import com.meizu.h.a;
import com.meizu.q0.d;

public class c extends com.meizu.i.c {
    public c(Context context, a aVar) {
        super(context, aVar);
    }

    public int a() {
        return 8192;
    }

    /* access modifiers changed from: protected */
    public void a(MessageV3 messageV3, com.meizu.z.c cVar) {
        if (cVar != null) {
            cVar.a(messageV3);
            c(messageV3);
        }
    }

    public boolean b(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start ScheduleNotificationHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SCHEDULE_NOTIFICATION.equals(e(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: g */
    public void c(MessageV3 messageV3) {
        d.f(c(), messageV3.getUploadDataPackageName(), messageV3.getDeviceId(), messageV3.getTaskId(), messageV3.getSeqId(), messageV3.getPushTimestamp(), messageV3.getDelayedReportMillis());
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public void d(MessageV3 messageV3) {
        DebugLogger.e("AbstractMessageHandler", "ScheduleNotificationHandler don't repeat upload receiver push event");
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public int f(MessageV3 messageV3) {
        return 0;
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public MessageV3 f(Intent intent) {
        return (MessageV3) intent.getParcelableExtra(PushConstants.EXTRA_APP_PUSH_SCHEDULE_NOTIFICATION_MESSAGE);
    }
}
