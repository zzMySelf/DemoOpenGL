package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.reflect.ClassPath;
import java.io.Closeable;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtIncompatible
public class FinalizableReferenceQueue implements Closeable {
    public static final String FINALIZER_CLASS_NAME = "com.google.common.base.internal.Finalizer";
    public static final Logger logger = Logger.getLogger(FinalizableReferenceQueue.class.getName());
    public static final Method startFinalizer = getStartFinalizer(loadFinalizer(new SystemLoader(), new DecoupledLoader(), new DirectLoader()));
    public final PhantomReference<Object> frqRef;
    public final ReferenceQueue<Object> queue = new ReferenceQueue<>();
    public final boolean threadStarted;

    public static class DecoupledLoader implements FinalizerLoader {
        public static final String LOADING_ERROR = "Could not load Finalizer in its own class loader. Loading Finalizer in the current class loader instead. As a result, you will not be able to garbage collect this class loader. To support reclaiming this class loader, either resolve the underlying issue, or move Guava to your system class path.";

        public URL getBaseUrl() throws IOException {
            String str = FinalizableReferenceQueue.FINALIZER_CLASS_NAME.replace('.', '/') + ClassPath.CLASS_FILE_NAME_EXTENSION;
            URL resource = DecoupledLoader.class.getClassLoader().getResource(str);
            if (resource != null) {
                String url = resource.toString();
                if (url.endsWith(str)) {
                    return new URL(resource, url.substring(0, url.length() - str.length()));
                }
                throw new IOException("Unsupported path style: " + url);
            }
            throw new FileNotFoundException(str);
        }

        @NullableDecl
        public Class<?> loadFinalizer() {
            try {
                return newLoader(getBaseUrl()).loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
            } catch (Exception e) {
                FinalizableReferenceQueue.logger.log(Level.WARNING, LOADING_ERROR, e);
                return null;
            }
        }

        public URLClassLoader newLoader(URL url) {
            return new URLClassLoader(new URL[]{url}, (ClassLoader) null);
        }
    }

    public static class DirectLoader implements FinalizerLoader {
        public Class<?> loadFinalizer() {
            try {
                return Class.forName(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
            } catch (ClassNotFoundException e) {
                throw new AssertionError(e);
            }
        }
    }

    public interface FinalizerLoader {
        @NullableDecl
        Class<?> loadFinalizer();
    }

    public static class SystemLoader implements FinalizerLoader {
        @VisibleForTesting
        public static boolean disabled;

        @NullableDecl
        public Class<?> loadFinalizer() {
            if (disabled) {
                return null;
            }
            try {
                ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
                if (systemClassLoader != null) {
                    try {
                        return systemClassLoader.loadClass(FinalizableReferenceQueue.FINALIZER_CLASS_NAME);
                    } catch (ClassNotFoundException unused) {
                    }
                }
                return null;
            } catch (SecurityException unused2) {
                FinalizableReferenceQueue.logger.info("Not allowed to access system class loader.");
                return null;
            }
        }
    }

    public FinalizableReferenceQueue() {
        PhantomReference<Object> phantomReference = new PhantomReference<>(this, this.queue);
        this.frqRef = phantomReference;
        boolean z = true;
        try {
            startFinalizer.invoke((Object) null, new Object[]{FinalizableReference.class, this.queue, phantomReference});
        } catch (IllegalAccessException e) {
            throw new AssertionError(e);
        } catch (Throwable th2) {
            logger.log(Level.INFO, "Failed to start reference finalizer thread. Reference cleanup will only occur when new references are created.", th2);
            z = false;
        }
        this.threadStarted = z;
    }

    public static Method getStartFinalizer(Class<?> cls) {
        try {
            return cls.getMethod("startFinalizer", new Class[]{Class.class, ReferenceQueue.class, PhantomReference.class});
        } catch (NoSuchMethodException e) {
            throw new AssertionError(e);
        }
    }

    public static Class<?> loadFinalizer(FinalizerLoader... finalizerLoaderArr) {
        for (FinalizerLoader loadFinalizer : finalizerLoaderArr) {
            Class<?> loadFinalizer2 = loadFinalizer.loadFinalizer();
            if (loadFinalizer2 != null) {
                return loadFinalizer2;
            }
        }
        throw new AssertionError();
    }

    public void cleanUp() {
        if (!this.threadStarted) {
            while (true) {
                Reference<? extends Object> poll = this.queue.poll();
                if (poll != null) {
                    poll.clear();
                    try {
                        ((FinalizableReference) poll).finalizeReferent();
                    } catch (Throwable th2) {
                        logger.log(Level.SEVERE, "Error cleaning up after reference.", th2);
                    }
                } else {
                    return;
                }
            }
        }
    }

    public void close() {
        this.frqRef.enqueue();
        cleanUp();
    }
}
