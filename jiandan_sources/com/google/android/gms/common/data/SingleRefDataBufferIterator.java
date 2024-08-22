package com.google.android.gms.common.data;

import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.NoSuchElementException;

@KeepForSdk
public class SingleRefDataBufferIterator<T> extends DataBufferIterator<T> {
    public T zams;

    public SingleRefDataBufferIterator(DataBuffer<T> dataBuffer) {
        super(dataBuffer);
    }

    public T next() {
        if (hasNext()) {
            int i2 = this.zalo + 1;
            this.zalo = i2;
            if (i2 == 0) {
                T t = this.zaln.get(0);
                this.zams = t;
                if (!(t instanceof DataBufferRef)) {
                    String valueOf = String.valueOf(this.zams.getClass());
                    StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 44);
                    sb.append("DataBuffer reference of type ");
                    sb.append(valueOf);
                    sb.append(" is not movable");
                    throw new IllegalStateException(sb.toString());
                }
            } else {
                ((DataBufferRef) this.zams).zag(i2);
            }
            return this.zams;
        }
        int i3 = this.zalo;
        StringBuilder sb2 = new StringBuilder(46);
        sb2.append("Cannot advance the iterator beyond ");
        sb2.append(i3);
        throw new NoSuchElementException(sb2.toString());
    }
}
