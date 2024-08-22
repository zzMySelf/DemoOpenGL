package com.baidu.bdtask;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.android.util.android.ActivityUtils;
import com.baidu.bdtask.framework.service.router.SchemeService;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002J\u001a\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/bdtask/TaskRouterService;", "Lcom/baidu/bdtask/framework/service/router/SchemeService;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getLightBrowserScheme", "", "urlWithoutEncode", "onIntercept", "", "scheme", "type", "", "lib_bdptask_operation_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BDPTaskSdkService.kt */
public final class TaskRouterService implements SchemeService {
    private final Context context;

    public TaskRouterService(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    private final String getLightBrowserScheme(String urlWithoutEncode) {
        StringBuilder schemeBuilder = new StringBuilder();
        schemeBuilder.append(UnitedSchemeConstants.UNITED_SCHEME).append("://v1/easybrowse/open?append=1&url=").append(Uri.encode(urlWithoutEncode));
        return schemeBuilder.toString();
    }

    public void onIntercept(String scheme, int type) {
        if (scheme != null && !TextUtils.isEmpty(scheme)) {
            String finalScheme = scheme;
            if (StringsKt.startsWith$default(finalScheme, "http", false, 2, (Object) null)) {
                finalScheme = getLightBrowserScheme(scheme);
            }
            if (!TextUtils.isEmpty(finalScheme)) {
                Uri uri = Uri.parse(finalScheme);
                if (TextUtils.equals(uri.getHost(), UnitedSchemeConstants.UNITED_SCHEME)) {
                    Router.invoke(this.context.getApplicationContext(), finalScheme);
                } else {
                    ActivityUtils.startActivitySafely(this.context.getApplicationContext(), new Intent("android.intent.action.VIEW", uri));
                }
            }
        }
    }
}
