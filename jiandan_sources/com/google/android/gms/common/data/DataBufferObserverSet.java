package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBufferObserver;
import java.util.HashSet;
import java.util.Iterator;

public final class DataBufferObserverSet implements DataBufferObserver, DataBufferObserver.Observable {
    public HashSet<DataBufferObserver> zalq = new HashSet<>();

    public final void addObserver(DataBufferObserver dataBufferObserver) {
        this.zalq.add(dataBufferObserver);
    }

    public final void clear() {
        this.zalq.clear();
    }

    public final boolean hasObservers() {
        return !this.zalq.isEmpty();
    }

    public final void onDataChanged() {
        Iterator<DataBufferObserver> it = this.zalq.iterator();
        while (it.hasNext()) {
            it.next().onDataChanged();
        }
    }

    public final void onDataRangeChanged(int i2, int i3) {
        Iterator<DataBufferObserver> it = this.zalq.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeChanged(i2, i3);
        }
    }

    public final void onDataRangeInserted(int i2, int i3) {
        Iterator<DataBufferObserver> it = this.zalq.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeInserted(i2, i3);
        }
    }

    public final void onDataRangeMoved(int i2, int i3, int i4) {
        Iterator<DataBufferObserver> it = this.zalq.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeMoved(i2, i3, i4);
        }
    }

    public final void onDataRangeRemoved(int i2, int i3) {
        Iterator<DataBufferObserver> it = this.zalq.iterator();
        while (it.hasNext()) {
            it.next().onDataRangeRemoved(i2, i3);
        }
    }

    public final void removeObserver(DataBufferObserver dataBufferObserver) {
        this.zalq.remove(dataBufferObserver);
    }
}
