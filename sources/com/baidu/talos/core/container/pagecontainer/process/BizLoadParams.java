package com.baidu.talos.core.container.pagecontainer.process;

import com.baidu.talos.core.container.pagecontainer.TalosPageContainer;
import com.baidu.talos.core.data.ParamMap;
import com.baidu.talos.view.SSRParams;

public class BizLoadParams {
    public TalosPageContainer container;
    public ParamMap initProps;
    public SSRParams ssrParams;
    public boolean wrapContent;

    public static class Builder {
        private BizLoadParams mParams = new BizLoadParams();

        public Builder container(TalosPageContainer container) {
            this.mParams.container = container;
            return this;
        }

        public Builder wrapContent(boolean wrapContent) {
            this.mParams.wrapContent = wrapContent;
            return this;
        }

        public Builder initProps(ParamMap initProps) {
            this.mParams.initProps = initProps;
            return this;
        }

        public Builder ssrParams(SSRParams ssrParams) {
            this.mParams.ssrParams = ssrParams;
            return this;
        }

        public BizLoadParams build() {
            return this.mParams;
        }
    }
}
