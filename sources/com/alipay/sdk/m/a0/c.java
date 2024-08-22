package com.alipay.sdk.m.a0;

import java.io.File;
import java.io.FileFilter;
import java.util.regex.Pattern;

public final class c implements FileFilter {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ b f2087a;

    public c(b bVar) {
        this.f2087a = bVar;
    }

    public final boolean accept(File file) {
        return Pattern.matches("cpu[0-9]+", file.getName());
    }
}
