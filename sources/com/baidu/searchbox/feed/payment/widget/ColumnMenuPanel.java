package com.baidu.searchbox.feed.payment.widget;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.baidu.android.common.menu.CommonMenu;
import com.baidu.android.common.menu.CommonMenuConfig;
import com.baidu.android.common.menu.CommonMenuItem;
import com.baidu.android.ext.widget.toast.UniversalToast;
import com.baidu.searchbox.appframework.ext.CommonMenuExtKt;
import com.baidu.searchbox.appframework.ext.ICommonMenuExt;
import com.baidu.searchbox.feed.payment.FeedpayKt;
import com.baidu.searchbox.feed.payment.column.facets.SpColumnContext;
import com.baidu.searchbox.feed.payment.model.SpColumnDetailData;
import com.baidu.searchbox.feed.payment.model.SpDetailShareInfo;
import com.baidu.searchbox.feed.pinchsummary.FeedPinchSummaryManager;
import com.baidu.searchbox.lightbrowser.IToolBarFrameworkContext;
import com.baidu.searchbox.lightbrowser.ToolBarFrameworkRuntime;
import com.baidu.searchbox.lightbrowser.base.R;
import com.baidu.searchbox.lightbrowser.model.PageReportData;
import com.baidu.searchbox.menu.data.CommonMenuItemHandleHelper;
import com.baidu.searchbox.menu.data.CommonMenuStatisticConstants;
import com.baidu.searchbox.menu.data.CommonMenuStyle;
import com.baidu.searchbox.socialshare.BDShare;
import com.baidu.searchbox.video.feedflow.detail.banner.model.FlowDetailBannerModelKt;
import com.baidu.share.common.util.WrappedClipboardManager;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000e\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\u000e\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J\n\u0010\u0013\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0014\u001a\u00020\u0003H\u0016J\u0014\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000eH\u0016J\b\u0010\u0016\u001a\u00020\u0017H\u0016J\u0014\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\u000eH\u0016J\u0018\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u000fH\u0016J\u0018\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\u001aH\u0016J\b\u0010\"\u001a\u00020\u0017H\u0002J\b\u0010#\u001a\u00020\u0017H\u0002J\u0014\u0010$\u001a\u0004\u0018\u00010\n2\b\u0010%\u001a\u0004\u0018\u00010\nH\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/feed/payment/widget/ColumnMenuPanel;", "Lcom/baidu/searchbox/appframework/ext/ICommonMenuExt;", "context", "Landroid/content/Context;", "columnContext", "Lcom/baidu/searchbox/feed/payment/column/facets/SpColumnContext;", "(Landroid/content/Context;Lcom/baidu/searchbox/feed/payment/column/facets/SpColumnContext;)V", "getColumnContext", "()Lcom/baidu/searchbox/feed/payment/column/facets/SpColumnContext;", "commonMenuExtObject", "", "data", "Lcom/baidu/searchbox/feed/payment/model/SpColumnDetailData;", "buildFirstLineMenuList", "", "Lcom/baidu/android/common/menu/CommonMenuItem;", "buildSecondLineMenuList", "getCommonMenuConfig", "Lcom/baidu/android/common/menu/CommonMenuConfig;", "getCommonMenuExtObject", "getExtContext", "getStaticMenuItemLists", "handleJsMenuConfig", "", "handleMenuItemLists", "onCommonMenuItemClick", "", "view", "Landroid/view/View;", "menuItem", "onCommonMenuStateChanged", "menu", "Lcom/baidu/android/common/menu/CommonMenu;", "isShown", "processCopyUrl", "processShare", "setCommonMenuExtObject", "obj", "lib-feed-spcolumn_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ColumnMenuPanel.kt */
public final class ColumnMenuPanel implements ICommonMenuExt {
    private final SpColumnContext columnContext;
    private Object commonMenuExtObject;
    private final Context context;
    private SpColumnDetailData data;

    public ColumnMenuPanel(Context context2, SpColumnContext columnContext2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        Intrinsics.checkNotNullParameter(columnContext2, "columnContext");
        this.context = context2;
        this.columnContext = columnContext2;
        this.data = columnContext2.getDetailViewModel().getDetailData();
    }

    public final SpColumnContext getColumnContext() {
        return this.columnContext;
    }

