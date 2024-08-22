package com.baidu.searchbox.reward;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J5\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H&¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/reward/OnGuideListener;", "", "onResultGuide", "", "guideType", "", "toast", "readProgress", "", "guideStyle", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/String;)V", "lib-reward-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OnGuideListener.kt */
public interface OnGuideListener {
    void onResultGuide(String str, String str2, Integer num, String str3);
}
