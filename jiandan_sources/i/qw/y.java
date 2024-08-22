package i.qw;

import kotlinx.coroutines.Incomplete;
import org.apache.commons.lang3.text.ExtendedMessageFormat;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public final class y implements Incomplete {

    /* renamed from: ad  reason: collision with root package name */
    public final boolean f6292ad;

    public y(boolean z) {
        this.f6292ad = z;
    }

    public boolean isActive() {
        return this.f6292ad;
    }

    @Nullable
    public a1 qw() {
        return null;
    }

    @NotNull
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Empty{");
        sb.append(isActive() ? "Active" : "New");
        sb.append(ExtendedMessageFormat.END_FE);
        return sb.toString();
    }
}
