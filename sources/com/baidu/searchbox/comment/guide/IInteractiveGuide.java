package com.baidu.searchbox.comment.guide;

import androidx.fragment.app.FragmentActivity;
import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@StableApi
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001:\u0001\u000eJ\u001a\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\b\u001a\u00020\u00032\b\u0010\t\u001a\u0004\u0018\u00010\nH&J\u0012\u0010\u000b\u001a\u00020\u00032\b\u0010\f\u001a\u0004\u0018\u00010\rH&¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/comment/guide/IInteractiveGuide;", "", "dismissIfNeed", "", "context", "Landroidx/fragment/app/FragmentActivity;", "orientation", "", "guide", "callParams", "Lcom/baidu/searchbox/comment/guide/InteractiveGuideInvokeParams;", "setInteractiveGuideParams", "params", "Lcom/baidu/searchbox/comment/guide/InteractiveGuideShareParams;", "EMPTY", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: IInteractiveGuide.kt */
public interface IInteractiveGuide {
    void dismissIfNeed(FragmentActivity fragmentActivity, int i2);

    void guide(InteractiveGuideInvokeParams interactiveGuideInvokeParams);

    void setInteractiveGuideParams(InteractiveGuideShareParams interactiveGuideShareParams);

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0012\u0010\f\u001a\u00020\u00042\b\u0010\r\u001a\u0004\u0018\u00010\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/baidu/searchbox/comment/guide/IInteractiveGuide$EMPTY;", "Lcom/baidu/searchbox/comment/guide/IInteractiveGuide;", "()V", "dismissIfNeed", "", "context", "Landroidx/fragment/app/FragmentActivity;", "orientation", "", "guide", "callParams", "Lcom/baidu/searchbox/comment/guide/InteractiveGuideInvokeParams;", "setInteractiveGuideParams", "params", "Lcom/baidu/searchbox/comment/guide/InteractiveGuideShareParams;", "lib-comment-interface_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: IInteractiveGuide.kt */
    public static final class EMPTY implements IInteractiveGuide {
        public void guide(InteractiveGuideInvokeParams callParams) {
        }

        public void dismissIfNeed(FragmentActivity context, int orientation) {
        }

        public void setInteractiveGuideParams(InteractiveGuideShareParams params) {
        }
    }
}
