package com.baidu.searchbox.vip;

import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.account.IAccountStatusChangedListener;
import com.baidu.searchbox.account.event.UserInfoChangeEvent;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.vip.models.VipUserInfo;
import com.baidu.searchbox.vip.utils.VipAccountUtilsKt;
import com.baidu.searchbox.vip.utils.VipKVUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0002J\b\u0010\u000f\u001a\u00020\u0010H\u0007J\b\u0010\u0011\u001a\u00020\rH\u0002J\b\u0010\u0012\u001a\u00020\u0010H\u0003Jc\u0010\u0013\u001a\u00020\u00102O\b\u0002\u0010\u0014\u001aI\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0019\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u00152\b\b\u0002\u0010\u000e\u001a\u00020\rH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/vip/VipUserInfoManager;", "", "()V", "accountListener", "Lcom/baidu/searchbox/account/IAccountStatusChangedListener;", "<set-?>", "Lcom/baidu/searchbox/vip/models/VipUserInfo;", "vipUserInfo", "getVipUserInfo", "()Lcom/baidu/searchbox/vip/models/VipUserInfo;", "getAccountVipStatus", "", "getLoginState", "", "isSupportGuest", "init", "", "needRefreshVipInfo", "saveToSP", "syncVipInfo", "callback", "Lkotlin/Function3;", "Lkotlin/ParameterName;", "name", "isSucceed", "isInfoChanged", "errorCode", "lib-vip_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VipUserInfoManager.kt */
public final class VipUserInfoManager {
    public static final VipUserInfoManager INSTANCE;
    private static final IAccountStatusChangedListener accountListener = new VipUserInfoManager$$ExternalSyntheticLambda0();
    /* access modifiers changed from: private */
    public static volatile VipUserInfo vipUserInfo;

    private VipUserInfoManager() {
    }

