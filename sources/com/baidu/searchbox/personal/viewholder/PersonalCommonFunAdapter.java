package com.baidu.searchbox.personal.viewholder;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.net.Uri;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewStub;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.RelativeLayout;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeTextViewExtKt;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.TipsType;
import com.baidu.searchbox.newpersonalcenter.manager.TaskFinishedEvent;
import com.baidu.searchbox.newpersonalcenter.manager.TaskPopupManagerKt;
import com.baidu.searchbox.newpersonalcenter.widget.StrokeTextView;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.personalcenter.animatoricon.AnimatorIconManager;
import com.baidu.searchbox.personalcenter.animatoricon.IAnimatorIcon;
import com.baidu.searchbox.personalcenter.animatoricon.icon.LottieAnimIcon;
import com.baidu.searchbox.skin.NightModeHelper;
import com.baidu.searchbox.ui.BdBaseLottieView;
import com.baidu.searchbox.ui.TouchStateListener;
import com.baidu.searchbox.ui.view.BadgeView;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u000212B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J$\u0010\u001c\u001a\u00020\u00152\u0006\u0010\u001d\u001a\u00020\u001e2\n\u0010\u001f\u001a\u00060 R\u00020\u00002\u0006\u0010!\u001a\u00020\u0019H\u0002J\b\u0010\"\u001a\u00020\u001eH\u0016J\u0010\u0010#\u001a\u00020$2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\u0010\u0010%\u001a\u00020&2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010'\u001a\u00020\u001eH\u0002J$\u0010(\u001a\u00020\u00192\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010\u00192\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J\u001e\u0010,\u001a\u0004\u0018\u00010\u00172\n\u0010-\u001a\u00060 R\u00020\u00002\u0006\u0010!\u001a\u00020\u0019H\u0002J\u0016\u0010.\u001a\u00020\u00152\u000e\u0010/\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u000100R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R \u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u00063"}, d2 = {"Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter;", "Landroid/widget/BaseAdapter;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "getContext", "()Landroid/content/Context;", "data", "", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "onCommonFunItemClickListener", "Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter$OnCommonFunItemClickListener;", "getOnCommonFunItemClickListener", "()Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter$OnCommonFunItemClickListener;", "setOnCommonFunItemClickListener", "(Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter$OnCommonFunItemClickListener;)V", "addTextTipsToParent", "", "tips", "Lcom/baidu/searchbox/ui/view/BadgeView;", "target", "Landroid/view/View;", "targetParent", "Landroid/widget/RelativeLayout;", "buildView", "position", "", "viewHolder", "Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter$CommonFuncViewHolder;", "itemView", "getCount", "getItem", "", "getItemId", "", "getItemWidth", "getView", "convertView", "parent", "Landroid/view/ViewGroup;", "initBadgeView", "holder", "setCommonFunData", "list", "", "CommonFuncViewHolder", "OnCommonFunItemClickListener", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalCommonFunAdapter.kt */
public final class PersonalCommonFunAdapter extends BaseAdapter {
    private final Context context;
    private List<PersonalCenterTabItemModel> data = new ArrayList();
    private OnCommonFunItemClickListener onCommonFunItemClickListener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter$OnCommonFunItemClickListener;", "", "onClick", "", "position", "", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalCommonFunAdapter.kt */
    public interface OnCommonFunItemClickListener {
        void onClick(int i2);
    }

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalCommonFunAdapter.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TipsType.values().length];
            iArr[TipsType.DOT_TIP.ordinal()] = 1;
            iArr[TipsType.NUMBER_TIP.ordinal()] = 2;
            iArr[TipsType.TEXT_TIP.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public PersonalCommonFunAdapter(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        this.context = context2;
    }

    public final Context getContext() {
        return this.context;
    }

    public final List<PersonalCenterTabItemModel> getData() {
        return this.data;
    }

    public final void setData(List<PersonalCenterTabItemModel> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.data = list;
    }

    public final OnCommonFunItemClickListener getOnCommonFunItemClickListener() {
        return this.onCommonFunItemClickListener;
    }

    public final void setOnCommonFunItemClickListener(OnCommonFunItemClickListener onCommonFunItemClickListener2) {
        this.onCommonFunItemClickListener = onCommonFunItemClickListener2;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView;
        int i2 = position;
        ViewGroup viewGroup = parent;
        Ref.ObjectRef viewHolder = new Ref.ObjectRef();
        viewHolder.element = new CommonFuncViewHolder();
        if (convertView == null) {
            View inflate = LayoutInflater.from(this.context).inflate(R.layout.personal_new_common_fun_item_layout, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "from(context).inflate(\n …em_layout, parent, false)");
            itemView = inflate;
            itemView.setOnTouchListener(new TouchStateListener(itemView));
            CommonFuncViewHolder $this$getView_u24lambda_u2d0 = (CommonFuncViewHolder) viewHolder.element;
            View findViewById = itemView.findViewById(R.id.common_fun_img);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.common_fun_img)");
            $this$getView_u24lambda_u2d0.setImageView((SimpleDraweeView) findViewById);
            FontSizeViewExtKt.setScaledSizeRes$default($this$getView_u24lambda_u2d0.getImageView(), 2, R.dimen.common_fun_img_size, R.dimen.common_fun_img_size, 0, 8, (Object) null);
            GenericDraweeHierarchy hierarchy = new GenericDraweeHierarchyBuilder(this.context.getResources()).build();
            hierarchy.setPlaceholderImage(this.context.getResources().getDrawable(R.drawable.personal_default_item));
            hierarchy.setUseGlobalColorFilter(false);
            $this$getView_u24lambda_u2d0.getImageView().setHierarchy(hierarchy);
            View findViewById2 = itemView.findViewById(R.id.common_fun_text);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.common_fun_text)");
            $this$getView_u24lambda_u2d0.setTextView((StrokeTextView) findViewById2);
            FontSizeTextViewExtKt.setScaledSizeRes$default($this$getView_u24lambda_u2d0.getTextView(), 2, R.dimen.common_fun_text_size, 0, 4, (Object) null);
            View findViewById3 = itemView.findViewById(R.id.common_fun_animation_icon);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.…ommon_fun_animation_icon)");
            $this$getView_u24lambda_u2d0.setAnimationIcon((LottieAnimIcon) findViewById3);
            FontSizeViewExtKt.setScaledSizeRes$default($this$getView_u24lambda_u2d0.getAnimationIcon(), 2, R.dimen.common_fun_img_size, R.dimen.common_fun_img_size, 0, 8, (Object) null);
            View findViewById4 = itemView.findViewById(R.id.notify_lottie);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.notify_lottie)");
            $this$getView_u24lambda_u2d0.setNotifylottieView((BdBaseLottieView) findViewById4);
            itemView.setTag(viewHolder.element);
        } else {
            itemView = convertView;
            T tag = itemView.getTag();
            if (tag != null) {
                viewHolder.element = (CommonFuncViewHolder) tag;
            } else {
                throw new NullPointerException("null cannot be cast to non-null type com.baidu.searchbox.personal.viewholder.PersonalCommonFunAdapter.CommonFuncViewHolder");
            }
        }
        itemView.setOnClickListener(new PersonalCommonFunAdapter$$ExternalSyntheticLambda0(this, i2, viewHolder));
        if (viewGroup instanceof GridView) {
            ViewGroup.LayoutParams layoutParams = itemView.getLayoutParams();
            layoutParams.width = getItemWidth();
            itemView.setLayoutParams(layoutParams);
        }
        buildView(i2, (CommonFuncViewHolder) viewHolder.element, itemView);
        return itemView;
    }

    /* access modifiers changed from: private */
    /* renamed from: getView$lambda-1  reason: not valid java name */
    public static final void m2151getView$lambda1(PersonalCommonFunAdapter this$0, int $position, Ref.ObjectRef $viewHolder, View it) {
        BadgeView tips;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($viewHolder, "$viewHolder");
        OnCommonFunItemClickListener onCommonFunItemClickListener2 = this$0.onCommonFunItemClickListener;
        if (onCommonFunItemClickListener2 != null) {
            onCommonFunItemClickListener2.onClick($position);
        }
        PersonalCenterTabItemModel info = (PersonalCenterTabItemModel) CollectionsKt.getOrNull(this$0.data, $position);
        if (info != null && !AnimatorIconManager.INSTANCE.checkTipClickInfo(info.getKeyId()) && (tips = ((CommonFuncViewHolder) $viewHolder.element).getTips()) != null) {
            tips.setVisibility(8);
        }
    }

    private final BadgeView initBadgeView(CommonFuncViewHolder holder, View itemView) {
        if (holder.getTips() == null) {
            ViewStub badgeViewStub = (ViewStub) itemView.findViewById(R.id.common_fun_tips);
            if (badgeViewStub != null) {
                View inflate = badgeViewStub.inflate();
                holder.setTips(inflate instanceof BadgeView ? (BadgeView) inflate : null);
            }
            BadgeView tips = holder.getTips();
            if (tips != null) {
                tips.setMaxLines(1);
            }
        }
        return holder.getTips();
    }

    private final int getItemWidth() {
        Point point = new Point();
        ((Activity) this.context).getWindow().getWindowManager().getDefaultDisplay().getSize(point);
        return ((point.x - (((Activity) this.context).getResources().getDimensionPixelOffset(R.dimen.template_margin_left) * 2)) - (((Activity) this.context).getResources().getDimensionPixelOffset(R.dimen.personal_grid_view_horizontal_spacing) * 4)) / 5;
    }

    private final void buildView(int position, CommonFuncViewHolder viewHolder, View itemView) {
        Integer intOrNull;
        CommonFuncViewHolder commonFuncViewHolder = viewHolder;
        View view2 = itemView;
        CommonFuncViewHolder $this$buildView_u24lambda_u2d3 = viewHolder;
        PersonalCenterTabItemModel info = this.data.get(position);
        $this$buildView_u24lambda_u2d3.getTextView().setTextColor(this.context.getResources().getColor(R.color.GC1));
        $this$buildView_u24lambda_u2d3.getTextView().setText(info.getTitle());
        if (NightModeHelper.getNightModeSwitcherState()) {
            if (!TextUtils.isEmpty(info.getIconNightUrl())) {
                $this$buildView_u24lambda_u2d3.getImageView().setImageURI(Uri.parse(info.getIconNightUrl()));
            } else if (!TextUtils.isEmpty(info.getIcon())) {
                $this$buildView_u24lambda_u2d3.getImageView().setImageURI(Uri.parse(info.getIcon()));
            }
        } else if (!TextUtils.isEmpty(info.getIcon())) {
            $this$buildView_u24lambda_u2d3.getImageView().setImageURI(Uri.parse(info.getIcon()));
        }
        if (TaskPopupManagerKt.getTaskPopup() == null) {
            $this$buildView_u24lambda_u2d3.checkPlayAnim(info);
        } else {
            $this$buildView_u24lambda_u2d3.getImageView().setVisibility(0);
            $this$buildView_u24lambda_u2d3.getAnimationIcon().setVisibility(8);
            BdEventBus.Companion.getDefault().register($this$buildView_u24lambda_u2d3.getAnimationIcon(), TaskFinishedEvent.class, new PersonalCommonFunAdapter$buildView$1$1($this$buildView_u24lambda_u2d3, info));
        }
        BadgeView tips = $this$buildView_u24lambda_u2d3.getTips();
        if (tips != null) {
            tips.setVisibility(8);
        }
        boolean z = true;
        switch (WhenMappings.$EnumSwitchMapping$0[info.getTipsType().ordinal()]) {
            case 1:
                initBadgeView(commonFuncViewHolder, view2);
                BadgeView tips2 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips2 != null) {
                    tips2.setType(BadgeView.Type.DOT);
                }
                BadgeView tips3 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips3 != null) {
                    tips3.bindViewInRelativeLayout($this$buildView_u24lambda_u2d3.getImageView(), (RelativeLayout) view2, BadgeView.DefaultPosition.ICON_DOT_NORMAL);
                }
                BadgeView tips4 = $this$buildView_u24lambda_u2d3.getTips();
                int[] badgeMargin = tips4 != null ? tips4.getBadgeMargin() : null;
                if (badgeMargin == null) {
                    badgeMargin = new int[]{0, 0, 0, 0};
                } else {
                    Intrinsics.checkNotNullExpressionValue(badgeMargin, "tips?.badgeMargin?: intArrayOf(0, 0, 0, 0)");
                }
                int[] marginLeft = badgeMargin;
                BadgeView tips5 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips5 != null) {
                    tips5.setBadgeMarginInPx(marginLeft[0], marginLeft[1], marginLeft[2], marginLeft[3] - ((int) this.context.getResources().getDimension(R.dimen.personal_common_fun_number_tips_margin_bottom_offset)));
                }
                BadgeView tips6 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips6 != null) {
                    tips6.setVisibility(0);
                    return;
                }
                return;
            case 2:
                initBadgeView(commonFuncViewHolder, view2);
                BadgeView tips7 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips7 != null) {
                    tips7.setType(BadgeView.Type.SMALL_TEXT);
                }
                BadgeView tips8 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips8 != null) {
                    tips8.setCountFormatType(BadgeView.CountFormatType.MAX_99);
                }
                BadgeView tips9 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips9 != null) {
                    tips9.bindViewInRelativeLayout($this$buildView_u24lambda_u2d3.getImageView(), (RelativeLayout) view2, BadgeView.DefaultPosition.ICON_SMALL_TXT_NORMAL);
                }
                BadgeView tips10 = $this$buildView_u24lambda_u2d3.getTips();
                int[] badgeMargin2 = tips10 != null ? tips10.getBadgeMargin() : null;
                if (badgeMargin2 == null) {
                    badgeMargin2 = new int[]{0, 0, 0, 0};
                } else {
                    Intrinsics.checkNotNullExpressionValue(badgeMargin2, "tips?.badgeMargin?: intArrayOf(0, 0, 0, 0)");
                }
                int[] marginLeft2 = badgeMargin2;
                String tipText = info.getTipText();
                if (tipText != null && (intOrNull = StringsKt.toIntOrNull(tipText)) != null) {
                    int it = intOrNull.intValue();
                    if (it <= 99 || !(FontSizeHelper.getFontSizeType() == 3 || FontSizeHelper.getFontSizeType() == 4 || FontSizeHelper.getFontSizeType() == 2)) {
                        BadgeView tips11 = $this$buildView_u24lambda_u2d3.getTips();
                        if (tips11 != null) {
                            tips11.setBadgeMarginInPx((int) FontSizeHelper.getScaledSize(2, ((float) marginLeft2[0]) - this.context.getResources().getDimension(R.dimen.personal_common_fun_number_tips_margin_left_offset)), marginLeft2[1], marginLeft2[2], marginLeft2[3]);
                        }
                    } else {
                        BadgeView tips12 = $this$buildView_u24lambda_u2d3.getTips();
                        if (tips12 != null) {
                            tips12.setBadgeMarginInPx((int) FontSizeHelper.getScaledSize(2, ((float) marginLeft2[0]) - this.context.getResources().getDimension(R.dimen.personal_function_base_tips_margin_left_offset)), marginLeft2[1], marginLeft2[2], marginLeft2[3]);
                        }
                    }
                    BadgeView tips13 = $this$buildView_u24lambda_u2d3.getTips();
                    if (tips13 != null) {
                        tips13.setBadgeCount(it);
                    }
                    BadgeView tips14 = $this$buildView_u24lambda_u2d3.getTips();
                    if (tips14 != null) {
                        tips14.setVisibility(0);
                        return;
                    }
                    return;
                }
                return;
            case 3:
                initBadgeView(commonFuncViewHolder, view2);
                BadgeView tips15 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips15 != null) {
                    tips15.setType(BadgeView.Type.SMALL_TEXT);
                }
                String tipText2 = info.getTipText();
                if (tipText2 == null || tipText2.length() != 1) {
                    z = false;
                }
                if (z) {
                    BadgeView tips16 = $this$buildView_u24lambda_u2d3.getTips();
                    if (tips16 != null) {
                        tips16.bindViewInRelativeLayout($this$buildView_u24lambda_u2d3.getImageView(), (RelativeLayout) view2, BadgeView.DefaultPosition.ICON_SMALL_TXT_NORMAL);
                    }
                } else {
                    addTextTipsToParent($this$buildView_u24lambda_u2d3.getTips(), $this$buildView_u24lambda_u2d3.getImageView(), (RelativeLayout) view2);
                }
                BadgeView tips17 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips17 != null) {
                    tips17.setText(info.getTipText());
                }
                BadgeView badgeView = $this$buildView_u24lambda_u2d3.getTips();
                if (!info.hasKeyId() || info.getTipsAnimationCount() == 0 || !(badgeView instanceof IAnimatorIcon)) {
                    BadgeView tips18 = $this$buildView_u24lambda_u2d3.getTips();
                    if (tips18 != null) {
                        tips18.setVisibility(0);
                        return;
                    }
                    return;
                }
                ((IAnimatorIcon) badgeView).setKeyId(info.getKeyId());
                if (AnimatorIconManager.INSTANCE.checkCanPlayEntryAnimation(((IAnimatorIcon) badgeView).getKeyId())) {
                    BadgeView tips19 = $this$buildView_u24lambda_u2d3.getTips();
                    if (tips19 != null) {
                        tips19.setAlpha(0.0f);
                    }
                } else {
                    BadgeView tips20 = $this$buildView_u24lambda_u2d3.getTips();
                    if (tips20 != null) {
                        tips20.setAlpha(1.0f);
                    }
                }
                BadgeView tips21 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips21 != null) {
                    tips21.setVisibility(0);
                }
                ((IAnimatorIcon) badgeView).setEntryAnimatorType(IAnimatorIcon.AnimatorEntry.SWING);
                if (AnimatorEmphasize.ZOOM == info.getAnimatorEmphasizeType()) {
                    ((IAnimatorIcon) badgeView).setEmphasizeAnimatorType(AnimatorEmphasize.DEFAULT);
                } else {
                    ((IAnimatorIcon) badgeView).setEmphasizeAnimatorType(info.getAnimatorEmphasizeType());
                }
                ((IAnimatorIcon) badgeView).setEmphasizePlayCount(info.getTipsAnimationCount());
                ((IAnimatorIcon) badgeView).tryPlayAnimation(new PersonalCommonFunAdapter$buildView$1$3($this$buildView_u24lambda_u2d3));
                return;
            default:
                BadgeView tips22 = $this$buildView_u24lambda_u2d3.getTips();
                if (tips22 != null) {
                    tips22.setVisibility(8);
                    return;
                }
                return;
        }
    }

    public Object getItem(int position) {
        return this.data.get(position);
    }

    public long getItemId(int position) {
        return (long) position;
    }

    public int getCount() {
        return this.data.size();
    }

    public final void setCommonFunData(List<? extends PersonalCenterTabItemModel> list) {
        this.data.clear();
        if (list != null && (!list.isEmpty())) {
            this.data.addAll(list);
        }
    }

    private final void addTextTipsToParent(BadgeView tips, View target, RelativeLayout targetParent) {
        if (tips != null) {
            ViewParent tipsParent = tips.getParent();
            if (tipsParent != null) {
                ((ViewGroup) tipsParent).removeView(tips);
            }
            ViewGroup.LayoutParams tipsLp = tips.getLayoutParams();
            Intrinsics.checkNotNullExpressionValue(tipsLp, "tips.layoutParams");
            RelativeLayout.LayoutParams badgeLp = new RelativeLayout.LayoutParams(tipsLp.width, tipsLp.height);
            badgeLp.addRule(11);
            badgeLp.addRule(2, target.getId());
            badgeLp.bottomMargin = (int) FontSizeHelper.getScaledSize(2, this.context.getResources().getDimension(R.dimen.personal_common_fun_tips_margin_bottom_offset));
            targetParent.addView(tips, badgeLp);
        }
    }

    @Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020$R\u001a\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001a\u0010\t\u001a\u00020\nX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001c\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 ¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter$CommonFuncViewHolder;", "", "(Lcom/baidu/searchbox/personal/viewholder/PersonalCommonFunAdapter;)V", "animationIcon", "Lcom/baidu/searchbox/personalcenter/animatoricon/icon/LottieAnimIcon;", "getAnimationIcon", "()Lcom/baidu/searchbox/personalcenter/animatoricon/icon/LottieAnimIcon;", "setAnimationIcon", "(Lcom/baidu/searchbox/personalcenter/animatoricon/icon/LottieAnimIcon;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setImageView", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "notifylottieView", "Lcom/baidu/searchbox/ui/BdBaseLottieView;", "getNotifylottieView", "()Lcom/baidu/searchbox/ui/BdBaseLottieView;", "setNotifylottieView", "(Lcom/baidu/searchbox/ui/BdBaseLottieView;)V", "textView", "Lcom/baidu/searchbox/newpersonalcenter/widget/StrokeTextView;", "getTextView", "()Lcom/baidu/searchbox/newpersonalcenter/widget/StrokeTextView;", "setTextView", "(Lcom/baidu/searchbox/newpersonalcenter/widget/StrokeTextView;)V", "tips", "Lcom/baidu/searchbox/ui/view/BadgeView;", "getTips", "()Lcom/baidu/searchbox/ui/view/BadgeView;", "setTips", "(Lcom/baidu/searchbox/ui/view/BadgeView;)V", "checkPlayAnim", "", "info", "Lcom/baidu/searchbox/kmm/personalcenter/entities/PersonalCenterTabItemModel;", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PersonalCommonFunAdapter.kt */
    public final class CommonFuncViewHolder {
        public LottieAnimIcon animationIcon;
        public SimpleDraweeView imageView;
        public BdBaseLottieView notifylottieView;
        public StrokeTextView textView;
        private BadgeView tips;

        public CommonFuncViewHolder() {
        }

        public final SimpleDraweeView getImageView() {
            SimpleDraweeView simpleDraweeView = this.imageView;
            if (simpleDraweeView != null) {
                return simpleDraweeView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("imageView");
            return null;
        }

        public final void setImageView(SimpleDraweeView simpleDraweeView) {
            Intrinsics.checkNotNullParameter(simpleDraweeView, "<set-?>");
            this.imageView = simpleDraweeView;
        }

        public final StrokeTextView getTextView() {
            StrokeTextView strokeTextView = this.textView;
            if (strokeTextView != null) {
                return strokeTextView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("textView");
            return null;
        }

        public final void setTextView(StrokeTextView strokeTextView) {
            Intrinsics.checkNotNullParameter(strokeTextView, "<set-?>");
            this.textView = strokeTextView;
        }

        public final BadgeView getTips() {
            return this.tips;
        }

        public final void setTips(BadgeView badgeView) {
            this.tips = badgeView;
        }

        public final BdBaseLottieView getNotifylottieView() {
            BdBaseLottieView bdBaseLottieView = this.notifylottieView;
            if (bdBaseLottieView != null) {
                return bdBaseLottieView;
            }
            Intrinsics.throwUninitializedPropertyAccessException("notifylottieView");
            return null;
        }

        public final void setNotifylottieView(BdBaseLottieView bdBaseLottieView) {
            Intrinsics.checkNotNullParameter(bdBaseLottieView, "<set-?>");
            this.notifylottieView = bdBaseLottieView;
        }

        public final LottieAnimIcon getAnimationIcon() {
            LottieAnimIcon lottieAnimIcon = this.animationIcon;
            if (lottieAnimIcon != null) {
                return lottieAnimIcon;
            }
            Intrinsics.throwUninitializedPropertyAccessException("animationIcon");
            return null;
        }

        public final void setAnimationIcon(LottieAnimIcon lottieAnimIcon) {
            Intrinsics.checkNotNullParameter(lottieAnimIcon, "<set-?>");
            this.animationIcon = lottieAnimIcon;
        }

        public final void checkPlayAnim(PersonalCenterTabItemModel info) {
            Intrinsics.checkNotNullParameter(info, "info");
            if (info.checkCanPlayIconAnim()) {
                getAnimationIcon().setVisibility(0);
                getAnimationIcon().setRawView(getImageView());
                getAnimationIcon().setKeyId(info.getKeyId());
                getAnimationIcon().setAnimationFromUrl(info.getIconAnimUrl());
                getAnimationIcon().setEmphasizePlayCount(info.getIconAnimationCount());
                getAnimationIcon().addAnimatorListener(new PersonalCommonFunAdapter$CommonFuncViewHolder$checkPlayAnim$1(this));
                getAnimationIcon().playAnimation();
                return;
            }
            getImageView().setVisibility(0);
            getAnimationIcon().setVisibility(8);
        }
    }
}
