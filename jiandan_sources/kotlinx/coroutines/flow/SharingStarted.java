package kotlinx.coroutines.flow;

import i.qw.w1.d0;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\bæ\u0001\u0018\u0000 \b2\u00020\u0001:\u0001\bJ\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006H&¨\u0006\t"}, d2 = {"Lkotlinx/coroutines/flow/SharingStarted;", "", "command", "Lkotlinx/coroutines/flow/Flow;", "Lkotlinx/coroutines/flow/SharingCommand;", "subscriptionCount", "Lkotlinx/coroutines/flow/StateFlow;", "", "Companion", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface SharingStarted {
    @NotNull
    public static final qw qw = qw.qw;

    public static final class qw {
        @NotNull

        /* renamed from: ad  reason: collision with root package name */
        public static final SharingStarted f6414ad = new d0();
        @NotNull

        /* renamed from: de  reason: collision with root package name */
        public static final SharingStarted f6415de = new StartedLazily();
        public static final /* synthetic */ qw qw = new qw();

        @NotNull
        public final SharingStarted ad() {
            return f6415de;
        }

        @NotNull
        public final SharingStarted qw() {
            return f6414ad;
        }
    }

    @NotNull
    Flow<SharingCommand> qw(@NotNull StateFlow<Integer> stateFlow);
}
