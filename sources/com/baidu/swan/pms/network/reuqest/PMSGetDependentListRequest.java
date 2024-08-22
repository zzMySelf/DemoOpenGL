package com.baidu.swan.pms.network.reuqest;

import android.text.TextUtils;
import java.util.Objects;
import java.util.Set;

public class PMSGetDependentListRequest extends PMSRequest {
    private static final int PMS_DEFAULT_VERSION = 0;
    private final Set<DependentItem> mDependentSet;

    public PMSGetDependentListRequest(Set<DependentItem> dependentSet) {
        super(-1);
        this.mDependentSet = dependentSet;
    }

    public Set<DependentItem> getDependentSet() {
        return this.mDependentSet;
    }

    public static class DependentItem {
        private final String mBundleId;
        private long mMaxVersionCode;
        private long mMinVersionCode;

        public DependentItem(String bundleId) {
            this.mBundleId = bundleId;
        }

        public String getBundleId() {
            return this.mBundleId;
        }

        public long getMinVersionCode() {
            return this.mMinVersionCode;
        }

        public void setVersionCodeRange(long minVersionCode, long maxVersionCode) {
            this.mMinVersionCode = minVersionCode;
            this.mMaxVersionCode = maxVersionCode;
        }

        public long getMaxVersionCode() {
            return this.mMaxVersionCode;
        }

        public int getCategory() {
            return 6;
        }

        public int getPkgVer() {
            return 0;
        }

        public int hashCode() {
            return Objects.hash(new Object[]{this.mBundleId, Long.valueOf(this.mMinVersionCode), Long.valueOf(this.mMaxVersionCode)});
        }

        public boolean equals(Object obj) {
            if (super.equals(obj)) {
                return true;
            }
            if (!(obj instanceof DependentItem)) {
                return false;
            }
            DependentItem item = (DependentItem) obj;
            if (TextUtils.equals(this.mBundleId, item.mBundleId) && this.mMinVersionCode == item.mMinVersionCode && this.mMaxVersionCode == item.mMaxVersionCode) {
                return true;
            }
            return false;
        }
    }
}
