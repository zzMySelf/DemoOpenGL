package com.baidu.searchbox.video.feedflow.flow.authorworks.bottom;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorWorksBottomContainer.kt */
final class AuthorWorksBottomContainer$minimumFlingVelocity$2 extends Lambda implements Function0<Integer> {
    final /* synthetic */ AuthorWorksBottomContainer this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AuthorWorksBottomContainer$minimumFlingVelocity$2(AuthorWorksBottomContainer authorWorksBottomContainer) {
        super(0);
        this.this$0 = authorWorksBottomContainer;
    }

    public final Integer invoke() {
        return Integer.valueOf(this.this$0.getViewConfiguration().getScaledMinimumFlingVelocity());
    }
}
