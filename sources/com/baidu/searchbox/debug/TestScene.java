package com.baidu.searchbox.debug;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\b\u001a\u00020\tH&R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/debug/TestScene;", "", "mAnchorActivity", "Lcom/baidu/searchbox/debug/FloatMenuTestActivity;", "(Lcom/baidu/searchbox/debug/FloatMenuTestActivity;)V", "getMAnchorActivity", "()Lcom/baidu/searchbox/debug/FloatMenuTestActivity;", "setMAnchorActivity", "buildPopupMenuScene", "", "lib-floatmenu-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FloatMenuTestActivity.kt */
public abstract class TestScene {
    private FloatMenuTestActivity mAnchorActivity;

    public abstract void buildPopupMenuScene();

    public TestScene(FloatMenuTestActivity mAnchorActivity2) {
        Intrinsics.checkNotNullParameter(mAnchorActivity2, "mAnchorActivity");
        this.mAnchorActivity = mAnchorActivity2;
    }

    public final FloatMenuTestActivity getMAnchorActivity() {
        return this.mAnchorActivity;
    }

    public final void setMAnchorActivity(FloatMenuTestActivity floatMenuTestActivity) {
        Intrinsics.checkNotNullParameter(floatMenuTestActivity, "<set-?>");
        this.mAnchorActivity = floatMenuTestActivity;
    }
}
