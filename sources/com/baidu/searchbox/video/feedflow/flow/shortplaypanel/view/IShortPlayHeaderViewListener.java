package com.baidu.searchbox.video.feedflow.flow.shortplaypanel.view;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/flow/shortplaypanel/view/IShortPlayHeaderViewListener;", "", "clickCloseBtn", "", "clickSubTitle", "cmd", "", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPanelTitleView.kt */
public interface IShortPlayHeaderViewListener {
    void clickCloseBtn();

    void clickSubTitle(String str);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ShortPlayPanelTitleView.kt */
    public static final class DefaultImpls {
        public static void clickCloseBtn(IShortPlayHeaderViewListener iShortPlayHeaderViewListener) {
        }

        public static void clickSubTitle(IShortPlayHeaderViewListener iShortPlayHeaderViewListener, String cmd) {
            Intrinsics.checkNotNullParameter(cmd, "cmd");
        }
    }
}
