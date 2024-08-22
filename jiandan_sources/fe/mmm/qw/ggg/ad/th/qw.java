package fe.mmm.qw.ggg.ad.th;

import org.jetbrains.annotations.NotNull;

public abstract class qw {
    @NotNull
    public abstract String getErrorMsg();

    public abstract int getErrorNo();

    @NotNull
    public abstract String getHeaderYme();

    @NotNull
    public abstract String getRequestId();

    public abstract boolean isSuccess();

    public abstract void setHeaderYme(@NotNull String str);
}
