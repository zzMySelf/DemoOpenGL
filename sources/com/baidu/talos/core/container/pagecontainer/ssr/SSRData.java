package com.baidu.talos.core.container.pagecontainer.ssr;

import com.baidu.talos.core.data.ParamArray;
import com.baidu.talos.core.data.ParamMap;

public class SSRData {
    public ParamArray fontSizeArr;
    public ParamMap jsSSRData;
    public ParamArray renderCmdArr;

    public boolean isValid() {
        ParamArray paramArray;
        if (this.jsSSRData == null || (paramArray = this.renderCmdArr) == null || paramArray.size() <= 0) {
            return false;
        }
        return true;
    }

    public static class Builder {
        SSRData mData = new SSRData();

        public Builder ssrData(ParamMap ssrData) {
            this.mData.jsSSRData = ssrData;
            return this;
        }

        public Builder renderCmdArr(ParamArray renderCmdArr) {
            this.mData.renderCmdArr = renderCmdArr;
            return this;
        }

        public Builder fontSizeArr(ParamArray fontSizeArr) {
            this.mData.fontSizeArr = fontSizeArr;
            return this;
        }

        public SSRData build() {
            return this.mData;
        }
    }
}
