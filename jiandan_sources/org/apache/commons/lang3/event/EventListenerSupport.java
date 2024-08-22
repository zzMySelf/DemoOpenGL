package org.apache.commons.lang3.event;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.apache.commons.lang3.Validate;

public class EventListenerSupport<L> implements Serializable {
    public static final long serialVersionUID = 3593265990380473632L;
    public List<L> listeners;
    public transient L[] prototypeArray;
    public transient L proxy;

    public class ProxyInvocationHandler implements InvocationHandler {
        public ProxyInvocationHandler() {
        }

        public Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
            for (Object invoke : EventListenerSupport.this.listeners) {
                method.invoke(invoke, objArr);
            }
            return null;
        }
    }

    public EventListenerSupport(Class<L> cls) {
        this(cls, Thread.currentThread().getContextClassLoader());
    }

    public static <T> EventListenerSupport<T> create(Class<T> cls) {
        return new EventListenerSupport<>(cls);
    }

    private void createProxy(Class<L> cls, ClassLoader classLoader) {
        this.proxy = cls.cast(Proxy.newProxyInstance(classLoader, new Class[]{cls}, createInvocationHandler()));
    }

    private void initializeTransientFields(Class<L> cls, ClassLoader classLoader) {
        this.prototypeArray = (Object[]) Array.newInstance(cls, 0);
        createProxy(cls, classLoader);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        Object[] objArr = (Object[]) objectInputStream.readObject();
        this.listeners = new CopyOnWriteArrayList(objArr);
        initializeTransientFields(objArr.getClass().getComponentType(), Thread.currentThread().getContextClassLoader());
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        ArrayList arrayList = new ArrayList();
        ObjectOutputStream objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
        for (L next : this.listeners) {
            try {
                objectOutputStream2.writeObject(next);
                arrayList.add(next);
            } catch (IOException unused) {
                objectOutputStream2 = new ObjectOutputStream(new ByteArrayOutputStream());
            }
        }
        objectOutputStream.writeObject(arrayList.toArray(this.prototypeArray));
    }

    public void addListener(L l) {
        addListener(l, true);
    }

    public InvocationHandler createInvocationHandler() {
        return new ProxyInvocationHandler();
    }

    public L fire() {
        return this.proxy;
    }

    public int getListenerCount() {
        return this.listeners.size();
    }

    public L[] getListeners() {
        return this.listeners.toArray(this.prototypeArray);
    }

    public void removeListener(L l) {
        Validate.notNull(l, "Listener object cannot be null.", new Object[0]);
        this.listeners.remove(l);
    }

    public EventListenerSupport(Class<L> cls, ClassLoader classLoader) {
        this();
        Validate.notNull(cls, "Listener interface cannot be null.", new Object[0]);
        Validate.notNull(classLoader, "ClassLoader cannot be null.", new Object[0]);
        Validate.isTrue(cls.isInterface(), "Class {0} is not an interface", cls.getName());
        initializeTransientFields(cls, classLoader);
    }

    public void addListener(L l, boolean z) {
        Validate.notNull(l, "Listener object cannot be null.", new Object[0]);
        if (z) {
            this.listeners.add(l);
        } else if (!this.listeners.contains(l)) {
            this.listeners.add(l);
        }
    }

    public EventListenerSupport() {
        this.listeners = new CopyOnWriteArrayList();
    }
}
