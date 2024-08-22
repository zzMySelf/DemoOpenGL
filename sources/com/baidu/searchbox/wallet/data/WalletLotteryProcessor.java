package com.baidu.searchbox.wallet.data;

import android.content.Context;
import android.text.TextUtils;
import com.baidu.searchbox.bdprofile.UserProfileNoticeLoader;
import com.baidu.searchbox.bdprofile.UserProfileNoticeParser;
import org.json.JSONException;
import org.json.JSONObject;

public class WalletLotteryProcessor implements UserProfileNoticeLoader.UserProfileNoticeProcessor {
    private static final String KEY_ITEM_HINT = "hint";
    private static final String KEY_ITEM_ID = "id";
    private static final String KEY_ITEM_STATUS = "status";
    private static final String KEY_ITEM_TYPE = "type";
    private static final String PARAM_PASSPORTID = "passportid";
    public static final int STATUS_LOTTERY_SHOT = 1;
    public static final String TYPE_LOTTERY = "lottery";

    public void process(Context context, String userid, UserProfileNoticeParser.UserProfileNoticeItem item) {
        if (TextUtils.equals("lottery", item.getType())) {
            try {
                JSONObject jsonObject = item.getItemJson();
                String id = jsonObject.has("id") ? jsonObject.getString("id") : "0";
                int i2 = 0;
                if (jsonObject.has("status")) {
                    i2 = jsonObject.optInt("status", 0);
                }
                int status = i2;
                String hint = jsonObject.has("hint") ? jsonObject.getString("hint") : "";
                if (status == 1) {
                    WalletLotteryManager.getInstance().setWinLotteryServiceId(id);
                    WalletLotteryManager.getInstance().setWinLotteryHint(hint);
                    WalletLotteryManager.getInstance().notifyDataChange();
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void getPostData(Context context, String userid, JSONObject postParam) throws JSONException {
        JSONObject userParam = new JSONObject();
        userParam.put(PARAM_PASSPORTID, userid);
        postParam.put("lottery", userParam);
    }
}
