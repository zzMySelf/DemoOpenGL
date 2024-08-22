package com.mars.united.core.os.pagedata;

import android.content.ContentResolver;
import fe.ggg.ad.qw.de.yj.ad.de;
import fe.ggg.ad.qw.de.yj.qw.qw;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\n"}, d2 = {"<anonymous>", "Lcom/mars/united/core/os/pagedata/data/DataVersion;", "T", "it", ""}, k = 3, mv = {1, 5, 1}, xi = 48)
public final class PageDataFactory$build$obtainVersion$1 extends Lambda implements Function1<Integer, qw> {
    public final /* synthetic */ ContentResolver $contentResolver;
    public final /* synthetic */ de $query;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PageDataFactory$build$obtainVersion$1(de deVar, ContentResolver contentResolver) {
        super(1);
        this.$query = deVar;
        this.$contentResolver = contentResolver;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return invoke(((Number) obj).intValue());
    }

    @NotNull
    public final qw invoke(int i2) {
        this.$query.qw(this.$contentResolver, i2);
        throw null;
    }
}
