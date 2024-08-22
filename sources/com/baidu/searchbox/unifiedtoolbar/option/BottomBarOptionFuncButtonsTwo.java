package com.baidu.searchbox.unifiedtoolbar.option;

import com.baidu.searchbox.unifiedtoolbar.base.BottomBarElementID;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/unifiedtoolbar/option/BottomBarOptionFuncButtonsTwo;", "Lcom/baidu/searchbox/unifiedtoolbar/option/UnifiedBottomBarOption;", "()V", "getElementOptions", "", "Lcom/baidu/searchbox/unifiedtoolbar/option/BottomBarElementOption;", "lib-unified-toolbar_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BottomBarOptionFuncButtonsTwo.kt */
public final class BottomBarOptionFuncButtonsTwo extends UnifiedBottomBarOption {
    public List<BottomBarElementOption> getElementOptions() {
        return CollectionsKt.listOf(new BottomBarElementOption(BottomBarElementID.ELEMENT_ID_BACK), new BottomBarElementOption(BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_1), new BottomBarElementOption(BottomBarElementID.ELEMENT_ID_FUNC_BUTTON_2));
    }
}
