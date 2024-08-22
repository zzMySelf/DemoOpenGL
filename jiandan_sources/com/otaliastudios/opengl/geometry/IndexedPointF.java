package com.otaliastudios.opengl.geometry;

import android.graphics.PointF;
import kotlin.Metadata;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007¢\u0006\u0004\b\n\u0010\u000bR\u0019\u0010\u0003\u001a\u00020\u00028\u0006@\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/otaliastudios/opengl/geometry/IndexedPointF;", "Landroid/graphics/PointF;", "", "index", "I", "getIndex", "()I", "", "x", "y", "<init>", "(IFF)V", "egloo-metadata_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class IndexedPointF extends PointF {
    public final int index;

    public IndexedPointF(int i2, float f, float f2) {
        super(f, f2);
        this.index = i2;
    }

    public final int getIndex() {
        return this.index;
    }
}
