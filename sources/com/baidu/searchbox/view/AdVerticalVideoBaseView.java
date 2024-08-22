package com.baidu.searchbox.view;

import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.ad.IAdDebugExceptionRuntime;
import com.baidu.searchbox.ad.exp.adconfig.ADConfigManager;
import com.baidu.searchbox.ad.uimodule.IAdVerticalVideoView;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.ad.AdUtil;
import com.baidu.searchbox.feed.ad.model.VideoAdItemVerticalStyleModel;
import com.baidu.searchbox.feed.core.R;
import com.baidu.searchbox.player.UniversalPlayer;
import com.facebook.drawee.view.SimpleDraweeView;

public class AdVerticalVideoBaseView implements IAdVerticalVideoView {
    public static final String KEY_VERTICAL_VIDEO_SCROLL_NEW = "vertical_video_scroll_new";
    private static final String TAG = "AdVerticalVideoBaseView";
    private FrameLayout.LayoutParams mBVideoViewParams;
    private final FrameLayout mBottomLayout = new FrameLayout(FeedRuntime.getAppContext());
    protected double mCurrPlayerHeightRatio = 0.5d;
    protected View mPlayerPlaceHolder;
    protected double mPlayerTopRatio = 0.5d;
    protected final VideoAdItemVerticalStyleModel mVerticalStyleModel;
    protected final UniversalPlayer mVideoPlayer;

    public AdVerticalVideoBaseView(UniversalPlayer videoPlayer, VideoAdItemVerticalStyleModel verticalStyleModel) {
        this.mVideoPlayer = videoPlayer;
        this.mVerticalStyleModel = verticalStyleModel;
        init();
    }

    private void init() {
        View bVideoView = getVideoView();
        if (bVideoView != null && (bVideoView.getParent() instanceof ViewGroup)) {
            ViewGroup.LayoutParams params = bVideoView.getLayoutParams();
            this.mBVideoViewParams = new FrameLayout.LayoutParams(params.width, params.height);
            ViewGroup parent = (ViewGroup) bVideoView.getParent();
            updateKernalLayerParams();
            addBottomAndCoverImg(parent, Math.max(parent.indexOfChild(bVideoView), 0));
        }
    }

    public void updateKernalLayerParams() {
        final ViewGroup playerContainer = this.mVideoPlayer.getLayerContainer();
        View bVideoView = getVideoView();
        if (bVideoView != null) {
            bVideoView.post(new Runnable() {
                public void run() {
                    int height = playerContainer.getMeasuredHeight();
                    int width = playerContainer.getMeasuredWidth();
                    if ((height == 0 || width == 0) && (playerContainer.getParent() instanceof ViewGroup)) {
                        ViewGroup parent = (ViewGroup) playerContainer.getParent();
                        height = parent.getMeasuredHeight();
                        width = parent.getMeasuredWidth();
                    }
                    AdVerticalVideoBaseView.this.updateLayerParams(width, height);
                    AdVerticalVideoBaseView.this.updateVideoViewPlaceHolder(width, height);
                }
            });
        }
    }

    public void resetKernalLayerParams() {
        FrameLayout.LayoutParams layoutParams;
        AdUtil.removeChildViewFromParent(this.mBottomLayout);
        View bVideoView = getVideoView();
        if (bVideoView != null && (layoutParams = this.mBVideoViewParams) != null) {
            bVideoView.setLayoutParams(layoutParams);
        }
    }

    public View getPlayerPlaceHolder() {
        return this.mPlayerPlaceHolder;
    }

    /* access modifiers changed from: private */
    public void updateLayerParams(int containerWidth, int containerHeight) {
        if (containerWidth == 0 || containerHeight == 0) {
            resetKernalLayerParams();
            return;
        }
        View bVideoView = getVideoView();
        if (bVideoView != null) {
            ViewGroup.LayoutParams params = bVideoView.getLayoutParams();
            if (params == null) {
                params = new ViewGroup.LayoutParams(-1, -1);
            }
            updatePlayerSize(params, containerWidth, containerHeight);
            if (params instanceof FrameLayout.LayoutParams) {
                updatePlayerOrientationPosition((FrameLayout.LayoutParams) params, containerWidth);
                updatePlayerPortraitPosition((FrameLayout.LayoutParams) params, containerHeight);
            } else {
                IAdDebugExceptionRuntime.Impl.get().showExceptionDialogAndWriteLog("bVideoView layout 不是frameLayout!");
            }
            bVideoView.setLayoutParams(params);
        }
    }

    /* access modifiers changed from: protected */
    public void updatePlayerSize(ViewGroup.LayoutParams params, int containerWidth, int containerHeight) {
        double playerWidthRatio = this.mVerticalStyleModel.playerWidthRatio;
        if (playerWidthRatio <= 0.0d || playerWidthRatio > 1.0d) {
            params.width = (int) (((float) containerHeight) * 0.5625f);
            params.height = containerHeight;
        } else {
            params.width = (int) (((double) containerWidth) * playerWidthRatio);
            params.height = (int) (((float) params.width) / 0.5625f);
        }
        this.mPlayerTopRatio = (((double) containerHeight) * 0.5d) / ((double) params.height);
    }

