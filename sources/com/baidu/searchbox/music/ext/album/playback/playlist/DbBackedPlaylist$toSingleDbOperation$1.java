package com.baidu.searchbox.music.ext.album.playback.playlist;

import android.util.Log;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.baidu.searchbox.music.ext.album.playback.playlist.DbBackedPlaylist;
import com.baidu.searchbox.music.ext.album.playback.playlist.diff.PlaylistDiffOperation;
import kotlin.Metadata;
import kotlin.jvm.internal.Ref;

@Metadata(d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016J\u0018\u0010\n\u001a\u00020\u00032\u0006\u0010\u000b\u001a\u00020\u00052\u0006\u0010\f\u001a\u00020\u0005H\u0016J\u0018\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0005H\u0016¨\u0006\u000e"}, d2 = {"com/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist$toSingleDbOperation$1", "Landroidx/recyclerview/widget/ListUpdateCallback;", "onChanged", "", "position", "", "count", "payload", "", "onInserted", "onMoved", "fromPosition", "toPosition", "onRemoved", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DbBackedPlaylist.kt */
public final class DbBackedPlaylist$toSingleDbOperation$1 implements ListUpdateCallback {
    final /* synthetic */ Ref.IntRef $numOperations;
    final /* synthetic */ Ref.ObjectRef<PlaylistDiffOperation> $operation;
    final /* synthetic */ DbBackedPlaylist this$0;

    DbBackedPlaylist$toSingleDbOperation$1(Ref.IntRef $numOperations2, Ref.ObjectRef<PlaylistDiffOperation> $operation2, DbBackedPlaylist $receiver) {
        this.$numOperations = $numOperations2;
        this.$operation = $operation2;
        this.this$0 = $receiver;
    }

    public void onInserted(int position, int count) {
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "onInserted(position=" + position + ", count=" + count + ')');
        }
        this.$numOperations.element++;
        this.$operation.element = new DbBackedPlaylist.InsertOperation(position, count);
    }

    public void onRemoved(int position, int count) {
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "onRemoved(position=" + position + ", count=" + count + ')');
        }
        this.$numOperations.element++;
        this.$operation.element = new DbBackedPlaylist.RemoveOperation(position, count);
    }

    public void onMoved(int fromPosition, int toPosition) {
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "onMoved(fromPosition=" + fromPosition + ", toPosition=" + toPosition + ')');
        }
        this.$numOperations.element++;
        this.$operation.element = new DbBackedPlaylist.MoveOperation(fromPosition, toPosition);
    }

    public void onChanged(int position, int count, Object payload) {
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "onChanged(position=" + position + ", count=" + count + ')');
        }
        this.$numOperations.element++;
    }
}
