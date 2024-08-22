package org.apache.commons.lang3.builder;

public final class IDKey {
    public final int id;
    public final Object value;

    public IDKey(Object obj) {
        this.id = System.identityHashCode(obj);
        this.value = obj;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof IDKey)) {
            return false;
        }
        IDKey iDKey = (IDKey) obj;
        if (this.id == iDKey.id && this.value == iDKey.value) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.id;
    }
}
