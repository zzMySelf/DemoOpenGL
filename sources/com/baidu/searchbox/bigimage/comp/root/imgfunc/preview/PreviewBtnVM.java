package com.baidu.searchbox.bigimage.comp.root.imgfunc.preview;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.wallpaper.navigation.NavManager;
import com.baidu.searchbox.bigimage.model.BigImageAsset;
import com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams;
import com.baidu.searchbox.bigimage.utils.BigImageTcUtilsKt;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\f\u001a\u00020\r2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u001f\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u0010H\u0001¢\u0006\u0002\b\u0012J\r\u0010\u0013\u001a\u00020\u0007H\u0001¢\u0006\u0002\b\u0014R\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/root/imgfunc/preview/PreviewBtnVM;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "isSupportPreview", "Landroidx/lifecycle/MutableLiveData;", "", "isSupportPreview$lib_search_bigimage_release", "()Landroidx/lifecycle/MutableLiveData;", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "setData", "", "statTcClickEvent", "action", "", "type", "statTcClickEvent$lib_search_bigimage_release", "supportPreview", "supportPreview$lib_search_bigimage_release", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PreviewBtnVM.kt */
public final class PreviewBtnVM extends BaseViewModel {
    private final MutableLiveData<Boolean> isSupportPreview = new MutableLiveData<>();
    private ImagePageParams params;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PreviewBtnVM(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final MutableLiveData<Boolean> isSupportPreview$lib_search_bigimage_release() {
        return this.isSupportPreview;
    }

    public final void setData(ImagePageParams params2) {
        Boolean bool;
        this.params = params2;
        MutableLiveData<Boolean> mutableLiveData = this.isSupportPreview;
        if (params2 != null) {
            bool = Boolean.valueOf(NavManager.INSTANCE.isSupportWallpaperPreview$lib_search_bigimage_release(params2));
        } else {
            bool = null;
        }
        mutableLiveData.setValue(bool);
    }

    public final boolean supportPreview$lib_search_bigimage_release() {
        Boolean value = this.isSupportPreview.getValue();
        if (value == null) {
            return false;
        }
        return value.booleanValue();
    }

    public static /* synthetic */ void statTcClickEvent$lib_search_bigimage_release$default(PreviewBtnVM previewBtnVM, String str, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = "click";
        }
        previewBtnVM.statTcClickEvent$lib_search_bigimage_release(str, str2);
    }

    public final void statTcClickEvent$lib_search_bigimage_release(String action, String type) {
        Intrinsics.checkNotNullParameter(action, "action");
        Intrinsics.checkNotNullParameter(type, "type");
        ImagePageParams imagePageParams = this.params;
        BigImageAsset bigImageAsset = null;
        SSBigImageBrowserExtraParams extraParams = imagePageParams != null ? imagePageParams.getExtraParams() : null;
        ImagePageParams imagePageParams2 = this.params;
        if (imagePageParams2 != null) {
            bigImageAsset = imagePageParams2.getImageInfo();
        }
        ImagePageParams imagePageParams3 = this.params;
        BigImageTcUtilsKt.bigImageCommonTCEvent(action, extraParams, bigImageAsset, imagePageParams3 != null ? imagePageParams3.isFromRelated() : false, type);
    }
}
