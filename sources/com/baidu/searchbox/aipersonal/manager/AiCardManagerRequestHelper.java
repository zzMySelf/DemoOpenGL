package com.baidu.searchbox.aipersonal.manager;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.aipersonal.activity.PersonalAiCommonManagerActivity;
import com.baidu.searchbox.aipersonal.activity.PersonalAiCommonManagerForPadActivity;
import com.baidu.searchbox.base.utils.PreferenceUtils;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.database.FunctionCodeControl;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonArray;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.home.tab.HomeFourthTabTypeUtils;
import com.baidu.searchbox.kmm.home.tab.HomeSecondTabTypeUtils;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.personal.fuse.PersonalCenterNetExtensionKt;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.config.PersonalCenterUrlConfig;
import com.baidu.searchbox.utils.PersonalCenterSpUtils;
import com.baidu.searchbox.utils.PersonalCenterUtils;
import com.baidu.searchbox.youthhome.IYouthHomeApi;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.FormBody;
import okhttp3.RequestBody;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J2\u0010\u0014\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u00160\u00152\u0018\u0010\u0018\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u00160\u0015J\u0010\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cJ\u0016\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001e0\u00152\b\b\u0002\u0010\u001f\u001a\u00020\u0004J$\u0010 \u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u0016\u0018\u00010\u00152\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010#\u001a\u00020\u001a2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u001e0\u0015H\u0002J\u0016\u0010%\u001a\u00020\u001a2\u000e\u0010&\u001a\n\u0018\u00010'j\u0004\u0018\u0001`(J \u0010%\u001a\u00020\u001a2\u0018\u0010)\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00040\u00160\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \n*\u0004\u0018\u00010\u00060\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u001b\u0010\u000e\u001a\u00020\u000f8BX\u0002¢\u0006\f\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0010\u0010\u0011¨\u0006*"}, d2 = {"Lcom/baidu/searchbox/aipersonal/manager/AiCardManagerRequestHelper;", "", "()V", "DEBUG", "", "HAVE_SHOWED", "", "MESSAGEBAR", "NEW_USER_ABOUT_NET_DISK", "TAG", "kotlin.jvm.PlatformType", "USER_IS_OPERATION_KEY", "USER_OPERATION_JSON_KEY", "YOUNG_HOMEPAGE", "mGson", "Lcom/google/gson/Gson;", "getMGson", "()Lcom/google/gson/Gson;", "mGson$delegate", "Lkotlin/Lazy;", "compareCcsIdsData", "", "Lkotlin/Pair;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "userSelectList", "getTabsData", "", "callBack", "Lcom/baidu/searchbox/aipersonal/manager/AiManagerCallBack;", "getUserOperationLocalData", "Lcom/baidu/searchbox/aipersonal/manager/AiLocalSelectItemData;", "isFromManager", "parseResponseJson", "response", "Lokhttp3/Response;", "realSaveSelectItems", "selectedItems", "updateSelectItems", "jsonArray", "Lorg/json/JSONArray;", "Lcom/baidu/searchbox/kmm/foundation/kelson/KJsonArray;", "datas", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiManagerDataRequestHelper.kt */
public final class AiCardManagerRequestHelper {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = AppConfig.isDebug();
    private static final String HAVE_SHOWED = "haveShowed";
    public static final AiCardManagerRequestHelper INSTANCE = new AiCardManagerRequestHelper();
    private static final String MESSAGEBAR = "messageBar";
    private static final String NEW_USER_ABOUT_NET_DISK = "newUserAboutNetdisk";
    /* access modifiers changed from: private */
    public static final String TAG = AiCardManagerRequestHelper.class.getSimpleName();
    public static final String USER_IS_OPERATION_KEY = "ai_manager_user_is_operation";
    public static final String USER_OPERATION_JSON_KEY = "ai_manager_user_operation_json";
    private static final String YOUNG_HOMEPAGE = "youngHomePage";
    private static final Lazy mGson$delegate = LazyKt.lazy(AiCardManagerRequestHelper$mGson$2.INSTANCE);

    private AiCardManagerRequestHelper() {
    }

    private final Gson getMGson() {
        return (Gson) mGson$delegate.getValue();
    }

