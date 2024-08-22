package com.meizu.o;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.meizu.cloud.pushinternal.DebugLogger;
import com.meizu.cloud.pushsdk.constants.PushConstants;
import com.meizu.cloud.pushsdk.platform.message.SubTagsStatus;
import com.meizu.i.a;
import com.meizu.z.c;

public class e extends a<SubTagsStatus> {
    public e(Context context, com.meizu.h.a aVar) {
        super(context, aVar);
    }

    public int a() {
        return 2048;
    }

    /* access modifiers changed from: protected */
    public void a(SubTagsStatus subTagsStatus, c cVar) {
        if (b() != null && subTagsStatus != null) {
            b().a(c(), subTagsStatus);
        }
    }

    public boolean b(Intent intent) {
        DebugLogger.i("AbstractMessageHandler", "start SubScribeTagsStatusHandler match");
        return PushConstants.MZ_PUSH_ON_MESSAGE_ACTION.equals(intent.getAction()) && PushConstants.MZ_PUSH_MESSAGE_METHOD_ACTION_SUBTAGS_STATUS.equals(e(intent));
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public SubTagsStatus f(Intent intent) {
        try {
            String stringExtra = intent.getStringExtra(PushConstants.MZ_MESSAGE_VALUE);
            return !TextUtils.isEmpty(stringExtra) ? com.meizu.cloud.pushsdk.platform.message.a.d(stringExtra) : (SubTagsStatus) intent.getSerializableExtra(PushConstants.EXTRA_APP_PUSH_SUBTAGS_STATUS);
        } catch (Exception e2) {
            DebugLogger.e("AbstractMessageHandler", "SubTagsStatus getMessage error, " + e2.getMessage());
            return null;
        }
    }
}
