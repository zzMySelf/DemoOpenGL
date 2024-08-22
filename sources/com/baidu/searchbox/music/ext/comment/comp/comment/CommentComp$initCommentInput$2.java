package com.baidu.searchbox.music.ext.comment.comp.comment;

import android.text.SpannableString;
import android.view.View;
import com.baidu.searchbox.comment.definition.toolbar.ICommentBarProxy;
import com.baidu.searchbox.toolbar.CommonToolBar;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000C\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0002H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016J\b\u0010\r\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u0004H\u0016J\u0018\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0006H\u0016J\b\u0010\u0015\u001a\u00020\u0004H\u0016J\u0012\u0010\u0016\u001a\u00020\u00042\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\u001a\u0010\u0019\u001a\u00020\u00042\b\u0010\u001a\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0012\u0010\u001b\u001a\u00020\u00042\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\u0012\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010 \u001a\u00020\u0004H\u0016¨\u0006!"}, d2 = {"com/baidu/searchbox/music/ext/comment/comp/comment/CommentComp$initCommentInput$2", "Lcom/baidu/searchbox/comment/definition/toolbar/ICommentBarProxy;", "Lcom/baidu/searchbox/toolbar/CommonToolBar;", "endCommentInputGuide", "", "withAnim", "", "getBarContainer", "getBarItemView", "Landroid/view/View;", "id", "", "isBarItemShow", "isSoFa", "onFontSizeChanged", "setBarItemAlpha", "itemId", "alpha", "", "setBarItemVisible", "visible", "setCloseCommentUI", "setCommentInput", "input", "Landroid/text/SpannableString;", "setCommentInputGuide", "inputGuide", "setCommentsStatus", "s", "", "setDefaultInput", "defaultInput", "setOpenCommentUI", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CommentComp.kt */
public final class CommentComp$initCommentInput$2 implements ICommentBarProxy<CommonToolBar> {
    final /* synthetic */ CommentComp this$0;

    CommentComp$initCommentInput$2(CommentComp $receiver) {
        this.this$0 = $receiver;
    }

    public void setCommentInput(SpannableString input) {
        this.this$0.toolbar.setCommentInput(input);
    }

    public boolean isBarItemShow(int id) {
        return this.this$0.toolbar.isShow(id);
    }

    public void setCloseCommentUI() {
        this.this$0.toolbar.setCloseCommentUIForNews();
    }

    public void setOpenCommentUI() {
        this.this$0.toolbar.setOpenCommentUI();
    }

    public void setBarItemAlpha(int itemId, float alpha) {
        this.this$0.toolbar.setToolBarItemAlpha(itemId, alpha);
    }

    public void setDefaultInput(String defaultInput) {
        this.this$0.toolbar.setDefaultInput(defaultInput);
    }

    public boolean isSoFa() {
        return this.this$0.toolbar.isSoFa();
    }

    public View getBarItemView(int id) {
        View toolBarItemView = this.this$0.toolbar.getToolBarItemView(id);
        return toolBarItemView == null ? new View(this.this$0.getContext()) : toolBarItemView;
    }

    public CommonToolBar getBarContainer() {
        return this.this$0.toolbar;
    }

    public void setBarItemVisible(int itemId, boolean visible) {
        this.this$0.toolbar.setVisible(itemId, visible);
    }

    public void setCommentsStatus(String s) {
        this.this$0.toolbar.setCommentsStatus(s);
    }

    public void setCommentInputGuide(SpannableString inputGuide, boolean withAnim) {
        this.this$0.toolbar.setCommentInputGuide(inputGuide, withAnim);
    }

    public void endCommentInputGuide(boolean withAnim) {
        this.this$0.toolbar.endCommentInputGuide(withAnim);
    }

    public void onFontSizeChanged() {
    }
}