    /* access modifiers changed from: protected */
    public void updatePlayerOrientationPosition(FrameLayout.LayoutParams params, int containerWidth) {
        double rightMarginRatio = this.mVerticalStyleModel.rightMarginRatio;
        if (rightMarginRatio >= 0.0d) {
            int playerMarginRight = (int) (((double) containerWidth) * rightMarginRatio);
            if (containerWidth - playerMarginRight <= params.width) {
                params.gravity = 8388627;
                return;
            }
            params.gravity = 8388629;
            params.rightMargin = playerMarginRight;
        } else if (this.mVerticalStyleModel.playerPosition == 0) {
            params.gravity = 8388629;
        } else if (this.mVerticalStyleModel.playerPosition == 1) {
            params.gravity = 17;
        } else if (this.mVerticalStyleModel.playerPosition == 2) {
            params.gravity = 8388627;
        }
    }

    private void updatePlayerPortraitPosition(FrameLayout.LayoutParams params, int containerHeight) {
        updatePlayerPortraitPosition(params, containerHeight, this.mVerticalStyleModel.playerHeightRatio);
    }

    /* access modifiers changed from: protected */
    public void updatePlayerPortraitPosition(FrameLayout.LayoutParams params, int containerHeight, double playerHeightRatio) {
        if (playerHeightRatio > 0.0d && playerHeightRatio < 1.0d) {
            if (playerHeightRatio > 0.5d) {
                params.bottomMargin = (params.height / 2) - Math.max((int) ((1.0d - playerHeightRatio) * ((double) params.height)), containerHeight / 2);
            } else {
                params.topMargin = Math.min((int) ((1.0d - playerHeightRatio) * ((double) params.height)), params.height - (containerHeight / 2)) - (params.height / 2);
            }
            this.mCurrPlayerHeightRatio = playerHeightRatio;
        }
    }

