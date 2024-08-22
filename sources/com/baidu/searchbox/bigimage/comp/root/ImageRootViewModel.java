package com.baidu.searchbox.bigimage.comp.root;

import android.app.Application;
import androidx.lifecycle.MutableLiveData;
import com.baidu.searchbox.bdeventbus.BdEventBus;
import com.baidu.searchbox.bigimage.comp.hao.HaoStatusChangeEvent;
import com.baidu.searchbox.bigimage.comp.root.favor.ChangeImageFavorEvent;
import com.baidu.searchbox.bigimage.comp.root.favor.ImageFavorChangedEvent;
import com.baidu.searchbox.bigimage.comp.root.repo.ImageRootRepo;
import com.baidu.searchbox.bigimage.comp.root.utils.ReadImageMarker;
import com.baidu.searchbox.bigimage.event.ImagePositionUpdate;
import com.baidu.searchbox.bigimage.model.BigImageAsset;
import com.baidu.searchbox.bigimage.utils.ImageAssetExtKt;
import com.baidu.searchbox.bigimage.utils.ImageParamsExtKt;
import com.baidu.searchbox.nacomp.mvvm.impl.BaseViewModel;
import com.baidu.searchbox.nacomp.util.UniqueId;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import rx.functions.Action1;
import rx.subscriptions.CompositeSubscription;

