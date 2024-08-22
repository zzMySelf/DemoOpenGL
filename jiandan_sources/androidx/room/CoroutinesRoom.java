package androidx.room;

import androidx.annotation.RestrictTo;
import i.qw.o;
import i.qw.w1.de;
import java.util.concurrent.Callable;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.ContinuationInterceptor;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.flow.Flow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u0003:\u0001\u0003B\t\b\u0002¢\u0006\u0004\b\u0001\u0010\u0002¨\u0006\u0004"}, d2 = {"Landroidx/room/CoroutinesRoom;", "<init>", "()V", "Companion", "room-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0003\u0018\u0000B\t\b\u0002¢\u0006\u0004\b\u0011\u0010\u0012JL\u0010\r\u001a\r\u0012\t\u0012\u00078\u0000¢\u0006\u0002\b\f0\u000b\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH\u0007¢\u0006\u0004\b\r\u0010\u000eJ7\u0010\u000f\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\tH@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010\u0002\u0004\n\u0002\b\u0019¨\u0006\u0013"}, d2 = {"Landroidx/room/CoroutinesRoom$Companion;", "R", "Landroidx/room/RoomDatabase;", "db", "", "inTransaction", "", "", "tableNames", "Ljava/util/concurrent/Callable;", "callable", "Lkotlinx/coroutines/flow/Flow;", "Lkotlin/jvm/JvmSuppressWildcards;", "createFlow", "(Landroidx/room/RoomDatabase;Z[Ljava/lang/String;Ljava/util/concurrent/Callable;)Lkotlinx/coroutines/flow/Flow;", "execute", "(Landroidx/room/RoomDatabase;ZLjava/util/concurrent/Callable;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "<init>", "()V", "room-ktx_release"}, k = 1, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
    public static final class Companion {
        public Companion() {
        }

        @JvmStatic
        @NotNull
        public final <R> Flow<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull String[] strArr, @NotNull Callable<R> callable) {
            return de.xxx(new CoroutinesRoom$Companion$createFlow$1(strArr, z, roomDatabase, callable, (Continuation) null));
        }

        @JvmStatic
        @Nullable
        public final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
            ContinuationInterceptor continuationInterceptor;
            if (roomDatabase.isOpen() && roomDatabase.inTransaction()) {
                return callable.call();
            }
            TransactionElement transactionElement = (TransactionElement) continuation.getContext().get(TransactionElement.Key);
            if (transactionElement == null || (continuationInterceptor = transactionElement.getTransactionDispatcher$room_ktx_release()) == null) {
                continuationInterceptor = z ? CoroutinesRoomKt.getTransactionDispatcher(roomDatabase) : CoroutinesRoomKt.getQueryDispatcher(roomDatabase);
            }
            return o.yj(continuationInterceptor, new CoroutinesRoom$Companion$execute$2(callable, (Continuation) null), continuation);
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    @JvmStatic
    @NotNull
    public static final <R> Flow<R> createFlow(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull String[] strArr, @NotNull Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z, strArr, callable);
    }

    @JvmStatic
    @Nullable
    public static final <R> Object execute(@NotNull RoomDatabase roomDatabase, boolean z, @NotNull Callable<R> callable, @NotNull Continuation<? super R> continuation) {
        return Companion.execute(roomDatabase, z, callable, continuation);
    }
}
