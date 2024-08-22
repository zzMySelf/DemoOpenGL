package com.baidu.searchbox.newpersonalcenter.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.newpersonalcenter.adapter.TemplateContentAdapter;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.newpersonalcenter.manager.TaskPopupManagerKt;
import com.baidu.searchbox.newpersonalcenter.model.TaskPopupModel;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.personalcenter.utils.LoginUtilKt;
import com.baidu.searchbox.skin.NightModeHelper;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J0\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0011H\u0002J\b\u0010\u001f\u001a\u00020 H\u0002J\b\u0010!\u001a\u00020\u000fH\u0002J+\u0010\"\u001a\u00020\u00172\u0016\u0010#\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u001b0$\"\u0004\u0018\u00010\u001b2\u0006\u0010\u001e\u001a\u00020\u0011¢\u0006\u0002\u0010%R\u001b\u0010\u0007\u001a\u00020\b8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006&"}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/widget/OperationItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "moduleActionListener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "(Landroid/content/Context;Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;)V", "layoutInflater", "Landroid/view/LayoutInflater;", "getLayoutInflater", "()Landroid/view/LayoutInflater;", "layoutInflater$delegate", "Lkotlin/Lazy;", "operationItems", "", "Lcom/baidu/searchbox/newpersonalcenter/widget/OperationItem;", "viewPosition", "", "getViewPosition", "()I", "setViewPosition", "(I)V", "addItemView", "", "index", "lastIdx", "item", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "dataLayoutParams", "Landroid/widget/LinearLayout$LayoutParams;", "cardPosition", "createDivider", "Landroid/view/View;", "createOperationItem", "populate", "data", "", "([Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;I)V", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OperationItemView.kt */
public final class OperationItemView extends LinearLayout {
    public Map<Integer, View> _$_findViewCache = new LinkedHashMap();
    private final Lazy layoutInflater$delegate;
    private final ModuleActionListener moduleActionListener;
    private final List<OperationItem> operationItems;
    private int viewPosition;

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
    public OperationItemView(Context context, ModuleActionListener moduleActionListener2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(moduleActionListener2, "moduleActionListener");
        this.moduleActionListener = moduleActionListener2;
        this.layoutInflater$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new OperationItemView$layoutInflater$2(context));
        this.operationItems = new ArrayList();
        setOrientation(0);
    }

    private final LayoutInflater getLayoutInflater() {
        Object value = this.layoutInflater$delegate.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "<get-layoutInflater>(...)");
        return (LayoutInflater) value;
    }

    public final int getViewPosition() {
        return this.viewPosition;
    }

    public final void setViewPosition(int i2) {
        this.viewPosition = i2;
    }

    public final void populate(PersonalCenterTabItemModel[] data, int cardPosition) {
        PersonalCenterTabItemModel[] personalCenterTabItemModelArr = data;
        Intrinsics.checkNotNullParameter(personalCenterTabItemModelArr, "data");
        removeAllViews();
        int lastIdx = personalCenterTabItemModelArr.length - 1;
        List list = ArraysKt.filterNotNull(data);
        LinearLayout.LayoutParams dataLayoutParams = new LinearLayout.LayoutParams(0, -2);
        dataLayoutParams.weight = 1.0f;
        int index$iv = 0;
        for (Object item$iv : list) {
            int index$iv2 = index$iv + 1;
            if (index$iv < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            addItemView(index$iv, lastIdx, (PersonalCenterTabItemModel) item$iv, dataLayoutParams, cardPosition);
            index$iv = index$iv2;
        }
        if (this.operationItems.size() > list.size()) {
            List<OperationItem> subList = this.operationItems.subList(0, list.size());
            this.operationItems.clear();
            this.operationItems.addAll(subList);
        }
    }

    private final void addItemView(int index, int lastIdx, PersonalCenterTabItemModel item, LinearLayout.LayoutParams dataLayoutParams, int cardPosition) {
        String titleColorString;
        int titleColor;
        String subTitleColorString;
        int subTitleColor;
        OperationItem operationItem = (OperationItem) CollectionsKt.getOrNull(this.operationItems, index);
        String str = null;
        if (operationItem == null) {
            operationItem = createOperationItem();
            SimpleDraweeView icon = operationItem.getIcon();
            if (icon != null) {
                GenericDraweeHierarchy $this$addItemView_u24lambda_u2d2 = new GenericDraweeHierarchyBuilder(getResources()).build();
                $this$addItemView_u24lambda_u2d2.setPlaceholderImage(ResourcesCompat.getDrawable(getResources(), R.drawable.personal_operation_fun_default_icon, (Resources.Theme) null));
                icon.setHierarchy($this$addItemView_u24lambda_u2d2);
            }
            this.operationItems.add(operationItem);
        }
        operationItem.setData(item);
        if (NightModeHelper.isNightMode()) {
            titleColorString = item.getMTitleColorNight();
        } else {
            titleColorString = item.getMTitleColor();
        }
        try {
            titleColor = Color.parseColor(titleColorString);
        } catch (Exception e2) {
            titleColor = ResourcesCompat.getColor(getResources(), R.color.GC1, (Resources.Theme) null);
        }
        if (NightModeHelper.isNightMode()) {
            subTitleColorString = item.getMSubTitleColorNight();
        } else {
            subTitleColorString = item.getMSubTitleColor();
        }
        try {
            subTitleColor = Color.parseColor(subTitleColorString);
        } catch (Exception e3) {
            subTitleColor = ResourcesCompat.getColor(getResources(), R.color.GC4, (Resources.Theme) null);
        }
        TextView title = operationItem.getTitle();
        if (title != null) {
            title.setTextColor(titleColor);
        }
        TextView subTitle = operationItem.getSubTitle();
        if (subTitle != null) {
            subTitle.setTextColor(subTitleColor);
        }
        SimpleDraweeView icon2 = operationItem.getIcon();
        if (icon2 != null) {
            icon2.setImageURI(item.getIcon());
        }
        TextView title2 = operationItem.getTitle();
        if (title2 != null) {
            title2.setText(item.getTitle());
        }
        TextView subTitle2 = operationItem.getSubTitle();
        if (subTitle2 != null) {
            subTitle2.setText(item.getSubTitle());
        }
        addView(operationItem.getRootView(), dataLayoutParams);
        if (index != lastIdx) {
            addView(createDivider());
        }
        operationItem.getRootView().setOnClickListener(new OperationItemView$$ExternalSyntheticLambda0(this, index, item, cardPosition));
        if (!(TaskPopupManagerKt.getTaskPopup() == null || item.getKeyId() == null)) {
            CharSequence keyId = item.getKeyId();
            TaskPopupModel taskPopup = TaskPopupManagerKt.getTaskPopup();
            if (taskPopup != null) {
                str = taskPopup.getAnimationLinkId();
            }
            if (TextUtils.equals(keyId, str)) {
                TaskPopupManagerKt.setTaskPopupAssociateView(operationItem);
            }
        }
        operationItem.checkPlayAnim();
    }

    /* access modifiers changed from: private */
    /* renamed from: addItemView$lambda-3  reason: not valid java name */
    public static final void m1684addItemView$lambda3(OperationItemView this$0, int $index, PersonalCenterTabItemModel $item, int $cardPosition, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($item, "$item");
        int position = (this$0.viewPosition * 2) + $index;
        if (!TextUtils.equals($item.getForceLogin(), "1")) {
            Router.invoke(this$0.getContext(), $item.getScheme());
        } else if (!TextUtils.equals("personal_cash", $item.getKeyId())) {
            TemplateContentAdapter.checkoutLogin(this$0.getContext(), $item);
        } else if (LoginUtilKt.isLogin(true)) {
            Router.invoke(this$0.getContext(), $item.getScheme());
        } else {
            LoginUtilKt.customStyleLogin$default(this$0.getContext(), $item.getUbcType(), false, true, new OperationItemView$addItemView$2$1(this$0, $item), 4, (Object) null);
        }
        this$0.moduleActionListener.onChildItemClickListener($item, position, $cardPosition);
    }

    private final OperationItem createOperationItem() {
        View itemLayout = getLayoutInflater().inflate(R.layout.personal_center_operation_item, this, false);
        Intrinsics.checkNotNullExpressionValue(itemLayout, "itemLayout");
        return new OperationItem(itemLayout);
    }

    private final View createDivider() {
        View view2 = new View(getContext());
        View $this$createDivider_u24lambda_u2d5 = view2;
        ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams($this$createDivider_u24lambda_u2d5.getResources().getDimensionPixelSize(R.dimen.personal_center_operation_decor_thickness), -1);
        ViewGroup.MarginLayoutParams $this$createDivider_u24lambda_u2d5_u24lambda_u2d4 = marginLayoutParams;
        $this$createDivider_u24lambda_u2d5_u24lambda_u2d4.topMargin = $this$createDivider_u24lambda_u2d5.getResources().getDimensionPixelSize(R.dimen.personal_center_operation_divider_margin);
        $this$createDivider_u24lambda_u2d5_u24lambda_u2d4.bottomMargin = $this$createDivider_u24lambda_u2d5.getResources().getDimensionPixelSize(R.dimen.personal_center_operation_divider_margin);
        $this$createDivider_u24lambda_u2d5.setLayoutParams(marginLayoutParams);
        $this$createDivider_u24lambda_u2d5.setBackgroundColor(ResourcesCompat.getColor($this$createDivider_u24lambda_u2d5.getResources(), R.color.GC34, (Resources.Theme) null));
        return view2;
    }
}
