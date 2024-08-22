package com.baidu.searchbox.feed.payment.model;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.searchbox.feed.db.SQLiteTransaction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/feed/payment/model/ObjectLocalDataSource$remove$1", "Lcom/baidu/searchbox/feed/db/SQLiteTransaction;", "performTransaction", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "lib-feed-payment_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: ObjectDao.kt */
public final class ObjectLocalDataSource$remove$1 extends SQLiteTransaction {
    final /* synthetic */ String $id;
    final /* synthetic */ Class<T> $type;

    ObjectLocalDataSource$remove$1(String $id2, Class<T> $type2) {
        this.$id = $id2;
        this.$type = $type2;
    }

    /* access modifiers changed from: protected */
    public boolean performTransaction(SQLiteDatabase db) {
        if (db == null) {
            return false;
        }
        db.delete("object_json", "id = ? and type = ?", new String[]{this.$id, this.$type.getName()});
        return true;
    }
}
