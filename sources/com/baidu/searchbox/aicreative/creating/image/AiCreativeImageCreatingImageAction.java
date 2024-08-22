package com.baidu.searchbox.aicreative.creating.image;

import com.baidu.searchbox.feed.detail.frame.Action;
import com.baidu.searchbox.ugc.model.ImageStruct;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0001\u0003B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0001\u0004¨\u0006\u0005"}, d2 = {"Lcom/baidu/searchbox/aicreative/creating/image/AiCreativeImageCreatingImageAction;", "Lcom/baidu/searchbox/feed/detail/frame/Action;", "()V", "UpdateImage", "Lcom/baidu/searchbox/aicreative/creating/image/AiCreativeImageCreatingImageAction$UpdateImage;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AiCreativeImageCreatingImageAction.kt */
public abstract class AiCreativeImageCreatingImageAction implements Action {
    public /* synthetic */ AiCreativeImageCreatingImageAction(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private AiCreativeImageCreatingImageAction() {
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0003J\u0019\u0010\t\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\rHÖ\u0003J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0010\u001a\u00020\u0011HÖ\u0001R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/baidu/searchbox/aicreative/creating/image/AiCreativeImageCreatingImageAction$UpdateImage;", "Lcom/baidu/searchbox/aicreative/creating/image/AiCreativeImageCreatingImageAction;", "images", "", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "(Ljava/util/List;)V", "getImages", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AiCreativeImageCreatingImageAction.kt */
    public static final class UpdateImage extends AiCreativeImageCreatingImageAction {
        private final List<ImageStruct> images;

        public static /* synthetic */ UpdateImage copy$default(UpdateImage updateImage, List<ImageStruct> list, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list = updateImage.images;
            }
            return updateImage.copy(list);
        }

        public final List<ImageStruct> component1() {
            return this.images;
        }

        public final UpdateImage copy(List<? extends ImageStruct> list) {
            Intrinsics.checkNotNullParameter(list, "images");
            return new UpdateImage(list);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof UpdateImage) && Intrinsics.areEqual((Object) this.images, (Object) ((UpdateImage) obj).images);
        }

        public int hashCode() {
            return this.images.hashCode();
        }

        public String toString() {
            return "UpdateImage(images=" + this.images + ')';
        }

        public final List<ImageStruct> getImages() {
            return this.images;
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public UpdateImage(List<? extends ImageStruct> images2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(images2, "images");
            this.images = images2;
        }
    }
}
