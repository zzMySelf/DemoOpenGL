package com.baidu.searchbox.personal.loginview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.Router;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.TipsType;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.personal.NewPersonalItemNewTip;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.ui.view.BadgeView;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0002J \u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\f2\u0006\u0010\u0017\u001a\u00020\u00182\b\u0010\u0019\u001a\u0004\u0018\u00010\nJ\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\fH\u0002J\u0006\u0010\u001b\u001a\u00020\u000eJ\u000e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0018R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/personal/loginview/PersonalHeaderTopRightItemView;", "Lcom/baidu/searchbox/personal/loginview/PersonalHeaderTopRightItemBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "moduleActionListener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "tabItemModel", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "addTextTipsToParent", "", "tips", "Lcom/baidu/searchbox/ui/view/BadgeView;", "target", "Landroid/view/View;", "targetParent", "Landroid/widget/RelativeLayout;", "populate", "itemModel", "hasTheme", "", "listener", "setBadgeData", "updateSize", "updateUI", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalHeaderTopRightItemView.kt */
public final class PersonalHeaderTopRightItemView extends PersonalHeaderTopRightItemBaseView {
    public Map<Integer, View> _$_findViewCache;
    private ModuleActionListener moduleActionListener;
    private PersonalCenterTabItemModel tabItemModel;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalHeaderTopRightItemView.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TipsType.values().length];
            iArr[TipsType.TEXT_TIP.ordinal()] = 1;
            iArr[TipsType.NUMBER_TIP.ordinal()] = 2;
            iArr[TipsType.DOT_TIP.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalHeaderTopRightItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public PersonalHeaderTopRightItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

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
    public PersonalHeaderTopRightItemView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        getBadgeView().setOnTouchListener(new TouchStateListener());
        getItemView().setOnClickListener(new PersonalHeaderTopRightItemView$$ExternalSyntheticLambda0(this, context));
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PersonalHeaderTopRightItemView(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    /* access modifiers changed from: private */
    /* renamed from: _init_$lambda-1  reason: not valid java name */
    public static final void m2100_init_$lambda1(PersonalHeaderTopRightItemView this$0, Context $context, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($context, "$context");
        PersonalCenterTabItemModel model = this$0.tabItemModel;
        if (model != null) {
            if (Intrinsics.areEqual((Object) model.getKeyId(), (Object) PersonalConstants.TOP_SETTINGS)) {
                ModuleActionListener moduleActionListener2 = this$0.moduleActionListener;
                if (moduleActionListener2 != null) {
                    moduleActionListener2.openPersonalSlide();
                }
            } else {
                Router.invoke($context, model.getScheme());
            }
            NewPersonalItemNewTip.getInstance().setItemRead(model.getKeyId());
            PersonalCenterTabItemModel personalCenterTabItemModel = this$0.tabItemModel;
            String str = null;
            String ubcType = personalCenterTabItemModel != null ? personalCenterTabItemModel.getUbcType() : null;
            Object tag = this$0.getBadgeView().getTag();
            String obj = tag != null ? tag.toString() : null;
            PersonalCenterTabItemModel personalCenterTabItemModel2 = this$0.tabItemModel;
            String ubcFrom = personalCenterTabItemModel2 != null ? personalCenterTabItemModel2.getUbcFrom() : null;
            PersonalCenterTabItemModel personalCenterTabItemModel3 = this$0.tabItemModel;
            if (personalCenterTabItemModel3 != null) {
                str = personalCenterTabItemModel3.getUbcEventId();
            }
            PersonCenterUBCStatistic.statisticUBC(ubcType, obj, "click", ubcFrom, str);
        }
    }

    public final void updateUI(boolean hasTheme) {
        Drawable placeholderIcon = ContextCompat.getDrawable(getContext(), R.drawable.personal_square_img_default);
        GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) getIconView().getHierarchy();
        if (genericDraweeHierarchy != null) {
            genericDraweeHierarchy.setPlaceholderImage(placeholderIcon);
        }
        GenericDraweeHierarchy genericDraweeHierarchy2 = (GenericDraweeHierarchy) getIconView().getHierarchy();
        if (genericDraweeHierarchy2 != null) {
            genericDraweeHierarchy2.setFailureImage(placeholderIcon);
        }
        String str = null;
        if (hasTheme) {
            SimpleDraweeView iconView = getIconView();
            if (NightModeHelper.isNightMode()) {
                PersonalCenterTabItemModel personalCenterTabItemModel = this.tabItemModel;
                if (personalCenterTabItemModel != null) {
                    str = personalCenterTabItemModel.getBgIconNight();
                }
            } else {
                PersonalCenterTabItemModel personalCenterTabItemModel2 = this.tabItemModel;
                if (personalCenterTabItemModel2 != null) {
                    str = personalCenterTabItemModel2.getBgIcon();
                }
            }
            iconView.setImageURI(str);
            return;
        }
        SimpleDraweeView iconView2 = getIconView();
        if (NightModeHelper.isNightMode()) {
            PersonalCenterTabItemModel personalCenterTabItemModel3 = this.tabItemModel;
            if (personalCenterTabItemModel3 != null) {
                str = personalCenterTabItemModel3.getIconNightUrl();
            }
        } else {
            PersonalCenterTabItemModel personalCenterTabItemModel4 = this.tabItemModel;
            if (personalCenterTabItemModel4 != null) {
                str = personalCenterTabItemModel4.getIcon();
            }
        }
        iconView2.setImageURI(str);
    }

    public final void updateSize() {
        FontSizeViewExtKt.setScaledWidth$default(getItemView(), 2, getResources().getDimension(R.dimen.area_header_top_right_item_width), 0, 4, (Object) null);
        FontSizeViewExtKt.setScaledSizeRes$default(getIconView(), 2, R.dimen.skin_center_icon_width, R.dimen.skin_center_icon_width, 0, 8, (Object) null);
        FontSizeViewExtKt.setScaledLeftMarginRes$default(getIconView(), 2, R.dimen.area_header_top_right_margin_left, 0, 4, (Object) null);
        FontSizeViewExtKt.setScaledRightMarginRes$default(getIconView(), 2, R.dimen.area_header_top_right_margin_right, 0, 4, (Object) null);
    }

    public final void populate(PersonalCenterTabItemModel itemModel, boolean hasTheme, ModuleActionListener listener) {
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        this.tabItemModel = itemModel;
        this.moduleActionListener = listener;
        updateUI(hasTheme);
        setBadgeData(itemModel);
        updateSize();
    }

    private final void setBadgeData(PersonalCenterTabItemModel itemModel) {
        String tipText = itemModel.getTipText();
        boolean z = false;
        switch (WhenMappings.$EnumSwitchMapping$0[itemModel.getTipsType().ordinal()]) {
            case 1:
                getBadgeView().setType(BadgeView.Type.SMALL_TEXT);
                getBadgeView().setBadgeText(tipText);
                getBadgeView().setVisibility(0);
                if (tipText != null && tipText.length() == 1) {
                    z = true;
                }
                if (z) {
                    getBadgeView().bindViewInRelativeLayout(getIconView(), getItemView(), BadgeView.DefaultPosition.ICON_SMALL_TXT_NORMAL);
                } else {
                    addTextTipsToParent(getBadgeView(), getIconView(), getItemView());
                }
                getBadgeView().setTag("3");
                return;
            case 2:
                getBadgeView().setCountFormatType(BadgeView.CountFormatType.MAX_99);
                getBadgeView().setType(BadgeView.Type.SMALL_TEXT);
                getBadgeView().setBadgeCount((tipText != null ? Integer.valueOf(Integer.parseInt(tipText)) : null).intValue());
                getBadgeView().setVisibility(0);
                getBadgeView().bindViewInRelativeLayout(getIconView(), getItemView(), BadgeView.DefaultPosition.ICON_SMALL_TXT_NORMAL);
                getBadgeView().setTag("2");
                return;
            case 3:
                getBadgeView().setType(BadgeView.Type.DOT);
                getBadgeView().setVisibility(0);
                getBadgeView().bindViewInRelativeLayout(getIconView(), getItemView(), BadgeView.DefaultPosition.ICON_DOT_NORMAL);
                getBadgeView().setTag("1");
                return;
            default:
                getBadgeView().setVisibility(8);
                getBadgeView().setTag("0");
                return;
        }
    }

    private final void addTextTipsToParent(BadgeView tips, View target, RelativeLayout targetParent) {
        ViewParent tipsParent = tips.getParent();
        if (tipsParent != null) {
            ((ViewGroup) tipsParent).removeView(tips);
        }
        ViewGroup.LayoutParams tipsLp = tips.getLayoutParams();
        Intrinsics.checkNotNullExpressionValue(tipsLp, "tips.layoutParams");
        RelativeLayout.LayoutParams badgeLp = new RelativeLayout.LayoutParams(tipsLp.width, tipsLp.height);
        badgeLp.addRule(11);
        badgeLp.addRule(2, target.getId());
        badgeLp.bottomMargin = (int) FontSizeHelper.getScaledSize(2, getContext().getResources().getDimension(R.dimen.personal_common_fun_tips_margin_bottom_offset));
        targetParent.addView(tips, badgeLp);
    }
}
