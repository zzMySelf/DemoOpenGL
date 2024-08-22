package com.baidu.searchbox.bigimage.comp.relatedlist.item.comb.item;

import android.app.Application;
import android.content.Context;
import com.baidu.searchbox.bigimage.comp.page.model.ImagePageParams;
import com.baidu.searchbox.bigimage.comp.relatedlist.footer.FooterData;
import com.baidu.searchbox.bigimage.comp.relatedlist.footer.FooterState;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.draft.DraftItemData;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.draft.DraftModule;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.textmaterial.TextMaterialItemData;
import com.baidu.searchbox.bigimage.comp.relatedlist.item.textmaterial.TextMaterialModule;
import com.baidu.searchbox.bigimage.model.DraftModelWrapper;
import com.baidu.searchbox.bigimage.model.TextMaterialModel;
import com.baidu.searchbox.bigimage.utils.BigImageTcUtilsKt;
import com.baidu.searchbox.nacomp.recycler.base.MappingRVViewModel;
import com.baidu.searchbox.nacomp.recycler.delegate.IAdapterData;
import com.baidu.searchbox.nacomp.util.UniqueId;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018J\u0016\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dJ\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0004¢\u0006\u0002\n\u0000¨\u0006!"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/relatedlist/item/comb/item/CombRVViewModel;", "Lcom/baidu/searchbox/nacomp/recycler/base/MappingRVViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "dataType", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getDataType", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setDataType", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "draftModule", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/item/draft/DraftModule;", "params", "Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "getParams", "()Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;", "setParams", "(Lcom/baidu/searchbox/bigimage/comp/page/model/ImagePageParams;)V", "textMaterialModule", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/item/textmaterial/TextMaterialModule;", "collapseItems", "", "getFooterState", "Lcom/baidu/searchbox/bigimage/comp/relatedlist/footer/FooterState;", "handleItemClicked", "context", "Landroid/content/Context;", "position", "", "setData", "data", "", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CombRVViewModel.kt */
public final class CombRVViewModel extends MappingRVViewModel {
    private UniqueId dataType;
    private final DraftModule draftModule = new DraftModule(this, false);
    private ImagePageParams params;
    private final TextMaterialModule textMaterialModule = new TextMaterialModule(this, false);

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CombRVViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
    }

    public final ImagePageParams getParams() {
        return this.params;
    }

    public final void setParams(ImagePageParams imagePageParams) {
        this.params = imagePageParams;
    }

    public final UniqueId getDataType() {
        return this.dataType;
    }

    public final void setDataType(UniqueId uniqueId) {
        this.dataType = uniqueId;
    }

    public final void setData(Object data) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data instanceof TextMaterialModel) {
            this.textMaterialModule.setData((TextMaterialModel) data);
            this.dataType = TextMaterialItemData.Companion.getTYPE();
        } else if (data instanceof DraftModelWrapper) {
            this.draftModule.setData((DraftModelWrapper) data);
            this.dataType = DraftItemData.Companion.getTYPE();
        }
    }

    public final void handleItemClicked(Context context, int position) {
        Intrinsics.checkNotNullParameter(context, "context");
        Object key = getMappingKeyAt(position);
        if (key instanceof FooterData) {
            if (Intrinsics.areEqual((Object) ((FooterData) key).getCompType(), (Object) DraftItemData.Companion.getTYPE())) {
                this.draftModule.onFooterClick(context, this.params, true);
            } else if (Intrinsics.areEqual((Object) ((FooterData) key).getCompType(), (Object) TextMaterialItemData.Companion.getTYPE())) {
                this.textMaterialModule.onFooterClick(context, this.params, true);
            }
        } else if (key instanceof DraftItemData) {
            this.draftModule.onDraftItemClick(context, ((DraftItemData) key).getData());
            BigImageTcUtilsKt.draftImageClickEvent(this.params, true);
        } else if (key instanceof TextMaterialItemData) {
            this.textMaterialModule.onItemDataClick(context, ((TextMaterialItemData) key).getData());
        }
    }

    public final FooterState getFooterState() {
        IAdapterData data = getData(getDataCount() - 1);
        FooterData footerData = data instanceof FooterData ? (FooterData) data : null;
        if (footerData != null) {
            return footerData.getState();
        }
        return null;
    }

    public final void collapseItems() {
        this.textMaterialModule.collapseItems();
        this.draftModule.collapseDrafts();
    }
}
