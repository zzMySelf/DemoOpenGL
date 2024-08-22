package com.baidu.searchbox.bigimage.model.loadmore;

import com.baidu.searchbox.bigimage.model.BigImageAsset;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001a\b\b\u0018\u00002\u00020\u0001BC\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\u0003\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\t\u0010\u001d\u001a\u00020\bHÆ\u0003J\u0010\u0010\u001e\u001a\u0004\u0018\u00010\nHÆ\u0003¢\u0006\u0002\u0010\u0014J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\rHÆ\u0003JX\u0010!\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001¢\u0006\u0002\u0010\"J\u0013\u0010#\u001a\u00020\n2\b\u0010$\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010%\u001a\u00020\bHÖ\u0001J\t\u0010&\u001a\u00020\u0003HÖ\u0001R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\n\n\u0002\u0010\u0015\u001a\u0004\b\u0013\u0010\u0014R\u0019\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0010¨\u0006'"}, d2 = {"Lcom/baidu/searchbox/bigimage/model/loadmore/ResponseModel;", "", "err", "", "images", "", "Lcom/baidu/searchbox/bigimage/model/BigImageAsset;", "loadImagesFlag", "", "hasMore", "", "loader", "extLog", "Lorg/json/JSONObject;", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;)V", "getErr", "()Ljava/lang/String;", "getExtLog", "()Lorg/json/JSONObject;", "getHasMore", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getImages", "()Ljava/util/List;", "getLoadImagesFlag", "()I", "getLoader", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/Boolean;Ljava/lang/String;Lorg/json/JSONObject;)Lcom/baidu/searchbox/bigimage/model/loadmore/ResponseModel;", "equals", "other", "hashCode", "toString", "lib-search-bigimage_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DataLoader.kt */
public final class ResponseModel {
    private final String err;
    private final JSONObject extLog;
    private final Boolean hasMore;
    private final List<BigImageAsset> images;
    private final int loadImagesFlag;
    private final String loader;

    public static /* synthetic */ ResponseModel copy$default(ResponseModel responseModel, String str, List<BigImageAsset> list, int i2, Boolean bool, String str2, JSONObject jSONObject, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            str = responseModel.err;
        }
        if ((i3 & 2) != 0) {
            list = responseModel.images;
        }
        List<BigImageAsset> list2 = list;
        if ((i3 & 4) != 0) {
            i2 = responseModel.loadImagesFlag;
        }
        int i4 = i2;
        if ((i3 & 8) != 0) {
            bool = responseModel.hasMore;
        }
        Boolean bool2 = bool;
        if ((i3 & 16) != 0) {
            str2 = responseModel.loader;
        }
        String str3 = str2;
        if ((i3 & 32) != 0) {
            jSONObject = responseModel.extLog;
        }
        return responseModel.copy(str, list2, i4, bool2, str3, jSONObject);
    }

    public final String component1() {
        return this.err;
    }

    public final List<BigImageAsset> component2() {
        return this.images;
    }

    public final int component3() {
        return this.loadImagesFlag;
    }

    public final Boolean component4() {
        return this.hasMore;
    }

    public final String component5() {
        return this.loader;
    }

    public final JSONObject component6() {
        return this.extLog;
    }

    public final ResponseModel copy(String str, List<BigImageAsset> list, int i2, Boolean bool, String str2, JSONObject jSONObject) {
        Intrinsics.checkNotNullParameter(str2, "loader");
        return new ResponseModel(str, list, i2, bool, str2, jSONObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ResponseModel)) {
            return false;
        }
        ResponseModel responseModel = (ResponseModel) obj;
        return Intrinsics.areEqual((Object) this.err, (Object) responseModel.err) && Intrinsics.areEqual((Object) this.images, (Object) responseModel.images) && this.loadImagesFlag == responseModel.loadImagesFlag && Intrinsics.areEqual((Object) this.hasMore, (Object) responseModel.hasMore) && Intrinsics.areEqual((Object) this.loader, (Object) responseModel.loader) && Intrinsics.areEqual((Object) this.extLog, (Object) responseModel.extLog);
    }

    public int hashCode() {
        String str = this.err;
        int i2 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        List<BigImageAsset> list = this.images;
        int hashCode2 = (((hashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.loadImagesFlag)) * 31;
        Boolean bool = this.hasMore;
        int hashCode3 = (((hashCode2 + (bool == null ? 0 : bool.hashCode())) * 31) + this.loader.hashCode()) * 31;
        JSONObject jSONObject = this.extLog;
        if (jSONObject != null) {
            i2 = jSONObject.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "ResponseModel(err=" + this.err + ", images=" + this.images + ", loadImagesFlag=" + this.loadImagesFlag + ", hasMore=" + this.hasMore + ", loader=" + this.loader + ", extLog=" + this.extLog + ')';
    }

    public ResponseModel(String err2, List<BigImageAsset> images2, int loadImagesFlag2, Boolean hasMore2, String loader2, JSONObject extLog2) {
        Intrinsics.checkNotNullParameter(loader2, "loader");
        this.err = err2;
        this.images = images2;
        this.loadImagesFlag = loadImagesFlag2;
        this.hasMore = hasMore2;
        this.loader = loader2;
        this.extLog = extLog2;
    }

    public final String getErr() {
        return this.err;
    }

    public final List<BigImageAsset> getImages() {
        return this.images;
    }

    public final int getLoadImagesFlag() {
        return this.loadImagesFlag;
    }

    public final Boolean getHasMore() {
        return this.hasMore;
    }

    public final String getLoader() {
        return this.loader;
    }

    public final JSONObject getExtLog() {
        return this.extLog;
    }
}
