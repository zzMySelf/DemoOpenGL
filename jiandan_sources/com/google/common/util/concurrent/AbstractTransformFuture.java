package com.google.common.util.concurrent;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.util.concurrent.FluentFuture;
import com.google.errorprone.annotations.ForOverride;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@GwtCompatible
public abstract class AbstractTransformFuture<I, O, F, T> extends FluentFuture.TrustedFuture<O> implements Runnable {
    @NullableDecl
    public F function;
    @NullableDecl
    public ListenableFuture<? extends I> inputFuture;

    public static final class AsyncTransformFuture<I, O> extends AbstractTransformFuture<I, O, AsyncFunction<? super I, ? extends O>, ListenableFuture<? extends O>> {
        public AsyncTransformFuture(ListenableFuture<? extends I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction) {
            super(listenableFuture, asyncFunction);
        }

        public ListenableFuture<? extends O> doTransform(AsyncFunction<? super I, ? extends O> asyncFunction, @NullableDecl I i2) throws Exception {
            ListenableFuture<? extends O> apply = asyncFunction.apply(i2);
            Preconditions.checkNotNull(apply, "AsyncFunction.apply returned null instead of a Future. Did you mean to return immediateFuture(null)? %s", (Object) asyncFunction);
            return apply;
        }

        public void setResult(ListenableFuture<? extends O> listenableFuture) {
            setFuture(listenableFuture);
        }
    }

    public static final class TransformFuture<I, O> extends AbstractTransformFuture<I, O, Function<? super I, ? extends O>, O> {
        public TransformFuture(ListenableFuture<? extends I> listenableFuture, Function<? super I, ? extends O> function) {
            super(listenableFuture, function);
        }

        public void setResult(@NullableDecl O o2) {
            set(o2);
        }

        @NullableDecl
        public O doTransform(Function<? super I, ? extends O> function, @NullableDecl I i2) {
            return function.apply(i2);
        }
    }

    public AbstractTransformFuture(ListenableFuture<? extends I> listenableFuture, F f) {
        this.inputFuture = (ListenableFuture) Preconditions.checkNotNull(listenableFuture);
        this.function = Preconditions.checkNotNull(f);
    }

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, AsyncFunction<? super I, ? extends O> asyncFunction, Executor executor) {
        Preconditions.checkNotNull(executor);
        AsyncTransformFuture asyncTransformFuture = new AsyncTransformFuture(listenableFuture, asyncFunction);
        listenableFuture.addListener(asyncTransformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, asyncTransformFuture));
        return asyncTransformFuture;
    }

    public final void afterDone() {
        maybePropagateCancellationTo(this.inputFuture);
        this.inputFuture = null;
        this.function = null;
    }

    @ForOverride
    @NullableDecl
    public abstract T doTransform(F f, @NullableDecl I i2) throws Exception;

    public String pendingToString() {
        String str;
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        String pendingToString = super.pendingToString();
        if (listenableFuture != null) {
            str = "inputFuture=[" + listenableFuture + "], ";
        } else {
            str = "";
        }
        if (f != null) {
            return str + "function=[" + f + "]";
        } else if (pendingToString == null) {
            return null;
        } else {
            return str + pendingToString;
        }
    }

    public final void run() {
        ListenableFuture<? extends I> listenableFuture = this.inputFuture;
        F f = this.function;
        boolean z = true;
        boolean isCancelled = isCancelled() | (listenableFuture == null);
        if (f != null) {
            z = false;
        }
        if (!isCancelled && !z) {
            this.inputFuture = null;
            if (listenableFuture.isCancelled()) {
                setFuture(listenableFuture);
                return;
            }
            try {
                try {
                    Object doTransform = doTransform(f, Futures.getDone(listenableFuture));
                    this.function = null;
                    setResult(doTransform);
                } catch (Throwable th2) {
                    this.function = null;
                    throw th2;
                }
            } catch (CancellationException unused) {
                cancel(false);
            } catch (ExecutionException e) {
                setException(e.getCause());
            } catch (RuntimeException e2) {
                setException(e2);
            } catch (Error e3) {
                setException(e3);
            }
        }
    }

    @ForOverride
    public abstract void setResult(@NullableDecl T t);

    public static <I, O> ListenableFuture<O> create(ListenableFuture<I> listenableFuture, Function<? super I, ? extends O> function2, Executor executor) {
        Preconditions.checkNotNull(function2);
        TransformFuture transformFuture = new TransformFuture(listenableFuture, function2);
        listenableFuture.addListener(transformFuture, MoreExecutors.rejectionPropagatingExecutor(executor, transformFuture));
        return transformFuture;
    }
}
