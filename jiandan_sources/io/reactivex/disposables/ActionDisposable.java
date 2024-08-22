package io.reactivex.disposables;

import io.reactivex.functions.Action;
import io.reactivex.internal.util.ExceptionHelper;

public final class ActionDisposable extends ReferenceDisposable<Action> {
    public static final long serialVersionUID = -8219729196779211169L;

    public ActionDisposable(Action action) {
        super(action);
    }

    public void onDisposed(Action action) {
        try {
            action.run();
        } catch (Throwable th2) {
            throw ExceptionHelper.fe(th2);
        }
    }
}
