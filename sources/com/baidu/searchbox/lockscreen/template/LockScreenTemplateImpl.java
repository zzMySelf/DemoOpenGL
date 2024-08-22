package com.baidu.searchbox.lockscreen.template;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.baidu.android.util.devices.NetWorkUtils;
import com.baidu.searchbox.lockscreen.base.R;
import com.baidu.searchbox.lockscreen.bridge.LockScreenRuntime;
import com.baidu.searchbox.lockscreen.model.LockScreenBaseModel;
import com.baidu.searchbox.lockscreen.presenter.ILockScreenLayoutPresenter;
import com.baidu.searchbox.lockscreen.util.LockScreenUtil;
import com.baidu.searchbox.lockscreen.view.LockScreenPlaceHolderDrawable;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.image.ImageInfo;
import java.util.HashMap;
import java.util.Map;

public class LockScreenTemplateImpl<T extends LockScreenBaseModel> implements LockScreenTemplate<T> {
    private static boolean DEBUG = LockScreenRuntime.GLOBAL_DEBUG;
    private static final String TAG = "LockScreenTemplateImpl";
    protected OnChildViewClickListener mClickListener;
    protected Context mContext;
    protected T mLockScreenModel;
    protected ILockScreenLayoutPresenter mPresenter;

    public static class Holder {
        public static int TEMPLATE_FLAG_BIGIMAGE = 0;
        public static int TEMPLATE_FLAG_VIDEO = 1;
        public SimpleDraweeView mImageView;
        public int mTemplateFlag = TEMPLATE_FLAG_BIGIMAGE;
    }

    public interface OnChildViewClickListener {
        void onClick(View view2);
    }

    public LockScreenTemplateImpl(Context context) {
        this.mContext = context;
        initialize(context);
    }

    public void onClick(View v) {
        if (this.mClickListener != null) {
            v.setTag(this.mLockScreenModel);
            this.mClickListener.onClick(v);
        }
    }

    public void setViewClickable(boolean clickable) {
    }

    public View getView() {
        return null;
    }

    public void setLayoutPresenter(ILockScreenLayoutPresenter presenter) {
        this.mPresenter = presenter;
    }

    public void setOnChildViewClickListener(OnChildViewClickListener listener) {
        this.mClickListener = listener;
    }

    public T getBaseViewModel() {
        return this.mLockScreenModel;
    }

    public void update(T baseViewModel) {
        this.mLockScreenModel = baseViewModel;
    }

    public void initialize(Context context) {
        this.mContext = context;
    }

    public static void loadImage(Context context, String url, Holder view2) {
        HashMap<String, String> header = new HashMap<>();
        if (!TextUtils.isEmpty(url)) {
            Uri uri = Uri.parse(url);
            if (!TextUtils.isEmpty("Mozilla/5.0 (Linux; Android 4.4.2; Nexus 5 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36")) {
                header.put("User-Agent", "Mozilla/5.0 (Linux; Android 4.4.2; Nexus 5 Build/KOT49H) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/30.0.0.0 Mobile Safari/537.36");
            }
            PipelineDraweeControllerBuilder controllerBuilder = (PipelineDraweeControllerBuilder) ((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setOldController(view2.mImageView.getController())).setControllerListener(new BaseControllerListener<ImageInfo>() {
                public void onSubmit(String id, Object callerContext) {
                    super.onSubmit(id, callerContext);
                }

                public void onFailure(String id, Throwable throwable) {
                    super.onFailure(id, throwable);
                }

                public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
                    super.onFinalImageSet(id, imageInfo, animatable);
                }

                public void onRelease(String id) {
                    super.onRelease(id);
                }
            });
            controllerBuilder.setUri(uri, (Map<String, String>) header);
            view2.mImageView.setController(controllerBuilder.build());
        }
    }

    public static void loadImage(String curUrl, String loadUrl, Holder holder) {
        if (holder != null && !TextUtils.equals(curUrl, loadUrl)) {
            holder.mImageView.setImageURI(String.valueOf(loadUrl));
            String curUrl2 = loadUrl;
        }
    }

    public static void loadPlaceHolder(String curUrl, Holder holder) {
        loadImage(curUrl, "", holder);
    }

    public void invokeCommand(Context context, String cmd) {
        if (context != null && !TextUtils.isEmpty(cmd) && NetWorkUtils.isNetworkConnected(context)) {
            LockScreenUtil.invokeCommand(this.mContext, cmd);
        }
    }

    private static Drawable createPlaceDrawable(boolean isRoundTL, boolean isRoundTR, boolean isRoundBR, boolean isRoundBL) {
        LockScreenPlaceHolderDrawable placeHolderDrawable = new LockScreenPlaceHolderDrawable(ResourcesCompat.getDrawable(LockScreenRuntime.getAppContext().getResources(), R.drawable.lockscreen_card_img_default_icon, (Resources.Theme) null));
        float radius = LockScreenRuntime.getAppContext().getResources().getDimension(R.dimen.lockscreen_template_cardview_radius);
        placeHolderDrawable.setRadiusX(radius);
        placeHolderDrawable.setRadiusY(radius);
        placeHolderDrawable.setTopLeftRound(isRoundTL);
        placeHolderDrawable.setTopRightRound(isRoundTR);
        placeHolderDrawable.setBottomRightRound(isRoundBR);
        placeHolderDrawable.setBottomLeftRound(isRoundBL);
        return placeHolderDrawable;
    }

    public static void setPlaceHolderDrawable(Holder holder, boolean isRoundTL, boolean isRoundTR, boolean isRoundBR, boolean isRoundBL) {
        if (holder != null) {
            ((GenericDraweeHierarchy) holder.mImageView.getHierarchy()).setPlaceholderImage(createPlaceDrawable(isRoundTL, isRoundTR, isRoundBR, isRoundBL));
        }
    }
}
