package com.baidu.searchbox.noveladapter.widget.pag;

import android.text.TextUtils;
import com.baidu.searchbox.NoProGuard;
import com.baidu.searchbox.noveladapter.widget.pag.NovelPAGImageView;

public class NovelPagUtils implements NoProGuard {
    public static void load(NovelPAGImageView pagImageView, String path) {
        if (pagImageView != null && !TextUtils.isEmpty(path)) {
            pagImageView.setPath(path);
        }
    }

    public static void play(NovelPAGImageView pagImageView, String path, int repeatCount, NovelPAGImageView.NovelPAGImageViewListener listener) {
        if (pagImageView != null && !TextUtils.isEmpty(path)) {
            pagImageView.setPath(path);
            pagImageView.setRepeatCount(repeatCount);
            if (listener != null) {
                pagImageView.addListener(listener);
            }
            pagImageView.play();
        }
    }

    public static void play(NovelPAGImageView pagImageView, String path, int repeatCount) {
        play(pagImageView, path, repeatCount, (NovelPAGImageView.NovelPAGImageViewListener) null);
    }

    public static void playUrl(final NovelPAGImageView pagImageView, String url, int repeatCount) {
        if (pagImageView != null && !TextUtils.isEmpty(url)) {
            pagImageView.setRepeatCount(repeatCount);
            pagImageView.setPathAsync(url, new NovelLoadListener() {
                public void onLoad(NovelPAGFile pagFile) {
                    NovelPAGImageView novelPAGImageView = NovelPAGImageView.this;
                    if (novelPAGImageView != null) {
                        novelPAGImageView.play();
                    }
                }
            });
        }
    }
}
