package io.reactivex.internal.disposables;

import io.reactivex.disposables.Disposable;

public interface DisposableContainer {
    boolean ad(Disposable disposable);

    boolean de(Disposable disposable);

    boolean qw(Disposable disposable);
}