    public final VipUserInfo getVipUserInfo() {
        return vipUserInfo;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x003a A[Catch:{ Exception -> 0x005a }] */
    static {
        /*
            com.baidu.searchbox.vip.VipUserInfoManager r0 = new com.baidu.searchbox.vip.VipUserInfoManager
            r0.<init>()
            INSTANCE = r0
            com.baidu.searchbox.vip.VipUserInfoManager$$ExternalSyntheticLambda0 r1 = new com.baidu.searchbox.vip.VipUserInfoManager$$ExternalSyntheticLambda0
            r1.<init>()
            accountListener = r1
            r1 = 0
            r2 = 0
            r3 = 1
            boolean r0 = getLoginState$default(r0, r2, r3, r1)     // Catch:{ Exception -> 0x005a }
            if (r0 == 0) goto L_0x0064
            com.baidu.searchbox.vip.utils.VipKVUtils r0 = com.baidu.searchbox.vip.utils.VipKVUtils.INSTANCE     // Catch:{ Exception -> 0x005a }
            com.baidu.android.util.UniKV r0 = r0.getKvInstance()     // Catch:{ Exception -> 0x005a }
            java.lang.String r4 = "cached_vip_info"
            java.lang.String r0 = r0.getString(r4, r1)     // Catch:{ Exception -> 0x005a }
            if (r0 == 0) goto L_0x0037
            r4 = r0
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ Exception -> 0x005a }
            int r4 = r4.length()     // Catch:{ Exception -> 0x005a }
            if (r4 <= 0) goto L_0x0032
            r4 = r3
            goto L_0x0033
        L_0x0032:
            r4 = r2
        L_0x0033:
            if (r4 != r3) goto L_0x0037
            r4 = r3
            goto L_0x0038
        L_0x0037:
            r4 = r2
        L_0x0038:
            if (r4 == 0) goto L_0x0064
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x005a }
            r4.<init>(r0)     // Catch:{ Exception -> 0x005a }
            r5 = 0
            com.baidu.searchbox.vip.models.VipUserInfo r6 = new com.baidu.searchbox.vip.models.VipUserInfo     // Catch:{ Exception -> 0x005a }
            org.json.JSONObject r7 = new org.json.JSONObject     // Catch:{ Exception -> 0x005a }
            java.lang.String r8 = "vip_info"
            java.lang.String r8 = r4.optString(r8)     // Catch:{ Exception -> 0x005a }
            r7.<init>(r8)     // Catch:{ Exception -> 0x005a }
            r6.<init>(r7)     // Catch:{ Exception -> 0x005a }
            vipUserInfo = r6     // Catch:{ Exception -> 0x005a }
            r4 = 3
            syncVipInfo$default(r1, r2, r4, r1)     // Catch:{ Exception -> 0x005a }
            goto L_0x0064
        L_0x005a:
            r0 = move-exception
            boolean r1 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r1 == 0) goto L_0x0064
            r0.printStackTrace()
        L_0x0064:
            com.baidu.searchbox.account.BoxAccountManager r0 = com.baidu.searchbox.vip.utils.VipAccountUtilsKt.getBoxAccountManager()
            if (r0 == 0) goto L_0x006f
            com.baidu.searchbox.account.IAccountStatusChangedListener r1 = accountListener
            r0.addLoginStatusChangedListener(r1)
        L_0x006f:
            com.baidu.searchbox.bdeventbus.BdEventBus$Companion r0 = com.baidu.searchbox.bdeventbus.BdEventBus.Companion
            com.baidu.searchbox.bdeventbus.BdEventBus r0 = r0.getDefault()
            com.baidu.searchbox.vip.VipUserInfoManager r1 = INSTANCE
            java.lang.Class<com.baidu.searchbox.account.event.UserInfoChangeEvent> r2 = com.baidu.searchbox.account.event.UserInfoChangeEvent.class
            com.baidu.searchbox.vip.VipUserInfoManager$$ExternalSyntheticLambda1 r4 = new com.baidu.searchbox.vip.VipUserInfoManager$$ExternalSyntheticLambda1
            r4.<init>()
            r0.register(r1, r2, r3, r4)
            com.baidu.searchbox.bdeventbus.BdEventBus$Companion r0 = com.baidu.searchbox.bdeventbus.BdEventBus.Companion
            com.baidu.searchbox.bdeventbus.BdEventBus r0 = r0.getDefault()
            java.lang.Class<com.baidu.searchbox.vip.VipUserInfoNeedSyncEvent> r2 = com.baidu.searchbox.vip.VipUserInfoNeedSyncEvent.class
            com.baidu.searchbox.vip.VipUserInfoManager$$ExternalSyntheticLambda2 r4 = new com.baidu.searchbox.vip.VipUserInfoManager$$ExternalSyntheticLambda2
            r4.<init>()
            r0.register(r1, r2, r3, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.vip.VipUserInfoManager.<clinit>():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: accountListener$lambda-0  reason: not valid java name */
    public static final void m7369accountListener$lambda0(boolean z, boolean z2) {
        if (!getLoginState$default(INSTANCE, false, 1, (Object) null)) {
            VipKVUtils.INSTANCE.getKvInstance().putString("cached_vip_info", "");
            vipUserInfo = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-2  reason: not valid java name */
    public static final void m7367_init_$lambda2(UserInfoChangeEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        if (INSTANCE.needRefreshVipInfo()) {
            syncVipInfo$default((Function3) null, false, 3, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-3  reason: not valid java name */
    public static final void m7368_init_$lambda3(VipUserInfoNeedSyncEvent it) {
        Intrinsics.checkNotNullParameter(it, "it");
        syncVipInfo$default((Function3) null, false, 3, (Object) null);
    }

    static /* synthetic */ boolean getLoginState$default(VipUserInfoManager vipUserInfoManager, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return vipUserInfoManager.getLoginState(z);
    }

    /* access modifiers changed from: private */
    public final boolean getLoginState(boolean isSupportGuest) {
        BoxAccountManager boxAccountManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        if (isSupportGuest) {
            return boxAccountManager.isLogin(0);
        }
        return boxAccountManager.isLogin(2);
    }

    public static /* synthetic */ void syncVipInfo$default(Function3 function3, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            function3 = null;
        }
        if ((i2 & 2) != 0) {
            z = false;
        }
        syncVipInfo(function3, z);
    }

    @JvmStatic
    public static final synchronized void syncVipInfo(Function3<? super Boolean, ? super Boolean, ? super Integer, Unit> callback, boolean isSupportGuest) {
        synchronized (VipUserInfoManager.class) {
            if (!INSTANCE.getLoginState(isSupportGuest)) {
                VipKVUtils.INSTANCE.getKvInstance().putString("cached_vip_info", "");
                vipUserInfo = null;
                if (callback != null) {
                    callback.invoke(false, true, -998);
                }
                BdEventBus.Companion.getDefault().post(new VipUserInfoChangedEvent(true, false, 2, (DefaultConstructorMarker) null));
                return;
            }
            VipServicesKt.reqVipInfo(new VipUserInfoManager$syncVipInfo$1(isSupportGuest, callback), new VipUserInfoManager$syncVipInfo$2(callback));
        }
    }

    /* access modifiers changed from: private */
    @JvmStatic
    public static final void saveToSP() {
        JSONObject data = new JSONObject();
        JSONObject $this$saveToSP_u24lambda_u2d4 = data;
        VipUserInfo vipUserInfo2 = vipUserInfo;
        $this$saveToSP_u24lambda_u2d4.put("vip_info", vipUserInfo2 != null ? vipUserInfo2.toJsonObject() : null);
        VipKVUtils.INSTANCE.getKvInstance().putString("cached_vip_info", data.toString());
    }

    @StableApi
    public final void init() {
    }

    private final boolean needRefreshVipInfo() {
        Boolean isNeedRefreshVipInfo;
        if (vipUserInfo == null) {
            return true;
        }
        VipUserInfo vipUserInfo2 = vipUserInfo;
        if (vipUserInfo2 != null) {
            String uid = VipAccountUtilsKt.getUid();
            if (uid == null) {
                uid = "";
            }
            isNeedRefreshVipInfo = Boolean.valueOf(vipUserInfo2.isChangedVipStatus(uid, getAccountVipStatus()));
        } else {
            isNeedRefreshVipInfo = null;
        }
        if (Intrinsics.areEqual((Object) isNeedRefreshVipInfo, (Object) true)) {
            return true;
        }
        return false;
    }

    private final int getAccountVipStatus() {
        String memberVip = VipAccountUtilsKt.getMemberVip();
        if (Intrinsics.areEqual((Object) memberVip, (Object) "0")) {
            return 1;
        }
        if (Intrinsics.areEqual((Object) memberVip, (Object) "1")) {
            return 2;
        }
        return 3;
    }
}
