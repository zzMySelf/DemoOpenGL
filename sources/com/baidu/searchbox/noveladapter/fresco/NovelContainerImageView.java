package com.baidu.searchbox.noveladapter.fresco;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.searchbox.NoProGuard;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.drawable.ScalingUtils;
import com.facebook.drawee.generic.GenericDraweeHierarchy;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;

public class NovelContainerImageView extends SimpleDraweeView implements NoProGuard {

    public interface BScaleType extends ScalingUtils.ScaleType, NoProGuard {
        public static final int CENTER = 4;
        public static final int CENTER_CROP = 6;
        public static final int CENTER_INSIDE = 5;
        public static final int FIT_CENTER = 2;
        public static final int FIT_END = 3;
        public static final int FIT_START = 1;
        public static final int FIT_XY = 0;
        public static final int FOCUS_CROP = 7;
        public static final int NONE = -1;
        public static final ScalingUtils.ScaleType[] sScaleTypeArray = {ScalingUtils.ScaleType.FIT_XY, ScalingUtils.ScaleType.FIT_START, ScalingUtils.ScaleType.FIT_CENTER, ScalingUtils.ScaleType.FIT_END, ScalingUtils.ScaleType.CENTER, ScalingUtils.ScaleType.CENTER_INSIDE, ScalingUtils.ScaleType.CENTER_CROP, ScalingUtils.ScaleType.FOCUS_CROP};
    }

    public NovelContainerImageView(Context context, GenericDraweeHierarchy hierarchy) {
        super(context, hierarchy);
    }

    public NovelContainerImageView(Context context) {
        super(context);
    }

    public NovelContainerImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public NovelContainerImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public NovelContainerImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    public void setImageURI(Uri uri) {
        super.setImageURI(uri, (Object) null);
    }

    public void setImageURI(Uri uri, Object callerContext) {
        super.setImageURI(uri, callerContext);
    }

    public void setAspectRatio(float aspectRatio) {
        super.setAspectRatio(aspectRatio);
    }

    public void showImageWidthFlex(final String url, final int fixedHeight) {
        if (fixedHeight != 0 && !TextUtils.isEmpty(url)) {
            NovelFrescoImageUtil.getInstance().loadBitmapOnlyJust(url, new INovelImageLoadListener() {
                public void onNewResultImpl(Bitmap bitmap) {
                    ViewGroup.LayoutParams layoutParams;
                    if (bitmap != null) {
                        int originW = bitmap.getWidth();
                        int originH = bitmap.getHeight();
                        if (originW > 0 && originH > 0 && (layoutParams = NovelContainerImageView.this.getLayoutParams()) != null) {
                            layoutParams.height = fixedHeight;
                            layoutParams.width = (int) (((float) fixedHeight) * (((float) originW) / ((float) originH)));
                            NovelContainerImageView.this.setLayoutParams(layoutParams);
                            NovelContainerImageView.this.setImageURI(url);
                        }
                    }
                }

                public void onFailureImpl() {
                }

                public void onCancellation() {
                }
            });
        }
    }

