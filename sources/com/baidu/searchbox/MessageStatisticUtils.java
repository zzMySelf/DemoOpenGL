package com.baidu.searchbox;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.mobstat.Config;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.searchbox.appframework.ext.IUnifiedBottomBarExt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.imsdk.ImSdkManager;
import com.baidu.searchbox.push.MessageStatistic;
import com.baidu.searchbox.push.MessageUtils;
import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import com.baidu.searchbox.unifiedtoolbar.top.UnifiedTopBarButton;
import com.baidu.ubc.Flow;
import com.baidu.ubc.UBC;
import com.baidu.ubc.UBCManager;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class MessageStatisticUtils {
    public static final String BANNER_CLICK = "click";
    public static final String BANNER_CLOSE = "close";
    public static final String BANNER_EXT = "ext";
    public static final String BANNER_EXT_JUESEID = "juese_id";
    public static final String BANNER_SHOW = "show";
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    public static final String DISCOVERY_FINDQUN_CLICK = "findqun_click";
    public static final String DISCOVERY_FINDQUN_SHOW = "findqun_show";
    public static final String DISCOVERY_PAGE_MESSAGE_LIST = "information";
    public static final String DISCOVERY_PAGE_QUN_LIST = "qun_list";
    public static final String DISCOVERY_PAGE_SHOW = "page_show";
    public static final String DISCOVERY_TYPE_NO_RED = "no_red";
    public static final String DISCOVERY_TYPE_RED = "red";
    public static final String DISCOVERY_VALUE_ASK_CLICK = "ask_click";
    public static final String DISCOVERY_VALUE_ASK_SHOW = "ask_show";
    public static final String DISCOVERY_VALUE_FINDQUNTIPCLOSE_CLICK = "findquntipclose_click";
    public static final String DISCOVERY_VALUE_FINDQUNTIPSEE_CLICK = "findquntipsee_click";
    public static final String DISCOVERY_VALUE_FINDQUNTIPSEE_SHOW = "findquntipshow_click";
    public static final String DISCOVERY_VALUE_FINDQUNTIP_SHOW = "findquntip_show";
    public static final String DISCOVERY_VALUE_FINDQUN_CLICK = "findqun_click";
    public static final String DISCOVERY_VALUE_FINDQUN_SHOW = "findqun_show";
    public static final String DISCOVERY_VALUE_MORE_CLICK = "more_click";
    public static final String DISCOVERY_VALUE_MORE_SHOW = "more_show";
    public static final String DISCOVERY_VALUE_UFO_CLICK = "ufo_click";
    public static final String DISCOVERY_VALUE_UFO_SHOW = "ufo_show";
    public static final String FANS_GROUP_SHIED_UBCID = "4387";
    public static final String FANS_GROUP_UBC_ID = "4387";
    public static final String FROM_BJH = "bjh";
    public static final String FROM_C_USER = "c_user";
    public static final String FROM_USER_SHIELD_SETTINGD_MEDIA = "bjh";
    public static final String FROM_USER_SHIELD_SETTINGD_USER = "c_user";
    public static final String GROUP_MESSAGE_UBC_PAGE = "qunxiaoxi";
    public static final String GROUP_SETTING_PAGE = "group_setup";
    public static final String GROUP_SHIELD_FANS_CLUB = "fans_club";
    public static final String GROUP_SHIELD_FANS_GROUP = "fans_group";
    public static final String GROUP_SHIELD_FANS_TRAINING = "training_camp";
    public static final String GROUP_SHIELD_NORMAL_GROUP = "normal_group";
    public static final String GROUP_SHIELD_NOTICE_CONFIRM = "newsremind_confirm";
    public static final String GROUP_SHIELD_NOTICE_SHOW = "newsremindset_show";
    public static final String GROUP_SHIELD_OPEN_CLICK = "newsremind_close";
    public static final String GROUP_SHIELD_OPEN_CLOSE = "newsremind_open";
    public static final String MESSAGE_ITEM_UBC_FROM_JIAYONGHU = "jiayonghu";
    public static final String MESSAGE_ITEM_UBC_FROM_NOT_DISTURB = "miandarao";
    public static final String MESSAGE_ITEM_UBC_FROM_PINGBI = "pingbi";
    public static final String MESSAGE_ITEM_UBC_FROM_QINGKONG = "qingkong";
    public static final String MESSAGE_ITEM_UBC_FROM_QUNMING = "qunming";
    public static final String MESSAGE_ITEM_UBC_FROM_ZHIDING = "zhiding";
    public static final String MESSAGE_ITEM_UBC_ID = "417";
    public static final String MESSAGE_ITEM_UBC_PAGE = "duihuakuangshezhiye";
    public static final String MESSAGE_ITEM_UBC_SOURCE = "duihuakuang";
    public static final String MESSAGE_ITEM_UBC_TYPE_C2C = "C2C";
    public static final String MESSAGE_ITEM_UBC_TYPE_QUNLIAO = "qunliao";
    public static final String MESSAGE_ITEM_UBC_VALUE_CLICK = "click";
    public static final String MESSAGE_ITEM_UBC_VALUE_OFF = "off";
    public static final String MESSAGE_ITEM_UBC_VALUE_ON = "on";
    public static final String MESSAGE_UBC_FANS_ASK = "ask_group";
    public static final String MESSAGE_UBC_FANS_BCP = "bcp_group";
    public static final String MESSAGE_UBC_FANS_CLUB = "fans_club";
    public static final String MESSAGE_UBC_FANS_GROUP_APPLY_CLICK = "apply_click";
    public static final String MESSAGE_UBC_FANS_GROUP_FOLLOW_POP_CANCEL = "followpop_cancel_click";
    public static final String MESSAGE_UBC_FANS_GROUP_FOLLOW_POP_CLICK = "followpop_follow_click";
    public static final String MESSAGE_UBC_FANS_GROUP_FOLLOW_POP_SHOW = "followpop_show";
    public static final String MESSAGE_UBC_FANS_GROUP_GROUP_APPLY = "group_apply";
    public static final String MESSAGE_UBC_FANS_GROUP_GROUP_QR = "group_QR";
    public static final String MESSAGE_UBC_FANS_GROUP_INVITE_COUNT = "count";
    public static final String MESSAGE_UBC_FANS_GROUP_INVITE_PAGE = "information_talk";
    public static final String MESSAGE_UBC_FANS_GROUP_INVITE_VALUE = "invite_send";
    public static final String MESSAGE_UBC_FANS_GROUP_SET_CLEAR_VALUE = "empty_click";
    public static final String MESSAGE_UBC_FANS_GROUP_SET_NAME_SUCCESS_VALUE = "nickname_change";
    public static final String MESSAGE_UBC_FANS_GROUP_SET_NAME_VALUE = "nickname_click";
    public static final String MESSAGE_UBC_FANS_GROUP_SET_PAGE = "group_setup";
    public static final String MESSAGE_UBC_FANS_GROUP_SET_QUIT_VALUE = "quit_click";
    public static final String MESSAGE_UBC_FANS_GROUP_SET_TOP_VALUE = "top_on";
    public static final String MESSAGE_UBC_FANS_GROUP_SET_TYPE = "fans_group";
    public static final String MESSAGE_UBC_FANS_GROUP_SHOW_VALUE = "page_show";
    public static final String MESSAGE_UBC_FANS_SWAN = "swanfans_group";
    public static final String MESSAGE_UBC_FROM_RECEIVE_MESSAGE = "jieshouxiaoxi";
    public static final String MESSAGE_UBC_FROM_TIP_REFORM = "shuzitixing";
    public static final String MESSAGE_UBC_STRANGER_SET_PAGE = "moshengrenshezhiye";
    public static final String MESSAGE_UBC_STRANGER_SET_SOURCE = "moshengrenliebiaoye";
    public static final String MESSAGE_UBC_TRAINING_CAMP_GROUP = "training_camp";
    public static final String MSG_BUSINESS_SOURCE = "business_source";
    public static final String MSG_CATEGORY = "msg_category";
    public static final String MSG_CONTENT_TYPE = "content_type";
    public static final String MSG_HUDONG_CONTENT_TYPE = "hudong_content_type";
    public static final String MSG_HUDONG_RESOURCE_TYPE = "hudong_resource_type";
    public static final String MSG_HUDONG_TO_TYPE = "hudong_to_type";
    public static final String MSG_ID = "msgid";
    public static final String MSG_IM_LOG = "im_log";
    public static final String MSG_KEY = "msg_key";
    public static final String MSG_PAID = "paid";
    public static final String MSG_PA_CLASS_TYPE = "pa_class_type";
    public static final String MSG_PA_TYPE = "pa_type";
    public static final String MSG_SUB_PA_TYPE = "sub_pa_type";
    public static final String MSG_THIRD_ID = "third_id";
    public static final String NORMAL_GROUP_SHIED_UBCID = "163";
    public static final String PAGE_ACCOUNT_SETUP = "account_setup";
    public static final String PAGE_CONSULT_NAME = "consult";
    public static final String PAGE_DURATION_EVENT_ID = "4532";
    public static final int PAGE_ECOMMERCE_TYPE = 5;
    public static final String PAGE_GUANZHU_NAME = "guanzhuxiaoxi";
    public static final int PAGE_GUANZHU_TYPE = 1;
    public static final String PAGE_INFORMATION_NAME = "information";
    public static final int PAGE_INFORMATION_TYPE = 0;
    public static final String PAGE_INTERACTION_NAME = "hudong";
    public static final int PAGE_INTERACTION_TYPE = 3;
    public static final String PAGE_MARKET_NAME = "yingxiao";
    public static final int PAGE_MARKET_TYPE = 4;
    public static final String PAGE_NORMAL_GROUP_NAME = "normal_group";
    public static final String PAGE_STRANGER_NAME = "stranger";
    public static final int PAGE_STRANGER_TYPE = 2;
    public static final String PAGE_USER_SHIELD_CHAT = "chat";
    public static final String PAGE_USER_SHIELD_SETTING = "msg_set";
    public static final String SCREEN_EVENT_ID = "5735";
    public static final String SCREEN_FLOW_FETCH_BEGIN = "fetch_begin";
    public static final String SCREEN_FLOW_FETCH_END = "fetch_end";
    public static final String SCREEN_FLOW_FETCH_IM_BEGIN = "fetch_im_begin";
    public static final String SCREEN_FLOW_FETCH_IM_END = "fetch_im_end";
    public static final String SCREEN_FLOW_FETCH_MSG_BEGIN = "fetch_msg_begin";
    public static final String SCREEN_FLOW_FETCH_MSG_END = "fetch_msg_end";
    public static final String SCREEN_FLOW_FRAGMENT_BEGIN = "fragment_begin";
    public static final String SCREEN_FLOW_FRAGMENT_END = "fragment_end";
    public static final String SCREEN_FLOW_INIT_BEGIN = "init_begin";
    public static final String SCREEN_FLOW_INIT_END = "init_end";
    public static final String SCREEN_FLOW_PARSE_SESSION_BEGIN = "parse_session_begin";
    public static final String SCREEN_FLOW_PARSE_SESSION_END = "parse_session_end";
    public static final String SCREEN_FLOW_PASS_BEGIN = "pass_begin";
    public static final String SCREEN_FLOW_PASS_END = "pass_end";
    public static final String SCREEN_FLOW_SEM_FETCH_BEGIN = "fetch_sem_begin";
    public static final String SCREEN_FLOW_SEM_FETCH_END = "fetch_sem_end";
    public static final String SCREEN_FLOW_SEM_UPDATE_BEGIN = "update_sem_begin";
    public static final String SCREEN_FLOW_SEM_UPDATE_END = "update_sem_end";
    public static final String SCREEN_FLOW_SORT_BEGIN = "sort_begin";
    public static final String SCREEN_FLOW_SORT_END = "sort_end";
    public static final String SCREEN_FLOW_UPDATE_BEGIN = "update_begin";
    public static final String SCREEN_FLOW_UPDATE_END = "update_end";
    public static final String SCREEN_FLOW_UPDATE_THREAD_BEGIN = "update_thread_begin";
    public static final String SCREEN_FLOW_UPDATE_THREAD_END = "update_thread_end";
    public static final String SCREEN_FLOW_WEAK_REMIND_BEGIN = "weak_remind_begin";
    public static final String SCREEN_FLOW_WEAK_REMIND_END = "weak_remind_end";
    public static final String SERVICE_MESSAGE_UBC_CUID = "cuid";
    public static final String SERVICE_MESSAGE_UBC_FROM = "IM";
    public static final String SERVICE_MESSAGE_UBC_ID = "416";
    public static final String SERVICE_MESSAGE_UBC_KEY_ACCOUNT_TYPE = "account_type";
    public static final String SERVICE_MESSAGE_UBC_KEY_CHAT_TIME = "chat_time";
    public static final String SERVICE_MESSAGE_UBC_KEY_MSGS = "msgs";
    public static final String SERVICE_MESSAGE_UBC_KEY_PAID = "paid";
    public static final String SERVICE_MESSAGE_UBC_PAGE = "shoubaifuwuhao";
    public static final String SERVICE_MESSAGE_UBC_SOURCE = "2";
    public static final String SERVICE_MESSAGE_UBC_UID = "uid";
    public static final String SERVICE_MESSAGE_UBC_VALUE_CHAT_SHOW = "chat_show";
    public static final String SERVICE_MESSAGE_UBC_VALUE_MSG_CLICK = "msg_click";
    public static final String SERVICE_MESSAGE_UBC_VALUE_MSG_CLOSE = "msg_close";
    public static final String SERVICE_MESSAGE_UBC_VALUE_MSG_SHOW = "msg_show";
    public static final String SOURCE_NEWS_NODISTURB = "news_nodisturb";
    public static final String SOURCE_USER_SHIELD_SETTINGD_CLICK = "clk";
    public static final String SOURCE_USER_SHIELD_SETTINGD_SHOW = "show";
    public static final String STATISTIC_EXT_KEY = "ext";
    public static final String STATISTIC_FROM_KEY = "from";
    public static final String STATISTIC_PAGE_KEY = "page";
    public static final String STATISTIC_SOURCE_KEY = "source";
    public static final String STATISTIC_TYPE_KEY = "type";
    public static final String STATISTIC_VALUE_KEY = "value";
    private static final String TAG = "MessageStatisticUtils";
    public static final String TOP_UBC_VALUE_CLOSE = "top_close";
    public static final String TOP_UBC_VALUE_OPEN = "top_open";
    public static final String TYPE_C_USER = "c_user";
    public static final String TYPE_USER_SHIELD_SETTINGD = "c_user";
    public static final String UBC_AI_BANNER_SOURCE1 = "AI_banner_id1";
    public static final String UBC_AI_BANNER_SOURCE2 = "AI_banner_id2";
    public static final String UBC_AI_BANNER_TYPE = "AI_banner";
    public static final String UBC_DISCOVERY_MESSAGE_LIST = "163";
    public static final String UBC_DISCOVERY_QUNLIST = "4387";
    public static final String UBC_HUODONG_BANNER_TYPE = "huodong_banner";
    public static final String UBC_ID_163 = "163";
    public static final String UBC_QUN_BANNER_TYPE = "qun_banner";
    public static final String VALUE_CHAT_TIME = "chat_time";
    public static final String VALUE_CLOSE = "close";
    public static final String VALUE_CONFIRM = "confirm";
    public static final String VALUE_LIST_TIME = "list_time";
    public static final String VALUE_OPEN = "open";
    public static final String VALUE_SET_LIST_TIME = "listset_time";
    public static final String VALUE_SET_TIME = "set_time";
    public static final String VALUE_SHOW = "show";
    public static final String VALUE_USER_SHIELD_SETTINGD_OFF = "reject_chat";
    public static final String VALUE_USER_SHIELD_SETTINGD_ON = "accept_chat";

    public static void statisticServicePageShow(long paid) {
        Map<String, String> valueMaps = new HashMap<>();
        valueMaps.put("from", "IM");
        valueMaps.put("page", "shoubaifuwuhao");
        valueMaps.put("source", "2");
        valueMaps.put("value", SERVICE_MESSAGE_UBC_VALUE_CHAT_SHOW);
        JSONObject extObject = new JSONObject();
        try {
            extObject.put("chat_time", String.valueOf(System.currentTimeMillis()));
            extObject.put("paid", paid);
            if (((BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE)).isLogin()) {
                extObject.put("account_type", "uid");
            } else {
                extObject.put("account_type", "cuid");
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        valueMaps.put("ext", extObject.toString());
        UBC.onEvent("416", valueMaps);
    }

    public static void statisticMsgSetting(String page, String source, String type, String from, String value) {
        Map<String, String> valueMaps = new HashMap<>();
        valueMaps.put("page", page);
        valueMaps.put("type", type);
        valueMaps.put("source", source);
        valueMaps.put("from", from);
        valueMaps.put("value", value);
        UBC.onEvent("417", valueMaps);
    }

    public static void statisticMsgSetting(String page, String source, String type, String from, String value, String ext) {
        Map<String, String> valueMaps = new HashMap<>();
        valueMaps.put("page", page);
        valueMaps.put("type", type);
        valueMaps.put("source", source);
        valueMaps.put("from", from);
        valueMaps.put("value", value);
        if (!TextUtils.isEmpty(ext)) {
            valueMaps.put("ext", ext);
        }
        if (DEBUG) {
            Log.d(TAG, "statisticMsgSetting" + valueMaps);
        }
        UBC.onEvent("163", valueMaps);
    }

    public static void statisticUserShield(String page, String source, String type, String from, String value) {
        Map<String, String> valueMaps = new HashMap<>();
        valueMaps.put("page", page);
        valueMaps.put("type", type);
        valueMaps.put("source", source);
        valueMaps.put("from", from);
        valueMaps.put("value", value);
        UBC.onEvent("163", valueMaps);
    }

    public static void statisticFansGroupSetting(String page, String source, int type, String from, String value) {
        Map<String, String> valueMaps = new HashMap<>();
        valueMaps.put("page", page);
        valueMaps.put("type", getFansGroupUbcType(type));
        valueMaps.put("source", source);
        valueMaps.put("from", from);
        valueMaps.put("value", value);
        UBC.onEvent("4387", valueMaps);
    }

    public static void selectFriendListStatistic(String type, String page, String value, String ext) {
        Map<String, String> valueMaps = new HashMap<>();
        valueMaps.put("type", type);
        valueMaps.put("page", page);
        valueMaps.put("value", value);
        JSONObject extObject = new JSONObject();
        try {
            extObject.put("count", ext);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        valueMaps.put("ext", extObject.toString());
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubc != null) {
            ubc.onEvent("4387", valueMaps);
        }
    }

    public static String getFansGroupUbcType(int subType) {
        switch (subType) {
            case 0:
                return "fans_group";
            case 1:
                return "training_camp";
            case 2:
                return "fans_club";
            case 3:
                return MESSAGE_UBC_FANS_BCP;
            case 2000:
                return MESSAGE_UBC_FANS_SWAN;
            case 3000:
                return MESSAGE_UBC_FANS_ASK;
            default:
                return String.valueOf(subType);
        }
    }

    public static Flow beginFlow(String eventId) {
        if (DEBUG) {
            Log.d(TAG, "beginFlow ：" + eventId);
        }
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubc != null) {
            return ubc.beginFlow(eventId);
        }
        return null;
    }

    public static void addFlow(Flow flow, String content) {
        UBCManager ubc;
        if (DEBUG) {
            Log.d(TAG, "addFlow ：" + content);
        }
        if (flow != null && (ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            ubc.flowSetValueWithDuration(flow, content);
        }
    }

    public static void endFlow(Flow flow, String content) {
        UBCManager ubc;
        if (DEBUG) {
            Log.d(TAG, "flowSetValueWithDuration, endFlow :" + content);
        }
        if (flow != null && (ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            ubc.flowSetValueWithDuration(flow, content);
            ubc.flowEnd(flow);
        }
    }

    public static void addEvent(Flow flow, String id, String content) {
        UBCManager ubc;
        if (DEBUG) {
            Log.d(TAG, "addEvent, id :" + id + ", content :" + content);
        }
        if (flow != null && (ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)) != null) {
            if (TextUtils.isEmpty(content)) {
                ubc.flowAddEvent(flow, id);
            } else {
                ubc.flowAddEvent(flow, id, content);
            }
        }
    }

    public static String getScreenEndContent(String key, String source, boolean hasData) {
        JSONObject statisticsObject = new JSONObject();
        try {
            statisticsObject.put("from", "message");
            statisticsObject.put("type", MessageUtils.isBusinessAccount() ? "bjh" : "c_user");
            statisticsObject.put("source", TextUtils.isEmpty(source) ? "5" : source);
            statisticsObject.put("page", "SessionPage");
            JSONObject extObject = new JSONObject();
            extObject.put("sdk_version", ImSdkManager.getInstance(AppRuntime.getAppContext()).getImsdkVersion());
            String imuk = ImSdkManager.getInstance(AppRuntime.getAppContext()).getImUK();
            extObject.put("my_uk", imuk);
            String str = "0";
            extObject.put("im_status", ImSdkManager.getInstance(AppRuntime.getAppContext()).isIMLogined() ? str : "1");
            extObject.put("key", Config.MODEL + key + "_" + imuk);
            if (!hasData) {
                str = "1";
            }
            extObject.put("has_data", str);
            statisticsObject.put("ext", extObject.toString());
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "getScreenEndContent :", e2);
            }
        }
        return statisticsObject.toString();
    }

    public static String getSessionTimeStatistic(int payeType) {
        String page;
        JSONObject statisticsObject = new JSONObject();
        String type = "";
        switch (payeType) {
            case 1:
                page = "guanzhuxiaoxi";
                type = "bjh";
                break;
            case 2:
                page = "stranger";
                break;
            case 3:
                page = "hudong";
                break;
            case 4:
                page = "yingxiao";
                break;
            case 5:
                page = "dianshang";
                type = "dianshang";
                break;
            default:
                page = "information";
                break;
        }
        try {
            statisticsObject.put("from", MessageUtils.isBusinessAccount() ? "bjh" : "c_user");
            statisticsObject.put("value", VALUE_LIST_TIME);
            statisticsObject.put("page", page);
            statisticsObject.put("type", type);
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "getSessionTimeStatistic :", e2);
            }
        }
        return statisticsObject.toString();
    }

    public static String getSettingPageDurationStatistic(String page) {
        JSONObject statisticsObject = new JSONObject();
        try {
            statisticsObject.put("from", MessageUtils.isBusinessAccount() ? "bjh" : "c_user");
            statisticsObject.put("value", VALUE_SET_LIST_TIME);
            statisticsObject.put("page", page);
            statisticsObject.put("type", "");
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "getSettingPageDurationStatistic :", e2);
            }
        }
        return statisticsObject.toString();
    }

    public static String getGroupSetStatistic(boolean isNormal, int type) {
        String str;
        String str2;
        JSONObject statisticsObject = new JSONObject();
        try {
            String str3 = "bjh";
            if (MessageUtils.isBusinessAccount()) {
                str = str3;
            } else {
                str = "c_user";
            }
            statisticsObject.put("from", str);
            statisticsObject.put("value", VALUE_SET_TIME);
            if (isNormal) {
                str2 = "normal_group";
            } else {
                str2 = getFansGroupUbcType(type);
            }
            statisticsObject.put("page", str2);
            if (isNormal) {
                str3 = "c_user";
            }
            statisticsObject.put("type", str3);
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "getGroupSetStatistic :", e2);
            }
        }
        return statisticsObject.toString();
    }

    public static String getListSetStatistic(boolean isInfo) {
        JSONObject statisticsObject = new JSONObject();
        try {
            statisticsObject.put("from", MessageUtils.isBusinessAccount() ? "bjh" : "c_user");
            statisticsObject.put("value", VALUE_SET_LIST_TIME);
            statisticsObject.put("page", isInfo ? "information" : "stranger");
            statisticsObject.put("type", "");
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "getUserSetStatistic :", e2);
            }
        }
        return statisticsObject.toString();
    }

    public static String getUserSetStatistic(boolean isInfo) {
        String str;
        JSONObject statisticsObject = new JSONObject();
        try {
            if (MessageUtils.isBusinessAccount()) {
                str = "bjh";
            } else {
                str = "c_user";
            }
            statisticsObject.put("from", str);
            statisticsObject.put("value", VALUE_SET_TIME);
            statisticsObject.put("page", isInfo ? "information" : "stranger");
            statisticsObject.put("type", "c_user");
        } catch (JSONException e2) {
            if (DEBUG) {
                Log.e(TAG, "getUserSetStatistic :", e2);
            }
        }
        return statisticsObject.toString();
    }

    public static void statisticGroupShied(String type, String page, String value, String ubcid, String groupid) {
        String from = MessageUtils.isBusinessAccount() ? "bjh" : "c_user";
        Map<String, String> valueMaps = new HashMap<>();
        valueMaps.put("type", type);
        valueMaps.put("page", page);
        valueMaps.put("value", value);
        valueMaps.put("from", from);
        valueMaps.put("source", SOURCE_NEWS_NODISTURB);
        try {
            JSONObject obj = new JSONObject();
            obj.put(MessageStatistic.UBC_MESSAGE_EXT_CONTACTER_ID_KEY, groupid);
            valueMaps.put("ext", obj.toString());
        } catch (Exception e2) {
            if (DEBUG) {
                Log.d(TAG, e2.toString());
            }
        }
        if (DEBUG) {
            Log.d(TAG, "statisticGroupShied" + valueMaps);
        }
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubc != null) {
            ubc.onEvent(ubcid, valueMaps);
        }
    }

    public static void discoveryStatistic(String eventId, String page, String type, String value) {
        Map<String, String> valueMaps = new HashMap<>();
        if (!TextUtils.isEmpty(page)) {
            valueMaps.put("page", page);
        }
        if (!TextUtils.isEmpty(type)) {
            valueMaps.put("type", type);
        }
        if (!TextUtils.isEmpty(value)) {
            valueMaps.put("value", value);
        }
        if (DEBUG) {
            Log.d("discovery", "UBC_ID:" + eventId + ",data:" + new JSONObject(valueMaps).toString());
        }
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubc != null && !TextUtils.isEmpty(eventId)) {
            ubc.onEvent(eventId, valueMaps);
        }
    }

    public static void discoverMessageListStatistic(String value) {
        moreMenuAndItemMessageListStatistic("", value);
    }

    public static void bannerStatistic(String eventId, String page, String type, String value, String source, String ext) {
        Map<String, String> valueMaps = new HashMap<>();
        if (!TextUtils.isEmpty(page)) {
            valueMaps.put("page", page);
        }
        if (!TextUtils.isEmpty(type)) {
            valueMaps.put("type", type);
        }
        if (!TextUtils.isEmpty(value)) {
            valueMaps.put("value", value);
        }
        if (!TextUtils.isEmpty(source)) {
            valueMaps.put("source", source);
        }
        if (!TextUtils.isEmpty(ext)) {
            valueMaps.put("ext", ext);
        }
        if (DEBUG) {
            Log.d(TAG, "banner Statistic UBC_ID:" + eventId + ",data:" + new JSONObject(valueMaps).toString());
        }
        UBCManager ubc = (UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE);
        if (ubc != null && !TextUtils.isEmpty(eventId)) {
            ubc.onEvent(eventId, valueMaps);
        }
    }

    public static void moreMenuAndItemMessageListStatistic(String type, String value) {
        discoveryStatistic("163", "information", type, value);
    }

    public static void discoverGroupLstStatistic(String value) {
        discoveryStatistic("4387", DISCOVERY_PAGE_QUN_LIST, "", value);
    }

    public static void discoverGroupLstStatistic(String type, String value) {
        discoveryStatistic("4387", DISCOVERY_PAGE_QUN_LIST, type, value);
    }

    public static void showStatisticUnifiedBackBar(IUnifiedBottomBarExt bottomBar, String secondPage) {
        HashMap<String, String> map = new HashMap<>();
        map.put("from", "base");
        map.put("page", "im");
        try {
            map.put("ext", new JSONObject().put(UnifiedTopBarButton.UBC_EXT_KEY_SECOND_PAGE, secondPage).toString());
        } catch (Exception e2) {
        }
        UnifiedBottomBarExtKt.getBottomBar(bottomBar).onElementsShowEventStatistic(BottomBarElementID.ELEMENT_ID_BACK, map);
    }
}
