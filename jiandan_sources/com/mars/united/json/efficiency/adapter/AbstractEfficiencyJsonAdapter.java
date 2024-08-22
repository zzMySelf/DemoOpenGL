package com.mars.united.json.efficiency.adapter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public abstract class AbstractEfficiencyJsonAdapter<T> extends TypeAdapter<T> {
    public final Gson qw;

    public abstract void ad(@NotNull JsonWriter jsonWriter, @NotNull T t) throws IOException;

    @Nullable
    public abstract T qw(@NotNull JsonReader jsonReader) throws IOException;

    @Nullable
    public final T read(JsonReader jsonReader) throws IOException {
        if (jsonReader == null) {
            return null;
        }
        return qw(jsonReader);
    }

    public final void write(JsonWriter jsonWriter, T t) throws IOException {
        if (jsonWriter != null && t != null) {
            ad(jsonWriter, t);
        }
    }
}
