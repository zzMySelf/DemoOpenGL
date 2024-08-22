package com.mars.kotlin.service.extension;

import android.os.Bundle;
import android.os.ResultReceiver;
import com.mars.kotlin.extension.BundleKt;
import com.mars.kotlin.extension.ExpectKt;
import com.mars.kotlin.extension.LoggerKt;
import com.mars.kotlin.extension.fp.Either;
import com.mars.kotlin.service.ErrorCode;
import com.mars.kotlin.service.Extra;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt___ArraysKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt___SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0010\u0011\n\u0002\b\u0003\u001a/\u0010\u0005\u001a\u0004\u0018\u00010\u0004\"\u0004\b\u0000\u0010\u00002\u0010\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\u0005\u0010\u0006\u001a=\u0010\t\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\"\u0004\b\u0000\u0010\u00002\u0010\u0010\u0002\u001a\f\u0012\u0006\b\u0001\u0012\u00028\u0000\u0018\u00010\u00012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0004\b\t\u0010\n\u001aP\u0010\u0011\u001a\u001e\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\u000f\u0012\u0006\u0012\u0004\u0018\u00010\u00100\u000f\"\n\b\u0000\u0010\u0000\u0018\u0001*\u00020\u000b*\u0004\u0018\u00010\f2\u0010\b\u0004\u0010\u000e\u001a\n\u0012\u0006\u0012\u0004\u0018\u00018\u00000\rH\n¢\u0006\u0004\b\u0011\u0010\u0012\u001a\u0015\u0010\u0013\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\f¢\u0006\u0004\b\u0013\u0010\u0014\u001a!\u0010\u0016\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\f2\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\u0016\u0010\u0017\u001a)\u0010\u001a\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\f2\u0006\u0010\u0018\u001a\u00020\b2\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0015\u0010\u001c\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\f¢\u0006\u0004\b\u001c\u0010\u0014\u001aA\u0010\u001c\u001a\u0004\u0018\u00010\u0010*\u0004\u0018\u00010\f2*\u0010\u001e\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u00070\u001d\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u000b0\u0007¢\u0006\u0004\b\u001c\u0010\u001f¨\u0006 "}, d2 = {"T", "Ljava/lang/Class;", "clazz", "instance", "", "findErrorMessage", "(Ljava/lang/Class;Ljava/lang/Object;)Ljava/lang/String;", "Lkotlin/Pair;", "", "findErrorNumber", "(Ljava/lang/Class;Ljava/lang/Object;)Lkotlin/Pair;", "", "Landroid/os/ResultReceiver;", "Lkotlin/Function0;", "server", "Lkotlin/Function1;", "", "invoke", "(Landroid/os/ResultReceiver;Lkotlin/Function0;)Lkotlin/Function1;", "networkWrong", "(Landroid/os/ResultReceiver;)Lkotlin/Unit;", "value", "right", "(Landroid/os/ResultReceiver;Ljava/lang/Object;)Lkotlin/Unit;", "errno", "message", "serverWrong", "(Landroid/os/ResultReceiver;ILjava/lang/String;)Lkotlin/Unit;", "wrong", "", "info", "(Landroid/os/ResultReceiver;[Lkotlin/Pair;)Lkotlin/Unit;", "service_release"}, k = 2, mv = {1, 1, 15}, pn = "", xi = 0, xs = "")
public final class ResultReceiverKt {
    @Nullable
    public static final <T> String findErrorMessage(@Nullable Class<? extends T> cls, T t) {
        Either either;
        if (cls == null) {
            return null;
        }
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields == null) {
                return null;
            }
            if (declaredFields.length == 0) {
                return findErrorMessage(cls.getSuperclass(), t);
            }
            Field field = (Field) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.filter(ArraysKt___ArraysKt.asSequence((T[]) declaredFields), ResultReceiverKt$findErrorMessage$1$field$1.INSTANCE));
            if (field == null) {
                return findErrorMessage(cls.getSuperclass(), t);
            }
            field.setAccessible(true);
            Object obj = field.get(t);
            if (!(obj instanceof String)) {
                obj = null;
            }
            either = ExpectKt.success((String) obj);
            return (String) ExpectKt.successOrNull(either);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
    }

    @Nullable
    public static final <T> Pair<Integer, Integer> findErrorNumber(@Nullable Class<? extends T> cls, T t) {
        Either either;
        Integer num;
        if (cls == null) {
            return null;
        }
        try {
            Field[] declaredFields = cls.getDeclaredFields();
            if (declaredFields == null) {
                return null;
            }
            if (declaredFields.length == 0) {
                return findErrorNumber(cls.getSuperclass(), t);
            }
            Field field = (Field) SequencesKt___SequencesKt.firstOrNull(SequencesKt___SequencesKt.filter(ArraysKt___ArraysKt.asSequence((T[]) declaredFields), ResultReceiverKt$findErrorNumber$1$field$1.INSTANCE));
            if (field == null) {
                return findErrorNumber(cls.getSuperclass(), t);
            }
            ErrorCode errorCode = (ErrorCode) field.getAnnotation(ErrorCode.class);
            if (errorCode == null) {
                return findErrorNumber(cls.getSuperclass(), t);
            }
            int noError = errorCode.noError();
            field.setAccessible(true);
            if (Intrinsics.areEqual((Object) field.getType(), (Object) Integer.class)) {
                Object obj = field.get(t);
                if (!(obj instanceof Integer)) {
                    obj = null;
                }
                num = (Integer) obj;
            } else {
                num = Integer.valueOf(field.getInt(t));
            }
            either = ExpectKt.success(TuplesKt.to(num, Integer.valueOf(noError)));
            return (Pair) ExpectKt.successOrNull(either);
        } catch (Throwable th2) {
            LoggerKt.e$default(th2, (Object) null, 1, (Object) null);
            either = ExpectKt.failure(th2);
        }
    }

    @NotNull
    public static final /* synthetic */ <T> Function1<Function1<? super T, ? extends Object>, Unit> invoke(@Nullable ResultReceiver resultReceiver, @NotNull Function0<? extends T> function0) {
        return new ResultReceiverKt$invoke$1(resultReceiver, function0);
    }

    @Nullable
    public static final Unit networkWrong(@Nullable ResultReceiver resultReceiver) {
        Unit wrong = wrong(resultReceiver, TuplesKt.to(Extra.ERROR_NETWORK, Boolean.TRUE));
        if (wrong == null) {
            return null;
        }
        LoggerKt.d$default("请求失败:网络错误", (Object) null, 1, (Object) null);
        return wrong;
    }

    @Nullable
    public static final Unit right(@Nullable ResultReceiver resultReceiver, @Nullable Object obj) {
        Bundle bundle = null;
        if (resultReceiver == null) {
            return null;
        }
        Bundle bundle2 = Bundle.EMPTY;
        if (obj == null) {
            bundle = bundle2;
        }
        if (bundle == null) {
            bundle = BundleKt.Bundle(new ResultReceiverKt$right$2(obj));
        }
        resultReceiver.send(1, bundle);
        return Unit.INSTANCE;
    }

    public static /* synthetic */ Unit right$default(ResultReceiver resultReceiver, Object obj, int i2, Object obj2) {
        if ((i2 & 1) != 0) {
            obj = null;
        }
        return right(resultReceiver, obj);
    }

    @Nullable
    public static final Unit serverWrong(@Nullable ResultReceiver resultReceiver, int i2, @Nullable String str) {
        Unit unit;
        if (str == null) {
            unit = wrong(resultReceiver, TuplesKt.to(Extra.ERROR, Integer.valueOf(i2)));
        } else {
            unit = wrong(resultReceiver, TuplesKt.to(Extra.ERROR, Integer.valueOf(i2)), TuplesKt.to(Extra.ERROR_SERVER_MESSAGE, str));
        }
        if (unit == null) {
            return null;
        }
        LoggerKt.d$default("请求失败:errno:" + i2 + ",message:" + str, (Object) null, 1, (Object) null);
        return unit;
    }

    public static /* synthetic */ Unit serverWrong$default(ResultReceiver resultReceiver, int i2, String str, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            str = null;
        }
        return serverWrong(resultReceiver, i2, str);
    }

    @Nullable
    public static final Unit wrong(@Nullable ResultReceiver resultReceiver) {
        if (resultReceiver == null) {
            return null;
        }
        resultReceiver.send(2, Bundle.EMPTY);
        Unit unit = Unit.INSTANCE;
        LoggerKt.d$default("请求失败", (Object) null, 1, (Object) null);
        return unit;
    }

    @Nullable
    public static final Unit wrong(@Nullable ResultReceiver resultReceiver, @NotNull Pair<String, ? extends Object>... pairArr) {
        if (resultReceiver == null) {
            return null;
        }
        resultReceiver.send(2, BundleKt.Bundle(new ResultReceiverKt$wrong$2(pairArr)));
        return Unit.INSTANCE;
    }
}
