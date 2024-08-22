package com.facebook.imagepipeline.memory;

import com.facebook.common.internal.Preconditions;
import com.facebook.common.references.OOMSoftReference;
import java.util.LinkedList;
import javax.annotation.Nullable;

class OOMSoftReferenceBucket<V> extends Bucket<V> {
    private LinkedList<OOMSoftReference<V>> mSpareReferences = new LinkedList<>();

    public OOMSoftReferenceBucket(int itemSize, int maxLength, int inUseLength) {
        super(itemSize, maxLength, inUseLength, false);
    }

    @Nullable
    public V pop() {
        OOMSoftReference<V> ref = (OOMSoftReference) this.mFreeList.poll();
        Preconditions.checkNotNull(ref);
        V value = ref.get();
        ref.clear();
        this.mSpareReferences.add(ref);
        return value;
    }

    /* access modifiers changed from: package-private */
    public void addToFreeList(V value) {
        OOMSoftReference<V> ref = this.mSpareReferences.poll();
        if (ref == null) {
            ref = new OOMSoftReference<>();
        }
        ref.set(value);
        this.mFreeList.add(ref);
    }
}
