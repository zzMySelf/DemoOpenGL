package com.baidu.searchbox.newhome.content.fragment.inter;

import android.os.Bundle;
import com.baidu.searchbox.newhome.content.fragment.HomeContentItemFragment;
import com.baidu.searchbox.newhome.content.fragment.HomeContentItemFragmentKt;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/newhome/content/fragment/inter/HomeFeedContentFragmentExt;", "Lcom/baidu/searchbox/newhome/content/fragment/inter/IHomeContentFragmentExt;", "()V", "createFragment", "Lcom/baidu/searchbox/newhome/content/fragment/HomeContentItemFragment;", "tabId", "", "isCurrentTab", "", "new-home-content_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HomeFeedContentFragment.kt */
public final class HomeFeedContentFragmentExt implements IHomeContentFragmentExt {
    public boolean isCurrentTab(String tabId) {
        return Intrinsics.areEqual((Object) tabId, (Object) "509");
    }

    public HomeContentItemFragment createFragment(String tabId) {
        HomeFeedContentFragment $this$createFragment_u24lambda_u2d1 = new HomeFeedContentFragment();
        Bundle $this$createFragment_u24lambda_u2d1_u24lambda_u2d0 = new Bundle();
        $this$createFragment_u24lambda_u2d1_u24lambda_u2d0.putSerializable(HomeContentItemFragmentKt.KEY_NEW_HOME_CHANNEL, tabId);
        $this$createFragment_u24lambda_u2d1.setArguments($this$createFragment_u24lambda_u2d1_u24lambda_u2d0);
        return $this$createFragment_u24lambda_u2d1;
    }
}
