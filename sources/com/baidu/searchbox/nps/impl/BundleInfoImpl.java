package com.baidu.searchbox.nps.impl;

import android.text.TextUtils;
import com.baidu.nps.pm.IBundleInfo;
import com.baidu.nps.pm.SubBundleInfo;
import com.baidu.searchbox.pms.bean.PackageInfo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class BundleInfoImpl implements IBundleInfo {
    private static final String TAG_ABI = "abi";
    private static final String TAG_DEPENDENCIES = "dependencies";
    private static final String TAG_DESCRIPTION = "description";
    private static final String TAG_FORCE_UPDATE = "force_update";
    private static final String TAG_ICON_URL = "icon_url";
    private static final String TAG_MAIN_BUNDLE = "main_bundle";
    private static final String TAG_MAX = "max";
    private static final String TAG_MIN = "min";
    private static final String TAG_MINVERSION = "min_version";
    private int mAbi;
    private PackageInfo mBase;
    private String mDependence;
    private List<String> mDependency;
    private String mDescription;
    private int mForceUpdate;
    private String mIconUrl;
    private boolean mIsRemovable = false;
    private boolean mIsVisible = true;
    private String mMainBundle;
    private int mMinVersion;
    private String mNetWorkStrategy;
    private int mSilence;
    private int mSilenceUpdate;
    private List<SubBundleInfo> mSubBundleList;
    private int mWifiOnly;
    private String patchMD5;
    private String patchUrl;

    public BundleInfoImpl(PackageInfo base) {
        this.mBase = base;
        String ext = base.extraServer;
        if (this.mBase.isAllowSilence()) {
            this.mSilence = 1;
        }
        if (this.mBase.isOnlyWifi()) {
            this.mWifiOnly = 1;
        }
        if (this.mBase.isAllowSilenceUpdate()) {
            this.mSilenceUpdate = 1;
        }
        if (!TextUtils.isEmpty(this.mBase.patchUrl) && !TextUtils.isEmpty(this.mBase.patchMD5)) {
            setPatchMD5(this.mBase.patchMD5);
            setPatchUrl(this.mBase.patchUrl);
        }
        this.mNetWorkStrategy = base.netWorkStrategy;
        if (!TextUtils.isEmpty(ext)) {
            try {
                JSONObject jsonObject = new JSONObject(ext);
                this.mDescription = jsonObject.optString("description");
                this.mIconUrl = jsonObject.optString("icon_url");
                this.mForceUpdate = jsonObject.optInt("force_update");
                this.mMinVersion = jsonObject.optInt("min_version");
                this.mAbi = jsonObject.optInt("abi");
            } catch (JSONException e2) {
            }
        }
        if (!TextUtils.isEmpty(base.subBundle)) {
            try {
                JSONObject jsonObject2 = new JSONObject(base.subBundle);
                Iterator<String> iterator = jsonObject2.keys();
                List<SubBundleInfo> subBundleInfos = new ArrayList<>();
                while (iterator.hasNext()) {
                    String key = iterator.next();
                    JSONObject subBundleJson = jsonObject2.getJSONObject(key);
                    int minVersion = subBundleJson.getInt(TAG_MIN);
                    int maxVersion = subBundleJson.getInt("max");
                    SubBundleInfo subBundleInfo = new SubBundleInfo();
                    subBundleInfo.setMaxVersion(maxVersion);
                    subBundleInfo.setMinVersion(minVersion);
                    subBundleInfo.setPackageName(key);
                    subBundleInfos.add(subBundleInfo);
                }
                setSubBundle(subBundleInfos);
            } catch (JSONException e3) {
                e3.printStackTrace();
            }
        }
        if (!TextUtils.isEmpty(base.dependInfo)) {
            try {
                JSONObject jsonObject3 = new JSONObject(base.dependInfo);
                String mainBundle = jsonObject3.optString("main_bundle");
                setMainBundle(mainBundle);
                List<String> dependencyList = new ArrayList<>();
                dependencyList.add(mainBundle);
                JSONArray dependencyArray = jsonObject3.optJSONArray("dependencies");
                if (dependencyArray != null) {
                    for (int i2 = 0; i2 < dependencyArray.length(); i2++) {
                        dependencyList.add(dependencyArray.optString(i2));
                    }
                }
                setDependency(dependencyList);
            } catch (JSONException e4) {
                e4.printStackTrace();
            }
        }
    }

    public long getSize() {
        int size = 0;
        try {
            size = Integer.parseInt(this.mBase.size);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return (long) size;
    }

    public void setSize(long l) {
        this.mBase.size = l + "";
    }

    public boolean isNeedRemove() {
        return false;
    }

    public void setNeedRemove(boolean b2) {
    }

    public String getExt() {
        return this.mBase.extraServer;
    }

    public void setExt(String s) {
        this.mBase.extraServer = s;
    }

    public String getMd5() {
        return this.mBase.md5;
    }

    public void setMd5(String s) {
        this.mBase.md5 = s;
    }

    public String getSignature() {
        return this.mBase.sign;
    }

    public void setSignature(String s) {
        this.mBase.sign = s;
    }

    public String getName() {
        return this.mBase.name;
    }

    public void setName(String s) {
        this.mBase.name = s;
    }

    public String getDescription() {
        return this.mDescription;
    }

    public void setDescription(String s) {
        this.mDescription = s;
    }

    public String getDownloadUrl() {
        return this.mBase.downloadUrl;
    }

    public void setDownloadUrl(String s) {
        this.mBase.downloadUrl = s;
    }

    public String getIconUrl() {
        return this.mIconUrl;
    }

    public void setIconUrl(String s) {
        this.mIconUrl = s;
    }

    public String getDependence() {
        return this.mDependence;
    }

    public void setDependence(String s) {
        this.mDescription = s;
    }

    public boolean isVisible() {
        return this.mIsVisible;
    }

    public void setVisible(boolean b2) {
        this.mIsVisible = b2;
    }

    public boolean isRemovable() {
        return this.mIsRemovable;
    }

    public void setRemovable(boolean b2) {
        this.mIsRemovable = b2;
    }

    public boolean isForbidden() {
        return this.mBase.disable == 1;
    }

    public void setForbidden(boolean b2) {
    }

    public boolean needForceUpdate() {
        return this.mForceUpdate == 1;
    }

    public void setForceUpdate(boolean b2) {
    }

    public String getPackageName() {
        return this.mBase.packageName;
    }

    public void setPackageName(String s) {
        this.mBase.packageName = s;
    }

    public int getVersionCode() {
        return (int) this.mBase.version;
    }

    public void setVersionCode(int i2) {
        this.mBase.version = (long) i2;
    }

    public long getUpdateV() {
        return this.mBase.updateVersion;
    }

    public void setUpdateV(long l) {
        this.mBase.updateVersion = l;
    }

    public String getApkPath() {
        return this.mBase.filePath;
    }

    public void setApkPath(String s) {
        this.mBase.filePath = s;
    }

    public int getType() {
        return 0;
    }

    public void setType(int i2) {
    }

    public boolean isBroken() {
        return false;
    }

    public void setBroken(boolean b2) {
    }

    public int getMinVersion() {
        return this.mMinVersion;
    }

    public void setMinVersion(int i2) {
    }

    public void setAbi(int i2) {
    }

    public int getAbi() {
        return this.mAbi;
    }

    public int getSilence() {
        return this.mSilence;
    }

    public void setSilence(int silence) {
        this.mSilence = silence;
    }

    public int getWifiOnly() {
        return this.mWifiOnly;
    }

    public void setWifiOnly(int wifiOnly) {
        this.mWifiOnly = wifiOnly;
    }

    public int getSilenceUpdate() {
        return this.mSilenceUpdate;
    }

    public void setSilenceUpdate(int silenceUpdate) {
        this.mSilenceUpdate = silenceUpdate;
    }

    public void setPatchUrl(String url) {
        this.patchUrl = this.mBase.patchUrl;
    }

    public String getPatchUrl() {
        return this.patchUrl;
    }

    public void setPatchMD5(String md5) {
        this.patchMD5 = this.mBase.patchMD5;
    }

    public String getPatchMD5() {
        return this.patchMD5;
    }

    public int getDownloadType() {
        return (TextUtils.isEmpty(this.patchUrl) || TextUtils.isEmpty(this.patchMD5)) ? 1 : 2;
    }

    public String getNetworkStrategy() {
        return this.mNetWorkStrategy;
    }

    public void setNetworkStrategy(String networkStrategy) {
        this.mNetWorkStrategy = networkStrategy;
    }

    public void setSubBundle(List<SubBundleInfo> list) {
        this.mSubBundleList = list;
    }

    public List<SubBundleInfo> getSubBundle() {
        return this.mSubBundleList;
    }

    public void setDependency(List<String> list) {
        this.mDependency = list;
    }

    public List<String> getDependency() {
        return this.mDependency;
    }

    public String getMainBudble() {
        return this.mMainBundle;
    }

    public void setMainBundle(String name) {
        this.mMainBundle = name;
    }
}
