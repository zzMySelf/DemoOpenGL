package com.baidu.searchbox.openwidget.guide;

import android.app.Activity;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.openwidget.guide.model.OpenWidgetGuideParams;
import com.baidu.searchbox.openwidget.scheme.UnitedSchemeOpenWidgetDispatcherKt;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010J\b\u0010\u0002\u001a\u00020\u0003H'J\u0012\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H'J\b\u0010\b\u001a\u00020\tH'J \u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u000fH'¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/openwidget/guide/OpenWidgetGuideManager;", "", "exceededLimitDays", "", "getActivatedGuideParams", "Lcom/baidu/searchbox/openwidget/guide/model/OpenWidgetGuideParams;", "page", "", "reportGuideShowed", "", "showAddOpenWidgetGuide", "activity", "Landroid/app/Activity;", "guideParams", "callback", "Lcom/baidu/searchbox/openwidget/guide/OpenWidgetGuideCallback;", "Companion", "lib-openwidget-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OpenWidgetGuideManager.kt */
public interface OpenWidgetGuideManager {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int ERROR_ADD_FAILED = 2003;
    public static final int ERROR_PROCESS_INVALID = 2002;
    public static final int ERROR_SERVICE_INVALID = 2001;
    public static final String GUIDE_PAGE_HOME = "home";
    public static final String GUIDE_PAGE_RESULT = "result";
    public static final String KEY_GUIDE_PAGE = "guide";

    boolean exceededLimitDays();

    OpenWidgetGuideParams getActivatedGuideParams(String str);

    void reportGuideShowed();

    void showAddOpenWidgetGuide(Activity activity, OpenWidgetGuideParams openWidgetGuideParams, OpenWidgetGuideCallback openWidgetGuideCallback);

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u0004\u0018\u00010\u000eR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\bXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/openwidget/guide/OpenWidgetGuideManager$Companion;", "", "()V", "ERROR_ADD_FAILED", "", "ERROR_PROCESS_INVALID", "ERROR_SERVICE_INVALID", "GUIDE_PAGE_HOME", "", "GUIDE_PAGE_RESULT", "KEY_GUIDE_PAGE", "serviceReference", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getOrNull", "Lcom/baidu/searchbox/openwidget/guide/OpenWidgetGuideManager;", "lib-openwidget-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: OpenWidgetGuideManager.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ERROR_ADD_FAILED = 2003;
        public static final int ERROR_PROCESS_INVALID = 2002;
        public static final int ERROR_SERVICE_INVALID = 2001;
        public static final String GUIDE_PAGE_HOME = "home";
        public static final String GUIDE_PAGE_RESULT = "result";
        public static final String KEY_GUIDE_PAGE = "guide";
        private static final ServiceReference serviceReference = new ServiceReference(UnitedSchemeOpenWidgetDispatcherKt.MODULE_NAME, "OpenWidgetGuideManager");

        private Companion() {
        }

        public final OpenWidgetGuideManager getOrNull() {
            return (OpenWidgetGuideManager) ServiceManager.getService(serviceReference);
        }
    }
}
