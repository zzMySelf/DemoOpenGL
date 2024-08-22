package com.baidu.searchbox.pms.init;

import android.text.TextUtils;
import com.baidu.searchbox.pms.bean.PackageParams;
import com.baidu.searchbox.pms.callback.IDataInterceptor;
import com.baidu.searchbox.pms.callback.PackageCallback;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.searchbox.pms.utils.CollectionUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.json.JSONObject;

public class RequestParams {
    private List<Channel> channelList;
    private JSONObject filter;
    private String runNode;
    private String runType;

    public RequestParams setRunType(String runType2) {
        this.runType = runType2;
        return this;
    }

    public String getRunType() {
        return this.runType;
    }

    public RequestParams setRunNode(String runNode2) {
        this.runNode = runNode2;
        return this;
    }

    public String getRunNode() {
        return this.runNode;
    }

    public RequestParams setFilter(JSONObject filter2) {
        this.filter = filter2;
        return this;
    }

    public JSONObject getFilter() {
        return this.filter;
    }

    public List<Channel> getChannelList() {
        return this.channelList;
    }

    public RequestParams addChannel(Channel channel) {
        if (channel == null) {
            if (!PmsConstant.DEBUG) {
                return this;
            }
            throw new RuntimeException("channel should not be null");
        } else if (channel.isFetchAllPackages || !CollectionUtils.isEmpty((Collection) channel.packageParamsList) || channel.dataInterceptor != null) {
            if (this.channelList == null) {
                this.channelList = new ArrayList();
            }
            int i2 = 0;
            while (i2 < this.channelList.size()) {
                Channel c2 = this.channelList.get(i2);
                if (!TextUtils.equals(c2.channelId, channel.channelId)) {
                    i2++;
                } else if (!PmsConstant.DEBUG) {
                    this.channelList.set(i2, c2);
                    return this;
                } else {
                    throw new RuntimeException("请求任务channelId不能重复" + c2.channelId + "," + channel.channelId);
                }
            }
            this.channelList.add(channel);
            return this;
        } else if (!PmsConstant.DEBUG) {
            return this;
        } else {
            throw new RuntimeException("packageNames should not be empty");
        }
    }

    public static class Channel {
        private PackageCallback callback;
        /* access modifiers changed from: private */
        public String channelId;
        /* access modifiers changed from: private */
        public IDataInterceptor dataInterceptor;
        /* access modifiers changed from: private */
        public boolean isFetchAllPackages;
        private boolean isUsePmsVersionData;
        private List<String> packageNames;
        /* access modifiers changed from: private */
        public List<PackageParams> packageParamsList;

        public Channel() {
            this.isUsePmsVersionData = true;
        }

        public Channel(String channelId2, List<String> packageNames2, PackageCallback callback2) {
            this.isUsePmsVersionData = true;
            this.channelId = channelId2;
            this.packageNames = packageNames2;
            this.callback = callback2;
            this.packageParamsList = CollectionUtils.convertToPackageParamsList(packageNames2);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Channel(String channelId2, String packageName, PackageCallback callback2) {
            this(channelId2, (List<String>) TextUtils.isEmpty(packageName) ? null : Collections.singletonList(packageName), callback2);
        }

        public Channel(String channelId2, boolean isFetchAllPackages2, PackageCallback callback2) {
            this.isUsePmsVersionData = true;
            this.channelId = channelId2;
            this.isFetchAllPackages = isFetchAllPackages2;
            this.callback = callback2;
        }

        public Channel setChannelId(String channelId2) {
            this.channelId = channelId2;
            return this;
        }

        public String getChannelId() {
            return this.channelId;
        }

        public boolean isUsePmsVersionData() {
            return this.isUsePmsVersionData;
        }

        public Channel setPackageNames(List<String> packageNames2) {
            this.packageNames = packageNames2;
            this.packageParamsList = CollectionUtils.convertToPackageParamsList(packageNames2);
            this.isUsePmsVersionData = true;
            return this;
        }

        public List<String> getPackageNames() {
            return this.packageNames;
        }

        public Channel setPackageParamsList(List<PackageParams> packageParamsList2) {
            this.packageParamsList = packageParamsList2;
            this.isUsePmsVersionData = false;
            return this;
        }

        public List<PackageParams> getPackageParamsList() {
            return this.packageParamsList;
        }

        public Channel setFetchAllPackages(boolean isFetchAllPackages2) {
            this.isFetchAllPackages = isFetchAllPackages2;
            return this;
        }

        public boolean isFetchAllPackages() {
            return this.isFetchAllPackages;
        }

        public PackageCallback getCallback() {
            return this.callback;
        }

        public Channel setCallback(PackageCallback callback2) {
            this.callback = callback2;
            return this;
        }

        public IDataInterceptor getDataInterceptor() {
            return this.dataInterceptor;
        }

        public Channel setDataInterceptor(IDataInterceptor dataInterceptor2) {
            this.dataInterceptor = dataInterceptor2;
            return this;
        }
    }
}
