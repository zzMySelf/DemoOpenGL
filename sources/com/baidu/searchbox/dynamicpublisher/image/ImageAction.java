package com.baidu.searchbox.dynamicpublisher.image;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.ugc.model.ImageStruct;
import com.baidu.searchbox.ugc.model.TiaoZhanInfo;
import com.baidu.searchbox.ugc.utils.SelectUtil;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0011\u0003\u0004\u0005\u0006\u0007\b\t\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0011\u0014\u0015\u0016\u0017\u0018\u0019\u001a\u001b\u001c\u001d\u001e\u001f !\"#$¨\u0006%"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "AiCreativeImageProgressUpdate", "AiCreativeImageResultState", "AiTxtGenImgRecPlaceViewCanShow", "AiTxtGenImgRecPlaceViewRefresh", "ClickImageDownload", "CollectData", "DelImageByIndex", "DelImageByIndexCompleted", "DispatchDownloadState", "Init", "NumberChanged", "PickImage", "RestoreData", "SendData", "SourceData", "UpdateImage", "UpdateVisibility", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$PickImage;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$UpdateImage;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$DelImageByIndex;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$NumberChanged;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$UpdateVisibility;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$CollectData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$SendData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$RestoreData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$SourceData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$Init;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$ClickImageDownload;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$DispatchDownloadState;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiCreativeImageResultState;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiCreativeImageProgressUpdate;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$DelImageByIndexCompleted;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiTxtGenImgRecPlaceViewCanShow;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiTxtGenImgRecPlaceViewRefresh;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ImageAction.kt */
public abstract class ImageAction implements Action {
    public /* synthetic */ ImageAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private ImageAction() {
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$PickImage;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "maxImageSize", "", "(I)V", "getMaxImageSize", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class PickImage extends ImageAction {
        private final int maxImageSize;

        public PickImage() {
            this(0, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ PickImage copy$default(PickImage pickImage, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = pickImage.maxImageSize;
            }
            return pickImage.copy(i2);
        }

        public final int component1() {
            return this.maxImageSize;
        }

        public final PickImage copy(int i2) {
            return new PickImage(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof PickImage) && this.maxImageSize == ((PickImage) obj).maxImageSize;
        }

        public int hashCode() {
            return Integer.hashCode(this.maxImageSize);
        }

        public String toString() {
            return "PickImage(maxImageSize=" + this.maxImageSize + ')';
        }

        public PickImage(int maxImageSize2) {
            super((DefaultConstructorMarker) null);
            this.maxImageSize = maxImageSize2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ PickImage(int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? SelectUtil.MAX_SELECTED_DEFAULT : i2);
        }

        public final int getMaxImageSize() {
            return this.maxImageSize;
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\u0002\u0010\bJ\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0003J1\u0010\u000f\u001a\u00020\u00002\b\b\u0003\u0010\u0002\u001a\u00020\u00032\u001c\b\u0002\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R%\u0010\u0004\u001a\u0016\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005j\n\u0012\u0004\u0012\u00020\u0006\u0018\u0001`\u0007¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0017"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$UpdateImage;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "type", "", "images", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "Lkotlin/collections/ArrayList;", "(ILjava/util/ArrayList;)V", "getImages", "()Ljava/util/ArrayList;", "getType", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class UpdateImage extends ImageAction {
        private final ArrayList<ImageStruct> images;
        private final int type;

        public static /* synthetic */ UpdateImage copy$default(UpdateImage updateImage, int i2, ArrayList<ImageStruct> arrayList, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = updateImage.type;
            }
            if ((i3 & 2) != 0) {
                arrayList = updateImage.images;
            }
            return updateImage.copy(i2, arrayList);
        }

        public final int component1() {
            return this.type;
        }

        public final ArrayList<ImageStruct> component2() {
            return this.images;
        }

        public final UpdateImage copy(@UpdateType int i2, ArrayList<ImageStruct> arrayList) {
            return new UpdateImage(i2, arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof UpdateImage)) {
                return false;
            }
            UpdateImage updateImage = (UpdateImage) obj;
            return this.type == updateImage.type && Intrinsics.areEqual((Object) this.images, (Object) updateImage.images);
        }

        public int hashCode() {
            int hashCode = Integer.hashCode(this.type) * 31;
            ArrayList<ImageStruct> arrayList = this.images;
            return hashCode + (arrayList == null ? 0 : arrayList.hashCode());
        }

        public String toString() {
            return "UpdateImage(type=" + this.type + ", images=" + this.images + ')';
        }

        public UpdateImage(@UpdateType int type2, ArrayList<ImageStruct> images2) {
            super((DefaultConstructorMarker) null);
            this.type = type2;
            this.images = images2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UpdateImage(int i2, ArrayList arrayList, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this(i2, (i3 & 2) != 0 ? null : arrayList);
        }

        public final ArrayList<ImageStruct> getImages() {
            return this.images;
        }

        public final int getType() {
            return this.type;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$DelImageByIndex;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "images", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "index", "", "(Lcom/baidu/searchbox/ugc/model/ImageStruct;I)V", "getImages", "()Lcom/baidu/searchbox/ugc/model/ImageStruct;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class DelImageByIndex extends ImageAction {
        private final ImageStruct images;
        private final int index;

        public static /* synthetic */ DelImageByIndex copy$default(DelImageByIndex delImageByIndex, ImageStruct imageStruct, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                imageStruct = delImageByIndex.images;
            }
            if ((i3 & 2) != 0) {
                i2 = delImageByIndex.index;
            }
            return delImageByIndex.copy(imageStruct, i2);
        }

        public final ImageStruct component1() {
            return this.images;
        }

        public final int component2() {
            return this.index;
        }

        public final DelImageByIndex copy(ImageStruct imageStruct, int i2) {
            return new DelImageByIndex(imageStruct, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DelImageByIndex)) {
                return false;
            }
            DelImageByIndex delImageByIndex = (DelImageByIndex) obj;
            return Intrinsics.areEqual((Object) this.images, (Object) delImageByIndex.images) && this.index == delImageByIndex.index;
        }

        public int hashCode() {
            ImageStruct imageStruct = this.images;
            return ((imageStruct == null ? 0 : imageStruct.hashCode()) * 31) + Integer.hashCode(this.index);
        }

        public String toString() {
            return "DelImageByIndex(images=" + this.images + ", index=" + this.index + ')';
        }

        public DelImageByIndex(ImageStruct images2, int index2) {
            super((DefaultConstructorMarker) null);
            this.images = images2;
            this.index = index2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DelImageByIndex(ImageStruct imageStruct, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : imageStruct, i2);
        }

        public final ImageStruct getImages() {
            return this.images;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$NumberChanged;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "number", "", "(I)V", "getNumber", "()I", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class NumberChanged extends ImageAction {
        private final int number;

        public static /* synthetic */ NumberChanged copy$default(NumberChanged numberChanged, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = numberChanged.number;
            }
            return numberChanged.copy(i2);
        }

        public final int component1() {
            return this.number;
        }

        public final NumberChanged copy(int i2) {
            return new NumberChanged(i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof NumberChanged) && this.number == ((NumberChanged) obj).number;
        }

        public int hashCode() {
            return Integer.hashCode(this.number);
        }

        public String toString() {
            return "NumberChanged(number=" + this.number + ')';
        }

        public NumberChanged(int number2) {
            super((DefaultConstructorMarker) null);
            this.number = number2;
        }

        public final int getNumber() {
            return this.number;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$UpdateVisibility;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "visible", "", "(Z)V", "getVisible", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class UpdateVisibility extends ImageAction {
        private final boolean visible;

        public UpdateVisibility() {
            this(false, 1, (DefaultConstructorMarker) null);
        }

        public static /* synthetic */ UpdateVisibility copy$default(UpdateVisibility updateVisibility, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = updateVisibility.visible;
            }
            return updateVisibility.copy(z);
        }

        public final boolean component1() {
            return this.visible;
        }

        public final UpdateVisibility copy(boolean z) {
            return new UpdateVisibility(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateVisibility) && this.visible == ((UpdateVisibility) obj).visible;
        }

        public int hashCode() {
            boolean z = this.visible;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "UpdateVisibility(visible=" + this.visible + ')';
        }

        public UpdateVisibility(boolean visible2) {
            super((DefaultConstructorMarker) null);
            this.visible = visible2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ UpdateVisibility(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this((i2 & 1) != 0 ? true : z);
        }

        public final boolean getVisible() {
            return this.visible;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$CollectData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "()V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class CollectData extends ImageAction {
        public static final CollectData INSTANCE = new CollectData();

        private CollectData() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$SendData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "images", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "Lkotlin/collections/ArrayList;", "tiaozhanInfo", "Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "(Ljava/util/ArrayList;Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;)V", "getImages", "()Ljava/util/ArrayList;", "getTiaozhanInfo", "()Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class SendData extends ImageAction {
        private final ArrayList<ImageStruct> images;
        private final TiaoZhanInfo tiaozhanInfo;

        public static /* synthetic */ SendData copy$default(SendData sendData, ArrayList<ImageStruct> arrayList, TiaoZhanInfo tiaoZhanInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                arrayList = sendData.images;
            }
            if ((i2 & 2) != 0) {
                tiaoZhanInfo = sendData.tiaozhanInfo;
            }
            return sendData.copy(arrayList, tiaoZhanInfo);
        }

        public final ArrayList<ImageStruct> component1() {
            return this.images;
        }

        public final TiaoZhanInfo component2() {
            return this.tiaozhanInfo;
        }

        public final SendData copy(ArrayList<ImageStruct> arrayList, TiaoZhanInfo tiaoZhanInfo) {
            return new SendData(arrayList, tiaoZhanInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof SendData)) {
                return false;
            }
            SendData sendData = (SendData) obj;
            return Intrinsics.areEqual((Object) this.images, (Object) sendData.images) && Intrinsics.areEqual((Object) this.tiaozhanInfo, (Object) sendData.tiaozhanInfo);
        }

        public int hashCode() {
            ArrayList<ImageStruct> arrayList = this.images;
            int i2 = 0;
            int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
            TiaoZhanInfo tiaoZhanInfo = this.tiaozhanInfo;
            if (tiaoZhanInfo != null) {
                i2 = tiaoZhanInfo.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "SendData(images=" + this.images + ", tiaozhanInfo=" + this.tiaozhanInfo + ')';
        }

        public SendData(ArrayList<ImageStruct> images2, TiaoZhanInfo tiaozhanInfo2) {
            super((DefaultConstructorMarker) null);
            this.images = images2;
            this.tiaozhanInfo = tiaozhanInfo2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ SendData(ArrayList arrayList, TiaoZhanInfo tiaoZhanInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(arrayList, (i2 & 2) != 0 ? null : tiaoZhanInfo);
        }

        public final ArrayList<ImageStruct> getImages() {
            return this.images;
        }

        public final TiaoZhanInfo getTiaozhanInfo() {
            return this.tiaozhanInfo;
        }
    }

    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B-\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u001d\u0010\r\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0007HÆ\u0003J3\u0010\u000f\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001R%\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\f¨\u0006\u0018"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$RestoreData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "images", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "Lkotlin/collections/ArrayList;", "tiaozhanInfo", "Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "(Ljava/util/ArrayList;Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;)V", "getImages", "()Ljava/util/ArrayList;", "getTiaozhanInfo", "()Lcom/baidu/searchbox/ugc/model/TiaoZhanInfo;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class RestoreData extends ImageAction {
        private final ArrayList<ImageStruct> images;
        private final TiaoZhanInfo tiaozhanInfo;

        public static /* synthetic */ RestoreData copy$default(RestoreData restoreData, ArrayList<ImageStruct> arrayList, TiaoZhanInfo tiaoZhanInfo, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                arrayList = restoreData.images;
            }
            if ((i2 & 2) != 0) {
                tiaoZhanInfo = restoreData.tiaozhanInfo;
            }
            return restoreData.copy(arrayList, tiaoZhanInfo);
        }

        public final ArrayList<ImageStruct> component1() {
            return this.images;
        }

        public final TiaoZhanInfo component2() {
            return this.tiaozhanInfo;
        }

        public final RestoreData copy(ArrayList<ImageStruct> arrayList, TiaoZhanInfo tiaoZhanInfo) {
            return new RestoreData(arrayList, tiaoZhanInfo);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof RestoreData)) {
                return false;
            }
            RestoreData restoreData = (RestoreData) obj;
            return Intrinsics.areEqual((Object) this.images, (Object) restoreData.images) && Intrinsics.areEqual((Object) this.tiaozhanInfo, (Object) restoreData.tiaozhanInfo);
        }

        public int hashCode() {
            ArrayList<ImageStruct> arrayList = this.images;
            int i2 = 0;
            int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
            TiaoZhanInfo tiaoZhanInfo = this.tiaozhanInfo;
            if (tiaoZhanInfo != null) {
                i2 = tiaoZhanInfo.hashCode();
            }
            return hashCode + i2;
        }

        public String toString() {
            return "RestoreData(images=" + this.images + ", tiaozhanInfo=" + this.tiaozhanInfo + ')';
        }

        public RestoreData(ArrayList<ImageStruct> images2, TiaoZhanInfo tiaozhanInfo2) {
            super((DefaultConstructorMarker) null);
            this.images = images2;
            this.tiaozhanInfo = tiaozhanInfo2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ RestoreData(ArrayList arrayList, TiaoZhanInfo tiaoZhanInfo, int i2, DefaultConstructorMarker defaultConstructorMarker) {
            this(arrayList, (i2 & 2) != 0 ? null : tiaoZhanInfo);
        }

        public final ArrayList<ImageStruct> getImages() {
            return this.images;
        }

        public final TiaoZhanInfo getTiaozhanInfo() {
            return this.tiaozhanInfo;
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u000b\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0015\u0010\b\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$SourceData;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class SourceData extends ImageAction {
        private final String source;

        public static /* synthetic */ SourceData copy$default(SourceData sourceData, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                str = sourceData.source;
            }
            return sourceData.copy(str);
        }

        public final String component1() {
            return this.source;
        }

        public final SourceData copy(String str) {
            return new SourceData(str);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof SourceData) && Intrinsics.areEqual((Object) this.source, (Object) ((SourceData) obj).source);
        }

        public int hashCode() {
            String str = this.source;
            if (str == null) {
                return 0;
            }
            return str.hashCode();
        }

        public String toString() {
            return "SourceData(source=" + this.source + ')';
        }

        public SourceData(String source2) {
            super((DefaultConstructorMarker) null);
            this.source = source2;
        }

        public final String getSource() {
            return this.source;
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$Init;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "()V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class Init extends ImageAction {
        public static final Init INSTANCE = new Init();

        private Init() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$ClickImageDownload;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "imageStruct", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "(Lcom/baidu/searchbox/ugc/model/ImageStruct;)V", "getImageStruct", "()Lcom/baidu/searchbox/ugc/model/ImageStruct;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class ClickImageDownload extends ImageAction {
        private final ImageStruct imageStruct;

        public static /* synthetic */ ClickImageDownload copy$default(ClickImageDownload clickImageDownload, ImageStruct imageStruct2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                imageStruct2 = clickImageDownload.imageStruct;
            }
            return clickImageDownload.copy(imageStruct2);
        }

        public final ImageStruct component1() {
            return this.imageStruct;
        }

        public final ClickImageDownload copy(ImageStruct imageStruct2) {
            Intrinsics.checkNotNullParameter(imageStruct2, "imageStruct");
            return new ClickImageDownload(imageStruct2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof ClickImageDownload) && Intrinsics.areEqual((Object) this.imageStruct, (Object) ((ClickImageDownload) obj).imageStruct);
        }

        public int hashCode() {
            return this.imageStruct.hashCode();
        }

        public String toString() {
            return "ClickImageDownload(imageStruct=" + this.imageStruct + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ClickImageDownload(ImageStruct imageStruct2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(imageStruct2, "imageStruct");
            this.imageStruct = imageStruct2;
        }

        public final ImageStruct getImageStruct() {
            return this.imageStruct;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\"\u0012\u001b\u0010\u0002\u001a\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u0006\u0018\u00010\u0003¢\u0006\u0002\u0010\u0007J\u001e\u0010\n\u001a\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u0006\u0018\u00010\u0003HÆ\u0003J(\u0010\u000b\u001a\u00020\u00002\u001d\b\u0002\u0010\u0002\u001a\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u0006\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R&\u0010\u0002\u001a\u0017\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\t\u0012\u00070\u0005¢\u0006\u0002\b\u0006\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$DispatchDownloadState;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "data", "Lkotlin/Pair;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "", "Lcom/baidu/searchbox/dynamicpublisher/image_download/ImageDownloadStatus;", "(Lkotlin/Pair;)V", "getData", "()Lkotlin/Pair;", "component1", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class DispatchDownloadState extends ImageAction {
        private final Pair<ImageStruct, Integer> data;

        public static /* synthetic */ DispatchDownloadState copy$default(DispatchDownloadState dispatchDownloadState, Pair<ImageStruct, Integer> pair, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                pair = dispatchDownloadState.data;
            }
            return dispatchDownloadState.copy(pair);
        }

        public final Pair<ImageStruct, Integer> component1() {
            return this.data;
        }

        public final DispatchDownloadState copy(Pair<? extends ImageStruct, Integer> pair) {
            return new DispatchDownloadState(pair);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof DispatchDownloadState) && Intrinsics.areEqual((Object) this.data, (Object) ((DispatchDownloadState) obj).data);
        }

        public int hashCode() {
            Pair<ImageStruct, Integer> pair = this.data;
            if (pair == null) {
                return 0;
            }
            return pair.hashCode();
        }

        public String toString() {
            return "DispatchDownloadState(data=" + this.data + ')';
        }

        public DispatchDownloadState(Pair<? extends ImageStruct, Integer> data2) {
            super((DefaultConstructorMarker) null);
            this.data = data2;
        }

        public final Pair<ImageStruct, Integer> getData() {
            return this.data;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiCreativeImageResultState;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "state", "", "imageStruct", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "(ILcom/baidu/searchbox/ugc/model/ImageStruct;)V", "getImageStruct", "()Lcom/baidu/searchbox/ugc/model/ImageStruct;", "getState", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class AiCreativeImageResultState extends ImageAction {
        private final ImageStruct imageStruct;
        private final int state;

        public static /* synthetic */ AiCreativeImageResultState copy$default(AiCreativeImageResultState aiCreativeImageResultState, int i2, ImageStruct imageStruct2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = aiCreativeImageResultState.state;
            }
            if ((i3 & 2) != 0) {
                imageStruct2 = aiCreativeImageResultState.imageStruct;
            }
            return aiCreativeImageResultState.copy(i2, imageStruct2);
        }

        public final int component1() {
            return this.state;
        }

        public final ImageStruct component2() {
            return this.imageStruct;
        }

        public final AiCreativeImageResultState copy(int i2, ImageStruct imageStruct2) {
            Intrinsics.checkNotNullParameter(imageStruct2, "imageStruct");
            return new AiCreativeImageResultState(i2, imageStruct2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof AiCreativeImageResultState)) {
                return false;
            }
            AiCreativeImageResultState aiCreativeImageResultState = (AiCreativeImageResultState) obj;
            return this.state == aiCreativeImageResultState.state && Intrinsics.areEqual((Object) this.imageStruct, (Object) aiCreativeImageResultState.imageStruct);
        }

        public int hashCode() {
            return (Integer.hashCode(this.state) * 31) + this.imageStruct.hashCode();
        }

        public String toString() {
            return "AiCreativeImageResultState(state=" + this.state + ", imageStruct=" + this.imageStruct + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AiCreativeImageResultState(int state2, ImageStruct imageStruct2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(imageStruct2, "imageStruct");
            this.state = state2;
            this.imageStruct = imageStruct2;
        }

        public final ImageStruct getImageStruct() {
            return this.imageStruct;
        }

        public final int getState() {
            return this.state;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiCreativeImageProgressUpdate;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "imageStruct", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "(Lcom/baidu/searchbox/ugc/model/ImageStruct;)V", "getImageStruct", "()Lcom/baidu/searchbox/ugc/model/ImageStruct;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class AiCreativeImageProgressUpdate extends ImageAction {
        private final ImageStruct imageStruct;

        public static /* synthetic */ AiCreativeImageProgressUpdate copy$default(AiCreativeImageProgressUpdate aiCreativeImageProgressUpdate, ImageStruct imageStruct2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                imageStruct2 = aiCreativeImageProgressUpdate.imageStruct;
            }
            return aiCreativeImageProgressUpdate.copy(imageStruct2);
        }

        public final ImageStruct component1() {
            return this.imageStruct;
        }

        public final AiCreativeImageProgressUpdate copy(ImageStruct imageStruct2) {
            Intrinsics.checkNotNullParameter(imageStruct2, "imageStruct");
            return new AiCreativeImageProgressUpdate(imageStruct2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AiCreativeImageProgressUpdate) && Intrinsics.areEqual((Object) this.imageStruct, (Object) ((AiCreativeImageProgressUpdate) obj).imageStruct);
        }

        public int hashCode() {
            return this.imageStruct.hashCode();
        }

        public String toString() {
            return "AiCreativeImageProgressUpdate(imageStruct=" + this.imageStruct + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AiCreativeImageProgressUpdate(ImageStruct imageStruct2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(imageStruct2, "imageStruct");
            this.imageStruct = imageStruct2;
        }

        public final ImageStruct getImageStruct() {
            return this.imageStruct;
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0019\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001f\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$DelImageByIndexCompleted;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "images", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "index", "", "(Lcom/baidu/searchbox/ugc/model/ImageStruct;I)V", "getImages", "()Lcom/baidu/searchbox/ugc/model/ImageStruct;", "getIndex", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class DelImageByIndexCompleted extends ImageAction {
        private final ImageStruct images;
        private final int index;

        public static /* synthetic */ DelImageByIndexCompleted copy$default(DelImageByIndexCompleted delImageByIndexCompleted, ImageStruct imageStruct, int i2, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                imageStruct = delImageByIndexCompleted.images;
            }
            if ((i3 & 2) != 0) {
                i2 = delImageByIndexCompleted.index;
            }
            return delImageByIndexCompleted.copy(imageStruct, i2);
        }

        public final ImageStruct component1() {
            return this.images;
        }

        public final int component2() {
            return this.index;
        }

        public final DelImageByIndexCompleted copy(ImageStruct imageStruct, int i2) {
            return new DelImageByIndexCompleted(imageStruct, i2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof DelImageByIndexCompleted)) {
                return false;
            }
            DelImageByIndexCompleted delImageByIndexCompleted = (DelImageByIndexCompleted) obj;
            return Intrinsics.areEqual((Object) this.images, (Object) delImageByIndexCompleted.images) && this.index == delImageByIndexCompleted.index;
        }

        public int hashCode() {
            ImageStruct imageStruct = this.images;
            return ((imageStruct == null ? 0 : imageStruct.hashCode()) * 31) + Integer.hashCode(this.index);
        }

        public String toString() {
            return "DelImageByIndexCompleted(images=" + this.images + ", index=" + this.index + ')';
        }

        public DelImageByIndexCompleted(ImageStruct images2, int index2) {
            super((DefaultConstructorMarker) null);
            this.images = images2;
            this.index = index2;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ DelImageByIndexCompleted(ImageStruct imageStruct, int i2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
            this((i3 & 1) != 0 ? null : imageStruct, i2);
        }

        public final ImageStruct getImages() {
            return this.images;
        }

        public final int getIndex() {
            return this.index;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\u00032\b\u0010\n\u001a\u0004\u0018\u00010\u000bHÖ\u0003J\t\u0010\f\u001a\u00020\rHÖ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiTxtGenImgRecPlaceViewCanShow;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "show", "", "(Z)V", "getShow", "()Z", "component1", "copy", "equals", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class AiTxtGenImgRecPlaceViewCanShow extends ImageAction {
        private final boolean show;

        public static /* synthetic */ AiTxtGenImgRecPlaceViewCanShow copy$default(AiTxtGenImgRecPlaceViewCanShow aiTxtGenImgRecPlaceViewCanShow, boolean z, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                z = aiTxtGenImgRecPlaceViewCanShow.show;
            }
            return aiTxtGenImgRecPlaceViewCanShow.copy(z);
        }

        public final boolean component1() {
            return this.show;
        }

        public final AiTxtGenImgRecPlaceViewCanShow copy(boolean z) {
            return new AiTxtGenImgRecPlaceViewCanShow(z);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AiTxtGenImgRecPlaceViewCanShow) && this.show == ((AiTxtGenImgRecPlaceViewCanShow) obj).show;
        }

        public int hashCode() {
            boolean z = this.show;
            if (z) {
                return 1;
            }
            return z ? 1 : 0;
        }

        public String toString() {
            return "AiTxtGenImgRecPlaceViewCanShow(show=" + this.show + ')';
        }

        public AiTxtGenImgRecPlaceViewCanShow(boolean show2) {
            super((DefaultConstructorMarker) null);
            this.show = show2;
        }

        public final boolean getShow() {
            return this.show;
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction$AiTxtGenImgRecPlaceViewRefresh;", "Lcom/baidu/searchbox/dynamicpublisher/image/ImageAction;", "img", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "(Lcom/baidu/searchbox/ugc/model/ImageStruct;)V", "getImg", "()Lcom/baidu/searchbox/ugc/model/ImageStruct;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: ImageAction.kt */
    public static final class AiTxtGenImgRecPlaceViewRefresh extends ImageAction {
        private final ImageStruct img;

        public static /* synthetic */ AiTxtGenImgRecPlaceViewRefresh copy$default(AiTxtGenImgRecPlaceViewRefresh aiTxtGenImgRecPlaceViewRefresh, ImageStruct imageStruct, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                imageStruct = aiTxtGenImgRecPlaceViewRefresh.img;
            }
            return aiTxtGenImgRecPlaceViewRefresh.copy(imageStruct);
        }

        public final ImageStruct component1() {
            return this.img;
        }

        public final AiTxtGenImgRecPlaceViewRefresh copy(ImageStruct imageStruct) {
            Intrinsics.checkNotNullParameter(imageStruct, "img");
            return new AiTxtGenImgRecPlaceViewRefresh(imageStruct);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof AiTxtGenImgRecPlaceViewRefresh) && Intrinsics.areEqual((Object) this.img, (Object) ((AiTxtGenImgRecPlaceViewRefresh) obj).img);
        }

        public int hashCode() {
            return this.img.hashCode();
        }

        public String toString() {
            return "AiTxtGenImgRecPlaceViewRefresh(img=" + this.img + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AiTxtGenImgRecPlaceViewRefresh(ImageStruct img2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(img2, "img");
            this.img = img2;
        }

        public final ImageStruct getImg() {
            return this.img;
        }
    }
}
