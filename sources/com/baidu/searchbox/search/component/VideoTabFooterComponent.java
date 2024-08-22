package com.baidu.searchbox.search.component;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.feed.list.widget.CommonFooterView;
import com.baidu.searchbox.feed.list.widget.IRefreshFooter;
import com.baidu.searchbox.search.tab.core.component.Component;
import com.baidu.searchbox.search.tab.core.component.IComponent;
import com.baidu.searchbox.search.tab.core.manager.IServiceManager;
import com.baidu.searchbox.search.tab.implement.service.IFooterService;
import com.baidu.searchbox.search.video.business.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0005H\u0016J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0017J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/search/component/VideoTabFooterComponent;", "Lcom/baidu/searchbox/search/tab/core/component/Component;", "Lcom/baidu/searchbox/search/tab/implement/service/IFooterService;", "()V", "getComponentName", "Ljava/lang/Class;", "Lcom/baidu/searchbox/search/tab/core/component/IComponent;", "handleFooterView", "Lcom/baidu/searchbox/feed/list/widget/IRefreshFooter;", "mContext", "Landroid/content/Context;", "footer", "Lcom/baidu/searchbox/feed/list/widget/CommonFooterView;", "registerServices", "", "serviceManager", "Lcom/baidu/searchbox/search/tab/core/manager/IServiceManager;", "lib_search_video_tab_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoTabFooterComponent.kt */
public final class VideoTabFooterComponent extends Component implements IFooterService {
    public Class<? extends IComponent> getComponentName() {
        return VideoTabFooterComponent.class;
    }

    public void registerServices(IServiceManager serviceManager) {
        Intrinsics.checkNotNullParameter(serviceManager, "serviceManager");
        serviceManager.registerService(IFooterService.class, new VideoTabFooterComponent$registerServices$1(this));
    }

    public IRefreshFooter handleFooterView(Context mContext, CommonFooterView footer) {
        Intrinsics.checkNotNullParameter(mContext, "mContext");
        Intrinsics.checkNotNullParameter(footer, "footer");
        footer.setVisibility(0);
        View rightCircleIconView = footer.getRightCircleIconView();
        if (rightCircleIconView != null) {
            rightCircleIconView.setVisibility(8);
        }
        footer.getStyleMap().put(1996555042, R.string.video_list_no_more_data);
        footer.setOnStateChangedListener(new VideoTabFooterComponent$$ExternalSyntheticLambda0(footer));
        footer.setCommonBackgroundColor(0);
        footer.getStyleMap().put(1996686114, com.baidu.searchbox.feed.payment.feedpayinterface.R.color.grey_999);
        footer.getStyleMap().put(1996685315, com.baidu.searchbox.feed.payment.feedpayinterface.R.color.grey_999);
        footer.getStyleMap().put(1996685312, com.baidu.searchbox.feed.payment.feedpayinterface.R.color.grey_999);
        footer.updateTheme();
        return footer;
    }

    /* access modifiers changed from: private */
    /* renamed from: handleFooterView$lambda-1  reason: not valid java name */
    public static final void m2746handleFooterView$lambda1(CommonFooterView $footer, int newState) {
        Intrinsics.checkNotNullParameter($footer, "$footer");
        View it = $footer.getRootView();
        if (it != null) {
            boolean z = true;
            it.setClickable(newState != 802);
            if (newState == 802) {
                z = false;
            }
            it.setEnabled(z);
        }
    }
}
