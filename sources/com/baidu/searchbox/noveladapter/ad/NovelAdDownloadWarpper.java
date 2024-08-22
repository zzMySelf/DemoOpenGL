package com.baidu.searchbox.noveladapter.ad;

import android.net.Uri;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.ad.download.data.AdDownload;
import com.baidu.searchbox.ad.download.data.AdDownloadExtra;
import org.json.JSONObject;

public class NovelAdDownloadWarpper implements NoProGuard {
    private AdDownload mAdDownload;

    public NovelAdDownloadWarpper(Object adDownload) {
        if (adDownload != null && (adDownload instanceof AdDownload)) {
            this.mAdDownload = (AdDownload) adDownload;
        }
    }

    public NovelAdDownloadWarpper() {
        this.mAdDownload = new AdDownload();
    }

    public AdDownload getAdDownload() {
        return this.mAdDownload;
    }

    public String getPackageName() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.packageName;
    }

    public void setPackageName(String packageName) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.packageName = packageName;
        }
    }

    public String getDownloadUrl() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.downloadUrl = downloadUrl;
        }
    }

    public boolean isExemptionsPkgName() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return false;
        }
        return adDownload.isExemptionsPkgName;
    }

    public void setExemptionsPkgName(boolean exemptionsPkgName) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.isExemptionsPkgName = exemptionsPkgName;
        }
    }

    public String getKey() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.key;
    }

    public void setKey(String key) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.key = key;
        }
    }

    public String getDeferredCmd() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.deferredCmd;
    }

    public void setDeferredCmd(String deferredCmd) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.deferredCmd = deferredCmd;
        }
    }

    public boolean isDrity() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return false;
        }
        return adDownload.isDrity;
    }

    public void setDrity(boolean drity) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.isDrity = drity;
        }
    }

    public long getUpdateTime() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return 0;
        }
        return adDownload.updateTime;
    }

    public void setUpdateTime(long updateTime) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.updateTime = updateTime;
        }
    }

    public String getDownloadBtnIcon() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.downloadBtnIcon;
    }

    public void setDownloadBtnIcon(String downloadBtnIcon) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.downloadBtnIcon = downloadBtnIcon;
        }
    }

    public String getDownloadBtnText() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.downloadBtnText;
    }

    public void setDownloadBtnText(String downloadBtnText) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.downloadBtnText = downloadBtnText;
        }
    }

    public String getAppIconUrl() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.appIconUrl;
    }

    public void setAppIconUrl(String appIconUrl) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.appIconUrl = appIconUrl;
        }
    }

    public String getAppName() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.appName;
    }

    public void setAppName(String appName) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.appName = appName;
        }
    }

    public String getVersioncode() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.versioncode;
    }

    public void setVersioncode(String versioncode) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.versioncode = versioncode;
        }
    }

    public String getCloseVDownload() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.closeVDownload;
    }

    public void setCloseVDownload(String closeVDownload) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.closeVDownload = closeVDownload;
        }
    }

    public String getSource() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.source;
    }

    public void setSource(String source) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null) {
            adDownload.source = source;
        }
    }

    public NovelAdDownloadExtraStatus getExtraStatus() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null || adDownload.extra == null) {
            return null;
        }
        return NovelAdDownloadExtraStatus.convertfrom(this.mAdDownload.extra.status);
    }

    public void setExtraStatus(NovelAdDownloadExtraStatus status) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null && adDownload.extra != null) {
            this.mAdDownload.extra.status = NovelAdDownloadExtraStatus.convertto(status);
        }
    }

    public Uri getExtraUri() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null || adDownload.extra == null) {
            return null;
        }
        return this.mAdDownload.extra.uri;
    }

    public void setExtraUri(Uri uri) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null && adDownload.extra != null) {
            this.mAdDownload.extra.uri = uri;
        }
    }

    public void setExtra(NovelAdDownloadWarpper adDownload) {
        AdDownload adDownload2 = this.mAdDownload;
        if (adDownload2 != null) {
            adDownload2.extra = AdDownloadExtra.create(adDownload == null ? null : adDownload.getAdDownload(), (JSONObject) null);
        }
    }

    public Object getExtra() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return null;
        }
        return adDownload.extra;
    }

    public int getExtraPercent() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null || adDownload.extra == null) {
            return 0;
        }
        return this.mAdDownload.extra.getPercent();
    }

    public void setExtraPercent(int percent) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null && adDownload.extra != null) {
            this.mAdDownload.extra.setPercent(percent);
        }
    }

    public void setExtraFakePercent(int fakePercent) {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload != null && adDownload.extra != null) {
            this.mAdDownload.extra.setFakePercent(fakePercent);
        }
    }

    public int getExtraFakePercent() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null || adDownload.extra == null) {
            return 0;
        }
        return this.mAdDownload.extra.getFakePercent();
    }

    public boolean isPackageNameValid() {
        AdDownload adDownload = this.mAdDownload;
        if (adDownload == null) {
            return false;
        }
        return adDownload.isPackageNameValid();
    }
}
