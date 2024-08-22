package com.baidu.searchbox.message.interactionupgrade.ubc;

import android.text.TextUtils;
import com.baidu.searchbox.bridge.MessageRuntime;
import com.baidu.searchbox.card.InteractCardUpgradeView;

public class InteractionUpgradeParamsUtil {
    private static final boolean DEBUG = MessageRuntime.GLOBAL_DEBUG;
    public static final int DEFAULT_ERROR = -1;
    public static final String PUSH_SOURCE = "5";
    public static final int REQUEST_COUNT_DEFAULT = 20;
    public static final int TEMPLATE_TYPE_INTERACT_NOTIFY = 3;
    private static final String TYPE_AITE = "at";
    private static final String TYPE_COLLECTION = "shoucang";
    private static final String TYPE_DINGYUE = "dingyue";
    private static final String TYPE_FEED_TRUSTED = "feed_trusted";
    private static final String TYPE_GUANZHU = "guanzhu";
    private static final String TYPE_PINGLUN = "pinglun";
    private static final String TYPE_PINGLUN_AT = "pinglun@";
    private static final String TYPE_PINGLUN_DIANZAN = "pinglun_dianzan";
    private static final String TYPE_PINGLUN_HUIFU = "pinglun_huifu";
    private static final String TYPE_PINGLUN_TOP = "pinglun_top";
    private static final String TYPE_TOUPIAOXIAOXI = "toupiaoxiaoxi";
    private static final String TYPE_VISITOR = "visit";
    private static final String TYPE_ZAN = "dianzan";

    public static String changeAction2Type(String action) {
        if (action == null) {
            return "";
        }
        if (TextUtils.equals("visitor", action)) {
            return "visit";
        }
        if (TextUtils.equals("follow", action)) {
            return "guanzhu";
        }
        if (TextUtils.equals("zan", action)) {
            return TYPE_ZAN;
        }
        if (TextUtils.equals("zan_comment", action) || TextUtils.equals(InteractCardUpgradeView.ACTION_ZAN_COMMENT_REPLY, action)) {
            return TYPE_PINGLUN_DIANZAN;
        }
        if (TextUtils.equals("collection", action)) {
            return TYPE_COLLECTION;
        }
        if (TextUtils.equals("comment", action)) {
            return TYPE_PINGLUN;
        }
        if (TextUtils.equals("comment_reply", action)) {
            return TYPE_PINGLUN_HUIFU;
        }
        if (TextUtils.equals("comment_favor", action)) {
            return TYPE_PINGLUN_TOP;
        }
        if (TextUtils.equals(InteractCardUpgradeView.ACTION_COMMENT_AT, action)) {
            return TYPE_PINGLUN_AT;
        }
        if (TextUtils.equals(InteractCardUpgradeView.ACTION_GENGXINTIXING, action)) {
            return TYPE_DINGYUE;
        }
        if (TextUtils.equals("@", action)) {
            return "at";
        }
        if (TextUtils.equals("vote", action)) {
            return "toupiaoxiaoxi";
        }
        if (TextUtils.equals("feed_trusted", action)) {
            return "feed_trusted";
        }
        return "";
    }
}
