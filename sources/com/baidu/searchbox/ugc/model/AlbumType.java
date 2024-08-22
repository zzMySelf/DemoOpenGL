package com.baidu.searchbox.ugc.model;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.Metadata;
import kotlin.annotation.AnnotationTarget;

@Target({ElementType.TYPE, ElementType.PARAMETER, ElementType.TYPE_USE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.TYPE, AnnotationTarget.CLASS, AnnotationTarget.PROPERTY, AnnotationTarget.VALUE_PARAMETER})
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0002\b\u0002\b\u0002\u0018\u0000 \u00022\u00020\u0001:\u0001\u0002B\u0000¨\u0006\u0003"}, d2 = {"Lcom/baidu/searchbox/ugc/model/AlbumType;", "", "Companion", "lib-ugc-album_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
@Retention(RetentionPolicy.RUNTIME)
/* compiled from: AlbumConfig.kt */
public @interface AlbumType {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int IMAGE_VIDEO = 2;
    public static final int ONLY_IMAGE = 0;
    public static final int ONLY_VIDEO = 1;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lcom/baidu/searchbox/ugc/model/AlbumType$Companion;", "", "()V", "IMAGE_VIDEO", "", "ONLY_IMAGE", "ONLY_VIDEO", "lib-ugc-album_debug"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* compiled from: AlbumConfig.kt */
    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int IMAGE_VIDEO = 2;
        public static final int ONLY_IMAGE = 0;
        public static final int ONLY_VIDEO = 1;

        private Companion() {
        }
    }
}
