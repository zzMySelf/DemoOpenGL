package com.baidu.searchbox.ad.model;

import android.text.TextUtils;
import com.baidu.nadcore.model.NadSlidingTagModel;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.model.AppInfoModel;
import com.baidu.searchbox.feed.ui.drawerslide.SlideToFinishActivity;
import com.baidu.searchbox.home.tabs.constants.HomeTabIconBubbleConstants;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FeedAdOperate {
    public static final String SHOW_STATE_DEFAULT_BAR = "default";
    public static final String SHOW_STATE_LIKE_BAR = "like";
    public static final String TYPE_COMMAND = "command";
    public static final String TYPE_DOWNLOAD = "download";
    public AppInfoModel appInfo;
    public String btnIcon;
    public Button button;
    public String changeType;
    public Desc desc;
    public Enhancement enhancement;
    public String showState;
    public NadSlidingTagModel slidingTagModel;
    public String type;

    public static class Desc {
        public Icon icon;
        public String text;

        public static JSONObject toJson(Desc data) throws JSONException {
            if (data == null) {
                return null;
            }
            JSONObject object = new JSONObject();
            if (!TextUtils.isEmpty(data.text)) {
                object.put("text", data.text);
            }
            Icon icon2 = data.icon;
            if (icon2 != null) {
                object.put("icon", Icon.toJson(icon2));
            }
            return object;
        }

        public static Desc fromJson(JSONObject root) {
            if (root == null) {
                return null;
            }
            Desc desc = new Desc();
            desc.text = root.optString("text");
            desc.icon = Icon.fromJson(root.optJSONObject("icon"));
            return desc;
        }
    }

    public static class Button {
        public String backgroundColor;
        public String cmd;
        public boolean hasPrefetched;
        public String style;
        public String text;
        public String textColor;

        public boolean isValid() {
            return !TextUtils.isEmpty(this.text) && !TextUtils.isEmpty(this.cmd);
        }
    }

    public static class TransitionItem {
        public long delay;
        public long duration;
        public int style;

        public boolean isValid() {
            return this.style >= 0;
        }

        public static JSONObject toJson(TransitionItem data) throws JSONException {
            if (data == null) {
                return null;
            }
            JSONObject object = new JSONObject();
            object.put("style", data.style);
            object.put("delay", data.delay);
            object.put("duration", data.duration);
            return object;
        }

        public static TransitionItem fromJson(JSONObject root) {
            if (root == null) {
                return null;
            }
            TransitionItem transitionItem = new TransitionItem();
            transitionItem.style = root.optInt("style");
            transitionItem.delay = root.optLong("delay");
            transitionItem.duration = root.optLong("duration");
            return transitionItem;
        }
    }

    public static class Icon {
        public String dark;
        public String night;
        public String normal;

        public boolean isValid() {
            return !TextUtils.isEmpty(this.normal);
        }

        public static JSONObject toJson(Icon data) throws JSONException {
            if (data == null) {
                return null;
            }
            JSONObject object = new JSONObject();
            object.put("normal", data.normal);
            object.put("night", data.night);
            object.put("dark", data.dark);
            return object;
        }

        public static Icon fromJson(JSONObject root) {
            if (root == null) {
                return null;
            }
            Icon icon = new Icon();
            icon.normal = root.optString("normal");
            icon.night = root.optString("night");
            icon.dark = root.optString("dark");
            return icon;
        }
    }

    public static class Enhancement {
        public String backgroundColor;
        public long hasCountDownTime = 0;
        public NormandyTransitionState state;
        public List<TransitionItem> transition;

        public static Enhancement fromJson(JSONObject jsonObject) {
            if (jsonObject == null) {
                return null;
            }
            Enhancement enhancement = new Enhancement();
            JSONArray jsonArray = jsonObject.optJSONArray(SlideToFinishActivity.KEY_TRANSITION);
            if (jsonArray != null && jsonArray.length() > 0) {
                enhancement.transition = new ArrayList();
                for (int i2 = 0; i2 < jsonArray.length(); i2++) {
                    JSONObject oj = jsonArray.optJSONObject(i2);
                    if (oj != null) {
                        enhancement.transition.add(TransitionItem.fromJson(oj));
                    }
                }
            }
            enhancement.state = NormandyTransitionState.STATE_NONE;
            enhancement.backgroundColor = jsonObject.optString("backgroundColor");
            return enhancement;
        }

        public static JSONObject toJson(Enhancement data) {
            if (data == null) {
                return null;
            }
            try {
                JSONObject jsonObject = new JSONObject();
                List<TransitionItem> list = data.transition;
                if (list != null && list.size() > 0) {
                    JSONArray transition2 = new JSONArray();
                    for (int i2 = 0; i2 < data.transition.size(); i2++) {
                        transition2.put(TransitionItem.toJson(data.transition.get(i2)));
                    }
                    jsonObject.put(SlideToFinishActivity.KEY_TRANSITION, transition2);
                }
                if (!TextUtils.isEmpty(data.backgroundColor)) {
                    jsonObject.put("backgroundColor", data.backgroundColor);
                }
                return jsonObject;
            } catch (JSONException e2) {
                return null;
            }
        }

        public enum NormandyTransitionState {
            STATE_NONE(0),
            STATE_ONE(1),
            STATE_TWO(2);
            
            private final int value;

            private NormandyTransitionState(int value2) {
                this.value = value2;
            }
        }
    }

    private enum EnhancementChangeType {
        OPERATE("operate"),
        ENHANCEMENT("enhancement");
        
        /* access modifiers changed from: private */
        public final String value;

        private EnhancementChangeType(String value2) {
            this.value = value2;
        }
    }

    public boolean isButtonValid() {
        Button button2 = this.button;
        return button2 != null && button2.isValid();
    }

    public static JSONObject toJson(FeedAdOperate adOperate) {
        if (adOperate == null) {
            return null;
        }
        JSONObject o = new JSONObject();
        try {
            o.put("type", adOperate.type);
            Desc desc2 = adOperate.desc;
            if (desc2 != null) {
                o.put("desc", Desc.toJson(desc2));
            }
            String str = adOperate.showState;
            if (str != null) {
                o.put("show_state", str);
            }
            if (adOperate.button != null) {
                JSONObject b2 = new JSONObject();
                b2.put("text", adOperate.button.text);
                b2.put("cmd", adOperate.button.cmd);
                b2.put("style", adOperate.button.style);
                o.put("button", b2);
            }
            if (!TextUtils.isEmpty(adOperate.btnIcon)) {
                o.put("icon", adOperate.btnIcon);
            }
            AppInfoModel appInfoModel = adOperate.appInfo;
            if (appInfoModel != null) {
                o.put("app_info", AppInfoModel.toJson(appInfoModel));
            }
            Enhancement enhancement2 = adOperate.enhancement;
            if (enhancement2 != null) {
                o.put("enhancement", Enhancement.toJson(enhancement2));
            }
            if (!TextUtils.isEmpty(adOperate.changeType)) {
                o.put("operate_change_type", adOperate.changeType);
            }
            NadSlidingTagModel nadSlidingTagModel = adOperate.slidingTagModel;
            if (nadSlidingTagModel != null) {
                o.put("sliding_tag_label", NadSlidingTagModel.toJson(nadSlidingTagModel));
            }
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return o;
    }

    public static FeedAdOperate fromJson(JSONObject root) {
        if (root == null) {
            return null;
        }
        FeedAdOperate operate = new FeedAdOperate();
        operate.type = root.optString("type");
        operate.showState = root.optString("show_state", "default");
        JSONObject desc2 = root.optJSONObject("desc");
        if (desc2 != null) {
            operate.desc = Desc.fromJson(desc2);
        }
        JSONObject button2 = root.optJSONObject("button");
        if (button2 != null) {
            Button button3 = new Button();
            operate.button = button3;
            button3.cmd = button2.optString("cmd");
            operate.button.text = button2.optString("text");
            operate.button.style = button2.optString("style");
            operate.button.backgroundColor = button2.optString("backgroundColor");
            operate.button.textColor = button2.optString(HomeTabIconBubbleConstants.BUBBLE_TEXT_COLOR);
        }
        operate.btnIcon = root.optString("icon");
        JSONObject appInfoJsonObject = root.optJSONObject("app_info");
        if (appInfoJsonObject != null) {
            operate.appInfo = AppInfoModel.fromJson(appInfoJsonObject);
        }
        JSONObject enhancement2 = root.optJSONObject("enhancement");
        if (enhancement2 != null) {
            operate.enhancement = Enhancement.fromJson(enhancement2);
        }
        operate.changeType = root.optString("operate_change_type");
        if (!AdUtil.canShowTransition()) {
            if (TextUtils.equals(operate.changeType, EnhancementChangeType.OPERATE.value)) {
                return null;
            }
            if (TextUtils.equals(operate.changeType, EnhancementChangeType.ENHANCEMENT.value)) {
                operate.enhancement = null;
            }
        }
        operate.slidingTagModel = NadSlidingTagModel.fromJson(root.optJSONObject("sliding_tag_label"));
        return operate;
    }

    public boolean isDownload() {
        return TextUtils.equals(this.type, "download");
    }

    public boolean isCommand() {
        return TextUtils.equals(this.type, "command");
    }
}
