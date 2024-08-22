package com.baidu.searchbox.bigimage.model;

import android.view.View;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@StableApi
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bg\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/ImageCallerViewInfo;", "", "findTalosView", "Landroid/view/View;", "pageId", "", "findWebView", "webViewScale", "", "lib-bigimage-interfaces_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageCallerInfo.kt */
public interface ImageCallerViewInfo {
    View findTalosView(String str);

    View findWebView();

    float webViewScale();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageCallerInfo.kt */
    public static final class DefaultImpls {
        public static View findTalosView(ImageCallerViewInfo imageCallerViewInfo, String pageId) {
            Intrinsics.checkNotNullParameter(pageId, "pageId");
            return null;
        }

        public static View findWebView(ImageCallerViewInfo imageCallerViewInfo) {
            return null;
        }

        public static float webViewScale(ImageCallerViewInfo imageCallerViewInfo) {
            return 1.0f;
        }
    }
}
