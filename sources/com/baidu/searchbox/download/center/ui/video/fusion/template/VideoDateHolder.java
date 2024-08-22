package com.baidu.searchbox.download.center.ui.video.fusion.template;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.baidu.searchbox.download.center.R;
import com.baidu.searchbox.download.center.ui.video.fusion.adapter.BaseVideoManagerHolder;
import com.baidu.searchbox.download.center.ui.video.fusion.model.AbsVideoTemplateModel;
import com.baidu.searchbox.download.center.ui.video.fusion.model.VideoDateModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J*\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0016J0\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u0002\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fH\u0002¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/download/center/ui/video/fusion/template/VideoDateHolder;", "Lcom/baidu/searchbox/download/center/ui/video/fusion/adapter/BaseVideoManagerHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "update", "", "templateModel", "Lcom/baidu/searchbox/download/center/ui/video/fusion/model/AbsVideoTemplateModel;", "position", "", "editMode", "", "isSelected", "updateItemView", "Landroid/view/ViewGroup;", "videoDateModel", "Lcom/baidu/searchbox/download/center/ui/video/fusion/model/VideoDateModel;", "lib-download-center_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoDateHolder.kt */
public final class VideoDateHolder extends BaseVideoManagerHolder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public VideoDateHolder(View itemView) {
        super(itemView);
        Intrinsics.checkNotNullParameter(itemView, "itemView");
    }

    public void update(AbsVideoTemplateModel templateModel, int position, boolean editMode, boolean isSelected) {
        if (templateModel instanceof VideoDateModel) {
            View view2 = this.itemView;
            ViewGroup itemView = view2 instanceof ViewGroup ? (ViewGroup) view2 : null;
            if (itemView != null) {
                updateItemView(itemView, (VideoDateModel) templateModel, position, editMode, isSelected);
            }
        }
    }

    private final void updateItemView(ViewGroup itemView, VideoDateModel videoDateModel, int position, boolean editMode, boolean isSelected) {
        TextView textView = (TextView) itemView.findViewById(R.id.videoTemplateDateText);
        if (textView != null) {
            textView.setBackgroundColor(ContextCompat.getColor(itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC18));
        }
        TextView textView2 = (TextView) itemView.findViewById(R.id.videoTemplateDateText);
        if (textView2 != null) {
            textView2.setTextColor(ContextCompat.getColor(itemView.getContext(), com.baidu.android.common.ui.style.R.color.GC1));
        }
        TextView textView3 = (TextView) itemView.findViewById(R.id.videoTemplateDateText);
        if (textView3 != null) {
            textView3.setText(videoDateModel.getTitle());
        }
    }
}
