package com.baidu.searchbox.search.tab.sortSelect;

import com.baidu.searchbox.search.tab.sortSelect.popupWIndow.VideoCommonPopupSelectListener;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/search/tab/sortSelect/SortSelectBaseView$showPopupWindow$1$popupSelectListener$1", "Lcom/baidu/searchbox/search/tab/sortSelect/popupWIndow/VideoCommonPopupSelectListener;", "onItemSelect", "", "position", "", "search_video_business_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: VideoCommonSortBaseView.kt */
public final class SortSelectBaseView$showPopupWindow$1$popupSelectListener$1 implements VideoCommonPopupSelectListener {
    final /* synthetic */ SortSelectBaseView this$0;

    SortSelectBaseView$showPopupWindow$1$popupSelectListener$1(SortSelectBaseView $receiver) {
        this.this$0 = $receiver;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r0 = r0.getVideoCommonSortModel();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onItemSelect(int r10) {
        /*
            r9 = this;
            com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView r0 = r9.this$0
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortUnionModel r0 = r0.getMModelVideoCommon()
            r1 = 0
            if (r0 == 0) goto L_0x0014
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel r0 = r0.getVideoCommonSortModel()
            if (r0 == 0) goto L_0x0014
            java.util.ArrayList r0 = r0.getSortItemList()
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            if (r0 == 0) goto L_0x0030
            java.lang.Object r2 = r0.get(r10)
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel$SortItem r2 = (com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel.SortItem) r2
            if (r2 == 0) goto L_0x0030
            com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView r3 = r9.this$0
            r4 = 0
            android.widget.TextView r3 = r3.getSortSelectTv()
            java.lang.String r5 = r2.getSelectTitle()
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r3.setText(r5)
        L_0x0030:
            com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView r2 = r9.this$0
            com.baidu.searchbox.search.tab.core.manager.IComponentManager r2 = r2.getComponentManager()
            if (r2 == 0) goto L_0x004b
            java.lang.Class<com.baidu.searchbox.search.tab.implement.service.ISubTabCacheService> r3 = com.baidu.searchbox.search.tab.implement.service.ISubTabCacheService.class
            com.baidu.searchbox.search.tab.core.service.IService r2 = r2.getService(r3)
            com.baidu.searchbox.search.tab.implement.service.ISubTabCacheService r2 = (com.baidu.searchbox.search.tab.implement.service.ISubTabCacheService) r2
            if (r2 == 0) goto L_0x004b
            java.lang.String r2 = r2.getSortType()
            if (r2 == 0) goto L_0x004b
            goto L_0x004d
        L_0x004b:
            java.lang.String r2 = ""
        L_0x004d:
            if (r0 == 0) goto L_0x0095
            com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView r3 = r9.this$0
            r4 = r0
            r5 = 0
            java.util.Iterator r6 = r4.iterator()
        L_0x0058:
            boolean r7 = r6.hasNext()
            if (r7 == 0) goto L_0x0070
            java.lang.Object r7 = r6.next()
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel$SortItem r7 = (com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel.SortItem) r7
            java.lang.String r8 = r7.getVrs()
            boolean r8 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r8, (java.lang.Object) r2)
            r7.setSelected(r8)
            goto L_0x0058
        L_0x0070:
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortUnionModel r6 = r3.getMModelVideoCommon()
            if (r6 == 0) goto L_0x007b
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel r6 = r6.getVideoCommonSortModel()
            goto L_0x007c
        L_0x007b:
            r6 = r1
        L_0x007c:
            if (r6 != 0) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            r6.setSortItemList(r4)
        L_0x0082:
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortUnionModel r3 = r3.getMModelVideoCommon()
            if (r3 == 0) goto L_0x008c
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel r1 = r3.getVideoCommonSortModel()
        L_0x008c:
            if (r1 != 0) goto L_0x008f
            goto L_0x0093
        L_0x008f:
            r3 = 1
            r1.setHasSorted(r3)
        L_0x0093:
        L_0x0095:
            com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView r1 = r9.this$0
            r1.showSortSelectTv()
            com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView r1 = r9.this$0
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortUnionModel r1 = r1.getMModelVideoCommon()
            if (r1 == 0) goto L_0x00b3
            com.baidu.searchbox.search.tab.sortSelect.VideoCommonSortModel r1 = r1.getVideoCommonSortModel()
            if (r1 == 0) goto L_0x00b3
            com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView r3 = r9.this$0
            r4 = 0
            com.baidu.searchbox.search.tab.sortSelect.popupWIndow.VideoCommonSortSelectPopupWindow r3 = r3.getMSimpleFeedbackPopupView()
            r3.setPopupData(r1)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.search.tab.sortSelect.SortSelectBaseView$showPopupWindow$1$popupSelectListener$1.onItemSelect(int):void");
    }
}
