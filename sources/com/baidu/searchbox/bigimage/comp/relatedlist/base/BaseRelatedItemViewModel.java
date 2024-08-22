package com.baidu.searchbox.bigimage.comp.relatedlist.base;

import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.relatedlist.base.BaseRelatedItemData;
import com.baidu.searchbox.bigimage.utils.ViewUtils;
import com.baidu.searchbox.nacomp.extension.base.BaseExtItemViewModel;
import com.baidu.searchbox.nacomp.extension.util.Size;
import com.baidu.searchbox.nacomp.extension.util.ViewExKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0016\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\rH\u0002J\u0015\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u001b\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001cR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\f¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR#\u0010\u0013\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u00140\f¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/relatedlist/base/BaseRelatedItemViewModel;", "T", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/base/BaseRelatedItemData;", "Lcom/baidu/searchbox/nacomp/extension/base/BaseExtItemViewModel;", "()V", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "getParams$lib_search_bigimage_release", "()Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "setParams$lib_search_bigimage_release", "(Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;)V", "picSize", "Landroidx/lifecycle/MutableLiveData;", "Lcom/baidu/searchbox/nacomp/extension/util/Size;", "getPicSize", "()Landroidx/lifecycle/MutableLiveData;", "placeholder", "", "getPlaceholder", "urlPair", "Lkotlin/Pair;", "", "getUrlPair", "formatPicSize", "", "size", "setModel", "model", "(Lcom/baidu/searchbox/bigimage/comp/relatedlist/base/BaseRelatedItemData;)V", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: BaseRelatedItemViewModel.kt */
public class BaseRelatedItemViewModel<T extends BaseRelatedItemData> extends BaseExtItemViewModel<T> {
    private ImagePageParams params;
    private final MutableLiveData<Size> picSize = new MutableLiveData<>();
    private final MutableLiveData<Integer> placeholder = new MutableLiveData<>();
    private final MutableLiveData<Pair<String, String>> urlPair = new MutableLiveData<>();

    public final MutableLiveData<Size> getPicSize() {
        return this.picSize;
    }

    public final MutableLiveData<Integer> getPlaceholder() {
        return this.placeholder;
    }

    public final MutableLiveData<Pair<String, String>> getUrlPair() {
        return this.urlPair;
    }

    public final ImagePageParams getParams$lib_search_bigimage_release() {
        return this.params;
    }

    public final void setParams$lib_search_bigimage_release(ImagePageParams imagePageParams) {
        this.params = imagePageParams;
    }

    public void setModel(T model) {
        Intrinsics.checkNotNullParameter(model, "model");
        super.setModel(model);
        this.params = model.getParams();
        formatPicSize(model.getPicSize());
        this.placeholder.setValue(Integer.valueOf(model.getPlaceholder()));
        this.urlPair.setValue(new Pair(model.getThumbUrl(), model.getPicUrl()));
    }

    private final void formatPicSize(Size size) {
        if (size.getWidth() > 0 && size.getHeight() > 0) {
            int realWidth = (ViewUtils.getScreenWidth(getApplication()) / 2) - ViewExKt.getDp(14.5f);
            this.picSize.setValue(new Size(realWidth, Math.min((int) (((float) realWidth) * (((float) size.getHeight()) / ((float) size.getWidth()))), 1998)));
        }
    }
}
