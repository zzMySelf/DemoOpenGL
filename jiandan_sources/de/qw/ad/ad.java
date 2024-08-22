package de.qw.ad;

import androidx.browser.trusted.TokenContents;
import java.util.Comparator;

/* compiled from: lambda */
public final /* synthetic */ class ad implements Comparator {

    /* renamed from: ad  reason: collision with root package name */
    public static final /* synthetic */ ad f1164ad = new ad();

    private /* synthetic */ ad() {
    }

    public final int compare(Object obj, Object obj2) {
        return TokenContents.compareByteArrays((byte[]) obj, (byte[]) obj2);
    }
}
