package com.baidu.searchbox.newpersonalcenter.viewholder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterGroupModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.newpersonalcenter.managerpage.TemplateManagerActivity;
import com.baidu.searchbox.newpersonalcenter.model.TipModel;
import com.baidu.searchbox.newpersonalcenter.model.TipsTypeConstants;
import com.baidu.searchbox.newpersonalcenter.widget.StrokeTextView;
import com.baidu.searchbox.personal.NewPersonalItemNewTip;
import com.baidu.searchbox.personalcenter.PersonalConstants;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.ui.bubble.manager.BubbleBaseManager;
import com.baidu.searchbox.ui.view.BadgeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0002J\u0012\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002H\u0016J\u0010\u0010\u0011\u001a\u00020\u000f2\b\u0010\u0012\u001a\u0004\u0018\u00010\tJ*\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/newpersonalcenter/viewholder/ManagerGuideViewHolder;", "Lcom/baidu/searchbox/newpersonalcenter/viewholder/BaseHolder;", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterGroupModel;", "itemView", "Landroid/view/View;", "moduleActionListener", "Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "(Landroid/view/View;Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;)V", "mBubble", "Lcom/baidu/searchbox/ui/bubble/manager/BubbleBaseManager;", "getModuleActionListener", "()Lcom/baidu/searchbox/newpersonalcenter/listener/ModuleActionListener;", "getPage", "", "populate", "", "data", "setBubble", "bubble", "showTips", "newTip", "Lcom/baidu/searchbox/ui/view/BadgeView;", "info", "Lcom/baidu/searchbox/newpersonalcenter/model/TipModel;", "target", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ManagerGuideViewHolder.kt */
public final class ManagerGuideViewHolder extends BaseHolder<PersonalCenterGroupModel> {
    private BubbleBaseManager mBubble;
    private final ModuleActionListener moduleActionListener;

