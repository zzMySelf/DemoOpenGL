package com.baidu.searchbox.download.center.clearcache.view.funison.views.secondpage;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.clearcache.business.R;
import com.baidu.searchbox.download.center.clearcache.view.funison.fileScan.ScanBean;
import com.baidu.searchbox.favor.data.FavorModel;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.common.ResizeOptions;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 #2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0006\u001e\u001f !\"#B!\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006¢\u0006\u0002\u0010\bJ\b\u0010\u0014\u001a\u00020\nH\u0016J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\nH\u0016J\u0018\u0010\u001a\u001a\u00020\u00022\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\nH\u0016R\u001b\u0010\t\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\n8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u000e\u0010\u0012\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00070\u00060\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006$"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$AbsClearCacheViewHolder;", "context", "Landroid/content/Context;", "list", "", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "(Landroid/content/Context;Ljava/util/List;)V", "itemHeight", "", "getItemHeight", "()I", "itemHeight$delegate", "Lkotlin/Lazy;", "itemWidth", "getItemWidth", "itemWidth$delegate", "mContext", "mImageList", "getItemCount", "getItemViewType", "position", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "AbsClearCacheViewHolder", "ClearCacheFourViewHolder", "ClearCacheOneViewHolder", "ClearCacheThreeViewHolder", "ClearCacheTwoViewHolder", "Companion", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ClearCacheAlbumPreviewAdapter.kt */
public final class ClearCacheAlbumPreviewAdapter extends RecyclerView.Adapter<AbsClearCacheViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final int TEMPLATE_TYPE_FOUR_SIMILAR = 4;
    private static final int TEMPLATE_TYPE_NO_SIMILAR = 1;
    private static final int TEMPLATE_TYPE_THREE_SIMILAR = 3;
    private static final int TEMPLATE_TYPE_TWO_SIMILAR = 2;
    private final Lazy itemHeight$delegate = LazyKt.lazy(ClearCacheAlbumPreviewAdapter$itemHeight$2.INSTANCE);
    private final Lazy itemWidth$delegate = LazyKt.lazy(ClearCacheAlbumPreviewAdapter$itemWidth$2.INSTANCE);
    private final Context mContext;
    private final List<List<ScanBean>> mImageList;

    public ClearCacheAlbumPreviewAdapter(Context context, List<List<ScanBean>> list) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(list, "list");
        this.mImageList = list;
        this.mContext = context;
    }

    private final int getItemWidth() {
        return ((Number) this.itemWidth$delegate.getValue()).intValue();
    }

    private final int getItemHeight() {
        return ((Number) this.itemHeight$delegate.getValue()).intValue();
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rR\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$Companion;", "", "()V", "TEMPLATE_TYPE_FOUR_SIMILAR", "", "TEMPLATE_TYPE_NO_SIMILAR", "TEMPLATE_TYPE_THREE_SIMILAR", "TEMPLATE_TYPE_TWO_SIMILAR", "displayImage", "", "date", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheAlbumPreviewAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void displayImage(ScanBean date, SimpleDraweeView imageView) {
            Intrinsics.checkNotNullParameter(date, "date");
            Intrinsics.checkNotNullParameter(imageView, "imageView");
            Context context = imageView.getContext();
            if (context != null) {
                Drawable placeholderImage = ContextCompat.getDrawable(context, R.drawable.clear_cache_download_grid_item_placeholder);
                GenericDraweeHierarchy genericDraweeHierarchy = (GenericDraweeHierarchy) imageView.getHierarchy();
                if (genericDraweeHierarchy != null) {
                    genericDraweeHierarchy.setPlaceholderImage(placeholderImage);
                }
                String downloadFileImageUri = date.getImageUriFromDownloadPath();
                CharSequence charSequence = downloadFileImageUri;
                if (!(charSequence == null || StringsKt.isBlank(charSequence))) {
                    imageView.setController(((PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(imageView.getController())).setImageRequest(ImageRequestBuilder.newBuilderWithSource(Uri.parse(downloadFileImageUri)).setResizeOptions(new ResizeOptions(DeviceUtils.ScreenInfo.dp2px(context, 74.0f), DeviceUtils.ScreenInfo.dp2px(context, 74.0f), 0.0f, 0.0f, 12, (DefaultConstructorMarker) null)).build())).build());
                }
            }
        }
    }

    public AbsClearCacheViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        switch (viewType) {
            case 1:
                View itemView = LayoutInflater.from(this.mContext).inflate(R.layout.clear_cache_one_preview_item, parent, false);
                itemView.setLayoutParams(new RecyclerView.LayoutParams(getItemWidth(), getItemHeight()));
                Intrinsics.checkNotNullExpressionValue(itemView, "itemView");
                return new ClearCacheOneViewHolder(itemView);
            case 2:
                View itemView2 = LayoutInflater.from(this.mContext).inflate(R.layout.clear_cache_two_preview_item, parent, false);
                itemView2.setLayoutParams(new RecyclerView.LayoutParams(getItemWidth(), getItemHeight()));
                Intrinsics.checkNotNullExpressionValue(itemView2, "itemView");
                return new ClearCacheTwoViewHolder(itemView2);
            case 3:
                View itemView3 = LayoutInflater.from(this.mContext).inflate(R.layout.clear_cache_three_preview_item, parent, false);
                itemView3.setLayoutParams(new RecyclerView.LayoutParams(getItemWidth(), getItemHeight()));
                Intrinsics.checkNotNullExpressionValue(itemView3, "itemView");
                return new ClearCacheThreeViewHolder(itemView3);
            default:
                View itemView4 = LayoutInflater.from(this.mContext).inflate(R.layout.clear_cache_four_preview_item, parent, false);
                itemView4.setLayoutParams(new RecyclerView.LayoutParams(getItemWidth(), getItemHeight()));
                Intrinsics.checkNotNullExpressionValue(itemView4, "itemView");
                return new ClearCacheFourViewHolder(itemView4);
        }
    }

    public void onBindViewHolder(AbsClearCacheViewHolder holder, int position) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
        if (layoutParams != null) {
            RecyclerView.LayoutParams layoutParams2 = (RecyclerView.LayoutParams) layoutParams;
            layoutParams2.leftMargin = position == 0 ? 0 : 15;
            holder.itemView.setLayoutParams(layoutParams2);
            List it = (List) CollectionsKt.getOrNull(this.mImageList, position);
            if (it != null) {
                holder.setImage(it);
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.RecyclerView.LayoutParams");
    }

    public int getItemCount() {
        return this.mImageList.size();
    }

    public int getItemViewType(int position) {
        List imageList = (List) CollectionsKt.getOrNull(this.mImageList, position);
        if (imageList == null) {
            return 1;
        }
        switch (imageList.size()) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            default:
                return 4;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$ClearCacheOneViewHolder;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$AbsClearCacheViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imagePreviewOne", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "setImage", "", "list", "", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheAlbumPreviewAdapter.kt */
    private static final class ClearCacheOneViewHolder extends AbsClearCacheViewHolder {
        private SimpleDraweeView imagePreviewOne;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClearCacheOneViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.imagePreviewOne = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_one);
        }

        public void setImage(List<ScanBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ScanBean itemItem = (ScanBean) CollectionsKt.getOrNull(list, 0);
            if (itemItem != null) {
                Companion companion = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView = this.imagePreviewOne;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imagePreviewOne");
                companion.displayImage(itemItem, simpleDraweeView);
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u000b\u001a\u00020\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000eH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$ClearCacheTwoViewHolder;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$AbsClearCacheViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imagePreviewOne", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "imagePreviewSimilarCount", "Landroid/widget/TextView;", "imagePreviewTwo", "setImage", "", "list", "", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheAlbumPreviewAdapter.kt */
    private static final class ClearCacheTwoViewHolder extends AbsClearCacheViewHolder {
        private SimpleDraweeView imagePreviewOne;
        private TextView imagePreviewSimilarCount;
        private SimpleDraweeView imagePreviewTwo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClearCacheTwoViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.imagePreviewOne = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_one);
            this.imagePreviewTwo = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_two);
            this.imagePreviewSimilarCount = (TextView) itemView.findViewById(R.id.preview_similar_count);
        }

        public void setImage(List<ScanBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ScanBean itemItem0 = (ScanBean) CollectionsKt.getOrNull(list, 0);
            if (itemItem0 != null) {
                Companion companion = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView = this.imagePreviewOne;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imagePreviewOne");
                companion.displayImage(itemItem0, simpleDraweeView);
            }
            ScanBean itemItem1 = (ScanBean) CollectionsKt.getOrNull(list, 1);
            if (itemItem1 != null) {
                Companion companion2 = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView2 = this.imagePreviewTwo;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "imagePreviewTwo");
                companion2.displayImage(itemItem1, simpleDraweeView2);
            }
            TextView textView = this.imagePreviewSimilarCount;
            if (textView != null) {
                textView.setText(String.valueOf(list.size()));
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fH\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$ClearCacheThreeViewHolder;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$AbsClearCacheViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imagePreviewOne", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "imagePreviewSimilarCount", "Landroid/widget/TextView;", "imagePreviewThree", "imagePreviewTwo", "setImage", "", "list", "", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheAlbumPreviewAdapter.kt */
    private static final class ClearCacheThreeViewHolder extends AbsClearCacheViewHolder {
        private SimpleDraweeView imagePreviewOne;
        private TextView imagePreviewSimilarCount;
        private SimpleDraweeView imagePreviewThree;
        private SimpleDraweeView imagePreviewTwo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClearCacheThreeViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.imagePreviewOne = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_one);
            this.imagePreviewTwo = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_two);
            this.imagePreviewThree = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_three);
            this.imagePreviewSimilarCount = (TextView) itemView.findViewById(R.id.preview_similar_count);
        }

        public void setImage(List<ScanBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ScanBean itemItem0 = (ScanBean) CollectionsKt.getOrNull(list, 0);
            if (itemItem0 != null) {
                Companion companion = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView = this.imagePreviewOne;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imagePreviewOne");
                companion.displayImage(itemItem0, simpleDraweeView);
            }
            ScanBean itemItem1 = (ScanBean) CollectionsKt.getOrNull(list, 1);
            if (itemItem1 != null) {
                Companion companion2 = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView2 = this.imagePreviewTwo;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "imagePreviewTwo");
                companion2.displayImage(itemItem1, simpleDraweeView2);
            }
            ScanBean itemItem2 = (ScanBean) CollectionsKt.getOrNull(list, 2);
            if (itemItem2 != null) {
                Companion companion3 = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView3 = this.imagePreviewThree;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView3, "imagePreviewThree");
                companion3.displayImage(itemItem2, simpleDraweeView3);
            }
            TextView textView = this.imagePreviewSimilarCount;
            if (textView != null) {
                textView.setText(String.valueOf(list.size()));
            }
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010H\u0016R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u0007*\u0004\u0018\u00010\n0\nX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$ClearCacheFourViewHolder;", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$AbsClearCacheViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imagePreviewFour", "Lcom/facebook/drawee/view/SimpleDraweeView;", "kotlin.jvm.PlatformType", "imagePreviewOne", "imagePreviewSimilarCount", "Landroid/widget/TextView;", "imagePreviewThree", "imagePreviewTwo", "setImage", "", "list", "", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheAlbumPreviewAdapter.kt */
    private static final class ClearCacheFourViewHolder extends AbsClearCacheViewHolder {
        private SimpleDraweeView imagePreviewFour;
        private SimpleDraweeView imagePreviewOne;
        private TextView imagePreviewSimilarCount;
        private SimpleDraweeView imagePreviewThree;
        private SimpleDraweeView imagePreviewTwo;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClearCacheFourViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.imagePreviewOne = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_one);
            this.imagePreviewTwo = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_two);
            this.imagePreviewThree = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_three);
            this.imagePreviewFour = (SimpleDraweeView) itemView.findViewById(R.id.preview_image_four);
            this.imagePreviewSimilarCount = (TextView) itemView.findViewById(R.id.preview_similar_count);
        }

        public void setImage(List<ScanBean> list) {
            Intrinsics.checkNotNullParameter(list, "list");
            ScanBean itemItem0 = (ScanBean) CollectionsKt.getOrNull(list, 0);
            if (itemItem0 != null) {
                Companion companion = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView = this.imagePreviewOne;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView, "imagePreviewOne");
                companion.displayImage(itemItem0, simpleDraweeView);
            }
            ScanBean itemItem1 = (ScanBean) CollectionsKt.getOrNull(list, 1);
            if (itemItem1 != null) {
                Companion companion2 = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView2 = this.imagePreviewTwo;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView2, "imagePreviewTwo");
                companion2.displayImage(itemItem1, simpleDraweeView2);
            }
            ScanBean itemItem2 = (ScanBean) CollectionsKt.getOrNull(list, 2);
            if (itemItem2 != null) {
                Companion companion3 = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView3 = this.imagePreviewThree;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView3, "imagePreviewThree");
                companion3.displayImage(itemItem2, simpleDraweeView3);
            }
            ScanBean itemItem3 = (ScanBean) CollectionsKt.getOrNull(list, 3);
            if (itemItem3 != null) {
                Companion companion4 = ClearCacheAlbumPreviewAdapter.Companion;
                SimpleDraweeView simpleDraweeView4 = this.imagePreviewFour;
                Intrinsics.checkNotNullExpressionValue(simpleDraweeView4, "imagePreviewFour");
                companion4.displayImage(itemItem3, simpleDraweeView4);
            }
            TextView textView = this.imagePreviewSimilarCount;
            if (textView != null) {
                textView.setText(String.valueOf(list.size()));
            }
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bH&¨\u0006\n"}, d2 = {"Lcom/baidu/searchbox/download/center/clearcache/view/funison/views/secondpage/ClearCacheAlbumPreviewAdapter$AbsClearCacheViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "setImage", "", "list", "", "Lcom/baidu/searchbox/download/center/clearcache/view/funison/fileScan/ScanBean;", "lib-clearcache-business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ClearCacheAlbumPreviewAdapter.kt */
    public static abstract class AbsClearCacheViewHolder extends RecyclerView.ViewHolder {
        public abstract void setImage(List<ScanBean> list);

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AbsClearCacheViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
        }
    }
}
