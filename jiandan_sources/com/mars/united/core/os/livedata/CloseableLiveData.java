package com.mars.united.core.os.livedata;

import androidx.lifecycle.MutableLiveData;
import java.io.Closeable;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\u0004\u001a\u00020\u0005J\u0015\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"Lcom/mars/united/core/os/livedata/CloseableLiveData;", "T", "Landroidx/lifecycle/MutableLiveData;", "()V", "close", "", "setValue", "value", "(Ljava/lang/Object;)V", "core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
public final class CloseableLiveData<T> extends MutableLiveData<T> {
    public final void close() {
        Object value = getValue();
        if (value instanceof Closeable) {
            ((Closeable) value).close();
        }
    }

    public void setValue(T t) {
        Object value = getValue();
        super.setValue(t);
        if (value instanceof Closeable) {
            ((Closeable) value).close();
        }
    }
}
