package com.baidu.talos.view;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.talos.TalosAdapterManager;
import com.baidu.talos.jsengine.JsEngineType;
import com.baidu.talos.view.Container;

public class TalosContainerViewInitParams {
    /* access modifiers changed from: private */
    public static final boolean DEBUG = TalosAdapterManager.getHostConfig().isDebug();
    private static final String TAG = "TLS_ContainerInitParams";
    public JsEngineType engineType;
    public boolean forceUpdate = false;
    public boolean isPreRender = false;
    public boolean mKeepLoading;
    public String mMiniMoudleVersion;
    public String mModuleName;
    public String mPackageName;
    public Uri mPackagePath;
    public String mPrefetchRequestData;
    public String mSource = "";
    public boolean showDebugEntrance = true;
    public SSRParams ssrParams;
    public Container.StateListener stateListener;
    public boolean wrapContent = false;

    public static class Builder {
        TalosContainerViewInitParams mParams = new TalosContainerViewInitParams();

        public Builder stateListener(Container.StateListener listener) {
            this.mParams.stateListener = listener;
            return this;
        }

        public Builder showDebugEntrance(boolean isShow) {
            this.mParams.showDebugEntrance = isShow;
            return this;
        }

        public Builder jsEngineType(JsEngineType engineType) {
            this.mParams.engineType = engineType;
            return this;
        }

        public Builder packageName(String packageName) {
            this.mParams.mPackageName = packageName;
            return this;
        }

        public Builder moudleName(String moduleName) {
            this.mParams.mModuleName = moduleName;
            return this;
        }

        public Builder minMoudleVersion(String minModuleVersion) {
            this.mParams.mMiniMoudleVersion = minModuleVersion;
            return this;
        }

        public Builder packagePath(Uri packagePath) {
            this.mParams.mPackagePath = packagePath;
            return this;
        }

        public Builder preFetch(String preFetchRequestData) {
            this.mParams.mPrefetchRequestData = preFetchRequestData;
            return this;
        }

        public Builder keepLoading(boolean keepLoading) {
            this.mParams.mKeepLoading = keepLoading;
            return this;
        }

        public Builder source(String src) {
            this.mParams.mSource = src;
            return this;
        }

        public Builder forceUpdate(boolean forceUpdate) {
            this.mParams.forceUpdate = forceUpdate;
            return this;
        }

        public Builder enableWrapContent(boolean enable) {
            this.mParams.wrapContent = enable;
            return this;
        }

        public Builder ssrParams(SSRParams ssrParams) {
            this.mParams.ssrParams = ssrParams;
            return this;
        }

        public Builder isPreRender(boolean value) {
            this.mParams.isPreRender = value;
            return this;
        }

        public TalosContainerViewInitParams build() {
            if (TextUtils.isEmpty(this.mParams.mPackageName) || TextUtils.isEmpty(this.mParams.mModuleName)) {
                StringBuilder eMsgBuilder = new StringBuilder("init info is invalid:TLS_ContainerInitParams");
                if (TextUtils.isEmpty(this.mParams.mPackageName)) {
                    eMsgBuilder.append(" mPackageName == null");
                }
                if (TextUtils.isEmpty(this.mParams.mModuleName)) {
                    eMsgBuilder.append(" mModuleName == null");
                }
                if (!TalosContainerViewInitParams.DEBUG) {
                    Log.e(TalosContainerViewInitParams.TAG, eMsgBuilder.toString());
                } else {
                    throw new IllegalArgumentException(eMsgBuilder.toString());
                }
            }
            if (this.mParams.mPackagePath != null && !TextUtils.isEmpty(this.mParams.mPackagePath.toString())) {
                String scheme = this.mParams.mPackagePath.getScheme();
                if (!"file".equals(scheme) && !"assets".equals(scheme)) {
                    String errMsg = "packagePath need file or asset uri mPackagePath=" + this.mParams.mPackagePath;
                    if (!TalosContainerViewInitParams.DEBUG) {
                        Log.e(TalosContainerViewInitParams.TAG, errMsg);
                    } else {
                        throw new IllegalArgumentException(errMsg);
                    }
                }
            }
            return this.mParams;
        }
    }
}
