package com.baidu.searchbox.bookmark.favor.webvideo;

import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.favor.IFavorManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/favor/IFavorManager;", "kotlin.jvm.PlatformType", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: FavorWebVideoView.kt */
final class FavorWebVideoView$mIFavorManager$2 extends Lambda implements Function0<IFavorManager> {
    public static final FavorWebVideoView$mIFavorManager$2 INSTANCE = new FavorWebVideoView$mIFavorManager$2();

    FavorWebVideoView$mIFavorManager$2() {
        super(0);
    }

    public final IFavorManager invoke() {
        return (IFavorManager) ServiceManager.getService(IFavorManager.SERVICE_REFERENCE);
    }
}
