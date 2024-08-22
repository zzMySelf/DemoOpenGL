package com.baidu.searchbox.kmm.personalcenter;

import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.utils.PlatformUtils;
import com.baidu.searchbox.kmm.personalcenter.api.PersonalCenterApiKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterDataWrapper;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterFusionHomeModel;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterDataMgrFusionExt.kt */
final class PersonalCenterDataMgrFusionExtKt$updateFusionPersonalItemFromServer$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ boolean $isColdStart;
    final /* synthetic */ Function1<Boolean, Unit> $onFailedCallback;
    final /* synthetic */ Function4<Boolean, JSONObject, JSONObject, JSONObject, Unit> $onLoadSucceedCallback;
    final /* synthetic */ PersonalCenterDataMgr $this_updateFusionPersonalItemFromServer;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    PersonalCenterDataMgrFusionExtKt$updateFusionPersonalItemFromServer$1(PersonalCenterDataMgr personalCenterDataMgr, boolean z, Function4<? super Boolean, ? super JSONObject, ? super JSONObject, ? super JSONObject, Unit> function4, Function1<? super Boolean, Unit> function1) {
        super(0);
        this.$this_updateFusionPersonalItemFromServer = personalCenterDataMgr;
        this.$isColdStart = z;
        this.$onLoadSucceedCallback = function4;
        this.$onFailedCallback = function1;
    }

    public final void invoke() {
        if (this.$this_updateFusionPersonalItemFromServer.getFusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter() == null) {
            PersonalCenterDataMgrFusionExtKt.initFusionLocalNormalData(this.$this_updateFusionPersonalItemFromServer);
            PersonalCenterDataMgr personalCenterDataMgr = this.$this_updateFusionPersonalItemFromServer;
            PersonalCenterDataWrapper fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter = personalCenterDataMgr.getFusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
            personalCenterDataMgr.setFusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter(fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter != null ? PersonalCenterDataWrapper.copy$default(fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter, (List) null, (List) null, (List) null, (JSONArray) null, (JSONArray) null, (PersonalCenterFusionHomeModel) null, 63, (Object) null) : null);
            final PersonalCenterDataMgr personalCenterDataMgr2 = this.$this_updateFusionPersonalItemFromServer;
            final Function4<Boolean, JSONObject, JSONObject, JSONObject, Unit> function4 = this.$onLoadSucceedCallback;
            final Function1<Boolean, Unit> function1 = this.$onFailedCallback;
            BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
                public final void invoke() {
                    PersonalCenterDataWrapper fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter = personalCenterDataMgr2.getFusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                    boolean z = false;
                    if (fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter != null && fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter.isValid$com_baidu_searchbox_kmm_business_personalcenter()) {
                        z = true;
                    }
                    if (z) {
                        PersonalCenterDataMgr personalCenterDataMgr = personalCenterDataMgr2;
                        PersonalCenterDataWrapper fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 = personalCenterDataMgr.getFusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                        personalCenterDataMgr.setFusionExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter(fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 != null ? PersonalCenterDataWrapper.copy$default(fusionLocalDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2, (List) null, (List) null, (List) null, (JSONArray) null, (JSONArray) null, (PersonalCenterFusionHomeModel) null, 63, (Object) null) : null);
                        Function4<Boolean, JSONObject, JSONObject, JSONObject, Unit> function4 = function4;
                        if (function4 != null) {
                            function4.invoke(true, null, null, null);
                            return;
                        }
                        return;
                    }
                    Function1<Boolean, Unit> function1 = function1;
                    if (function1 != null) {
                        function1.invoke(true);
                    }
                }
            });
        }
        if (!this.$isColdStart || !Intrinsics.areEqual((Object) "android", (Object) PlatformUtils.getPlatform())) {
            PersonalCenterDataMgr personalCenterDataMgr3 = this.$this_updateFusionPersonalItemFromServer;
            boolean z = this.$isColdStart;
            final PersonalCenterDataMgr personalCenterDataMgr4 = this.$this_updateFusionPersonalItemFromServer;
            final Function4<Boolean, JSONObject, JSONObject, JSONObject, Unit> function42 = this.$onLoadSucceedCallback;
            final Function1<Boolean, Unit> function12 = this.$onFailedCallback;
            final Function1<Boolean, Unit> function13 = this.$onFailedCallback;
            PersonalCenterApiKt.requestFusionPersonalCenterMain(personalCenterDataMgr3, z, new Function3<JsonObject, JsonObject, JsonObject, Unit>() {
                public /* bridge */ /* synthetic */ Object invoke(Object p1, Object p2, Object p3) {
                    invoke((JsonObject) p1, (JsonObject) p2, (JsonObject) p3);
                    return Unit.INSTANCE;
                }

                public final void invoke(JsonObject tipsJson, JsonObject guidanceData, JsonObject popupJson) {
                    final PersonalCenterDataMgr personalCenterDataMgr = personalCenterDataMgr4;
                    final Function4<Boolean, JSONObject, JSONObject, JSONObject, Unit> function4 = function42;
                    final Function1<Boolean, Unit> function1 = function12;
                    final JsonObject jsonObject = tipsJson;
                    final JsonObject jsonObject2 = guidanceData;
                    final JsonObject jsonObject3 = popupJson;
                    BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
                        public final void invoke() {
                            PersonalCenterDataWrapper fusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter = personalCenterDataMgr.getFusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                            boolean z = true;
                            if (fusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter == null || !fusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter.isValid$com_baidu_searchbox_kmm_business_personalcenter()) {
                                z = false;
                            }
                            if (z) {
                                PersonalCenterDataMgr personalCenterDataMgr = personalCenterDataMgr;
                                PersonalCenterDataWrapper fusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 = personalCenterDataMgr.getFusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter();
                                JSONObject jSONObject = null;
                                personalCenterDataMgr.setFusionExportedDataWrapper$com_baidu_searchbox_kmm_business_personalcenter(fusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2 != null ? PersonalCenterDataWrapper.copy$default(fusionDataWrapper$com_baidu_searchbox_kmm_business_personalcenter2, (List) null, (List) null, (List) null, (JSONArray) null, (JSONArray) null, (PersonalCenterFusionHomeModel) null, 63, (Object) null) : null);
                                Function4<Boolean, JSONObject, JSONObject, JSONObject, Unit> function4 = function4;
                                if (function4 != null) {
                                    JsonObject jsonObject = jsonObject;
                                    JSONObject rawObject = jsonObject != null ? jsonObject.getRawObject() : null;
                                    JsonObject jsonObject2 = jsonObject2;
                                    JSONObject rawObject2 = jsonObject2 != null ? jsonObject2.getRawObject() : null;
                                    JsonObject jsonObject3 = jsonObject3;
                                    if (jsonObject3 != null) {
                                        jSONObject = jsonObject3.getRawObject();
                                    }
                                    function4.invoke(false, rawObject, rawObject2, jSONObject);
                                    return;
                                }
                                return;
                            }
                            Function1<Boolean, Unit> function1 = function1;
                            if (function1 != null) {
                                function1.invoke(false);
                            }
                        }
                    });
                }
            }, new Function0<Unit>() {
                public final void invoke() {
                    final Function1<Boolean, Unit> function1 = function13;
                    BackgroundTaskUtilsKt.mainWork(new Function0<Unit>() {
                        public final void invoke() {
                            Function1<Boolean, Unit> function1 = function1;
                            if (function1 != null) {
                                function1.invoke(false);
                            }
                        }
                    });
                }
            });
        }
    }
}
