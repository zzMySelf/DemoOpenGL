package com.baidu.searchbox.comment.commentlist.templateview.switcher;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.android.ext.widget.BdContentPopupWindow;
import com.baidu.searchbox.comment.R;
import com.baidu.searchbox.comment.commentlist.templateview.switcher.CommentHeaderSwitcher;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/comment/commentlist/templateview/switcher/HeaderSwitcherPopup;", "Lcom/baidu/android/ext/widget/BdContentPopupWindow;", "context", "Landroid/content/Context;", "switcherAdapter", "Lcom/baidu/searchbox/comment/commentlist/templateview/switcher/ICommentHeaderSwitcher;", "selectedId", "", "(Landroid/content/Context;Lcom/baidu/searchbox/comment/commentlist/templateview/switcher/ICommentHeaderSwitcher;I)V", "popupSwitcher", "Lcom/baidu/searchbox/comment/commentlist/templateview/switcher/CommentHeaderSwitcher;", "setSwitcherPopupListener", "", "switchClickListener", "Lcom/baidu/searchbox/comment/commentlist/templateview/switcher/CommentHeaderSwitcher$SwitchClickListener;", "updateUI", "lib-comment-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HeaderSwitcherPopup.kt */
public final class HeaderSwitcherPopup extends BdContentPopupWindow {
    private CommentHeaderSwitcher popupSwitcher;
    private int selectedId;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HeaderSwitcherPopup(Context context, ICommentHeaderSwitcher switcherAdapter, int selectedId2) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(switcherAdapter, "switcherAdapter");
        this.selectedId = selectedId2;
        setFocusable(true);
        setOutsideTouchable(true);
        setClippingEnabled(false);
        View rootView = View.inflate(context, R.layout.bdcomment_top_header_switcher_popup_layout, (ViewGroup) null);
        if (rootView != null) {
            this.popupSwitcher = new CommentHeaderSwitcher((ViewGroup) rootView, switcherAdapter);
            setPopupWindowContentView(rootView);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public final void setSwitcherPopupListener(CommentHeaderSwitcher.SwitchClickListener switchClickListener) {
        Intrinsics.checkNotNullParameter(switchClickListener, "switchClickListener");
        this.popupSwitcher.setItemClickListener(switchClickListener);
    }

    public final void updateUI(int selectedId2) {
        setBackgroundDrawable(new ColorDrawable(0));
        setResources();
        CommentHeaderSwitcher $this$updateUI_u24lambda_u2d0 = this.popupSwitcher;
        $this$updateUI_u24lambda_u2d0.setSelectedId(selectedId2);
        $this$updateUI_u24lambda_u2d0.updatePopupSceneUI();
        update();
    }
}
