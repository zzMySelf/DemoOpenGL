package com.baidu.searchbox.noveladapter.share;

import android.content.Context;
import android.view.View;
import com.baidu.searchbox.NoProGuard;

public interface INovelSearchboxShareInterface extends NoProGuard {
    void clean();

    NovelSearchboxShareContent parseH5JsonData(String str);

    void share(Context context, View view2, NovelSearchboxShareContent novelSearchboxShareContent, INovelSearchboxShareOnLifeCycleListener iNovelSearchboxShareOnLifeCycleListener, INovelSearchboxOnSocialListener iNovelSearchboxOnSocialListener);

    public static final class Impl implements NoProGuard {
        private Impl() {
        }

        public static INovelSearchboxShareInterface get() {
            return null;
        }
    }
}
