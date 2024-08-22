package com.baidu.searchbox.video.feedflow.detail.player.player;

import com.baidu.searchbox.player.menu.constant.MenuItemType;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0014\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H&J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0004H&¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/player/player/ICustomMenuListener;", "", "getItemData", "", "Lcom/baidu/searchbox/player/menu/constant/MenuItemType;", "Lcom/baidu/searchbox/video/feedflow/detail/player/player/CustomItemInitData;", "onCustomItemClick", "", "menuItemType", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoPlayerCallbackManager.kt */
public interface ICustomMenuListener {
    Map<MenuItemType, CustomItemInitData> getItemData();

    void onCustomItemClick(MenuItemType menuItemType);
}
