package fe.xxx.qw;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

public final class qw {
    public static <T> Set<T> qw(Collection<T> collection) {
        return Collections.unmodifiableSet(new LinkedHashSet(collection));
    }
}
