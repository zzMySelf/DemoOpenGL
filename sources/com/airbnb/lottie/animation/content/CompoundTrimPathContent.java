package com.airbnb.lottie.animation.content;

import android.graphics.Path;
import com.airbnb.lottie.utils.Utils;
import java.util.ArrayList;
import java.util.List;

public class CompoundTrimPathContent {
    private List<TrimPathContent> contents = new ArrayList();

    /* access modifiers changed from: package-private */
    public void addTrimPath(TrimPathContent trimPath) {
        this.contents.add(trimPath);
    }

    public void apply(Path path) {
        for (int i2 = this.contents.size() - 1; i2 >= 0; i2--) {
            Utils.applyTrimPathIfNeeded(path, this.contents.get(i2));
        }
    }
}
