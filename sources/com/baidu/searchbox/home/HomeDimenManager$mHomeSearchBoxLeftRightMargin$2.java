package com.baidu.searchbox.home;

import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.home.tools.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeDimenManager.kt */
final class HomeDimenManager$mHomeSearchBoxLeftRightMargin$2 extends Lambda implements Function0<Integer> {
    public static final HomeDimenManager$mHomeSearchBoxLeftRightMargin$2 INSTANCE = new HomeDimenManager$mHomeSearchBoxLeftRightMargin$2();

    HomeDimenManager$mHomeSearchBoxLeftRightMargin$2() {
        super(0);
    }

    public final Integer invoke() {
        return Integer.valueOf(AppRuntime.getAppContext().getResources().getDimensionPixelOffset(R.dimen.home_searchbox_left_right_margin));
    }
}
