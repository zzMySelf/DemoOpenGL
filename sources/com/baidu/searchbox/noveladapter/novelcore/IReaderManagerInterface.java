package com.baidu.searchbox.noveladapter.novelcore;

import android.app.Application;
import com.baidu.searchbox.NoProGuard;

public interface IReaderManagerInterface extends NoProGuard {
    void clearCallbacks(Application application);

    void initNovelPath(Impl.OnPathResult onPathResult);

    public static final class Impl implements NoProGuard {
        private static IReaderManagerInterface onReaderDealInterface = null;

        public interface OnPathResult extends NoProGuard {
            void onResult(String str);
        }

        private Impl() {
        }

        public static IReaderManagerInterface get() {
            return onReaderDealInterface;
        }

        public static void set(IReaderManagerInterface readerDealInterface) {
            onReaderDealInterface = readerDealInterface;
        }
    }
}
