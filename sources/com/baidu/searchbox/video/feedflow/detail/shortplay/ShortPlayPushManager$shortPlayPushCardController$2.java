package com.baidu.searchbox.video.feedflow.detail.shortplay;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lcom/baidu/searchbox/video/feedflow/detail/shortplay/ShortPlayPushCardController;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: ShortPlayPushManager.kt */
final class ShortPlayPushManager$shortPlayPushCardController$2 extends Lambda implements Function0<ShortPlayPushCardController> {
    public static final ShortPlayPushManager$shortPlayPushCardController$2 INSTANCE = new ShortPlayPushManager$shortPlayPushCardController$2();

    ShortPlayPushManager$shortPlayPushCardController$2() {
        super(0);
    }

    public final ShortPlayPushCardController invoke() {
        return new ShortPlayPushCardController(ShortPlayPushManager.INSTANCE.getConfig());
    }
}
