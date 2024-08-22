package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
import com.baidu.searchbox.cloudcontrol.ICloudControlUBCCallBack;
import com.baidu.searchbox.cloudcontrol.data.CloudControlRequestInfo;
import com.baidu.searchbox.cloudcontrol.data.CloudControlResponseInfo;
import com.baidu.searchbox.cloudcontrol.processor.ICloudControlProcessor;
import com.baidu.searchbox.pms.IPmsContext;
import com.baidu.searchbox.pms.PmsRuntime;
import com.baidu.searchbox.pms.bean.ErrorInfo;
import com.baidu.searchbox.pms.init.RequestParams;
import com.baidu.searchbox.pms.init.request.RequestDataUtils;
import com.baidu.searchbox.pms.init.request.RequestTask;
import com.baidu.searchbox.pms.init.response.ResponseDataProcess;
import com.baidu.searchbox.pms.utils.CommonUtils;
import com.baidu.searchbox.pms.utils.DebugUtils;
import com.baidu.searchbox.pms.utils.StatisticUtils;
import java.util.List;
import org.json.JSONObject;

public class ApsCloudControlProcessor implements ICloudControlProcessor {
    public static final String SERVER_APS = "aps";
    public static final String SERVER_DPM = "dpm";
    private String serviceName = "aps";

    public ApsCloudControlProcessor() {
    }

    public ApsCloudControlProcessor(String serviceName2) {
        this.serviceName = serviceName2;
    }

    public void processServiceData(final CloudControlResponseInfo cloudControlResponseInfo, final ICloudControlUBCCallBack cloudControlUBCCallBack) {
        CommonUtils.postThread(new Runnable() {
            public void run() {
                ApsCloudControlProcessor.this.processServiceDataInThread(cloudControlResponseInfo, cloudControlUBCCallBack);
            }
        }, "pms_processServiceData");
    }

    /* access modifiers changed from: protected */
    public void processServiceDataInThread(CloudControlResponseInfo cloudControlResponseInfo, ICloudControlUBCCallBack cloudControlUBCCallback) {
        ResponseDataProcess dataProcess = new ResponseDataProcess();
        if (cloudControlResponseInfo == null) {
            StatisticUtils.sendCloudCtrl("【响应结果】cloudControlResponseInfo  is null", (List<RequestParams.Channel>) null);
        } else if (!this.serviceName.equals(cloudControlResponseInfo.getServiceName())) {
            StatisticUtils.sendCloudCtrl("【响应结果】ServiceName err: " + cloudControlResponseInfo.getServiceName(), (List<RequestParams.Channel>) null);
        } else {
            Object checkData = cloudControlResponseInfo.getCheckData();
            if (checkData == null) {
                IPmsContext pmsContext = PmsRuntime.getPmsContext();
                if (pmsContext != null) {
                    List<RequestParams.Channel> list = pmsContext.getLongConnectParams();
                    if (list != null && list.size() > 0) {
                        dataProcess.setResponseInfo(cloudControlResponseInfo);
                        dataProcess.setChannelList(list);
                        dataProcess.process(this.serviceName);
                    }
                } else {
                    return;
                }
            } else if (checkData instanceof RequestTask) {
                dataProcess.setResponseInfo(cloudControlResponseInfo);
                dataProcess.setChannelList(((RequestTask) checkData).getRequestParams().getChannelList());
                dataProcess.process(this.serviceName);
            }
            ResponseDataProcess.sendCloudControlUBCData(cloudControlUBCCallback, dataProcess);
        }
    }

    public CloudControlRequestInfo getPostData(String runType, boolean isDegradeTime, JSONObject degradeJsonObject) {
        RequestParams requestParams = getRegisterParams(runType);
        if (requestParams == null) {
            DebugUtils.log("requestParams is empty runType:", runType);
            return null;
        }
        String errMsg = RequestDataUtils.checkParamsWithMsg(requestParams);
        if (!TextUtils.isEmpty(errMsg)) {
            ResponseDataProcess.dispatchFetchError(new ErrorInfo(2102, errMsg), requestParams.getChannelList());
            return null;
        }
        CloudControlRequestInfo requestInfo = new RequestTask(requestParams).createPostData();
        if (requestInfo != null) {
            return requestInfo;
        }
        DebugUtils.log("requestInfo is empty");
        return null;
    }

    /* access modifiers changed from: protected */
    public RequestParams getRegisterParams(String runType) {
        IPmsContext pmsContext = PmsRuntime.getPmsContext();
        if (pmsContext == null) {
            return null;
        }
        return pmsContext.getRegisterParams(runType, this.serviceName);
    }
}
