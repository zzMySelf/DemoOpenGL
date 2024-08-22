package com.mars.united.json.efficiency.adapter;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import fe.ggg.ad.de.qw.ad.ad;
import fe.ggg.ad.de.qw.qw.qw;
import java.io.IOException;
import java.lang.reflect.Method;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ReflectEfficiencyJsonAdapter<T> extends AbstractEfficiencyJsonAdapter<T> {
    @NotNull

    /* renamed from: ad  reason: collision with root package name */
    public qw<T> f6668ad;
    @NotNull

    /* renamed from: de  reason: collision with root package name */
    public Method f6669de;

    public void ad(@NotNull JsonWriter jsonWriter, @NotNull T t) throws IOException {
        jsonWriter.beginObject();
        try {
            this.f6669de.invoke(t, new Object[]{this.qw, jsonWriter});
            jsonWriter.endObject();
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
    }

    @Nullable
    public T qw(@NotNull JsonReader jsonReader) throws IOException {
        ad<T> qw = this.f6668ad.qw(this.qw, jsonReader);
        if (qw != null) {
            return qw.qw();
        }
        return null;
    }
}
