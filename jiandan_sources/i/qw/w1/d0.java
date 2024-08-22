package i.qw.w1;

import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.SharingCommand;
import kotlinx.coroutines.flow.SharingStarted;
import kotlinx.coroutines.flow.StateFlow;
import org.jetbrains.annotations.NotNull;

public final class d0 implements SharingStarted {
    @NotNull
    public Flow<SharingCommand> qw(@NotNull StateFlow<Integer> stateFlow) {
        return de.ddd(SharingCommand.START);
    }

    @NotNull
    public String toString() {
        return "SharingStarted.Eagerly";
    }
}
