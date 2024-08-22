package com.baidu.searchbox.youthhome.content.frgment.ext;

import androidx.fragment.app.FragmentActivity;
import com.baidu.searchbox.youthhome.content.frgment.IYouthHomeFragmentExt;
import com.baidu.searchbox.youthhome.content.frgment.YouthContentBaseFragment;
import com.baidu.searchbox.youthhome.content.frgment.impl.YouthHomeFeedFragment;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/youthhome/content/frgment/ext/FeedContentFragmentExt;", "Lcom/baidu/searchbox/youthhome/content/frgment/IYouthHomeFragmentExt;", "()V", "createFragment", "Lcom/baidu/searchbox/youthhome/content/frgment/YouthContentBaseFragment;", "activity", "Landroidx/fragment/app/FragmentActivity;", "tabId", "", "isCurrentTab", "", "youth-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FeedContentFragmentExt.kt */
public final class FeedContentFragmentExt implements IYouthHomeFragmentExt {
    public boolean isCurrentTab(String tabId) {
        return Intrinsics.areEqual((Object) tabId, (Object) "215");
    }

    public YouthContentBaseFragment createFragment(FragmentActivity activity, String tabId) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        return new YouthHomeFeedFragment();
    }
}
