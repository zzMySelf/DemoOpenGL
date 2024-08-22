package th.qw.fe;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Predicate {
    public static final /* synthetic */ ad qw = new ad();

    private /* synthetic */ ad() {
    }

    public final boolean test(Object obj) {
        return ((AccessibilityBridge.SemanticsNode) obj).hasFlag(AccessibilityBridge.Flag.HAS_IMPLICIT_SCROLLING);
    }
}
