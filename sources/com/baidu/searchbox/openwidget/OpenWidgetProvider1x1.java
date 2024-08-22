package com.baidu.searchbox.openwidget;

import android.content.Context;
import android.content.Intent;
import com.baidu.searchbox.openwidget.model.OpenWidgetSize;
import com.baidu.searchbox.openwidget.utils.OpenWidgetProcess;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0014R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/openwidget/OpenWidgetProvider1x1;", "Lcom/baidu/searchbox/openwidget/OpenWidgetProvider;", "()V", "size", "Lcom/baidu/searchbox/openwidget/model/OpenWidgetSize;", "getSize", "()Lcom/baidu/searchbox/openwidget/model/OpenWidgetSize;", "handleCustomActions", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "lib-openwidget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@OpenWidgetProcess
/* compiled from: OpenWidgetProvider1x1.kt */
public final class OpenWidgetProvider1x1 extends OpenWidgetProvider {
    private final OpenWidgetSize size = OpenWidgetSize.SIZE_TINY;

    public OpenWidgetSize getSize() {
        return this.size;
    }

    /* access modifiers changed from: protected */
    public boolean handleCustomActions(Context context, Intent intent) {
        String action;
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        if (super.handleCustomActions(context, intent) || (action = intent.getAction()) == null) {
            return false;
        }
        switch (action.hashCode()) {
            case 1412865185:
                if (!action.equals(OpenWidgetProvider.ACTION_GROUP_REFRESH_1x1)) {
                    return false;
                }
                onGroupRefresh(context, OpenWidgetSize.SIZE_TINY);
                return true;
            default:
                return false;
        }
    }
}
