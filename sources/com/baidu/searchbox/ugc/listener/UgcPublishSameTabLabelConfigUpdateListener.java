package com.baidu.searchbox.ugc.listener;

import com.baidu.searchbox.ugc.utils.UgcUpdateConfigUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\nH\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/ugc/listener/UgcPublishSameTabLabelConfigUpdateListener;", "Lcom/baidu/searchbox/ugc/listener/BaseUgcUpdateListener;", "()V", "getAction", "", "handleUpdateData", "", "data", "Lorg/json/JSONObject;", "isSaveAllData", "", "Companion", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: UgcPublishSameTabLabelConfigUpdateListener.kt */
public final class UgcPublishSameTabLabelConfigUpdateListener extends BaseUgcUpdateListener {
    public static final String CLOUD_ACTION = "publish_same_tab_new_label";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String LABEL_SHOW_ENABLE_KEY = "publish_same_tab_new_switch";

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/baidu/searchbox/ugc/listener/UgcPublishSameTabLabelConfigUpdateListener$Companion;", "", "()V", "CLOUD_ACTION", "", "LABEL_SHOW_ENABLE_KEY", "getLabelShowEnable", "", "lib-ugc-core_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: UgcPublishSameTabLabelConfigUpdateListener.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean getLabelShowEnable() {
            JSONObject data = UgcUpdateConfigUtil.INSTANCE.getAllSaveData(UgcPublishSameTabLabelConfigUpdateListener.CLOUD_ACTION);
            if (data == null) {
                return false;
            }
            boolean showEnable = false;
            if (data.optInt(UgcPublishSameTabLabelConfigUpdateListener.LABEL_SHOW_ENABLE_KEY, 0) == 1) {
                showEnable = true;
            }
            return showEnable;
        }
    }

    public String getAction() {
        return CLOUD_ACTION;
    }

    public void handleUpdateData(JSONObject data) {
        Intrinsics.checkNotNullParameter(data, "data");
    }

    public boolean isSaveAllData() {
        return true;
    }
}
