package org.apache.commons.lang3.mutable;

import com.baidu.android.common.others.lang.StringUtil;
import java.io.Serializable;

public class MutableObject<T> implements Mutable<T>, Serializable {
    public static final long serialVersionUID = 86241875189L;
    public T value;

    public MutableObject() {
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (MutableObject.class == obj.getClass()) {
            return this.value.equals(((MutableObject) obj).value);
        }
        return false;
    }

    public T getValue() {
        return this.value;
    }

    public int hashCode() {
        T t = this.value;
        if (t == null) {
            return 0;
        }
        return t.hashCode();
    }

    public void setValue(T t) {
        this.value = t;
    }

    public String toString() {
        T t = this.value;
        return t == null ? StringUtil.NULL_STRING : t.toString();
    }

    public MutableObject(T t) {
        this.value = t;
    }
}
