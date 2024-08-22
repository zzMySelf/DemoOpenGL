package com.baidu.searchbox.hissug.data.utils.debug;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.CheckBox;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J(\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J(\u0010\r\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f"}, d2 = {"com/baidu/searchbox/hissug/data/utils/debug/HissugDebugConfigProvider$getInputDebugConfig$2$fetchView$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "str", "Landroid/text/Editable;", "beforeTextChanged", "s", "", "start", "", "count", "after", "onTextChanged", "before", "lib_hissug_data_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HissugDebugConfigProvider.kt */
public final class HissugDebugConfigProvider$getInputDebugConfig$2$fetchView$2 implements TextWatcher {
    final /* synthetic */ CheckBox $avaNumCB;

    HissugDebugConfigProvider$getInputDebugConfig$2$fetchView$2(CheckBox $avaNumCB2) {
        this.$avaNumCB = $avaNumCB2;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        Intrinsics.checkNotNullParameter(s, "s");
        this.$avaNumCB.setChecked(false);
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
        Intrinsics.checkNotNullParameter(s, "s");
    }

    public void afterTextChanged(Editable str) {
        Intrinsics.checkNotNullParameter(str, "str");
    }
}
