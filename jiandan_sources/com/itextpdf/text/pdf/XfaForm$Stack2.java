package com.itextpdf.text.pdf;

import java.util.ArrayList;
import java.util.EmptyStackException;

public class XfaForm$Stack2<T> extends ArrayList<T> {
    public static final long serialVersionUID = -7451476576174095212L;

    public boolean empty() {
        return size() == 0;
    }

    public T peek() {
        if (size() != 0) {
            return get(size() - 1);
        }
        throw new EmptyStackException();
    }

    public T pop() {
        if (size() != 0) {
            T t = get(size() - 1);
            remove(size() - 1);
            return t;
        }
        throw new EmptyStackException();
    }

    public T push(T t) {
        add(t);
        return t;
    }
}
