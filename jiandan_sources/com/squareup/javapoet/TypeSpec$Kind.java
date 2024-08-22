package com.squareup.javapoet;

import fe.xxx.qw.qw;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import javax.lang.model.element.Modifier;

public enum TypeSpec$Kind {
    CLASS(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.emptySet()),
    INTERFACE(qw.qw(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL})), qw.qw(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.ABSTRACT})), qw.qw(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC})), qw.qw(Collections.singletonList(Modifier.STATIC))),
    ENUM(Collections.emptySet(), Collections.emptySet(), Collections.emptySet(), Collections.singleton(Modifier.STATIC)),
    ANNOTATION(qw.qw(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC, Modifier.FINAL})), qw.qw(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.ABSTRACT})), qw.qw(Arrays.asList(new Modifier[]{Modifier.PUBLIC, Modifier.STATIC})), qw.qw(Collections.singletonList(Modifier.STATIC)));
    
    public final Set<Modifier> asMemberModifiers;
    public final Set<Modifier> implicitFieldModifiers;
    public final Set<Modifier> implicitMethodModifiers;
    public final Set<Modifier> implicitTypeModifiers;

    /* access modifiers changed from: public */
    TypeSpec$Kind(Set<Modifier> set, Set<Modifier> set2, Set<Modifier> set3, Set<Modifier> set4) {
        this.implicitFieldModifiers = set;
        this.implicitMethodModifiers = set2;
        this.implicitTypeModifiers = set3;
        this.asMemberModifiers = set4;
    }
}
