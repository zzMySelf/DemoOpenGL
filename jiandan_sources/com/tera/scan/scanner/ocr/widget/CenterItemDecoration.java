package com.tera.scan.scanner.ocr.widget;

import androidx.recyclerview.widget.RecyclerView;
import fe.mmm.qw.p030switch.th.de.ad.qw;
import kotlin.Metadata;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J(\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/tera/scan/scanner/ocr/widget/CenterItemDecoration;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "itemWidth", "", "(I)V", "enableCenter", "", "getEnableCenter", "()Z", "setEnableCenter", "(Z)V", "margin", "getItemOffsets", "", "outRect", "Landroid/graphics/Rect;", "view", "Landroid/view/View;", "parent", "Landroidx/recyclerview/widget/RecyclerView;", "state", "Landroidx/recyclerview/widget/RecyclerView$State;", "scanner_aiscanConfigRelease"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CenterItemDecoration extends RecyclerView.ItemDecoration {

    /* renamed from: ad  reason: collision with root package name */
    public boolean f7295ad;
    public final int qw;

    public CenterItemDecoration(int i2) {
        this.qw = (qw.rg() - i2) / 2;
    }

    public final boolean getEnableCenter() {
        return this.f7295ad;
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: type inference failed for: r0v8, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: type inference failed for: r0v10, types: [android.view.ViewGroup$LayoutParams] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getItemOffsets(@org.jetbrains.annotations.NotNull android.graphics.Rect r5, @org.jetbrains.annotations.NotNull android.view.View r6, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView r7, @org.jetbrains.annotations.NotNull androidx.recyclerview.widget.RecyclerView.State r8) {
        /*
            r4 = this;
            java.lang.String r0 = "outRect"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "view"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "parent"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            java.lang.String r0 = "state"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r8, r0)
            androidx.recyclerview.widget.RecyclerView$Adapter r0 = r7.getAdapter()
            r1 = 0
            if (r0 == 0) goto L_0x0020
            int r0 = r0.getItemCount()
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            if (r0 <= 0) goto L_0x0085
            boolean r2 = r4.f7295ad
            if (r2 != 0) goto L_0x0028
            goto L_0x0085
        L_0x0028:
            int r2 = r7.getChildAdapterPosition(r6)
            r3 = 0
            if (r2 != 0) goto L_0x004a
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            boolean r2 = r0 instanceof androidx.recyclerview.widget.RecyclerView.LayoutParams
            if (r2 == 0) goto L_0x003a
            r3 = r0
            androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
        L_0x003a:
            if (r3 != 0) goto L_0x003d
            goto L_0x0041
        L_0x003d:
            int r0 = r4.qw
            r3.leftMargin = r0
        L_0x0041:
            if (r3 != 0) goto L_0x0044
            goto L_0x0046
        L_0x0044:
            r3.rightMargin = r1
        L_0x0046:
            r6.setLayoutParams(r3)
            goto L_0x0081
        L_0x004a:
            int r0 = r0 + -1
            if (r2 != r0) goto L_0x0069
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            boolean r2 = r0 instanceof androidx.recyclerview.widget.RecyclerView.LayoutParams
            if (r2 == 0) goto L_0x0059
            r3 = r0
            androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
        L_0x0059:
            if (r3 != 0) goto L_0x005c
            goto L_0x005e
        L_0x005c:
            r3.leftMargin = r1
        L_0x005e:
            if (r3 != 0) goto L_0x0061
            goto L_0x0065
        L_0x0061:
            int r0 = r4.qw
            r3.rightMargin = r0
        L_0x0065:
            r6.setLayoutParams(r3)
            goto L_0x0081
        L_0x0069:
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            boolean r2 = r0 instanceof androidx.recyclerview.widget.RecyclerView.LayoutParams
            if (r2 == 0) goto L_0x0074
            r3 = r0
            androidx.recyclerview.widget.RecyclerView$LayoutParams r3 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r3
        L_0x0074:
            if (r3 != 0) goto L_0x0077
            goto L_0x0079
        L_0x0077:
            r3.leftMargin = r1
        L_0x0079:
            if (r3 != 0) goto L_0x007c
            goto L_0x007e
        L_0x007c:
            r3.rightMargin = r1
        L_0x007e:
            r6.setLayoutParams(r3)
        L_0x0081:
            super.getItemOffsets(r5, r6, r7, r8)
            return
        L_0x0085:
            super.getItemOffsets(r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tera.scan.scanner.ocr.widget.CenterItemDecoration.getItemOffsets(android.graphics.Rect, android.view.View, androidx.recyclerview.widget.RecyclerView, androidx.recyclerview.widget.RecyclerView$State):void");
    }

    public final void setEnableCenter(boolean z) {
        this.f7295ad = z;
    }
}
