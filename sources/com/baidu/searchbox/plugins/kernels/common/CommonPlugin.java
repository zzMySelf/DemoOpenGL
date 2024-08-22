package com.baidu.searchbox.plugins.kernels.common;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import com.baidu.searchbox.plugins.Plugin;
import com.baidu.searchbox.plugins.PluginView;
import com.baidu.searchbox.plugins.state.PluginState;

public class CommonPlugin extends Plugin {
    public static final int TYPE_DOWNLOADING = 2;
    public static final int TYPE_INSTALL = 1;
    public static final int TYPE_UPDATE = 3;
    public boolean force = false;
    public boolean isNew = false;
    private boolean mAccessable = false;
    private String mApkSize;
    private String mBehavior;
    private String mCardWhitelist;
    private String mCmdList;
    private String mDependence;
    private String mDisable;
    private String mDownloadUrl;
    private boolean mEnable = true;
    private String mIconUrl;
    private String mInstallTip;
    private String mInvokeMethods;
    private String mMD5;
    private long mMinVersion = -1;
    private String mPackageName;
    private boolean mRealtimeUpload = true;
    private boolean mRemovable = true;
    private String mSignature;
    private int mType;
    private long mUpdateV;
    private long mVersion = -1;
    private boolean mVisible = true;
    private String mZhidaIds;
    public int maxCache = 10;
    public String patchMd5;
    public String patchUrl;

    public CommonPlugin(Context context, String packageName, String name, String description) {
        super(context, packageName, name, description);
        this.mPackageName = packageName;
    }

    public PluginView.StateInvalidater getStateInvalidater(PluginState state) {
        return null;
    }

    public boolean isAvailable() {
        return false;
    }

    public boolean isForbidden() {
        return true;
    }

    public Drawable getIcon() {
        return null;
    }

    public String getDownloadName() {
        return null;
    }

    public String getDownloadFile() {
        return null;
    }

    public void installAsync(Uri uri, String filename) {
    }

    public void uninstallAsync() {
    }

    public String getVersion() {
        return null;
    }

    public long getVersionL() {
        return this.mVersion;
    }

    public void setVersion(String version) {
    }

    public void setVersionL(long version) {
        this.mVersion = version;
    }

    public boolean isDownloaded() {
        return false;
    }

    public void setUri(Uri uri) {
    }

    public Uri getUri() {
        return null;
    }

    public boolean isAccessable() {
        return this.mAccessable;
    }

    public void setAccessable(boolean accessable) {
        this.mAccessable = accessable;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String iconUrl) {
        this.mIconUrl = iconUrl;
    }

    public boolean isRemovable() {
        return this.mRemovable;
    }

    public void setRemovable(boolean removable) {
        this.mRemovable = removable;
    }

    public String getSignature() {
        return this.mSignature;
    }

    public void setSignature(String signature) {
        this.mSignature = signature;
    }

    public boolean isVisible() {
        return this.mVisible;
    }

    public void setVisible(boolean visible) {
        this.mVisible = visible;
    }

    public String getBehavior() {
        return this.mBehavior;
    }

    public void setBehavior(String behavior) {
        this.mBehavior = behavior;
    }

    public long getUpdateV() {
        return this.mUpdateV;
    }

    public void setUpdateV(long updateV) {
        this.mUpdateV = updateV;
    }

    public int getType() {
        return this.mType;
    }

    public void setType(int type) {
        this.mType = type;
    }

    public long getMinVersion() {
        return this.mMinVersion;
    }

    public void setMinVersion(long version) {
        this.mMinVersion = version;
    }

    public String getDownloadUrl() {
        return this.mDownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.mDownloadUrl = downloadUrl;
    }

    public String getInstallTip() {
        return this.mInstallTip;
    }

    public void setInstallTip(String installTip) {
        this.mInstallTip = installTip;
    }

    public String getCmdList() {
        return this.mCmdList;
    }

    public void setCmdList(String list) {
        this.mCmdList = list;
    }

    public void setDependence(String dependence) {
        this.mDependence = dependence;
    }

    public String getDependence() {
        return this.mDependence;
    }

    public boolean isEnable() {
        return this.mEnable;
    }

    public void setEnable(boolean enable) {
        this.mEnable = enable;
    }

    public String getDisable() {
        return this.mDisable;
    }

    public void setDisable(String disable) {
        this.mDisable = disable;
    }

    public String getMD5() {
        return this.mMD5;
    }

    public void setMD5(String md5) {
        this.mMD5 = md5;
    }

    public String getInvokeMethods() {
        return this.mInvokeMethods;
    }

    public void setInvokeMethods(String methods) {
        this.mInvokeMethods = methods;
    }

    public String getPackageName() {
        return this.mPackageName;
    }

    public void setApkSize(String size) {
        this.mApkSize = size;
    }

    public String getApkSize() {
        return this.mApkSize;
    }

    public void setCardWhitelist(String cardWhitelist) {
        this.mCardWhitelist = cardWhitelist;
    }

    public String getCardWhitelist() {
        return this.mCardWhitelist;
    }

    public void setRealtimeUpload(boolean state) {
        this.mRealtimeUpload = state;
    }

    public boolean isRealtimeUpload() {
        return this.mRealtimeUpload;
    }

    public void setZhidaIds(String ids) {
        this.mZhidaIds = ids;
    }

    public String getZhidaIds() {
        return this.mZhidaIds;
    }
}
