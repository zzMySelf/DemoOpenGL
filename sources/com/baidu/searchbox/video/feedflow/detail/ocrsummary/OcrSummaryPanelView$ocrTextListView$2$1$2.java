package com.baidu.searchbox.video.feedflow.detail.ocrsummary;

import android.graphics.Rect;
import android.view.View;
import com.baidu.searchbox.player.widget.PortraitPanelDragView;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.OcrExt;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.listview.OcrSummaryContentView;
import com.baidu.searchbox.video.feedflow.detail.ocrsummary.ocrinterface.ItemViewClickListener;
import com.baidu.searchbox.video.feedflow.di.DIFactory;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000;\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J \u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0016J\b\u0010\r\u001a\u00020\u000eH\u0016J*\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0016J\"\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\b2\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u000b\u001a\u00020\fH\u0016J\u001a\u0010\u0015\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0016\u001a\u00020\bH\u0016J1\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0019\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u001aJ\b\u0010\u001b\u001a\u00020\u0003H\u0016J)\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00132\b\u0010\u001e\u001a\u0004\u0018\u00010\u00052\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005H\u0016¢\u0006\u0002\u0010 ¨\u0006!"}, d2 = {"com/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrSummaryPanelView$ocrTextListView$2$1$2", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/ocrinterface/ItemViewClickListener;", "foldView", "", "isFold", "", "getClickedPosition", "position", "", "selectedText", "", "scene", "Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrExt$OcrPanelScene;", "getContentRect", "Landroid/graphics/Rect;", "onClick", "index", "progress", "itemView", "Landroid/view/View;", "onImageClick", "onItemSelected", "summaryTime", "onLinkClick", "cmd", "isOutline", "(Ljava/lang/String;Lcom/baidu/searchbox/video/feedflow/detail/ocrsummary/OcrExt$OcrPanelScene;Ljava/lang/Integer;Z)V", "onLinkShow", "onViewClick", "view", "isLikeBtnSelected", "isDislikeBtnSelected", "(Landroid/view/View;Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: OcrSummaryPanelView.kt */
public final class OcrSummaryPanelView$ocrTextListView$2$1$2 implements ItemViewClickListener {
    final /* synthetic */ OcrSummaryContentView $this_apply;
    final /* synthetic */ OcrSummaryPanelView this$0;

    OcrSummaryPanelView$ocrTextListView$2$1$2(OcrSummaryPanelView $receiver, OcrSummaryContentView $receiver2) {
        this.this$0 = $receiver;
        this.$this_apply = $receiver2;
    }

    public void onClick(int index, int progress, View itemView, OcrExt.OcrPanelScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        if (this.this$0.getPanelDragView().isFullScreenState() && !DIFactory.INSTANCE.isPadLandStyle()) {
            PortraitPanelDragView.showUnFoldPanel$default(this.this$0.getPanelDragView(), false, false, false, 7, (Object) null);
        }
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onTextViewClick(index, progress, scene);
        }
        this.this$0.isOperatedByUser = true;
        this.$this_apply.scrollToPositionByOther(itemView);
    }

    public void foldView(boolean isFold) {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onFoldView(isFold);
        }
    }

    public Rect getContentRect() {
        Rect rect = new Rect();
        this.this$0.contentView.getGlobalVisibleRect(rect);
        return rect;
    }

    public void onItemSelected(View itemView, int summaryTime) {
        if (!this.this$0.isOperatedByUser) {
            this.$this_apply.scrollToPositionByOther(itemView);
        }
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onItemSelected(itemView, summaryTime);
        }
    }

    public void getClickedPosition(int position, String selectedText, OcrExt.OcrPanelScene scene) {
        Intrinsics.checkNotNullParameter(selectedText, "selectedText");
        Intrinsics.checkNotNullParameter(scene, "scene");
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.getClickedPosition(position, selectedText, scene);
        }
    }

    public void onImageClick(int index, View itemView, OcrExt.OcrPanelScene scene) {
        Intrinsics.checkNotNullParameter(scene, "scene");
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onImageClick(index, itemView, scene);
        }
    }

    public void onViewClick(View view2, Boolean isLikeBtnSelected, Boolean isDislikeBtnSelected) {
        Intrinsics.checkNotNullParameter(view2, "view");
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onViewClick(view2, isLikeBtnSelected, isDislikeBtnSelected);
        }
    }

    public void onLinkClick(String cmd, OcrExt.OcrPanelScene scene, Integer index, boolean isOutline) {
        Intrinsics.checkNotNullParameter(cmd, "cmd");
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onLinkClick(cmd, scene, index, isOutline);
        }
    }

    public void onLinkShow() {
        IOcrSummaryPanelListener ocrSummaryListener = this.this$0.getOcrSummaryListener();
        if (ocrSummaryListener != null) {
            ocrSummaryListener.onLinkShow();
        }
    }
}
