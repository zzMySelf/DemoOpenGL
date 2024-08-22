package com.baidu.searchbox.reactnative;

import org.json.JSONException;
import org.json.JSONObject;

public class RNSearchBoxCmdConfig {
    public static final String BAINUO_HOME_CMD = "{\"mode\": \"7\",\"commands\": [{\"mode\": \"6\",\"intent\": \"intent:#Intent;S.rn_search_box_key=6;S.rn_bundle_id=box.rnplugin.bainuo;S.rn_component_name=BaiNuoSdk;end\",\"class\": \"com.baidu.searchbox.reactnative.RNSearchBoxMainActivity\",\"min_v\": \"16786176\"},{\"mode\": \"0\",\"intent\": \"intent:#Intent;end\",\"class\": \"com.baidu.bainuosdk.nuomi.NuomiHomeActivity\",\"min_v\": \"16786176\"}],\"min_v\": \"16786176\"}";
    public static final String MY_ATTENTION_CMD = "{\"mode\": \"7\",\"commands\": [{\"mode\": \"6\",\"intent\": \"intent:#Intent;S.rn_search_box_key=6;S.rn_bundle_id=box.rnplugin.myattention;S.rn_component_name=MyAttention;end\",\"class\": \"com.baidu.searchbox.reactnative.RNSearchBoxMainActivity\",\"min_v\": \"16786176\"},{\"mode\": \"0\",\"intent\": \"intent:#Intent;S.user_sub_center_load_url=/webpage?action=icard&type=subscribe;B.launch_center=true;B.user_sub_center_search_enable=false;B.create_menu_key=false;end\",\"class\": \"com.baidu.searchbox.xsearch.UserSubscribeCenterActivity\",\"dyna_url_key\":\"user_sub_center_load_url\",\"http_style\":true,\"min_v\": \"16786176\"}],\"min_v\": \"16786176\"}";
    public static final String SKIN_CENTER_CMD = "{\"mode\": \"7\",\"commands\": [{\"mode\": \"6\",\"intent\": \"intent:#Intent;S.rn_search_box_key=6;S.rn_bundle_id=box.rnplugin.skincenter;S.rn_component_name=SkinCenter;end\",\"class\": \"com.baidu.searchbox.reactnative.RNSearchBoxMainActivity\",\"min_v\": \"16786176\"},{\"mode\": \"0\",\"intent\": \"intent:#Intent;end\",\"class\": \"com.baidu.searchbox.theme.skin.SkinCenterNewActivity\",\"min_v\": \"16786176\"}],\"min_v\": \"16786176\"}";
    public static final String VIDEO_HOME_CMD = "{\"mode\": \"7\",\"commands\": [{\"mode\": \"6\",\"intent\": \"intent:#Intent;S.rn_search_box_key=6;S.rn_bundle_id=box.rnplugin.videohome;S.rn_component_name=VideoHome;end\",\"class\": \"com.baidu.searchbox.reactnative.RNSearchBoxMainActivity\",\"min_v\": \"16786176\"},{\"mode\": \"0\",\"intent\":\"intent:#Intent;S.bdsb_light_start_url=http%3A%2F%2Fvideo.m.baidu.com%2F%3Fentry%3Dbox_nav;B.bdsb_append_param=true;i.extra_actionbar_color_id=-13421773;end\",\"class\":\"com.baidu.searchbox.video.VideoHomeActivity\",\"min_v\":\"16787968\"}],\"min_v\": \"16786176\"}";

    public static JSONObject toJSON(String objString) {
        try {
            return new JSONObject(objString);
        } catch (JSONException e2) {
            e2.printStackTrace();
            return null;
        }
    }
}
