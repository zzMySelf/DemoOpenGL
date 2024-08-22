package com.baidu.searchbox.cloudcommand.processor;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.util.UniKV;
import com.baidu.pyramid.annotation.component.DefaultListHolder;
import com.baidu.pyramid.annotation.component.ListHolder;
import com.baidu.searchbox.cloudcommand.dao.CloudCommandDao;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.config.AppConfig;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class CloudCommandProcessor implements ICloudControlProcessor {
    static final String COMMAND_CLOUD_VERSION = "command_cloudconfig_version";
    private static final String COMMAND_KEY = "command";
    private static final String COMMAND_VERSION_ASC_DEFAULT = "0";
    private static final String COMMAND_VERSION_DEFAULT = "0";
    private static final String COMMAND_VERSION_KEY = "step";
    private static final String KEY_COUNT = "count";
    private static final String KEY_DATA = "data";
    private static final String KEY_ITEMS = "items";
    private static final String KEY_LIST = "list";
    private static final String KEY_MSG_ID = "msgid";
    private static final String KEY_PRODUCT = "product";
    private static final String KEY_TYPE = "type";
    private static final String KEY_VALID = "valid";
    private static final String KEY_VERSION = "version";
    private static final String SP_COMMAND_FILE_NAME = "com.baidu.searchbox_cloud_command";
    private static final String TAG = "CloudCommandProcessor";
    private static final String VALUE_FILTER = "2";
    private static final String VALUE_INVALID = "0";
    private static final String VALUE_SUC = "1";
    ListHolder<ICloudCommandObserver> mCloudCommandObservers;

    public void initmCloudCommandObservers() {
        DefaultListHolder create = DefaultListHolder.create();
        this.mCloudCommandObservers = create;
        create.setList(new ICloudCommandObserver_CloudCommandProcessor_ListProvider());
    }

    public CloudCommandProcessor() {
        initmCloudCommandObservers();
    }

    public void processServiceData(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack cloudControlUBCCallBack) throws JSONException {
        JSONObject serviceData = cloudControlResponseInfo.getServiceData();
        if (serviceData != null) {
            String step = serviceData.optString("step");
            if (!TextUtils.isEmpty(step)) {
                sharedPrefsWrapper().putString(COMMAND_CLOUD_VERSION, step);
            }
            JSONArray commandList = serviceData.optJSONArray("list");
            if (commandList != null) {
                handleReceiveCommand(commandList, cloudControlUBCCallBack);
                if (AppConfig.isDebug()) {
                    Log.d(TAG, "service data " + serviceData);
                }
            }
        }
    }

    public CloudControlRequestInfo getPostData(String runType, boolean isDegradeTime, JSONObject degradeJsonObject) {
        if (degradeJsonObject != null && degradeJsonObject.length() == 0) {
            return null;
        }
        String step = sharedPrefsWrapper().getString(COMMAND_CLOUD_VERSION, "0");
        JSONObject filterJson = new JSONObject();
        try {
            filterJson.put("step", step);
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        return new CloudControlRequestInfo("command", (Object) null, (HashMap<String, String>) null, "", filterJson);
    }

    private static UniKV sharedPrefsWrapper() {
        return new UniKV(SP_COMMAND_FILE_NAME);
    }

    private void handleReceiveCommand(JSONArray commandList, ICloudControlUBCCallBack cloudControlUBCCallBack) throws JSONException {
        int total;
        ICloudControlUBCCallBack iCloudControlUBCCallBack = cloudControlUBCCallBack;
        int total2 = 0;
        int success = 0;
        int filter = 0;
        JSONObject commandUBCObj = new JSONObject();
        JSONArray commandUBCArray = new JSONArray();
        for (int index = 0; index < commandList.length(); index++) {
            JSONObject commandJson = commandList.optJSONObject(index);
            JSONObject commandUBC = new JSONObject();
            if (commandJson != null) {
                int total3 = total2 + 1;
                String commandType = commandJson.optString("type");
                String msgID = commandJson.optString("msgid");
                String version = commandJson.optString("version");
                JSONObject commandData = commandJson.optJSONObject("data");
                commandUBC.put("product", commandType);
                commandUBC.put("version", msgID);
                if (TextUtils.isEmpty(commandType) || TextUtils.isEmpty(msgID)) {
                    total = total3;
                    JSONObject jSONObject = commandData;
                    String str = msgID;
                } else if (TextUtils.isEmpty(version)) {
                    total = total3;
                    JSONObject jSONObject2 = commandData;
                    String str2 = msgID;
                } else {
                    int total4 = total3;
                    if (CloudCommandDao.getInstance().queryDispatched(msgID, 1).size() <= 0) {
                        ICloudCommandObserver commandReceiver = getCommandObserver(commandType);
                        if (commandReceiver != null) {
                            commandReceiver.dispatch(commandData);
                            ICloudCommandObserver iCloudCommandObserver = commandReceiver;
                            JSONObject jSONObject3 = commandData;
                            String str3 = msgID;
                            CloudCommandDao.getInstance().addCommand(commandType, msgID, 1, version, System.currentTimeMillis());
                            success++;
                            commandUBC.put("valid", "1");
                        } else {
                            JSONObject jSONObject4 = commandData;
                            String str4 = msgID;
                            commandUBC.put("valid", "0");
                        }
                    } else {
                        JSONObject jSONObject5 = commandData;
                        String str5 = msgID;
                        filter++;
                        commandUBC.put("valid", "2");
                    }
                    commandUBCArray.put(commandUBC);
                    total2 = total4;
                }
                commandUBC.put("valid", "0");
                commandUBCArray.put(commandUBC);
                total2 = total;
            }
        }
        JSONArray jSONArray = commandList;
        commandUBCObj.put("count", String.format("%s,%s,%s", new Object[]{Integer.valueOf(total2), Integer.valueOf(success), Integer.valueOf(filter)}));
        commandUBCObj.put("items", commandUBCArray);
        if (iCloudControlUBCCallBack != null) {
            iCloudControlUBCCallBack.setServiceInfo(commandUBCObj);
        }
    }

    private ICloudCommandObserver getCommandObserver(String commandType) {
        ListHolder<ICloudCommandObserver> listHolder = this.mCloudCommandObservers;
        if (listHolder == null || listHolder.getList() == null || this.mCloudCommandObservers.getList().size() <= 0) {
            return null;
        }
        for (ICloudCommandObserver receiver : this.mCloudCommandObservers.getList()) {
            if (TextUtils.equals(commandType, receiver.getCommandType())) {
                return receiver;
            }
        }
        return null;
    }
}
