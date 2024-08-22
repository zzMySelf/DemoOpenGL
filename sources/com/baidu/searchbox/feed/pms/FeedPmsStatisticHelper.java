package com.baidu.searchbox.feed.pms;

import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.pms.bean.PackageInfo;
import com.baidu.searchbox.pms.init.PmsManager;
import com.baidu.ubc.UBCManager;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010#\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u000f\u001a\u00020\u00052\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0005J\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\r\u001a\u00020\u00052\b\u0010\u000e\u001a\u0004\u0018\u00010\u0005H\u0002J \u0010\u0013\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u0015J\u001e\u0010\u0016\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u0010\u0010\u001b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0005H\u0002J\u0016\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005R&\u0010\u0003\u001a\u001a\u0012\u0004\u0012\u00020\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u00040\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\b0\u0004X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\nX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/feed/pms/FeedPmsStatisticHelper;", "", "()V", "channelMap", "", "", "Lcom/baidu/searchbox/feed/pms/FeedPmsUbcParams;", "packageCount", "", "usageList", "", "failEvent", "", "channelId", "packageName", "errType", "errMsg", "getCurrentPackageInfo", "Lcom/baidu/searchbox/pms/bean/PackageInfo;", "notifyStateSuccess", "endState", "", "registerUbcEvent", "version", "", "resourceUsageEvent", "showReport", "successEventIfNeed", "unregisterUbcEvent", "lib-feed-apm_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedPmsStatisticHelper.kt */
public final class FeedPmsStatisticHelper {
    public static final FeedPmsStatisticHelper INSTANCE = new FeedPmsStatisticHelper();
    private static final Map<String, Map<String, FeedPmsUbcParams>> channelMap = new ConcurrentHashMap();
    private static Map<String, Integer> packageCount = new ConcurrentHashMap();
    private static final Set<String> usageList = new HashSet();

    private FeedPmsStatisticHelper() {
    }

