package com.baidu.swan.apps.trace;

import com.baidu.swan.apps.console.SwanAppLog;
import java.util.Locale;

public final class Index<ValueT> {
    public final String id;
    private ValueUpdater<ValueT> mUpdater;
    private ValueT mValue;

    public interface ValueUpdater<ValueT> {
        ValueT update() throws IllegalStateException;
    }

    Index(String id2) {
        this.id = id2;
        Tracer.get().regIndex(this);
    }

    public String toString() {
        return String.format(Locale.getDefault(), "%s :: %s(%s)", new Object[]{super.toString(), this.id, getFormatValue()});
    }

    public Index<ValueT> updater(ValueUpdater<ValueT> updater) {
        this.mUpdater = updater;
        update();
        return this;
    }

    public boolean update() {
        return update(this.mUpdater);
    }

    public boolean update(ValueUpdater<ValueT> updater) {
        if (updater == null) {
            return false;
        }
        try {
            return update(updater.update());
        } catch (IllegalStateException e2) {
            SwanAppLog.w(ITracer.LOG_TAG, "index update IllegalStateException " + e2.getMessage());
            return false;
        }
    }

    public boolean update(ValueT value) {
        this.mValue = value;
        Tracer.get().notifyCallbacks((Index<?>[]) new Index[]{this});
        return true;
    }

    public ValueT getValue() {
        return this.mValue;
    }

    public CharSequence getFormatValue() {
        ValueT valuet = this.mValue;
        return valuet == null ? "" : valuet.toString();
    }
}
