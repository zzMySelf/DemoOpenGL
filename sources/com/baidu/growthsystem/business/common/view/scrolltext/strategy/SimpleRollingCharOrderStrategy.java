package com.baidu.growthsystem.business.common.view.scrolltext.strategy;

import com.baidu.growthsystem.business.common.view.scrolltext.ColumnNextProgress;
import com.baidu.growthsystem.business.common.view.scrolltext.ColumnPreviousProgress;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u001c\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J,\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n0\nH\u0016JJ\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u0016\u0010\u0012\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\nj\u0002`\u0014H\u0016JB\u0010\f\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\b2\u000e\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u0016H\u0016JJ\u0010\u0017\u001a\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0011\u001a\u00020\b2\u0016\u0010\u0012\u001a\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u00130\nj\u0002`\u0014H\u0016¨\u0006\u001b"}, d2 = {"Lcom/baidu/growthsystem/business/common/view/scrolltext/strategy/SimpleRollingCharOrderStrategy;", "Lcom/baidu/growthsystem/business/common/view/scrolltext/strategy/RollingCharOrderStrategy;", "()V", "columnNextProgress", "Lcom/baidu/growthsystem/business/common/view/scrolltext/ColumnNextProgress;", "cloPreviousProgress", "Lcom/baidu/growthsystem/business/common/view/scrolltext/ColumnPreviousProgress;", "columnIndex", "", "columns", "", "", "findCharOrder", "Lkotlin/Pair;", "Lcom/baidu/growthsystem/business/common/view/scrolltext/strategy/RollingDirection;", "sourceChar", "targetChar", "index", "charPool", "", "Lcom/baidu/growthsystem/business/common/view/scrolltext/strategy/CharPool;", "order", "", "findRollingCharOrder", "sourceText", "", "targetText", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: RollingOrderStrategy.kt */
public abstract class SimpleRollingCharOrderStrategy implements RollingCharOrderStrategy {
    public ColumnNextProgress columnNextProgress(ColumnPreviousProgress cloPreviousProgress, int columnIndex, List<? extends List<Character>> columns) {
        List<? extends List<Character>> list = columns;
        Intrinsics.checkNotNullParameter(cloPreviousProgress, "cloPreviousProgress");
        Intrinsics.checkNotNullParameter(list, "columns");
        double columnTotalProgress = ((double) (((List) list.get(columnIndex)).size() - 1)) * cloPreviousProgress.getProgress();
        int columnCurrentCharIndex = (int) columnTotalProgress;
        double offset = columnTotalProgress - ((double) columnCurrentCharIndex);
        return new ColumnNextProgress(columnCurrentCharIndex, offset >= 0.0d ? offset : 0.0d, cloPreviousProgress.getProgress());
    }

    public Pair<List<Character>, RollingDirection> findRollingCharOrder(CharSequence sourceText, CharSequence targetText, int index, List<? extends Collection<Character>> charPool) {
        Intrinsics.checkNotNullParameter(sourceText, "sourceText");
        Intrinsics.checkNotNullParameter(targetText, "targetText");
        Intrinsics.checkNotNullParameter(charPool, "charPool");
        int maxLen = RangesKt.coerceAtLeast(sourceText.length(), targetText.length());
        int sourceDistance = maxLen - sourceText.length();
        int targetDistance = maxLen - targetText.length();
        char sourceChar = 0;
        char targetChar = 0;
        if (index >= sourceDistance) {
            sourceChar = sourceText.charAt(index - sourceDistance);
        }
        if (index >= targetDistance) {
            targetChar = targetText.charAt(index - targetDistance);
        }
        return findCharOrder(sourceChar, targetChar, index, charPool);
    }

    public Pair<List<Character>, RollingDirection> findCharOrder(char sourceChar, char targetChar, int index, List<? extends Collection<Character>> charPool) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(charPool, "charPool");
        Iterator it = charPool.iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Collection it2 = (Collection) obj;
            if (!it2.contains(Character.valueOf(sourceChar)) || !it2.contains(Character.valueOf(targetChar))) {
                z = false;
                continue;
            } else {
                z = true;
                continue;
            }
            if (z) {
                break;
            }
        }
        return findCharOrder(sourceChar, targetChar, index, (Iterable<Character>) (Collection) obj);
    }

    public Pair<List<Character>, RollingDirection> findCharOrder(char sourceChar, char targetChar, int index, Iterable<Character> order) {
        return TuplesKt.to(CollectionsKt.listOf(Character.valueOf(sourceChar), Character.valueOf(targetChar)), RollingDirection.SCROLL_DOWN);
    }
}
