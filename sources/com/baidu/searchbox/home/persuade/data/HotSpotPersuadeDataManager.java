package com.baidu.searchbox.home.persuade.data;

import java.util.ArrayList;
import kotlin.Metadata;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\bJ\u0010\u0010\f\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\t\u001a\u00020\bJ&\u0010\r\u001a\u00020\u000e2\u001e\u0010\u000f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006R&\u0010\u0003\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u00010\u0004j\f\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0018\u0001`\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/baidu/searchbox/home/persuade/data/HotSpotPersuadeDataManager;", "", "()V", "mHotSpotPersuadeItemList", "Ljava/util/ArrayList;", "Lcom/baidu/searchbox/home/persuade/data/HotSpotPersuadeItem;", "Lkotlin/collections/ArrayList;", "getHotSpotLabelDrawable", "", "index", "getScheme", "", "getWord", "setData", "", "list", "lib-home-persuade_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: HotSpotPersuadeDataManager.kt */
public final class HotSpotPersuadeDataManager {
    private ArrayList<HotSpotPersuadeItem> mHotSpotPersuadeItemList;

    public final void setData(ArrayList<HotSpotPersuadeItem> list) {
        this.mHotSpotPersuadeItemList = list;
    }

    public final String getWord(int index) {
        HotSpotPersuadeItem hotSpotPersuadeItem;
        ArrayList<HotSpotPersuadeItem> arrayList = this.mHotSpotPersuadeItemList;
        if (arrayList == null || (hotSpotPersuadeItem = arrayList.get(index)) == null) {
            return null;
        }
        return hotSpotPersuadeItem.getWord();
    }

    public final String getScheme(int index) {
        HotSpotPersuadeItem hotSpotPersuadeItem;
        ArrayList<HotSpotPersuadeItem> arrayList = this.mHotSpotPersuadeItemList;
        if (arrayList == null || (hotSpotPersuadeItem = arrayList.get(index)) == null) {
            return null;
        }
        return hotSpotPersuadeItem.getScheme();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r0.get(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int getHotSpotLabelDrawable(int r3) {
        /*
            r2 = this;
            java.util.ArrayList<com.baidu.searchbox.home.persuade.data.HotSpotPersuadeItem> r0 = r2.mHotSpotPersuadeItemList
            if (r0 == 0) goto L_0x0011
            java.lang.Object r0 = r0.get(r3)
            com.baidu.searchbox.home.persuade.data.HotSpotPersuadeItem r0 = (com.baidu.searchbox.home.persuade.data.HotSpotPersuadeItem) r0
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r0.getHotTag()
            goto L_0x0012
        L_0x0011:
            r0 = 0
        L_0x0012:
            r1 = r0
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0020
            int r1 = r1.length()
            if (r1 != 0) goto L_0x001e
            goto L_0x0020
        L_0x001e:
            r1 = 0
            goto L_0x0021
        L_0x0020:
            r1 = 1
        L_0x0021:
            if (r1 != 0) goto L_0x006a
            int r1 = r0.hashCode()
            switch(r1) {
                case 48: goto L_0x005b;
                case 49: goto L_0x004f;
                case 50: goto L_0x002a;
                case 51: goto L_0x0043;
                case 52: goto L_0x0037;
                case 53: goto L_0x002b;
                default: goto L_0x002a;
            }
        L_0x002a:
            goto L_0x0067
        L_0x002b:
            java.lang.String r1 = "5"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0034
            goto L_0x002a
        L_0x0034:
            int r1 = com.baidu.searchbox.home.persuade.R.drawable.hot_spot_label_bao
            goto L_0x0069
        L_0x0037:
            java.lang.String r1 = "4"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0040
            goto L_0x002a
        L_0x0040:
            int r1 = com.baidu.searchbox.home.persuade.R.drawable.hot_spot_label_fei
            goto L_0x0069
        L_0x0043:
            java.lang.String r1 = "3"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x004c
            goto L_0x002a
        L_0x004c:
            int r1 = com.baidu.searchbox.home.persuade.R.drawable.hot_spot_label_re
            goto L_0x0069
        L_0x004f:
            java.lang.String r1 = "1"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0058
            goto L_0x002a
        L_0x0058:
            int r1 = com.baidu.searchbox.home.persuade.R.drawable.hot_spot_label_new
            goto L_0x0069
        L_0x005b:
            java.lang.String r1 = "0"
            boolean r1 = r0.equals(r1)
            if (r1 != 0) goto L_0x0064
            goto L_0x002a
        L_0x0064:
            int r1 = com.baidu.searchbox.home.persuade.R.drawable.hot_spot_label_fire
            goto L_0x0069
        L_0x0067:
            int r1 = com.baidu.searchbox.home.persuade.R.drawable.hot_spot_label_fire
        L_0x0069:
            return r1
        L_0x006a:
            int r1 = com.baidu.searchbox.home.persuade.R.drawable.hot_spot_label_fire
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.home.persuade.data.HotSpotPersuadeDataManager.getHotSpotLabelDrawable(int):int");
    }
}