    /* access modifiers changed from: protected */
    public void updateVideoViewPlaceHolder(int containerWidth, int containerHeight) {
        if (this.mPlayerPlaceHolder == null) {
            if (containerWidth == 0 || containerHeight == 0) {
                this.mPlayerPlaceHolder = null;
                return;
            }
            ViewGroup attachedContainer = this.mVideoPlayer.getAttachedContainer();
            if (attachedContainer == null || !(attachedContainer.getParent() instanceof ViewGroup)) {
                this.mPlayerPlaceHolder = null;
                return;
            }
            ViewGroup parentView = (ViewGroup) attachedContainer.getParent();
            if (parentView.getResources().getConfiguration().orientation == 2) {
                this.mPlayerPlaceHolder = null;
                return;
            }
            this.mPlayerPlaceHolder = new View(FeedRuntime.getAppContext());
            if (parentView instanceof FrameLayout) {
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(-1, -1);
                updatePlayerSize(params, containerWidth, containerHeight);
                params.height = Math.min(containerHeight, params.height);
                updatePlayerOrientationPosition(params, containerWidth);
                AdUtil.removeChildViewFromParent(this.mPlayerPlaceHolder);
                parentView.addView(this.mPlayerPlaceHolder, params);
            } else if (parentView instanceof RelativeLayout) {
                RelativeLayout.LayoutParams params2 = setPlaceHolderRightMargin(containerWidth, containerHeight);
                AdUtil.removeChildViewFromParent(this.mPlayerPlaceHolder);
                parentView.addView(this.mPlayerPlaceHolder, params2);
            } else {
                this.mPlayerPlaceHolder = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    public RelativeLayout.LayoutParams setPlaceHolderRightMargin(int containerWidth, int containerHeight) {
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(-1, -1);
        updatePlayerSize(params, containerWidth, containerHeight);
        params.height = Math.min(containerHeight, params.height);
        double rightMarginRatio = this.mVerticalStyleModel.rightMarginRatio;
        if (rightMarginRatio < 0.0d) {
            switch (this.mVerticalStyleModel.playerPosition) {
                case 0:
                    params.addRule(11);
                    break;
                case 1:
                    params.addRule(13);
                    break;
                case 2:
                    params.addRule(9);
                    break;
                default:
                    params.addRule(11);
                    break;
            }
        } else {
            int playerMarginRight = (int) (((double) containerWidth) * rightMarginRatio);
            if (containerWidth - playerMarginRight <= params.width) {
                params.addRule(9);
            } else {
                params.addRule(11);
                params.rightMargin = playerMarginRight;
            }
        }
        return params;
    }

    /* access modifiers changed from: protected */
    public View getVideoView() {
        if (this.mVideoPlayer.getPlayerKernelLayer() == null || this.mVideoPlayer.getPlayerKernelLayer().getContentView() == null) {
            return null;
        }
        return this.mVideoPlayer.getPlayerKernelLayer().getContentView();
    }

    public void setBottomLayoutVisible(int visible) {
        this.mBottomLayout.setVisibility(visible);
    }

    private void addBottomAndCoverImg(ViewGroup contentView, int index) {
        this.mBottomLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        initBottomImg(this.mBottomLayout);
        initCoverBg(this.mBottomLayout);
        contentView.addView(this.mBottomLayout, index);
        this.mBottomLayout.setVisibility(8);
    }

    private void initBottomImg(FrameLayout bottomLayout) {
        SimpleDraweeView bottomImage = new SimpleDraweeView(bottomLayout.getContext());
        bottomImage.setLayoutParams(bottomLayout.getLayoutParams());
        AdUtil.removeChildViewFromParent(bottomImage);
        bottomLayout.addView(bottomImage);
        if (!TextUtils.isEmpty(this.mVerticalStyleModel.bottomPicture)) {
            bottomImage.setImageURI(this.mVerticalStyleModel.bottomPicture);
            bottomImage.setVisibility(0);
            return;
        }
        bottomImage.setVisibility(8);
    }

    private void initCoverBg(FrameLayout bottomLayout) {
        SimpleDraweeView coverBg = new SimpleDraweeView(bottomLayout.getContext());
        coverBg.setBackgroundColor(bottomLayout.getResources().getColor(R.color.tail_background_color));
        coverBg.setLayoutParams(bottomLayout.getLayoutParams());
        AdUtil.removeChildViewFromParent(coverBg);
        this.mBottomLayout.addView(coverBg);
        if (this.mVerticalStyleModel.coverShadowSwitch == 1) {
            coverBg.setVisibility(0);
        } else {
            coverBg.setVisibility(8);
        }
    }

    public void onScroll(RecyclerView recyclerView, int dx, int dy) {
        if (ADConfigManager.instance().getGlobalConfInt(KEY_VERTICAL_VIDEO_SCROLL_NEW, 0) == 1) {
            onScrollNew(recyclerView, dx, dy);
        } else {
            handleScroll(recyclerView, dx, dy);
        }
    }

    /* access modifiers changed from: protected */
    public void onScrollNew(RecyclerView recyclerView, int dx, int dy) {
        double d2 = this.mCurrPlayerHeightRatio;
        double d3 = this.mPlayerTopRatio;
        if (d2 <= d3 && dy > 0) {
            return;
        }
        if (d2 < 1.0d - d3 || dy >= 0) {
            handleScroll(recyclerView, dx, dy);
        }
    }

    private void handleScroll(RecyclerView recyclerView, int dx, int dy) {
        int height;
        if (this.mVerticalStyleModel.followHeart != null) {
            double startY = this.mVerticalStyleModel.followHeart.startY;
            double endY = this.mVerticalStyleModel.followHeart.endY;
            if (startY < 0.0d || startY > 1.0d || endY < 0.0d || endY > 1.0d) {
                RecyclerView recyclerView2 = recyclerView;
                double d2 = startY;
                double d3 = endY;
            } else if (startY <= endY) {
                RecyclerView recyclerView3 = recyclerView;
                double d4 = startY;
                double d5 = endY;
            } else {
                ViewGroup playerContainer = this.mVideoPlayer.getLayerContainer();
                View bVideoView = getVideoView();
                if (bVideoView != null && (height = playerContainer.getMeasuredHeight()) != 0) {
                    ViewGroup.LayoutParams params = bVideoView.getLayoutParams();
                    if (params instanceof FrameLayout.LayoutParams) {
                        Rect playerRect = new Rect();
                        playerContainer.getGlobalVisibleRect(playerRect);
                        int screenHeight = DeviceUtils.ScreenInfo.getDisplayHeight(FeedRuntime.getAppContext());
                        Rect recyclerRect = new Rect();
                        recyclerView.getGlobalVisibleRect(recyclerRect);
                        int topLimitY = Math.max((int) (((double) screenHeight) * endY), recyclerRect.top);
                        double d6 = endY;
                        int bottomLimitY = Math.min((int) (((double) screenHeight) * startY), recyclerRect.bottom) - height;
                        if (bottomLimitY > topLimitY) {
                            if (playerRect.top < topLimitY) {
                                int i2 = bottomLimitY;
                                int i3 = topLimitY;
                            } else if (playerRect.top > bottomLimitY) {
                                double d7 = startY;
                                int i4 = bottomLimitY;
                                int i5 = topLimitY;
                            } else {
                                double d8 = startY;
                                double scrollYRatio = ((double) (playerRect.top - topLimitY)) / ((double) (bottomLimitY - topLimitY));
                                int i6 = topLimitY;
                                int i7 = bottomLimitY;
                                double d9 = scrollYRatio;
                                updatePlayerPortraitPosition((FrameLayout.LayoutParams) params, height, ((1.0d - (((double) height) / ((double) params.height))) * scrollYRatio) + (((double) height) / ((double) (params.height * 2))));
                                bVideoView.setLayoutParams(params);
                            }
                        }
                    }
                }
            }
        }
    }
}
