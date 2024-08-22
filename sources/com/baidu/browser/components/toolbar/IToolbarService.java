package com.baidu.browser.components.toolbar;

import android.view.View;
import com.baidu.browser.arch.service.IBrowserService;
import kotlin.Metadata;
import org.json.JSONObject;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\n\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\f\u001a\u0004\u0018\u00010\rH&J\b\u0010\u000e\u001a\u00020\u0003H&J\b\u0010\u000f\u001a\u00020\u0006H&J\b\u0010\u0010\u001a\u00020\u0006H&J\b\u0010\u0011\u001a\u00020\u0006H&J\b\u0010\u0012\u001a\u00020\u0006H&J\b\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u0014\u001a\u00020\u0003H&J\u0012\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H&J\u0010\u0010\u0018\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u0006H&J\u0010\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0013\u001a\u00020\u0006H&J\b\u0010\u001a\u001a\u00020\u0006H&J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\rH&J\b\u0010\u001d\u001a\u00020\u0003H&¨\u0006\u001e"}, d2 = {"Lcom/baidu/browser/components/toolbar/IToolbarService;", "Lcom/baidu/browser/arch/service/IBrowserService;", "delayInitTopicToolbar", "", "destroyBottomView", "dispatchEvent", "", "event", "Lcom/baidu/browser/components/toolbar/ToolbarItemEvent;", "getToolbar", "Landroid/view/View;", "hideBackground", "h5LandingtoolbarInfo", "", "initBottomView", "isGroupTopic", "isNewAndNotH5Toolbar", "isThemePage", "isThemeToolBar", "isTwoLineTopic", "recordClickShare", "setBtnClickable", "json", "Lorg/json/JSONObject;", "setIsGroupTopic", "setIsTwoLineTopic", "shouldShowShareRedTipOnMenu", "showThemeToolBar", "url", "updateCommentInfo", "lib-browser_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IToolbarService.kt */
public interface IToolbarService extends IBrowserService {
    void delayInitTopicToolbar();

    void destroyBottomView();

    boolean dispatchEvent(ToolbarItemEvent toolbarItemEvent);

    View getToolbar();

    boolean hideBackground(String str);

    void initBottomView();

    boolean isGroupTopic();

    boolean isNewAndNotH5Toolbar();

    boolean isThemePage();

    boolean isThemeToolBar();

    boolean isTwoLineTopic();

    void recordClickShare();

    void setBtnClickable(JSONObject jSONObject);

    void setIsGroupTopic(boolean z);

    void setIsTwoLineTopic(boolean z);

    boolean shouldShowShareRedTipOnMenu();

    boolean showThemeToolBar(String str);

    void updateCommentInfo();
}
