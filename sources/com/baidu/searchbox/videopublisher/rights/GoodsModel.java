package com.baidu.searchbox.videopublisher.rights;

import com.baidu.searchbox.ugc.model.UgcGoodsModel;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001R \u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0019"}, d2 = {"Lcom/baidu/searchbox/videopublisher/rights/GoodsModel;", "", "ugcGoodsModel", "Lcom/baidu/searchbox/ugc/model/UgcGoodsModel;", "goodsData", "Lorg/json/JSONObject;", "(Lcom/baidu/searchbox/ugc/model/UgcGoodsModel;Lorg/json/JSONObject;)V", "getGoodsData", "()Lorg/json/JSONObject;", "setGoodsData", "(Lorg/json/JSONObject;)V", "getUgcGoodsModel", "()Lcom/baidu/searchbox/ugc/model/UgcGoodsModel;", "setUgcGoodsModel", "(Lcom/baidu/searchbox/ugc/model/UgcGoodsModel;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "lib-publisher-video_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RightsModel.kt */
public final class GoodsModel {
    @SerializedName("goods_model_source_data")
    private JSONObject goodsData;
    @SerializedName("goods_model_ugc_goods_model")
    private UgcGoodsModel ugcGoodsModel;

    public GoodsModel() {
        this((UgcGoodsModel) null, (JSONObject) null, 3, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ GoodsModel copy$default(GoodsModel goodsModel, UgcGoodsModel ugcGoodsModel2, JSONObject jSONObject, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            ugcGoodsModel2 = goodsModel.ugcGoodsModel;
        }
        if ((i2 & 2) != 0) {
            jSONObject = goodsModel.goodsData;
        }
        return goodsModel.copy(ugcGoodsModel2, jSONObject);
    }

    public final UgcGoodsModel component1() {
        return this.ugcGoodsModel;
    }

    public final JSONObject component2() {
        return this.goodsData;
    }

    public final GoodsModel copy(UgcGoodsModel ugcGoodsModel2, JSONObject jSONObject) {
        return new GoodsModel(ugcGoodsModel2, jSONObject);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GoodsModel)) {
            return false;
        }
        GoodsModel goodsModel = (GoodsModel) obj;
        return Intrinsics.areEqual((Object) this.ugcGoodsModel, (Object) goodsModel.ugcGoodsModel) && Intrinsics.areEqual((Object) this.goodsData, (Object) goodsModel.goodsData);
    }

    public int hashCode() {
        UgcGoodsModel ugcGoodsModel2 = this.ugcGoodsModel;
        int i2 = 0;
        int hashCode = (ugcGoodsModel2 == null ? 0 : ugcGoodsModel2.hashCode()) * 31;
        JSONObject jSONObject = this.goodsData;
        if (jSONObject != null) {
            i2 = jSONObject.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "GoodsModel(ugcGoodsModel=" + this.ugcGoodsModel + ", goodsData=" + this.goodsData + ')';
    }

    public GoodsModel(UgcGoodsModel ugcGoodsModel2, JSONObject goodsData2) {
        this.ugcGoodsModel = ugcGoodsModel2;
        this.goodsData = goodsData2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GoodsModel(UgcGoodsModel ugcGoodsModel2, JSONObject jSONObject, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : ugcGoodsModel2, (i2 & 2) != 0 ? null : jSONObject);
    }

    public final UgcGoodsModel getUgcGoodsModel() {
        return this.ugcGoodsModel;
    }

    public final void setUgcGoodsModel(UgcGoodsModel ugcGoodsModel2) {
        this.ugcGoodsModel = ugcGoodsModel2;
    }

    public final JSONObject getGoodsData() {
        return this.goodsData;
    }

    public final void setGoodsData(JSONObject jSONObject) {
        this.goodsData = jSONObject;
    }
}
