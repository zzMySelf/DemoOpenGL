package com.baidu.searchbox.account.userinfo.parser;

import android.util.Log;
import com.baidu.android.util.io.BaseJsonData;
import com.baidu.android.util.io.StreamUtils;
import com.baidu.searchbox.account.userinfo.data.GroupQrcodeInfoResult;
import com.baidu.searchbox.bridge.UserInfoRuntime;
import com.baidu.searchbox.net.common.IResponseParser;
import java.io.InputStream;
import org.json.JSONObject;

public class GroupQrcodeInfoResultParser implements IResponseParser<InputStream, GroupQrcodeInfoResult> {
    private static final boolean DEBUG = UserInfoRuntime.GLOBAL_DEBUG;
    private static final String KEY_EXPIRE = "expire";
    private static final String KEY_QRCODE_URL = "qrcode_url";
    private static final String TAG = GroupQrcodeInfoResultParser.class.getSimpleName();

    public GroupQrcodeInfoResult parseResponse(InputStream result) {
        if (result != null) {
            String json = StreamUtils.streamToString(result);
            if (DEBUG) {
                Log.i(TAG, "parseResponse result:" + json);
            }
            BaseJsonData pageData = BaseJsonData.fromJson(json);
            if (pageData == null || pageData.getErrorCode() != 0) {
                return null;
            }
            JSONObject jsonData = pageData.getData();
            GroupQrcodeInfoResult groupQrcodeInfoResult = null;
            if (jsonData == null) {
                return null;
            }
            try {
                long expire = jsonData.getLong("expire");
                String qrcodeUrl = jsonData.getString(KEY_QRCODE_URL);
                groupQrcodeInfoResult = new GroupQrcodeInfoResult();
                groupQrcodeInfoResult.setExpireTime(expire);
                groupQrcodeInfoResult.setmQrcodeUrl(qrcodeUrl);
                return groupQrcodeInfoResult;
            } catch (Exception e2) {
                if (!DEBUG) {
                    return groupQrcodeInfoResult;
                }
                Log.e(TAG, "parseResponse error e:" + e2);
                return groupQrcodeInfoResult;
            }
        } else {
            if (DEBUG) {
                Log.i(TAG, "parseResponse result is null");
            }
            return null;
        }
    }
}
