package com.baidu.searchbox.feed.ui.biserialassembly;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.util.devices.DeviceUtils;
import com.baidu.searchbox.feed.FeedRuntime;
import com.baidu.searchbox.feed.template.FeedTemplateUtil;
import com.baidu.searchbox.feed.ui.R;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017J\u0006\u0010\u0019\u001a\u00020\u0014R\u000e\u0010\u0007\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000eR\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/baidu/searchbox/feed/ui/biserialassembly/BiSerialAssemblySkeletonView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "SKELETON_IMG_WIDTH", "", "SKELETON_TITLE_HEIGTH", "isForceNightModel", "", "()Z", "setForceNightModel", "(Z)V", "skeletonDesc", "Landroid/view/View;", "skeletonImg", "skeletonTitle", "initView", "", "updateSize", "imgRatio", "", "descWidthRatio", "updateUi", "lib-feed-ui_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BiSerialAssemblySkeletonView.kt */
public final class BiSerialAssemblySkeletonView extends LinearLayout {
    private int SKELETON_IMG_WIDTH;
    private int SKELETON_TITLE_HEIGTH = DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 13.0f);
    private boolean isForceNightModel;
    private View skeletonDesc;
    private View skeletonImg;
    private View skeletonTitle;

    public BiSerialAssemblySkeletonView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.SKELETON_IMG_WIDTH = (FeedTemplateUtil.getCalculateWidth(context) - DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 19.0f)) / 2;
        initView();
    }

    public final boolean isForceNightModel() {
        return this.isForceNightModel;
    }

    public final void setForceNightModel(boolean z) {
        this.isForceNightModel = z;
    }

    public final void initView() {
        LayoutInflater.from(getContext()).inflate(R.layout.biserial_assembly_skeleton_layout, this);
        this.skeletonImg = findViewById(R.id.skeleton_img);
        this.skeletonTitle = findViewById(R.id.skeleton_title);
        this.skeletonDesc = findViewById(R.id.skeleton_desc);
    }

    public final void updateSize(float imgRatio, float descWidthRatio) {
        View view2 = this.skeletonImg;
        if (view2 != null) {
            int i2 = this.SKELETON_IMG_WIDTH;
            view2.setLayoutParams(new LinearLayout.LayoutParams(i2, (int) (((float) i2) / imgRatio)));
        }
        LinearLayout.LayoutParams descParams = new LinearLayout.LayoutParams((int) (((float) (this.SKELETON_IMG_WIDTH - (DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 9.0f) * 2))) * descWidthRatio), this.SKELETON_TITLE_HEIGTH);
        descParams.leftMargin = DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 9.0f);
        descParams.topMargin = DeviceUtils.ScreenInfo.dp2px(FeedRuntime.getAppContext(), 6.0f);
        View view3 = this.skeletonDesc;
        if (view3 != null) {
            view3.setLayoutParams(descParams);
        }
    }

    public final void updateUi() {
        if (this.isForceNightModel) {
            View view2 = this.skeletonImg;
            if (view2 != null) {
                view2.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.biserial_skeleton_img_bg_video_night, (Resources.Theme) null));
            }
            View view3 = this.skeletonTitle;
            if (view3 != null) {
                view3.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.biserial_skeleton_title_bg_video_night, (Resources.Theme) null));
            }
            View view4 = this.skeletonDesc;
            if (view4 != null) {
                view4.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.biserial_skeleton_title_bg_video_night, (Resources.Theme) null));
                return;
            }
            return;
        }
        View view5 = this.skeletonImg;
        if (view5 != null) {
            view5.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.biserial_skeleton_img_bg, (Resources.Theme) null));
        }
        View view6 = this.skeletonTitle;
        if (view6 != null) {
            view6.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.biserial_skeleton_title_bg, (Resources.Theme) null));
        }
        View view7 = this.skeletonDesc;
        if (view7 != null) {
            view7.setBackground(ResourcesCompat.getDrawable(FeedRuntime.getAppContext().getResources(), R.drawable.biserial_skeleton_title_bg, (Resources.Theme) null));
        }
    }
}