    public final void getTabsData(AiManagerCallBack callBack) {
        try {
            String requestUrl = PersonalCenterUrlConfig.getAIManagerUrl();
            RequestBody bodyParams = null;
            JsonObject jsonObject = new JsonObject();
            JsonArray haveShowedJson = new JsonArray();
            if (HomeFourthTabTypeUtils.INSTANCE.isFourthTabTypeMessage() || HomeSecondTabTypeUtils.INSTANCE.isSecondTabTypeMessage()) {
                haveShowedJson.add("messageBar");
            }
            IYouthHomeApi youthHomeApi = IYouthHomeApi.Companion.getYouthHomeApi();
            boolean z = true;
            if (youthHomeApi == null || !youthHomeApi.isYouthHome()) {
                z = false;
            }
            if (z) {
                haveShowedJson.add("youngHomePage");
            }
            IDownloadCenterFun downloadCenterFun = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
            if (downloadCenterFun != null && downloadCenterFun.isShieldedNetDiskAbility()) {
                haveShowedJson.add("newUserAboutNetdisk");
            }
            if (haveShowedJson.getSize() != 0) {
                jsonObject.put("haveShowed", haveShowedJson);
                if (DEBUG) {
                    Log.d(TAG, " bodyJson  = " + jsonObject);
                }
                FormBody.Builder formBodyBuilder = new FormBody.Builder();
                formBodyBuilder.add("data", jsonObject.toString());
                bodyParams = formBodyBuilder.build();
            }
            Intrinsics.checkNotNullExpressionValue(requestUrl, "requestUrl");
            PersonalCenterNetExtensionKt.postRequestOnUIBack(requestUrl, new LinkedHashMap(), bodyParams, new AiCardManagerRequestHelper$getTabsData$2(callBack));
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, " getTabsData  异常 " + e2);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x003e A[Catch:{ all -> 0x019e }] */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0048 A[Catch:{ all -> 0x019e }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<kotlin.Pair<com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel, java.lang.Boolean>> parseResponseJson(okhttp3.Response r25) {
        /*
            r24 = this;
            kotlin.Result$Companion r0 = kotlin.Result.Companion     // Catch:{ all -> 0x019e }
            r0 = 0
            okhttp3.ResponseBody r1 = r25.body()     // Catch:{ all -> 0x019e }
            r2 = 0
            if (r1 == 0) goto L_0x000f
            java.lang.String r1 = r1.string()     // Catch:{ all -> 0x019e }
            goto L_0x0010
        L_0x000f:
            r1 = r2
        L_0x0010:
            boolean r3 = DEBUG     // Catch:{ all -> 0x019e }
            if (r3 == 0) goto L_0x002c
            java.lang.String r4 = TAG     // Catch:{ all -> 0x019e }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x019e }
            r5.<init>()     // Catch:{ all -> 0x019e }
            java.lang.String r6 = " parseResponseJson json = "
            java.lang.StringBuilder r5 = r5.append(r6)     // Catch:{ all -> 0x019e }
            java.lang.StringBuilder r5 = r5.append(r1)     // Catch:{ all -> 0x019e }
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x019e }
            android.util.Log.d(r4, r5)     // Catch:{ all -> 0x019e }
        L_0x002c:
            r4 = r1
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4     // Catch:{ all -> 0x019e }
            r6 = 1
            if (r4 == 0) goto L_0x003b
            int r4 = r4.length()     // Catch:{ all -> 0x019e }
            if (r4 != 0) goto L_0x0039
            goto L_0x003b
        L_0x0039:
            r4 = 0
            goto L_0x003c
        L_0x003b:
            r4 = r6
        L_0x003c:
            if (r4 == 0) goto L_0x0048
            if (r3 == 0) goto L_0x0047
            java.lang.String r3 = TAG     // Catch:{ all -> 0x019e }
            java.lang.String r4 = " parseResponseJson 解析失败，json 不存在"
            android.util.Log.e(r3, r4)     // Catch:{ all -> 0x019e }
        L_0x0047:
            return r2
        L_0x0048:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x019e }
            r4.<init>(r1)     // Catch:{ all -> 0x019e }
            java.lang.String r7 = "data"
            org.json.JSONObject r7 = r4.optJSONObject(r7)     // Catch:{ all -> 0x019e }
            if (r7 != 0) goto L_0x0056
            return r2
        L_0x0056:
            java.lang.String r8 = "rootObj.optJSONObject(\"data\") ?: return null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r8)     // Catch:{ all -> 0x019e }
            java.lang.String r8 = "selectedItems"
            org.json.JSONObject r8 = r7.optJSONObject(r8)     // Catch:{ all -> 0x019e }
            if (r8 != 0) goto L_0x0066
            return r2
        L_0x0066:
            java.lang.String r9 = "data.optJSONObject(\"selectedItems\") ?: return null"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r8, r9)     // Catch:{ all -> 0x019e }
            com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper r9 = com.baidu.searchbox.aipersonal.PersonalAiDataManagerWrapper.INSTANCE     // Catch:{ all -> 0x019e }
            com.baidu.searchbox.kmm.personalcenter.smart.PersonalCenterSmartDataMgr r9 = r9.getManager()     // Catch:{ all -> 0x019e }
            com.baidu.searchbox.kmm.foundation.kelson.JsonObject r10 = new com.baidu.searchbox.kmm.foundation.kelson.JsonObject     // Catch:{ all -> 0x019e }
            r10.<init>((org.json.JSONObject) r8)     // Catch:{ all -> 0x019e }
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel r9 = com.baidu.searchbox.kmm.personalcenter.processors.PersonalCenterDataProcessorKt.parseGroupJson(r9, r10)     // Catch:{ all -> 0x019e }
            if (r3 == 0) goto L_0x0095
            java.lang.String r3 = TAG     // Catch:{ all -> 0x019e }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x019e }
            r10.<init>()     // Catch:{ all -> 0x019e }
            java.lang.String r11 = " personalCenterGroupData = "
            java.lang.StringBuilder r10 = r10.append(r11)     // Catch:{ all -> 0x019e }
            java.lang.StringBuilder r10 = r10.append(r9)     // Catch:{ all -> 0x019e }
            java.lang.String r10 = r10.toString()     // Catch:{ all -> 0x019e }
            android.util.Log.d(r3, r10)     // Catch:{ all -> 0x019e }
        L_0x0095:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x019e }
            r3.<init>()     // Catch:{ all -> 0x019e }
            java.util.List r3 = (java.util.List) r3     // Catch:{ all -> 0x019e }
            r10 = r9
            r11 = 0
            com.baidu.searchbox.aipersonal.manager.AiCardManagerRequestHelper r12 = INSTANCE     // Catch:{ all -> 0x019e }
            java.util.List r12 = r12.getUserOperationLocalData(r6)     // Catch:{ all -> 0x019e }
            boolean r13 = r12.isEmpty()     // Catch:{ all -> 0x019e }
            if (r13 == 0) goto L_0x00b7
            boolean r13 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x019e }
            if (r13 == 0) goto L_0x00b7
            java.lang.String r13 = TAG     // Catch:{ all -> 0x019e }
            java.lang.String r14 = " sp 本地数据不存在，异常！"
            android.util.Log.e(r13, r14)     // Catch:{ all -> 0x019e }
        L_0x00b7:
            if (r10 == 0) goto L_0x00c6
            java.util.List r13 = r10.getPersonalCenterTabs()     // Catch:{ all -> 0x019e }
            if (r13 == 0) goto L_0x00c6
            java.lang.Object r13 = kotlin.collections.CollectionsKt.firstOrNull(r13)     // Catch:{ all -> 0x019e }
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel r13 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel) r13     // Catch:{ all -> 0x019e }
            goto L_0x00c7
        L_0x00c6:
            r13 = r2
        L_0x00c7:
            if (r13 == 0) goto L_0x0173
            java.util.List r14 = r13.getBody()     // Catch:{ all -> 0x019e }
            if (r14 == 0) goto L_0x0173
            r15 = 0
            java.util.Iterator r16 = r14.iterator()     // Catch:{ all -> 0x019e }
        L_0x00d4:
            boolean r17 = r16.hasNext()     // Catch:{ all -> 0x019e }
            if (r17 == 0) goto L_0x0157
            java.lang.Object r17 = r16.next()     // Catch:{ all -> 0x019e }
            com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel r17 = (com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel) r17     // Catch:{ all -> 0x019e }
            r18 = r17
            r17 = 0
            r19 = 0
            int r6 = r12.size()     // Catch:{ all -> 0x019e }
            r2 = r19
        L_0x00ec:
            if (r2 >= r6) goto L_0x012c
            java.lang.String r5 = r18.getKeyId()     // Catch:{ all -> 0x019e }
            java.lang.Object r21 = r12.get(r2)     // Catch:{ all -> 0x019e }
            com.baidu.searchbox.aipersonal.manager.AiLocalSelectItemData r21 = (com.baidu.searchbox.aipersonal.manager.AiLocalSelectItemData) r21     // Catch:{ all -> 0x019e }
            r22 = r0
            java.lang.String r0 = r21.getId()     // Catch:{ all -> 0x019e }
            r21 = r1
            r1 = 2
            r23 = r4
            r20 = r6
            r4 = 0
            r6 = 0
            boolean r0 = kotlin.text.StringsKt.equals$default(r5, r0, r4, r1, r6)     // Catch:{ all -> 0x019e }
            if (r0 == 0) goto L_0x011f
            kotlin.Pair r0 = new kotlin.Pair     // Catch:{ all -> 0x019e }
            r1 = 1
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r1)     // Catch:{ all -> 0x019e }
            r1 = r18
            r0.<init>(r1, r4)     // Catch:{ all -> 0x019e }
            r3.add(r0)     // Catch:{ all -> 0x019e }
            r17 = 1
            goto L_0x0135
        L_0x011f:
            r1 = r18
            int r2 = r2 + 1
            r6 = r20
            r1 = r21
            r0 = r22
            r4 = r23
            goto L_0x00ec
        L_0x012c:
            r22 = r0
            r21 = r1
            r23 = r4
            r1 = r18
            r6 = 0
        L_0x0135:
            if (r17 == 0) goto L_0x0140
            r2 = r6
            r1 = r21
            r0 = r22
            r4 = r23
            r6 = 1
            goto L_0x00d4
        L_0x0140:
            kotlin.Pair r0 = new kotlin.Pair     // Catch:{ all -> 0x019e }
            r2 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r2)     // Catch:{ all -> 0x019e }
            r0.<init>(r1, r4)     // Catch:{ all -> 0x019e }
            r3.add(r0)     // Catch:{ all -> 0x019e }
            r2 = r6
            r1 = r21
            r0 = r22
            r4 = r23
            r6 = 1
            goto L_0x00d4
        L_0x0157:
            r22 = r0
            r21 = r1
            r23 = r4
            r0 = r3
            r1 = 0
            int r2 = r0.size()     // Catch:{ all -> 0x019e }
            r4 = 1
            if (r2 <= r4) goto L_0x0170
            com.baidu.searchbox.aipersonal.manager.AiCardManagerRequestHelper$parseResponseJson$lambda-4$lambda-3$lambda-2$$inlined$sortBy$1 r2 = new com.baidu.searchbox.aipersonal.manager.AiCardManagerRequestHelper$parseResponseJson$lambda-4$lambda-3$lambda-2$$inlined$sortBy$1     // Catch:{ all -> 0x019e }
            r2.<init>(r12, r3)     // Catch:{ all -> 0x019e }
            java.util.Comparator r2 = (java.util.Comparator) r2     // Catch:{ all -> 0x019e }
            kotlin.collections.CollectionsKt.sortWith(r0, r2)     // Catch:{ all -> 0x019e }
        L_0x0170:
            goto L_0x0179
        L_0x0173:
            r22 = r0
            r21 = r1
            r23 = r4
        L_0x0179:
            boolean r0 = com.baidu.searchbox.config.AppConfig.isDebug()     // Catch:{ all -> 0x019e }
            if (r0 == 0) goto L_0x019d
            java.lang.String r0 = TAG     // Catch:{ all -> 0x019e }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x019e }
            r1.<init>()     // Catch:{ all -> 0x019e }
            java.lang.String r2 = " finalBodyItemList 数据: "
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x019e }
            int r2 = r3.size()     // Catch:{ all -> 0x019e }
            java.lang.StringBuilder r1 = r1.append(r2)     // Catch:{ all -> 0x019e }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x019e }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x019e }
        L_0x019d:
            return r3
        L_0x019e:
            r0 = move-exception
            kotlin.Result$Companion r1 = kotlin.Result.Companion
            java.lang.Object r0 = kotlin.ResultKt.createFailure(r0)
            java.lang.Object r0 = kotlin.Result.m8971constructorimpl(r0)
            java.lang.Throwable r0 = kotlin.Result.m8974exceptionOrNullimpl(r0)
            if (r0 == 0) goto L_0x01c1
            r1 = 0
            boolean r2 = com.baidu.searchbox.config.AppConfig.isDebug()
            if (r2 == 0) goto L_0x01bf
            java.lang.String r2 = TAG
            java.lang.String r3 = r0.toString()
            android.util.Log.e(r2, r3)
        L_0x01bf:
        L_0x01c1:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.aipersonal.manager.AiCardManagerRequestHelper.parseResponseJson(okhttp3.Response):java.util.List");
    }

    public final void updateSelectItems(JSONArray jsonArray) {
        if (jsonArray != null && jsonArray.length() != 0) {
            List selectedItems = new ArrayList();
            int index = 0;
            int length = jsonArray.length();
            while (true) {
                boolean z = true;
                if (index < length) {
                    if (jsonArray.get(index) instanceof JSONObject) {
                        Object obj = jsonArray.get(index);
                        if (obj != null) {
                            Object opt = ((JSONObject) obj).opt("id");
                            String id = opt != null ? opt.toString() : null;
                            if (DEBUG) {
                                Log.d(TAG, "kmm 更新 updateSelectItems id = " + id + ' ');
                            }
                            CharSequence charSequence = id;
                            if (!(charSequence == null || charSequence.length() == 0)) {
                                z = false;
                            }
                            if (!z) {
                                selectedItems.add(new AiLocalSelectItemData(id));
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type org.json.JSONObject");
                        }
                    }
                    index++;
                } else if (!selectedItems.isEmpty()) {
                    realSaveSelectItems(selectedItems);
                    return;
                } else if (DEBUG) {
                    Log.d(TAG, "updateSelectItems selectItems null ");
                    return;
                } else {
                    return;
                }
            }
        } else if (DEBUG) {
            Log.e(TAG, "updateSelectItems selectItems 数据有误！ ");
        }
    }

    private final synchronized void realSaveSelectItems(List<AiLocalSelectItemData> selectedItems) {
        ExecutorUtilsExt.postOnElastic(new AiCardManagerRequestHelper$$ExternalSyntheticLambda0(selectedItems), "ai_manager_sp_save_thread ", 0);
    }

    /* access modifiers changed from: private */
    /* renamed from: realSaveSelectItems$lambda-6  reason: not valid java name */
    public static final void m14999realSaveSelectItems$lambda6(List $selectedItems) {
        Intrinsics.checkNotNullParameter($selectedItems, "$selectedItems");
        try {
            String userOperationJson = INSTANCE.getMGson().toJson((Object) $selectedItems);
            if (DEBUG) {
                Log.d(TAG, "用户操作后，数据json  =  " + userOperationJson);
            }
            PersonalCenterSpUtils.putString(USER_OPERATION_JSON_KEY, userOperationJson);
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, "realSaveSelectItems  error = " + e2 + ' ');
            }
        }
    }

    public final void updateSelectItems(List<Pair<PersonalCenterTabItemModel, Boolean>> datas) {
        Intrinsics.checkNotNullParameter(datas, FunctionCodeControl.FUNCTION_CODE_DATA_NAME);
        if (DEBUG) {
            Log.d(TAG, " 管理页关闭，保存数据 ");
        }
        List selectedItems = new ArrayList();
        boolean isContainMore = false;
        for (Pair it : datas) {
            PersonalCenterTabItemModel itemData = (PersonalCenterTabItemModel) it.getFirst();
            if (!TextUtils.isEmpty(itemData.getKeyId())) {
                if (TextUtils.equals(String.valueOf(itemData.getKeyId()), "edit")) {
                    isContainMore = true;
                }
                selectedItems.add(new AiLocalSelectItemData(String.valueOf(itemData.getKeyId())));
            }
        }
        if (!isContainMore) {
            selectedItems.add(new AiLocalSelectItemData("edit"));
        }
        if (!selectedItems.isEmpty()) {
            realSaveSelectItems(selectedItems);
        }
    }

    public static /* synthetic */ List getUserOperationLocalData$default(AiCardManagerRequestHelper aiCardManagerRequestHelper, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = false;
        }
        return aiCardManagerRequestHelper.getUserOperationLocalData(z);
    }

