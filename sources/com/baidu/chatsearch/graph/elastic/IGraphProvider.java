package com.baidu.chatsearch.graph.elastic;

import android.view.MotionEvent;
import com.baidu.pyramid.annotation.nps.PluginAccessible;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J(\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\tH'J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH'J\b\u0010\r\u001a\u00020\u0003H'J\b\u0010\u000e\u001a\u00020\u0003H'J\u0012\u0010\u000f\u001a\u00020\u00032\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H'J\b\u0010\u0012\u001a\u00020\u0003H'¨\u0006\u0013"}, d2 = {"Lcom/baidu/chatsearch/graph/elastic/IGraphProvider;", "Lcom/baidu/searchbox/NoProGuard;", "changeToFullStatus", "", "source", "", "animate", "", "complete", "Lkotlin/Function0;", "onGraphEvent", "params", "Lorg/json/JSONObject;", "onJsReady", "onRenderProcessGone", "onWebViewTouchEvent", "motionEvent", "Landroid/view/MotionEvent;", "resultPageGoBackBlock", "lib-chatsearch-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAccessible
/* compiled from: IGraphProvider.kt */
public interface IGraphProvider extends NoProGuard {
    @PluginAccessible
    void changeToFullStatus(String str, boolean z, Function0<Unit> function0);

    @PluginAccessible
    void onGraphEvent(JSONObject jSONObject);

    @PluginAccessible
    void onJsReady();

    @PluginAccessible
    void onRenderProcessGone();

    @PluginAccessible
    void onWebViewTouchEvent(MotionEvent motionEvent);

    @PluginAccessible
    void resultPageGoBackBlock();

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IGraphProvider.kt */
    public static final class DefaultImpls {
        public static /* synthetic */ void changeToFullStatus$default(IGraphProvider iGraphProvider, String str, boolean z, Function0 function0, int i2, Object obj) {
            if (obj == null) {
                if ((i2 & 1) != 0) {
                    str = "";
                }
                iGraphProvider.changeToFullStatus(str, z, function0);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: changeToFullStatus");
        }
    }
}
