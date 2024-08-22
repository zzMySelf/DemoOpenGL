package com.baidu.searchbox.kmm.personalpage.shop.entities;

import com.baidu.searchbox.kmm.foundation.kelson.JsonElement;
import com.baidu.searchbox.kmm.foundation.kelson.JsonModel;
import com.baidu.searchbox.kmm.foundation.kelson.JsonObject;
import com.baidu.searchbox.kmm.foundation.kelson.JsonUtilKt;
import com.baidu.searchbox.kmm.foundation.utils.extensions.StringExtensions;
import com.baidu.searchbox.theme.skin.utils.SkinDataParser;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0016J\u0012\u0010:\u001a\f\u0012\u0004\u0012\u00020\u0006\u0012\u0002\b\u00030;H\u0016R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u000b\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\tR.\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r2\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\r@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0012\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003@BX\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001e\u0010\u001e\u001a\u0004\u0018\u00010\u0018X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b\u001f\u0010\u001a\"\u0004\b \u0010\u001cR\u001c\u0010!\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\t\"\u0004\b#\u0010$R\u001c\u0010%\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\t\"\u0004\b'\u0010$R$\u0010(\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`)X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b*\u0010\u001a\"\u0004\b+\u0010\u001cR$\u0010,\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`)X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b-\u0010\u001a\"\u0004\b.\u0010\u001cR$\u0010/\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`)X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b0\u0010\u001a\"\u0004\b1\u0010\u001cR$\u00102\u001a\n\u0018\u00010\u0018j\u0004\u0018\u0001`)X\u000e¢\u0006\u0010\n\u0002\u0010\u001d\u001a\u0004\b3\u0010\u001a\"\u0004\b4\u0010\u001cR\u0010\u00105\u001a\u0004\u0018\u00010\u0016X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryCategoryEntity;", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonModel;", "useNewApi", "", "(Z)V", "<set-?>", "", "cateId", "getCateId", "()Ljava/lang/String;", "cateName", "cateTitle", "getCateTitle", "", "Lcom/baidu/searchbox/kmm/personalpage/shop/entities/PersonalPageGalleryImageEntity;", "images", "getImages", "()Ljava/util/List;", "isVip", "()Z", "subTitle", "tabColor", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonObject;", "tabImageAndroidWidth", "", "getTabImageAndroidWidth", "()Ljava/lang/Integer;", "setTabImageAndroidWidth", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "tabImageIOSWidth", "getTabImageIOSWidth", "setTabImageIOSWidth", "tabImageUrl", "getTabImageUrl", "setTabImageUrl", "(Ljava/lang/String;)V", "tabNightImageUrl", "getTabNightImageUrl", "setTabNightImageUrl", "tabSelectedColorAnd", "Lcom/baidu/searchbox/kmm/foundation/mappings/KColorValue;", "getTabSelectedColorAnd", "setTabSelectedColorAnd", "tabSelectedColorAndNight", "getTabSelectedColorAndNight", "setTabSelectedColorAndNight", "tabSelectedColorIos", "getTabSelectedColorIos", "setTabSelectedColorIos", "tabSelectedColorIosNight", "getTabSelectedColorIosNight", "setTabSelectedColorIosNight", "tabSize", "decode", "", "jsonObject", "Lcom/baidu/searchbox/kmm/foundation/kelson/JsonElement;", "encode", "", "com.baidu.searchbox.kmm.business.personalpage"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: PersonalPageGalleryCategoryEntity.kt */
public final class PersonalPageGalleryCategoryEntity extends JsonModel {
    private String cateId;
    /* access modifiers changed from: private */
    public String cateName;
    private String cateTitle;
    private List<PersonalPageGalleryImageEntity> images;
    private boolean isVip;
    /* access modifiers changed from: private */
    public String subTitle;
    /* access modifiers changed from: private */
    public JsonObject tabColor;
    private Integer tabImageAndroidWidth;
    private Integer tabImageIOSWidth;
    private String tabImageUrl;
    private String tabNightImageUrl;
    private Integer tabSelectedColorAnd;
    private Integer tabSelectedColorAndNight;
    private Integer tabSelectedColorIos;
    private Integer tabSelectedColorIosNight;
    /* access modifiers changed from: private */
    public JsonObject tabSize;
    private final boolean useNewApi;

    public PersonalPageGalleryCategoryEntity() {
        this(false, 1, (DefaultConstructorMarker) null);
    }

    public PersonalPageGalleryCategoryEntity(boolean useNewApi2) {
        this.useNewApi = useNewApi2;
        this.cateId = "";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PersonalPageGalleryCategoryEntity(boolean z, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? false : z);
    }

    public final String getCateId() {
        return this.cateId;
    }

    public final String getCateTitle() {
        return this.cateTitle;
    }

    public final boolean isVip() {
        return this.isVip;
    }

    public final List<PersonalPageGalleryImageEntity> getImages() {
        return this.images;
    }

    public final String getTabImageUrl() {
        return this.tabImageUrl;
    }

    public final void setTabImageUrl(String str) {
        this.tabImageUrl = str;
    }

    public final String getTabNightImageUrl() {
        return this.tabNightImageUrl;
    }

    public final void setTabNightImageUrl(String str) {
        this.tabNightImageUrl = str;
    }

    public final Integer getTabImageAndroidWidth() {
        return this.tabImageAndroidWidth;
    }

    public final void setTabImageAndroidWidth(Integer num) {
        this.tabImageAndroidWidth = num;
    }

