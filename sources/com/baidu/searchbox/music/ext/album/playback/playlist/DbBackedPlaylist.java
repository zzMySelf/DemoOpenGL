package com.baidu.searchbox.music.ext.album.playback.playlist;

import android.util.Log;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListUpdateCallback;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.music.ext.album.playback.playlist.db.PlaylistDao;
import com.baidu.searchbox.music.ext.album.playback.playlist.diff.PlaylistDiffCallback;
import com.baidu.searchbox.music.ext.album.playback.playlist.diff.PlaylistDiffOperation;
import com.baidu.searchbox.music.ext.model.ISong;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import rx.Single;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0003&'(B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0017J\b\u0010\u0014\u001a\u00020\u0015H\u0017J\u0014\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\u0013H\u0017J\u0016\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0006\u0010\u0018\u001a\u00020\u0005H\u0017J*\u0010\u0019\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u0013\"\u0004\b\u0000\u0010\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u0002H\u001a0\u001eH\u0002J\u001e\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00150\u001eH\u0002J\u001e\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u000e\u0010!\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\tH\u0017J\u0014\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010$\u001a\u0004\u0018\u00010%H\u0002R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R*\u0010\u0006\u001a\u001e\u0012\u0018\u0012\u0016\u0012\u0012\u0012\u0010\u0012\f\b\u0000\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b0\u0007\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8BX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006)"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist;", "Lcom/baidu/searchbox/music/ext/album/playback/playlist/IPlaylist;", "()V", "currSongList", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "dbSongSubs", "Ljava/lang/ref/WeakReference;", "Lrx/SingleSubscriber;", "", "hasInitDb", "", "playlistDao", "Lcom/baidu/searchbox/music/ext/album/playback/playlist/db/PlaylistDao;", "getPlaylistDao", "()Lcom/baidu/searchbox/music/ext/album/playback/playlist/db/PlaylistDao;", "playlistDao$delegate", "Lkotlin/Lazy;", "clearSongs", "Lrx/Single;", "close", "", "getSongList", "removeSong", "song", "runRxSerial", "R", "name", "", "block", "Lkotlin/Function0;", "runSerial", "setSongList", "newSongList", "toSingleDbOperation", "Lcom/baidu/searchbox/music/ext/album/playback/playlist/diff/PlaylistDiffOperation;", "result", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "InsertOperation", "MoveOperation", "RemoveOperation", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: DbBackedPlaylist.kt */
public final class DbBackedPlaylist implements IPlaylist {
    private final List<ISong> currSongList = new ArrayList();
    private List<WeakReference<SingleSubscriber<? super List<? extends ISong>>>> dbSongSubs;
    private boolean hasInitDb;
    private final Lazy playlistDao$delegate = LazyKt.lazy(DbBackedPlaylist$playlistDao$2.INSTANCE);

    /* access modifiers changed from: private */
    public final PlaylistDao getPlaylistDao() {
        return (PlaylistDao) this.playlistDao$delegate.getValue();
    }

