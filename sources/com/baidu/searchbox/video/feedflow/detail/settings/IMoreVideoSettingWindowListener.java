package com.baidu.searchbox.video.feedflow.detail.settings;

import com.baidu.searchbox.video.feedflow.detail.longpressmore.model.MoreBottomItemType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u001a\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0016¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/settings/IMoreVideoSettingWindowListener;", "", "onBottomItemCheckChanged", "", "itemType", "", "checked", "", "onBottomItemClicked", "onSmartPlayViewClickChanged", "clickBeforePosition", "status", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSettingsOptionPanel.kt */
public interface IMoreVideoSettingWindowListener {
    void onBottomItemCheckChanged(@MoreBottomItemType int i2, boolean z);

    void onBottomItemClicked(@MoreBottomItemType int i2);

    void onSmartPlayViewClickChanged(int i2, int i3);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: VideoSettingsOptionPanel.kt */
    public static final class DefaultImpls {
        public static void onBottomItemCheckChanged(IMoreVideoSettingWindowListener iMoreVideoSettingWindowListener, @MoreBottomItemType int itemType, boolean checked) {
        }

        public static void onSmartPlayViewClickChanged(IMoreVideoSettingWindowListener iMoreVideoSettingWindowListener, int clickBeforePosition, int status) {
        }

        public static void onBottomItemClicked(IMoreVideoSettingWindowListener iMoreVideoSettingWindowListener, @MoreBottomItemType int itemType) {
        }
    }
}
