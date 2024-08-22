package com.airbnb.lottie.model.content;

import androidx.annotation.Nullable;
import com.airbnb.lottie.animation.content.Content;
import fe.qw.qw.ggg.fe;
import fe.qw.qw.p009switch.o.qw;
import fe.qw.qw.pf.ad.i;
import fe.qw.qw.rg;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public class MergePaths implements ContentModel {

    /* renamed from: ad  reason: collision with root package name */
    public final MergePathsMode f590ad;

    /* renamed from: de  reason: collision with root package name */
    public final boolean f591de;
    public final String qw;

    public enum MergePathsMode {
        MERGE,
        ADD,
        SUBTRACT,
        INTERSECT,
        EXCLUDE_INTERSECTIONS;

        public static MergePathsMode forId(int i2) {
            if (i2 == 1) {
                return MERGE;
            }
            if (i2 == 2) {
                return ADD;
            }
            if (i2 == 3) {
                return SUBTRACT;
            }
            if (i2 == 4) {
                return INTERSECT;
            }
            if (i2 != 5) {
                return MERGE;
            }
            return EXCLUDE_INTERSECTIONS;
        }
    }

    public MergePaths(String str, MergePathsMode mergePathsMode, boolean z) {
        this.qw = str;
        this.f590ad = mergePathsMode;
        this.f591de = z;
    }

    public MergePathsMode ad() {
        return this.f590ad;
    }

    public String de() {
        return this.qw;
    }

    public boolean fe() {
        return this.f591de;
    }

    @Nullable
    public Content qw(rg rgVar, qw qwVar) {
        if (rgVar.ppp()) {
            return new i(this);
        }
        fe.de("Animation contains merge paths but they are disabled.");
        return null;
    }

    public String toString() {
        return "MergePaths{mode=" + this.f590ad + ExtendedMessageFormat.END_FE;
    }
}
