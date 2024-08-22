package com.baidu.searchbox.search.lego.tplview;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\n¢\u0006\u0002\b\u0006"}, d2 = {"<anonymous>", "", "dataStr", "", "code", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: WiseBrandTipView.kt */
final class WiseBrandTipView$requestBzData$1 extends Lambda implements Function2<String, Integer, Unit> {
    final /* synthetic */ Function0<Unit> $block;
    final /* synthetic */ Ref.ObjectRef<String> $uid;
    final /* synthetic */ WiseBrandTipView this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    WiseBrandTipView$requestBzData$1(WiseBrandTipView wiseBrandTipView, Ref.ObjectRef<String> objectRef, Function0<Unit> function0) {
        super(2);
        this.this$0 = wiseBrandTipView;
        this.$uid = objectRef;
        this.$block = function0;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2) {
        invoke((String) p1, ((Number) p2).intValue());
        return Unit.INSTANCE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x007d, code lost:
        r4 = (r4 = r3.optJSONObject((java.lang.String) r6.$uid.element)).optJSONObject("1");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke(java.lang.String r7, int r8) {
        /*
            r6 = this;
            java.lang.String r0 = "data"
            java.lang.String r1 = "{}"
            com.baidu.searchbox.search.lego.tplview.WiseBrandTipView r2 = r6.this$0
            boolean r2 = r2.DEBUG
            if (r2 == 0) goto L_0x0057
            com.baidu.searchbox.search.lego.tplview.WiseBrandTipView r2 = r6.this$0
            java.lang.String r2 = r2.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestBzData uid: "
            java.lang.StringBuilder r3 = r3.append(r4)
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r4 = r6.$uid
            T r4 = r4.element
            java.lang.String r4 = (java.lang.String) r4
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r2, r3)
            com.baidu.searchbox.search.lego.tplview.WiseBrandTipView r2 = r6.this$0
            java.lang.String r2 = r2.TAG
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "requestBzData dataStr: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r7)
            java.lang.String r4 = " ,code: "
            java.lang.StringBuilder r3 = r3.append(r4)
            java.lang.StringBuilder r3 = r3.append(r8)
            java.lang.String r3 = r3.toString()
            android.util.Log.d(r2, r3)
        L_0x0057:
            if (r8 <= 0) goto L_0x00cd
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a7 }
            r2.<init>(r7)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r3 = "result"
            java.lang.String r2 = r2.optString(r3, r1)     // Catch:{ Exception -> 0x00a7 }
            org.json.JSONObject r3 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a7 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x00a7 }
            org.json.JSONObject r3 = r3.optJSONObject(r0)     // Catch:{ Exception -> 0x00a7 }
            if (r3 == 0) goto L_0x008a
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r4 = r6.$uid     // Catch:{ Exception -> 0x00a7 }
            T r4 = r4.element     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r4 = (java.lang.String) r4     // Catch:{ Exception -> 0x00a7 }
            org.json.JSONObject r4 = r3.optJSONObject(r4)     // Catch:{ Exception -> 0x00a7 }
            if (r4 == 0) goto L_0x008a
            java.lang.String r5 = "1"
            org.json.JSONObject r4 = r4.optJSONObject(r5)     // Catch:{ Exception -> 0x00a7 }
            if (r4 == 0) goto L_0x008a
            java.lang.String r0 = r4.optString(r0, r1)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x008b
        L_0x008a:
            r0 = 0
        L_0x008b:
            com.baidu.searchbox.search.lego.tplview.WiseBrandTipView r1 = r6.this$0     // Catch:{ Exception -> 0x00a7 }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ Exception -> 0x00a7 }
            r4.<init>(r0)     // Catch:{ Exception -> 0x00a7 }
            r1.bzDataObj = r4     // Catch:{ Exception -> 0x00a7 }
            com.baidu.searchbox.search.lego.tplview.WiseBrandTipView r1 = r6.this$0     // Catch:{ Exception -> 0x00a7 }
            org.json.JSONObject r1 = r1.bzDataObj     // Catch:{ Exception -> 0x00a7 }
            if (r1 == 0) goto L_0x00a6
            kotlin.jvm.functions.Function0<kotlin.Unit> r4 = r6.$block     // Catch:{ Exception -> 0x00a7 }
            r5 = 0
            if (r4 == 0) goto L_0x00a5
            r4.invoke()     // Catch:{ Exception -> 0x00a7 }
        L_0x00a5:
            goto L_0x00cd
        L_0x00a6:
            goto L_0x00cd
        L_0x00a7:
            r0 = move-exception
            com.baidu.searchbox.search.lego.tplview.WiseBrandTipView r1 = r6.this$0
            boolean r1 = r1.DEBUG
            if (r1 == 0) goto L_0x00cd
            com.baidu.searchbox.search.lego.tplview.WiseBrandTipView r1 = r6.this$0
            java.lang.String r1 = r1.TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "requestBzData Exception: "
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.StringBuilder r2 = r2.append(r0)
            java.lang.String r2 = r2.toString()
            android.util.Log.d(r1, r2)
        L_0x00cd:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.lego.tplview.WiseBrandTipView$requestBzData$1.invoke(java.lang.String, int):void");
    }
}
