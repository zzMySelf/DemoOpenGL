package kotlinx.serialization.internal;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlinx.serialization.KSerializer;
import kotlinx.serialization.Polymorphic;
import kotlinx.serialization.PolymorphicSerializer;
import kotlinx.serialization.Serializable;
import kotlinx.serialization.SerializationException;

@Metadata(d1 = {"\u0000L\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0018\n\u0002\b\u0005\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aO\u0010\u0000\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0002¢\u0006\u0002\u0010\b\u001a\u0016\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\fH\u0000\u001a\u0012\u0010\r\u001a\u0004\u0018\u00010\u0003*\u0006\u0012\u0002\b\u00030\u0005H\u0002\u001a$\u0010\u000e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00052\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\b\u001aM\u0010\u000f\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\f2\"\u0010\u0006\u001a\u0012\u0012\u000e\b\u0001\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\u0007\"\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001H\u0000¢\u0006\u0002\u0010\u0010\u001a$\u0010\u0011\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a$\u0010\u0012\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a&\u0010\u0013\u001a\u0002H\u0002\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u0015H\b¢\u0006\u0002\u0010\u0016\u001a\u0015\u0010\u0013\u001a\u00020\n*\u00020\u00172\u0006\u0010\u0014\u001a\u00020\u0015H\b\u001a$\u0010\u0018\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0018\u0010\u0019\u001a\u00020\n*\u00020\u00032\n\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\fH\u0000\u001a\u001c\u0010\u001b\u001a\u00020\n\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001c\u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\fH\u0000\u001a$\u0010\u001e\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0002\u001a\u0010\u0010\u001f\u001a\u00020\u001d*\u0006\u0012\u0002\b\u00030\u0005H\u0000\u001aK\u0010 \u001a\b\u0012\u0004\u0012\u0002H!0\u0007\"\b\b\u0000\u0010\u0002*\u00020\u0003\"\n\b\u0001\u0010!*\u0004\u0018\u0001H\u0002*\u0012\u0012\u0004\u0012\u0002H!0\"j\b\u0012\u0004\u0012\u0002H!`#2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H\u00020\fH\u0000¢\u0006\u0002\u0010%¨\u0006&"}, d2 = {"invokeSerializerOnCompanion", "Lkotlinx/serialization/KSerializer;", "T", "", "jClass", "Ljava/lang/Class;", "args", "", "(Ljava/lang/Class;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "isReferenceArray", "", "rootClass", "Lkotlin/reflect/KClass;", "companionOrNull", "compiledSerializerImpl", "constructSerializerForGivenTypeArgs", "(Lkotlin/reflect/KClass;[Lkotlinx/serialization/KSerializer;)Lkotlinx/serialization/KSerializer;", "createEnumSerializer", "findObjectSerializer", "getChecked", "index", "", "([Ljava/lang/Object;I)Ljava/lang/Object;", "", "interfaceSerializer", "isInstanceOf", "kclass", "isNotAnnotated", "platformSpecificSerializerNotRegistered", "", "polymorphicSerializer", "serializerNotRegistered", "toNativeArrayImpl", "E", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "eClass", "(Ljava/util/ArrayList;Lkotlin/reflect/KClass;)[Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: Platform.kt */
public final class PlatformKt {
    public static final <T> T getChecked(T[] $this$getChecked, int index) {
        Intrinsics.checkNotNullParameter($this$getChecked, "<this>");
        return $this$getChecked[index];
    }

    public static final boolean getChecked(boolean[] $this$getChecked, int index) {
        Intrinsics.checkNotNullParameter($this$getChecked, "<this>");
        return $this$getChecked[index];
    }

    public static final <T> KSerializer<T> compiledSerializerImpl(KClass<T> $this$compiledSerializerImpl) {
        Intrinsics.checkNotNullParameter($this$compiledSerializerImpl, "<this>");
        return constructSerializerForGivenTypeArgs($this$compiledSerializerImpl, (KSerializer<Object>[]) new KSerializer[0]);
    }

    public static final <T, E extends T> E[] toNativeArrayImpl(ArrayList<E> $this$toNativeArrayImpl, KClass<T> eClass) {
        Intrinsics.checkNotNullParameter($this$toNativeArrayImpl, "<this>");
        Intrinsics.checkNotNullParameter(eClass, "eClass");
        Object newInstance = Array.newInstance(JvmClassMappingKt.getJavaClass(eClass), $this$toNativeArrayImpl.size());
        if (newInstance != null) {
            E[] array = $this$toNativeArrayImpl.toArray((Object[]) newInstance);
            Intrinsics.checkNotNullExpressionValue(array, "toArray(java.lang.reflec….java, size) as Array<E>)");
            return array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<E of kotlinx.serialization.internal.PlatformKt.toNativeArrayImpl>");
    }

    public static final Void platformSpecificSerializerNotRegistered(KClass<?> $this$platformSpecificSerializerNotRegistered) {
        Intrinsics.checkNotNullParameter($this$platformSpecificSerializerNotRegistered, "<this>");
        Platform_commonKt.serializerNotRegistered($this$platformSpecificSerializerNotRegistered);
        throw new KotlinNothingValueException();
    }

    public static final Void serializerNotRegistered(Class<?> $this$serializerNotRegistered) {
        Intrinsics.checkNotNullParameter($this$serializerNotRegistered, "<this>");
        throw new SerializationException("Serializer for class '" + $this$serializerNotRegistered.getSimpleName() + "' is not found.\nMark the class as @Serializable or provide the serializer explicitly.");
    }

    public static final <T> KSerializer<T> constructSerializerForGivenTypeArgs(KClass<T> $this$constructSerializerForGivenTypeArgs, KSerializer<Object>... args) {
        Intrinsics.checkNotNullParameter($this$constructSerializerForGivenTypeArgs, "<this>");
        Intrinsics.checkNotNullParameter(args, "args");
        return constructSerializerForGivenTypeArgs(JvmClassMappingKt.getJavaClass($this$constructSerializerForGivenTypeArgs), (KSerializer<Object>[]) (KSerializer[]) Arrays.copyOf(args, args.length));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0075, code lost:
        r2 = r4.getField("INSTANCE");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <T> kotlinx.serialization.KSerializer<T> constructSerializerForGivenTypeArgs(java.lang.Class<T> r13, kotlinx.serialization.KSerializer<java.lang.Object>... r14) {
        /*
            java.lang.String r0 = "<this>"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r13, r0)
            java.lang.String r0 = "args"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r14, r0)
            boolean r0 = r13.isEnum()
            if (r0 == 0) goto L_0x001b
            boolean r0 = isNotAnnotated(r13)
            if (r0 == 0) goto L_0x001b
            kotlinx.serialization.KSerializer r0 = createEnumSerializer(r13)
            return r0
        L_0x001b:
            boolean r0 = r13.isInterface()
            if (r0 == 0) goto L_0x0026
            kotlinx.serialization.KSerializer r0 = interfaceSerializer(r13)
            return r0
        L_0x0026:
            int r0 = r14.length
            java.lang.Object[] r0 = java.util.Arrays.copyOf(r14, r0)
            kotlinx.serialization.KSerializer[] r0 = (kotlinx.serialization.KSerializer[]) r0
            kotlinx.serialization.KSerializer r0 = invokeSerializerOnCompanion(r13, r0)
            if (r0 == 0) goto L_0x0034
            return r0
        L_0x0034:
            kotlinx.serialization.KSerializer r1 = findObjectSerializer(r13)
            if (r1 == 0) goto L_0x003c
            r2 = 0
            return r1
        L_0x003c:
            r1 = 0
            java.lang.Class[] r2 = r13.getDeclaredClasses()     // Catch:{ NoSuchFieldException -> 0x008c }
            java.lang.String r3 = "declaredClasses"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)     // Catch:{ NoSuchFieldException -> 0x008c }
            java.lang.Object[] r2 = (java.lang.Object[]) r2     // Catch:{ NoSuchFieldException -> 0x008c }
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            int r7 = r2.length     // Catch:{ NoSuchFieldException -> 0x008c }
        L_0x004f:
            if (r6 >= r7) goto L_0x006c
            r8 = r2[r6]     // Catch:{ NoSuchFieldException -> 0x008c }
            r9 = r8
            java.lang.Class r9 = (java.lang.Class) r9     // Catch:{ NoSuchFieldException -> 0x008c }
            r10 = 0
            java.lang.String r11 = r9.getSimpleName()     // Catch:{ NoSuchFieldException -> 0x008c }
            java.lang.String r12 = "$serializer"
            boolean r11 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r11, (java.lang.Object) r12)     // Catch:{ NoSuchFieldException -> 0x008c }
            if (r11 == 0) goto L_0x0069
            if (r5 == 0) goto L_0x0067
            r4 = r1
            goto L_0x0071
        L_0x0067:
            r4 = r8
            r5 = 1
        L_0x0069:
            int r6 = r6 + 1
            goto L_0x004f
        L_0x006c:
            if (r5 != 0) goto L_0x0070
            r4 = r1
            goto L_0x0071
        L_0x0070:
        L_0x0071:
            java.lang.Class r4 = (java.lang.Class) r4     // Catch:{ NoSuchFieldException -> 0x008c }
            if (r4 == 0) goto L_0x0083
            java.lang.String r2 = "INSTANCE"
            java.lang.reflect.Field r2 = r4.getField(r2)     // Catch:{ NoSuchFieldException -> 0x008c }
            if (r2 == 0) goto L_0x0083
            java.lang.Object r2 = r2.get(r1)     // Catch:{ NoSuchFieldException -> 0x008c }
            goto L_0x0084
        L_0x0083:
            r2 = r1
        L_0x0084:
            boolean r3 = r2 instanceof kotlinx.serialization.KSerializer     // Catch:{ NoSuchFieldException -> 0x008c }
            if (r3 == 0) goto L_0x0090
            kotlinx.serialization.KSerializer r2 = (kotlinx.serialization.KSerializer) r2     // Catch:{ NoSuchFieldException -> 0x008c }
            r1 = r2
            goto L_0x0090
        L_0x008c:
            r2 = move-exception
            r3 = r1
            kotlinx.serialization.KSerializer r3 = (kotlinx.serialization.KSerializer) r3
        L_0x0090:
            if (r1 == 0) goto L_0x0094
            return r1
        L_0x0094:
            kotlinx.serialization.KSerializer r2 = polymorphicSerializer(r13)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.constructSerializerForGivenTypeArgs(java.lang.Class, kotlinx.serialization.KSerializer[]):kotlinx.serialization.KSerializer");
    }

    private static final <T> boolean isNotAnnotated(Class<T> $this$isNotAnnotated) {
        return $this$isNotAnnotated.getAnnotation(Serializable.class) == null && $this$isNotAnnotated.getAnnotation(Polymorphic.class) == null;
    }

    private static final <T> KSerializer<T> polymorphicSerializer(Class<T> $this$polymorphicSerializer) {
        if ($this$polymorphicSerializer.getAnnotation(Polymorphic.class) != null) {
            return new PolymorphicSerializer<>(JvmClassMappingKt.getKotlinClass($this$polymorphicSerializer));
        }
        Serializable serializable = (Serializable) $this$polymorphicSerializer.getAnnotation(Serializable.class);
        if (serializable == null || !Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return null;
        }
        return new PolymorphicSerializer<>(JvmClassMappingKt.getKotlinClass($this$polymorphicSerializer));
    }

    private static final <T> KSerializer<T> interfaceSerializer(Class<T> $this$interfaceSerializer) {
        Serializable serializable = (Serializable) $this$interfaceSerializer.getAnnotation(Serializable.class);
        if (serializable == null || Intrinsics.areEqual((Object) Reflection.getOrCreateKotlinClass(serializable.with()), (Object) Reflection.getOrCreateKotlinClass(PolymorphicSerializer.class))) {
            return new PolymorphicSerializer<>(JvmClassMappingKt.getKotlinClass($this$interfaceSerializer));
        }
        return null;
    }

    private static final <T> KSerializer<T> invokeSerializerOnCompanion(Class<?> jClass, KSerializer<Object>... args) {
        Class[] clsArr;
        Object companion = companionOrNull(jClass);
        if (companion == null) {
            return null;
        }
        try {
            if (args.length == 0) {
                clsArr = (Class[]) ((Object[]) new Class[0]);
            } else {
                int length = args.length;
                Class[] clsArr2 = new Class[length];
                for (int i2 = 0; i2 < length; i2++) {
                    clsArr2[i2] = KSerializer.class;
                }
                clsArr = clsArr2;
            }
            Class[] types = clsArr;
            Object invoke = companion.getClass().getDeclaredMethod("serializer", (Class[]) Arrays.copyOf(types, types.length)).invoke(companion, Arrays.copyOf(args, args.length));
            if (invoke instanceof KSerializer) {
                return (KSerializer) invoke;
            }
            return null;
        } catch (NoSuchMethodException e2) {
            KSerializer kSerializer = null;
            return null;
        } catch (InvocationTargetException e3) {
            Throwable cause = e3.getCause();
            if (cause != null) {
                String message = cause.getMessage();
                if (message == null) {
                    message = e3.getMessage();
                }
                throw new InvocationTargetException(cause, message);
            }
            throw e3;
        }
    }

    private static final Object companionOrNull(Class<?> $this$companionOrNull) {
        try {
            Field companion = $this$companionOrNull.getDeclaredField("Companion");
            companion.setAccessible(true);
            return companion.get((Object) null);
        } catch (Throwable th2) {
            return null;
        }
    }

    private static final <T> KSerializer<T> createEnumSerializer(Class<T> $this$createEnumSerializer) {
        Object[] constants = $this$createEnumSerializer.getEnumConstants();
        String canonicalName = $this$createEnumSerializer.getCanonicalName();
        Intrinsics.checkNotNullExpressionValue(canonicalName, "canonicalName");
        if (constants != null) {
            EnumSerializer enumSerializer = new EnumSerializer(canonicalName, (Enum[]) constants);
            if (enumSerializer instanceof KSerializer) {
                return enumSerializer;
            }
            return null;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<out kotlin.Enum<*>>");
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0049 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00ad A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static final <T> kotlinx.serialization.KSerializer<T> findObjectSerializer(java.lang.Class<T> r16) {
        /*
            java.lang.reflect.Field[] r0 = r16.getDeclaredFields()
            java.lang.String r1 = "declaredFields"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r1)
            java.lang.Object[] r0 = (java.lang.Object[]) r0
            r1 = 0
            r2 = 0
            r3 = 0
            int r4 = r0.length
            r5 = 0
            r6 = r5
        L_0x0011:
            r8 = 0
            if (r6 >= r4) goto L_0x004c
            r9 = r0[r6]
            r10 = r9
            java.lang.reflect.Field r10 = (java.lang.reflect.Field) r10
            r11 = 0
            java.lang.String r12 = r10.getName()
            java.lang.String r13 = "INSTANCE"
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x003e
            java.lang.Class r12 = r10.getType()
            r13 = r16
            boolean r12 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r12, (java.lang.Object) r13)
            if (r12 == 0) goto L_0x0040
            int r12 = r10.getModifiers()
            boolean r12 = java.lang.reflect.Modifier.isStatic(r12)
            if (r12 == 0) goto L_0x0040
            r10 = 1
            goto L_0x0041
        L_0x003e:
            r13 = r16
        L_0x0040:
            r10 = r5
        L_0x0041:
            if (r10 == 0) goto L_0x0049
            if (r3 == 0) goto L_0x0047
            r2 = r8
            goto L_0x0053
        L_0x0047:
            r2 = r9
            r3 = 1
        L_0x0049:
            int r6 = r6 + 1
            goto L_0x0011
        L_0x004c:
            r13 = r16
            if (r3 != 0) goto L_0x0052
            r2 = r8
            goto L_0x0053
        L_0x0052:
        L_0x0053:
            java.lang.reflect.Field r2 = (java.lang.reflect.Field) r2
            if (r2 != 0) goto L_0x0058
            return r8
        L_0x0058:
            r0 = r2
            java.lang.Object r1 = r0.get(r8)
            java.lang.reflect.Method[] r2 = r16.getMethods()
            java.lang.String r3 = "methods"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r2, r3)
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            r3 = 0
            r4 = 0
            r6 = 0
            int r9 = r2.length
            r10 = r5
        L_0x006e:
            if (r10 >= r9) goto L_0x00b0
            r11 = r2[r10]
            r12 = r11
            java.lang.reflect.Method r12 = (java.lang.reflect.Method) r12
            r14 = 0
            java.lang.String r15 = r12.getName()
            java.lang.String r7 = "serializer"
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r15, (java.lang.Object) r7)
            if (r7 == 0) goto L_0x00a4
            java.lang.Class[] r7 = r12.getParameterTypes()
            java.lang.String r15 = "it.parameterTypes"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r7, r15)
            java.lang.Object[] r7 = (java.lang.Object[]) r7
            int r7 = r7.length
            if (r7 != 0) goto L_0x0093
            r7 = 1
            goto L_0x0094
        L_0x0093:
            r7 = r5
        L_0x0094:
            if (r7 == 0) goto L_0x00a4
            java.lang.Class r7 = r12.getReturnType()
            java.lang.Class<kotlinx.serialization.KSerializer> r15 = kotlinx.serialization.KSerializer.class
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r15)
            if (r7 == 0) goto L_0x00a4
            r7 = 1
            goto L_0x00a5
        L_0x00a4:
            r7 = r5
        L_0x00a5:
            if (r7 == 0) goto L_0x00ad
            if (r6 == 0) goto L_0x00ab
            r4 = r8
            goto L_0x00b5
        L_0x00ab:
            r4 = r11
            r6 = 1
        L_0x00ad:
            int r10 = r10 + 1
            goto L_0x006e
        L_0x00b0:
            if (r6 != 0) goto L_0x00b4
            r4 = r8
            goto L_0x00b5
        L_0x00b4:
        L_0x00b5:
            java.lang.reflect.Method r4 = (java.lang.reflect.Method) r4
            if (r4 != 0) goto L_0x00ba
            return r8
        L_0x00ba:
            r2 = r4
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.Object r3 = r2.invoke(r1, r3)
            boolean r4 = r3 instanceof kotlinx.serialization.KSerializer
            if (r4 == 0) goto L_0x00c8
            r8 = r3
            kotlinx.serialization.KSerializer r8 = (kotlinx.serialization.KSerializer) r8
        L_0x00c8:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.internal.PlatformKt.findObjectSerializer(java.lang.Class):kotlinx.serialization.KSerializer");
    }

    public static final boolean isInstanceOf(Object $this$isInstanceOf, KClass<?> kclass) {
        Intrinsics.checkNotNullParameter($this$isInstanceOf, "<this>");
        Intrinsics.checkNotNullParameter(kclass, "kclass");
        return JvmClassMappingKt.getJavaObjectType(kclass).isInstance($this$isInstanceOf);
    }

    public static final boolean isReferenceArray(KClass<Object> rootClass) {
        Intrinsics.checkNotNullParameter(rootClass, "rootClass");
        return JvmClassMappingKt.getJavaClass(rootClass).isArray();
    }
}
