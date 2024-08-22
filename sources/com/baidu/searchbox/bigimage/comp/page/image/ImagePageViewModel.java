package com.baidu.searchbox.bigimage.comp.page.image;

import android.app.Application;
import com.baidu.searchbox.bigimage.comp.page.image.rs.PageRsProvider;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.wallpaper.WallpaperSetting;
import com.baidu.searchbox.bigimage.model.SSBigImageBrowserExtraParams;
import com.baidu.searchbox.bigimage.utils.ImageParamsExtKt;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0006\u0010\u001c\u001a\u00020\u001bR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R(\u0010\t\u001a\u0004\u0018\u00010\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\b@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/page/image/ImagePageViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "extraParams", "Lcom/baidu/searchbox/bigimage/model/SSBigImageBrowserExtraParams;", "value", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "imageParams", "getImageParams", "()Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "setImageParams", "(Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;)V", "rsProvider", "Lcom/baidu/searchbox/bigimage/comp/page/image/rs/PageRsProvider;", "getRsProvider$lib_search_bigimage_release", "()Lcom/baidu/searchbox/bigimage/comp/page/image/rs/PageRsProvider;", "setRsProvider$lib_search_bigimage_release", "(Lcom/baidu/searchbox/bigimage/comp/page/image/rs/PageRsProvider;)V", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getToken$lib_search_bigimage_release", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setToken$lib_search_bigimage_release", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "isSupportWallpaperPreview", "", "shouldStartPreview", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImagePageViewModel.kt */
public final class ImagePageViewModel extends BaseViewModel {
    private SSBigImageBrowserExtraParams extraParams;
    private ImagePageParams imageParams;
    private PageRsProvider rsProvider;
    private UniqueId token;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImagePageViewModel.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ImageBrowseMode.values().length];
            iArr[ImageBrowseMode.Preview.ordinal()] = 1;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImagePageViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final PageRsProvider getRsProvider$lib_search_bigimage_release() {
        return this.rsProvider;
    }

    public final void setRsProvider$lib_search_bigimage_release(PageRsProvider pageRsProvider) {
        this.rsProvider = pageRsProvider;
    }

    public final UniqueId getToken$lib_search_bigimage_release() {
        return this.token;
    }

    public final void setToken$lib_search_bigimage_release(UniqueId uniqueId) {
        this.token = uniqueId;
    }

    public final ImagePageParams getImageParams() {
        return this.imageParams;
    }

    public final void setImageParams(ImagePageParams value) {
        this.imageParams = value;
        this.extraParams = value != null ? value.getExtraParams() : null;
    }

    public final boolean shouldStartPreview() {
        if (!isSupportWallpaperPreview()) {
            return false;
        }
        ImageBrowseMode orNull = ImageBrowseMode.Companion.getOrNull(this.token);
        switch (orNull == null ? -1 : WhenMappings.$EnumSwitchMapping$0[orNull.ordinal()]) {
            case -1:
                return WallpaperSetting.INSTANCE.getPreviewState();
            case 1:
                return true;
            default:
                return false;
        }
    }

    private final boolean isSupportWallpaperPreview() {
        return ImageParamsExtKt.supportWallpaperPreview(this.extraParams);
    }
}
