package com.baidu.searchbox.vip;

import com.baidu.netdisk.model.AccountInfo;
import com.baidu.netdisk.model.AccountInfoKt;
import com.baidu.searchbox.diskupload.BdDiskUpload;
import com.baidu.searchbox.vip.models.VipPurchaseType;
import com.baidu.searchbox.vip.models.VipType;
import com.baidu.searchbox.vip.models.VipUserInfo;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000U\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001JT\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052<\u0010\u0007\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\bH\u0002JJ\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u001028\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0002JT\u0010\u0016\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052<\u0010\u0007\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\bH\u0016Jb\u0010\u0016\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052<\u0010\u0007\u001a8\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u00030\bH\u0016JP\u0010\u0018\u001a\u00020\u00032\u0012\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00030\u001a2\u000e\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001c2\u000e\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001c2\b\u0010\u001e\u001a\u0004\u0018\u00010\u00142\b\u0010\u001f\u001a\u0004\u0018\u00010\u0014H\u0016Jb\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\"2\u0006\u0010\u000f\u001a\u00020\u00102\u000e\u0010#\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u001c28\u0010\u0011\u001a4\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0013\u0012\u0013\u0012\u00110\u0014¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0003\u0018\u00010\bH\u0016J$\u0010$\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00030\u001cH\u0016¨\u0006&"}, d2 = {"com/baidu/searchbox/vip/VipRightsServicesFetcher$createService$1", "Lcom/baidu/searchbox/vip/IVipRightsManager;", "getVipRights", "", "vipTypes", "", "Lcom/baidu/searchbox/vip/models/VipType;", "getRightsCallback", "Lkotlin/Function2;", "", "Lkotlin/ParameterName;", "name", "isRights", "supportVipTypes", "gotoBuyDuVip", "vipPurchaseConfig", "Lcom/baidu/searchbox/vip/models/VipPurchaseConfig;", "completionCallback", "", "code", "", "msg", "hasVipRights", "needRefreshRightsTypes", "openNetDiskPanSvipPage", "isSuccessOpenSvipPage", "Lkotlin/Function1;", "successCallback", "Lkotlin/Function0;", "failCallback", "source", "from", "purchaseVip", "vipPurchaseType", "Lcom/baidu/searchbox/vip/models/VipPurchaseType;", "closePurchaseCallback", "refreshVipRights", "refreshCallback", "lib-vip_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipRightsServicesFetcher.kt */
public final class VipRightsServicesFetcher$createService$1 implements IVipRightsManager {

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VipRightsServicesFetcher.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[VipType.values().length];
            iArr[VipType.VIP_TYPE_DU.ordinal()] = 1;
            iArr[VipType.VIP_TYPE_NET_DISK_NEW_VIP.ordinal()] = 2;
            iArr[VipType.VIP_TYPE_NET_DISK_SVIP.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[VipPurchaseType.values().length];
            iArr2[VipPurchaseType.PURCHASE_TYPE_DU.ordinal()] = 1;
            iArr2[VipPurchaseType.PURCHASE_TYPE_NET_DISK.ordinal()] = 2;
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    VipRightsServicesFetcher$createService$1() {
    }

    public void hasVipRights(List<? extends VipType> vipTypes, Function2<? super Boolean, ? super List<? extends VipType>, Unit> getRightsCallback) {
        Intrinsics.checkNotNullParameter(vipTypes, "vipTypes");
        Intrinsics.checkNotNullParameter(getRightsCallback, "getRightsCallback");
        hasVipRights(vipTypes, CollectionsKt.emptyList(), getRightsCallback);
    }

    public void hasVipRights(List<? extends VipType> vipTypes, List<? extends VipType> needRefreshRightsTypes, Function2<? super Boolean, ? super List<? extends VipType>, Unit> getRightsCallback) {
        IVipUserInfoManager access$getIVipUserInfoManager;
        List<? extends VipType> list = vipTypes;
        List<? extends VipType> list2 = needRefreshRightsTypes;
        Function2<? super Boolean, ? super List<? extends VipType>, Unit> function2 = getRightsCallback;
        Intrinsics.checkNotNullParameter(list, "vipTypes");
        Intrinsics.checkNotNullParameter(list2, "needRefreshRightsTypes");
        Intrinsics.checkNotNullParameter(function2, "getRightsCallback");
        if (vipTypes.isEmpty()) {
            function2.invoke(false, CollectionsKt.emptyList());
        }
        if (needRefreshRightsTypes.isEmpty()) {
            getVipRights(list, function2);
            return;
        }
        boolean isRefreshDuVip = list2.contains(VipType.VIP_TYPE_DU);
        boolean isRefreshNetDiskVip = list2.contains(VipType.VIP_TYPE_NET_DISK_NEW_VIP) || list2.contains(VipType.VIP_TYPE_NET_DISK_SVIP);
        Ref.BooleanRef refreshDuComplete = new Ref.BooleanRef();
        Ref.BooleanRef refreshNetDiskComplete = new Ref.BooleanRef();
        if (isRefreshDuVip) {
            VipUserInfoManager.syncVipInfo$default(new VipRightsServicesFetcher$createService$1$hasVipRights$1(refreshDuComplete, isRefreshNetDiskVip, refreshNetDiskComplete, this, vipTypes, getRightsCallback), false, 2, (Object) null);
        }
        if (isRefreshNetDiskVip && (access$getIVipUserInfoManager = VipRightsServicesFetcherKt.getIVipUserInfoManager()) != null) {
            access$getIVipUserInfoManager.refreshNetDiskUserInfo(new VipRightsServicesFetcher$createService$1$hasVipRights$2(refreshNetDiskComplete, isRefreshDuVip, refreshDuComplete, this, vipTypes, getRightsCallback));
        }
    }

    /* access modifiers changed from: private */
    public final void getVipRights(List<? extends VipType> vipTypes, Function2<? super Boolean, ? super List<? extends VipType>, Unit> getRightsCallback) {
        boolean isRights = false;
        List isRightsList = new ArrayList();
        BdDiskUpload netDiskUploader = BdDiskUpload.get();
        Intrinsics.checkNotNullExpressionValue(netDiskUploader, "get()");
        for (VipType vipType : vipTypes) {
            boolean isSvipRights = false;
            switch (WhenMappings.$EnumSwitchMapping$0[vipType.ordinal()]) {
                case 1:
                    IVipUserInfoManager access$getIVipUserInfoManager = VipRightsServicesFetcherKt.getIVipUserInfoManager();
                    VipUserInfo vipUserInfo = access$getIVipUserInfoManager != null ? access$getIVipUserInfoManager.getVipUserInfo() : null;
                    if (vipUserInfo != null) {
                        isSvipRights = vipUserInfo.hasDuVip();
                    }
                    if (!isSvipRights) {
                        break;
                    } else {
                        isRights = true;
                        isRightsList.add(VipType.VIP_TYPE_DU);
                        break;
                    }
                case 2:
                    AccountInfo accountInfo = netDiskUploader.getAccountInfo();
                    if (accountInfo != null) {
                        Intrinsics.checkNotNullExpressionValue(accountInfo, "accountInfo");
                        isSvipRights = AccountInfoKt.isNewVip(accountInfo);
                    }
                    if (!isSvipRights) {
                        break;
                    } else {
                        isRights = true;
                        isRightsList.add(VipType.VIP_TYPE_NET_DISK_NEW_VIP);
                        break;
                    }
                case 3:
                    AccountInfo accountInfo2 = netDiskUploader.getAccountInfo();
                    if (accountInfo2 != null) {
                        Intrinsics.checkNotNullExpressionValue(accountInfo2, "accountInfo");
                        isSvipRights = AccountInfoKt.isSVip(accountInfo2);
                    }
                    if (!isSvipRights) {
                        break;
                    } else {
                        isRights = true;
                        isRightsList.add(VipType.VIP_TYPE_NET_DISK_SVIP);
                        break;
                    }
            }
        }
        getRightsCallback.invoke(Boolean.valueOf(isRights), isRightsList);
    }

    public void refreshVipRights(List<? extends VipType> vipTypes, Function0<Unit> refreshCallback) {
        Intrinsics.checkNotNullParameter(vipTypes, "vipTypes");
        Intrinsics.checkNotNullParameter(refreshCallback, "refreshCallback");
        hasVipRights(vipTypes, vipTypes, new VipRightsServicesFetcher$createService$1$refreshVipRights$1(refreshCallback));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        if (r3 != false) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void purchaseVip(com.baidu.searchbox.vip.models.VipPurchaseType r6, com.baidu.searchbox.vip.models.VipPurchaseConfig r7, kotlin.jvm.functions.Function0<kotlin.Unit> r8, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> r9) {
        /*
            r5 = this;
            java.lang.String r0 = "vipPurchaseType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "vipPurchaseConfig"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            int[] r0 = com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1.WhenMappings.$EnumSwitchMapping$1
            int r1 = r6.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0025;
                default: goto L_0x0017;
            }
        L_0x0017:
            if (r9 == 0) goto L_0x0078
            r0 = -3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.String r1 = "未知错误"
            r9.invoke(r0, r1)
            goto L_0x0078
        L_0x0025:
            java.lang.String r0 = r7.getFrom()
            java.lang.String r1 = r7.getSource()
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r3 = 0
            r4 = 1
            if (r2 == 0) goto L_0x003d
            int r2 = r2.length()
            if (r2 != 0) goto L_0x003b
            goto L_0x003d
        L_0x003b:
            r2 = r3
            goto L_0x003e
        L_0x003d:
            r2 = r4
        L_0x003e:
            if (r2 != 0) goto L_0x004e
            r2 = r1
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x004b
            int r2 = r2.length()
            if (r2 != 0) goto L_0x004c
        L_0x004b:
            r3 = r4
        L_0x004c:
            if (r3 == 0) goto L_0x005b
        L_0x004e:
            if (r9 == 0) goto L_0x005b
            r2 = -2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r3 = "购买参数错误"
            r9.invoke(r2, r3)
        L_0x005b:
            com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$purchaseVip$1 r2 = new com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$purchaseVip$1
            r2.<init>(r5, r7, r9)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$purchaseVip$2 r3 = new com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$purchaseVip$2
            r3.<init>(r9)
            kotlin.jvm.functions.Function0 r3 = (kotlin.jvm.functions.Function0) r3
            com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$purchaseVip$3 r4 = new com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$purchaseVip$3
            r4.<init>(r9)
            kotlin.jvm.functions.Function0 r4 = (kotlin.jvm.functions.Function0) r4
            com.baidu.searchbox.vip.VipUpgradeManagerKt.openNetDiskSvipPage(r2, r3, r4, r1, r0)
            goto L_0x0078
        L_0x0075:
            r5.gotoBuyDuVip(r7, r9)
        L_0x0078:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1.purchaseVip(com.baidu.searchbox.vip.models.VipPurchaseType, com.baidu.searchbox.vip.models.VipPurchaseConfig, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2):void");
    }

    public void openNetDiskPanSvipPage(Function1<? super Boolean, Unit> isSuccessOpenSvipPage, Function0<Unit> successCallback, Function0<Unit> failCallback, String source, String from) {
        Intrinsics.checkNotNullParameter(isSuccessOpenSvipPage, "isSuccessOpenSvipPage");
        VipUpgradeManagerKt.openNetDiskSvipPage(isSuccessOpenSvipPage, successCallback, failCallback, source, from);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0014, code lost:
        if (true == (r0.length() > 0)) goto L_0x0018;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void gotoBuyDuVip(com.baidu.searchbox.vip.models.VipPurchaseConfig r5, kotlin.jvm.functions.Function2<? super java.lang.Integer, ? super java.lang.String, kotlin.Unit> r6) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getScheme()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0017
            r3 = r0
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            int r3 = r3.length()
            if (r3 <= 0) goto L_0x0013
            r3 = r1
            goto L_0x0014
        L_0x0013:
            r3 = r2
        L_0x0014:
            if (r1 != r3) goto L_0x0017
            goto L_0x0018
        L_0x0017:
            r1 = r2
        L_0x0018:
            if (r1 == 0) goto L_0x0035
            android.content.Context r1 = com.baidu.searchbox.common.runtime.AppRuntime.getAppContext()
            java.lang.String r2 = "context"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$gotoBuyDuVip$1 r2 = new com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$gotoBuyDuVip$1
            r2.<init>(r6)
            kotlin.jvm.functions.Function1 r2 = (kotlin.jvm.functions.Function1) r2
            com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$gotoBuyDuVip$2 r3 = new com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1$gotoBuyDuVip$2
            r3.<init>(r6)
            kotlin.jvm.functions.Function2 r3 = (kotlin.jvm.functions.Function2) r3
            com.baidu.searchbox.vip.utils.VipBuyActiveCommonUtilsKt.commonBuyVip(r1, r0, r2, r3)
            goto L_0x0042
        L_0x0035:
            if (r6 == 0) goto L_0x0042
            r1 = -2
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            java.lang.String r2 = "购买参数错误"
            r6.invoke(r1, r2)
        L_0x0042:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.vip.VipRightsServicesFetcher$createService$1.gotoBuyDuVip(com.baidu.searchbox.vip.models.VipPurchaseConfig, kotlin.jvm.functions.Function2):void");
    }
}