    public final List<AiLocalSelectItemData> getUserOperationLocalData(boolean isFromManager) {
        if (isFromManager || PersonalCenterSpUtils.getBoolean(USER_IS_OPERATION_KEY)) {
            String userOperationJson = PersonalCenterSpUtils.getString(USER_OPERATION_JSON_KEY);
            CharSequence charSequence = userOperationJson;
            if (!(charSequence == null || charSequence.length() == 0)) {
                try {
                    List list = (List) getMGson().fromJson(userOperationJson, new AiCardManagerRequestHelper$getUserOperationLocalData$type$1().getType());
                    if (DEBUG) {
                        Log.d(TAG, " getUserOperationLocalData  list.size = " + list.size());
                    }
                    Intrinsics.checkNotNullExpressionValue(list, "list");
                    return list;
                } catch (Exception e2) {
                    if (DEBUG) {
                        Log.e(TAG, " getUserOperationLocalData  e = " + e2);
                    }
                }
            }
            return new ArrayList<>();
        }
        if (DEBUG) {
            Log.d(TAG, " getUserOperationLocalData  ，用户暂未操作过");
        }
        return new ArrayList<>();
    }

    public final List<Pair<PersonalCenterTabItemModel, Boolean>> compareCcsIdsData(List<Pair<PersonalCenterTabItemModel, Boolean>> userSelectList) {
        Intrinsics.checkNotNullParameter(userSelectList, "userSelectList");
        try {
            String ccsJson = PreferenceUtils.getString(PersonalConstants.PERSONAL_AI_MANAGER_FIXED_IDS, "");
            if (TextUtils.isEmpty(ccsJson)) {
                if (DEBUG) {
                    Log.d(TAG, " ccsJson 未下发，使用兜底");
                }
                ccsJson = "[\n    \"feature\",\n    \"history\",\n    \"novel\",\n    \"download\",\n    \"tongzhi\"\n  ]";
            }
            List idsList = new ArrayList();
            JSONArray jsonArray = new JSONArray(ccsJson);
            int length = jsonArray.length();
            for (int index = 0; index < length; index++) {
                if (!TextUtils.isEmpty(jsonArray.get(index).toString())) {
                    idsList.add(jsonArray.get(index).toString());
                }
            }
            List tempList = new ArrayList();
            List fixedList = new ArrayList();
            for (Pair it : userSelectList) {
                if (CollectionsKt.contains(idsList, ((PersonalCenterTabItemModel) it.getFirst()).getKeyId())) {
                    fixedList.add(it);
                } else {
                    tempList.add(it);
                }
            }
            List finalList = new ArrayList();
            finalList.addAll(fixedList);
            finalList.addAll(tempList);
            if (fixedList.size() != 0) {
                if (PersonalCenterUtils.isTablet()) {
                    PersonalAiCommonManagerForPadActivity.Companion.setFixSize(fixedList.size());
                } else {
                    PersonalAiCommonManagerActivity.Companion.setFixSize(fixedList.size());
                }
            }
            if (DEBUG) {
                Log.d(TAG, " ccsJson = " + ccsJson + " , idsList = " + idsList + " , fixedList.size =" + fixedList);
            }
            return finalList;
        } catch (Exception e2) {
            if (DEBUG) {
                Log.e(TAG, " ccsJson 解析异常 " + e2);
            }
            return userSelectList;
        }
    }
}
