package com.baidu.searchbox.inputbox.utils;

import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData;
import java.util.Collection;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0004H\u0007J\u0014\u0010\u0013\u001a\u0004\u0018\u00010\n2\b\u0010\u0014\u001a\u0004\u0018\u00010\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u001d\u0010\t\u001a\u0004\u0018\u00010\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/inputbox/utils/LandingPageSearchBoxTagHelper;", "", "()V", "AB_KEY_LANDING_PAGE_SEARCH_BOX_TAG", "", "DEBUG", "", "TAG_STYLE_TAG", "TAG_STYLE_TEXT", "landingPageSearchBoxTagConfig", "Lcom/baidu/searchbox/inputbox/utils/LandingPageSearchBoxTagConfigData;", "getLandingPageSearchBoxTagConfig", "()Lcom/baidu/searchbox/inputbox/utils/LandingPageSearchBoxTagConfigData;", "landingPageSearchBoxTagConfig$delegate", "Lkotlin/Lazy;", "getTagStyle", "Lcom/baidu/searchbox/inputbox/utils/LandingPageSearchBoxTagConfigData$Style;", "channel", "sa", "parseConfig", "json", "lib-home-search_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LandingPageSearchBoxTagHelper.kt */
public final class LandingPageSearchBoxTagHelper {
    private static final String AB_KEY_LANDING_PAGE_SEARCH_BOX_TAG = "search_landing_searchbox_tag_config_json_str_and";
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    public static final LandingPageSearchBoxTagHelper INSTANCE = new LandingPageSearchBoxTagHelper();
    public static final String TAG_STYLE_TAG = "tag";
    public static final String TAG_STYLE_TEXT = "text";
    private static final Lazy landingPageSearchBoxTagConfig$delegate = LazyKt.lazy(LandingPageSearchBoxTagHelper$landingPageSearchBoxTagConfig$2.INSTANCE);

    private LandingPageSearchBoxTagHelper() {
    }

