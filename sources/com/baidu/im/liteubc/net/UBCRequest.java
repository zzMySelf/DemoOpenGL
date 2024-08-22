package com.baidu.im.liteubc.net;

import android.content.Context;
import com.baidu.im.liteubc.IMLiteUBC;
import com.baidu.im.liteubc.utils.Constants;
import com.baidu.im.liteubc.utils.LogUtils;
import com.baidu.im.liteubc.utils.Utils;
import com.baidu.searchbox.gamecore.util.GameCenterUtils;
import com.baidu.searchbox.log.sender.upload.BIMUploadConstants;
import java.util.HashMap;
import java.util.Map;

public class UBCRequest implements IRequest, IResponseHandler {
    private static final String APP_NAME = "imsdk";
    private static final String CONTENT_TYPE_VALUE = "application/octet-stream";
    private static final String DEBUG_URL = "http://bjyz-mco-searchbox201609-m12xi3-044.bjyz.baidu.com:8080/ztbox";
    private static final String METHOD = "POST";
    private static final String ONLINE_URL = "https://tcbox.baidu.com/ztbox";
    private static final String TAG = "UBCRequest";
    private final Context mContext;

    public UBCRequest(Context context) {
        this.mContext = context;
    }

    public String getHost() {
        String url = ONLINE_URL;
        if (IMLiteUBC.getInstance().getEnv() != Constants.ONLINE) {
            url = DEBUG_URL;
        }
        return url + GameCenterUtils.SCHEME_SWAN_SUFFIX + getParam();
    }

    public String getMethod() {
        return "POST";
    }

    public byte[] getRequestParameter() {
        return null;
    }

    public String getContentType() {
        return "application/octet-stream";
    }

    public Map<String, String> getHeaders() {
        HashMap<String, String> headerMap = new HashMap<>();
        headerMap.put(BIMUploadConstants.NB, "1");
        return headerMap;
    }

    private String getParam() {
        StringBuilder sb = new StringBuilder();
        sb.append("action=").append("zubc");
        sb.append("&appname=").append(APP_NAME);
        sb.append("&uid=").append(IMLiteUBC.getInstance().getCuid());
        sb.append("&ua=").append(Utils.getUA(this.mContext));
        sb.append("&appversion=").append(Utils.getVersionName(this.mContext));
        if (IMLiteUBC.getInstance().getEnv() != Constants.ONLINE) {
            sb.append("&debug=").append("1");
        }
        return sb.toString();
    }

    public void onSuccess(int errorCode, byte[] resultContent) {
        LogUtils.d(TAG, "ubc upload errorcode:" + errorCode + ", resultContent:" + new String(resultContent));
    }

    public void onFailure(int errorCode, byte[] resultContent) {
        LogUtils.d(TAG, "ubc upload errorcode:" + errorCode + ", resultContent:" + new String(resultContent));
    }
}
