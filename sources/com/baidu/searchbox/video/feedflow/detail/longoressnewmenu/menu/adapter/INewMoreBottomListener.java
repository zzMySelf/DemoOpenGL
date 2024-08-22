package com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.menu.adapter;

import com.baidu.searchbox.video.feedflow.detail.longoressnewmenu.model.NewMoreItemType;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\u001a\u0010\u0006\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u0005H\u0016J\"\u0010\n\u001a\u00020\u00032\b\b\u0001\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/longoressnewmenu/menu/adapter/INewMoreBottomListener;", "", "onBottomItemArrowClick", "", "itemType", "", "onBottomItemButtonChanged", "checked", "", "onBottomItemHighLightClick", "onBottomItemSliderClick", "clickBeforePosition", "clickPosition", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: NewMoreBottomAdapter.kt */
public interface INewMoreBottomListener {
    void onBottomItemArrowClick(@NewMoreItemType int i2);

    void onBottomItemButtonChanged(@NewMoreItemType int i2, boolean z);

    void onBottomItemHighLightClick(@NewMoreItemType int i2);

    void onBottomItemSliderClick(@NewMoreItemType int i2, int i3, int i4);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: NewMoreBottomAdapter.kt */
    public static final class DefaultImpls {
        public static void onBottomItemButtonChanged(INewMoreBottomListener iNewMoreBottomListener, @NewMoreItemType int itemType, boolean checked) {
        }

        public static void onBottomItemArrowClick(INewMoreBottomListener iNewMoreBottomListener, @NewMoreItemType int itemType) {
        }

        public static void onBottomItemHighLightClick(INewMoreBottomListener iNewMoreBottomListener, @NewMoreItemType int itemType) {
        }

        public static void onBottomItemSliderClick(INewMoreBottomListener iNewMoreBottomListener, @NewMoreItemType int itemType, int clickBeforePosition, int clickPosition) {
        }
    }
}
