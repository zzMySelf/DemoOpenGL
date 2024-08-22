package com.baidu.searchbox.video.feedflow.detail.author;

import com.baidu.searchbox.feed.detail.frame.Store;
import com.baidu.searchbox.video.feedflow.common.CommonStateExtKt;
import com.baidu.searchbox.video.widget.viewpager2.OnScrollChangedListener;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\t\n\u0000\n\u0002\b\u0003*\u0001\u0001\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "com/baidu/searchbox/video/feedflow/detail/author/AuthorComponent$listScrollListener$2$1", "invoke", "()Lcom/baidu/searchbox/video/feedflow/detail/author/AuthorComponent$listScrollListener$2$1;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorComponent.kt */
final class AuthorComponent$listScrollListener$2 extends Lambda implements Function0<AnonymousClass1> {
    final /* synthetic */ AuthorComponent this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthorComponent$listScrollListener$2(AuthorComponent authorComponent) {
        super(0);
        this.this$0 = authorComponent;
    }

    public final AnonymousClass1 invoke() {
        final AuthorComponent authorComponent = this.this$0;
        return new OnScrollChangedListener() {
            public void onItemScrolled(int position, float positionOffset, int positionOffsetPixels) {
                OnScrollChangedListener.DefaultImpls.onItemScrolled(this, position, positionOffset, positionOffsetPixels);
            }

            public void onPageScrolled(int state, int dx, int dy) {
                OnScrollChangedListener.DefaultImpls.onPageScrolled(this, state, dx, dy);
            }

            public void onScrollStateChanged(int state, String direction) {
                AuthorView access$getAvatar;
                AuthorView access$getAvatar2;
                Intrinsics.checkNotNullParameter(direction, "direction");
                Store access$getStore = authorComponent.getStore();
                boolean z = false;
                if (access$getStore != null && CommonStateExtKt.isActive(access$getStore)) {
                    z = true;
                }
                if (z) {
                    switch (state) {
                        case 0:
                            if (!(authorComponent.recyclerViewScrollState == 0 || (access$getAvatar = authorComponent.getAvatar()) == null)) {
                                access$getAvatar.resumeLiveLottieAnim();
                                break;
                            }
                        case 1:
                            if (!(authorComponent.recyclerViewScrollState == 1 || (access$getAvatar2 = authorComponent.getAvatar()) == null)) {
                                access$getAvatar2.pauseLiveLottieAnim();
                                break;
                            }
                    }
                    authorComponent.recyclerViewScrollState = state;
                }
            }
        };
    }
}
