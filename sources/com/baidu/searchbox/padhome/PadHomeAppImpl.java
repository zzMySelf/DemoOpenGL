package com.baidu.searchbox.padhome;

import android.content.Context;
import com.baidu.searchbox.download.center.clearcache.guide.HomeClearCacheGuide;
import com.baidu.searchbox.home.controller.HomeSchemeBackController;
import com.baidu.searchbox.home.controller.HomeSmartScheduleController;
import com.baidu.searchbox.home.controller.HomeTaskToastController;
import com.baidu.searchbox.home.controller.HomeVoiceController;
import com.baidu.searchbox.home.tabs.bubble.HomeTabBubbleController;
import com.baidu.searchbox.introduction.controller.HomeIntroductionController;
import com.baidu.searchbox.newhome.INewHomeEventListener;
import com.baidu.searchbox.padhome.ioc.IPadHomeApp;
import com.baidu.searchbox.shake.BDShakeController;
import com.baidu.searchbox.update.HomeUpdateCheckController;
import com.baidu.searchbox.usergrowth.business.guide.UserGrowthRightsHomeGuide;
import com.baidu.searchbox.widget.guide.HomeOneOneWidgetGuide;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u001a\u0010\b\u001a\u00020\u00052\u0006\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0002¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/padhome/PadHomeAppImpl;", "Lcom/baidu/searchbox/padhome/ioc/IPadHomeApp;", "()V", "getListeners", "", "Lcom/baidu/searchbox/padhome/IPadHomeEventListener;", "context", "Landroid/content/Context;", "wrapListeners", "listener", "Lcom/baidu/searchbox/newhome/INewHomeEventListener;", "isHomeOneOneWidgetGuide", "", "lib-home-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PadHomeAppImpl.kt */
public final class PadHomeAppImpl implements IPadHomeApp {
    public List<IPadHomeEventListener> getListeners(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return CollectionsKt.listOf(wrapListeners$default(this, new HomeIntroductionController(context), false, 2, (Object) null), wrapListeners$default(this, new HomeTabBubbleController(), false, 2, (Object) null), wrapListeners$default(this, new HomeVoiceController(context), false, 2, (Object) null), wrapListeners$default(this, new HomeTaskToastController(context), false, 2, (Object) null), wrapListeners$default(this, new HomeSchemeBackController(context), false, 2, (Object) null), wrapListeners$default(this, new HomeSmartScheduleController(), false, 2, (Object) null), wrapListeners$default(this, new BDShakeController(), false, 2, (Object) null), wrapListeners$default(this, new HomeClearCacheGuide(new WeakReference(context)), false, 2, (Object) null), wrapListeners$default(this, new HomeUpdateCheckController(context), false, 2, (Object) null), wrapListeners(new HomeOneOneWidgetGuide(), true), wrapListeners$default(this, new UserGrowthRightsHomeGuide(), false, 2, (Object) null));
    }

    static /* synthetic */ IPadHomeEventListener wrapListeners$default(PadHomeAppImpl padHomeAppImpl, INewHomeEventListener iNewHomeEventListener, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return padHomeAppImpl.wrapListeners(iNewHomeEventListener, z);
    }

    private final IPadHomeEventListener wrapListeners(INewHomeEventListener listener, boolean isHomeOneOneWidgetGuide) {
        return new PadHomeAppImpl$wrapListeners$1(isHomeOneOneWidgetGuide, listener);
    }
}