    public final ModuleActionListener getModuleActionListener() {
        return this.moduleActionListener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ManagerGuideViewHolder(View itemView, ModuleActionListener moduleActionListener2) {
        super(itemView, moduleActionListener2);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
        this.moduleActionListener = moduleActionListener2;
    }

    public void populate(PersonalCenterGroupModel data) {
        Context context = this.itemView.getContext();
        ((StrokeTextView) this.itemView.findViewById(R.id.managerLeftText)).setTextColor(context.getResources().getColor(R.color.GC104));
        FontSizeTextViewExtKt.setScaledSizeRes$default((StrokeTextView) this.itemView.findViewById(R.id.managerLeftText), 2, R.dimen.managerLeftText_size, 0, 4, (Object) null);
        ((TextView) this.itemView.findViewById(R.id.managerRightText)).setTextColor(context.getResources().getColor(R.color.GC105));
        FontSizeTextViewExtKt.setScaledSizeRes$default((TextView) this.itemView.findViewById(R.id.managerRightText), 2, R.dimen.managerRightText_size, 0, 4, (Object) null);
        Drawable drawable = FontSizeHelper.getScaledDrawable$default(2, ResourcesCompat.getDrawable(context.getResources(), R.drawable.manager_right_icon, (Resources.Theme) null), 0, 4, (Object) null);
        int marginTop = DeviceUtils.ScreenInfo.dp2px(context, 1.0f);
        if (drawable != null) {
            drawable.setBounds(0, marginTop, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        }
        ((TextView) this.itemView.findViewById(R.id.managerRightText)).setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        TipModel tipModel = NewPersonalItemNewTip.getInstance().getTipModelByKey(PersonalConstants.ID_MANAGERMENT_TIPS);
        BadgeView badgeView = (BadgeView) this.itemView.findViewById(R.id.tip);
        Intrinsics.checkNotNullExpressionValue(badgeView, "itemView.tip");
        TextView textView = (TextView) this.itemView.findViewById(R.id.managerRightText);
        Intrinsics.checkNotNullExpressionValue(textView, "itemView.managerRightText");
        View view2 = this.itemView;
        Intrinsics.checkNotNullExpressionValue(view2, "itemView");
        showTips(badgeView, tipModel, textView, view2);
        ((TextView) this.itemView.findViewById(R.id.managerRightText)).setCompoundDrawablePadding(this.itemView.getResources().getDimensionPixelOffset(R.dimen.manager_text_drawable_padding));
        ((TextView) this.itemView.findViewById(R.id.managerRightText)).setOnClickListener(new ManagerGuideViewHolder$$ExternalSyntheticLambda0(context, this, data));
    }

    /* access modifiers changed from: private */
    /* renamed from: populate$lambda-0  reason: not valid java name */
    public static final void m1669populate$lambda0(Context $context, ManagerGuideViewHolder this$0, PersonalCenterGroupModel $data, View it) {
        List<PersonalCenterTabModel> personalCenterTabs;
        PersonalCenterTabModel personalCenterTabModel;
        List<PersonalCenterTabItemModel> body;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        PersonalCenterTabItemModel personalCenterTabItemModel = null;
        Activity activity = $context instanceof Activity ? (Activity) $context : null;
        if (activity != null) {
            activity.startActivity(new Intent($context, TemplateManagerActivity.class));
        }
        ModuleActionListener moduleActionListener2 = this$0.moduleActionListener;
        if (moduleActionListener2 != null) {
            if (!($data == null || (personalCenterTabs = $data.getPersonalCenterTabs()) == null || (personalCenterTabModel = (PersonalCenterTabModel) CollectionsKt.firstOrNull(personalCenterTabs)) == null || (body = personalCenterTabModel.getBody()) == null)) {
                personalCenterTabItemModel = (PersonalCenterTabItemModel) CollectionsKt.firstOrNull(body);
            }
            moduleActionListener2.onChildItemClickListener(personalCenterTabItemModel, this$0.getPage() - 1, this$0.cardPosition);
        }
        NewPersonalItemNewTip.getInstance().setItemRead(PersonalConstants.ID_MANAGERMENT_TIPS);
    }

    public final void setBubble(BubbleBaseManager bubble) {
        this.mBubble = bubble;
    }

    private final int getPage() {
        BubbleBaseManager bubbleBaseManager = this.mBubble;
        if (bubbleBaseManager != null) {
            if ((bubbleBaseManager != null && !bubbleBaseManager.isDismissed()) && ((BadgeView) this.itemView.findViewById(R.id.tip)).getVisibility() == 0) {
                return 3;
            }
        }
        BubbleBaseManager bubbleBaseManager2 = this.mBubble;
        if (bubbleBaseManager2 != null) {
            if ((bubbleBaseManager2 != null && !bubbleBaseManager2.isDismissed()) && ((BadgeView) this.itemView.findViewById(R.id.tip)).getVisibility() != 0) {
                return 2;
            }
        }
        BubbleBaseManager bubbleBaseManager3 = this.mBubble;
        return (!(bubbleBaseManager3 != null && bubbleBaseManager3.isDismissed()) || ((BadgeView) this.itemView.findViewById(R.id.tip)).getVisibility() != 0) ? 0 : 1;
    }

    private final void showTips(BadgeView newTip, TipModel info, View target, View itemView) {
        Integer intOrNull;
        if (info == null || !TextUtils.equals(info.isShow, "1")) {
            newTip.setVisibility(8);
            return;
        }
        String str = info.type;
        if (Intrinsics.areEqual((Object) str, (Object) "point")) {
            newTip.setType(BadgeView.Type.DOT);
            newTip.bindViewInRelativeLayout(target, (RelativeLayout) itemView, BadgeView.DefaultPosition.ICON_DOT_NORMAL);
            int[] marginLeft = newTip.getBadgeMargin();
            newTip.setBadgeMarginInPx(marginLeft[0], marginLeft[1], marginLeft[2], marginLeft[3] - ((int) ((RelativeLayout) itemView).getResources().getDimension(R.dimen.personal_common_fun_number_tips_margin_bottom_offset)));
            newTip.setVisibility(0);
        } else if (Intrinsics.areEqual((Object) str, (Object) TipsTypeConstants.NUMBERIC)) {
            newTip.setType(BadgeView.Type.SMALL_TEXT);
            newTip.setCountFormatType(BadgeView.CountFormatType.MAX_99);
            newTip.bindViewInRelativeLayout(target, (RelativeLayout) itemView, BadgeView.DefaultPosition.ICON_SMALL_TXT_NORMAL);
            int[] marginLeft2 = newTip.getBadgeMargin();
            String str2 = info.text;
            if (str2 != null && (intOrNull = StringsKt.toIntOrNull(str2)) != null) {
                int it = intOrNull.intValue();
                if (it <= 99 || !(FontSizeHelper.getFontSizeType() == 3 || FontSizeHelper.getFontSizeType() == 4)) {
                    newTip.setBadgeMarginInPx((int) FontSizeHelper.getScaledSize(2, ((float) marginLeft2[0]) - ((RelativeLayout) itemView).getResources().getDimension(R.dimen.personal_common_fun_number_tips_margin_left_offset)), marginLeft2[1], marginLeft2[2], marginLeft2[3]);
                } else {
                    newTip.setBadgeMarginInPx((int) FontSizeHelper.getScaledSize(2, ((float) marginLeft2[0]) - ((RelativeLayout) itemView).getResources().getDimension(R.dimen.personal_function_base_tips_margin_left_offset)), marginLeft2[1], marginLeft2[2], marginLeft2[3]);
                }
                newTip.setBadgeCount(it);
                newTip.setVisibility(0);
            }
        } else {
            newTip.setVisibility(8);
        }
    }
}
