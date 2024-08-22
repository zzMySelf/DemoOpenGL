package com.baidu.searchbox.newpersonalcenter.widget;

import android.animation.Animator;
import android.util.Log;
import com.baidu.searchbox.config.QuickPersistConfig;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabItemModel;
import com.baidu.searchbox.kmm.personalcenter.entities.PersonalCenterTabModel;
import com.baidu.searchbox.newpersonalcenter.advisory.PersonalAdvisoryManager;
import com.baidu.searchbox.personal.NewPersonalItemNewTip;
import com.baidu.searchbox.personal.NewVerticalScrollUbcTrigger;
import com.baidu.searchbox.utils.PersonCenterUBCStatistic;
import com.baidu.talos.core.render.animation.AnimConstants;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\t"}, d2 = {"com/baidu/searchbox/newpersonalcenter/widget/AvatarAnimView$startAnim$1", "Landroid/animation/Animator$AnimatorListener;", "onAnimationCancel", "", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "lib-personal-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AvatarAnimView.kt */
public final class AvatarAnimView$startAnim$1 implements Animator.AnimatorListener {
    final /* synthetic */ SimpleDraweeView $imgView;
    final /* synthetic */ PersonalCenterTabItemModel $info;
    final /* synthetic */ int $position;
    final /* synthetic */ AvatarAnimView this$0;

    AvatarAnimView$startAnim$1(AvatarAnimView $receiver, SimpleDraweeView $imgView2, PersonalCenterTabItemModel $info2, int $position2) {
        this.this$0 = $receiver;
        this.$imgView = $imgView2;
        this.$info = $info2;
        this.$position = $position2;
    }

    public void onAnimationStart(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (AvatarAnimView.DEBUG) {
            Log.d("AvatarAnimView", AnimConstants.ON_ANIMATION_START);
        }
        this.this$0.mIsAnimCancel = false;
        PersonalAdvisoryManager.INSTANCE.addAvatarAnim(this.this$0);
    }

    public void onAnimationEnd(Animator animation) {
        int count;
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (AvatarAnimView.DEBUG) {
            Log.d("AvatarAnimView", "onAnimationEnd isCancel: " + this.this$0.mIsAnimCancel);
        }
        this.this$0.endAnimStatus(this.$imgView);
        if (!this.this$0.mIsAnimCancel && (count = QuickPersistConfig.getInstance().getInt(NewPersonalItemNewTip.ADVISORY_ANIM_SHOW_COUNT, -1)) > 0) {
            QuickPersistConfig.getInstance().putInt(NewPersonalItemNewTip.ADVISORY_ANIM_SHOW_COUNT, count - 1);
        }
        PersonalCenterTabItemModel personalCenterTabItemModel = this.$info;
        if (personalCenterTabItemModel != null) {
            String type = NewVerticalScrollUbcTrigger.getType(personalCenterTabItemModel);
            String value = NewVerticalScrollUbcTrigger.getValue(this.$info, "show");
            JSONObject ext = NewVerticalScrollUbcTrigger.getExt(this.$info);
            String from = NewVerticalScrollUbcTrigger.getFrom((PersonalCenterTabModel) null, this.$info);
            PersonalCenterTabItemModel personalCenterTabItemModel2 = this.$info;
            PersonCenterUBCStatistic.statisticUBC(type, "7", value, ext, from, personalCenterTabItemModel2 != null ? personalCenterTabItemModel2.getUbcEventId() : null, NewVerticalScrollUbcTrigger.getPage(this.$info, this.$position));
        }
    }

    public void onAnimationCancel(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (AvatarAnimView.DEBUG) {
            Log.d("AvatarAnimView", AnimConstants.ON_ANIMATION_CANCEL);
        }
        this.this$0.mIsAnimCancel = true;
        this.this$0.endAnimStatus(this.$imgView);
    }

    public void onAnimationRepeat(Animator animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }
}
