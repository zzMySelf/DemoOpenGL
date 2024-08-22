package com.baidu.swan.pms.network.processor;

import com.baidu.swan.pms.PMSConstants;
import com.baidu.swan.pms.callback.PMSCallback;
import com.baidu.swan.pms.model.PMSError;
import com.baidu.swan.pms.network.PMSResponseCallback;
import com.baidu.swan.pms.network.download.opti.PmsDownloaderImpl;
import com.baidu.swan.pms.network.response.PMSGetPkgResponse;
import com.baidu.swan.pms.network.reuqest.PMSRequest;
import com.baidu.swan.pms.utils.PMSJsonParser;
import com.baidu.swan.pms.utils.PMSPkgCountSet;
import org.json.JSONObject;

public class PMSGetPkgResponseProcessor extends PMSResponseCallback<PMSGetPkgResponse> {
    private final String mAppId;

    public PMSGetPkgResponseProcessor(String appId, PMSCallback mCallback, PMSRequest request) {
        super(mCallback, request);
        this.mAppId = appId;
    }

    /* access modifiers changed from: protected */
    public PMSGetPkgResponse parseResponseData(JSONObject jsonObject) {
        return PMSJsonParser.parseGetPkgResponse(this.mAppId, jsonObject);
    }

    /* access modifiers changed from: protected */
    public boolean onInterceptResponseData(PMSGetPkgResponse data, int statusCode) {
        if (data == null) {
            return false;
        }
        handleSwanApp(data.swanApp);
        return false;
    }

    /* access modifiers changed from: protected */
    public PMSError onResponseParseSuccess(PMSGetPkgResponse response) {
        this.mCallback.onFetchSuccess();
        PMSPkgCountSet countSet = new PMSPkgCountSet();
        handlePkgMain(response.pkgMain, countSet);
        handlePkgSub(response.pkgSubList, countSet);
        handlePkgDependent(filterExistDependentPkg(response.pkgDependentList), countSet);
        handleFramework(response.framework, countSet);
        handleExtension(response.extension, countSet);
        handleSwanApp(response.swanApp);
        if (countSet.pkgSize() == 0) {
            this.mCallback.onNoPackage();
            return null;
        }
        this.mCallback.onPrepareDownload(countSet);
        PmsDownloaderImpl.startDownload(response, this.mCallback);
        return null;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0068  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean checkResponseValid(com.baidu.swan.pms.network.response.PMSGetPkgResponse r5) {
        /*
            r4 = this;
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            com.baidu.swan.pms.model.PMSPkgMain r1 = r5.pkgMain
            if (r1 != 0) goto L_0x002d
            java.util.List<com.baidu.swan.pms.model.PMSPkgSub> r1 = r5.pkgSubList
            if (r1 == 0) goto L_0x0014
            java.util.List<com.baidu.swan.pms.model.PMSPkgSub> r1 = r5.pkgSubList
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002d
        L_0x0014:
            java.util.List<com.baidu.swan.pms.model.PMSPlugin> r1 = r5.pkgDependentList
            if (r1 == 0) goto L_0x0020
            java.util.List<com.baidu.swan.pms.model.PMSPlugin> r1 = r5.pkgDependentList
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x002d
        L_0x0020:
            com.baidu.swan.pms.model.PMSFramework r1 = r5.framework
            if (r1 != 0) goto L_0x002d
            com.baidu.swan.pms.model.PMSExtension r1 = r5.extension
            if (r1 != 0) goto L_0x002d
            com.baidu.swan.pms.model.PMSAppInfo r1 = r5.swanApp
            if (r1 != 0) goto L_0x002d
            return r0
        L_0x002d:
            com.baidu.swan.pms.model.PMSPkgMain r1 = r5.pkgMain
            if (r1 == 0) goto L_0x003a
            com.baidu.swan.pms.model.PMSPkgMain r1 = r5.pkgMain
            boolean r1 = r1.checkValid()
            if (r1 != 0) goto L_0x003a
            return r0
        L_0x003a:
            java.util.List<com.baidu.swan.pms.model.PMSPkgSub> r1 = r5.pkgSubList
            if (r1 == 0) goto L_0x0058
            java.util.List<com.baidu.swan.pms.model.PMSPkgSub> r1 = r5.pkgSubList
            java.util.Iterator r1 = r1.iterator()
        L_0x0044:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0058
            java.lang.Object r2 = r1.next()
            com.baidu.swan.pms.model.PMSPkgSub r2 = (com.baidu.swan.pms.model.PMSPkgSub) r2
            boolean r3 = r2.checkValid()
            if (r3 != 0) goto L_0x0057
            return r0
        L_0x0057:
            goto L_0x0044
        L_0x0058:
            java.util.List<com.baidu.swan.pms.model.PMSPlugin> r1 = r5.pkgDependentList
            if (r1 == 0) goto L_0x0079
            java.util.List<com.baidu.swan.pms.model.PMSPlugin> r1 = r5.pkgDependentList
            java.util.Iterator r1 = r1.iterator()
        L_0x0062:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0079
            java.lang.Object r2 = r1.next()
            com.baidu.swan.pms.model.PMSPlugin r2 = (com.baidu.swan.pms.model.PMSPlugin) r2
            if (r2 == 0) goto L_0x0078
            boolean r3 = r2.checkValid()
            if (r3 != 0) goto L_0x0077
            goto L_0x0078
        L_0x0077:
            goto L_0x0062
        L_0x0078:
            return r0
        L_0x0079:
            com.baidu.swan.pms.model.PMSFramework r1 = r5.framework
            if (r1 == 0) goto L_0x0086
            com.baidu.swan.pms.model.PMSFramework r1 = r5.framework
            boolean r1 = r1.checkValid()
            if (r1 != 0) goto L_0x0086
            return r0
        L_0x0086:
            com.baidu.swan.pms.model.PMSExtension r1 = r5.extension
            if (r1 == 0) goto L_0x0093
            com.baidu.swan.pms.model.PMSExtension r1 = r5.extension
            boolean r1 = r1.checkValid()
            if (r1 != 0) goto L_0x0093
            return r0
        L_0x0093:
            com.baidu.swan.pms.model.PMSAppInfo r1 = r5.swanApp
            if (r1 == 0) goto L_0x009f
            com.baidu.swan.pms.model.PMSAppInfo r1 = r5.swanApp
            boolean r1 = r1.checkValid()
            if (r1 == 0) goto L_0x00a0
        L_0x009f:
            r0 = 1
        L_0x00a0:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.swan.pms.network.processor.PMSGetPkgResponseProcessor.checkResponseValid(com.baidu.swan.pms.network.response.PMSGetPkgResponse):boolean");
    }

    /* access modifiers changed from: protected */
    public String getInterfaceType() {
        return PMSConstants.Statistics.PAGE_GET_PKG;
    }
}
