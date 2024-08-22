package com.baidu.searchbox.account.userinfo.feed;

import android.content.res.Resources;
import com.baidu.searchbox.account.userinfo.R;
import com.baidu.searchbox.common.runtime.AppRuntime;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: CustomSnapHelper.kt */
final class CustomSnapHelper$offset$2 extends Lambda implements Function0<Integer> {
    public static final CustomSnapHelper$offset$2 INSTANCE = new CustomSnapHelper$offset$2();

    CustomSnapHelper$offset$2() {
        super(0);
    }

    public final Integer invoke() {
        Resources resources = AppRuntime.getAppContext().getResources();
        return Integer.valueOf(resources.getDimensionPixelSize(R.dimen.user_pull_arrow_margin_left) + resources.getDimensionPixelSize(R.dimen.user_pull_arrow_margin_right) + resources.getDimensionPixelOffset(R.dimen.video_collection_item_left_offset));
    }
}
