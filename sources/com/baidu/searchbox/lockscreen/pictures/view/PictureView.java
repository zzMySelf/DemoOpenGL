package com.baidu.searchbox.lockscreen.pictures.view;

import android.content.Context;
import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import com.baidu.android.common.logging.Log;
import com.baidu.searchbox.lockscreen.base.R;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.picture.component.listener.OnViewTapListener;
import com.baidu.searchbox.picture.component.view.PhotoDraweeView;
import com.baidu.searchbox.ui.BdShimmerView;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import java.io.File;

public class PictureView extends FrameLayout {
    private static final boolean DEBUG = (LockScreenUtil.GLOBAL_DEBUG & true);
    private static final String TAG = "PictureView";
    /* access modifiers changed from: private */
    public boolean mHasBitmap;
    private String mImageUrl;
    private View mLoadingLayout;
    private BdShimmerView mProgressBar;
    private View mReloadTextView;
    /* access modifiers changed from: private */
    public PhotoDraweeView mZoomDraweeView;

    public PictureView(Context context) {
        this(context, (AttributeSet) null);
    }

    public PictureView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public PictureView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mImageUrl = null;
        this.mProgressBar = null;
        this.mReloadTextView = null;
        this.mLoadingLayout = null;
        this.mHasBitmap = false;
        init(context);
    }

    private void init(Context context) {
        View view2 = LayoutInflater.from(context).inflate(R.layout.lockscreen_pictures_item, this);
        this.mProgressBar = (BdShimmerView) view2.findViewById(com.baidu.searchbox.lockscreen.R.id.picture_load_progressbar);
        this.mReloadTextView = view2.findViewById(R.id.picture_reload_textview);
        this.mLoadingLayout = view2.findViewById(R.id.picture_loading_layout);
        PhotoDraweeView photoDraweeView = (PhotoDraweeView) view2.findViewById(R.id.zoom_imageview);
        this.mZoomDraweeView = photoDraweeView;
        photoDraweeView.setOnViewTapListener(new OnViewTapListener() {
            public void onViewTap(View view2, float x, float y) {
                if (!PictureView.this.mHasBitmap) {
                    PictureView.this.loadImageByUrl();
                } else if (View.OnClickListener.class.isInstance(PictureView.this.getContext())) {
                    ((View.OnClickListener) PictureView.this.getContext()).onClick(PictureView.this.mZoomDraweeView);
                }
            }
        });
    }

    public void setData(String url) {
        this.mImageUrl = url;
        loadImageByUrl();
    }

    public static Uri getUri(String url) {
        if (TextUtils.isEmpty(url)) {
            return null;
        }
        if (url.startsWith("http://") || url.startsWith("https://") || url.startsWith("file://")) {
            return Uri.parse(url);
        }
        if (url.startsWith("/")) {
            return Uri.fromFile(new File(url));
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void loadImageByUrl() {
        String url = this.mImageUrl;
        Uri uri = getUri(url);
        boolean invalid = uri == null;
        int i2 = 4;
        this.mProgressBar.setVisibility(invalid ? 4 : 0);
        if (invalid) {
            this.mProgressBar.stopShimmerAnimation();
        } else {
            this.mProgressBar.startShimmerAnimation();
        }
        View view2 = this.mReloadTextView;
        if (invalid) {
            i2 = 0;
        }
        view2.setVisibility(i2);
        this.mLoadingLayout.setVisibility(0);
        if (!invalid) {
            if (Fresco.getImagePipeline().isInBitmapMemoryCache(uri)) {
                Log.d(TAG, "fresco image cache exists:" + url);
            }
            PipelineDraweeControllerBuilder controllerBuilder = ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setUri(uri);
            controllerBuilder.setOldController(this.mZoomDraweeView.getController());
            controllerBuilder.setControllerListener(new BaseControllerListener<ImageInfo>() {
                public void onSubmit(String id, Object callerContext) {
                }

                public void onRelease(String id) {
                    boolean unused = PictureView.this.mHasBitmap = false;
                }

                public void onFailure(String id, Throwable throwable) {
                    super.onFailure(id, throwable);
                    PictureView.this.onLoadImageFailed();
                }

                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                    if (imageInfo != null) {
                        PictureView.this.mZoomDraweeView.update(imageInfo.getWidth(), imageInfo.getHeight());
                        PictureView.this.onLoadImageSuccess();
                    }
                }
            });
            this.mZoomDraweeView.setController(controllerBuilder.build());
        }
    }

    /* access modifiers changed from: private */
    public void onLoadImageSuccess() {
        this.mHasBitmap = true;
        this.mReloadTextView.setVisibility(4);
        this.mProgressBar.setVisibility(4);
        this.mProgressBar.stopShimmerAnimation();
        this.mLoadingLayout.setVisibility(4);
    }

    /* access modifiers changed from: private */
    public void onLoadImageFailed() {
        if (DEBUG) {
            Log.e(TAG, "onLoadImageFailed, show the error layout, url = " + this.mImageUrl);
        }
        this.mHasBitmap = false;
        this.mReloadTextView.setVisibility(0);
        this.mProgressBar.setVisibility(4);
        this.mProgressBar.stopShimmerAnimation();
        this.mLoadingLayout.setVisibility(0);
    }
}
