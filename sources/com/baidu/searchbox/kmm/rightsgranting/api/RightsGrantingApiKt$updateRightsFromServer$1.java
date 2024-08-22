package com.baidu.searchbox.kmm.rightsgranting.api;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.network.HttpPostBodyType;
import com.baidu.searchbox.kmm.foundation.network.HttpRequest;
import com.baidu.searchbox.kmm.foundation.network.URLComposerKt;
import com.baidu.searchbox.kmm.rightsgranting.entities.RightsModel;
import com.baidu.searchbox.kmm.rightsgranting.entities.RightsSource;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: RightsGrantingApi.kt */
final class RightsGrantingApiKt$updateRightsFromServer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Function2<String, String, Unit> $failureCB;
    final /* synthetic */ Map<String, String> $reqParams;
    final /* synthetic */ RightsSource $source;
    final /* synthetic */ Function4<List<RightsModel>, String, JsonObject, JsonObject, Unit> $successCB;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RightsGrantingApiKt$updateRightsFromServer$1(RightsSource rightsSource, Map<String, String> map, Function2<? super String, ? super String, Unit> function2, Function4<? super List<RightsModel>, ? super String, ? super JsonObject, ? super JsonObject, Unit> function4) {
        super(0);
        this.$source = rightsSource;
        this.$reqParams = map;
        this.$failureCB = function2;
        this.$successCB = function4;
    }

    public final void invoke() {
        String makeFullURL = URLComposerKt.makeFullURL(RightsGrantingApiKt.getUpdateRightsUrl(this.$source));
        Map<String, String> map = this.$reqParams;
        final Function2<String, String, Unit> function2 = this.$failureCB;
        final Function4<List<RightsModel>, String, JsonObject, JsonObject, Unit> function4 = this.$successCB;
        final Function2<String, String, Unit> function22 = this.$failureCB;
        HttpRequest.doPOST$default(makeFullURL, map, (HttpPostBodyType) null, false, (Integer) null, (Integer) null, new Function1<String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1) {
                invoke((String) p1);
                return Unit.INSTANCE;
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r11v1, resolved type: com.baidu.searchbox.kmm.foundation.kelson.JsonElement} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: com.baidu.searchbox.kmm.foundation.kelson.JsonArray} */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:69:0x018f  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(java.lang.String r31) {
                /*
                    r30 = this;
                    r1 = r30
                    r2 = 0
                    kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0019 }
                    r0 = 0
                    if (r31 == 0) goto L_0x000d
                    com.baidu.searchbox.kmm.foundation.kelson.JsonObject r3 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.toJsonObject(r31)     // Catch:{ all -> 0x0019 }
                    goto L_0x000e
                L_0x000d:
                    r3 = r2
                L_0x000e:
                    boolean r4 = r3 instanceof com.baidu.searchbox.kmm.foundation.kelson.JsonObject     // Catch:{ all -> 0x0019 }
                    if (r4 == 0) goto L_0x0013
                    goto L_0x0014
                L_0x0013:
                    r3 = r2
                L_0x0014:
                    java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r3)     // Catch:{ all -> 0x0019 }
                    goto L_0x0024
                L_0x0019:
                    r0 = move-exception
                    kotlin.Result$Companion r3 = kotlin.Result.Companion
                    java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                    java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
                L_0x0024:
                    boolean r3 = kotlin.Result.m8977isFailureimpl(r0)
                    if (r3 == 0) goto L_0x002b
                    r0 = r2
                L_0x002b:
                    com.baidu.searchbox.kmm.foundation.kelson.JsonObject r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonObject) r0
                    r3 = r0
                    r0 = r3
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    boolean r0 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.isNull(r0)
                    java.lang.String r4 = "-600"
                    if (r0 == 0) goto L_0x0044
                    kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r0 = r3
                    if (r0 == 0) goto L_0x0043
                    java.lang.String r2 = "jsonObj is empty"
                    r0.invoke(r4, r2)
                L_0x0043:
                    return
                L_0x0044:
                    r0 = r3
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    r5 = 0
                    java.lang.String r6 = "errno"
                    r7 = 2
                    int r5 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getInt$default(r0, r6, r5, r7, r2)
                    if (r5 == 0) goto L_0x0066
                    kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r0 = r3
                    if (r0 == 0) goto L_0x0065
                    java.lang.String r4 = java.lang.String.valueOf(r5)
                    r6 = r3
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r6 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r6
                    java.lang.String r8 = "errmsg"
                    java.lang.String r2 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString$default(r6, r8, r2, r7, r2)
                    r0.invoke(r4, r2)
                L_0x0065:
                    return
                L_0x0066:
                    r0 = r3
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    java.lang.String r6 = "data"
                    com.baidu.searchbox.kmm.foundation.kelson.JsonObject r6 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getJsonObject((com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0, (java.lang.String) r6)
                    r0 = r6
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    boolean r0 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.isNull(r0)
                    java.lang.String r7 = "业务逻辑错误"
                    if (r0 == 0) goto L_0x0083
                    kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r0 = r3
                    if (r0 == 0) goto L_0x0082
                    r0.invoke(r4, r7)
                L_0x0082:
                    return
                L_0x0083:
                    r0 = r6
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    java.lang.String r8 = "rightsList"
                    com.baidu.searchbox.kmm.foundation.kelson.JsonArray r8 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getJsonArray((com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0, (java.lang.String) r8)
                    r0 = r8
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    boolean r0 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.isNull(r0)
                    if (r0 == 0) goto L_0x009e
                    kotlin.jvm.functions.Function2<java.lang.String, java.lang.String, kotlin.Unit> r0 = r3
                    if (r0 == 0) goto L_0x009d
                    r0.invoke(r4, r7)
                L_0x009d:
                    return
                L_0x009e:
                    r0 = r6
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    java.lang.String r4 = "signal"
                    com.baidu.searchbox.kmm.foundation.kelson.JsonObject r0 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getJsonObject((com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0, (java.lang.String) r4)
                    if (r0 == 0) goto L_0x00bc
                    r4 = r0
                    r7 = 0
                    long r9 = com.baidu.searchbox.kmm.foundation.utils.datetime.TimeUtils.getCurrentTimeStamp()
                    java.lang.Long r9 = java.lang.Long.valueOf(r9)
                    java.lang.String r10 = "time"
                    r4.put(r10, r9)
                    goto L_0x00bd
                L_0x00bc:
                    r0 = r2
                L_0x00bd:
                    r4 = r0
                    r0 = r6
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    java.lang.String r7 = "userType"
                    java.lang.String r9 = ""
                    java.lang.String r7 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getString(r0, r7, r9)
                    r0 = r6
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r0 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0
                    java.lang.String r9 = "userKeep"
                    com.baidu.searchbox.kmm.foundation.kelson.JsonObject r9 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getJsonObject((com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r0, (java.lang.String) r9)
                    kotlin.jvm.functions.Function4<java.util.List<com.baidu.searchbox.kmm.rightsgranting.entities.RightsModel>, java.lang.String, com.baidu.searchbox.kmm.foundation.kelson.JsonObject, com.baidu.searchbox.kmm.foundation.kelson.JsonObject, kotlin.Unit> r10 = r4
                    r11 = r8
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r11 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r11
                    java.lang.String r12 = "list"
                    r13 = 0
                    boolean r0 = r11 instanceof com.baidu.searchbox.kmm.foundation.kelson.JsonArray
                    if (r0 == 0) goto L_0x00e7
                    r2 = r11
                    com.baidu.searchbox.kmm.foundation.kelson.JsonArray r2 = (com.baidu.searchbox.kmm.foundation.kelson.JsonArray) r2
                    goto L_0x00f1
                L_0x00e7:
                    boolean r0 = r11 instanceof com.baidu.searchbox.kmm.foundation.kelson.JsonObject
                    if (r0 == 0) goto L_0x00f0
                    com.baidu.searchbox.kmm.foundation.kelson.JsonArray r2 = com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt.getJsonArray((com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r11, (java.lang.String) r12)
                    goto L_0x00f1
                L_0x00f0:
                L_0x00f1:
                    if (r2 != 0) goto L_0x0100
                    java.util.List r0 = kotlin.collections.CollectionsKt.emptyList()
                    r24 = r3
                    r26 = r5
                    r29 = r6
                    goto L_0x0194
                L_0x0100:
                    java.util.ArrayList r0 = new java.util.ArrayList
                    r0.<init>()
                    r14 = r0
                    java.util.List r14 = (java.util.List) r14
                    r15 = r14
                    r16 = 0
                    kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x0176 }
                    r0 = r15
                    r17 = 0
                    r18 = r2
                    java.lang.Iterable r18 = (java.lang.Iterable) r18     // Catch:{ all -> 0x0176 }
                    r19 = 0
                    java.util.Iterator r20 = r18.iterator()     // Catch:{ all -> 0x0176 }
                L_0x011b:
                    boolean r21 = r20.hasNext()     // Catch:{ all -> 0x0176 }
                    if (r21 == 0) goto L_0x0164
                    java.lang.Object r21 = r20.next()     // Catch:{ all -> 0x0176 }
                    r22 = r21
                    com.baidu.searchbox.kmm.foundation.kelson.JsonElement r22 = (com.baidu.searchbox.kmm.foundation.kelson.JsonElement) r22     // Catch:{ all -> 0x0176 }
                    r23 = 0
                    r24 = r22
                    r25 = 0
                    com.baidu.searchbox.kmm.rightsgranting.entities.RightsModel r1 = new com.baidu.searchbox.kmm.rightsgranting.entities.RightsModel     // Catch:{ all -> 0x0176 }
                    r1.<init>()     // Catch:{ all -> 0x0176 }
                    r26 = r1
                    r27 = 0
                    r28 = r2
                    r2 = r24
                    r24 = r3
                    r3 = r26
                    r3.decode(r2)     // Catch:{ all -> 0x015e }
                    r26 = r5
                    r29 = r6
                    long r5 = com.baidu.searchbox.kmm.foundation.utils.datetime.TimeUtils.getCurrentTimeStamp()     // Catch:{ all -> 0x0174 }
                    r3.setTime$com_baidu_searchbox_kmm_business_rightsgranting(r5)     // Catch:{ all -> 0x0174 }
                    r0.add(r1)     // Catch:{ all -> 0x0174 }
                    r1 = r30
                    r3 = r24
                    r5 = r26
                    r2 = r28
                    r6 = r29
                    goto L_0x011b
                L_0x015e:
                    r0 = move-exception
                    r26 = r5
                    r29 = r6
                    goto L_0x017f
                L_0x0164:
                    r28 = r2
                    r24 = r3
                    r26 = r5
                    r29 = r6
                    kotlin.Unit r0 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0174 }
                    java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)     // Catch:{ all -> 0x0174 }
                    goto L_0x0189
                L_0x0174:
                    r0 = move-exception
                    goto L_0x017f
                L_0x0176:
                    r0 = move-exception
                    r28 = r2
                    r24 = r3
                    r26 = r5
                    r29 = r6
                L_0x017f:
                    kotlin.Result$Companion r1 = kotlin.Result.Companion
                    java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
                    java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
                L_0x0189:
                    java.lang.Throwable r0 = kotlin.Result.m8974exceptionOrNullimpl(r0)
                    if (r0 == 0) goto L_0x0192
                    r0.printStackTrace()
                L_0x0192:
                    r0 = r14
                L_0x0194:
                    r10.invoke(r0, r7, r4, r9)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.kmm.rightsgranting.api.RightsGrantingApiKt$updateRightsFromServer$1.AnonymousClass1.invoke(java.lang.String):void");
            }
        }, new Function2<Integer, String, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
                invoke(((Number) p1).intValue(), (String) p2);
                return Unit.INSTANCE;
            }

            public final void invoke(int code, String msg) {
                Function2<String, String, Unit> function2 = function22;
                if (function2 != null) {
                    function2.invoke(String.valueOf(code), msg == null ? "" : msg);
                }
            }
        }, (Function2) null, 0.0f, 0.0d, 1852, (Object) null);
    }
}
