package com.baidu.searchbox.settings.teenager.guid;

import android.util.Log;
import com.baidu.common.matrixstyle.StyleMode;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.homepage.extend.IHomeFun;
import com.baidu.searchbox.settings.teenager.util.StyleModeHelper;
import com.baidu.searchbox.settings.teenager.util.TeenagerConstants;
import com.baidu.searchbox.settings.teenager.util.TeenagerUbcHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "hasLogin", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChildTeenagerGuidActivity.kt */
final class ChildTeenagerGuidActivity$handleGuidOpenBtnClick$1 extends Lambda implements Function1<Boolean, Unit> {
    final /* synthetic */ ChildTeenagerGuidActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChildTeenagerGuidActivity$handleGuidOpenBtnClick$1(ChildTeenagerGuidActivity childTeenagerGuidActivity) {
        super(1);
        this.this$0 = childTeenagerGuidActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1) {
        invoke(((Boolean) p1).booleanValue());
        return Unit.INSTANCE;
    }

    public final void invoke(boolean hasLogin) {
        if (hasLogin) {
            if (!this.this$0.fetchHasTeenagerPwd()) {
                this.this$0.gotoPasswordActivity(1);
                TeenagerUbcHelper.triggerUbc$default(TeenagerUbcHelper.INSTANCE, "click", "", TeenagerConstants.UBC_TYPE_SET_PASSWORD, "", (String) null, 16, (Object) null);
            } else if (!StyleMode.INSTANCE.isTeenagerStyle()) {
                StyleModeHelper.INSTANCE.setCurrentStyle(2);
                StyleModeHelper.INSTANCE.changeStyleUI();
                if (AppConfig.isDebug()) {
                    Log.d(TeenagerGuidActivity.TAG, "之前不是青少年模式，点【知道了】——> 开启青少年模式，并更新UI");
                }
            } else {
                ((IHomeFun) ServiceManager.getService(IHomeFun.SERVICE_REFERENCE)).gotoHome();
                this.this$0.finish();
            }
        } else if (AppConfig.isDebug()) {
            Log.d(TeenagerGuidActivity.TAG, "开启青少年模式之前登录失败");
        }
    }
}
