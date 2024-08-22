package com.baidu.searchbox.appframework;

import android.view.animation.Animation;
import com.baidu.searchbox.appframework.ext.ToolBarExtKt;
import com.baidu.searchbox.appframework.ext.UnifiedBottomBarExtKt;
import com.baidu.searchbox.toolbar.CommonToolBar;
import com.baidu.searchbox.unifiedtoolbar.templates.UnifiedBottomBar;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\b"}, d2 = {"com/baidu/searchbox/appframework/EditableActivity$handleEditModeChanged$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "lib-appframework-actiontoolbar_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: EditableActivity.kt */
public final class EditableActivity$handleEditModeChanged$1 implements Animation.AnimationListener {
    final /* synthetic */ EditableActivity this$0;

    EditableActivity$handleEditModeChanged$1(EditableActivity $receiver) {
        this.this$0 = $receiver;
    }

    public void onAnimationStart(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationRepeat(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
    }

    public void onAnimationEnd(Animation animation) {
        Intrinsics.checkNotNullParameter(animation, "animation");
        if (UnifiedBottomBarExtKt.getUseUnifiedBottomBar(this.this$0)) {
            UnifiedBottomBar bottomBar = UnifiedBottomBarExtKt.getBottomBar(this.this$0);
            if (bottomBar != null) {
                bottomBar.setVisibility(8);
                return;
            }
            return;
        }
        CommonToolBar toolBar = ToolBarExtKt.getToolBar(this.this$0);
        if (toolBar != null) {
            toolBar.setVisibility(8);
        }
    }
}
