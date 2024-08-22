package com.baidu.searchbox.video.feedflow.detail.dynamic.preview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.video.feedflow.component.R;
import com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicModel;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0002\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u001b\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/ImagePagerAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/ImagePagerAdapter$ViewHolder;", "imageList", "", "Lcom/baidu/searchbox/video/feedflow/view/carousepic/CarouselPicModel;", "context", "Landroid/content/Context;", "(Ljava/util/List;Landroid/content/Context;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DynamicPreviewView.kt */
final class ImagePagerAdapter extends RecyclerView.Adapter<ViewHolder> {
    private final Context context;
    private final List<CarouselPicModel> imageList;

    public ImagePagerAdapter(List<CarouselPicModel> imageList2, Context context2) {
        Intrinsics.checkNotNullParameter(imageList2, "imageList");
        Intrinsics.checkNotNullParameter(context2, "context");
        this.imageList = imageList2;
        this.context = context2;
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View view2 = LayoutInflater.from(this.context).inflate(R.layout.video_flow_dynamic_preview_item_view, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "from(context).inflate(R.…item_view, parent, false)");
        return new ViewHolder(this, view2);
    }

    /* JADX WARNING: type inference failed for: r4v4, types: [com.facebook.drawee.interfaces.DraweeHierarchy] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onBindViewHolder(com.baidu.searchbox.video.feedflow.detail.dynamic.preview.ImagePagerAdapter.ViewHolder r8, int r9) {
        /*
            r7 = this;
            java.lang.String r0 = "holder"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            java.util.List<com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicModel> r0 = r7.imageList
            java.lang.Object r0 = r0.get(r9)
            com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicModel r0 = (com.baidu.searchbox.video.feedflow.view.carousepic.CarouselPicModel) r0
            boolean r1 = r0.isThumbnailEnabled()
            if (r1 == 0) goto L_0x0018
            java.lang.String r1 = r0.getThumbnailUrl()
            goto L_0x001c
        L_0x0018:
            java.lang.String r1 = r0.getImageUrl()
        L_0x001c:
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r2 = com.facebook.drawee.backends.pipeline.Fresco.newDraweeControllerBuilder()
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r2 = r2.setUri((java.lang.String) r1)
            r3 = 0
            com.facebook.drawee.controller.AbstractDraweeControllerBuilder r2 = r2.setAutoPlayAnimations(r3)
            com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder r2 = (com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder) r2
            com.facebook.drawee.controller.AbstractDraweeController r2 = r2.build()
            java.lang.String r4 = "newDraweeControllerBuild…Animations(false).build()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r4)
            com.facebook.drawee.interfaces.DraweeController r2 = (com.facebook.drawee.interfaces.DraweeController) r2
            com.facebook.drawee.view.SimpleDraweeView r4 = r8.getImageView()
            r5 = 0
            if (r4 == 0) goto L_0x0047
            com.facebook.drawee.interfaces.DraweeHierarchy r4 = r4.getHierarchy()
            com.facebook.drawee.generic.GenericDraweeHierarchy r4 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r4
            goto L_0x0048
        L_0x0047:
            r4 = r5
        L_0x0048:
            if (r4 != 0) goto L_0x004b
            goto L_0x0050
        L_0x004b:
            com.facebook.drawee.drawable.ScalingUtils$ScaleType r6 = com.facebook.drawee.drawable.ScalingUtils.ScaleType.CENTER_CROP
            r4.setActualImageScaleType(r6)
        L_0x0050:
            com.facebook.drawee.view.SimpleDraweeView r4 = r8.getImageView()
            if (r4 == 0) goto L_0x005d
            com.facebook.drawee.interfaces.DraweeHierarchy r4 = r4.getHierarchy()
            r5 = r4
            com.facebook.drawee.generic.GenericDraweeHierarchy r5 = (com.facebook.drawee.generic.GenericDraweeHierarchy) r5
        L_0x005d:
            if (r5 != 0) goto L_0x0060
            goto L_0x0063
        L_0x0060:
            r5.setUseGlobalColorFilter(r3)
        L_0x0063:
            com.facebook.drawee.view.SimpleDraweeView r3 = r8.getImageView()
            if (r3 != 0) goto L_0x006a
            goto L_0x006d
        L_0x006a:
            r3.setController(r2)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.video.feedflow.detail.dynamic.preview.ImagePagerAdapter.onBindViewHolder(com.baidu.searchbox.video.feedflow.detail.dynamic.preview.ImagePagerAdapter$ViewHolder, int):void");
    }

    public int getItemCount() {
        return this.imageList.size();
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/ImagePagerAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/baidu/searchbox/video/feedflow/detail/dynamic/preview/ImagePagerAdapter;Landroid/view/View;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "setImageView", "(Lcom/facebook/drawee/view/SimpleDraweeView;)V", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DynamicPreviewView.kt */
    public final class ViewHolder extends RecyclerView.ViewHolder {
        private SimpleDraweeView imageView;
        final /* synthetic */ ImagePagerAdapter this$0;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(ImagePagerAdapter this$02, View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.this$0 = this$02;
            this.imageView = (SimpleDraweeView) itemView.findViewById(R.id.iv_pic);
        }

        public final SimpleDraweeView getImageView() {
            return this.imageView;
        }

        public final void setImageView(SimpleDraweeView simpleDraweeView) {
            this.imageView = simpleDraweeView;
        }
    }
}
