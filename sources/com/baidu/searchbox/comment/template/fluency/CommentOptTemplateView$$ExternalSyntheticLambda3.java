package com.baidu.searchbox.comment.template.fluency;

import android.view.ViewGroup;
import com.baidu.searchbox.comment.model.CommentModel;

/* compiled from: D8$$SyntheticClass */
public final /* synthetic */ class CommentOptTemplateView$$ExternalSyntheticLambda3 implements Runnable {
    public final /* synthetic */ CommentOptTemplateView f$0;
    public final /* synthetic */ int f$1;
    public final /* synthetic */ CommentModel f$2;
    public final /* synthetic */ boolean f$3;
    public final /* synthetic */ ViewGroup f$4;

    public /* synthetic */ CommentOptTemplateView$$ExternalSyntheticLambda3(CommentOptTemplateView commentOptTemplateView, int i2, CommentModel commentModel, boolean z, ViewGroup viewGroup) {
        this.f$0 = commentOptTemplateView;
        this.f$1 = i2;
        this.f$2 = commentModel;
        this.f$3 = z;
        this.f$4 = viewGroup;
    }

    public final void run() {
        CommentOptTemplateView.m16867handleLongClickPopupWindow$lambda13(this.f$0, this.f$1, this.f$2, this.f$3, this.f$4);
    }
}
