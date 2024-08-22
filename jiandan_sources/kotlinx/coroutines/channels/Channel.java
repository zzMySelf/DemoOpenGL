package kotlinx.coroutines.channels;

import com.tera.scan.widget.customrecyclerview.WrapperAdapter;
import i.qw.x1.d;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u0000 \u0004*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003:\u0001\u0004¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/channels/Channel;", "E", "Lkotlinx/coroutines/channels/SendChannel;", "Lkotlinx/coroutines/channels/ReceiveChannel;", "Factory", "kotlinx-coroutines-core"}, k = 1, mv = {1, 5, 1}, xi = 48)
public interface Channel<E> extends SendChannel<E>, ReceiveChannel<E> {
    @NotNull

    /* renamed from: rg  reason: collision with root package name */
    public static final qw f6350rg = qw.qw;

    public static final class qw {

        /* renamed from: ad  reason: collision with root package name */
        public static final int f6351ad = d.ad("kotlinx.coroutines.channels.defaultBuffer", 64, 1, WrapperAdapter.FOOTER);
        public static final /* synthetic */ qw qw = new qw();

        public final int qw() {
            return f6351ad;
        }
    }
}
