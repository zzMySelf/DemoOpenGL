package com.baidu.searchbox.push.mymessagefragment.util;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.account.BoxAccountManager;
import com.baidu.ubc.UBCManager;
import java.util.Map;
import org.json.JSONObject;

public class PushNotifyUBCUtil {
    public static final String FROM = "notice";
    public static final String PUSH_NOTICE_ID = "416";
    public static final String UBC_ACCOUNT_SOURCE_VALUE = "personal_notice";
    public static final String UBC_ALL_CLICK_KEY = "all_shaixuan";
    public static final String UBC_BUSINESS_SOURCE_KEY = "business_source";
    public static final String UBC_CANCEL_SUBSCRIBE = "cancel_subscribe";
    public static final String UBC_CANCLE_PRAISE_CLICK_KEY = "cancel_praise_click";
    public static final String UBC_CONTENT_TYPE_KEY = "content_type";
    public static final String UBC_FOLLOW_CLICK_KEY = "follow_click";
    public static final String UBC_FUWU_CLICK_KEY = "fuwu_shaixuan";
    public static final String UBC_HOME_CLICK_KEY = "home_click";
    public static final String UBC_HUIFU_CLICK_KEY = "huifu_click";
    public static final String UBC_JIESHOU_KEY = "jieshou_click";
    public static final String UBC_JUHE_CLICK_KEY = "juhe_click";
    public static final String UBC_JUSHOU_KEY = "jushou_click";
    public static final String UBC_MSGID_KEY = "msgid";
    public static final String UBC_MSG_CATEGORY_KEY = "msg_category";
    public static final String UBC_MSG_CLICK_KEY = "msg_click";
    public static final String UBC_MSG_KEY_KEY = "msg_key";
    public static final String UBC_MSG_SHOW_KEY = "msg_show";
    public static final String UBC_NOTIFY_LONE_PRESS_DEL_KEY = "delete";
    public static final String UBC_NOTIFY_LONE_PRESS_KEY = "press";
    public static final String UBC_PAGE_BAIJIAHAO_KEY = "baijiahao";
    public static final String UBC_PAGE_HUDONG_KEY = "hudong";
    public static final String UBC_PAGE_SHANGYE_KEY = "shangye";
    public static final String UBC_PAGE_SHOUBAIFUWUHAO_KEY = "shoubaifuwuhao";
    public static final String UBC_PAGE_SHOW_KEY = "page_show";
    public static final String UBC_PAGE_XIAOCHENGXU_KEY = "xiaochengxu";
    public static final String UBC_PAGE_XIONGZHANGHAO_KEY = "xiongzhanghao";
    public static final String UBC_PAID_KEY = "paid";
    public static final String UBC_PA_CLASS_TYPE_KEY = "pa_class_type";
    public static final String UBC_PA_TYPE_KEY = "pa_type";
    public static final String UBC_PICTURE_CLICK_KEY = "picture_click";
    public static final String UBC_PINGLUN_SHAIXUAN_KEY = "pinglun_shaixuan";
    public static final String UBC_PRAISE_CLICK_KEY = "praise_click";
    public static final String UBC_PUSH_ACCOUNT_TYPE_KEY = "account_type";
    public static final String UBC_PUSH_CUID_KEY = "cuid";
    public static final String UBC_PUSH_EXT_KEY = "ext";
    public static final String UBC_PUSH_FROM_KEY = "from";
    public static final String UBC_PUSH_PAGE_KEY = "page";
    public static final String UBC_PUSH_SOURCE_KEY = "source";
    public static final String UBC_PUSH_TYPE_KEY = "type";
    public static final String UBC_PUSH_UID_KEY = "uid";
    public static final String UBC_PUSH_VALUE_KEY = "value";
    public static final String UBC_QITA_CLICK_KEY = "qita_shaixuan";
    public static final String UBC_SUBSCRIBE = "subscribe";
    public static final String UBC_SUBSCRIBLE_CLICK_KEY = "dingyue_shaixuan";
    public static final String UBC_SUB_PA_TYPE_KEY = "sub_pa_type";
    public static final String UBC_THIRD_ID_KEY = "third_id";
    public static final String UBC_TOUXIANG_CLICK_KEY = "touxiang_click";
    public static final String UBC_TYPE_AITEXIAOXI_KEY = "aitexiaoxi";
    public static final String UBC_TYPE_BIAODANXIAOXI_KEY = "biaodanxiaoxi";
    public static final String UBC_TYPE_DIANZANXIAOXI_KEY = "dianzanxiaoxi";
    public static final String UBC_TYPE_DINGDANXIAOXI_KEY = "dingdanxiaoxi";
    public static final String UBC_TYPE_DINGYUEXIAOXI_KEY = "dingyuexiaoxi";
    public static final String UBC_TYPE_FOLLOWXIAOXI_KEY = "followxiaoxi";
    public static final String UBC_TYPE_PINGLUNXIAOXI_KEY = "pinglunxiaoxi";
    public static final String UBC_TYPE_SHEQUHUITIE_KEY = "shequhuitie";
    public static final String UBC_TYPE_TOUPIAOXIAOXI_KEY = "toupiaoxiaoxi";
    public static final String UBC_TYPE_XITONGXIAOXI_KEY = "xitongxiaoxi";
    public static final String UBC_XITONG_CLICK_KEY = "xitong_shaixuan";
    public static final String UBC_ZIYUAN_CLICK_KEY = "ziyuan_click";

    public static void pushDetailUBCEvent(String type, String page, String source, String value, Map<String, String> otherParams) {
        BoxAccountManager loginManager = (BoxAccountManager) ServiceManager.getService(BoxAccountManager.SERVICE_REFERENCE);
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("from", "notice");
            jsonObject.put("type", type);
            jsonObject.put("page", page);
            jsonObject.put("source", source);
            jsonObject.put("value", value);
            JSONObject extObject = new JSONObject();
            if (loginManager != null) {
                if (loginManager.isLogin()) {
                    extObject.put("account_type", "uid");
                    if (!(otherParams == null || otherParams.get("msgs") == null)) {
                        extObject.put("msgs", otherParams.get("msgs"));
                    }
                    jsonObject.putOpt("ext", extObject);
                    ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("416", jsonObject.toString());
                }
            }
            extObject.put("account_type", "cuid");
            extObject.put("msgs", otherParams.get("msgs"));
            jsonObject.putOpt("ext", extObject);
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent("416", jsonObject.toString());
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
