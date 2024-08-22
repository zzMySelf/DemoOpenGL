package com.baidu.searchbox.inputbox.tag;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.airbnb.lottie.ImageAssetDelegate;
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieImageAsset;
import com.baidu.searchbox.config.AppConfig;
import com.baidu.searchbox.config.FontSizeHelper;
import com.baidu.searchbox.config.ext.FontSizeViewExtKt;
import com.baidu.searchbox.favor.data.FavorModel;
import com.baidu.searchbox.feed.hot.aps.HissugLottieManager;
import com.baidu.searchbox.feed.hot.aps.HissugLottieManagerKt;
import com.baidu.searchbox.hissug.data.model.HisTagDataModel;
import com.baidu.searchbox.inputbox.R;
import com.baidu.searchbox.inputbox.pms.HissugPmsUtils;
import com.baidu.searchbox.skin.NightModeHelper;
import java.io.File;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u00012\u00020\u0002B%\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u0017H\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0017H\u0016J\b\u0010 \u001a\u00020\u0017H\u0002J\u0010\u0010!\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015¨\u0006\""}, d2 = {"Lcom/baidu/searchbox/inputbox/tag/HissugLottieTag;", "Lcom/airbnb/lottie/LottieAnimationView;", "Lcom/baidu/searchbox/inputbox/tag/HissugTag;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "dataModel", "Lcom/baidu/searchbox/hissug/data/model/HisTagDataModel;", "getDataModel", "()Lcom/baidu/searchbox/hissug/data/model/HisTagDataModel;", "setDataModel", "(Lcom/baidu/searchbox/hissug/data/model/HisTagDataModel;)V", "originHeight", "", "getOriginHeight", "()F", "setOriginHeight", "(F)V", "addViewToParent", "", "parent", "Landroid/view/ViewGroup;", "lp", "Landroid/view/ViewGroup$LayoutParams;", "fontSizeChange", "getView", "Landroid/view/View;", "onNightModeChange", "playLottie", "setData", "lib-inputbox-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HissugLottieTag.kt */
public final class HissugLottieTag extends LottieAnimationView implements HissugTag {
    public Map<Integer, View> _$_findViewCache;
    private HisTagDataModel dataModel;
    private float originHeight;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HissugLottieTag(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HissugLottieTag(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
        this._$_findViewCache.clear();
    }

    public View _$_findCachedViewById(int i2) {
        Map<Integer, View> map = this._$_findViewCache;
        View view2 = map.get(Integer.valueOf(i2));
        if (view2 != null) {
            return view2;
        }
        View findViewById = findViewById(i2);
        if (findViewById == null) {
            return null;
        }
        map.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HissugLottieTag(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        Intrinsics.checkNotNullParameter(context, "context");
        this._$_findViewCache = new LinkedHashMap();
        this.originHeight = context.getResources().getDimension(R.dimen.his_lottie_img_tag_height);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HissugLottieTag(Context context, AttributeSet attributeSet, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, (i3 & 4) != 0 ? 0 : i2);
    }

    public final HisTagDataModel getDataModel() {
        return this.dataModel;
    }

    public final void setDataModel(HisTagDataModel hisTagDataModel) {
        this.dataModel = hisTagDataModel;
    }

    public final float getOriginHeight() {
        return this.originHeight;
    }

    public final void setOriginHeight(float f2) {
        this.originHeight = f2;
    }

    public void setData(HisTagDataModel dataModel2) {
        Intrinsics.checkNotNullParameter(dataModel2, "dataModel");
        if (dataModel2.isValid() && dataModel2.isLottieType()) {
            this.dataModel = dataModel2;
            playLottie();
        }
    }

    public View getView() {
        return this;
    }

    public void fontSizeChange() {
        float h2 = this.originHeight;
        double d2 = (double) h2;
        HisTagDataModel hisTagDataModel = this.dataModel;
        FontSizeViewExtKt.setScaledSize$default(this, 0, (float) (d2 * (hisTagDataModel != null ? hisTagDataModel.getWhRatio() : 1.0d)), h2, 0, 8, (Object) null);
    }

    public void onNightModeChange() {
        HisTagDataModel it = this.dataModel;
        if (it != null) {
            setData(it);
        }
    }

    public void addViewToParent(ViewGroup parent, ViewGroup.LayoutParams lp) {
        Intrinsics.checkNotNullParameter(parent, FavorModel.KEY_PARENT);
        Intrinsics.checkNotNullParameter(lp, "lp");
        if (getParent() == null) {
            if (lp.height <= 0) {
                this.originHeight = getContext().getResources().getDimension(R.dimen.his_lottie_img_tag_height);
            } else {
                this.originHeight = (float) lp.height;
            }
            float h2 = FontSizeHelper.getScaledSize(0, this.originHeight);
            double d2 = (double) h2;
            HisTagDataModel hisTagDataModel = this.dataModel;
            lp.width = (int) (d2 * (hisTagDataModel != null ? hisTagDataModel.getWhRatio() : 1.0d));
            lp.height = (int) h2;
            parent.addView(this, lp);
        }
    }

    private final void playLottie() {
        String str = null;
        if (NightModeHelper.isNightMode()) {
            HisTagDataModel hisTagDataModel = this.dataModel;
            if (hisTagDataModel != null) {
                str = hisTagDataModel.getLottieNameNight();
            }
        } else {
            HisTagDataModel hisTagDataModel2 = this.dataModel;
            if (hisTagDataModel2 != null) {
                str = hisTagDataModel2.getLottieName();
            }
        }
        String lottieName = str;
        CharSequence charSequence = lottieName;
        if (!(charSequence == null || charSequence.length() == 0) && HissugLottieManager.INSTANCE.isLottieValid(lottieName)) {
            try {
                List outputLottieFiles = HissugLottieManager.INSTANCE.getLottieFilesPath(lottieName, HissugLottieManagerKt.HIS_SUG_LOTTIE_ZIP_FILE_NAME);
                String lottieJSONStr = HissugPmsUtils.INSTANCE.getJSONStrFromJSONFile(outputLottieFiles.get(0));
                if (!TextUtils.isEmpty(lottieJSONStr)) {
                    Ref.ObjectRef imageAssetDelegate = new Ref.ObjectRef();
                    if (outputLottieFiles.size() == 2) {
                        setImageAssetsFolder(outputLottieFiles.get(1));
                        imageAssetDelegate.element = new HissugLottieTag$$ExternalSyntheticLambda0(outputLottieFiles);
                    }
                    post(new HissugLottieTag$$ExternalSyntheticLambda1(this, lottieJSONStr, imageAssetDelegate));
                    addAnimatorListener(new HissugLottieTag$playLottie$3(this));
                }
            } catch (Exception ex) {
                if (AppConfig.isDebug()) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: playLottie$lambda-1  reason: not valid java name */
    public static final Bitmap m20406playLottie$lambda1(List $outputLottieFiles, LottieImageAsset it) {
        Intrinsics.checkNotNullParameter($outputLottieFiles, "$outputLottieFiles");
        return BitmapFactory.decodeFile(((String) $outputLottieFiles.get(1)) + File.separator + it.getFileName());
    }

    /* access modifiers changed from: private */
    /* renamed from: playLottie$lambda-2  reason: not valid java name */
    public static final void m20407playLottie$lambda2(HissugLottieTag this$0, String $lottieJSONStr, Ref.ObjectRef $imageAssetDelegate) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($lottieJSONStr, "$lottieJSONStr");
        Intrinsics.checkNotNullParameter($imageAssetDelegate, "$imageAssetDelegate");
        this$0.setScaleType(ImageView.ScaleType.FIT_CENTER);
        this$0.setVisibility(0);
        this$0.setAnimationFromJson($lottieJSONStr, HissugLottieManagerKt.HIS_SUG_LOTTIE_ZIP_FILE_NAME);
        this$0.setImageAssetDelegate((ImageAssetDelegate) $imageAssetDelegate.element);
        this$0.playAnimation();
        this$0.setRepeatCount(-1);
    }
}