@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0012\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0016\u00101\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\u000f\u00104\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b5J\u0017\u00106\u001a\u0004\u0018\u00010\u00112\u0006\u00107\u001a\u00020\u0007H\u0000¢\u0006\u0002\b8J\r\u00109\u001a\u00020\u0007H\u0000¢\u0006\u0002\b:J\u000f\u0010;\u001a\u0004\u0018\u00010\u0011H\u0000¢\u0006\u0002\b<J\r\u0010=\u001a\u000202H\u0000¢\u0006\u0002\b>J\b\u0010?\u001a\u000202H\u0014J\u000e\u0010@\u001a\u0002022\u0006\u0010A\u001a\u00020\u0007J\u000e\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020DJ\u001b\u0010E\u001a\u0002022\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0000¢\u0006\u0002\bGJ\u001b\u0010H\u001a\u0002022\f\u0010F\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0000¢\u0006\u0002\bIJ\b\u0010J\u001a\u000202H\u0002J\b\u0010K\u001a\u000202H\u0002J\b\u0010L\u001a\u000202H\u0002J\u0016\u0010M\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\u0015\u0010N\u001a\u0002022\u0006\u0010O\u001a\u00020\u000eH\u0000¢\u0006\u0002\bPJ\u0016\u0010Q\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002J\r\u0010R\u001a\u000202H\u0000¢\u0006\u0002\bSJ\u0010\u0010T\u001a\u0002022\u0006\u0010C\u001a\u00020DH\u0002J\u0016\u0010U\u001a\u0002022\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00110\u001cH\u0002R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00070\u0006X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R \u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u001c0\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R(\u0010 \u001a\u0004\u0018\u00010\u001f2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001f@@X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u000e\u0010%\u001a\u00020&X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0004¢\u0006\u0002\n\u0000R\u001a\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00070\u0013X\u0004¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0015R\u001c\u0010+\u001a\u0004\u0018\u00010,X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010.\"\u0004\b/\u00100¨\u0006V"}, d2 = {"Lcom/baidu/searchbox/bigimage/comp/root/ImageRootViewModel;", "Lcom/baidu/searchbox/nacomp/mvvm/impl/BaseViewModel;", "application", "Landroid/app/Application;", "(Landroid/app/Application;)V", "changedCollect", "", "", "currImageIndex", "<set-?>", "firstRealImageIndex", "getFirstRealImageIndex$lib_search_bigimage_release", "()I", "hasNotifyPageClose", "", "imageInfos", "", "Lcom/baidu/searchbox/bigimage/model/BigImageAsset;", "initialIndex", "Landroidx/lifecycle/MutableLiveData;", "getInitialIndex$lib_search_bigimage_release", "()Landroidx/lifecycle/MutableLiveData;", "loadImageSubs", "Lrx/subscriptions/CompositeSubscription;", "loadMoreSubs", "notifyLastIndex", "getNotifyLastIndex$lib_search_bigimage_release", "pagerImageData", "", "getPagerImageData$lib_search_bigimage_release", "value", "Lcom/baidu/searchbox/bigimage/comp/root/ImageInvokeParams;", "params", "getParams$lib_search_bigimage_release", "()Lcom/baidu/searchbox/bigimage/comp/root/ImageInvokeParams;", "setParams$lib_search_bigimage_release", "(Lcom/baidu/searchbox/bigimage/comp/root/ImageInvokeParams;)V", "readMarker", "Lcom/baidu/searchbox/bigimage/comp/root/utils/ReadImageMarker;", "rootRepo", "Lcom/baidu/searchbox/bigimage/comp/root/repo/ImageRootRepo;", "selectedItem", "getSelectedItem$lib_search_bigimage_release", "token", "Lcom/baidu/searchbox/nacomp/util/UniqueId;", "getToken$lib_search_bigimage_release", "()Lcom/baidu/searchbox/nacomp/util/UniqueId;", "setToken$lib_search_bigimage_release", "(Lcom/baidu/searchbox/nacomp/util/UniqueId;)V", "appendImageData", "", "items", "firstValidImage", "firstValidImage$lib_search_bigimage_release", "getImageOrNull", "index", "getImageOrNull$lib_search_bigimage_release", "imageCount", "imageCount$lib_search_bigimage_release", "lastValidImage", "lastValidImage$lib_search_bigimage_release", "notifyPageClose", "notifyPageClose$lib_search_bigimage_release", "onCleared", "onImageSelected", "position", "onPositionUpdate", "update", "Lcom/baidu/searchbox/bigimage/event/ImagePositionUpdate;", "processBackward", "folded", "processBackward$lib_search_bigimage_release", "processForward", "processForward$lib_search_bigimage_release", "registerChangeImageFavorEvent", "registerImageFavorChanged", "registerImageHaoStatusChange", "replaceDummyData", "setBackwardDummyStatus", "isError", "setBackwardDummyStatus$lib_search_bigimage_release", "setImageData", "startLoad", "startLoad$lib_search_bigimage_release", "updateClipInfo", "updateImageSet", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageRootViewModel.kt */
public final class ImageRootViewModel extends BaseViewModel {
    /* access modifiers changed from: private */
    public final Map<Integer, Integer> changedCollect = new LinkedHashMap();
    private int currImageIndex;
    private int firstRealImageIndex;
    private boolean hasNotifyPageClose;
    /* access modifiers changed from: private */
    public final List<BigImageAsset> imageInfos = new ArrayList();
    private final MutableLiveData<Integer> initialIndex = new MutableLiveData<>();
    private final CompositeSubscription loadImageSubs = new CompositeSubscription();
    private final CompositeSubscription loadMoreSubs = new CompositeSubscription();
    private final MutableLiveData<Boolean> notifyLastIndex = new MutableLiveData<>();
    private final MutableLiveData<List<BigImageAsset>> pagerImageData = new MutableLiveData<>();
    private ImageInvokeParams params;
    private final ReadImageMarker readMarker = new ReadImageMarker();
    private final ImageRootRepo rootRepo = new ImageRootRepo();
    private final MutableLiveData<Integer> selectedItem = new MutableLiveData<>();
    private UniqueId token;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ImageRootViewModel(Application application) {
        super(application);
        Intrinsics.checkNotNullParameter(application, "application");
        registerChangeImageFavorEvent();
        registerImageFavorChanged();
        registerImageHaoStatusChange();
    }

    public final MutableLiveData<Integer> getInitialIndex$lib_search_bigimage_release() {
        return this.initialIndex;
    }

    public final MutableLiveData<List<BigImageAsset>> getPagerImageData$lib_search_bigimage_release() {
        return this.pagerImageData;
    }

    public final MutableLiveData<Integer> getSelectedItem$lib_search_bigimage_release() {
        return this.selectedItem;
    }

    public final MutableLiveData<Boolean> getNotifyLastIndex$lib_search_bigimage_release() {
        return this.notifyLastIndex;
    }

    public final int getFirstRealImageIndex$lib_search_bigimage_release() {
        return this.firstRealImageIndex;
    }

    public final ImageInvokeParams getParams$lib_search_bigimage_release() {
        return this.params;
    }

    public final void setParams$lib_search_bigimage_release(ImageInvokeParams value) {
        this.params = value;
        if (value != null) {
            this.firstRealImageIndex = value.getFirstRealImageIndex();
        }
    }

    public final UniqueId getToken$lib_search_bigimage_release() {
        return this.token;
    }

    public final void setToken$lib_search_bigimage_release(UniqueId uniqueId) {
        this.token = uniqueId;
    }

    public final void startLoad$lib_search_bigimage_release() {
        this.loadImageSubs.clear();
        ImageInvokeParams it = this.params;
        if (it != null) {
            this.loadImageSubs.add(this.rootRepo.loadInvokeParams(it).subscribe(new ImageRootViewModel$$ExternalSyntheticLambda0(this), (Action1<Throwable>) new ImageRootViewModel$$ExternalSyntheticLambda1()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLoad$lambda-2$lambda-0  reason: not valid java name */
    public static final void m16462startLoad$lambda2$lambda0(ImageRootViewModel this$0, LoadImageResult data) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (data.getType()) {
            case 1:
                this$0.setImageData(data.getItems());
                return;
            case 2:
                this$0.updateImageSet(data.getItems());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: startLoad$lambda-2$lambda-1  reason: not valid java name */
    public static final void m16463startLoad$lambda2$lambda1(Throwable it) {
    }

    private final void setImageData(List<BigImageAsset> items) {
        this.imageInfos.clear();
        this.imageInfos.addAll(items);
        int index = ImageParamsExtKt.indexOfStartImage(this.params, items);
        this.initialIndex.setValue(Integer.valueOf(index));
        this.pagerImageData.setValue(this.imageInfos);
        this.selectedItem.setValue(Integer.valueOf(index));
    }

    private final void updateImageSet(List<BigImageAsset> items) {
        Integer imgOfSetIndex;
        if (!items.isEmpty()) {
            Integer imgOfSetIndex2 = items.get(0).getImgOfSetIndex();
            int index = imgOfSetIndex2 != null ? imgOfSetIndex2.intValue() : 0;
            int index$iv = 0;
            Iterator<BigImageAsset> it = this.imageInfos.iterator();
            while (true) {
                if (!it.hasNext()) {
                    index$iv = -1;
                    break;
                }
                Integer imgOfSetIndex3 = it.next().getImgOfSetIndex();
                if (((imgOfSetIndex3 != null && imgOfSetIndex3.intValue() == index) ? 1 : null) != null) {
                    break;
                }
                index$iv++;
            }
            int start = index$iv;
            int end = (items.size() + start) - 1;
            if (start >= 0 && this.imageInfos.size() > end && (imgOfSetIndex = this.imageInfos.get(end).getImgOfSetIndex()) != null && imgOfSetIndex.intValue() == index) {
                int i2 = 0;
                for (Object item$iv : items) {
                    int index$iv2 = i2 + 1;
                    if (i2 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    BigImageAsset asset = (BigImageAsset) item$iv;
                    if (i2 + start < this.imageInfos.size() && i2 + start >= 0) {
                        ImageAssetExtKt.copyClippingInfo(this.imageInfos.get(i2 + start), asset);
                        this.imageInfos.set(i2 + start, asset);
                    }
                    i2 = index$iv2;
                }
                this.pagerImageData.setValue(this.imageInfos);
            }
        }
    }

    public final void processForward$lib_search_bigimage_release(List<BigImageAsset> folded) {
        Intrinsics.checkNotNullParameter(folded, "folded");
        CompositeSubscription compositeSubscription = this.loadMoreSubs;
        ImageRootRepo imageRootRepo = this.rootRepo;
        ImageInvokeParams imageInvokeParams = this.params;
        compositeSubscription.add(imageRootRepo.unfoldForward(folded, imageInvokeParams != null ? imageInvokeParams.getExtraParams() : null).subscribe(new ImageRootViewModel$$ExternalSyntheticLambda4(this), (Action1<Throwable>) new ImageRootViewModel$$ExternalSyntheticLambda5()));
    }

    /* access modifiers changed from: private */
    /* renamed from: processForward$lambda-5  reason: not valid java name */
    public static final void m16460processForward$lambda5(ImageRootViewModel this$0, LoadImageResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (result.getType()) {
            case 1:
                this$0.appendImageData(result.getItems());
                return;
            case 2:
                this$0.updateImageSet(result.getItems());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: processForward$lambda-6  reason: not valid java name */
    public static final void m16461processForward$lambda6(Throwable it) {
    }

    private final void appendImageData(List<BigImageAsset> items) {
        if (!items.isEmpty()) {
            BigImageAsset bigImageAsset = (BigImageAsset) CollectionsKt.lastOrNull(this.imageInfos);
            Integer index = bigImageAsset != null ? bigImageAsset.getImgOfSetIndex() : null;
            if (index != null) {
                int intValue = index.intValue() + 1;
                Integer imgOfSetIndex = ((BigImageAsset) CollectionsKt.first(items)).getImgOfSetIndex();
                if (imgOfSetIndex != null && intValue == imgOfSetIndex.intValue()) {
                    this.imageInfos.addAll(items);
                    this.pagerImageData.setValue(this.imageInfos);
                }
            }
        }
    }

    public final void processBackward$lib_search_bigimage_release(List<BigImageAsset> folded) {
        Intrinsics.checkNotNullParameter(folded, "folded");
        CompositeSubscription compositeSubscription = this.loadMoreSubs;
        ImageRootRepo imageRootRepo = this.rootRepo;
        ImageInvokeParams imageInvokeParams = this.params;
        compositeSubscription.add(imageRootRepo.unfoldBackward(folded, imageInvokeParams != null ? imageInvokeParams.getExtraParams() : null).subscribe(new ImageRootViewModel$$ExternalSyntheticLambda2(this), (Action1<Throwable>) new ImageRootViewModel$$ExternalSyntheticLambda3()));
    }

    /* access modifiers changed from: private */
    /* renamed from: processBackward$lambda-7  reason: not valid java name */
    public static final void m16458processBackward$lambda7(ImageRootViewModel this$0, LoadImageResult result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        switch (result.getType()) {
            case 1:
                this$0.replaceDummyData(result.getItems());
                return;
            case 2:
                this$0.updateImageSet(result.getItems());
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: processBackward$lambda-8  reason: not valid java name */
    public static final void m16459processBackward$lambda8(Throwable it) {
    }

    private final void replaceDummyData(List<BigImageAsset> items) {
        BigImageAsset bigImageAsset = (BigImageAsset) CollectionsKt.getOrNull(this.imageInfos, this.currImageIndex);
        boolean isCurrItemDummy = bigImageAsset != null && bigImageAsset.isFakeModel();
        int start = Math.max(0, this.firstRealImageIndex - items.size());
        int index = 0;
        for (Object item$iv : items) {
            int index$iv = index + 1;
            if (index < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            BigImageAsset asset = (BigImageAsset) item$iv;
            int updateIndex = start + index;
            if (updateIndex < this.firstRealImageIndex && updateIndex < this.imageInfos.size()) {
                this.imageInfos.set(updateIndex, asset);
            }
            index = index$iv;
        }
        this.firstRealImageIndex = start;
        this.pagerImageData.setValue(this.imageInfos);
        if (isCurrItemDummy) {
            this.notifyLastIndex.setValue(true);
        }
    }

    public final void setBackwardDummyStatus$lib_search_bigimage_release(boolean isError) {
        int i2 = this.firstRealImageIndex;
        for (int i3 = 0; i3 < i2; i3++) {
            BigImageAsset $this$setBackwardDummyStatus_u24lambda_u2d10 = (BigImageAsset) CollectionsKt.getOrNull(this.imageInfos, i3);
            if ($this$setBackwardDummyStatus_u24lambda_u2d10 != null && $this$setBackwardDummyStatus_u24lambda_u2d10.isFakeModel()) {
                $this$setBackwardDummyStatus_u24lambda_u2d10.setPlaceholderErr(isError);
            }
        }
        if (this.firstRealImageIndex > 0) {
            this.pagerImageData.setValue(this.imageInfos);
        }
    }

    private final void registerChangeImageFavorEvent() {
        BdEventBus.Companion.getDefault().register(this, ChangeImageFavorEvent.class, new ImageRootViewModel$registerChangeImageFavorEvent$1(this));
    }

    private final void registerImageFavorChanged() {
        BdEventBus.Companion.getDefault().register(this, ImageFavorChangedEvent.class, new ImageRootViewModel$registerImageFavorChanged$1(this));
    }

    private final void registerImageHaoStatusChange() {
        BdEventBus.Companion.getDefault().register(this, HaoStatusChangeEvent.class, new ImageRootViewModel$registerImageHaoStatusChange$1(this));
    }

    public final BigImageAsset firstValidImage$lib_search_bigimage_release() {
        return (BigImageAsset) CollectionsKt.getOrNull(this.imageInfos, this.firstRealImageIndex);
    }

    public final BigImageAsset lastValidImage$lib_search_bigimage_release() {
        return (BigImageAsset) CollectionsKt.lastOrNull(this.imageInfos);
    }

    public final int imageCount$lib_search_bigimage_release() {
        return this.imageInfos.size();
    }

    public final BigImageAsset getImageOrNull$lib_search_bigimage_release(int index) {
        return (BigImageAsset) CollectionsKt.getOrNull(this.imageInfos, index);
    }

    public final void onPositionUpdate(ImagePositionUpdate update) {
        Intrinsics.checkNotNullParameter(update, "update");
        updateClipInfo(update);
    }

    private final void updateClipInfo(ImagePositionUpdate update) {
        Object element$iv;
        boolean z;
        Iterator it = this.imageInfos.iterator();
        while (true) {
            if (!it.hasNext()) {
                element$iv = null;
                break;
            }
            element$iv = it.next();
            BigImageAsset it2 = (BigImageAsset) element$iv;
            Integer imgOfSetIndex = it2.getImgOfSetIndex();
            int index = update.getIndex();
            if (imgOfSetIndex != null && imgOfSetIndex.intValue() == index && Intrinsics.areEqual((Object) it2.getImageSetIndex(), (Object) update.getSetIndex())) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        BigImageAsset bigImageAsset = (BigImageAsset) element$iv;
        if (bigImageAsset != null) {
            ImageAssetExtKt.copyClipInfo(bigImageAsset, update.getClipInfo());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001a, code lost:
        r4 = r2.getImgOfSetIndex();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void notifyPageClose$lib_search_bigimage_release() {
        /*
            r7 = this;
            boolean r0 = r7.hasNotifyPageClose
            if (r0 == 0) goto L_0x0005
            return
        L_0x0005:
            com.baidu.searchbox.nacomp.util.UniqueId r0 = r7.token
            if (r0 == 0) goto L_0x0039
            r1 = 0
            int r2 = r7.currImageIndex
            com.baidu.searchbox.bigimage.model.BigImageAsset r2 = r7.getImageOrNull$lib_search_bigimage_release(r2)
            com.baidu.searchbox.bigimage.channel.IMessageChannel$Companion r3 = com.baidu.searchbox.bigimage.channel.IMessageChannel.Companion
            com.baidu.searchbox.bigimage.channel.IMessageChannel r3 = r3.of(r0)
            if (r3 == 0) goto L_0x0034
            if (r2 == 0) goto L_0x0025
            java.lang.Integer r4 = r2.getImgOfSetIndex()
            if (r4 == 0) goto L_0x0025
            int r4 = r4.intValue()
            goto L_0x0027
        L_0x0025:
            int r4 = r7.currImageIndex
        L_0x0027:
            if (r2 == 0) goto L_0x002e
            java.lang.Integer r5 = r2.getImageSetIndex()
            goto L_0x002f
        L_0x002e:
            r5 = 0
        L_0x002f:
            java.util.Map<java.lang.Integer, java.lang.Integer> r6 = r7.changedCollect
            r3.onPageClose(r4, r5, r6)
        L_0x0034:
            r3 = 1
            r7.hasNotifyPageClose = r3
        L_0x0039:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.bigimage.comp.root.ImageRootViewModel.notifyPageClose$lib_search_bigimage_release():void");
    }

    public final void onImageSelected(int position) {
        BigImageAsset $this$onImageSelected_u24lambda_u2d13;
        this.currImageIndex = position;
        ImageInvokeParams imageInvokeParams = this.params;
        boolean z = false;
        if (imageInvokeParams != null && !imageInvokeParams.isFromRelated()) {
            z = true;
        }
        if (z && ($this$onImageSelected_u24lambda_u2d13 = (BigImageAsset) CollectionsKt.getOrNull(this.imageInfos, position)) != null) {
            ReadImageMarker readImageMarker = this.readMarker;
            ImageInvokeParams imageInvokeParams2 = this.params;
            readImageMarker.markAsRead($this$onImageSelected_u24lambda_u2d13, imageInvokeParams2 != null ? imageInvokeParams2.getExtraParams() : null);
        }
    }

    /* access modifiers changed from: protected */
    public void onCleared() {
        super.onCleared();
        BdEventBus.Companion.getDefault().unregister(this);
    }
}
