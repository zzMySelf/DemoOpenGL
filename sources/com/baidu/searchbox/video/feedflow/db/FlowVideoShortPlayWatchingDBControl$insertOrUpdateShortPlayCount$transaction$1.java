package com.baidu.searchbox.video.feedflow.db;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import com.baidu.searchbox.video.detail.db.VideoSQLiteTransaction;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0014¨\u0006\u0006"}, d2 = {"com/baidu/searchbox/video/feedflow/db/FlowVideoShortPlayWatchingDBControl$insertOrUpdateShortPlayCount$transaction$1", "Lcom/baidu/searchbox/video/detail/db/VideoSQLiteTransaction;", "performTransaction", "", "db", "Landroid/database/sqlite/SQLiteDatabase;", "lib-flow-component_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: FlowVideoShortPlayWatchingDBControl.kt */
public final class FlowVideoShortPlayWatchingDBControl$insertOrUpdateShortPlayCount$transaction$1 extends VideoSQLiteTransaction {
    final /* synthetic */ int $shortPlayCount;
    final /* synthetic */ FlowVideoShortPlayWatchingDBControl this$0;

    FlowVideoShortPlayWatchingDBControl$insertOrUpdateShortPlayCount$transaction$1(FlowVideoShortPlayWatchingDBControl $receiver, int $shortPlayCount2) {
        this.this$0 = $receiver;
        this.$shortPlayCount = $shortPlayCount2;
    }

    /* access modifiers changed from: protected */
    public boolean performTransaction(SQLiteDatabase db) {
        this.this$0.deleteOver30DaysData(db);
        ContentValues contentValues = this.this$0.buildShortPlayCountContentValues(this.$shortPlayCount);
        if (db == null) {
            return true;
        }
        db.insertWithOnConflict("videoflow_short_play_day_play_count", (String) null, contentValues, 5);
        return true;
    }
}
