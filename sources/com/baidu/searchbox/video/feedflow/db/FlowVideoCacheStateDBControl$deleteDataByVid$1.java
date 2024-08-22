package com.baidu.searchbox.video.feedflow.db;

import android.database.sqlite.SQLiteDatabase;
import com.baidu.searchbox.video.detail.db.SqlParams;
import com.baidu.searchbox.video.detail.db.VideoSQLiteTransaction;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/db/FlowVideoCacheStateDBControl$deleteDataByVid$1", "Lcom/baidu/searchbox/video/detail/db/VideoSQLiteTransaction;", "performTransaction", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoCacheStateDBControl.kt */
public final class FlowVideoCacheStateDBControl$deleteDataByVid$1 extends VideoSQLiteTransaction {
    final /* synthetic */ String $vid;
    final /* synthetic */ FlowVideoCacheStateDBControl this$0;

    FlowVideoCacheStateDBControl$deleteDataByVid$1(FlowVideoCacheStateDBControl $receiver, String $vid2) {
        this.this$0 = $receiver;
        this.$vid = $vid2;
    }

    /* access modifiers changed from: protected */
    public boolean performTransaction(SQLiteDatabase db) {
        Intrinsics.checkNotNullParameter(db, "db");
        try {
            SqlParams sqlParams = this.this$0.buildSQLParamsByVid(this.$vid);
            if (sqlParams == null) {
                return true;
            }
            db.delete("videoflow_cache_state", sqlParams.getCondition(), sqlParams.getWhereArray());
            return true;
        } catch (Exception e2) {
            return true;
        }
    }
}
