package com.baidu.searchbox.push.notification;

import android.util.SparseArray;
import com.baidu.searchbox.bridge.PushRuntime;
import com.baidu.searchbox.push.PushPreferenceUtils;
import com.baidu.searchbox.push.set.IMParam;

public class NotifySwitchCache {
    public static final int TYPE_IM = 1;
    public static final int TYPE_INNER_IM = 7;
    public static final int TYPE_INNER_IM_CHAT = 8;
    public static final int TYPE_INNER_IM_INTERACT = 9;
    public static final int TYPE_INNER_PUSH = 4;
    public static final int TYPE_MAIN_PUSH = 10;
    public static final int TYPE_NOTICE_IN_APP = 18;
    public static final int TYPE_NOTIFY_INTERACT = 15;
    public static final int TYPE_NOTIFY_SERVICE = 16;
    public static final int TYPE_NOTIFY_SUB = 14;
    public static final int TYPE_NOTIFY_SYSTEM = 17;
    public static final int TYPE_PL = 3;
    public static final int TYPE_PL_DETAIL = 5;
    public static final int TYPE_PUSH = 2;
    public static final int TYPE_PUSH_INTEREST = 12;
    public static final int TYPE_PUSH_NEWS = 11;
    @Deprecated
    public static final int TYPE_PUSH_SUBSCRIBE_INTEREST = 21;
    @Deprecated
    public static final int TYPE_PUSH_SUBSCRIBE_NEWS = 20;
    @Deprecated
    public static final int TYPE_PUSH_SUBSCRIBE_WEATHER = 22;
    public static final int TYPE_PUSH_WEATHER = 13;
    public static final int TYPE_STRANGER = 6;
    public static final int TYPE_SYSTEM_SETTING_PUSH = 19;
    private static SparseArray cacheArray;

    public static boolean isOpen(int type) {
        try {
            if (cacheArray == null) {
                cacheArray = new SparseArray();
            }
            if (cacheArray.get(type) != null) {
                return ((Boolean) cacheArray.get(type)).booleanValue();
            }
            boolean isOpen = readFromPreference(type);
            cacheArray.put(type, Boolean.valueOf(isOpen));
            return isOpen;
        } catch (Exception e2) {
            if (PushRuntime.GLOBAL_DEBUG) {
                e2.printStackTrace();
            }
            return readFromPreference(type);
        }
    }

    public static void setState(int type, boolean state) {
        if (cacheArray == null) {
            cacheArray = new SparseArray();
        }
        cacheArray.put(type, Boolean.valueOf(state));
        writeToPreference(type, state);
    }

    private static boolean readFromPreference(int type) {
        switch (type) {
            case 1:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_IM_NOTIFY, true);
            case 2:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_PUSH_NOTIFY, true);
            case 3:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_PL_NOTIFY, true);
            case 4:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_INNER_PUSH_NOTIFY, true);
            case 5:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_PL_DETAIL_NOTIFY, true);
            case 6:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_STRANGER_NOTIFY, true);
            case 7:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_INNER_IM_NOTIFY, true);
            case 8:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_INNER_CHAT_NOTIFY, true);
            case 9:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_RECEIVE_INNER_IM_INTERACT_NOTIFY, true);
            case 10:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_MAIN_PUSH, true);
            case 11:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_PUSH_NEWS, true);
            case 12:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_PUSH_INTEREST, true);
            case 13:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_PUSH_WEATHER, true);
            case 14:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_SUB, true);
            case 15:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_INTERACT, true);
            case 16:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_SERVICE, true);
            case 17:
                return PushPreferenceUtils.getInstance().getBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_SYSTEM, true);
            default:
                return true;
        }
    }

    private static void writeToPreference(int type, boolean state) {
        switch (type) {
            case 1:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_IM_NOTIFY, state);
                return;
            case 2:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_PUSH_NOTIFY, state);
                return;
            case 3:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_PL_NOTIFY, state);
                return;
            case 4:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_INNER_PUSH_NOTIFY, state);
                return;
            case 5:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_PL_DETAIL_NOTIFY, state);
                return;
            case 6:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_STRANGER_NOTIFY, state);
                return;
            case 7:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_INNER_IM_NOTIFY, state);
                return;
            case 8:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_INNER_CHAT_NOTIFY, state);
                return;
            case 9:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_RECEIVE_INNER_IM_INTERACT_NOTIFY, state);
                return;
            case 10:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_MAIN_PUSH, state);
                return;
            case 11:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_PUSH_NEWS, state);
                return;
            case 12:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_PUSH_INTEREST, state);
                return;
            case 13:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_PUSH_WEATHER, state);
                return;
            case 14:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_SUB, state);
                return;
            case 15:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_INTERACT, state);
                return;
            case 16:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_SERVICE, state);
                return;
            case 17:
                PushPreferenceUtils.getInstance().putBoolean(IMParam.KEY_MSG_SETTING_NOTIFY_SYSTEM, state);
                return;
            default:
                return;
        }
    }
}
