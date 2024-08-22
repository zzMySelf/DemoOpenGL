package com.baidu.searchbox.collectiondetail.repos;

import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.video.detail.core.model.IntentData;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b0\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bs\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\t\u001a\u00020\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\t\u0010'\u001a\u00020\u0003HÆ\u0003J\t\u0010(\u001a\u00020\u0003HÆ\u0003J\t\u0010)\u001a\u00020\u0003HÆ\u0003J\t\u0010*\u001a\u00020\u0003HÆ\u0003J\t\u0010+\u001a\u00020\u0003HÆ\u0003J\t\u0010,\u001a\u00020\u0003HÆ\u0003J\t\u0010-\u001a\u00020\u0003HÆ\u0003J\t\u0010.\u001a\u00020\u0003HÆ\u0003J\t\u0010/\u001a\u00020\u0003HÆ\u0003J\t\u00100\u001a\u00020\u0003HÆ\u0003J\t\u00101\u001a\u00020\u0003HÆ\u0003Jw\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u0003HÆ\u0001J\u0013\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u000106HÖ\u0003J\t\u00107\u001a\u000208HÖ\u0001J\t\u00109\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\n\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001a\u0010\u0006\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012R\u001a\u0010\u000b\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0010\"\u0004\b\u0018\u0010\u0012R\u001a\u0010\f\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0010\"\u0004\b\u001a\u0010\u0012R\u001a\u0010\u0007\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0010\"\u0004\b\u001c\u0010\u0012R\u001a\u0010\r\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u0012R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0010\"\u0004\b \u0010\u0012R\u001a\u0010\u0004\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u0010\"\u0004\b\"\u0010\u0012R\u001a\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u0012R\u001a\u0010\t\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0010\"\u0004\b&\u0010\u0012¨\u0006:"}, d2 = {"Lcom/baidu/searchbox/collectiondetail/repos/CollectionDetailFavorModel;", "Lcom/baidu/searchbox/NoProGuard;", "topicId", "", "tplid", "ukey", "extdata", "pauid", "authorName", "url", "cmd", "favourite", "img", "title", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAuthorName", "()Ljava/lang/String;", "setAuthorName", "(Ljava/lang/String;)V", "getCmd", "setCmd", "getExtdata", "setExtdata", "getFavourite", "setFavourite", "getImg", "setImg", "getPauid", "setPauid", "getTitle", "setTitle", "getTopicId", "setTopicId", "getTplid", "setTplid", "getUkey", "setUkey", "getUrl", "setUrl", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "", "toString", "lib-flow-domain_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: CollectionDetailModel.kt */
public final class CollectionDetailFavorModel implements NoProGuard {
    private String authorName;
    private String cmd;
    private String extdata;
    private String favourite;
    private String img;
    private String pauid;
    private String title;
    private String topicId;
    private String tplid;
    private String ukey;
    private String url;

    public CollectionDetailFavorModel() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 2047, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ CollectionDetailFavorModel copy$default(CollectionDetailFavorModel collectionDetailFavorModel, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, Object obj) {
        CollectionDetailFavorModel collectionDetailFavorModel2 = collectionDetailFavorModel;
        int i3 = i2;
        return collectionDetailFavorModel.copy((i3 & 1) != 0 ? collectionDetailFavorModel2.topicId : str, (i3 & 2) != 0 ? collectionDetailFavorModel2.tplid : str2, (i3 & 4) != 0 ? collectionDetailFavorModel2.ukey : str3, (i3 & 8) != 0 ? collectionDetailFavorModel2.extdata : str4, (i3 & 16) != 0 ? collectionDetailFavorModel2.pauid : str5, (i3 & 32) != 0 ? collectionDetailFavorModel2.authorName : str6, (i3 & 64) != 0 ? collectionDetailFavorModel2.url : str7, (i3 & 128) != 0 ? collectionDetailFavorModel2.cmd : str8, (i3 & 256) != 0 ? collectionDetailFavorModel2.favourite : str9, (i3 & 512) != 0 ? collectionDetailFavorModel2.img : str10, (i3 & 1024) != 0 ? collectionDetailFavorModel2.title : str11);
    }

    public final String component1() {
        return this.topicId;
    }

    public final String component10() {
        return this.img;
    }

    public final String component11() {
        return this.title;
    }

    public final String component2() {
        return this.tplid;
    }

    public final String component3() {
        return this.ukey;
    }

    public final String component4() {
        return this.extdata;
    }

    public final String component5() {
        return this.pauid;
    }

    public final String component6() {
        return this.authorName;
    }

    public final String component7() {
        return this.url;
    }

    public final String component8() {
        return this.cmd;
    }

    public final String component9() {
        return this.favourite;
    }