    public Object getCommonMenuExtObject() {
        return this.commonMenuExtObject;
    }

    public Context getExtContext() {
        return this.context;
    }

    public CommonMenuConfig getCommonMenuConfig() {
        CommonMenuConfig $this$getCommonMenuConfig_u24lambda_u2d0 = new CommonMenuConfig();
        $this$getCommonMenuConfig_u24lambda_u2d0.setSingleLineSlide(false);
        return $this$getCommonMenuConfig_u24lambda_u2d0;
    }

    public List<List<CommonMenuItem>> getStaticMenuItemLists() {
        List menuLists = new ArrayList(2);
        menuLists.add(buildFirstLineMenuList());
        menuLists.add(buildSecondLineMenuList());
        return menuLists;
    }

    public List<List<CommonMenuItem>> handleMenuItemLists() {
        CommonMenuItemHandleHelper.handleCommonMenuItemState(CommonMenuExtKt.getMenuItemLists(this));
        return CommonMenuExtKt.getMenuItemLists(this);
    }

    public boolean onCommonMenuItemClick(View view2, CommonMenuItem menuItem) {
        Intrinsics.checkNotNullParameter(view2, "view");
        Intrinsics.checkNotNullParameter(menuItem, "menuItem");
        switch (menuItem.getItemId()) {
            case 4:
                processShare();
                CommonMenuItemHandleHelper.handleCommonMenuItemClickEvent("share", FlowDetailBannerModelKt.BANNER_TYPE_PAY, (Map<String, String>) null);
                return true;
            case 9:
                IToolBarFrameworkContext toolBarFrameworkContext = ToolBarFrameworkRuntime.getToolBarFrameworkContext();
                Context appContext = FeedpayKt.appContext();
                PageReportData $this$onCommonMenuItemClick_u24lambda_u2d1 = new PageReportData();
                $this$onCommonMenuItemClick_u24lambda_u2d1.nid = this.columnContext.getFeedId();
                Unit unit = Unit.INSTANCE;
                toolBarFrameworkContext.processReport(appContext, FlowDetailBannerModelKt.BANNER_TYPE_PAY, $this$onCommonMenuItemClick_u24lambda_u2d1);
                CommonMenuItemHandleHelper.handleCommonMenuItemClick(view2, menuItem, CommonMenuExtKt.getCommonMenu(this), FlowDetailBannerModelKt.BANNER_TYPE_PAY, (Map<String, String>) null);
                return true;
            case 10:
                processCopyUrl();
                CommonMenuItemHandleHelper.handleCommonMenuItemClickEvent("copylink", FlowDetailBannerModelKt.BANNER_TYPE_PAY, (Map<String, String>) null);
                return true;
            case 28:
                CommonMenuExtKt.dismissMenu(this);
                CommonMenuItemHandleHelper.gotoHomePage(this.context);
                Context context2 = this.context;
                if (context2 instanceof Activity) {
                    ((Activity) context2).finish();
                }
                CommonMenuItemHandleHelper.handleCommonMenuItemClickEvent(CommonMenuStatisticConstants.MENU_TYPE_HOME, FlowDetailBannerModelKt.BANNER_TYPE_PAY, (Map<String, String>) null);
                return true;
            case 66:
                FeedPinchSummaryManager.Companion.menuClickInvokeSummary(this.context);
                CommonMenuItemHandleHelper.handleCommonMenuItemClickEvent("summary", FlowDetailBannerModelKt.BANNER_TYPE_PAY, (Map<String, String>) null);
                CommonMenuExtKt.dismissMenu(this);
                return true;
            default:
                CommonMenuItemHandleHelper.handleCommonMenuItemClick(view2, menuItem, CommonMenuExtKt.getCommonMenu(this), "feed", (Map<String, String>) null);
                return true;
        }
    }

    public Object setCommonMenuExtObject(Object obj) {
        this.commonMenuExtObject = obj;
        return obj;
    }

    public void onCommonMenuStateChanged(CommonMenu menu, boolean isShown) {
        Intrinsics.checkNotNullParameter(menu, "menu");
    }

    public void handleJsMenuConfig() {
    }