    public final Integer getTabImageIOSWidth() {
        return this.tabImageIOSWidth;
    }

    public final void setTabImageIOSWidth(Integer num) {
        this.tabImageIOSWidth = num;
    }

    public final Integer getTabSelectedColorAnd() {
        return this.tabSelectedColorAnd;
    }

    public final void setTabSelectedColorAnd(Integer num) {
        this.tabSelectedColorAnd = num;
    }

    public final Integer getTabSelectedColorAndNight() {
        return this.tabSelectedColorAndNight;
    }

    public final void setTabSelectedColorAndNight(Integer num) {
        this.tabSelectedColorAndNight = num;
    }

    public final Integer getTabSelectedColorIos() {
        return this.tabSelectedColorIos;
    }

    public final void setTabSelectedColorIos(Integer num) {
        this.tabSelectedColorIos = num;
    }

    public final Integer getTabSelectedColorIosNight() {
        return this.tabSelectedColorIosNight;
    }

    public final void setTabSelectedColorIosNight(Integer num) {
        this.tabSelectedColorIosNight = num;
    }

    public void decode(JsonElement jsonObject) {
        String str;
        String str2;
        int i2;
        int i3;
        String string$default;
        String string$default2;
        String string$default3;
        String string$default4;
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
        Integer num = null;
        JsonObject obj = jsonObject instanceof JsonObject ? (JsonObject) jsonObject : null;
        if (obj != null) {
            this.cateId = JsonUtilKt.getString$default(obj, "id", (String) null, 2, (Object) null);
            JsonElement jsonElement = obj;
            if (this.useNewApi) {
                str = "name";
            } else {
                str = "category";
            }
            this.cateName = JsonUtilKt.getString$default(jsonElement, str, (String) null, 2, (Object) null);
            this.subTitle = JsonUtilKt.getString$default(obj, "subTitle", (String) null, 2, (Object) null);
            if (Intrinsics.areEqual((Object) this.cateName, (Object) "会员")) {
                this.isVip = true;
                this.cateTitle = "DU会员专享";
            } else {
                this.isVip = false;
                this.cateTitle = this.cateName;
            }
            JsonElement jsonElement2 = obj;
            if (this.useNewApi) {
                str2 = "list";
            } else {
                str2 = "images";
            }
            this.images = JsonUtilKt.getJsonModelList(jsonElement2, str2, new PersonalPageGalleryCategoryEntity$decode$1(this));
            this.tabImageUrl = JsonUtilKt.getString$default(obj, "img_url", (String) null, 2, (Object) null);
            this.tabNightImageUrl = JsonUtilKt.getString$default(obj, "dark_img_url", (String) null, 2, (Object) null);
            JsonObject jsonObject2 = JsonUtilKt.toJsonObject(JsonUtilKt.getString$default(obj, SkinDataParser.KEY_ATTRS_CATEGORY_ITEM_IMG_SIZE, (String) null, 2, (Object) null));
            this.tabSize = jsonObject2;
            int andWidth = jsonObject2 != null ? JsonUtilKt.getInt$default(jsonObject2, SkinDataParser.KEY_ATTRS_CATEGORY_ITEM_TAB_WIDTH_AND, 0, 2, (Object) null) : 0;
            if (andWidth > 0) {
                i2 = Integer.valueOf(andWidth);
            } else {
                i2 = 0;
            }
            this.tabImageAndroidWidth = i2;
            JsonObject jsonObject3 = this.tabSize;
            int iosWidth = jsonObject3 != null ? JsonUtilKt.getInt$default(jsonObject3, "tab_width_ios", 0, 2, (Object) null) : 0;
            if (iosWidth > 0) {
                i3 = Integer.valueOf(iosWidth);
            } else {
                i3 = 0;
            }
            this.tabImageIOSWidth = i3;
            JsonObject jsonObject4 = JsonUtilKt.toJsonObject(JsonUtilKt.getString$default(obj, "tab_color", (String) null, 2, (Object) null));
            this.tabColor = jsonObject4;
            this.tabSelectedColorAnd = (jsonObject4 == null || (string$default4 = JsonUtilKt.getString$default(jsonObject4, "tab_selected_color_and", (String) null, 2, (Object) null)) == null) ? null : StringExtensions.hexToColor(string$default4);
            JsonObject jsonObject5 = this.tabColor;
            this.tabSelectedColorAndNight = (jsonObject5 == null || (string$default3 = JsonUtilKt.getString$default(jsonObject5, "tab_selected_color_and_night", (String) null, 2, (Object) null)) == null) ? null : StringExtensions.hexToColor(string$default3);
            JsonObject jsonObject6 = this.tabColor;
            this.tabSelectedColorIos = (jsonObject6 == null || (string$default2 = JsonUtilKt.getString$default(jsonObject6, "tab_selected_color_ios", (String) null, 2, (Object) null)) == null) ? null : StringExtensions.hexToColor(string$default2);
            JsonObject jsonObject7 = this.tabColor;
            if (!(jsonObject7 == null || (string$default = JsonUtilKt.getString$default(jsonObject7, "tab_selected_color_ios_night", (String) null, 2, (Object) null)) == null)) {
                num = StringExtensions.hexToColor(string$default);
            }
            this.tabSelectedColorIosNight = num;
        }
    }

    public Map<String, ?> encode() {
        return JsonUtilKt.buildJsonObject(new PersonalPageGalleryCategoryEntity$encode$1(this));
    }
}
