package kotlin.jvm.internal;

import androidx.lifecycle.SavedStateHandle;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\t\b&\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\u0013\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u0000¢\u0006\u0002\u0010\u0012J\b\u0010\u0003\u001a\u00020\u0004H\u0004J\u001d\u0010\u0013\u001a\u00028\u00002\u0006\u0010\u0014\u001a\u00028\u00002\u0006\u0010\u0015\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0016J\u0011\u0010\u0017\u001a\u00020\u0004*\u00028\u0000H$¢\u0006\u0002\u0010\u0018R\u001a\u0010\u0006\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0004¢\u0006\n\n\u0002\u0010\u000e\u0012\u0004\b\f\u0010\r¨\u0006\u0019"}, d2 = {"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "getSpreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k = 1, mv = {1, 6, 0}, xi = 48)
public abstract class PrimitiveSpreadBuilder<T> {
    public int position;
    public final int size;
    @NotNull
    public final T[] spreads;

    public PrimitiveSpreadBuilder(int i2) {
        this.size = i2;
        this.spreads = new Object[i2];
    }

    public static /* synthetic */ void getSpreads$annotations() {
    }

    public final void addSpread(@NotNull T t) {
        Intrinsics.checkNotNullParameter(t, "spreadArgument");
        T[] tArr = this.spreads;
        int i2 = this.position;
        this.position = i2 + 1;
        tArr[i2] = t;
    }

    public final int getPosition() {
        return this.position;
    }

    public abstract int getSize(@NotNull T t);

    public final void setPosition(int i2) {
        this.position = i2;
    }

    public final int size() {
        int i2 = this.size - 1;
        int i3 = 0;
        if (i2 >= 0) {
            int i4 = 0;
            while (true) {
                T t = this.spreads[i4];
                i3 += t != null ? getSize(t) : 1;
                if (i4 == i2) {
                    break;
                }
                i4++;
            }
        }
        return i3;
    }

    @NotNull
    public final T toArray(@NotNull T t, @NotNull T t2) {
        int i2;
        Intrinsics.checkNotNullParameter(t, SavedStateHandle.VALUES);
        Intrinsics.checkNotNullParameter(t2, "result");
        int i3 = this.size - 1;
        int i4 = 0;
        if (i3 >= 0) {
            int i5 = 0;
            int i6 = 0;
            i2 = 0;
            while (true) {
                T t3 = this.spreads[i5];
                if (t3 != null) {
                    if (i6 < i5) {
                        int i7 = i5 - i6;
                        System.arraycopy(t, i6, t2, i2, i7);
                        i2 += i7;
                    }
                    int size2 = getSize(t3);
                    System.arraycopy(t3, 0, t2, i2, size2);
                    i2 += size2;
                    i6 = i5 + 1;
                }
                if (i5 == i3) {
                    break;
                }
                i5++;
            }
            i4 = i6;
        } else {
            i2 = 0;
        }
        int i8 = this.size;
        if (i4 < i8) {
            System.arraycopy(t, i4, t2, i2, i8 - i4);
        }
        return t2;
    }
}
