package com.baidu.searchbox.lockscreen.view;

import android.view.View;
import com.baidu.searchbox.lockscreen.util.LockScreenCommonUtils;
import com.baidu.searchbox.lockscreen.viewpager.BasePageTransformer;

public class LockScreenPageTransformer extends BasePageTransformer {
    public void transformPage(View view2, float position) {
        super.transformPage(view2, position);
        LockScreenCommonUtils.doReversalAnim(view2, super.getActuralScale());
    }
}