    private final LandingPageSearchBoxTagConfigData getLandingPageSearchBoxTagConfig() {
        return (LandingPageSearchBoxTagConfigData) landingPageSearchBoxTagConfig$delegate.getValue();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:100:0x0243  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x004c A[Catch:{ all -> 0x022f }] */
    /* JADX WARNING: Removed duplicated region for block: B:91:0x021a A[Catch:{ all -> 0x0207, all -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x0241  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData parseConfig(java.lang.String r42) {
        /*
            r41 = this;
            r1 = r42
            java.lang.String r0 = "text"
            java.lang.String r2 = ""
            r3 = r1
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
            if (r3 == 0) goto L_0x0015
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r3 = 0
            goto L_0x0016
        L_0x0015:
            r3 = 1
        L_0x0016:
            r6 = 0
            if (r3 == 0) goto L_0x001a
            return r6
        L_0x001a:
            kotlin.Result$Companion r3 = kotlin.Result.Companion     // Catch:{ all -> 0x022f }
            r3 = r41
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagHelper r3 = (com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagHelper) r3     // Catch:{ all -> 0x022f }
            r7 = 0
            org.json.JSONObject r8 = new org.json.JSONObject     // Catch:{ all -> 0x022f }
            r8.<init>(r1)     // Catch:{ all -> 0x022f }
            java.lang.String r9 = "tagged_channels"
            org.json.JSONArray r9 = r8.optJSONArray(r9)     // Catch:{ all -> 0x022f }
            if (r9 == 0) goto L_0x0042
            java.lang.String r10 = "optJSONArray(\"tagged_channels\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r9, r10)     // Catch:{ all -> 0x022f }
            java.util.List r9 = com.baidu.searchbox.nacomp.extension.util.JSONExtKt.mapStringNotNull(r9)     // Catch:{ all -> 0x022f }
            if (r9 == 0) goto L_0x0042
            java.lang.Iterable r9 = (java.lang.Iterable) r9     // Catch:{ all -> 0x022f }
            java.util.Set r9 = kotlin.collections.CollectionsKt.toSet(r9)     // Catch:{ all -> 0x022f }
            goto L_0x0043
        L_0x0042:
            r9 = r6
        L_0x0043:
            java.lang.String r10 = "type_mapping"
            org.json.JSONArray r10 = r8.optJSONArray(r10)     // Catch:{ all -> 0x022f }
            if (r10 == 0) goto L_0x021a
            java.lang.String r11 = "optJSONArray(\"type_mapping\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r10, r11)     // Catch:{ all -> 0x022f }
            r11 = 0
            java.util.ArrayList r12 = new java.util.ArrayList     // Catch:{ all -> 0x022f }
            r12.<init>()     // Catch:{ all -> 0x022f }
            r13 = r10
            r14 = 0
            r15 = 0
            int r5 = r13.length()     // Catch:{ all -> 0x022f }
        L_0x005f:
            if (r15 >= r5) goto L_0x020a
            org.json.JSONObject r16 = r13.optJSONObject(r15)     // Catch:{ all -> 0x022f }
            r17 = 0
            r18 = r16
            r19 = 0
            java.lang.String r4 = "name"
            r6 = r18
            java.lang.String r4 = com.baidu.searchbox.nacomp.extension.util.JSONExtKt.optStringIgnoreNulls(r6, r4, r2)     // Catch:{ all -> 0x0207 }
            if (r6 == 0) goto L_0x008c
            java.lang.String r1 = "sa_rules"
            org.json.JSONArray r1 = r6.optJSONArray(r1)     // Catch:{ all -> 0x0207 }
            if (r1 == 0) goto L_0x008c
            r18 = r3
            java.lang.String r3 = "optJSONArray(\"sa_rules\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r3)     // Catch:{ all -> 0x0207 }
            java.util.List r1 = com.baidu.searchbox.nacomp.extension.util.JSONExtKt.mapStringNotNull(r1)     // Catch:{ all -> 0x0207 }
            goto L_0x008f
        L_0x008c:
            r18 = r3
            r1 = 0
        L_0x008f:
            if (r6 == 0) goto L_0x01d3
            java.lang.String r3 = "styles"
            org.json.JSONArray r3 = r6.optJSONArray(r3)     // Catch:{ all -> 0x0207 }
            if (r3 == 0) goto L_0x01d3
            r21 = r5
            java.lang.String r5 = "optJSONArray(\"styles\")"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r3, r5)     // Catch:{ all -> 0x0207 }
            r5 = 0
            java.util.ArrayList r22 = new java.util.ArrayList     // Catch:{ all -> 0x0207 }
            r22.<init>()     // Catch:{ all -> 0x0207 }
            r23 = r22
            r22 = r3
            r24 = 0
            r25 = 0
            r26 = r3
            int r3 = r22.length()     // Catch:{ all -> 0x0207 }
            r27 = r5
            r5 = r25
        L_0x00ba:
            if (r5 >= r3) goto L_0x01bb
            r25 = r3
            r3 = r22
            org.json.JSONObject r22 = r3.optJSONObject(r5)     // Catch:{ all -> 0x0207 }
            r28 = 0
            r29 = r22
            r30 = 0
            r31 = r3
            java.lang.String r3 = "channel"
            r32 = r6
            r6 = r29
            java.lang.String r3 = com.baidu.searchbox.nacomp.extension.util.JSONExtKt.optStringIgnoreNulls(r6, r3, r2)     // Catch:{ all -> 0x0207 }
            r29 = r7
            java.lang.String r7 = "type"
            java.lang.String r7 = com.baidu.searchbox.nacomp.extension.util.JSONExtKt.optStringIgnoreNulls(r6, r7, r2)     // Catch:{ all -> 0x0207 }
            r33 = r8
            java.lang.String r8 = "tag"
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)     // Catch:{ all -> 0x0207 }
            if (r8 == 0) goto L_0x0119
            com.baidu.searchbox.hissug.data.model.HisTagDataModel r8 = new com.baidu.searchbox.hissug.data.model.HisTagDataModel     // Catch:{ all -> 0x0207 }
            r8.<init>()     // Catch:{ all -> 0x0207 }
            if (r6 == 0) goto L_0x00fb
            r34 = r10
            java.lang.String r10 = "tag_style"
            org.json.JSONObject r10 = r6.optJSONObject(r10)     // Catch:{ all -> 0x0207 }
            goto L_0x00fe
        L_0x00fb:
            r34 = r10
            r10 = 0
        L_0x00fe:
            com.baidu.searchbox.hissug.data.model.HisTagDataModel r8 = r8.toModel(r10)     // Catch:{ all -> 0x0207 }
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$Style r10 = new com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$Style     // Catch:{ all -> 0x0207 }
            r35 = r11
            r11 = 0
            r10.<init>(r3, r7, r8, r11)     // Catch:{ all -> 0x0115 }
            r36 = r0
            r37 = r2
            r38 = r6
            r2 = r10
            r10 = 0
            goto L_0x0196
        L_0x0115:
            r0 = move-exception
            r10 = r11
            goto L_0x0231
        L_0x0119:
            r34 = r10
            r35 = r11
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r0)     // Catch:{ all -> 0x0207 }
            if (r8 == 0) goto L_0x018b
            if (r6 == 0) goto L_0x012d
            java.lang.String r8 = "text_style"
            org.json.JSONObject r8 = r6.optJSONObject(r8)     // Catch:{ all -> 0x0207 }
            goto L_0x012e
        L_0x012d:
            r8 = 0
        L_0x012e:
            com.baidu.searchbox.ui.controller.landingpage.BoxTextStyle$Companion r10 = com.baidu.searchbox.ui.controller.landingpage.BoxTextStyle.Companion     // Catch:{ all -> 0x0207 }
            com.baidu.searchbox.ui.controller.landingpage.BoxTextStyle r10 = r10.fromJson(r8)     // Catch:{ all -> 0x0207 }
            java.lang.String r11 = com.baidu.searchbox.nacomp.extension.util.JSONExtKt.optStringIgnoreNulls(r8, r0, r2)     // Catch:{ all -> 0x0207 }
            r36 = r0
            java.lang.String r0 = "location"
            java.lang.String r0 = com.baidu.searchbox.nacomp.extension.util.JSONExtKt.optStringIgnoreNulls(r8, r0, r2)     // Catch:{ all -> 0x0207 }
            if (r8 == 0) goto L_0x0150
            r37 = r2
            java.lang.String r2 = "query_margin"
            r38 = r6
            r6 = 0
            int r2 = r8.optInt(r2, r6)     // Catch:{ all -> 0x0207 }
            goto L_0x0156
        L_0x0150:
            r37 = r2
            r38 = r6
            r6 = 0
            r2 = r6
        L_0x0156:
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$TextStyle r6 = new com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$TextStyle     // Catch:{ all -> 0x0207 }
            r6.<init>(r10, r11, r0, r2)     // Catch:{ all -> 0x0207 }
            r39 = r11
            java.lang.CharSequence r39 = (java.lang.CharSequence) r39     // Catch:{ all -> 0x0207 }
            int r39 = r39.length()     // Catch:{ all -> 0x0207 }
            if (r39 != 0) goto L_0x0169
            r39 = 1
            goto L_0x016b
        L_0x0169:
            r39 = 0
        L_0x016b:
            if (r39 == 0) goto L_0x017a
            r39 = r2
            r2 = 0
            r20 = r2
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$Style r20 = (com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData.Style) r20     // Catch:{ all -> 0x0176 }
            r10 = r2
            goto L_0x0196
        L_0x0176:
            r0 = move-exception
            r10 = r2
            goto L_0x0231
        L_0x017a:
            r39 = r2
            r2 = 0
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$Style r2 = new com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$Style     // Catch:{ all -> 0x0207 }
            r40 = r8
            r8 = 0
            r2.<init>(r3, r7, r8, r6)     // Catch:{ all -> 0x0187 }
            r10 = 0
            goto L_0x0196
        L_0x0187:
            r0 = move-exception
            r10 = r8
            goto L_0x0231
        L_0x018b:
            r36 = r0
            r37 = r2
            r38 = r6
            r10 = 0
            r6 = r10
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$Style r6 = (com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData.Style) r6     // Catch:{ all -> 0x022d }
            r2 = r10
        L_0x0196:
            if (r2 == 0) goto L_0x01a1
            r0 = r2
            r2 = 0
            r3 = r23
            r3.add(r0)     // Catch:{ all -> 0x022d }
            goto L_0x01a3
        L_0x01a1:
            r3 = r23
        L_0x01a3:
            int r5 = r5 + 1
            r23 = r3
            r3 = r25
            r7 = r29
            r22 = r31
            r6 = r32
            r8 = r33
            r10 = r34
            r11 = r35
            r0 = r36
            r2 = r37
            goto L_0x00ba
        L_0x01bb:
            r36 = r0
            r37 = r2
            r32 = r6
            r29 = r7
            r33 = r8
            r34 = r10
            r35 = r11
            r31 = r22
            r3 = r23
            r10 = 0
            r11 = r3
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x022d }
            goto L_0x01e5
        L_0x01d3:
            r36 = r0
            r37 = r2
            r21 = r5
            r32 = r6
            r29 = r7
            r33 = r8
            r34 = r10
            r35 = r11
            r10 = 0
            r11 = r10
        L_0x01e5:
            r0 = r11
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$MappingItem r2 = new com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData$MappingItem     // Catch:{ all -> 0x022d }
            r2.<init>(r4, r1, r0)     // Catch:{ all -> 0x022d }
            r0 = r2
            r1 = 0
            r12.add(r0)     // Catch:{ all -> 0x022d }
            int r15 = r15 + 1
            r1 = r42
            r6 = r10
            r3 = r18
            r5 = r21
            r7 = r29
            r8 = r33
            r10 = r34
            r11 = r35
            r0 = r36
            r2 = r37
            goto L_0x005f
        L_0x0207:
            r0 = move-exception
            r10 = 0
            goto L_0x0231
        L_0x020a:
            r18 = r3
            r29 = r7
            r33 = r8
            r34 = r10
            r35 = r11
            r10 = r6
            r11 = r12
            java.util.List r11 = (java.util.List) r11     // Catch:{ all -> 0x022d }
            goto L_0x0222
        L_0x021a:
            r18 = r3
            r10 = r6
            r29 = r7
            r33 = r8
            r11 = r10
        L_0x0222:
            r0 = r11
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData r1 = new com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData     // Catch:{ all -> 0x022d }
            r1.<init>(r9, r0)     // Catch:{ all -> 0x022d }
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r1)     // Catch:{ all -> 0x022d }
            goto L_0x023b
        L_0x022d:
            r0 = move-exception
            goto L_0x0231
        L_0x022f:
            r0 = move-exception
            r10 = r6
        L_0x0231:
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
        L_0x023b:
            boolean r1 = kotlin.Result.m8977isFailureimpl(r0)
            if (r1 == 0) goto L_0x0243
            r6 = r10
            goto L_0x0244
        L_0x0243:
            r6 = r0
        L_0x0244:
            com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData r6 = (com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData) r6
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagHelper.parseConfig(java.lang.String):com.baidu.searchbox.inputbox.utils.LandingPageSearchBoxTagConfigData");
    }

    public final LandingPageSearchBoxTagConfigData.Style getTagStyle(String channel, String sa) {
        List<LandingPageSearchBoxTagConfigData.Style> $this$forEach$iv;
        String str = channel;
        LandingPageSearchBoxTagConfigData config = getLandingPageSearchBoxTagConfig();
        if (config == null) {
            return null;
        }
        CharSequence charSequence = str;
        boolean z = true;
        boolean z2 = false;
        if (!(charSequence == null || charSequence.length() == 0)) {
            CharSequence charSequence2 = sa;
            if (!(charSequence2 == null || charSequence2.length() == 0)) {
                Collection channels = config.getChannels();
                if (channels != null && !channels.isEmpty()) {
                    z = false;
                }
                if (z) {
                    return null;
                } else if (!config.getChannels().contains(str)) {
                    LandingPageSearchBoxTagConfigData landingPageSearchBoxTagConfigData = config;
                    return null;
                } else {
                    List<LandingPageSearchBoxTagConfigData.MappingItem> mappingList = config.getMappingList();
                    if (mappingList != null) {
                        Iterable<LandingPageSearchBoxTagConfigData.MappingItem> $this$forEach$iv2 = mappingList;
                        int $i$f$forEach = false;
                        for (LandingPageSearchBoxTagConfigData.MappingItem mappingItem : $this$forEach$iv2) {
                            List<String> $this$forEach$iv3 = mappingItem.getSaRules();
                            if ($this$forEach$iv3 != null) {
                                for (String rules : $this$forEach$iv3) {
                                    LandingPageSearchBoxTagConfigData config2 = config;
                                    Iterable $this$forEach$iv4 = $this$forEach$iv2;
                                    int $i$f$forEach2 = $i$f$forEach;
                                    if (StringsKt.contains$default((CharSequence) sa, (CharSequence) rules, z2, 2, (Object) null) && ($this$forEach$iv = mappingItem.getStyles()) != null) {
                                        for (LandingPageSearchBoxTagConfigData.Style style : $this$forEach$iv) {
                                            if (Intrinsics.areEqual((Object) style.getChannel(), (Object) str)) {
                                                return style;
                                            }
                                        }
                                        continue;
                                    }
                                    config = config2;
                                    $this$forEach$iv2 = $this$forEach$iv4;
                                    $i$f$forEach = $i$f$forEach2;
                                    z2 = false;
                                }
                                continue;
                            }
                            config = config;
                            $this$forEach$iv2 = $this$forEach$iv2;
                            $i$f$forEach = $i$f$forEach;
                            z2 = false;
                        }
                        Iterable iterable = $this$forEach$iv2;
                        int i2 = $i$f$forEach;
                        return null;
                    }
                    return null;
                }
            }
        }
        return null;
    }
}
