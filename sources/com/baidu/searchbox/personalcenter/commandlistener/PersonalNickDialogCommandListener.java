package com.baidu.searchbox.personalcenter.commandlistener;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.android.util.sp.PreferenceUtils;
import com.baidu.searchbox.net.update.CommandPostData;
import com.baidu.searchbox.net.update.v2.AbstractCommandListener;
import com.baidu.searchbox.net.update.v2.ActionData;
import org.json.JSONException;

public class PersonalNickDialogCommandListener extends AbstractCommandListener<PersonalNickDialogCommand> {
    public static final String COMMAND_ACTION = "nickswitch";
    public static final boolean DEF_PERSONAL_HEAD_ICON_DIALOG_SWITCH_KEY = false;
    public static final boolean DEF_PERSONAL_NICKNAME_DIALOG_SWITCH_KEY = true;
    public static final boolean DEF_PERSONAL_NICKNAME_HEAD_ICON_DIALOG_SWITCH_KEY = true;
    public static final String PREF_PERSONAL_HEAD_ICON_DIALOG_SWITCH_KEY = "PREF_PERSONAL_HEAD_ICON_DIALOG_SWITCH_KEY";
    public static final String PREF_PERSONAL_NICKNAME_DIALOG_SWITCH_KEY = "PREF_PERSONAL_NICKNAME_DIALOG_SWITCH_KEY";
    public static final String PREF_PERSONAL_NICKNAME_HEAD_ICON_DIALOG_SWITCH_KEY = "PREF_PERSONAL_NICKNAME_HEAD_ICON_DIALOG_SWITCH_KEY";
    private static final String SWITCHER_CLOSE = "0";
    private static final String SWITCHER_OPEN = "1";

    public void addPostData(Context context, String module, String action, CommandPostData postData) throws JSONException {
        if (postData != null && postData.getVersion() != null) {
            postData.getVersion().put(COMMAND_ACTION, getLocalVersion(context, module, action));
        }
    }

    public boolean executeCommand(Context context, String module, String action, ActionData<PersonalNickDialogCommand> value) {
        boolean headIconSwitcher;
        if (value == null || value.data == null || !TextUtils.equals(action, COMMAND_ACTION) || TextUtils.isEmpty(value.version) || TextUtils.equals(value.version, getLocalVersion(context, module, action))) {
            return false;
        }
        try {
            String dialogSwitchNickName = ((PersonalNickDialogCommand) value.data).dialogSwitchNickName;
            boolean nickNameSwitcher = true;
            if ("1".equals(dialogSwitchNickName)) {
                nickNameSwitcher = true;
            } else if ("0".equals(dialogSwitchNickName)) {
                nickNameSwitcher = false;
            }
            PreferenceUtils.setBoolean(PREF_PERSONAL_NICKNAME_DIALOG_SWITCH_KEY, nickNameSwitcher);
            String dialogSwitchHeadIcon = ((PersonalNickDialogCommand) value.data).dialogSwitchHeadIcon;
            if ("1".equals(dialogSwitchHeadIcon)) {
                headIconSwitcher = true;
            } else {
                "0".equals(dialogSwitchHeadIcon);
                headIconSwitcher = false;
            }
            PreferenceUtils.setBoolean(PREF_PERSONAL_HEAD_ICON_DIALOG_SWITCH_KEY, headIconSwitcher);
            String dialogSwitchNickNameHeadIcon = ((PersonalNickDialogCommand) value.data).dialogSwitchNickNameHeadIcon;
            boolean nickNameHeadIconSwitcher = true;
            if ("1".equals(dialogSwitchNickNameHeadIcon)) {
                nickNameHeadIconSwitcher = true;
            } else if ("0".equals(dialogSwitchNickNameHeadIcon)) {
                nickNameHeadIconSwitcher = false;
            }
            PreferenceUtils.setBoolean(PREF_PERSONAL_NICKNAME_HEAD_ICON_DIALOG_SWITCH_KEY, nickNameHeadIconSwitcher);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        PreferenceUtils.setString(PersonalCenterCommandUtil.getActionVersionSpKey(COMMAND_ACTION), value.version);
        return true;
    }

    public String getLocalVersion(Context context, String module, String action) {
        return PreferenceUtils.getString(PersonalCenterCommandUtil.getActionVersionSpKey(COMMAND_ACTION), "0");
    }
}
