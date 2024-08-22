package com.baidu.searchbox.widget.operate;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0004\b\b\u0018\u00002\u00020\u0001BE\u0012\u001a\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\nJ\u001d\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u0006\u0010\u001b\u001a\u00020\u0000JK\u0010\u001b\u001a\u00020\u00002\u001c\b\u0002\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0007HÆ\u0001J\u0013\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fHÖ\u0003J\u0010\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\"J\t\u0010#\u001a\u00020\"HÖ\u0001J\u000e\u0010$\u001a\u00020\u001d2\u0006\u0010%\u001a\u00020\u0000J\u0010\u0010&\u001a\u00020\u001d2\b\u0010'\u001a\u0004\u0018\u00010\u0004J\u0006\u0010(\u001a\u00020\u001dJ\u0006\u0010)\u001a\u00020\u001dJ\u000e\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u0007J\u0006\u0010-\u001a\u00020+J\t\u0010.\u001a\u00020\u0007HÖ\u0001R.\u0010\u0002\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003j\n\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012R\u001c\u0010\t\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0010\"\u0004\b\u0016\u0010\u0012¨\u0006/"}, d2 = {"Lcom/baidu/searchbox/widget/operate/WidgetOperateList;", "Lcom/baidu/searchbox/NoProGuard;", "cates", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/widget/operate/WidgetOperate;", "Lkotlin/collections/ArrayList;", "dayPic", "", "nightPic", "widgetType", "(Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCates", "()Ljava/util/ArrayList;", "setCates", "(Ljava/util/ArrayList;)V", "getDayPic", "()Ljava/lang/String;", "setDayPic", "(Ljava/lang/String;)V", "getNightPic", "setNightPic", "getWidgetType", "setWidgetType", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "getWidgetOperate", "index", "", "hashCode", "isChanged", "widgetOperateList", "isContains", "widgetOperate", "isDataValid", "isValid", "removeItemById", "", "id", "reset", "toString", "lib-widget_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WidgetOperateList.kt */
public final class WidgetOperateList implements NoProGuard {
    private ArrayList<WidgetOperate> cates;
    private String dayPic;
    private String nightPic;
    private String widgetType;

    public static /* synthetic */ WidgetOperateList copy$default(WidgetOperateList widgetOperateList, ArrayList<WidgetOperate> arrayList, String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            arrayList = widgetOperateList.cates;
        }
        if ((i2 & 2) != 0) {
            str = widgetOperateList.dayPic;
        }
        if ((i2 & 4) != 0) {
            str2 = widgetOperateList.nightPic;
        }
        if ((i2 & 8) != 0) {
            str3 = widgetOperateList.widgetType;
        }
        return widgetOperateList.copy(arrayList, str, str2, str3);
    }

    public final ArrayList<WidgetOperate> component1() {
        return this.cates;
    }

    public final String component2() {
        return this.dayPic;
    }

    public final String component3() {
        return this.nightPic;
    }

    public final String component4() {
        return this.widgetType;
    }

    public final WidgetOperateList copy(ArrayList<WidgetOperate> arrayList, String str, String str2, String str3) {
        return new WidgetOperateList(arrayList, str, str2, str3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof WidgetOperateList)) {
            return false;
        }
        WidgetOperateList widgetOperateList = (WidgetOperateList) obj;
        return Intrinsics.areEqual((Object) this.cates, (Object) widgetOperateList.cates) && Intrinsics.areEqual((Object) this.dayPic, (Object) widgetOperateList.dayPic) && Intrinsics.areEqual((Object) this.nightPic, (Object) widgetOperateList.nightPic) && Intrinsics.areEqual((Object) this.widgetType, (Object) widgetOperateList.widgetType);
    }

    public int hashCode() {
        ArrayList<WidgetOperate> arrayList = this.cates;
        int i2 = 0;
        int hashCode = (arrayList == null ? 0 : arrayList.hashCode()) * 31;
        String str = this.dayPic;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        String str2 = this.nightPic;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.widgetType;
        if (str3 != null) {
            i2 = str3.hashCode();
        }
        return hashCode3 + i2;
    }

    public String toString() {
        return "WidgetOperateList(cates=" + this.cates + ", dayPic=" + this.dayPic + ", nightPic=" + this.nightPic + ", widgetType=" + this.widgetType + ')';
    }

    public WidgetOperateList(ArrayList<WidgetOperate> cates2, String dayPic2, String nightPic2, String widgetType2) {
        this.cates = cates2;
        this.dayPic = dayPic2;
        this.nightPic = nightPic2;
        this.widgetType = widgetType2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ WidgetOperateList(ArrayList arrayList, String str, String str2, String str3, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(arrayList, (i2 & 2) != 0 ? "" : str, (i2 & 4) != 0 ? "" : str2, (i2 & 8) != 0 ? "" : str3);
    }

    public final ArrayList<WidgetOperate> getCates() {
        return this.cates;
    }

    public final void setCates(ArrayList<WidgetOperate> arrayList) {
        this.cates = arrayList;
    }

    public final String getDayPic() {
        return this.dayPic;
    }

    public final void setDayPic(String str) {
        this.dayPic = str;
    }

    public final String getNightPic() {
        return this.nightPic;
    }

    public final void setNightPic(String str) {
        this.nightPic = str;
    }

    public final String getWidgetType() {
        return this.widgetType;
    }

    public final void setWidgetType(String str) {
        this.widgetType = str;
    }

    public final WidgetOperate getWidgetOperate(int index) {
        ArrayList $this$getWidgetOperate_u24lambda_u2d0 = this.cates;
        if ($this$getWidgetOperate_u24lambda_u2d0 == null || index >= $this$getWidgetOperate_u24lambda_u2d0.size()) {
            return null;
        }
        return $this$getWidgetOperate_u24lambda_u2d0.get(index);
    }

    public final boolean isValid() {
        ArrayList $this$isValid_u24lambda_u2d1 = this.cates;
        if ($this$isValid_u24lambda_u2d1 == null || $this$isValid_u24lambda_u2d1.size() <= 2 || !$this$isValid_u24lambda_u2d1.get(0).isValid() || !$this$isValid_u24lambda_u2d1.get(1).isValid() || !$this$isValid_u24lambda_u2d1.get(2).isValid()) {
            return false;
        }
        return true;
    }

    public final boolean isDataValid() {
        ArrayList $this$isDataValid_u24lambda_u2d2 = this.cates;
        if ($this$isDataValid_u24lambda_u2d2 == null || !(!$this$isDataValid_u24lambda_u2d2.isEmpty())) {
            return false;
        }
        Iterator<WidgetOperate> it = $this$isDataValid_u24lambda_u2d2.iterator();
        while (it.hasNext()) {
            WidgetOperate item = it.next();
            if (item != null && !item.isValid()) {
                return false;
            }
        }
        return true;
    }

    public final WidgetOperateList copy() {
        ArrayList copyCates = new ArrayList();
        ArrayList<WidgetOperate> arrayList = this.cates;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (!arrayList.isEmpty()) {
                ArrayList<WidgetOperate> arrayList2 = this.cates;
                Intrinsics.checkNotNull(arrayList2);
                Iterator<WidgetOperate> it = arrayList2.iterator();
                while (it.hasNext()) {
                    WidgetOperate item = it.next();
                    if (item != null) {
                        WidgetOperate $this$copy_u24lambda_u2d3 = item;
                        copyCates.add($this$copy_u24lambda_u2d3.copy($this$copy_u24lambda_u2d3.getId(), $this$copy_u24lambda_u2d3.isDefault(), $this$copy_u24lambda_u2d3.getTitle(), $this$copy_u24lambda_u2d3.getSubTitle(), $this$copy_u24lambda_u2d3.getIcon(), $this$copy_u24lambda_u2d3.getTransIcon(), $this$copy_u24lambda_u2d3.getSchema(), $this$copy_u24lambda_u2d3.getPage(), $this$copy_u24lambda_u2d3.getValue(), $this$copy_u24lambda_u2d3.getResId()));
                    }
                }
            }
        }
        return new WidgetOperateList(copyCates, this.dayPic, this.nightPic, this.widgetType);
    }

    public final boolean isChanged(WidgetOperateList widgetOperateList) {
        Intrinsics.checkNotNullParameter(widgetOperateList, "widgetOperateList");
        ArrayList newCates = widgetOperateList.cates;
        ArrayList<WidgetOperate> arrayList = this.cates;
        if (arrayList == null) {
            return false;
        }
        Intrinsics.checkNotNull(arrayList);
        if (!(!arrayList.isEmpty()) || newCates == null || !(!newCates.isEmpty())) {
            return false;
        }
        ArrayList<WidgetOperate> arrayList2 = this.cates;
        Intrinsics.checkNotNull(arrayList2);
        if (arrayList2.size() != newCates.size()) {
            return false;
        }
        ArrayList<WidgetOperate> arrayList3 = this.cates;
        Intrinsics.checkNotNull(arrayList3);
        int size = arrayList3.size();
        for (int index = 0; index < size; index++) {
            ArrayList<WidgetOperate> arrayList4 = this.cates;
            Intrinsics.checkNotNull(arrayList4);
            WidgetOperate widgetOperate = arrayList4.get(index);
            Intrinsics.checkNotNullExpressionValue(widgetOperate, "cates!![index]");
            WidgetOperate oldItem = widgetOperate;
            WidgetOperate widgetOperate2 = newCates.get(index);
            Intrinsics.checkNotNullExpressionValue(widgetOperate2, "newCates!![index]");
            WidgetOperate newItem = widgetOperate2;
            if (!TextUtils.equals(oldItem.getId(), newItem.getId()) || !TextUtils.equals(oldItem.isDefault(), newItem.isDefault())) {
                return true;
            }
        }
        return false;
    }

    public final boolean isContains(WidgetOperate widgetOperate) {
        ArrayList<WidgetOperate> arrayList = this.cates;
        if (arrayList == null) {
            return false;
        }
        Intrinsics.checkNotNull(arrayList);
        if (!(!arrayList.isEmpty()) || widgetOperate == null) {
            return false;
        }
        ArrayList<WidgetOperate> arrayList2 = this.cates;
        Intrinsics.checkNotNull(arrayList2);
        Iterator<WidgetOperate> it = arrayList2.iterator();
        while (it.hasNext()) {
            WidgetOperate item = it.next();
            if (item != null && TextUtils.equals(widgetOperate.getId(), item.getId())) {
                return true;
            }
        }
        return false;
    }

    public final void reset() {
        ArrayList<WidgetOperate> arrayList = this.cates;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (!arrayList.isEmpty()) {
                ArrayList<WidgetOperate> arrayList2 = this.cates;
                Intrinsics.checkNotNull(arrayList2);
                Iterator<WidgetOperate> it = arrayList2.iterator();
                while (it.hasNext()) {
                    WidgetOperate item = it.next();
                    if (item != null && TextUtils.equals(item.isDefault(), "1")) {
                        item.setDefault("0");
                    }
                }
            }
        }
    }

    public final void removeItemById(String id) {
        Intrinsics.checkNotNullParameter(id, "id");
        ArrayList<WidgetOperate> arrayList = this.cates;
        if (arrayList != null) {
            Intrinsics.checkNotNull(arrayList);
            if (!arrayList.isEmpty()) {
                WidgetOperate removeItem = null;
                ArrayList<WidgetOperate> arrayList2 = this.cates;
                Intrinsics.checkNotNull(arrayList2);
                Iterator<WidgetOperate> it = arrayList2.iterator();
                while (true) {
                    if (it.hasNext()) {
                        WidgetOperate item = it.next();
                        if (item != null && TextUtils.equals(item.getId(), id)) {
                            removeItem = item;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (removeItem != null) {
                    ArrayList<WidgetOperate> arrayList3 = this.cates;
                    Intrinsics.checkNotNull(arrayList3);
                    arrayList3.remove(removeItem);
                }
            }
        }
    }
}
