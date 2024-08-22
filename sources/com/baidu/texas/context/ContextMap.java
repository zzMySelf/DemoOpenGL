package com.baidu.texas.context;

public interface ContextMap<Key> {

    public interface EntryConsumer<Key> {
        void accept(Key key, Object obj);
    }

    public interface Manipulation<Key> {
        boolean manipulate(ContextMap<Key> contextMap, Key key, Object obj, Object obj2);
    }

    boolean containsUserData(Key key);

    void forEachUserData(EntryConsumer<Key> entryConsumer);

    <T> T getUserData(Key key, T t);

    boolean manipulateUserData(Key key, Object obj, Object obj2, Manipulation<Key> manipulation);

    Object putUserData(Key key, Object obj);

    Object removeUserData(Key key);

    int sizeOfUserData();
}
