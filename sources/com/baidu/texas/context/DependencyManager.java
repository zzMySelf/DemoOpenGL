package com.baidu.texas.context;

import java.util.List;

public interface DependencyManager {
    Spec getScopedSpec(Id id);

    public interface Spec {

        public interface Listener {
            void onDependencyChanged(Spec spec, Id id);
        }

        void dependsOn(Id id, List<Id> list, DependencyOptions dependencyOptions);

        void dependsOn(Id id, Id... idArr);

        Id[] getDependencies(Id id);

        Id getId();

        void setListener(Listener listener);

        public static class DependencyOptions {
            public static final DependencyOptions DEFAULT = new DependencyOptions(false, false, false);
            public final boolean applyOnlyIfNoReverseMapping;
            public final boolean clearOldDepends;
            public final boolean clearReverseMapping;

            public DependencyOptions(boolean clearOldDepends2, boolean clearReverseMapping2, boolean applyOnlyIfNoReverseMapping2) {
                this.clearOldDepends = clearOldDepends2;
                this.clearReverseMapping = clearReverseMapping2;
                this.applyOnlyIfNoReverseMapping = applyOnlyIfNoReverseMapping2;
            }
        }
    }
}
