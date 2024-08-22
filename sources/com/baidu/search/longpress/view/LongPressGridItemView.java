package com.baidu.search.longpress.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.search.longpress.model.LongPressMenuGridItem;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0013\u001a\u00020\u0011H\u0002J-\u0010\u0014\u001a\u00020\u00112%\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\fR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R-\u0010\u000b\u001a!\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0011\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0001X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/search/longpress/view/LongPressGridItemView;", "Landroid/widget/RelativeLayout;", "context", "Landroid/content/Context;", "longPressMenuGridItem", "Lcom/baidu/search/longpress/model/LongPressMenuGridItem;", "(Landroid/content/Context;Lcom/baidu/search/longpress/model/LongPressMenuGridItem;)V", "contentView", "Landroid/widget/TextView;", "iconView", "Landroid/widget/ImageView;", "itemClickListener", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "id", "", "rootView", "initView", "setItemClickListener", "lib_search_long_press_menu_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LongPressGridItemView.kt */
public final class LongPressGridItemView extends RelativeLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private TextView contentView;
    private ImageView iconView;
    private Function1<? super Integer, Unit> itemClickListener;
    private LongPressMenuGridItem longPressMenuGridItem;
    private RelativeLayout rootView;

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

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LongPressGridItemView(Context context, LongPressMenuGridItem longPressMenuGridItem2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(longPressMenuGridItem2, "longPressMenuGridItem");
        this.longPressMenuGridItem = longPressMenuGridItem2;
        initView();
    }

    /* JADX WARNING: type inference failed for: r1v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void initView() {
        /*
            r7 = this;
            android.content.Context r0 = r7.getContext()
            android.view.LayoutInflater r0 = android.view.LayoutInflater.from(r0)
            int r1 = com.baidu.search.longpress.R.layout.long_press_menu_gird_item_layout
            r2 = r7
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            android.view.View r1 = r0.inflate(r1, r2)
            if (r1 == 0) goto L_0x00e2
            android.widget.RelativeLayout r1 = (android.widget.RelativeLayout) r1
            r7.rootView = r1
            r2 = 0
            if (r1 == 0) goto L_0x0023
            int r3 = com.baidu.search.longpress.R.id.long_press_gridview_item_icon
            android.view.View r1 = r1.findViewById(r3)
            android.widget.ImageView r1 = (android.widget.ImageView) r1
            goto L_0x0024
        L_0x0023:
            r1 = r2
        L_0x0024:
            r7.iconView = r1
            android.widget.RelativeLayout r1 = r7.rootView
            if (r1 == 0) goto L_0x0033
            int r2 = com.baidu.search.longpress.R.id.long_press_gridview_item_content
            android.view.View r1 = r1.findViewById(r2)
            r2 = r1
            android.widget.TextView r2 = (android.widget.TextView) r2
        L_0x0033:
            r7.contentView = r2
            android.view.ViewGroup$LayoutParams r1 = new android.view.ViewGroup$LayoutParams
            r2 = -1
            android.content.Context r3 = r7.getContext()
            r4 = 1115684864(0x42800000, float:64.0)
            int r3 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r3, r4)
            r1.<init>(r2, r3)
            r7.setLayoutParams(r1)
            android.widget.LinearLayout$LayoutParams r2 = new android.widget.LinearLayout$LayoutParams
            android.content.Context r3 = r7.getContext()
            float r4 = com.baidu.search.longpress.LongPressMenuUtilsKt.getLongPressMenuScale()
            r5 = 1101004800(0x41a00000, float:20.0)
            float r4 = r4 * r5
            int r3 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r3, r4)
            android.content.Context r4 = r7.getContext()
            float r6 = com.baidu.search.longpress.LongPressMenuUtilsKt.getLongPressMenuScale()
            float r6 = r6 * r5
            int r4 = com.baidu.android.util.devices.DeviceUtils.ScreenInfo.dp2px(r4, r6)
            r2.<init>(r3, r4)
            android.widget.ImageView r3 = r7.iconView
            if (r3 != 0) goto L_0x006e
            goto L_0x0074
        L_0x006e:
            r4 = r2
            android.view.ViewGroup$LayoutParams r4 = (android.view.ViewGroup.LayoutParams) r4
            r3.setLayoutParams(r4)
        L_0x0074:
            boolean r3 = com.baidu.searchbox.skin.NightModeHelper.isNightMode()
            if (r3 == 0) goto L_0x0090
            com.baidu.search.longpress.model.LongPressMenuGridItem r3 = r7.longPressMenuGridItem
            int r3 = r3.getIconIdNight()
            if (r3 == 0) goto L_0x00a5
            android.widget.ImageView r3 = r7.iconView
            if (r3 == 0) goto L_0x00a5
            com.baidu.search.longpress.model.LongPressMenuGridItem r4 = r7.longPressMenuGridItem
            int r4 = r4.getIconIdNight()
            r3.setImageResource(r4)
            goto L_0x00a5
        L_0x0090:
            com.baidu.search.longpress.model.LongPressMenuGridItem r3 = r7.longPressMenuGridItem
            int r3 = r3.getIconIdLight()
            if (r3 == 0) goto L_0x00a5
            android.widget.ImageView r3 = r7.iconView
            if (r3 == 0) goto L_0x00a5
            com.baidu.search.longpress.model.LongPressMenuGridItem r4 = r7.longPressMenuGridItem
            int r4 = r4.getIconIdLight()
            r3.setImageResource(r4)
        L_0x00a5:
            android.widget.TextView r3 = r7.contentView
            if (r3 != 0) goto L_0x00aa
            goto L_0x00b5
        L_0x00aa:
            com.baidu.search.longpress.model.LongPressMenuGridItem r4 = r7.longPressMenuGridItem
            java.lang.String r4 = r4.getTitle()
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r3.setText(r4)
        L_0x00b5:
            android.widget.TextView r3 = r7.contentView
            if (r3 == 0) goto L_0x00ca
            android.content.Context r4 = r7.getContext()
            android.content.res.Resources r4 = r4.getResources()
            int r5 = com.baidu.search.longpress.R.color.long_press_menu_content_color
            int r4 = r4.getColor(r5)
            r3.setTextColor(r4)
        L_0x00ca:
            android.widget.TextView r3 = r7.contentView
            if (r3 != 0) goto L_0x00cf
            goto L_0x00d9
        L_0x00cf:
            r4 = 1096810496(0x41600000, float:14.0)
            float r5 = com.baidu.search.longpress.LongPressMenuUtilsKt.getLongPressMenuScale()
            float r5 = r5 * r4
            r3.setTextSize(r5)
        L_0x00d9:
            com.baidu.search.longpress.view.LongPressGridItemView$$ExternalSyntheticLambda0 r3 = new com.baidu.search.longpress.view.LongPressGridItemView$$ExternalSyntheticLambda0
            r3.<init>(r7)
            r7.setOnClickListener(r3)
            return
        L_0x00e2:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.RelativeLayout"
            r1.<init>(r2)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.search.longpress.view.LongPressGridItemView.initView():void");
    }

    /* access modifiers changed from: private */
    /* renamed from: initView$lambda-0  reason: not valid java name */
    public static final void m14296initView$lambda0(LongPressGridItemView this$0, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function1<? super Integer, Unit> function1 = this$0.itemClickListener;
        if (function1 != null) {
            Unit invoke = function1.invoke(Integer.valueOf(this$0.longPressMenuGridItem.getId()));
        }
    }

    public final void setItemClickListener(Function1<? super Integer, Unit> itemClickListener2) {
        this.itemClickListener = itemClickListener2;
    }
}
