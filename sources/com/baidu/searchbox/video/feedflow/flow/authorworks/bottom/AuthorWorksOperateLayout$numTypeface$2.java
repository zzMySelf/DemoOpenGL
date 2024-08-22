package com.baidu.searchbox.video.feedflow.flow.authorworks.bottom;

import android.graphics.Typeface;
import com.baidu.searchbox.video.feedflow.utils.VideoFlowUtilsKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/Typeface;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: AuthorWorksOperateLayout.kt */
final class AuthorWorksOperateLayout$numTypeface$2 extends Lambda implements Function0<Typeface> {
    public static final AuthorWorksOperateLayout$numTypeface$2 INSTANCE = new AuthorWorksOperateLayout$numTypeface$2();

    AuthorWorksOperateLayout$numTypeface$2() {
        super(0);
    }

    public final Typeface invoke() {
        return VideoFlowUtilsKt.getNumberFont();
    }
}