    private final List<CommonMenuItem> buildFirstLineMenuList() {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : CollectionsKt.arrayListOf(4, 0, 2, 3, 8)) {
            int it = ((Number) element$iv$iv).intValue();
            SpColumnDetailData spColumnDetailData = this.data;
            if ((((spColumnDetailData != null ? spColumnDetailData.shareInfo : null) == null && it == 4) ? 1 : 0) == 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<Number> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Number intValue : $this$map$iv) {
            destination$iv$iv2.add(CommonMenuStyle.getMenuItem(intValue.intValue()));
        }
        return CollectionsKt.toMutableList((List) destination$iv$iv2);
    }

    private final List<CommonMenuItem> buildSecondLineMenuList() {
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : CollectionsKt.arrayListOf(30, 66, 9, 28, 5, 10)) {
            int it = ((Number) element$iv$iv).intValue();
            SpColumnDetailData spColumnDetailData = this.data;
            if ((((spColumnDetailData != null ? spColumnDetailData.shareInfo : null) == null && it == 10) ? 1 : 0) == 0) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable $this$filterNot$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList();
        for (Object element$iv$iv2 : $this$filterNot$iv) {
            if (((((Number) element$iv$iv2).intValue() != 66 || FeedPinchSummaryManager.Companion.isSupportPinchSummary(this.context)) ? 0 : 1) == 0) {
                destination$iv$iv2.add(element$iv$iv2);
            }
        }
        Iterable<Number> $this$map$iv = (List) destination$iv$iv2;
        Collection destination$iv$iv3 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Number intValue : $this$map$iv) {
            destination$iv$iv3.add(CommonMenuStyle.getMenuItem(intValue.intValue()));
        }
        return CollectionsKt.toMutableList((List) destination$iv$iv3);
    }

    private final void processShare() {
        CommonMenuExtKt.dismissMenu(this);
        SpColumnDetailData spColumnDetailData = this.data;
        SpDetailShareInfo shareInfo = spColumnDetailData != null ? spColumnDetailData.shareInfo : null;
        CharSequence charSequence = shareInfo != null ? shareInfo.url : null;
        if (!(charSequence == null || charSequence.length() == 0)) {
            BDShare.getInstance().share(this.context, (View) null, this.columnContext.getDetailViewModel().createShareContent());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r0 = r0.shareInfo;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void processCopyUrl() {
        /*
            r5 = this;
            com.baidu.searchbox.feed.payment.model.SpColumnDetailData r0 = r5.data
            r1 = 0
            if (r0 == 0) goto L_0x000c
            com.baidu.searchbox.feed.payment.model.SpDetailShareInfo r0 = r0.shareInfo
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = r0.url
            goto L_0x000d
        L_0x000c:
            r0 = r1
        L_0x000d:
            r2 = r0
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x001b
            int r2 = r2.length()
            if (r2 != 0) goto L_0x0019
            goto L_0x001b
        L_0x0019:
            r2 = 0
            goto L_0x001c
        L_0x001b:
            r2 = 1
        L_0x001c:
            if (r2 == 0) goto L_0x002c
            android.content.Context r1 = com.baidu.searchbox.feed.payment.FeedpayKt.appContext()
            int r2 = com.baidu.searchbox.lightbrowser.base.R.string.browser_menu_toast_copy_url_null
            com.baidu.android.ext.widget.toast.UniversalToast r1 = com.baidu.android.ext.widget.toast.UniversalToast.makeText((android.content.Context) r1, (int) r2)
            r1.show()
            goto L_0x0039
        L_0x002c:
            android.content.Context r2 = r5.context
            com.baidu.searchbox.feed.payment.widget.ColumnMenuPanel$$ExternalSyntheticLambda0 r3 = new com.baidu.searchbox.feed.payment.widget.ColumnMenuPanel$$ExternalSyntheticLambda0
            r3.<init>()
            java.lang.String r4 = "pay_column"
            com.baidu.searchbox.socialshare.utils.ShareUtils.createBrowserShortUrl(r2, r0, r1, r4, r3)
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.feed.payment.widget.ColumnMenuPanel.processCopyUrl():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: processCopyUrl$lambda-7  reason: not valid java name */
    public static final void m19320processCopyUrl$lambda7(String linkUrl) {
        WrappedClipboardManager.newInstance().setText(linkUrl);
        UniversalToast.makeText(FeedpayKt.appContext(), R.string.copy_dialog_title).showHighlightToast();
    }
}
