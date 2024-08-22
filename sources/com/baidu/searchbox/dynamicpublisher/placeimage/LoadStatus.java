package com.baidu.searchbox.dynamicpublisher.placeimage;

import com.baidu.searchbox.ugc.model.ImageStruct;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004¢\u0006\u0002\u0010\u0002\u0001\u0004\u0007\b\t\n¨\u0006\u000b"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus;", "", "()V", "Done", "Idle", "Progress", "Start", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Idle;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Start;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Progress;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Done;", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PlaceImageState.kt */
public abstract class LoadStatus {
    public /* synthetic */ LoadStatus(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private LoadStatus() {
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Idle;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus;", "()V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaceImageState.kt */
    public static final class Idle extends LoadStatus {
        public static final Idle INSTANCE = new Idle();

        private Idle() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Start;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus;", "()V", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaceImageState.kt */
    public static final class Start extends LoadStatus {
        public static final Start INSTANCE = new Start();

        private Start() {
            super((DefaultConstructorMarker) null);
        }
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\t\u0010\u0007\u001a\u00020\u0003HÆ\u0003J\u0013\u0010\b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fHÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Progress;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus;", "progress", "", "(F)V", "getProgress", "()F", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaceImageState.kt */
    public static final class Progress extends LoadStatus {
        private final float progress;

        public static /* synthetic */ Progress copy$default(Progress progress2, float f2, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                f2 = progress2.progress;
            }
            return progress2.copy(f2);
        }

        public final float component1() {
            return this.progress;
        }

        public final Progress copy(float f2) {
            return new Progress(f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Progress) && Intrinsics.areEqual((Object) Float.valueOf(this.progress), (Object) Float.valueOf(((Progress) obj).progress));
        }

        public int hashCode() {
            return Float.hashCode(this.progress);
        }

        public String toString() {
            return "Progress(progress=" + this.progress + ')';
        }

        public Progress(float progress2) {
            super((DefaultConstructorMarker) null);
            this.progress = progress2;
        }

        public final float getProgress() {
            return this.progress;
        }
    }

    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0016\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\u0002\u0010\u0006J\u0019\u0010\t\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0003J#\u0010\n\u001a\u00020\u00002\u0018\b\u0002\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005HÆ\u0001J\u0013\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000eHÖ\u0003J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R!\u0010\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00040\u0003j\b\u0012\u0004\u0012\u00020\u0004`\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus$Done;", "Lcom/baidu/searchbox/dynamicpublisher/placeimage/LoadStatus;", "imageList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/ugc/model/ImageStruct;", "Lkotlin/collections/ArrayList;", "(Ljava/util/ArrayList;)V", "getImageList", "()Ljava/util/ArrayList;", "component1", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "lib-publisher-component_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: PlaceImageState.kt */
    public static final class Done extends LoadStatus {
        private final ArrayList<ImageStruct> imageList;

        public static /* synthetic */ Done copy$default(Done done, ArrayList<ImageStruct> arrayList, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                arrayList = done.imageList;
            }
            return done.copy(arrayList);
        }

        public final ArrayList<ImageStruct> component1() {
            return this.imageList;
        }

        public final Done copy(ArrayList<ImageStruct> arrayList) {
            Intrinsics.checkNotNullParameter(arrayList, "imageList");
            return new Done(arrayList);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Done) && Intrinsics.areEqual((Object) this.imageList, (Object) ((Done) obj).imageList);
        }

        public int hashCode() {
            return this.imageList.hashCode();
        }

        public String toString() {
            return "Done(imageList=" + this.imageList + ')';
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public Done(ArrayList<ImageStruct> imageList2) {
            super((DefaultConstructorMarker) null);
            Intrinsics.checkNotNullParameter(imageList2, "imageList");
            this.imageList = imageList2;
        }

        public final ArrayList<ImageStruct> getImageList() {
            return this.imageList;
        }
    }
}
