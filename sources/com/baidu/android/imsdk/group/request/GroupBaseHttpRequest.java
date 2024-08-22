package com.baidu.android.imsdk.group.request;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.utils.BaseHttpRequest;
import com.baidu.android.imsdk.utils.Utility;
import java.util.HashMap;
import java.util.Map;

public abstract class GroupBaseHttpRequest extends BaseHttpRequest {
    public Map<String, String> getHeaders() {
        Map<String, String> map = new HashMap<>();
        map.put("Cookie", "BDUSS=" + IMConfigInternal.getInstance().getIMConfig(this.mContext).getBduss(this.mContext));
        return map;
    }

    public String getMethod() {
        return "POST";
    }

    public String getHost() {
        if (getHostUrl() == null) {
            return null;
        }
        return getHostUrl() + "rest/2.0/im/groupchat";
    }

    public String getHostUrl() {
        switch (Utility.readIntData(this.mContext, Constants.KEY_ENV, 0)) {
            case 0:
                return "https://pim.baidu.com/";
            case 1:
                return "http://rd-im-server.bcc-szth.baidu.com:8080/";
            case 2:
                return Constants.URL_HTTP_QA;
            case 3:
                return Constants.URL_HTTP_BOX;
            default:
                return null;
        }
    }
}
