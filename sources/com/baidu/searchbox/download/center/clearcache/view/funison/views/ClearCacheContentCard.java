package com.baidu.searchbox.download.center.clearcache.view.funison.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.ViewCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.download.center.clearcache.view.funison.CacheSizeFormatter;
import com.baidu.searchbox.download.center.clearcache.view.funison.ClearCacheConstant;
import com.baidu.searchbox.download.center.clearcache.view.funison.IClearCacheItemClickListener;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheContentCardInfo;
import com.baidu.searchbox.download.center.clearcache.view.funison.bo.ClearCacheItemInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 D2\u00020\u00012\u00020\u0002:\u0001DB\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ3\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020$2!\u0010/\u001a\u001d\u0012\u0013\u0012\u001101¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(4\u0012\u0004\u0012\u00020-00H\u0002J\u000e\u00105\u001a\u0002062\u0006\u0010.\u001a\u00020$J+\u00107\u001a\u00020-2!\u0010/\u001a\u001d\u0012\u0013\u0012\u001101¢\u0006\f\b2\u0012\b\b3\u0012\u0004\b\b(8\u0012\u0004\u0012\u00020-00H\u0002J\u0010\u00109\u001a\u00020-2\u0006\u0010.\u001a\u00020$H\u0016J\u0006\u0010:\u001a\u00020-J\u0010\u0010;\u001a\u00020-2\u0006\u0010<\u001a\u000206H\u0016J\u000e\u0010=\u001a\u00020-2\u0006\u0010>\u001a\u00020?J\b\u0010@\u001a\u00020-H\u0002J\b\u0010A\u001a\u00020-H\u0002J\u0006\u0010B\u001a\u00020-J\u0006\u0010C\u001a\u00020-R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0002X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001b\u0010\u0018\u001a\u00020\u00198BX\u0002¢\u0006\f\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001e\u001a\u00020\u001f8BX\u0002¢\u0006\f\n\u0004\b\"\u0010\u001d\u001a\u0004\b \u0010!R\u001a\u0010#\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010)\u001a\u00020$X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010&\"\u0004\b+\u0010(¨\u0006E"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheContentCard;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/IClearCacheItemClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "value", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/bo/ClearCacheContentCardInfo;", "clearCacheContentCardData", "getClearCacheContentCardData", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/bo/ClearCacheContentCardInfo;", "setClearCacheContentCardData", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/bo/ClearCacheContentCardInfo;)V", "itemClickListener", "getItemClickListener", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/IClearCacheItemClickListener;", "setItemClickListener", "(Lcom/baidu/searchbox/download/center/clearcache/view/funison/IClearCacheItemClickListener;)V", "mBodyLinearLayout", "Landroid/widget/LinearLayout;", "getMBodyLinearLayout", "()Landroid/widget/LinearLayout;", "mBodyLinearLayout$delegate", "Lkotlin/Lazy;", "mHeaderView", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheContentCardHeaderView;", "getMHeaderView", "()Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheContentCardHeaderView;", "mHeaderView$delegate", "ubcPage", "", "getUbcPage", "()Ljava/lang/String;", "setUbcPage", "(Ljava/lang/String;)V", "ubcSource", "getUbcSource", "setUbcSource", "findClearCacheCardItemViewByCacheId", "", "cacheId", "callback", "Lkotlin/Function1;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheCardItemView;", "Lkotlin/ParameterName;", "name", "cardItemView", "isContainClearCacheItem", "", "loopBodyLinearLayout", "cacheCardItemView", "onClearCacheItemClicked", "resetPrivacyCardFoldState", "setClickable", "clickable", "updateCacheItemInfo", "clearCacheItem", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/bo/ClearCacheItemInfo;", "updateHeaderSubtitle", "updateView", "updateWhenFontSizeChanged", "updateWhenNightModeChanged", "Companion", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheContentCard.kt */
public final class ClearCacheContentCard extends ConstraintLayout implements IClearCacheItemClickListener {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int ID_PARENT = 0;
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private ClearCacheContentCardInfo clearCacheContentCardData;
    private IClearCacheItemClickListener itemClickListener;
    private final Lazy mBodyLinearLayout$delegate;
    private final Lazy mHeaderView$delegate;
    private String ubcPage;
    private String ubcSource;

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/ClearCacheContentCard$Companion;", "", "()V", "ID_PARENT", "", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheContentCard.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final ClearCacheContentCardInfo getClearCacheContentCardData() {
        return this.clearCacheContentCardData;
    }

    public final void setClearCacheContentCardData(ClearCacheContentCardInfo value) {
        this.clearCacheContentCardData = value;
        updateView();
    }

    public final IClearCacheItemClickListener getItemClickListener() {
        return this.itemClickListener;
    }

    public final void setItemClickListener(IClearCacheItemClickListener iClearCacheItemClickListener) {
        this.itemClickListener = iClearCacheItemClickListener;
    }

    public final String getUbcSource() {
        return this.ubcSource;
    }

    public final void setUbcSource(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ubcSource = str;
    }

    public final String getUbcPage() {
        return this.ubcPage;
    }

    public final void setUbcPage(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ubcPage = str;
    }

    private final ClearCacheContentCardHeaderView getMHeaderView() {
        return (ClearCacheContentCardHeaderView) this.mHeaderView$delegate.getValue();
    }

    private final LinearLayout getMBodyLinearLayout() {
        return (LinearLayout) this.mBodyLinearLayout$delegate.getValue();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClearCacheContentCard(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        this.ubcSource = "";
        this.ubcPage = "";
        this.mHeaderView$delegate = LazyKt.lazy(new ClearCacheContentCard$mHeaderView$2(this));
        this.mBodyLinearLayout$delegate = LazyKt.lazy(new ClearCacheContentCard$mBodyLinearLayout$2(this));
        int paddingTop = DeviceUtils.ScreenInfo.dp2px(getContext(), 9.0f);
        setPadding(0, paddingTop, 0, paddingTop);
        ConstraintLayout.LayoutParams headerTitleLayoutParams = new ConstraintLayout.LayoutParams(0, -2);
        headerTitleLayoutParams.constrainedWidth = true;
        headerTitleLayoutParams.startToStart = 0;
        headerTitleLayoutParams.topToTop = 0;
        headerTitleLayoutParams.endToEnd = 0;
        addView(getMHeaderView(), headerTitleLayoutParams);
        ConstraintLayout.LayoutParams bodyLayoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        bodyLayoutParams.startToStart = 0;
        bodyLayoutParams.topToBottom = getMHeaderView().getId();
        bodyLayoutParams.endToEnd = 0;
        bodyLayoutParams.bottomToBottom = 0;
        addView(getMBodyLinearLayout(), bodyLayoutParams);
        setBackground(getResources().getDrawable(R.drawable.clear_cache_background_corner));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClearCacheContentCard(Context context, AttributeSet attrs) {
        super(context, attrs);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.ubcSource = "";
        this.ubcPage = "";
        this.mHeaderView$delegate = LazyKt.lazy(new ClearCacheContentCard$mHeaderView$2(this));
        this.mBodyLinearLayout$delegate = LazyKt.lazy(new ClearCacheContentCard$mBodyLinearLayout$2(this));
        int paddingTop = DeviceUtils.ScreenInfo.dp2px(getContext(), 9.0f);
        setPadding(0, paddingTop, 0, paddingTop);
        ConstraintLayout.LayoutParams headerTitleLayoutParams = new ConstraintLayout.LayoutParams(0, -2);
        headerTitleLayoutParams.constrainedWidth = true;
        headerTitleLayoutParams.startToStart = 0;
        headerTitleLayoutParams.topToTop = 0;
        headerTitleLayoutParams.endToEnd = 0;
        addView(getMHeaderView(), headerTitleLayoutParams);
        ConstraintLayout.LayoutParams bodyLayoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        bodyLayoutParams.startToStart = 0;
        bodyLayoutParams.topToBottom = getMHeaderView().getId();
        bodyLayoutParams.endToEnd = 0;
        bodyLayoutParams.bottomToBottom = 0;
        addView(getMBodyLinearLayout(), bodyLayoutParams);
        setBackground(getResources().getDrawable(R.drawable.clear_cache_background_corner));
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ClearCacheContentCard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attrs, "attrs");
        this.ubcSource = "";
        this.ubcPage = "";
        this.mHeaderView$delegate = LazyKt.lazy(new ClearCacheContentCard$mHeaderView$2(this));
        this.mBodyLinearLayout$delegate = LazyKt.lazy(new ClearCacheContentCard$mBodyLinearLayout$2(this));
        int paddingTop = DeviceUtils.ScreenInfo.dp2px(getContext(), 9.0f);
        setPadding(0, paddingTop, 0, paddingTop);
        ConstraintLayout.LayoutParams headerTitleLayoutParams = new ConstraintLayout.LayoutParams(0, -2);
        headerTitleLayoutParams.constrainedWidth = true;
        headerTitleLayoutParams.startToStart = 0;
        headerTitleLayoutParams.topToTop = 0;
        headerTitleLayoutParams.endToEnd = 0;
        addView(getMHeaderView(), headerTitleLayoutParams);
        ConstraintLayout.LayoutParams bodyLayoutParams = new ConstraintLayout.LayoutParams(-1, -2);
        bodyLayoutParams.startToStart = 0;
        bodyLayoutParams.topToBottom = getMHeaderView().getId();
        bodyLayoutParams.endToEnd = 0;
        bodyLayoutParams.bottomToBottom = 0;
        addView(getMBodyLinearLayout(), bodyLayoutParams);
        setBackground(getResources().getDrawable(R.drawable.clear_cache_background_corner));
    }

    /* access modifiers changed from: private */
    public final void updateView() {
        String str;
        List<ClearCacheItemInfo> clearCacheItems;
        ClearCacheContentCardHeaderView mHeaderView = getMHeaderView();
        ClearCacheContentCardInfo clearCacheContentCardInfo = this.clearCacheContentCardData;
        if (clearCacheContentCardInfo == null || (str = clearCacheContentCardInfo.getTitle()) == null) {
            str = "";
        }
        mHeaderView.setTitleText(str);
        updateHeaderSubtitle();
        ClearCacheContentCardHeaderView mHeaderView2 = getMHeaderView();
        ClearCacheContentCardInfo clearCacheContentCardInfo2 = this.clearCacheContentCardData;
        mHeaderView2.setCardExpand(clearCacheContentCardInfo2 != null ? clearCacheContentCardInfo2.isExpand() : false);
        getMBodyLinearLayout().removeAllViews();
        ClearCacheContentCardInfo clearCacheContentCardInfo3 = this.clearCacheContentCardData;
        if (clearCacheContentCardInfo3 != null && (clearCacheItems = clearCacheContentCardInfo3.getItems()) != null) {
            for (ClearCacheItemInfo clearCacheItemInfo : clearCacheItems) {
                Context context = getContext();
                Intrinsics.checkNotNullExpressionValue(context, "context");
                ClearCacheCardItemView clearCacheItemView = new ClearCacheCardItemView(context);
                clearCacheItemView.setId(ViewCompat.generateViewId());
                clearCacheItemView.setClearCacheItemData(clearCacheItemInfo);
                clearCacheItemView.setItemClickListener(this);
                clearCacheItemView.setClickable(isClickable());
                LinearLayout.LayoutParams itemLayoutParams = new LinearLayout.LayoutParams(-1, -2);
                itemLayoutParams.topMargin = DeviceUtils.ScreenInfo.dp2px(getContext(), 9.0f);
                getMBodyLinearLayout().addView(clearCacheItemView, itemLayoutParams);
            }
            ClearCacheContentCardInfo clearCacheContentCardInfo4 = this.clearCacheContentCardData;
            if (clearCacheContentCardInfo4 == null) {
                return;
            }
            if (clearCacheContentCardInfo4.isExpand()) {
                getMBodyLinearLayout().setVisibility(0);
            } else {
                getMBodyLinearLayout().setVisibility(8);
            }
        }
    }

    public final void resetPrivacyCardFoldState() {
        ClearCacheContentCardInfo clearCacheContentCardInfo = this.clearCacheContentCardData;
        if (TextUtils.equals(clearCacheContentCardInfo != null ? clearCacheContentCardInfo.getTitle() : null, ClearCacheConstant.CONTENT_CARD_TITLE_PRIVACY_RECORD)) {
            ClearCacheContentCardInfo clearCacheContentCardInfo2 = this.clearCacheContentCardData;
            if (clearCacheContentCardInfo2 != null) {
                clearCacheContentCardInfo2.setExpand(false);
            }
            getMHeaderView().setCardExpand(false);
            getMBodyLinearLayout().setVisibility(8);
        }
    }

    public final boolean isContainClearCacheItem(String cacheId) {
        List<ClearCacheItemInfo> items;
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        ClearCacheContentCardInfo clearCacheContentCardInfo = this.clearCacheContentCardData;
        if (clearCacheContentCardInfo == null || (items = clearCacheContentCardInfo.getItems()) == null) {
            return false;
        }
        Iterable<ClearCacheItemInfo> $this$any$iv = items;
        if (($this$any$iv instanceof Collection) && ((Collection) $this$any$iv).isEmpty()) {
            return false;
        }
        for (ClearCacheItemInfo clearCacheItemInfo : $this$any$iv) {
            if (Intrinsics.areEqual((Object) clearCacheItemInfo.getItemId(), (Object) cacheId)) {
                return true;
            }
        }
        return false;
    }

    public final void updateCacheItemInfo(ClearCacheItemInfo clearCacheItem) {
        Intrinsics.checkNotNullParameter(clearCacheItem, "clearCacheItem");
        findClearCacheCardItemViewByCacheId(clearCacheItem.getItemId(), new ClearCacheContentCard$updateCacheItemInfo$1(clearCacheItem, this));
    }

    public final void updateWhenNightModeChanged() {
        getMHeaderView().updateWhenNightModeChanged();
        loopBodyLinearLayout(ClearCacheContentCard$updateWhenNightModeChanged$1.INSTANCE);
    }

    public final void updateWhenFontSizeChanged() {
        getMHeaderView().updateWhenFontSizeChanged();
        loopBodyLinearLayout(ClearCacheContentCard$updateWhenFontSizeChanged$1.INSTANCE);
    }

    private final void loopBodyLinearLayout(Function1<? super ClearCacheCardItemView, Unit> callback) {
        int childCount = getMBodyLinearLayout().getChildCount();
        for (int childIndex = 0; childIndex < childCount; childIndex++) {
            View childAt = getMBodyLinearLayout().getChildAt(childIndex);
            ClearCacheCardItemView childView = childAt instanceof ClearCacheCardItemView ? (ClearCacheCardItemView) childAt : null;
            if (childView != null) {
                callback.invoke(childView);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void updateHeaderSubtitle() {
        int count$iv;
        List<ClearCacheItemInfo> items;
        List<ClearCacheItemInfo> $this$filter$iv;
        ClearCacheContentCardInfo clearCacheContentCardInfo = this.clearCacheContentCardData;
        ClearCacheContentCardInfo.SubTitleType subtitleShowType = clearCacheContentCardInfo != null ? clearCacheContentCardInfo.getSubTitleType() : null;
        if (ClearCacheContentCardInfo.SubTitleType.TOTAL_SIZE_SELECTED == subtitleShowType) {
            ClearCacheContentCardInfo clearCacheContentCardInfo2 = this.clearCacheContentCardData;
            long cardSelectedTotalSize = 0;
            if (!(clearCacheContentCardInfo2 == null || ($this$filter$iv = clearCacheContentCardInfo2.getItems()) == null)) {
                Collection destination$iv$iv = new ArrayList();
                for (Object element$iv$iv : $this$filter$iv) {
                    if (((ClearCacheItemInfo) element$iv$iv).isSelected()) {
                        destination$iv$iv.add(element$iv$iv);
                    }
                }
                for (ClearCacheItemInfo clearCacheItem : (List) destination$iv$iv) {
                    cardSelectedTotalSize += clearCacheItem.getTotalSize();
                }
            }
            String subTitleSizeText = getResources().getString(R.string.clear_cache_card_header_selected_total_size, new Object[]{CacheSizeFormatter.INSTANCE.formatSize(cardSelectedTotalSize)});
            Intrinsics.checkNotNullExpressionValue(subTitleSizeText, "resources.getString(\n   …zeFormatted\n            )");
            getMHeaderView().setSubTitleText(subTitleSizeText);
        } else if (ClearCacheContentCardInfo.SubTitleType.TOTAL_COUNT_SELECTED == subtitleShowType) {
            ClearCacheContentCardInfo clearCacheContentCardInfo3 = this.clearCacheContentCardData;
            if (clearCacheContentCardInfo3 == null || (items = clearCacheContentCardInfo3.getItems()) == null) {
                count$iv = 0;
            } else {
                Iterable<ClearCacheItemInfo> $this$count$iv = items;
                if (!($this$count$iv instanceof Collection) || !((Collection) $this$count$iv).isEmpty()) {
                    count$iv = 0;
                    for (ClearCacheItemInfo clearCacheItem2 : $this$count$iv) {
                        if (clearCacheItem2.isSelected() && (count$iv = count$iv + 1) < 0) {
                            CollectionsKt.throwCountOverflow();
                        }
                    }
                } else {
                    count$iv = 0;
                }
            }
            String subTitleCountText = getResources().getString(R.string.clear_cache_card_header_selected_total_count, new Object[]{String.valueOf(count$iv)});
            Intrinsics.checkNotNullExpressionValue(subTitleCountText, "resources.getString(\n   ….toString()\n            )");
            getMHeaderView().setSubTitleText(subTitleCountText);
        } else {
            getMHeaderView().setSubTitleText("");
        }
    }

    public void onClearCacheItemClicked(String cacheId) {
        Intrinsics.checkNotNullParameter(cacheId, "cacheId");
        IClearCacheItemClickListener iClearCacheItemClickListener = this.itemClickListener;
        if (iClearCacheItemClickListener != null) {
            iClearCacheItemClickListener.onClearCacheItemClicked(cacheId);
        }
    }

    private final void findClearCacheCardItemViewByCacheId(String cacheId, Function1<? super ClearCacheCardItemView, Unit> callback) {
        int childIndex = 0;
        int childCount = getMBodyLinearLayout().getChildCount();
        while (childIndex < childCount) {
            View childAt = getMBodyLinearLayout().getChildAt(childIndex);
            ClearCacheCardItemView childView = childAt instanceof ClearCacheCardItemView ? (ClearCacheCardItemView) childAt : null;
            if (childView == null || !childView.isCanHandleClearCacheItem(cacheId)) {
                childIndex++;
            } else {
                callback.invoke(childView);
                return;
            }
        }
    }

    public void setClickable(boolean clickable) {
        super.setClickable(clickable);
        getMHeaderView().setClickable(clickable);
        int childCount = getMBodyLinearLayout().getChildCount();
        for (int childIndex = 0; childIndex < childCount; childIndex++) {
            View childAt = getMBodyLinearLayout().getChildAt(childIndex);
            ClearCacheCardItemView childView = childAt instanceof ClearCacheCardItemView ? (ClearCacheCardItemView) childAt : null;
            if (childView != null) {
                childView.setClickable(clickable);
            }
        }
    }
}
