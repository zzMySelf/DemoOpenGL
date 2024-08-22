package com.baidu.searchbox.vip;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.searchbox.vip.models.VipPurchaseConfig;
import com.baidu.searchbox.vip.models.VipPurchaseType;
import com.baidu.searchbox.vip.models.VipType;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

@StableApi
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\bg\u0018\u0000 $2\u00020\u0001:\u0001$JT\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052<\u0010\u0007\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\bH&Jb\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052<\u0010\u0007\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\bH&JR\u0010\u000f\u001a\u00020\u00032\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u00112\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\u000e\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&Jf\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0010\b\u0002\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00132:\b\u0002\u0010\u001e\u001a4\u0012\u0013\u0012\u00110\u001f¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b( \u0012\u0013\u0012\u00110\u0016¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH&J$\u0010\"\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00030\u0013H&¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/vip/IVipRightsManager;", "", "hasVipRights", "", "vipTypes", "", "Lcom/baidu/searchbox/vip/models/VipType;", "getRightsCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isRights", "supportVipTypes", "needRefreshRightsTypes", "openNetDiskPanSvipPage", "isSuccessOpenSvipPage", "Lkotlin/Function1;", "successCallback", "Lkotlin/Function0;", "failCallback", "source", "", "from", "purchaseVip", "vipPurchaseType", "Lcom/baidu/searchbox/vip/models/VipPurchaseType;", "vipPurchaseConfig", "Lcom/baidu/searchbox/vip/models/VipPurchaseConfig;", "closePurchaseCallback", "completionCallback", "", "code", "msg", "refreshVipRights", "refreshCallback", "Companion", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IVipRightsManager.kt */
public interface IVipRightsManager {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String NAME = "VIP_RIGHTS";
    public static final String NAME_SPACE = "vipRights";

    void hasVipRights(List<? extends VipType> list, List<? extends VipType> list2, Function2<? super Boolean, ? super List<? extends VipType>, Unit> function2);

    void hasVipRights(List<? extends VipType> list, Function2<? super Boolean, ? super List<? extends VipType>, Unit> function2);

    void openNetDiskPanSvipPage(Function1<? super Boolean, Unit> function1, Function0<Unit> function0, Function0<Unit> function02, String str, String str2);

    void purchaseVip(VipPurchaseType vipPurchaseType, VipPurchaseConfig vipPurchaseConfig, Function0<Unit> function0, Function2<? super Integer, ? super String, Unit> function2);

    void refreshVipRights(List<? extends VipType> list, Function0<Unit> function0);

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/vip/IVipRightsManager$Companion;", "", "()V", "NAME", "", "NAME_SPACE", "SERVICE_REFERENCE", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getSERVICE_REFERENCE", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "lib-vip-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IVipRightsManager.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final String NAME = "VIP_RIGHTS";
        public static final String NAME_SPACE = "vipRights";
        @StableApi
        private static final ServiceReference SERVICE_REFERENCE = new ServiceReference("vipRights", "VIP_RIGHTS");

        private Companion() {
        }

        public final ServiceReference getSERVICE_REFERENCE() {
            return SERVICE_REFERENCE;
        }
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IVipRightsManager.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void purchaseVip$default(IVipRightsManager iVipRightsManager, VipPurchaseType vipPurchaseType, VipPurchaseConfig vipPurchaseConfig, Function0 function0, Function2 function2, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 4) != 0) {
                    function0 = null;
                }
                if ((i2 & 8) != 0) {
                    function2 = null;
                }
                iVipRightsManager.purchaseVip(vipPurchaseType, vipPurchaseConfig, function0, function2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: purchaseVip");
        }

        public static /* synthetic */ void openNetDiskPanSvipPage$default(IVipRightsManager iVipRightsManager, Function1 function1, Function0 function0, Function0 function02, String str, String str2, int i2, Object obj) {
            String str3;
            if (obj == null) {
                if ((i2 & 8) != 0) {
                    str3 = null;
                } else {
                    str3 = str;
                }
                iVipRightsManager.openNetDiskPanSvipPage(function1, function0, function02, str3, str2);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: openNetDiskPanSvipPage");
        }
    }
}
