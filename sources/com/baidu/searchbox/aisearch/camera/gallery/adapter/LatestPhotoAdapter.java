package com.baidu.searchbox.aisearch.camera.gallery.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.aisearch.camera.R;
import com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Item;
import com.baidu.searchbox.aisearch.camera.gallery.imageloader.FrescoImageLoader;
import com.baidu.searchbox.aisearch.camera.uitls.DisplayUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.favor.data.FavorModel;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00182\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0003\u0018\u0019\u001aB\u0019\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u001a\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0015J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u000bH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000bX\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter;", "Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/RecyclerViewCursorAdapter;", "Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter$ViewHolder;", "listener", "Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter$OnLatestPhotoSelectListener;", "cursor", "Landroid/database/Cursor;", "(Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter$OnLatestPhotoSelectListener;Landroid/database/Cursor;)V", "imageLoader", "Lcom/baidu/searchbox/aisearch/camera/gallery/imageloader/FrescoImageLoader;", "leftPadding", "", "getListener", "()Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter$OnLatestPhotoSelectListener;", "paddingBetween", "quarter", "rightPadding", "onBindViewHolder", "", "holder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "Companion", "OnLatestPhotoSelectListener", "ViewHolder", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LatestPhotoAdapter.kt */
public final class LatestPhotoAdapter extends RecyclerViewCursorAdapter<ViewHolder> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */
    public static int latestPhotoSize;
    private final FrescoImageLoader imageLoader;
    private final int leftPadding;
    private final OnLatestPhotoSelectListener listener;
    private final int paddingBetween;
    private final int quarter;
    private final int rightPadding;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J*\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000bH&¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter$OnLatestPhotoSelectListener;", "", "onLatestPhotoClick", "", "item", "Lcom/baidu/searchbox/aisearch/camera/gallery/cursorloader/entity/Item;", "view", "Landroid/view/View;", "cursor", "Landroid/database/Cursor;", "position", "", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LatestPhotoAdapter.kt */
    public interface OnLatestPhotoSelectListener {
        void onLatestPhotoClick(Item item, View view2, Cursor cursor, int i2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ LatestPhotoAdapter(OnLatestPhotoSelectListener onLatestPhotoSelectListener, Cursor cursor, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(onLatestPhotoSelectListener, (i2 & 2) != 0 ? null : cursor);
    }

    public final OnLatestPhotoSelectListener getListener() {
        return this.listener;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LatestPhotoAdapter(OnLatestPhotoSelectListener listener2, Cursor cursor) {
        super(cursor);
        Intrinsics.checkNotNullParameter(listener2, "listener");
        this.listener = listener2;
        this.imageLoader = new FrescoImageLoader();
        int dip2pix = DisplayUtils.dip2pix(6.97f);
        this.leftPadding = dip2pix;
        this.rightPadding = dip2pix;
        this.paddingBetween = DisplayUtils.dip2pix(1.32f);
        this.quarter = ((DisplayUtils.INSTANCE.getScreenWidth() - dip2pix) - dip2pix) / 4;
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter$Companion;", "", "()V", "latestPhotoSize", "", "getLatestPhotoSize", "()I", "setLatestPhotoSize", "(I)V", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LatestPhotoAdapter.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getLatestPhotoSize() {
            return LatestPhotoAdapter.latestPhotoSize;
        }

        public final void setLatestPhotoSize(int i2) {
            LatestPhotoAdapter.latestPhotoSize = i2;
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.aisearch_gallery_latest_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "from(parent.context)\n   …test_item, parent, false)");
        ViewHolder holder = new ViewHolder(view2);
        ViewGroup.LayoutParams layoutParams = holder.getImageView().getLayoutParams();
        Resources resources = null;
        RelativeLayout.LayoutParams layoutParams2 = layoutParams instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams : null;
        if (layoutParams2 != null) {
            layoutParams2.topMargin = this.paddingBetween / 2;
        }
        ViewGroup.LayoutParams layoutParams3 = holder.getImageView().getLayoutParams();
        RelativeLayout.LayoutParams layoutParams4 = layoutParams3 instanceof RelativeLayout.LayoutParams ? (RelativeLayout.LayoutParams) layoutParams3 : null;
        if (layoutParams4 != null) {
            layoutParams4.bottomMargin = this.paddingBetween / 2;
        }
        holder.getView().getLayoutParams().width = this.quarter;
        holder.getView().getLayoutParams().height = this.quarter;
        holder.getImageView().getLayoutParams().width = this.quarter - this.paddingBetween;
        holder.getImageView().getLayoutParams().height = this.quarter - this.paddingBetween;
        latestPhotoSize = this.quarter - this.paddingBetween;
        Context context = parent.getContext();
        if (context != null) {
            resources = context.getResources();
        }
        holder.getImageView().setHierarchy(new GenericDraweeHierarchyBuilder(resources).setFailureImage(R.drawable.ic_gallery_fail_photo).build());
        return holder;
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/LatestPhotoAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "view", "getView", "()Landroid/view/View;", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: LatestPhotoAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final SimpleDraweeView imageView;

        /* renamed from: view  reason: collision with root package name */
        private final View f18610view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f18610view = itemView;
            View findViewById = itemView.findViewById(R.id.gallery_latest_item);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.gallery_latest_item)");
            this.imageView = (SimpleDraweeView) findViewById;
        }

        public final View getView() {
            return this.f18610view;
        }

        public final SimpleDraweeView getImageView() {
            return this.imageView;
        }
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(ViewHolder holder, Cursor cursor) {
        Item curItem;
        Intrinsics.checkNotNullParameter(holder, "holder");
        int position = cursor != null ? cursor.getPosition() : -1;
        if (position != -1 && cursor != null && (curItem = Item.CREATOR.valueOf(cursor)) != null) {
            if (!TextUtils.isEmpty(curItem.getRealPath())) {
                FrescoImageLoader frescoImageLoader = this.imageLoader;
                Context appContext = AppRuntime.getAppContext();
                SimpleDraweeView imageView = holder.getImageView();
                int i2 = this.quarter;
                int i3 = this.paddingBetween;
                frescoImageLoader.loadThumbnailPath(appContext, imageView, i2 - i3, i2 - i3, curItem.getRealPath());
            } else {
                FrescoImageLoader frescoImageLoader2 = this.imageLoader;
                Context appContext2 = AppRuntime.getAppContext();
                SimpleDraweeView imageView2 = holder.getImageView();
                int i4 = this.quarter;
                int i5 = this.paddingBetween;
                frescoImageLoader2.loadThumbnailUri(appContext2, imageView2, i4 - i5, i4 - i5, curItem.getContentUri());
            }
            holder.getView().setOnClickListener(new LatestPhotoAdapter$$ExternalSyntheticLambda0(this, curItem, holder, cursor, position));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-1  reason: not valid java name */
    public static final void m15126onBindViewHolder$lambda1(LatestPhotoAdapter this$0, Item $curItem, ViewHolder $holder, Cursor $cursor, int $position, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($curItem, "$curItem");
        Intrinsics.checkNotNullParameter($holder, "$holder");
        this$0.listener.onLatestPhotoClick($curItem, $holder.getView(), $cursor, $position);
    }
}
