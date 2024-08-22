package com.squareup.sqldelight;

import com.squareup.sqldelight.Transacter;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\u0016\u0010\r\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\fH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0015\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0011J2\u0010\u0004\u001a\u0002H\u0001\"\u0004\b\u0001\u0010\u00012\u001d\u0010\u0012\u001a\u0019\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u0003\u0012\u0004\u0012\u0002H\u00010\u0013¢\u0006\u0002\b\u0014H\u0016¢\u0006\u0002\u0010\u0015J!\u0010\u0004\u001a\u00020\n2\u0017\u0010\u0012\u001a\u0013\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\n0\u0013¢\u0006\u0002\b\u0014H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u0016"}, d2 = {"Lcom/squareup/sqldelight/TransactionWrapper;", "R", "Lcom/squareup/sqldelight/TransactionWithoutReturn;", "Lcom/squareup/sqldelight/TransactionWithReturn;", "transaction", "Lcom/squareup/sqldelight/Transacter$Transaction;", "(Lcom/squareup/sqldelight/Transacter$Transaction;)V", "getTransaction", "()Lcom/squareup/sqldelight/Transacter$Transaction;", "afterCommit", "", "function", "Lkotlin/Function0;", "afterRollback", "rollback", "", "returnValue", "(Ljava/lang/Object;)Ljava/lang/Void;", "body", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "runtime"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* compiled from: Transacter.kt */
final class TransactionWrapper<R> implements TransactionWithoutReturn, TransactionWithReturn<R> {
    private final Transacter.Transaction transaction;

    public TransactionWrapper(Transacter.Transaction transaction2) {
        Intrinsics.checkNotNullParameter(transaction2, "transaction");
        this.transaction = transaction2;
    }

    public final Transacter.Transaction getTransaction() {
        return this.transaction;
    }

    public Void rollback() {
        this.transaction.checkThreadConfinement$runtime();
        throw new RollbackException((Object) null, 1, (DefaultConstructorMarker) null);
    }

    public Void rollback(R returnValue) {
        this.transaction.checkThreadConfinement$runtime();
        throw new RollbackException(returnValue);
    }

    public void afterCommit(Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.transaction.afterCommit(function);
    }

    public void afterRollback(Function0<Unit> function) {
        Intrinsics.checkNotNullParameter(function, "function");
        this.transaction.afterRollback(function);
    }

    /* renamed from: transaction  reason: collision with other method in class */
    public void m8204transaction(Function1<? super TransactionWithoutReturn, Unit> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Transacter transacter$runtime = this.transaction.getTransacter$runtime();
        Intrinsics.checkNotNull(transacter$runtime);
        transacter$runtime.transaction(false, body);
    }

    public <R> R transaction(Function1<? super TransactionWithReturn<R>, ? extends R> body) {
        Intrinsics.checkNotNullParameter(body, "body");
        Transacter transacter$runtime = this.transaction.getTransacter$runtime();
        Intrinsics.checkNotNull(transacter$runtime);
        return transacter$runtime.transactionWithResult(false, body);
    }
}
