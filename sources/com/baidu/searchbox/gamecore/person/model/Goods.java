package com.baidu.searchbox.gamecore.person.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B\u001f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005¢\u0006\u0002\u0010\u0007J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u0011\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J'\u0010\u0012\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0018HÖ\u0001J\b\u0010\u0019\u001a\u00020\u0014H\u0016J\t\u0010\u001a\u001a\u00020\u001bHÖ\u0001R&\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001c"}, d2 = {"Lcom/baidu/searchbox/gamecore/person/model/Goods;", "Lcom/baidu/searchbox/gamecore/person/model/BaseItemData;", "moreButton", "Lcom/baidu/searchbox/gamecore/person/model/MoreButton;", "list", "", "Lcom/baidu/searchbox/gamecore/person/model/GoodItem;", "(Lcom/baidu/searchbox/gamecore/person/model/MoreButton;Ljava/util/List;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getMoreButton", "()Lcom/baidu/searchbox/gamecore/person/model/MoreButton;", "setMoreButton", "(Lcom/baidu/searchbox/gamecore/person/model/MoreButton;)V", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "isValid", "toString", "", "lib-game-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: Goods.kt */
public final class Goods extends BaseItemData {
    @SerializedName("list")
    private List<GoodItem> list;
    @SerializedName("see_more_button")
    private MoreButton moreButton;

    public static /* synthetic */ Goods copy$default(Goods goods, MoreButton moreButton2, List<GoodItem> list2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            moreButton2 = goods.moreButton;
        }
        if ((i2 & 2) != 0) {
            list2 = goods.list;
        }
        return goods.copy(moreButton2, list2);
    }

    public final MoreButton component1() {
        return this.moreButton;
    }

    public final List<GoodItem> component2() {
        return this.list;
    }

    public final Goods copy(MoreButton moreButton2, List<GoodItem> list2) {
        return new Goods(moreButton2, list2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Goods)) {
            return false;
        }
        Goods goods = (Goods) obj;
        return Intrinsics.areEqual((Object) this.moreButton, (Object) goods.moreButton) && Intrinsics.areEqual((Object) this.list, (Object) goods.list);
    }

    public int hashCode() {
        MoreButton moreButton2 = this.moreButton;
        int i2 = 0;
        int hashCode = (moreButton2 == null ? 0 : moreButton2.hashCode()) * 31;
        List<GoodItem> list2 = this.list;
        if (list2 != null) {
            i2 = list2.hashCode();
        }
        return hashCode + i2;
    }

    public String toString() {
        return "Goods(moreButton=" + this.moreButton + ", list=" + this.list + ')';
    }

    public final MoreButton getMoreButton() {
        return this.moreButton;
    }

    public final void setMoreButton(MoreButton moreButton2) {
        this.moreButton = moreButton2;
    }

    public Goods(MoreButton moreButton2, List<GoodItem> list2) {
        this.moreButton = moreButton2;
        this.list = list2;
    }

    public final List<GoodItem> getList() {
        return this.list;
    }

    public final void setList(List<GoodItem> list2) {
        this.list = list2;
    }

    public boolean isValid() {
        List it = this.list;
        if (it != null) {
            return !it.isEmpty();
        }
        return false;
    }
}
