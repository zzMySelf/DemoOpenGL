package com.baidu.searchbox.personal.manager;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.download.center.ui.autobackup.NetDiskOptionWrapper;
import com.baidu.searchbox.downloadcenter.service.IDownloadCenterFun;
import com.baidu.searchbox.kmm.personalcenter.IPersonalCenterUploadDataCallback;
import com.baidu.searchbox.newpersonalcenter.manager.PersonalDataManager;
import com.baidu.searchbox.newpersonalcenter.manager.TaskPopupManagerKt;
import com.baidu.searchbox.newpersonalcenter.managerpage.SelectedTabsBO;
import com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerCacheHelper;
import com.baidu.searchbox.newpersonalcenter.model.AddWidgetModel;
import com.baidu.searchbox.newpersonalcenter.model.AddWidgetModelKt;
import com.baidu.searchbox.newpersonalcenter.model.TipModel;
import com.baidu.searchbox.newpersonalcenter.model.TipsModel;
import com.baidu.searchbox.openwidget.OpenWidgetManager;
import com.baidu.searchbox.openwidget.model.OpenWidgetInstance;
import com.baidu.searchbox.personal.bubble.BubbleGuideManager;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.newtips.PersonalItemObservable;
import com.baidu.searchbox.personalcenter.novel.PersonalContentFetcher;
import com.baidu.searchbox.personalcenter.novel.PersonalDataType;
import com.baidu.searchbox.utils.PersonalCenterSpUtils;
import com.google.gson.Gson;
import java.util.HashMap;
import java.util.List;
import kotlin.Metadata;
import org.json.JSONArray;
import org.json.JSONObject;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\f\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005H\u0016J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\b\u001a\u00020\u0007H\u0016J\n\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u0010\u0010\u000b\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\u0016J\f\u0010\f\u001a\u00060\rj\u0002`\u000eH\u0016J\f\u0010\u000f\u001a\u00060\u0004j\u0002`\u0005H\u0016J\u0010\u0010\u0010\u001a\n\u0018\u00010\u0004j\u0004\u0018\u0001`\u0005H\u0016J\f\u0010\u0011\u001a\u00060\rj\u0002`\u000eH\u0016J\u0010\u0010\u0012\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0016J\u0010\u0010\u0013\u001a\n\u0018\u00010\rj\u0004\u0018\u0001`\u000eH\u0002¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/personal/manager/UpstreamDataGenerator;", "Lcom/baidu/searchbox/kmm/personalcenter/IPersonalCenterUploadDataCallback;", "()V", "getCardTypeParams", "Lorg/json/JSONObject;", "Lcom/baidu/searchbox/kmm/foundation/kelson/KJsonObject;", "getIsNovelUser", "", "getIsPanShieldUser", "getLiuChangBoClickTime", "", "getNetdiskSwitches", "getSelectedTabs", "Lorg/json/JSONArray;", "Lcom/baidu/searchbox/kmm/foundation/kelson/KJsonArray;", "getUploadGuidanceData", "getUploadTaskPopupData", "getUploadTipsData", "getUploadWidgetInfo", "getWidgetPostParams", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UpstreamDataGenerator.kt */
public final class UpstreamDataGenerator implements IPersonalCenterUploadDataCallback {
    public boolean getIsNovelUser() {
        List originalData;
        boolean isNovelUser = PersonalCenterSpUtils.getBoolean(PersonalConstants.PERSONAL_IS_NOVEL_USER_KEY);
        if (isNovelUser || (originalData = PersonalContentFetcher.getInstance().getOriginalData(PersonalDataType.NOVEL, 10)) == null || originalData.size() <= 0) {
            return isNovelUser;
        }
        PersonalCenterSpUtils.putBoolean(PersonalConstants.PERSONAL_IS_NOVEL_USER_KEY, true);
        return true;
    }

    public String getLiuChangBoClickTime() {
        return ((IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE)).getLastClickLCBTime();
    }

    public JSONObject getNetdiskSwitches() {
        String str;
        String str2;
        JSONObject backupSwitch = new JSONObject();
        String str3 = "1";
        backupSwitch.put("backupSwitch", NetDiskOptionWrapper.INSTANCE.getSwitchStateAutoBackup() ? str3 : "0");
        if (NetDiskOptionWrapper.INSTANCE.getSwitchStateOptionVideo()) {
            str = str3;
        } else {
            str = "0";
        }
        backupSwitch.put("videoBackupSwitch", str);
        if (NetDiskOptionWrapper.INSTANCE.getSwitchStateOptionFile()) {
            str2 = str3;
        } else {
            str2 = "0";
        }
        backupSwitch.put("fileBackupSwitch", str2);
        if (!NetDiskOptionWrapper.INSTANCE.getSwitchStateOptionPicture()) {
            str3 = "0";
        }
        backupSwitch.put("imgBackupSwitch", str3);
        return backupSwitch;
    }

    public JSONArray getSelectedTabs() {
        List selectedTabs = TemplateManagerCacheHelper.INSTANCE.getSelectedTabsSync();
        JSONArray selectTabsJsonArray = new JSONArray();
        int size = selectedTabs.size();
        for (int i2 = 0; i2 < size; i2++) {
            SelectedTabsBO selectedTabsBO = selectedTabs.get(i2);
            String groupId = selectedTabsBO.component1();
            String status = selectedTabsBO.component2();
            String showTimes = selectedTabsBO.component3();
            String clickTimes = selectedTabsBO.component4();
            String clickTime = selectedTabsBO.component5();
            JSONObject selectedTabJson = new JSONObject();
            selectedTabJson.put("id", groupId);
            selectedTabJson.put("status", status);
            selectedTabJson.put("showTimes", showTimes);
            selectedTabJson.put("clickTimes", clickTimes);
            selectedTabJson.put("clickTime", clickTime);
            selectTabsJsonArray.put(selectedTabJson);
        }
        return selectTabsJsonArray;
    }

    public JSONObject getUploadGuidanceData() {
        JSONObject guidancesJson = new JSONObject();
        guidancesJson.put("version", BubbleGuideManager.INSTANCE.getGuideVersion());
        return guidancesJson;
    }

    public JSONObject getUploadTaskPopupData() {
        JSONObject taskJson = new JSONObject();
        taskJson.put("task_popup", TaskPopupManagerKt.getTaskVersion());
        return taskJson;
    }

    public JSONArray getUploadTipsData() {
        TipsModel serverTipsData;
        String isShow;
        try {
            serverTipsData = (TipsModel) new Gson().fromJson(PersonalItemObservable.getInstance().getServerTipsData(), TipsModel.class);
        } catch (Exception e2) {
            serverTipsData = null;
            if (AppConfig.isDebug()) {
                e2.printStackTrace();
            }
        }
        if (serverTipsData == null || serverTipsData.getTipModelList() == null || serverTipsData.getTipModelList().size() <= 0) {
            return new JSONArray();
        }
        List tipModelList = serverTipsData.getTipModelList();
        JSONArray postTipsList = new JSONArray();
        for (TipModel singleTipModel : tipModelList) {
            JSONObject item = new JSONObject();
            item.put("id", singleTipModel.id);
            item.put("type", singleTipModel.type);
            item.put("sortie", singleTipModel.sortie);
            String linkShow = "1";
            if (PersonalItemObservable.getInstance().getItemHasNewTips(singleTipModel.id, singleTipModel.type)) {
                isShow = linkShow;
            } else {
                isShow = "0";
            }
            item.put("isShow", isShow);
            if (TextUtils.equals(singleTipModel.id, "skin")) {
                item.put("linkSortie", singleTipModel.linkSortie);
                if (!PersonalItemObservable.getInstance().getSkinCenterHasLinkTips()) {
                    linkShow = "0";
                }
                item.put("linkShow", linkShow);
            }
            postTipsList.put(item);
        }
        return postTipsList;
    }

    public JSONArray getUploadWidgetInfo() {
        return getWidgetPostParams();
    }

    private final JSONArray getWidgetPostParams() {
        if (AppConfig.isDebug()) {
            return new JSONArray();
        }
        long startTime = System.currentTimeMillis();
        JSONArray widgetModels = new JSONArray();
        OpenWidgetManager widgetManager = OpenWidgetManager.Companion.getOrNull();
        if (widgetManager != null) {
            List widgets = widgetManager.getWidgetInstances();
            HashMap widgetsMap = new HashMap();
            for (OpenWidgetInstance widget : widgets) {
                long openWidgetId = widget.getInfo().getOpenWidgetId();
                OpenWidgetInstance instanceInMap = (OpenWidgetInstance) widgetsMap.get(Long.valueOf(openWidgetId));
                if (instanceInMap == null || instanceInMap.getId() < widget.getId()) {
                    widgetsMap.put(Long.valueOf(openWidgetId), widget);
                }
            }
            for (Long openWidgetId2 : widgetsMap.keySet()) {
                OpenWidgetInstance widgetInstance = (OpenWidgetInstance) widgetsMap.get(openWidgetId2);
                if (widgetInstance != null) {
                    widgetModels.put(AddWidgetModelKt.toJson(new AddWidgetModel(String.valueOf(openWidgetId2.longValue()), widgetInstance.getConfig().component2())));
                }
            }
            if (AppConfig.isDebug()) {
                Log.d(PersonalDataManager.TAG, "getWidgets cost time = " + (((float) (System.currentTimeMillis() - startTime)) / 1000.0f) + "s , size = " + widgets.size());
            }
        }
        return widgetModels;
    }

    public JSONObject getCardTypeParams() {
        JSONObject cardTypeJson = new JSONObject();
        String constellationType = PersonalCenterSpUtils.getString("KEY_CONSTELLATION_TYPE", "");
        if (!TextUtils.isEmpty(constellationType)) {
            cardTypeJson.put("constellationType", constellationType);
        }
        return cardTypeJson;
    }

    public boolean getIsPanShieldUser() {
        IDownloadCenterFun downloadCenterFun = (IDownloadCenterFun) ServiceManager.getService(IDownloadCenterFun.SERVICE_REFERENCE);
        if (downloadCenterFun != null) {
            return downloadCenterFun.isShieldedNetDiskAbility();
        }
        return false;
    }
}
