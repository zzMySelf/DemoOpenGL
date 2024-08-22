package com.baidu.searchbox.comment.data;

import android.text.TextUtils;
import android.util.LruCache;
import com.baidu.searchbox.comment.model.CommentListData;
import com.baidu.searchbox.comment.model.VoteDataModel;

public class CommentNetworkCache {
    public static final int CACHE_SIZE = 10;
    private static CommentNetworkCache sCommentNetworkCache = null;
    private LruCache<String, NetworkItemCache> mCommentList;
    private LruCache<String, VoteDataModel> mVoteDataCache;

    public CommentNetworkCache() {
        this.mCommentList = null;
        this.mVoteDataCache = null;
        this.mCommentList = new LruCache<>(10);
        this.mVoteDataCache = new LruCache<>(10);
    }

    public static synchronized CommentNetworkCache getInstance() {
        CommentNetworkCache commentNetworkCache;
        synchronized (CommentNetworkCache.class) {
            if (sCommentNetworkCache == null) {
                sCommentNetworkCache = new CommentNetworkCache();
            }
            commentNetworkCache = sCommentNetworkCache;
        }
        return commentNetworkCache;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0029, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002b, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putCommentListData(java.lang.String r4, com.baidu.searchbox.comment.model.CommentListData r5, java.lang.String r6) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ all -> 0x002c }
            if (r0 != 0) goto L_0x002a
            if (r5 == 0) goto L_0x002a
            boolean r0 = android.text.TextUtils.isEmpty(r6)     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x0010
            goto L_0x002a
        L_0x0010:
            android.util.LruCache<java.lang.String, com.baidu.searchbox.comment.data.NetworkItemCache> r0 = r3.mCommentList     // Catch:{ all -> 0x002c }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002c }
            com.baidu.searchbox.comment.data.NetworkItemCache r0 = (com.baidu.searchbox.comment.data.NetworkItemCache) r0     // Catch:{ all -> 0x002c }
            if (r0 == 0) goto L_0x001e
            r0.put(r5, r6)     // Catch:{ all -> 0x002c }
            goto L_0x0028
        L_0x001e:
            android.util.LruCache<java.lang.String, com.baidu.searchbox.comment.data.NetworkItemCache> r1 = r3.mCommentList     // Catch:{ all -> 0x002c }
            com.baidu.searchbox.comment.data.NetworkItemCache r2 = new com.baidu.searchbox.comment.data.NetworkItemCache     // Catch:{ all -> 0x002c }
            r2.<init>(r5, r6)     // Catch:{ all -> 0x002c }
            r1.put(r4, r2)     // Catch:{ all -> 0x002c }
        L_0x0028:
            monitor-exit(r3)
            return
        L_0x002a:
            monitor-exit(r3)
            return
        L_0x002c:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.data.CommentNetworkCache.putCommentListData(java.lang.String, com.baidu.searchbox.comment.model.CommentListData, java.lang.String):void");
    }

    public synchronized CommentListData getCommentListData(String key, String start) {
        NetworkItemCache item;
        if (TextUtils.isEmpty(key) || TextUtils.isEmpty(start) || (item = this.mCommentList.get(key)) == null || item.getData() == null) {
            return null;
        }
        return item.getData().get(start);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0012, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void putVoteData(java.lang.String r2, com.baidu.searchbox.comment.model.VoteDataModel r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0013 }
            if (r0 != 0) goto L_0x0011
            if (r3 != 0) goto L_0x000a
            goto L_0x0011
        L_0x000a:
            android.util.LruCache<java.lang.String, com.baidu.searchbox.comment.model.VoteDataModel> r0 = r1.mVoteDataCache     // Catch:{ all -> 0x0013 }
            r0.put(r2, r3)     // Catch:{ all -> 0x0013 }
            monitor-exit(r1)
            return
        L_0x0011:
            monitor-exit(r1)
            return
        L_0x0013:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.baidu.searchbox.comment.data.CommentNetworkCache.putVoteData(java.lang.String, com.baidu.searchbox.comment.model.VoteDataModel):void");
    }

    public synchronized VoteDataModel getVoteData(String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        return this.mVoteDataCache.get(key);
    }
}
