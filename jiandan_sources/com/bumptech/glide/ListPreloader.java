package com.bumptech.glide;

import android.widget.AbsListView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.bumptech.glide.request.target.SizeReadyCallback;
import com.bumptech.glide.request.transition.Transition;
import fe.rg.qw.ggg.i;
import fe.rg.qw.rg;
import fe.rg.qw.th;
import java.util.List;
import java.util.Queue;

public class ListPreloader<T> implements AbsListView.OnScrollListener {
    public boolean isIncreasing = true;
    public int lastEnd;
    public int lastFirstVisible = -1;
    public int lastStart;
    public final int maxPreload;
    public final PreloadSizeProvider<T> preloadDimensionProvider;
    public final PreloadModelProvider<T> preloadModelProvider;
    public final ad preloadTargetQueue;
    public final th requestManager;
    public int totalItemCount;

    public interface PreloadModelProvider<U> {
        @Nullable
        rg<?> ad(@NonNull U u);

        @NonNull
        List<U> qw(int i2);
    }

    public interface PreloadSizeProvider<T> {
        @Nullable
        int[] qw(@NonNull T t, int i2, int i3);
    }

    public static final class ad {
        public final Queue<qw> qw;

        public ad(int i2) {
            this.qw = i.rg(i2);
            for (int i3 = 0; i3 < i2; i3++) {
                this.qw.offer(new qw());
            }
        }

        public qw qw(int i2, int i3) {
            qw poll = this.qw.poll();
            this.qw.offer(poll);
            poll.f3658yj = i2;
            poll.f3657th = i3;
            return poll;
        }
    }

    public static final class qw extends fe.rg.qw.when.fe.qw<Object> {

        /* renamed from: th  reason: collision with root package name */
        public int f3657th;

        /* renamed from: yj  reason: collision with root package name */
        public int f3658yj;

        public void fe(@NonNull SizeReadyCallback sizeReadyCallback) {
        }

        public void rg(@NonNull Object obj, @Nullable Transition<? super Object> transition) {
        }

        public void yj(@NonNull SizeReadyCallback sizeReadyCallback) {
            sizeReadyCallback.ad(this.f3658yj, this.f3657th);
        }
    }

    public ListPreloader(@NonNull th thVar, @NonNull PreloadModelProvider<T> preloadModelProvider2, @NonNull PreloadSizeProvider<T> preloadSizeProvider, int i2) {
        this.requestManager = thVar;
        this.preloadModelProvider = preloadModelProvider2;
        this.preloadDimensionProvider = preloadSizeProvider;
        this.maxPreload = i2;
        this.preloadTargetQueue = new ad(i2 + 1);
    }

    private void cancelAll() {
        for (int i2 = 0; i2 < this.maxPreload; i2++) {
            this.requestManager.pf(this.preloadTargetQueue.qw(0, 0));
        }
    }

    private void preload(int i2, boolean z) {
        if (this.isIncreasing != z) {
            this.isIncreasing = z;
            cancelAll();
        }
        preload(i2, (z ? this.maxPreload : -this.maxPreload) + i2);
    }

    private void preloadAdapterPosition(List<T> list, int i2, boolean z) {
        int size = list.size();
        if (z) {
            for (int i3 = 0; i3 < size; i3++) {
                preloadItem(list.get(i3), i2, i3);
            }
            return;
        }
        for (int i4 = size - 1; i4 >= 0; i4--) {
            preloadItem(list.get(i4), i2, i4);
        }
    }

    private void preloadItem(@Nullable T t, int i2, int i3) {
        int[] qw2;
        rg<?> ad2;
        if (t != null && (qw2 = this.preloadDimensionProvider.qw(t, i2, i3)) != null && (ad2 = this.preloadModelProvider.ad(t)) != null) {
            ad2.o(this.preloadTargetQueue.qw(qw2[0], qw2[1]));
        }
    }

    public void onScroll(AbsListView absListView, int i2, int i3, int i4) {
        this.totalItemCount = i4;
        int i5 = this.lastFirstVisible;
        if (i2 > i5) {
            preload(i3 + i2, true);
        } else if (i2 < i5) {
            preload(i2, false);
        }
        this.lastFirstVisible = i2;
    }

    public void onScrollStateChanged(AbsListView absListView, int i2) {
    }

    private void preload(int i2, int i3) {
        int i4;
        int i5;
        if (i2 < i3) {
            i4 = Math.max(this.lastEnd, i2);
            i5 = i3;
        } else {
            i5 = Math.min(this.lastStart, i2);
            i4 = i3;
        }
        int min = Math.min(this.totalItemCount, i5);
        int min2 = Math.min(this.totalItemCount, Math.max(0, i4));
        if (i2 < i3) {
            for (int i6 = min2; i6 < min; i6++) {
                preloadAdapterPosition(this.preloadModelProvider.qw(i6), i6, true);
            }
        } else {
            for (int i7 = min - 1; i7 >= min2; i7--) {
                preloadAdapterPosition(this.preloadModelProvider.qw(i7), i7, false);
            }
        }
        this.lastStart = min2;
        this.lastEnd = min;
    }
}
