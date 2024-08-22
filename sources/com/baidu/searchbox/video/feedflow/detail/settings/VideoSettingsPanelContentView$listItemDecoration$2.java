package com.baidu.searchbox.video.feedflow.detail.settings;

import android.content.Context;
import com.baidu.searchbox.video.feedflow.detail.longpressmore.MenuListItemDecoration;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/longpressmore/MenuListItemDecoration;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoSettingsPanelContentView.kt */
final class VideoSettingsPanelContentView$listItemDecoration$2 extends Lambda implements Function0<MenuListItemDecoration> {
    final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    VideoSettingsPanelContentView$listItemDecoration$2(Context context) {
        super(0);
        this.$context = context;
    }

    public final MenuListItemDecoration invoke() {
        return new MenuListItemDecoration(this.$context, DIFactory.INSTANCE.dp2px(10.0f), 0, 4, (DefaultConstructorMarker) null);
    }
}