    public void setImageURI(String uriString) {
        if (!TextUtils.isEmpty(uriString)) {
            try {
                super.setImageURI(uriString);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void setImageURISupportGif(String uriString) {
        if (!TextUtils.isEmpty(uriString)) {
            try {
                if (uriString.endsWith(".gif")) {
                    setController(((PipelineDraweeControllerBuilder) Fresco.newDraweeControllerBuilder().setAutoPlayAnimations(true)).setUri(Uri.parse(uriString)).build());
                    return;
                }
                super.setImageURI(uriString);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public Object getOldController() {
        return super.getController();
    }

    public void setScaleType(int scaleType) {
        ScalingUtils.ScaleType type = BScaleType.sScaleTypeArray[scaleType];
        GenericDraweeHierarchy hierarchy = (GenericDraweeHierarchy) super.getHierarchy();
        if (hierarchy != null) {
            hierarchy.setActualImageScaleType(type);
        }
    }

    public void setFailureImage(int placeholderImage, int scaleType) {
        ScalingUtils.ScaleType type = BScaleType.sScaleTypeArray[scaleType];
        GenericDraweeHierarchy hierarchy = (GenericDraweeHierarchy) super.getHierarchy();
        if (hierarchy != null) {
            hierarchy.setFailureImage(placeholderImage, type);
        }
    }

    public void setFailureImage(Drawable drawable) {
        GenericDraweeHierarchy hierarchy = (GenericDraweeHierarchy) super.getHierarchy();
        if (hierarchy != null) {
            hierarchy.setFailureImage(drawable);
        }
    }

    public void setPlaceholderImage(int placeholderImage, int scaleType) {
        ScalingUtils.ScaleType type = BScaleType.sScaleTypeArray[scaleType];
        GenericDraweeHierarchy hierarchy = (GenericDraweeHierarchy) super.getHierarchy();
        if (hierarchy != null) {
            hierarchy.setPlaceholderImage(placeholderImage, type);
        }
    }

    public void setPlaceholderImage(int placeholderImage) {
        GenericDraweeHierarchy hierarchy = (GenericDraweeHierarchy) super.getHierarchy();
        if (hierarchy != null) {
            hierarchy.setPlaceholderImage(placeholderImage);
        }
    }

    public void setPlaceholderImage(Drawable placeholderDrawable) {
        GenericDraweeHierarchy hierarchy = (GenericDraweeHierarchy) super.getHierarchy();
        if (hierarchy != null) {
            hierarchy.setPlaceholderImage(placeholderDrawable);
        }
    }

    public void setOnClickListener(View.OnClickListener listener) {
        super.setOnClickListener(listener);
    }

    public void setImageResource(int resId) {
        super.setImageResource(resId);
    }

    public void setUseGlobalColorFilter(boolean useGlobalColorFilter) {
        ((GenericDraweeHierarchy) super.getHierarchy()).setUseGlobalColorFilter(useGlobalColorFilter);
    }

    public void setActualImageResource(int resourceId, Object callerContext) {
        super.setActualImageResource(resourceId, callerContext);
    }

    public void setRoundingParms(boolean roundAsCircle, float roundedCornerRadius, boolean roundTopLeft, boolean roundTopRight, boolean roundBottomRight, boolean roundBottomLeft) {
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(roundedCornerRadius);
        roundingParams.setRoundAsCircle(roundAsCircle);
        if (!roundAsCircle) {
            float f2 = 0.0f;
            float f3 = roundTopLeft ? roundedCornerRadius : 0.0f;
            float f4 = roundTopRight ? roundedCornerRadius : 0.0f;
            float f5 = roundBottomRight ? roundedCornerRadius : 0.0f;
            if (roundBottomLeft) {
                f2 = roundedCornerRadius;
            }
            roundingParams.setCornersRadii(f3, f4, f5, f2);
        }
        ((GenericDraweeHierarchy) super.getHierarchy()).setRoundingParams(roundingParams);
    }

    public void setRoundingParams(boolean roundAsCircle, float roundedCornerRadius, boolean roundTopLeft, boolean roundTopRight, boolean roundBottomRight, boolean roundBottomLeft, int borderColor, float borderWidth) {
        RoundingParams roundingParams = RoundingParams.fromCornersRadius(roundedCornerRadius);
        roundingParams.setRoundAsCircle(roundAsCircle);
        roundingParams.setBorderColor(borderColor);
        roundingParams.setBorderWidth(borderWidth);
        if (!roundAsCircle) {
            float f2 = 0.0f;
            float f3 = roundTopLeft ? roundedCornerRadius : 0.0f;
            float f4 = roundTopRight ? roundedCornerRadius : 0.0f;
            float f5 = roundBottomRight ? roundedCornerRadius : 0.0f;
            if (roundBottomLeft) {
                f2 = roundedCornerRadius;
            }
            roundingParams.setCornersRadii(f3, f4, f5, f2);
        }
        ((GenericDraweeHierarchy) super.getHierarchy()).setRoundingParams(roundingParams);
    }

    public void setController(Object controller) {
        if (controller != null && (controller instanceof DraweeController)) {
            super.setController((DraweeController) controller);
        }
    }
}
