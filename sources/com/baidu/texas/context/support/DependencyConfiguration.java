package com.baidu.texas.context.support;

import com.baidu.texas.context.DependencyManager;
import com.baidu.texas.context.Id;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DependencyConfiguration implements DependencyManager {
    private final Map<Id, Constraint> mIdConstraintMap = new HashMap();

    public DependencyManager.Spec getScopedSpec(Id scopedId) {
        Constraint constraint;
        synchronized (this) {
            constraint = this.mIdConstraintMap.get(scopedId);
            if (constraint == null) {
                Map<Id, Constraint> map = this.mIdConstraintMap;
                Constraint constraint2 = new Constraint(scopedId);
                constraint = constraint2;
                map.put(scopedId, constraint2);
            }
        }
        return constraint;
    }

    public static class Constraint implements DependencyManager.Spec {
        private static final Id[] EMPTY_IDS = new Id[0];
        private final Id mId;
        private final Map<Id, Set<Id>> mIdDepsMap = new HashMap();
        private DependencyManager.Spec.Listener mListener;

        public Constraint(Id id) {
            this.mId = id;
        }

        public void dependsOn(Id from, Id... to) {
            dependsOn(from, Arrays.asList(to), DependencyManager.Spec.DependencyOptions.DEFAULT);
        }

        public void dependsOn(Id target, List<Id> deps, DependencyManager.Spec.DependencyOptions options) {
            Set<Id> ids = this.mIdDepsMap.get(target);
            if (ids == null) {
                Map<Id, Set<Id>> map = this.mIdDepsMap;
                Set<Id> hashSet = new HashSet<>();
                ids = hashSet;
                map.put(target, hashSet);
            }
            if (options.applyOnlyIfNoReverseMapping) {
                deps = filterReverseMapping(target, deps);
                if (deps.isEmpty()) {
                    return;
                }
            }
            if (options.clearOldDepends) {
                ids.clear();
            }
            if (options.clearReverseMapping) {
                clearReverseMapping(target, deps);
            }
            ids.addAll(deps);
            DependencyManager.Spec.Listener listener = this.mListener;
            if (listener != null) {
                listener.onDependencyChanged(this, target);
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x000f, code lost:
            r2 = r1.next();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private java.util.List<com.baidu.texas.context.Id> filterReverseMapping(com.baidu.texas.context.Id r6, java.util.List<com.baidu.texas.context.Id> r7) {
            /*
                r5 = this;
                java.util.ArrayList r0 = new java.util.ArrayList
                r0.<init>()
                java.util.Iterator r1 = r7.iterator()
            L_0x0009:
                boolean r2 = r1.hasNext()
                if (r2 == 0) goto L_0x002a
                java.lang.Object r2 = r1.next()
                com.baidu.texas.context.Id r2 = (com.baidu.texas.context.Id) r2
                java.util.Map<com.baidu.texas.context.Id, java.util.Set<com.baidu.texas.context.Id>> r3 = r5.mIdDepsMap
                java.lang.Object r3 = r3.get(r2)
                java.util.Set r3 = (java.util.Set) r3
                if (r3 == 0) goto L_0x0026
                boolean r4 = r3.contains(r6)
                if (r4 == 0) goto L_0x0026
                goto L_0x002a
            L_0x0026:
                r0.add(r2)
                goto L_0x0009
            L_0x002a:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.baidu.texas.context.support.DependencyConfiguration.Constraint.filterReverseMapping(com.baidu.texas.context.Id, java.util.List):java.util.List");
        }

        private void clearReverseMapping(Id from, List<Id> to) {
            DependencyManager.Spec.Listener listener;
            for (Id id : to) {
                Set<Id> ids = this.mIdDepsMap.get(id);
                if (!(ids == null || !ids.remove(from) || (listener = this.mListener) == null)) {
                    listener.onDependencyChanged(this, from);
                }
            }
        }

        public Id[] getDependencies(Id from) {
            Set<Id> ids = this.mIdDepsMap.get(from);
            if (ids == null) {
                return EMPTY_IDS;
            }
            return (Id[]) ids.toArray(EMPTY_IDS);
        }

        public Id getId() {
            return this.mId;
        }

        public void setListener(DependencyManager.Spec.Listener listener) {
            this.mListener = listener;
        }
    }
}
