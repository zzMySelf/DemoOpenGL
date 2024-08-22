package th.de.o;

import io.reactivex.internal.util.ExceptionHelper;

public final class qw {
    public static void ad(Throwable th2) {
        if (th2 instanceof VirtualMachineError) {
            throw ((VirtualMachineError) th2);
        } else if (th2 instanceof ThreadDeath) {
            throw ((ThreadDeath) th2);
        } else if (th2 instanceof LinkageError) {
            throw ((LinkageError) th2);
        }
    }

    public static RuntimeException qw(Throwable th2) {
        throw ExceptionHelper.fe(th2);
    }
}
