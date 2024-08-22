package com.mars.kotlin.extension;

import android.database.Cursor;
import com.mars.kotlin.extension.fp.Either;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.NotNull;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u00012\u00020\u0002J\u0010\u0010\u0004\u001a\u00020\u0003H\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t¸\u0006\u0000"}, d2 = {"com/mars/kotlin/extension/CursorKt$asSequence$1$1", "Ljava/util/Iterator;", "Lkotlin/jvm/internal/markers/KMappedMarker;", "", "hasNext", "()Z", "Landroid/database/Cursor;", "next", "()Landroid/database/Cursor;", "x_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class CursorKt$asSequence$$inlined$Sequence$1$lambda$1 implements Iterator<Cursor>, KMappedMarker {
    public final /* synthetic */ CursorKt$asSequence$$inlined$Sequence$1 this$0;

    public CursorKt$asSequence$$inlined$Sequence$1$lambda$1(CursorKt$asSequence$$inlined$Sequence$1 cursorKt$asSequence$$inlined$Sequence$1) {
        this.this$0 = cursorKt$asSequence$$inlined$Sequence$1;
    }

    public boolean hasNext() {
        Either either;
        try {
            either = ExpectKt.success(Boolean.valueOf(!this.this$0.$this_asSequence$inlined.isClosed() && this.this$0.$this_asSequence$inlined.getCount() > 0 && this.this$0.$this_asSequence$inlined.moveToNext()));
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
        return ((Boolean) ExpectKt.successOrDefault(either, Boolean.FALSE)).booleanValue();
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @NotNull
    public Cursor next() {
        return this.this$0.$this_asSequence$inlined;
    }
}
