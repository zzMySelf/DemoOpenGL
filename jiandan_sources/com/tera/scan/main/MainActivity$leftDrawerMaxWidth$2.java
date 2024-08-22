package com.tera.scan.main;

import com.baidu.aiscan.R;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"<anonymous>", "", "invoke", "()Ljava/lang/Integer;"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class MainActivity$leftDrawerMaxWidth$2 extends Lambda implements Function0<Integer> {
    public final /* synthetic */ MainActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public MainActivity$leftDrawerMaxWidth$2(MainActivity mainActivity) {
        super(0);
        this.this$0 = mainActivity;
    }

    @NotNull
    public final Integer invoke() {
        return Integer.valueOf(this.this$0.getResources().getDimensionPixelOffset(R.dimen.left_drawer_max_width));
    }
}
