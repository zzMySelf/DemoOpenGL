package com.baidu.searchbox.ioc;

public class CommentAdTopViewFetcher_Factory {
    private static volatile CommentAdTopViewFetcher instance;

    private CommentAdTopViewFetcher_Factory() {
    }

    public static synchronized CommentAdTopViewFetcher get() {
        CommentAdTopViewFetcher commentAdTopViewFetcher;
        synchronized (CommentAdTopViewFetcher_Factory.class) {
            if (instance == null) {
                instance = new CommentAdTopViewFetcher();
            }
            commentAdTopViewFetcher = instance;
        }
        return commentAdTopViewFetcher;
    }
}
