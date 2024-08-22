package com.baidu.searchbox.logsystem.logsys.eventscene.handler;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import fe.fe.ddd.when.fe.fe;
import fe.fe.ddd.when.fe.i.qw;
import java.io.File;
import java.util.Set;

public interface EventSceneHandler<T> {
    @Nullable
    Set<T> ad(@NonNull Context context, @NonNull qw qwVar);

    @Nullable
    Set<fe> qw(@NonNull Context context, @NonNull File file, @NonNull qw qwVar);
}