    public final void unregisterUbcEvent(String channelId, String packageName) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Map packageMap = channelMap.get(channelId);
        if (packageMap != null) {
            packageMap.remove(packageName);
            Integer num = packageCount.get(channelId);
            if (num != null) {
                packageCount.put(channelId, Integer.valueOf(num.intValue() - 1));
            }
            successEventIfNeed(channelId);
        }
    }

    public final void registerUbcEvent(String channelId, String packageName, long version) {
        String str = channelId;
        String str2 = packageName;
        Intrinsics.checkNotNullParameter(str, "channelId");
        Intrinsics.checkNotNullParameter(str2, "packageName");
        Map<String, Map<String, FeedPmsUbcParams>> map = channelMap;
        if (!map.containsKey(str)) {
            map.put(str, new ConcurrentHashMap());
        }
        if (!packageCount.containsKey(str)) {
            packageCount.put(str, 0);
        }
        Map map2 = map.get(str);
        if (map2 != null) {
            Map packageMap = map2;
            if (!packageMap.containsKey(str2)) {
                Integer num = packageCount.get(str);
                if (num != null) {
                    packageCount.put(str, Integer.valueOf(num.intValue() + 1));
                }
                packageMap.put(str2, new FeedPmsUbcParams(channelId, version, (JSONArray) null, (String) null, "online", System.currentTimeMillis(), 12, (DefaultConstructorMarker) null));
            }
        }
    }

    public static /* synthetic */ void notifyStateSuccess$default(FeedPmsStatisticHelper feedPmsStatisticHelper, String str, String str2, boolean z, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            z = false;
        }
        feedPmsStatisticHelper.notifyStateSuccess(str, str2, z);
    }

    public final void notifyStateSuccess(String channelId, String packageName, boolean endState) {
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        Map packageMap = channelMap.get(channelId);
        if (packageMap != null) {
            FeedPmsUbcParams params = (FeedPmsUbcParams) packageMap.get(packageName);
            String str = null;
            if (params != null) {
                FeedPmsUbcParams $this$notifyStateSuccess_u24lambda_u2d2 = params;
                $this$notifyStateSuccess_u24lambda_u2d2.getDuration().put(System.currentTimeMillis() - $this$notifyStateSuccess_u24lambda_u2d2.getStartTimeStamp());
            } else {
                params = null;
            }
            if (endState) {
                if (params != null) {
                    str = params.getPackageType();
                }
                if (Intrinsics.areEqual((Object) str, (Object) "online")) {
                    Integer num = packageCount.get(channelId);
                    if (num != null) {
                        packageCount.put(channelId, Integer.valueOf(num.intValue() - 1));
                    }
                    successEventIfNeed(channelId);
                }
            }
        }
    }

    private final void successEventIfNeed(String channelId) {
        UBCManager ubc;
        String str = channelId;
        Integer num = packageCount.get(str);
        if (num != null) {
            int packageCount2 = num.intValue();
            Map map = channelMap.get(str);
            if (map != null) {
                Map packageMap = map;
                if (!packageMap.isEmpty() && packageCount2 <= 0) {
                    JSONObject ubcObject = new JSONObject();
                    try {
                        Result.Companion companion = Result.Companion;
                        FeedPmsStatisticHelper feedPmsStatisticHelper = this;
                        ubcObject.put("from", "feed");
                        ubcObject.put("type", "success");
                        Result.m8971constructorimpl(ubcObject.put("source", str));
                    } catch (Throwable th2) {
                        Result.Companion companion2 = Result.Companion;
                        Result.m8971constructorimpl(ResultKt.createFailure(th2));
                    }
                    JSONObject extObject = new JSONObject();
                    try {
                        Result.Companion companion3 = Result.Companion;
                        FeedPmsStatisticHelper feedPmsStatisticHelper2 = this;
                        JSONArray packageArray = new JSONArray();
                        for (Map.Entry entry : packageMap.entrySet()) {
                            String str2 = (String) entry.getKey();
                            FeedPmsUbcParams params = (FeedPmsUbcParams) entry.getValue();
                            if (Intrinsics.areEqual((Object) params.getPackageType(), (Object) "online")) {
                                if (Intrinsics.areEqual((Object) params.getChannelId(), (Object) str)) {
                                    JSONObject packageObject = new JSONObject();
                                    JSONObject $this$successEventIfNeed_u24lambda_u2d6_u24lambda_u2d5 = packageObject;
                                    $this$successEventIfNeed_u24lambda_u2d6_u24lambda_u2d5.put(TableDefine.EmojiColumns.COLUMN_PACKAGE_ID, str2);
                                    $this$successEventIfNeed_u24lambda_u2d6_u24lambda_u2d5.put("pkg_version", String.valueOf(params.getVersion()));
                                    $this$successEventIfNeed_u24lambda_u2d6_u24lambda_u2d5.put("duration", params.getDuration());
                                    packageArray.put(packageObject);
                                }
                            }
                        }
                        packageMap.clear();
                        extObject.put("pkg_list", packageArray);
                        Result.m8971constructorimpl(ubcObject.put("ext", extObject));
                    } catch (Throwable th3) {
                        Result.Companion companion4 = Result.Companion;
                        Result.m8971constructorimpl(ResultKt.createFailure(th3));
                    }
                    if (showReport() && (ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
                        ubc.onEvent("6585", ubcObject);
                    }
                }
            }
        }
    }

    public static /* synthetic */ void failEvent$default(FeedPmsStatisticHelper feedPmsStatisticHelper, String str, String str2, String str3, String str4, int i2, Object obj) {
        if ((i2 & 8) != 0) {
            str4 = null;
        }
        feedPmsStatisticHelper.failEvent(str, str2, str3, str4);
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x00fc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void failEvent(java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            r16 = this;
            r1 = r17
            r2 = r18
            r3 = r19
            java.lang.String r0 = "channelId"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r1, r0)
            java.lang.String r0 = "packageName"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r2, r0)
            java.lang.String r0 = "errType"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            java.util.Map<java.lang.String, java.lang.Integer> r0 = packageCount
            java.lang.Object r0 = r0.get(r1)
            java.lang.Integer r0 = (java.lang.Integer) r0
            if (r0 == 0) goto L_0x0034
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            r4 = 0
            java.util.Map<java.lang.String, java.lang.Integer> r5 = packageCount
            int r6 = r0 + -1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r5.put(r1, r6)
        L_0x0034:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r4 = r0
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x005b }
            r0 = r16
            com.baidu.searchbox.feed.pms.FeedPmsStatisticHelper r0 = (com.baidu.searchbox.feed.pms.FeedPmsStatisticHelper) r0     // Catch:{ all -> 0x005b }
            r5 = 0
            java.lang.String r6 = "from"
            java.lang.String r7 = "feed"
            r4.put(r6, r7)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = "type"
            java.lang.String r7 = "fail"
            r4.put(r6, r7)     // Catch:{ all -> 0x005b }
            java.lang.String r6 = "source"
            org.json.JSONObject r6 = r4.put(r6, r1)     // Catch:{ all -> 0x005b }
            kotlin.Result.m8971constructorimpl(r6)     // Catch:{ all -> 0x005b }
            goto L_0x0065
        L_0x005b:
            r0 = move-exception
            kotlin.Result$Companion r5 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x0065:
            org.json.JSONObject r0 = new org.json.JSONObject
            r0.<init>()
            r5 = r0
            org.json.JSONArray r0 = new org.json.JSONArray
            r0.<init>()
            r6 = r0
            java.util.Map<java.lang.String, java.util.Map<java.lang.String, com.baidu.searchbox.feed.pms.FeedPmsUbcParams>> r0 = channelMap
            java.lang.Object r0 = r0.get(r1)
            java.util.Map r0 = (java.util.Map) r0
            if (r0 != 0) goto L_0x007c
            return
        L_0x007c:
            r7 = r0
            java.lang.Object r0 = r7.get(r2)
            r8 = r0
            com.baidu.searchbox.feed.pms.FeedPmsUbcParams r8 = (com.baidu.searchbox.feed.pms.FeedPmsUbcParams) r8
            if (r8 == 0) goto L_0x0105
            java.lang.String r0 = r8.getPackageType()
            java.lang.String r9 = "local"
            boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r0, (java.lang.Object) r9)
            if (r0 == 0) goto L_0x0095
            r14 = r20
            goto L_0x0107
        L_0x0095:
            r7.remove(r2)
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x00e6 }
            r0 = r16
            com.baidu.searchbox.feed.pms.FeedPmsStatisticHelper r0 = (com.baidu.searchbox.feed.pms.FeedPmsStatisticHelper) r0     // Catch:{ all -> 0x00e6 }
            r9 = 0
            org.json.JSONObject r10 = new org.json.JSONObject     // Catch:{ all -> 0x00e6 }
            r10.<init>()     // Catch:{ all -> 0x00e6 }
            r11 = r10
            r12 = 0
            java.lang.String r13 = "package_id"
            r11.put(r13, r2)     // Catch:{ all -> 0x00e6 }
            java.lang.String r13 = "pkg_version"
            long r14 = r8.getVersion()     // Catch:{ all -> 0x00e6 }
            java.lang.String r14 = java.lang.String.valueOf(r14)     // Catch:{ all -> 0x00e6 }
            r11.put(r13, r14)     // Catch:{ all -> 0x00e6 }
            java.lang.String r13 = "duration"
            org.json.JSONArray r14 = r8.getDuration()     // Catch:{ all -> 0x00e6 }
            r11.put(r13, r14)     // Catch:{ all -> 0x00e6 }
            java.lang.String r13 = "error_type"
            r11.put(r13, r3)     // Catch:{ all -> 0x00e6 }
            java.lang.String r13 = "error_msg"
            r14 = r20
            r11.put(r13, r14)     // Catch:{ all -> 0x00e4 }
            r6.put(r10)     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = "pkg_list"
            r5.put(r11, r6)     // Catch:{ all -> 0x00e4 }
            java.lang.String r11 = "ext"
            org.json.JSONObject r11 = r4.put(r11, r5)     // Catch:{ all -> 0x00e4 }
            kotlin.Result.m8971constructorimpl(r11)     // Catch:{ all -> 0x00e4 }
            goto L_0x00f2
        L_0x00e4:
            r0 = move-exception
            goto L_0x00e9
        L_0x00e6:
            r0 = move-exception
            r14 = r20
        L_0x00e9:
            kotlin.Result$Companion r9 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            kotlin.Result.m8971constructorimpl(r0)
        L_0x00f2:
            com.baidu.pyramid.runtime.service.ServiceReference r0 = com.baidu.ubc.UBCManager.SERVICE_REFERENCE
            java.lang.Object r0 = com.baidu.pyramid.runtime.service.ServiceManager.getService(r0)
            com.baidu.ubc.UBCManager r0 = (com.baidu.ubc.UBCManager) r0
            if (r0 == 0) goto L_0x0101
            java.lang.String r9 = "6585"
            r0.onEvent((java.lang.String) r9, (org.json.JSONObject) r4)
        L_0x0101:
            r16.successEventIfNeed(r17)
            return
        L_0x0105:
            r14 = r20
        L_0x0107:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.pms.FeedPmsStatisticHelper.failEvent(java.lang.String, java.lang.String, java.lang.String, java.lang.String):void");
    }

    @JvmStatic
    public static final void resourceUsageEvent(String channelId, String packageName) {
        String str;
        Intrinsics.checkNotNullParameter(channelId, "channelId");
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        String usageId = channelId + packageName;
        Set<String> set = usageList;
        if (!set.contains(usageId)) {
            set.add(usageId);
            JSONObject ubcObject = new JSONObject();
            FeedPmsStatisticHelper feedPmsStatisticHelper = INSTANCE;
            try {
                Result.Companion companion = Result.Companion;
                ubcObject.put("from", "feed");
                ubcObject.put("type", "resource_usage");
                Result.m8971constructorimpl(ubcObject.put("source", channelId));
            } catch (Throwable th2) {
                Result.Companion companion2 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th2));
            }
            JSONObject extObject = new JSONObject();
            JSONArray packageArray = new JSONArray();
            FeedPmsStatisticHelper $this$resourceUsageEvent_u24lambda_u2d13 = INSTANCE;
            try {
                Result.Companion companion3 = Result.Companion;
                JSONObject packageObject = new JSONObject();
                JSONObject $this$resourceUsageEvent_u24lambda_u2d13_u24lambda_u2d12 = packageObject;
                $this$resourceUsageEvent_u24lambda_u2d13_u24lambda_u2d12.put(TableDefine.EmojiColumns.COLUMN_PACKAGE_ID, packageName);
                PackageInfo currentPackageInfo = $this$resourceUsageEvent_u24lambda_u2d13.getCurrentPackageInfo(channelId, packageName);
                if (currentPackageInfo == null || (str = Long.valueOf(currentPackageInfo.version).toString()) == null) {
                    str = "-1";
                }
                $this$resourceUsageEvent_u24lambda_u2d13_u24lambda_u2d12.put("pkg_version", str);
                packageArray.put(packageObject);
                extObject.put("pkg_list", packageArray);
                Result.m8971constructorimpl(ubcObject.put("ext", extObject));
            } catch (Throwable th3) {
                Result.Companion companion4 = Result.Companion;
                Result.m8971constructorimpl(ResultKt.createFailure(th3));
            }
        }
    }

    private final PackageInfo getCurrentPackageInfo(String channelId, String packageName) {
        Map map;
        if (packageName == null || (map = PmsManager.getInstance().getPackageInfo(channelId, packageName)) == null) {
            return null;
        }
        return map.get(packageName);
    }

    private final boolean showReport() {
        return AppConfig.isDebug() || new Random().nextInt(100) == 1;
    }
}
