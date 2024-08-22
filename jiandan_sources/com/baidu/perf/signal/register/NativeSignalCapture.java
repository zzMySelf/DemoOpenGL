package com.baidu.perf.signal.register;

import java.util.Iterator;
import java.util.LinkedList;

public class NativeSignalCapture {
    public static final LinkedList<OnNativeANRListener> sANRListeners = new LinkedList<>();
    public static final Object sANRMutex = new Object();
    public static final LinkedList<OnNativeExceptionListener> sExceptionListeners = new LinkedList<>();
    public static final Object sExceptionMutex = new Object();

    public static void addANRListener(OnNativeANRListener onNativeANRListener) {
        if (onNativeANRListener != null) {
            synchronized (sANRMutex) {
                sANRListeners.add(onNativeANRListener);
            }
        }
    }

    public static void addExceptionListener(OnNativeExceptionListener onNativeExceptionListener) {
        if (onNativeExceptionListener != null) {
            synchronized (sExceptionMutex) {
                sExceptionListeners.add(onNativeExceptionListener);
            }
        }
    }

    public static void clearANRListener() {
        synchronized (sANRMutex) {
            sANRListeners.clear();
        }
    }

    public static void clearExceptionListener() {
        synchronized (sExceptionMutex) {
            sExceptionListeners.clear();
        }
    }

    public static native int makeNativeCrash();

    public static final void onNativeANR(int i2) {
        if (sANRListeners != null) {
            synchronized (sANRMutex) {
                Iterator it = sANRListeners.iterator();
                while (it.hasNext()) {
                    ((OnNativeANRListener) it.next()).qw(i2);
                }
            }
        }
    }

    public static final void onNativeException(int i2, int i3, int i4) {
        if (sExceptionListeners != null) {
            synchronized (sExceptionMutex) {
                Iterator it = sExceptionListeners.iterator();
                while (it.hasNext()) {
                    ((OnNativeExceptionListener) it.next()).qw(i2, i3, i4);
                }
            }
        }
    }

    public static native int registerANR(int i2);

    public static native int registerException(int i2);

    public static void removeANRListener(OnNativeANRListener onNativeANRListener) {
        if (onNativeANRListener != null) {
            synchronized (sANRMutex) {
                sANRListeners.remove(onNativeANRListener);
            }
        }
    }

    public static void removeExceptionListener(OnNativeExceptionListener onNativeExceptionListener) {
        if (onNativeExceptionListener != null) {
            synchronized (sExceptionMutex) {
                sExceptionListeners.remove(onNativeExceptionListener);
            }
        }
    }

    public static native int unRegisterANR();

    public static native int unRegisterException();
}
