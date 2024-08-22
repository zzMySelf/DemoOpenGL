package com.baidu.searchbox.account.userinfo.view;

import android.view.MotionEvent;
import android.view.View;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/account/userinfo/view/AiGenerateNickNamePanel$onStart$1", "Landroid/view/View$OnTouchListener;", "onTouch", "", "v", "Landroid/view/View;", "event", "Landroid/view/MotionEvent;", "lib-account_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiGenerateNickNamePanel.kt */
public final class AiGenerateNickNamePanel$onStart$1 implements View.OnTouchListener {
    final /* synthetic */ AiGenerateNickNamePanel this$0;

    AiGenerateNickNamePanel$onStart$1(AiGenerateNickNamePanel $receiver) {
        this.this$0 = $receiver;
    }

    public boolean onTouch(View v, MotionEvent event) {
        if (!(event != null && event.getAction() == 1)) {
            return false;
        }
        this.this$0.dismiss();
        return true;
    }
}
