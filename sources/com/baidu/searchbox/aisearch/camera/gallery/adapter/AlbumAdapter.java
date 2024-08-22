package com.baidu.searchbox.aisearch.camera.gallery.adapter;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.searchbox.aisearch.camera.R;
import com.baidu.searchbox.aisearch.camera.gallery.cursorloader.entity.Album;
import com.baidu.searchbox.aisearch.camera.gallery.imageloader.FrescoImageLoader;
import com.baidu.searchbox.aisearch.camera.uitls.DisplayUtils;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.favor.data.FavorModel;
import com.facebook.drawee.generic.GenericDraweeHierarchyBuilder;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002\u0017\u0018B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00022\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0015J\u0018\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\u0005¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/AlbumAdapter;", "Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/RecyclerViewCursorAdapter;", "Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/AlbumAdapter$ViewHolder;", "listener", "Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/AlbumAdapter$OnAlbumClickListener;", "(Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/AlbumAdapter$OnAlbumClickListener;)V", "imageLoader", "Lcom/baidu/searchbox/aisearch/camera/gallery/imageloader/FrescoImageLoader;", "getImageLoader", "()Lcom/baidu/searchbox/aisearch/camera/gallery/imageloader/FrescoImageLoader;", "getListener", "()Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/AlbumAdapter$OnAlbumClickListener;", "setListener", "onBindViewHolder", "", "holder", "cursor", "Landroid/database/Cursor;", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "", "OnAlbumClickListener", "ViewHolder", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumAdapter.kt */
public final class AlbumAdapter extends RecyclerViewCursorAdapter<ViewHolder> {
    private final FrescoImageLoader imageLoader = new FrescoImageLoader();
    private OnAlbumClickListener listener;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/AlbumAdapter$OnAlbumClickListener;", "", "onAlbumClick", "", "album", "Lcom/baidu/searchbox/aisearch/camera/gallery/cursorloader/entity/Album;", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlbumAdapter.kt */
    public interface OnAlbumClickListener {
        void onAlbumClick(Album album);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public AlbumAdapter(OnAlbumClickListener listener2) {
        super((Cursor) null, 1, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(listener2, "listener");
        this.listener = listener2;
    }

    public final FrescoImageLoader getImageLoader() {
        return this.imageLoader;
    }

    public final OnAlbumClickListener getListener() {
        return this.listener;
    }

    public final void setListener(OnAlbumClickListener onAlbumClickListener) {
        this.listener = onAlbumClickListener;
    }

    /* access modifiers changed from: protected */
    public void onBindViewHolder(ViewHolder holder, Cursor cursor) {
        Intrinsics.checkNotNullParameter(holder, "holder");
        if (cursor != null) {
            Album album = Album.CREATOR.valueOf(cursor);
            TextView albumDisplayName = holder.getAlbumDisplayName();
            Context appContext = AppRuntime.getAppContext();
            Intrinsics.checkNotNullExpressionValue(appContext, "getAppContext()");
            albumDisplayName.setText(album.getDisplayName(appContext));
            holder.getAlbumPhotoNum().setText(new StringBuilder().append(album.getCount()).append(24352).toString());
            int thumbnailWidth = DisplayUtils.dip2pix(48.33f);
            int thumbnailHeight = thumbnailWidth;
            holder.getCoverImageView().getLayoutParams().width = thumbnailWidth;
            holder.getCoverImageView().getLayoutParams().height = thumbnailHeight;
            this.imageLoader.loadThumbnailUri(AppRuntime.getAppContext(), holder.getCoverImageView(), thumbnailWidth, thumbnailHeight, album.getCoverUri());
            holder.getView().setOnClickListener(new AlbumAdapter$$ExternalSyntheticLambda0(this, album));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
    public static final void m15125onBindViewHolder$lambda0(AlbumAdapter this$0, Album $album, View it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($album, "$album");
        OnAlbumClickListener onAlbumClickListener = this$0.listener;
        if (onAlbumClickListener != null) {
            onAlbumClickListener.onAlbumClick($album);
        }
    }

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.aisearch_gallery_album_item, parent, false);
        Intrinsics.checkNotNullExpressionValue(view2, "from(parent.context)\n   …lbum_item, parent, false)");
        ViewHolder viewHolder = new ViewHolder(view2);
        float round = (float) DisplayUtils.dip2pix(4.0f);
        viewHolder.getCoverImageView().setHierarchy(new GenericDraweeHierarchyBuilder(parent.getContext().getResources()).setRoundingParams(RoundingParams.fromCornersRadii(round, round, round, round)).build());
        return viewHolder;
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\bR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u000f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/aisearch/camera/gallery/adapter/AlbumAdapter$ViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "albumDisplayName", "Landroid/widget/TextView;", "getAlbumDisplayName", "()Landroid/widget/TextView;", "albumPhotoNum", "getAlbumPhotoNum", "coverImageView", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getCoverImageView", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "view", "getView", "()Landroid/view/View;", "lib-aisearch-camera_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlbumAdapter.kt */
    public static final class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView albumDisplayName;
        private final TextView albumPhotoNum;
        private final SimpleDraweeView coverImageView;

        /* renamed from: view  reason: collision with root package name */
        private final View f18609view;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View itemView) {
            super(itemView);
            Intrinsics.checkNotNullParameter(itemView, "itemView");
            this.f18609view = itemView;
            View findViewById = itemView.findViewById(R.id.gallery_album_cover);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.gallery_album_cover)");
            this.coverImageView = (SimpleDraweeView) findViewById;
            View findViewById2 = itemView.findViewById(R.id.album_name);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.album_name)");
            this.albumDisplayName = (TextView) findViewById2;
            View findViewById3 = itemView.findViewById(R.id.album_photo_num);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.album_photo_num)");
            this.albumPhotoNum = (TextView) findViewById3;
        }

        public final View getView() {
            return this.f18609view;
        }

        public final SimpleDraweeView getCoverImageView() {
            return this.coverImageView;
        }

        public final TextView getAlbumDisplayName() {
            return this.albumDisplayName;
        }

        public final TextView getAlbumPhotoNum() {
            return this.albumPhotoNum;
        }
    }
}
