package com.baidu.swan.apps.api;

import android.util.Pair;
import android.webkit.JavascriptInterface;
import com.baidu.searchbox.v8engine.JsObject;
import com.baidu.swan.apps.api.base.ISwanApi;
import com.baidu.swan.apps.api.base.ISwanApiContext;
import com.baidu.swan.apps.api.base.SwanBaseApi;
import com.baidu.swan.apps.api.module.filemanager.FileSystemApi;
import com.baidu.swan.apps.api.result.ISwanApiResult;
import com.baidu.swan.apps.api.result.SwanApiResult;
import com.baidu.swan.apps.api.utils.SwanApiSafeUtils;
import com.baidu.swan.apps.console.SwanAppLog;
import com.baidu.swan.apps.core.master.isolation.MasterIsolationHelper;
import com.baidu.swan.apps.media.chooser.action.FileChooseApi;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONObject;

public class SwanApi$$FileSystemV8Module {
    private static final boolean DEBUG = false;
    private static final String TAG = "Api-Base";
    private ConcurrentHashMap<String, Object> mApis = new ConcurrentHashMap<>();
    private ISwanApiContext mSwanApiContext;

    public SwanApi$$FileSystemV8Module(ISwanApiContext mSwanApiContext2) {
        this.mSwanApiContext = mSwanApiContext2;
    }

    @JavascriptInterface
    public String access(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/access");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.access")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.access(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.access[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String accessSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/accessSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.accessSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.accessSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.accessSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String appendFile(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/appendFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.appendFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.appendFile(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.appendFile[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String appendFileSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/appendFileSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.appendFileSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.appendFileSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.appendFileSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String chooseFile(String $params) {
        FileChooseApi swanApi;
        try {
            Object obj = this.mApis.get("-1898666677");
            if (obj == null || !(obj instanceof FileChooseApi)) {
                swanApi = new FileChooseApi(this.mSwanApiContext);
                this.mApis.put("-1898666677", swanApi);
            } else {
                swanApi = (FileChooseApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/chooseFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.chooseFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.chooseFile($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.chooseFile[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String chooseImageBySysPicker(String $params) {
        FileChooseApi swanApi;
        try {
            Object obj = this.mApis.get("-1898666677");
            if (obj == null || !(obj instanceof FileChooseApi)) {
                swanApi = new FileChooseApi(this.mSwanApiContext);
                this.mApis.put("-1898666677", swanApi);
            } else {
                swanApi = (FileChooseApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/chooseImageBySysPicker");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.chooseImageBySysPicker")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            ISwanApiResult result = swanApi.chooseImageBySysPicker($params);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.chooseImageBySysPicker[type:V8, v8 binding:false] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String copyFile(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/copyFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.copyFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.copyFile(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.copyFile[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String copyFileSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/copyFileSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.copyFileSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.copyFileSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.copyFileSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getFileInfo(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getFileInfo");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.getFileInfo")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.getFileInfo(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.getFileInfo[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String getSavedFileList(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/getSavedFileList");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.getSavedFileList")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.getSavedFileList(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.getSavedFileList[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String mkdir(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/mkdir");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.mkdir")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.mkDir(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.mkdir[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String mkdirSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/mkdirSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.mkdirSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.mkDirSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.mkdirSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String readFile(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/readFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.readFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.readFile(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.readFile[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String readFileSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/readFileSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.readFileSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.readFileSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.readFileSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String readdir(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/readdir");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.readdir")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.readdir(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.readdir[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String readdirSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/readdirSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.readdirSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.readdirSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.readdirSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String removeSavedFile(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/removeSavedFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.removeSavedFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.removeSavedFile(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.removeSavedFile[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String rename(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/rename");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.rename")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.rename(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.rename[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String renameSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/renameSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.renameSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.renameSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.renameSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String rmdir(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/rmdir");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.rmdir")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.rmdir(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.rmdir[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String rmdirSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/rmdirSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.rmdirSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.rmdirSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.rmdirSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String saveFile(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/saveFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.saveFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.saveFile(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.saveFile[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String saveFileSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/saveFileSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.saveFileSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.saveFileSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.saveFileSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String stat(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/stat");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.stat")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.stat(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.stat[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String statSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/statSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.statSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.statSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.statSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String unlink(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/unlink");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.unlink")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.unlink(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.unlink[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String unlinkSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/unlinkSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.unlinkSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.unlinkSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.unlinkSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String unzip(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/unzip");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.unzip")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.unzip(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.unzip[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String writeFile(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/writeFile");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.writeFile")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.writeFile(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.writeFile[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }

    @JavascriptInterface
    public String writeFileSync(JsObject $params) {
        FileSystemApi swanApi;
        try {
            Object obj = this.mApis.get("674832227");
            if (obj == null || !(obj instanceof FileSystemApi)) {
                swanApi = new FileSystemApi(this.mSwanApiContext);
                this.mApis.put("674832227", swanApi);
            } else {
                swanApi = (FileSystemApi) obj;
            }
            Pair<Boolean, ISwanApiResult> interceptResult = SwanApiSafeUtils.shouldInterceptApi((ISwanApi) swanApi, "swanAPI/writeFileSync");
            if (((Boolean) interceptResult.first).booleanValue()) {
                return ((ISwanApiResult) interceptResult.second).toJsonString();
            }
            if (MasterIsolationHelper.intercept(this.mSwanApiContext.getJSContainer(), "FileSystem.writeFileSync")) {
                return new SwanApiResult(1001, "illegal swanApp, intercept for preload/prefetch").toJsonString();
            }
            Pair<ISwanApiResult, JSONObject> paramsResult = SwanBaseApi.parseParams($params);
            if (!((ISwanApiResult) paramsResult.first).isSuccess()) {
                return ((ISwanApiResult) paramsResult.first).toJsonString();
            }
            JSONObject paramsJsonObject = (JSONObject) paramsResult.second;
            if (paramsJsonObject == null) {
                return ISwanApiResult.ILLEGAL_PARAMS_NULL_JSONOBJECT.toJsonString();
            }
            ISwanApiResult result = swanApi.writeFileSync(paramsJsonObject);
            return result == null ? "" : result.toJsonString();
        } catch (Throwable t) {
            t.printStackTrace();
            SwanAppLog.e("Api-Base", "====================[[FileSystem.writeFileSync[type:V8, v8 binding:true] with exception]]", t);
            throw t;
        }
    }
}
