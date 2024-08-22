package org.sqlite.database.sqlite;

import java.io.Closeable;

public abstract class SQLiteClosable implements Closeable {
    public int mReferenceCount = 1;

    public void acquireReference() {
        synchronized (this) {
            if (this.mReferenceCount > 0) {
                this.mReferenceCount++;
            } else {
                throw new IllegalStateException("attempt to re-open an already-closed object: " + this);
            }
        }
    }

    public void close() {
        releaseReference();
    }

    public abstract void onAllReferencesReleased();

    @Deprecated
    public void onAllReferencesReleasedFromContainer() {
        onAllReferencesReleased();
    }

    public void releaseReference() {
        boolean z;
        synchronized (this) {
            z = true;
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            onAllReferencesReleased();
        }
    }

    @Deprecated
    public void releaseReferenceFromContainer() {
        boolean z;
        synchronized (this) {
            z = true;
            int i2 = this.mReferenceCount - 1;
            this.mReferenceCount = i2;
            if (i2 != 0) {
                z = false;
            }
        }
        if (z) {
            onAllReferencesReleasedFromContainer();
        }
    }
}
