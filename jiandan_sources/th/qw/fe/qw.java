package th.qw.fe;

import io.flutter.util.Predicate;
import io.flutter.view.AccessibilityBridge;

/* compiled from: lambda */
public final /* synthetic */ class qw implements Predicate {
    public final /* synthetic */ AccessibilityBridge.SemanticsNode qw;

    public /* synthetic */ qw(AccessibilityBridge.SemanticsNode semanticsNode) {
        this.qw = semanticsNode;
    }

    public final boolean test(Object obj) {
        return AccessibilityBridge.qw(this.qw, (AccessibilityBridge.SemanticsNode) obj);
    }
}
