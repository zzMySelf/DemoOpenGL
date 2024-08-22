package com.baidu.searchbox.feed.tab.navigation.manager;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.feed.FeedPreferenceUtils;
import com.baidu.searchbox.feed.event.MultiTabUpdateEvent;
import com.baidu.searchbox.feed.tab.TabListUpdateReceiver;
import com.baidu.searchbox.feed.tab.model.TabController;
import com.baidu.searchbox.feed.tab.update.MultiTabItemInfo;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.unitedscheme.utils.UnitedSchemeUtility;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class TabNavSchemeProcessor {
    private static final String ACTION = "action";
    private static final String ACTION_DELETE = "delete";
    private static final String ACTION_INSERT = "insert";
    private static final String ACTION_QUERY = "query";
    private static final String ACTION_SAVE = "save";
    private static final String KEY_TAB_UPDATE_NEW_ID = "channelId";
    private static final String KEY_TAB_UPDATE_NEW_NAME = "channelName";
    private static final String KEY_TAB_UPDATE_PRE_ID = "preChannelId";
    public static final String KEY_TAB_UPDATE_REF_BY_USER = "refreshByUser";
    public static final String KEY_TAB_UPDATE_REF_USER_VALUE = "1";
    public static final String SP_TAB_UPDATE_REF_BY_USER = "local_tab_refresh_by_user";
    public static final String TAB_ID = "tab_id";
    public static final String TAB_INDEX = "tabindex";
    public static final String TAB_INFO = "tabinfo";
    public static final String TAB_INSERT_POLICY = "insertpolicy";
    private static final String TAB_STATUS = "tab_status";
    private static final String TAB_STATUS_ADDED = "1";
    private static final String TAB_STATUS_UNADDED = "0";
    private static volatile TabNavSchemeProcessor sInstance;

    public static TabNavSchemeProcessor getInstance() {
        if (sInstance == null) {
            synchronized (TabNavSchemeProcessor.class) {
                if (sInstance == null) {
                    sInstance = new TabNavSchemeProcessor();
                }
            }
        }
        return sInstance;
    }

    public JSONObject processTabAction(String params) {
        if (!ProcessUtils.isMainProcess()) {
            sendUpdateFeedTabListBroadcast(params);
        }
        if (TextUtils.isEmpty(params)) {
            return error(202);
        }
        try {
            JSONObject paramsJson = new JSONObject(params);
            String action = paramsJson.optString("action");
            if (TextUtils.equals("save", action)) {
                return processSave(paramsJson);
            }
            if (TextUtils.equals("query", action)) {
                return processQuery(paramsJson);
            }
            if (TextUtils.equals("delete", action)) {
                return processDelete(paramsJson);
            }
            if (TextUtils.equals("insert", action)) {
                return processInsert(paramsJson);
            }
            return error(202);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    public boolean processTabItemUpdate(JSONObject paramsJson) {
        if (paramsJson == null) {
            return false;
        }
        String preChannelId = paramsJson.optString(KEY_TAB_UPDATE_PRE_ID);
        String channelId = paramsJson.optString("channelId");
        String channelName = paramsJson.optString("channelName");
        boolean isRefreshByUser = TextUtils.equals(paramsJson.optString(KEY_TAB_UPDATE_REF_BY_USER), "1");
        TabNavDataManager.getInstance().updateTabDisplayInfo(preChannelId, channelId, channelName);
        MultiTabUpdateEvent changeEvent = new MultiTabUpdateEvent(3);
        changeEvent.arg1 = 1;
        changeEvent.arg0 = TabController.INSTANCE.getCurrentPosition();
        BdEventBus.Companion.getDefault().post(changeEvent);
        if (isRefreshByUser) {
            FeedPreferenceUtils.putString(SP_TAB_UPDATE_REF_BY_USER, "1");
        }
        if (TextUtils.equals(preChannelId, TabController.INSTANCE.getCurrentChannelId())) {
            TabController.INSTANCE.setCurrentChannelId(channelId);
        }
        notifyTabChange(false);
        return true;
    }

    public String getLocalTabRefStatus() {
        return FeedPreferenceUtils.getString(SP_TAB_UPDATE_REF_BY_USER, "");
    }

    public List<String> getCurrentShowTabIdList(Context context) {
        if (context == null) {
            return null;
        }
        return TabNavDataManager.getInstance().getCurrentShowTabIdList(context);
    }

    public JSONObject processSave(JSONObject json) {
        String tabId = json.optString("tab_id");
        JSONObject tabJson = json.optJSONObject(TAB_INFO);
        if (TextUtils.isEmpty(tabId) || tabJson == null) {
            return error(202);
        }
        MultiTabItemInfo unAdded = TabNavDataManager.getInstance().removeTab(tabId, 1);
        if (unAdded != null) {
            TabNavDataManager.getInstance().addTab(unAdded, 0);
        } else {
            MultiTabItemInfo info = new MultiTabItemInfo();
            info.parseFromJson(tabJson);
            if (!info.isValidate() || !TextUtils.equals(info.mId, tabId)) {
                return error(202);
            }
            if (isNoNeedAdd(tabId)) {
                return error(401);
            }
            if (TabNavDataManager.getInstance().isAdded(tabId)) {
                return success(true);
            }
            TabNavDataManager.getInstance().addTab(info, 0);
            TabNavDataManager.getInstance().removeTab(info.mId, 2);
        }
        notifyTabChange(true);
        return success(true);
    }

    private JSONObject processQuery(JSONObject json) {
        String tabId = json.optString("tab_id");
        if (TextUtils.isEmpty(tabId)) {
            return error(202);
        }
        if (isNoNeedAdd(tabId)) {
            return error(401);
        }
        return success(TabNavDataManager.getInstance().getTabType(tabId) == 0);
    }

    private JSONObject processDelete(JSONObject json) {
        String tabId = json.optString("tab_id");
        JSONObject tabJson = json.optJSONObject(TAB_INFO);
        if (TextUtils.isEmpty(tabId) || tabJson == null) {
            return error(202);
        }
        MultiTabItemInfo added = TabNavDataManager.getInstance().removeTab(tabId, 0);
        if (added != null) {
            TabNavDataManager.getInstance().addTab(added, 1);
        } else {
            MultiTabItemInfo info = new MultiTabItemInfo();
            info.parseFromJson(tabJson);
            if (!info.isValidate() || !TextUtils.equals(info.mId, tabId)) {
                return error(202);
            }
            if (isNoNeedAdd(tabId)) {
                return error(401);
            }
            TabNavDataManager.getInstance().addTab(info, 1);
            TabNavDataManager.getInstance().removeTab(info.mId, 2);
        }
        notifyTabChange(false);
        return success(false);
    }

    public JSONObject processInsert(JSONObject json) {
        return processInsert(json, 3);
    }

    public JSONObject processInsert(JSONObject json, int eventId) {
        String tabId = json.optString("tab_id");
        JSONObject tabInfo = json.optJSONObject(TAB_INFO);
        if (TextUtils.isEmpty(tabId)) {
            return error(202);
        }
        if (isNoNeedAdd(tabId)) {
            return error(401);
        }
        int tabIndex = json.optInt(TAB_INDEX, -1);
        String insertPositionPolicy = json.optString(TAB_INSERT_POLICY);
        if (tabIndex == -1) {
            return error(202);
        }
        int minCanMoveTabIndex = minCanDeleteTabIndex();
        if (minCanMoveTabIndex < 0) {
            return error(101);
        }
        if (minCanMoveTabIndex > tabIndex) {
            tabIndex = minCanMoveTabIndex;
        }
        MultiTabItemInfo added = TabNavDataManager.getInstance().removeTab(tabId, 1);
        if (added == null) {
            int pos = TabNavDataManager.getInstance().getAddedItemPosById(tabId);
            if (pos == -1) {
                MultiTabItemInfo info = new MultiTabItemInfo();
                info.parseFromJson(tabInfo);
                added = info;
            } else if (pos > -1 && pos <= tabIndex) {
                return success(true);
            } else {
                if (!TextUtils.equals(insertPositionPolicy, "0")) {
                    added = TabNavDataManager.getInstance().removeTab(tabId, 0);
                }
            }
        }
        if (added == null) {
            return error(0);
        }
        int tabIndex2 = insertAndSaveTabAtAdded(tabIndex, added);
        if (TabController.INSTANCE.getCurrentPosition() >= tabIndex2) {
            TabController.INSTANCE.saveSchemeCeiling(TabController.INSTANCE.getCurrentChannelId(), "0");
        }
        notifyTabChange(tabId, tabIndex2, eventId);
        return success(true);
    }

    private int insertAndSaveTabAtAdded(int tabIndex, MultiTabItemInfo tabInfo) {
        List<MultiTabItemInfo> addedList;
        if (tabIndex >= 0 && (addedList = TabNavDataManager.getInstance().getAllAddedMultiTabItemList()) != null) {
            if (addedList.size() > tabIndex) {
                addedList.add(tabIndex, tabInfo);
            } else {
                addedList.add(tabInfo);
                tabIndex = addedList.size() - 1;
            }
            TabNavDataManager.getInstance().saveTabs(addedList, 0);
        }
        return tabIndex;
    }

    public int minCanDeleteTabIndex() {
        List<MultiTabItemInfo> addedList = TabNavDataManager.getInstance().getAllAddedMultiTabItemList();
        if (addedList == null || addedList.size() <= 0) {
            return -1;
        }
        int tabIndex = 0;
        while (tabIndex < addedList.size() && !addedList.get(tabIndex).canDelete) {
            tabIndex++;
        }
        return tabIndex;
    }

    private void sendUpdateFeedTabListBroadcast(String paramsJson) {
        try {
            new JSONObject().put("message_id", 3);
            Intent intent = new Intent(TabListUpdateReceiver.UPDATE_TAB_LIST_ACTION);
            intent.putExtra("data", paramsJson);
            AppRuntime.getAppContext().sendBroadcast(intent);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }

    private JSONObject error(int errorCode) {
        return UnitedSchemeUtility.wrapCallbackParams((JSONObject) null, errorCode);
    }

    private JSONObject success(boolean isAdded) {
        JSONObject data = new JSONObject();
        try {
            data.put(TAB_STATUS, isAdded ? "1" : "0");
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return UnitedSchemeUtility.wrapCallbackParams(data, 0);
    }

    private boolean isNoNeedAdd(String tabId) {
        return !(true & TabNavDataManager.getInstance().isSupportOpt(tabId));
    }

    private void notifyTabChange(boolean isAdd) {
        MultiTabUpdateEvent event = new MultiTabUpdateEvent(3);
        event.arg1 = 1;
        if (isAdd) {
            event.arg0 = TabNavDataManager.getInstance().getAddedMultiTabItemList((Context) null).size() - 1;
        } else {
            event.arg0 = TabController.INSTANCE.getCurrentPosition();
        }
        TabNavDataManager.getInstance().notifyTabChange(event);
    }

    private void notifyTabChange(int tabIndex) {
        notifyTabChange((String) null, tabIndex, 3);
    }

    private void notifyTabChange(String tableID, int tabIndex, int eventId) {
        int addedTabSize = TabNavDataManager.getInstance().getAddedMultiTabItemList((Context) null).size();
        if (tabIndex >= 0 && tabIndex < addedTabSize) {
            MultiTabUpdateEvent event = new MultiTabUpdateEvent(eventId);
            event.arg0 = tabIndex;
            event.arg1 = 1;
            event.tableID = tableID;
            TabNavDataManager.getInstance().notifyTabChange(event);
        }
    }
}