    public final CollectionDetailFavorModel copy(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11) {
        Intrinsics.checkNotNullParameter(str, "topicId");
        Intrinsics.checkNotNullParameter(str2, "tplid");
        Intrinsics.checkNotNullParameter(str3, "ukey");
        Intrinsics.checkNotNullParameter(str4, "extdata");
        Intrinsics.checkNotNullParameter(str5, "pauid");
        Intrinsics.checkNotNullParameter(str6, IntentData.AUTHOR_NAME);
        Intrinsics.checkNotNullParameter(str7, "url");
        Intrinsics.checkNotNullParameter(str8, "cmd");
        Intrinsics.checkNotNullParameter(str9, "favourite");
        Intrinsics.checkNotNullParameter(str10, "img");
        Intrinsics.checkNotNullParameter(str11, "title");
        return new CollectionDetailFavorModel(str, str2, str3, str4, str5, str6, str7, str8, str9, str10, str11);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CollectionDetailFavorModel)) {
            return false;
        }
        CollectionDetailFavorModel collectionDetailFavorModel = (CollectionDetailFavorModel) obj;
        return Intrinsics.areEqual((Object) this.topicId, (Object) collectionDetailFavorModel.topicId) && Intrinsics.areEqual((Object) this.tplid, (Object) collectionDetailFavorModel.tplid) && Intrinsics.areEqual((Object) this.ukey, (Object) collectionDetailFavorModel.ukey) && Intrinsics.areEqual((Object) this.extdata, (Object) collectionDetailFavorModel.extdata) && Intrinsics.areEqual((Object) this.pauid, (Object) collectionDetailFavorModel.pauid) && Intrinsics.areEqual((Object) this.authorName, (Object) collectionDetailFavorModel.authorName) && Intrinsics.areEqual((Object) this.url, (Object) collectionDetailFavorModel.url) && Intrinsics.areEqual((Object) this.cmd, (Object) collectionDetailFavorModel.cmd) && Intrinsics.areEqual((Object) this.favourite, (Object) collectionDetailFavorModel.favourite) && Intrinsics.areEqual((Object) this.img, (Object) collectionDetailFavorModel.img) && Intrinsics.areEqual((Object) this.title, (Object) collectionDetailFavorModel.title);
    }

    public int hashCode() {
        return (((((((((((((((((((this.topicId.hashCode() * 31) + this.tplid.hashCode()) * 31) + this.ukey.hashCode()) * 31) + this.extdata.hashCode()) * 31) + this.pauid.hashCode()) * 31) + this.authorName.hashCode()) * 31) + this.url.hashCode()) * 31) + this.cmd.hashCode()) * 31) + this.favourite.hashCode()) * 31) + this.img.hashCode()) * 31) + this.title.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CollectionDetailFavorModel(topicId=").append(this.topicId).append(", tplid=").append(this.tplid).append(", ukey=").append(this.ukey).append(", extdata=").append(this.extdata).append(", pauid=").append(this.pauid).append(", authorName=").append(this.authorName).append(", url=").append(this.url).append(", cmd=").append(this.cmd).append(", favourite=").append(this.favourite).append(", img=").append(this.img).append(", title=").append(this.title).append(')');
        return sb.toString();
    }

    public CollectionDetailFavorModel(String topicId2, String tplid2, String ukey2, String extdata2, String pauid2, String authorName2, String url2, String cmd2, String favourite2, String img2, String title2) {
        Intrinsics.checkNotNullParameter(topicId2, "topicId");
        Intrinsics.checkNotNullParameter(tplid2, "tplid");
        Intrinsics.checkNotNullParameter(ukey2, "ukey");
        Intrinsics.checkNotNullParameter(extdata2, "extdata");
        Intrinsics.checkNotNullParameter(pauid2, "pauid");
        Intrinsics.checkNotNullParameter(authorName2, IntentData.AUTHOR_NAME);
        Intrinsics.checkNotNullParameter(url2, "url");
        Intrinsics.checkNotNullParameter(cmd2, "cmd");
        Intrinsics.checkNotNullParameter(favourite2, "favourite");
        Intrinsics.checkNotNullParameter(img2, "img");
        Intrinsics.checkNotNullParameter(title2, "title");
        this.topicId = topicId2;
        this.tplid = tplid2;
        this.ukey = ukey2;
        this.extdata = extdata2;
        this.pauid = pauid2;
        this.authorName = authorName2;
        this.url = url2;
        this.cmd = cmd2;
        this.favourite = favourite2;
        this.img = img2;
        this.title = title2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CollectionDetailFavorModel(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? "" : str, (i2 & 2) != 0 ? "" : str2, (i2 & 4) != 0 ? "" : str3, (i2 & 8) != 0 ? "" : str4, (i2 & 16) != 0 ? "" : str5, (i2 & 32) != 0 ? "" : str6, (i2 & 64) != 0 ? "" : str7, (i2 & 128) != 0 ? "" : str8, (i2 & 256) != 0 ? "" : str9, (i2 & 512) != 0 ? "" : str10, (i2 & 1024) != 0 ? "" : str11);
    }

    public final String getTopicId() {
        return this.topicId;
    }

    public final void setTopicId(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.topicId = str;
    }

    public final String getTplid() {
        return this.tplid;
    }

    public final void setTplid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.tplid = str;
    }

    public final String getUkey() {
        return this.ukey;
    }

    public final void setUkey(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ukey = str;
    }

    public final String getExtdata() {
        return this.extdata;
    }

    public final void setExtdata(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.extdata = str;
    }

    public final String getPauid() {
        return this.pauid;
    }

    public final void setPauid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.pauid = str;
    }

    public final String getAuthorName() {
        return this.authorName;
    }

    public final void setAuthorName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.authorName = str;
    }

    public final String getUrl() {
        return this.url;
    }

    public final void setUrl(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.url = str;
    }

    public final String getCmd() {
        return this.cmd;
    }

    public final void setCmd(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.cmd = str;
    }

    public final String getFavourite() {
        return this.favourite;
    }

    public final void setFavourite(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.favourite = str;
    }

    public final String getImg() {
        return this.img;
    }

    public final void setImg(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.img = str;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.title = str;
    }
}
