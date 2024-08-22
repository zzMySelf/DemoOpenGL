package uk.qw.qw;

import java.util.function.Supplier;
import kotlin.sequences.Sequence;
import kotlin.streams.jdk8.StreamsKt;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Supplier {
    public final /* synthetic */ Sequence qw;

    public /* synthetic */ qw(Sequence sequence) {
        this.qw = sequence;
    }

    public final Object get() {
        return StreamsKt.m495asStream$lambda4(this.qw);
    }
}
