package com.baidu.searchbox.kmm.personalcenter.api;

import co.touchlab.stately.HelpersJVMKt;
import com.baidu.searchbox.kmm.foundation.concurrent.BackgroundTaskUtilsKt;
import com.baidu.searchbox.kmm.foundation.io.AssetsFileUtilsKt;
import com.baidu.searchbox.kmm.foundation.kelson.JsonArray;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.foundation.network.HttpPostBodyType;
import com.baidu.searchbox.kmm.foundation.network.HttpRequest;
import com.baidu.searchbox.kmm.foundation.network.URLComposerKt;
import com.baidu.searchbox.kmm.personalcenter.PersonalCenterDataMgr;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterHoroscopeTypeEntity;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.kmm.personalcenter.smart.PersonalCenterSmartDataMgr;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\b\u0010\u0003\u001a\u00020\u0004H\u0000\u001a\u0010\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u0006H\u0000\u001au\u0010\b\u001a\u00020\u0004*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2Q\u0010\f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0000\u001aX\u0010\u0016\u001a\u00020\u0004*\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u001b28\u0010\u001c\u001a4\u0012\u0013\u0012\u00110\u000b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001e\u0012\u0015\u0012\u0013\u0018\u00010\u001b¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00040\u001dH\u0000\u001au\u0010 \u001a\u00020\u0004*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2Q\u0010\f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0000\u001a\u0010!\u001a\u00020\u0004*\u00020\u00172\u0006\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\"\u001a\u00020\u000b2Q\u0010\f\u001aM\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0012\u0012\u0015\u0012\u0013\u0018\u00010\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0013\u0012\u0004\u0012\u00020\u00040\r2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00040\u0015H\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001XT¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"STAT_TOPIC", "", "SUB_FROM_PERSONAL_CENTER", "checkIsFusionTargetUser", "", "reqHoroscopeTypeData", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterHoroscopeTypeEntity;", "requestFusionPersonalCenterMain", "Lcom/baidu/searchbox/kmm/personalcenter/PersonalCenterDataMgr;", "isColdStart", "", "succeedCB", "Lkotlin/Function3;", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObject;", "Lkotlin/ParameterName;", "name", "tipsJson", "guidanceData", "popupJson", "failedCB", "Lkotlin/Function0;", "requestNpsAbilitySubmit", "Lcom/baidu/searchbox/kmm/personalcenter/smart/PersonalCenterSmartDataMgr;", "dataModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabModel;", "userScore", "", "requestCB", "Lkotlin/Function2;", "isSuccess", "toastText", "requestPersonalCenterMain", "requestSmartPersonalCenterMain", "isNeedAllRefresh", "com.baidu.searchbox.kmm.business.personalcenter"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCenterApi.kt */
public final class PersonalCenterApiKt {
    private static final int STAT_TOPIC = 10;
    private static final int SUB_FROM_PERSONAL_CENTER = 1015;

    public static final List<PersonalCenterHoroscopeTypeEntity> reqHoroscopeTypeData() {
        String json = AssetsFileUtilsKt.readAssetContent("personal_center_horoscope_preset.json");
        List list = null;
        JsonArray jsonArray = json != null ? JsonUtilKt.toJsonArray(json) : null;
        if (jsonArray != null) {
            list = JsonUtilKt.getJsonModelList$default(jsonArray, (String) null, PersonalCenterApiKt$reqHoroscopeTypeData$1.INSTANCE, 1, (Object) null);
        }
        return (List) HelpersJVMKt.freeze(list);
    }

    public static final void requestPersonalCenterMain(PersonalCenterDataMgr $this$requestPersonalCenterMain, boolean isColdStart, Function3<? super JsonObject, ? super JsonObject, ? super JsonObject, Unit> succeedCB, Function0<Unit> failedCB) {
        PersonalCenterDataMgr personalCenterDataMgr = $this$requestPersonalCenterMain;
        Function3<? super JsonObject, ? super JsonObject, ? super JsonObject, Unit> function3 = succeedCB;
        Function0<Unit> function0 = failedCB;
        Intrinsics.checkNotNullParameter(personalCenterDataMgr, "<this>");
        Intrinsics.checkNotNullParameter(function3, "succeedCB");
        Intrinsics.checkNotNullParameter(function0, "failedCB");
        HttpRequest.doPOST$default(URLComposerKt.makeFullURL("/baiduboxapp/personal/index?action=personal&" + ("source=" + (isColdStart ? "start" : "click"))), PersonalCenterPostDataMakerKt.createPostData($this$requestPersonalCenterMain), (HttpPostBodyType) null, true, 10, 1015, new PersonalCenterApiKt$requestPersonalCenterMain$1(function0, personalCenterDataMgr, function3), new PersonalCenterApiKt$requestPersonalCenterMain$2(function0), (Function2) null, 0.0f, 0.0d, 1796, (Object) null);
    }

