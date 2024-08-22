package com.baidu.searchbox.newpersonalcenter.viewholder;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.bdeventbus.Action;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.AnimatorEmphasize;
import com.baidu.searchbox.kmm.personalcenter.entities.constants.ViewTypeConstants;
import com.baidu.searchbox.newpersonalcenter.listener.ModuleActionListener;
import com.baidu.searchbox.newpersonalcenter.manager.TaskFinishedEvent;
import com.baidu.searchbox.newpersonalcenter.manager.TaskPopupManagerKt;
import com.baidu.searchbox.personalcenter.R;
import com.baidu.searchbox.personalcenter.animatoricon.AnimatorIconManager;
import com.baidu.searchbox.personalcenter.animatoricon.IAnimatorIcon;
import com.baidu.searchbox.personalcenter.animatoricon.icon.LottieAnimIcon;
import com.baidu.searchbox.utils.PersonalCenterUtils;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

public abstract class ContentBaseHolder extends BaseHolder<PersonalCenterTabItemModel> {
    protected Context context;
    private String iconScale;
    private boolean isEditState;
    protected int position;
    private int tempCategory;

    public ContentBaseHolder(Context context2, View itemView, ModuleActionListener moduleActionListener) {
        super(itemView, moduleActionListener);
        this.context = context2;
    }

    public void setPosition(int position2) {
        this.position = position2;
    }

    public int getTempCategory() {
        return this.tempCategory;
    }

    public String getIconScale() {
        return this.iconScale;
    }

    public void setEditState(boolean editState) {
        this.isEditState = editState;
    }

    public boolean isEditState() {
        return this.isEditState;
    }

    public void adjustLayoutParam(int tempCategory2, String iconScale2) {
        this.tempCategory = tempCategory2;
        this.iconScale = iconScale2;
        ViewGroup.LayoutParams layoutParams = this.itemView.getLayoutParams();
        int width = getContentWidth(getTemplateColumn(tempCategory2));
        int height = getContentHeight(width);
        if ((width > 0 && height > 0) || width == -2 || height == -2) {
            layoutParams.width = width;
            layoutParams.height = height;
            this.itemView.setLayoutParams(layoutParams);
        }
    }

    public int getContentWidth(int column) {
        if (column <= 0) {
            return 0;
        }
        return ((PersonalCenterUtils.getActivityWidth(this.context) - (this.context.getResources().getDimensionPixelOffset(R.dimen.content_margin_left_right) * 2)) - (this.context.getResources().getDimensionPixelOffset(R.dimen.content_template_margin_left) * (column - 1))) / column;
    }

    public void populate(PersonalCenterTabItemModel data) {
        RecyclerView.LayoutParams layoutParams = (RecyclerView.LayoutParams) this.itemView.getLayoutParams();
        layoutParams.leftMargin = getItemLeftMargin();
        this.itemView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void tryReplaceAndPlayLottieIcon(final View rawView, final LottieAnimIcon lottieAnimIcon, final PersonalCenterTabItemModel data) {
        if (TaskPopupManagerKt.getTaskPopup() == null) {
            checkPlayAnim(rawView, lottieAnimIcon, data);
            return;
        }
        rawView.setVisibility(0);
        lottieAnimIcon.setVisibility(8);
        BdEventBus.Companion.getDefault().register(lottieAnimIcon, TaskFinishedEvent.class, new Action<TaskFinishedEvent>() {
            public void call(TaskFinishedEvent taskFinishedEvent) {
                BdEventBus.Companion.getDefault().unregister(lottieAnimIcon);
                ContentBaseHolder.this.checkPlayAnim(rawView, lottieAnimIcon, data);
            }
        });
    }

    /* access modifiers changed from: private */
    public void checkPlayAnim(final View rawView, LottieAnimIcon lottieAnimIcon, PersonalCenterTabItemModel data) {
        if (data.checkCanPlayIconAnim()) {
            lottieAnimIcon.setVisibility(0);
            lottieAnimIcon.setRawView(rawView);
            lottieAnimIcon.setKeyId(data.getKeyId());
            lottieAnimIcon.setAnimationFromUrl(data.getIconAnimUrl());
            lottieAnimIcon.setEmphasizePlayCount(data.getIconAnimationCount());
            lottieAnimIcon.addAnimatorListener(new AnimatorListenerAdapter() {
                public void onAnimationStart(Animator animation) {
                    rawView.setVisibility(4);
                }
            });
            lottieAnimIcon.playAnimation();
            return;
        }
        rawView.setVisibility(0);
        lottieAnimIcon.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void doShowTips(final TextView labelView, PersonalCenterTabItemModel data) {
        labelView.setBackground(this.context.getResources().getDrawable(R.drawable.content_label_red_bg));
        labelView.setTextColor(this.context.getResources().getColor(R.color.GC84));
        if (!TextUtils.isEmpty(data.getTipText())) {
            labelView.setText(data.getTipText());
            if (!data.hasKeyId() || data.getTipsAnimationCount() == 0 || !(labelView instanceof IAnimatorIcon)) {
                labelView.setAlpha(1.0f);
                labelView.setVisibility(0);
                return;
            }
            IAnimatorIcon badgeView = (IAnimatorIcon) labelView;
            badgeView.setKeyId(data.getKeyId());
            if (AnimatorIconManager.INSTANCE.checkCanPlayEntryAnimation(badgeView.getKeyId())) {
                labelView.setAlpha(0.0f);
            } else {
                labelView.setAlpha(1.0f);
            }
            labelView.setVisibility(0);
            badgeView.setEntryAnimatorType(IAnimatorIcon.AnimatorEntry.SLIDE);
            if (AnimatorEmphasize.SWING == data.getAnimatorEmphasizeType()) {
                badgeView.setEmphasizeAnimatorType(AnimatorEmphasize.DEFAULT);
            } else {
                badgeView.setEmphasizeAnimatorType(data.getAnimatorEmphasizeType());
            }
            badgeView.setEmphasizePlayCount(data.getTipsAnimationCount());
            badgeView.tryPlayAnimation(new Function0<Unit>() {
                public Unit invoke() {
                    labelView.setAlpha(1.0f);
                    return null;
                }
            });
            return;
        }
        labelView.setVisibility(8);
    }

    public int getContentHeight(int calWidth) {
        return -2;
    }

    /* access modifiers changed from: protected */
    public int getItemLeftMargin() {
        if (this.position == 0) {
            return this.context.getResources().getDimensionPixelOffset(R.dimen.content_template_first_margin_left);
        }
        return this.context.getResources().getDimensionPixelOffset(R.dimen.content_template_margin_left);
    }

    public int getTemplateColumn(int tempCategory2) {
        return ViewTypeConstants.INSTANCE.getViewTypeColumn(tempCategory2);
    }
}
