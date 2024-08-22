package com.baidu.searchbox.kmm.rightsgranting.services;

import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.rightsgranting.entities.DisplayRecordModel;
import com.baidu.searchbox.kmm.rightsgranting.entities.RightsMaterial;
import com.baidu.searchbox.kmm.rightsgranting.entities.RightsModel;
import com.baidu.searchbox.kmm.rightsgranting.entities.RightsSource;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J\u0010\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bH&J\u001a\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H&J,\u0010\f\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\r\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\u000fH&J\u0010\u0010\u0010\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H&J\n\u0010\u0013\u001a\u0004\u0018\u00010\u0005H&J\n\u0010\u0014\u001a\u0004\u0018\u00010\u0015H&J\u001e\u0010\u0014\u001a\u00020\u00032\u0014\u0010\u0016\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0015\u0012\u0004\u0012\u00020\u00030\u0017H&J\u0010\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\bH&J$\u0010\u0018\u001a\u00020\u00032\u001a\u0010\u0016\u001a\u0016\u0012\f\u0012\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\b\u0012\u0004\u0012\u00020\u00030\u0017H&J\n\u0010\u0019\u001a\u0004\u0018\u00010\u001aH&J\u0010\u0010\u001b\u001a\n\u0018\u00010\u0011j\u0004\u0018\u0001`\u0012H&J\u0010\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\bH&J \u0010\u001d\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u001e\u001a\u00020\u001fH&¨\u0006 "}, d2 = {"Lcom/baidu/searchbox/kmm/rightsgranting/services/IRightsDataService;", "", "clearRightsCache", "", "scene", "", "rightsID", "getDisplayRecordList", "", "Lcom/baidu/searchbox/kmm/rightsgranting/entities/DisplayRecordModel;", "getRightsMaterial", "Lcom/baidu/searchbox/kmm/rightsgranting/entities/RightsMaterial;", "getRightsRemindTalosScheme", "localBundleVersion", "bottomTabHeight", "", "getUserKeep", "Lorg/json/JSONObject;", "Lcom/baidu/searchbox/kmm/foundation/kelson/KJsonObject;", "getUserType", "getValidRights", "Lcom/baidu/searchbox/kmm/rightsgranting/entities/RightsModel;", "callback", "Lkotlin/Function1;", "getValidRightsList", "getValidRightsSignal", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObject;", "getValidRightsSignals", "getValidWidgetRightsList", "recordDialogDisplay", "from", "Lcom/baidu/searchbox/kmm/rightsgranting/entities/RightsSource;", "com.baidu.searchbox.kmm.business.rightsgranting"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IRightsDataService.kt */
public interface IRightsDataService {
    void clearRightsCache(String str, String str2);

    List<DisplayRecordModel> getDisplayRecordList();

    RightsMaterial getRightsMaterial(String str, String str2);

    String getRightsRemindTalosScheme(String str, String str2, String str3, int i2);

    JSONObject getUserKeep();

    String getUserType();

    RightsModel getValidRights();

    void getValidRights(Function1<? super RightsModel, Unit> function1);

    List<RightsModel> getValidRightsList();

    void getValidRightsList(Function1<? super List<RightsModel>, Unit> function1);

    JsonObject getValidRightsSignal();

    JSONObject getValidRightsSignals();

    List<RightsModel> getValidWidgetRightsList();

    void recordDialogDisplay(String str, String str2, RightsSource rightsSource);
}