    public static final void requestFusionPersonalCenterMain(PersonalCenterDataMgr $this$requestFusionPersonalCenterMain, boolean isColdStart, Function3<? super JsonObject, ? super JsonObject, ? super JsonObject, Unit> succeedCB, Function0<Unit> failedCB) {
        PersonalCenterDataMgr personalCenterDataMgr = $this$requestFusionPersonalCenterMain;
        Function3<? super JsonObject, ? super JsonObject, ? super JsonObject, Unit> function3 = succeedCB;
        Function0<Unit> function0 = failedCB;
        Intrinsics.checkNotNullParameter(personalCenterDataMgr, "<this>");
        Intrinsics.checkNotNullParameter(function3, "succeedCB");
        Intrinsics.checkNotNullParameter(function0, "failedCB");
        HttpRequest.doPOST$default(URLComposerKt.makeFullURL("/baiduboxapp/personal/index?action=personal&" + ("source=" + (isColdStart ? "start" : "click"))), PersonalCenterPostDataMakerKt.createFusionPostData($this$requestFusionPersonalCenterMain), (HttpPostBodyType) null, true, 10, 1015, new PersonalCenterApiKt$requestFusionPersonalCenterMain$1(function0, personalCenterDataMgr, function3), new PersonalCenterApiKt$requestFusionPersonalCenterMain$2(function0), (Function2) null, 0.0f, 0.0d, 1796, (Object) null);
    }

    public static /* synthetic */ void requestSmartPersonalCenterMain$default(PersonalCenterSmartDataMgr personalCenterSmartDataMgr, boolean z, boolean z2, Function3 function3, Function0 function0, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        requestSmartPersonalCenterMain(personalCenterSmartDataMgr, z, z2, function3, function0);
    }

    public static final void requestSmartPersonalCenterMain(PersonalCenterSmartDataMgr $this$requestSmartPersonalCenterMain, boolean isColdStart, boolean isNeedAllRefresh, Function3<? super JsonObject, ? super JsonObject, ? super JsonObject, Unit> succeedCB, Function0<Unit> failedCB) {
        PersonalCenterSmartDataMgr personalCenterSmartDataMgr = $this$requestSmartPersonalCenterMain;
        Function3<? super JsonObject, ? super JsonObject, ? super JsonObject, Unit> function3 = succeedCB;
        Function0<Unit> function0 = failedCB;
        Intrinsics.checkNotNullParameter(personalCenterSmartDataMgr, "<this>");
        Intrinsics.checkNotNullParameter(function3, "succeedCB");
        Intrinsics.checkNotNullParameter(function0, "failedCB");
        HttpRequest.doPOST$default(URLComposerKt.makeFullURL("/baiduboxapp/personal/aiindex?action=personal&" + ("source=" + (isColdStart ? "start" : "click"))), PersonalCenterPostDataMakerKt.createSmartPostData(personalCenterSmartDataMgr, isNeedAllRefresh), (HttpPostBodyType) null, true, 10, 1015, new PersonalCenterApiKt$requestSmartPersonalCenterMain$1(function0, personalCenterSmartDataMgr, function3), new PersonalCenterApiKt$requestSmartPersonalCenterMain$2(function0), (Function2) null, 0.0f, 0.0d, 1796, (Object) null);
    }

    public static final void requestNpsAbilitySubmit(PersonalCenterSmartDataMgr $this$requestNpsAbilitySubmit, PersonalCenterTabModel dataModel, String userScore, Function2<? super Boolean, ? super String, Unit> requestCB) {
        Function2<? super Boolean, ? super String, Unit> function2 = requestCB;
        Intrinsics.checkNotNullParameter($this$requestNpsAbilitySubmit, "<this>");
        Intrinsics.checkNotNullParameter(userScore, "userScore");
        Intrinsics.checkNotNullParameter(function2, "requestCB");
        String url = URLComposerKt.makeFullURL("/baiduboxapp/personal/nps/submit?");
        HttpRequest.doPOST$default(url, PersonalCenterPostDataMakerKt.createNpsSubmitPostData($this$requestNpsAbilitySubmit, dataModel, userScore), (HttpPostBodyType) null, true, 10, 1015, new PersonalCenterApiKt$requestNpsAbilitySubmit$1(function2), new PersonalCenterApiKt$requestNpsAbilitySubmit$2(function2), (Function2) null, 0.0f, 0.0d, 1796, (Object) null);
    }

    public static final void checkIsFusionTargetUser() {
        BackgroundTaskUtilsKt.bgSerialWork(PersonalCenterApiKt$checkIsFusionTargetUser$1.INSTANCE);
    }
}
