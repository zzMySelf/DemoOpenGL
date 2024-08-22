package io.reactivex.disposables;

import com.baidu.android.common.others.lang.StringUtil;

public final class RunnableDisposable extends ReferenceDisposable<Runnable> {
    public static final long serialVersionUID = -8219729196779211169L;

    public RunnableDisposable(Runnable runnable) {
        super(runnable);
    }

    public String toString() {
        return "RunnableDisposable(disposed=" + isDisposed() + StringUtil.ARRAY_ELEMENT_SEPARATOR + get() + ")";
    }

    public void onDisposed(Runnable runnable) {
        runnable.run();
    }
}