    public Single<List<ISong>> getSongList() {
        Single<List<ISong>> single;
        if (this.hasInitDb) {
            if (DbBackedPlaylistKt.DEBUG) {
                Log.d("PlaylistManager", "getSongList from memory");
            }
            Single<List<ISong>> just = Single.just(this.currSongList);
            Intrinsics.checkNotNullExpressionValue(just, "{\n            if (DEBUG)…t(currSongList)\n        }");
            return just;
        }
        List subs = this.dbSongSubs;
        if (subs != null) {
            if (DbBackedPlaylistKt.DEBUG) {
                Log.d("PlaylistManager", "already getting from DB, just add subscribers");
            }
            single = Single.create(new DbBackedPlaylist$$ExternalSyntheticLambda4(subs));
        } else {
            single = null;
        }
        if (single != null) {
            return single;
        }
        DbBackedPlaylist $this$getSongList_u24lambda_u2d6 = this;
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "getSongList from DB");
        }
        $this$getSongList_u24lambda_u2d6.dbSongSubs = new ArrayList();
        Single<List<ISong>> map = $this$getSongList_u24lambda_u2d6.runRxSerial("PlaylistManager#getSongList", new DbBackedPlaylist$getSongList$2$1($this$getSongList_u24lambda_u2d6)).observeOn(AndroidSchedulers.mainThread()).onErrorReturn(new DbBackedPlaylist$$ExternalSyntheticLambda5($this$getSongList_u24lambda_u2d6)).map(new DbBackedPlaylist$$ExternalSyntheticLambda6($this$getSongList_u24lambda_u2d6));
        Intrinsics.checkNotNullExpressionValue(map, "run {\n                if…          }\n            }");
        return map;
    }

    /* access modifiers changed from: private */
    /* renamed from: getSongList$lambda-1$lambda-0  reason: not valid java name */
    public static final void m824getSongList$lambda1$lambda0(List $subs, SingleSubscriber it) {
        Intrinsics.checkNotNullParameter($subs, "$subs");
        $subs.add(new WeakReference(it));
    }

    /* access modifiers changed from: private */
    /* renamed from: getSongList$lambda-6$lambda-2  reason: not valid java name */
    public static final List m825getSongList$lambda6$lambda2(DbBackedPlaylist $this_run, Throwable it) {
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        return CollectionsKt.toList($this_run.currSongList);
    }

    /* access modifiers changed from: private */
    /* renamed from: getSongList$lambda-6$lambda-5  reason: not valid java name */
    public static final List m826getSongList$lambda6$lambda5(DbBackedPlaylist $this_run, List dbSongs) {
        Intrinsics.checkNotNullParameter($this_run, "$this_run");
        $this_run.hasInitDb = true;
        $this_run.currSongList.clear();
        List<ISong> list = $this_run.currSongList;
        Intrinsics.checkNotNullExpressionValue(dbSongs, "dbSongs");
        list.addAll(dbSongs);
        List<WeakReference<SingleSubscriber<? super List<? extends ISong>>>> $this$forEach$iv = $this_run.dbSongSubs;
        if ($this$forEach$iv != null) {
            for (WeakReference it : $this$forEach$iv) {
                SingleSubscriber $this$getSongList_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3 = (SingleSubscriber) it.get();
                if ($this$getSongList_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3 != null && !$this$getSongList_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.isUnsubscribed()) {
                    $this$getSongList_u24lambda_u2d6_u24lambda_u2d5_u24lambda_u2d4_u24lambda_u2d3.onSuccess($this_run.currSongList);
                }
            }
        }
        $this_run.dbSongSubs = null;
        return $this_run.currSongList;
    }

    public Single<Boolean> setSongList(List<? extends ISong> newSongList) {
        List newList;
        PlaylistDiffOperation operation = null;
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "setSongList " + (newSongList != null ? Integer.valueOf(newSongList.size()) : null));
        }
        if (Intrinsics.areEqual((Object) this.currSongList, (Object) newSongList)) {
            if (DbBackedPlaylistKt.DEBUG) {
                Log.d("PlaylistManager", "all songs are the same, ignore setSongList");
            }
            Single<Boolean> just = Single.just(true);
            Intrinsics.checkNotNullExpressionValue(just, "just(true)");
            return just;
        }
        List oldList = CollectionsKt.toList(this.currSongList);
        if (newSongList == null || (newList = CollectionsKt.toList(newSongList)) == null) {
            newList = CollectionsKt.emptyList();
        }
        if (!newList.isEmpty()) {
            operation = toSingleDbOperation(DiffUtil.calculateDiff(new PlaylistDiffCallback(oldList, newList), true));
        }
        this.currSongList.clear();
        this.currSongList.addAll(newList);
        Single<Boolean> create = Single.create(new DbBackedPlaylist$$ExternalSyntheticLambda1(this, operation, newList, oldList));
        Intrinsics.checkNotNullExpressionValue(create, "create {\n            run…)\n            }\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: setSongList$lambda-7  reason: not valid java name */
    public static final void m831setSongList$lambda7(DbBackedPlaylist this$0, PlaylistDiffOperation $operation, List $newList, List $oldList, SingleSubscriber it) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter($newList, "$newList");
        Intrinsics.checkNotNullParameter($oldList, "$oldList");
        this$0.runSerial("PlaylistManager#setSongList", new DbBackedPlaylist$setSongList$1$1($operation, $newList, $oldList, this$0, it));
    }

    private final PlaylistDiffOperation toSingleDbOperation(DiffUtil.DiffResult result) {
        Ref.IntRef numOperations = new Ref.IntRef();
        Ref.ObjectRef operation = new Ref.ObjectRef();
        if (result != null) {
            result.dispatchUpdatesTo((ListUpdateCallback) new DbBackedPlaylist$toSingleDbOperation$1(numOperations, operation, this));
        }
        if (numOperations.element != 1) {
            return null;
        }
        return (PlaylistDiffOperation) operation.element;
    }

    public Single<Boolean> removeSong(ISong song) {
        Intrinsics.checkNotNullParameter(song, "song");
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "removeSong " + song);
        }
        if (this.currSongList.remove(song)) {
            Single<Boolean> map = runRxSerial("PlaylistManager#removeSong", new DbBackedPlaylist$removeSong$1(this, song)).observeOn(AndroidSchedulers.mainThread()).map(new DbBackedPlaylist$$ExternalSyntheticLambda8());
            Intrinsics.checkNotNullExpressionValue(map, "@MainThread\n    override…e Single.just(true)\n    }");
            return map;
        }
        Single<Boolean> just = Single.just(true);
        Intrinsics.checkNotNullExpressionValue(just, "just(true)");
        return just;
    }

    /* access modifiers changed from: private */
    /* renamed from: removeSong$lambda-8  reason: not valid java name */
    public static final Boolean m827removeSong$lambda8(Boolean it) {
        return true;
    }

    public Single<Boolean> clearSongs() {
        if (DbBackedPlaylistKt.DEBUG) {
            Log.d("PlaylistManager", "clearSongs");
        }
        if (!this.currSongList.isEmpty()) {
            this.currSongList.clear();
            Single<Boolean> map = runRxSerial("PlaylistManager#clearSongs", new DbBackedPlaylist$clearSongs$1(this)).observeOn(AndroidSchedulers.mainThread()).map(new DbBackedPlaylist$$ExternalSyntheticLambda3());
            Intrinsics.checkNotNullExpressionValue(map, "@MainThread\n    override…e Single.just(true)\n    }");
            return map;
        }
        Single<Boolean> just = Single.just(true);
        Intrinsics.checkNotNullExpressionValue(just, "just(true)");
        return just;
    }

    /* access modifiers changed from: private */
    /* renamed from: clearSongs$lambda-9  reason: not valid java name */
    public static final Boolean m823clearSongs$lambda9(Unit it) {
        return true;
    }

    public void close() {
        this.currSongList.clear();
        this.hasInitDb = false;
        runSerial("PlaylistManager#close", new DbBackedPlaylist$close$1(this));
    }

    private final <R> Single<R> runRxSerial(String name, Function0<? extends R> block) {
        Single<R> create = Single.create(new DbBackedPlaylist$$ExternalSyntheticLambda2(name, block));
        Intrinsics.checkNotNullExpressionValue(create, "create { subscriber ->\n …       }, name)\n        }");
        return create;
    }

    /* access modifiers changed from: private */
    /* renamed from: runRxSerial$lambda-11  reason: not valid java name */
    public static final void m828runRxSerial$lambda11(String $name, Function0 $block, SingleSubscriber subscriber) {
        Intrinsics.checkNotNullParameter($name, "$name");
        Intrinsics.checkNotNullParameter($block, "$block");
        ExecutorUtilsExt.postOnSerial(new DbBackedPlaylist$$ExternalSyntheticLambda0(subscriber, $block), $name);
    }

    /* access modifiers changed from: private */
    /* renamed from: runRxSerial$lambda-11$lambda-10  reason: not valid java name */
    public static final void m829runRxSerial$lambda11$lambda10(SingleSubscriber $subscriber, Function0 $block) {
        Intrinsics.checkNotNullParameter($block, "$block");
        $subscriber.onSuccess($block.invoke());
    }

    private final void runSerial(String name, Function0<Unit> block) {
        ExecutorUtilsExt.postOnSerial(new DbBackedPlaylist$$ExternalSyntheticLambda7(block), name);
    }

    /* access modifiers changed from: private */
    /* renamed from: runSerial$lambda-12  reason: not valid java name */
    public static final void m830runSerial$lambda12(Function0 $block) {
        Intrinsics.checkNotNullParameter($block, "$block");
        $block.invoke();
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist$InsertOperation;", "Lcom/baidu/searchbox/music/ext/album/playback/playlist/diff/PlaylistDiffOperation;", "position", "", "count", "(Lcom/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist;II)V", "apply", "", "oldList", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "newList", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DbBackedPlaylist.kt */
    private final class InsertOperation implements PlaylistDiffOperation {
        private final int count;
        private final int position;

        public InsertOperation(int position2, int count2) {
            this.position = position2;
            this.count = count2;
        }

        public boolean apply(List<? extends ISong> oldList, List<? extends ISong> newList) {
            int i2;
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            int i3 = this.position;
            if (i3 < 0 || i3 > oldList.size() || (i2 = this.count) <= 0 || this.position + i2 > newList.size()) {
                return false;
            }
            int i4 = this.position;
            List<? extends ISong> subList = newList.subList(i4, this.count + i4);
            if (this.position == oldList.size()) {
                if (DbBackedPlaylistKt.DEBUG) {
                    Log.d("PlaylistManager", "append " + CollectionsKt.joinToString$default(subList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DbBackedPlaylist$InsertOperation$apply$1.INSTANCE, 31, (Object) null));
                }
                return DbBackedPlaylist.this.getPlaylistDao().appendSongs(subList);
            }
            if (DbBackedPlaylistKt.DEBUG) {
                Log.d("PlaylistManager", "insert $ " + CollectionsKt.joinToString$default(subList, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DbBackedPlaylist$InsertOperation$apply$2.INSTANCE, 31, (Object) null));
            }
            return DbBackedPlaylist.this.getPlaylistDao().insertSongs(subList, this.position);
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist$RemoveOperation;", "Lcom/baidu/searchbox/music/ext/album/playback/playlist/diff/PlaylistDiffOperation;", "position", "", "count", "(Lcom/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist;II)V", "apply", "", "oldList", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "newList", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DbBackedPlaylist.kt */
    private final class RemoveOperation implements PlaylistDiffOperation {
        private final int count;
        private final int position;

        public RemoveOperation(int position2, int count2) {
            this.position = position2;
            this.count = count2;
        }

        public boolean apply(List<? extends ISong> oldList, List<? extends ISong> newList) {
            int i2;
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            int i3 = this.position;
            if (i3 < 0 || i3 >= oldList.size() || (i2 = this.count) <= 0 || this.position + i2 > oldList.size()) {
                return false;
            }
            if (DbBackedPlaylistKt.DEBUG) {
                StringBuilder append = new StringBuilder().append("remove ");
                int i4 = this.position;
                Log.d("PlaylistManager", append.append(CollectionsKt.joinToString$default(oldList.subList(i4, this.count + i4), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DbBackedPlaylist$RemoveOperation$apply$1.INSTANCE, 31, (Object) null)).toString());
            }
            ISong it = (ISong) CollectionsKt.getOrNull(oldList, this.position);
            if (it != null) {
                return DbBackedPlaylist.this.getPlaylistDao().deleteSongs(it, this.count);
            }
            return false;
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist$MoveOperation;", "Lcom/baidu/searchbox/music/ext/album/playback/playlist/diff/PlaylistDiffOperation;", "fromPosition", "", "toPosition", "(Lcom/baidu/searchbox/music/ext/album/playback/playlist/DbBackedPlaylist;II)V", "apply", "", "oldList", "", "Lcom/baidu/searchbox/music/ext/model/ISong;", "newList", "lib-music-ext_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DbBackedPlaylist.kt */
    private final class MoveOperation implements PlaylistDiffOperation {
        private final int fromPosition;
        private final int toPosition;

        public MoveOperation(int fromPosition2, int toPosition2) {
            this.fromPosition = fromPosition2;
            this.toPosition = toPosition2;
        }

        public boolean apply(List<? extends ISong> oldList, List<? extends ISong> newList) {
            int i2;
            ISong it;
            Intrinsics.checkNotNullParameter(oldList, "oldList");
            Intrinsics.checkNotNullParameter(newList, "newList");
            if (oldList.size() != newList.size() || (i2 = this.toPosition) < 0 || i2 >= oldList.size() || (it = (ISong) CollectionsKt.getOrNull(oldList, this.fromPosition)) == null) {
                return false;
            }
            DbBackedPlaylist dbBackedPlaylist = DbBackedPlaylist.this;
            if (DbBackedPlaylistKt.DEBUG) {
                Log.d("PlaylistManager", "move " + it.getName() + " from " + this.fromPosition + " to " + this.toPosition);
            }
            return dbBackedPlaylist.getPlaylistDao().reorderSong(it, this.fromPosition, this.toPosition);
        }
    }
}
