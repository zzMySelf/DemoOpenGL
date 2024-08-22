package com.baidu.bdtask.component;

import com.baidu.bdtask.utils.ToastUtils;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 2}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 1, 9})
final class GuideViewManager$showGuide$1 extends Lambda implements Function0<String> {
    public static final GuideViewManager$showGuide$1 INSTANCE = new GuideViewManager$showGuide$1();

    GuideViewManager$showGuide$1() {
        super(0);
    }

    public final String invoke() {
        return "skip and add registered toast to pending queue by systemToastShowAble:" + ToastUtils.systemToastShowAble();
    }
}
