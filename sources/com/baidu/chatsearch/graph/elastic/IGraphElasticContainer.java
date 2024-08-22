package com.baidu.chatsearch.graph.elastic;

import android.content.Context;
import android.view.View;
import com.baidu.chatsearch.graph.OpenChatSearchParams;
import com.baidu.pyramid.annotation.nps.PluginAccessible;
import com.baidu.pyramid.annotation.tekes.StableApi;
import com.baidu.searchbox.NoProGuard;
import kotlin.Metadata;
import org.json.JSONObject;

@StableApi
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001d\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H'J\b\u0010\u0006\u001a\u00020\u0005H'J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\b\u001a\u0004\u0018\u00010\tH'J\b\u0010\n\u001a\u00020\u0003H'J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\tH'J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH'J\u001c\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\b\u0010\f\u001a\u0004\u0018\u00010\u0014H'J\u0018\u0010\u0015\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH'J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H'J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H'J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0017H'J\n\u0010\u001b\u001a\u0004\u0018\u00010\u0017H'J\u0012\u0010\u001c\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H'J\b\u0010\u001e\u001a\u00020\u0005H'J\u000f\u0010\u001f\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0003H'J\b\u0010\"\u001a\u00020\u0003H'J\u0012\u0010#\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013H\u0017J\b\u0010$\u001a\u00020\u0003H\u0017J\b\u0010%\u001a\u00020\u0003H\u0017J\b\u0010&\u001a\u00020\u0003H\u0017J\b\u0010'\u001a\u00020\u0003H\u0017J\b\u0010(\u001a\u00020\u0003H\u0017J\b\u0010)\u001a\u00020\u0003H\u0017J\b\u0010*\u001a\u00020\u0003H'J\u001e\u0010+\u001a\u0004\u0018\u00010\u00172\b\u0010,\u001a\u0004\u0018\u00010\u00172\b\u0010-\u001a\u0004\u0018\u00010\u0017H'J\n\u0010.\u001a\u0004\u0018\u00010\u0019H'J\u0017\u0010/\u001a\u00020\u00032\b\u00100\u001a\u0004\u0018\u00010\u0005H'¢\u0006\u0002\u00101J\u0012\u00102\u001a\u00020\u00032\b\u0010\u001d\u001a\u0004\u0018\u00010\u0019H'J\b\u00103\u001a\u00020\u0003H'J\u0010\u00104\u001a\u00020\u00032\u0006\u00105\u001a\u00020\u000fH'¨\u00066"}, d2 = {"Lcom/baidu/chatsearch/graph/elastic/IGraphElasticContainer;", "Lcom/baidu/searchbox/NoProGuard;", "changeContainerMode", "", "isFullScreen", "", "checkWebViewPopMenuStatus", "cleanH5Content", "jsonObject", "Lorg/json/JSONObject;", "cleanInputBarText", "dispatchGraphEvent", "params", "doErrorViewScroll", "originY", "", "currentY", "doGraphSearch", "context", "Landroid/content/Context;", "Lcom/baidu/chatsearch/graph/OpenChatSearchParams;", "doHalfScreenScroll", "getCraftId", "", "getCurrentWebView", "Landroid/view/View;", "getResultExtClickParams", "getUbcSource", "hideAiInputBarAnimate", "parentView", "isResultPageBusy", "onBackPressed", "()Ljava/lang/Boolean;", "onContainerEnter", "onContainerLeave", "onCreate", "onDestroy", "onPause", "onRestart", "onResume", "onStart", "onStop", "preloadContainerSearchFrame", "recordLocalImageUriToInterceptedUrl", "imageId", "localURI", "rootView", "setFitHighHalfMode", "needFitHighHalfMode", "(Ljava/lang/Boolean;)V", "showAiInputBarAnimate", "showInputView", "updateWebViewContentOffSet", "offset", "lib-chatsearch-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
@PluginAccessible
/* compiled from: IGraphElasticContainer.kt */
public interface IGraphElasticContainer extends NoProGuard {
    @PluginAccessible
    void changeContainerMode(boolean z);

    @PluginAccessible
    boolean checkWebViewPopMenuStatus();

    @PluginAccessible
    void cleanH5Content(JSONObject jSONObject);

    @PluginAccessible
    void cleanInputBarText();

    @PluginAccessible
    void dispatchGraphEvent(JSONObject jSONObject);

    @PluginAccessible
    void doErrorViewScroll(int i2, int i3);

    @PluginAccessible
    void doGraphSearch(Context context, OpenChatSearchParams openChatSearchParams);

    @PluginAccessible
    void doHalfScreenScroll(int i2, int i3);

    @PluginAccessible
    String getCraftId();

    @PluginAccessible
    View getCurrentWebView();

    @PluginAccessible
    String getResultExtClickParams();

    @PluginAccessible
    String getUbcSource();

    @PluginAccessible
    void hideAiInputBarAnimate(View view2);

    @PluginAccessible
    boolean isResultPageBusy();

    @PluginAccessible
    Boolean onBackPressed();

    @PluginAccessible
    void onContainerEnter();

    @PluginAccessible
    void onContainerLeave();

    @PluginAccessible
    void onCreate(Context context);

    @PluginAccessible
    void onDestroy();

    @PluginAccessible
    void onPause();

    @PluginAccessible
    void onRestart();

    @PluginAccessible
    void onResume();

    @PluginAccessible
    void onStart();

    @PluginAccessible
    void onStop();

    @PluginAccessible
    void preloadContainerSearchFrame();

    @PluginAccessible
    String recordLocalImageUriToInterceptedUrl(String str, String str2);

    @PluginAccessible
    View rootView();

    @PluginAccessible
    void setFitHighHalfMode(Boolean bool);

    @PluginAccessible
    void showAiInputBarAnimate(View view2);

    @PluginAccessible
    void showInputView();

    @PluginAccessible
    void updateWebViewContentOffSet(int i2);

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IGraphElasticContainer.kt */
    public static final class DefaultImpls {
        @PluginAccessible
        public static void onCreate(IGraphElasticContainer iGraphElasticContainer, Context context) {
        }

        @PluginAccessible
        public static void onDestroy(IGraphElasticContainer iGraphElasticContainer) {
        }

        @PluginAccessible
        public static void onResume(IGraphElasticContainer iGraphElasticContainer) {
        }

        @PluginAccessible
        public static void onPause(IGraphElasticContainer iGraphElasticContainer) {
        }

        @PluginAccessible
        public static void onStop(IGraphElasticContainer iGraphElasticContainer) {
        }

        @PluginAccessible
        public static void onStart(IGraphElasticContainer iGraphElasticContainer) {
        }

        @PluginAccessible
        public static void onRestart(IGraphElasticContainer iGraphElasticContainer) {
        }
    }
}
