package com.baidu.searchbox.aisearch.comps.page.states;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ScrollView;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000%\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J*\u0010\f\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/aisearch/comps/page/states/ConsoleDebugsKt$buildConsole$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "lib-aisearch-impl_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ConsoleDebugs.kt */
public final class ConsoleDebugsKt$buildConsole$1 implements TextWatcher {
    final /* synthetic */ AtomicBoolean $autoScroll;
    final /* synthetic */ ScrollView $scrollView;

    ConsoleDebugsKt$buildConsole$1(AtomicBoolean $autoScroll2, ScrollView $scrollView2) {
        this.$autoScroll = $autoScroll2;
        this.$scrollView = $scrollView2;
    }

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    public void afterTextChanged(Editable s) {
        ScrollView scrollView;
        if (this.$autoScroll.get() && (scrollView = this.$scrollView) != null) {
            scrollView.scrollBy(0, ViewExKt.getDp(16));
        }
    }
}
