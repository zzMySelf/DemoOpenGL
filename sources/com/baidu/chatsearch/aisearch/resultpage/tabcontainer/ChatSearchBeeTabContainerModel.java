package com.baidu.chatsearch.aisearch.resultpage.tabcontainer;

import com.baidu.browser.tabna.model.TabContainerModel;
import com.baidu.chatsearch.aisearch.resultpage.SSAiResultPageModel;
import com.baidu.searchbox.browserenhanceengine.container.Container;
import com.baidu.searchbox.browserenhanceengine.container.ContainerModel;
import com.baidu.searchbox.config.AppConfig;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u000b0\nH\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0010H\u0016R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, d2 = {"Lcom/baidu/chatsearch/aisearch/resultpage/tabcontainer/ChatSearchBeeTabContainerModel;", "Lcom/baidu/browser/tabna/model/TabContainerModel;", "()V", "aiResultPageModel", "Lcom/baidu/chatsearch/aisearch/resultpage/SSAiResultPageModel;", "getAiResultPageModel", "()Lcom/baidu/chatsearch/aisearch/resultpage/SSAiResultPageModel;", "setAiResultPageModel", "(Lcom/baidu/chatsearch/aisearch/resultpage/SSAiResultPageModel;)V", "getContainerClass", "Ljava/lang/Class;", "Lcom/baidu/searchbox/browserenhanceengine/container/Container;", "Lcom/baidu/searchbox/browserenhanceengine/container/ContainerModel;", "load", "", "json", "", "toJsonString", "lib-chatsearch-resultpage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ChatSearchBeeTabContainerModel.kt */
public final class ChatSearchBeeTabContainerModel extends TabContainerModel {
    private SSAiResultPageModel aiResultPageModel = new SSAiResultPageModel();

    public final SSAiResultPageModel getAiResultPageModel() {
        return this.aiResultPageModel;
    }

    public final void setAiResultPageModel(SSAiResultPageModel sSAiResultPageModel) {
        Intrinsics.checkNotNullParameter(sSAiResultPageModel, "<set-?>");
        this.aiResultPageModel = sSAiResultPageModel;
    }

    public String toJsonString() {
        return this.aiResultPageModel.toJsonString();
    }

    public boolean load(String json) {
        try {
            if (this.aiResultPageModel.load(json)) {
                return true;
            }
            return false;
        } catch (JSONException e2) {
            if (!AppConfig.isDebug()) {
                return false;
            }
            e2.printStackTrace();
            return false;
        }
    }

    public Class<Container<ContainerModel>> getContainerClass() {
        return ChatSearchBeeTabContainer.class;
    }
}
