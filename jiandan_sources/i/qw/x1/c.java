package i.qw.x1;

import kotlin.text.Typography;
import org.jetbrains.annotations.NotNull;

public final class c {
    @NotNull
    public final String qw;

    public c(@NotNull String str) {
        this.qw = str;
    }

    @NotNull
    public String toString() {
        return Typography.less + this.qw + Typography.greater;
    }
}
