package kotlinx.serialization;

import androidx.exifinterface.media.ExifInterface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Triple;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlinx.serialization.builtins.BuiltinSerializersKt;
import kotlinx.serialization.internal.ArrayListSerializer;
import kotlinx.serialization.internal.HashMapSerializer;
import kotlinx.serialization.internal.HashSetSerializer;
import kotlinx.serialization.internal.LinkedHashMapSerializer;
import kotlinx.serialization.internal.LinkedHashSetSerializer;
import kotlinx.serialization.internal.PlatformKt;
import kotlinx.serialization.internal.Platform_commonKt;
import kotlinx.serialization.internal.PrimitivesKt;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\u001a\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001H\b\u001a\u0016\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a\u0018\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00012\u0006\u0010\u0004\u001a\u00020\u0005\u001a?\u0010\u0007\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0003\u0018\u00010\u0001*\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00050\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\b\u000f\u001a1\u0010\u0010\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\u00012\u0006\u0010\u0011\u001a\u00020\u000eH\u0002¢\u0006\u0002\b\u0012\u001aB\u0010\u0013\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u00020\b2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u0002H\u00020\f2\u0014\u0010\u0015\u001a\u0010\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u00010\nH\u0000\u001a\"\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007\u001a\u001b\u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0006\b\u0000\u0010\u0002\u0018\u0001*\u00020\bH\b\u001a\u001a\u0010\u0000\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005\u001a+\u0010\u0016\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0002\b\u0017\u001a$\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\u0002\u0018\u00010\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\b\u0012\u0004\u0012\u0002H\u00020\fH\u0007\u001a\u001c\u0010\u0006\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u0001*\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005¨\u0006\u0018"}, d2 = {"serializer", "Lkotlinx/serialization/KSerializer;", "T", "", "type", "Lkotlin/reflect/KType;", "serializerOrNull", "builtinSerializer", "Lkotlinx/serialization/modules/SerializersModule;", "typeArguments", "", "rootClass", "Lkotlin/reflect/KClass;", "failOnMissingTypeArgSerializer", "", "builtinSerializer$SerializersKt__SerializersKt", "nullable", "shouldBeNullable", "nullable$SerializersKt__SerializersKt", "reflectiveOrContextual", "kClass", "typeArgumentsSerializers", "serializerByKTypeImpl", "serializerByKTypeImpl$SerializersKt__SerializersKt", "kotlinx-serialization-core"}, k = 5, mv = {1, 6, 0}, xi = 48, xs = "kotlinx/serialization/SerializersKt")
/* compiled from: Serializers.kt */
final /* synthetic */ class SerializersKt__SerializersKt {
    public static final /* synthetic */ <T> KSerializer<T> serializer(SerializersModule $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        return SerializersKt.serializer($this$serializer, (KType) null);
    }

    public static final KSerializer<Object> serializer(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializer(SerializersModuleKt.getEmptySerializersModule(), type);
    }

    public static final KSerializer<Object> serializerOrNull(KType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        return SerializersKt.serializerOrNull(SerializersModuleKt.getEmptySerializersModule(), type);
    }

    public static final KSerializer<Object> serializer(SerializersModule $this$serializer, KType type) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt = serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializer, type, true);
        if (serializerByKTypeImpl$SerializersKt__SerializersKt != null) {
            return serializerByKTypeImpl$SerializersKt__SerializersKt;
        }
        PlatformKt.platformSpecificSerializerNotRegistered(Platform_commonKt.kclass(type));
        throw new KotlinNothingValueException();
    }

    public static final KSerializer<Object> serializerOrNull(SerializersModule $this$serializerOrNull, KType type) {
        Intrinsics.checkNotNullParameter($this$serializerOrNull, "<this>");
        Intrinsics.checkNotNullParameter(type, "type");
        return serializerByKTypeImpl$SerializersKt__SerializersKt($this$serializerOrNull, type, false);
    }

    private static final KSerializer<Object> serializerByKTypeImpl$SerializersKt__SerializersKt(SerializersModule $this$serializerByKTypeImpl, KType type, boolean failOnMissingTypeArgSerializer) {
        KSerializer result;
        KClass rootClass = Platform_commonKt.kclass(type);
        boolean isNullable = type.isMarkedNullable();
        Iterable<KTypeProjection> $this$map$iv = type.getArguments();
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (KTypeProjection it : $this$map$iv) {
            KType type2 = it.getType();
            if (type2 != null) {
                destination$iv$iv.add(type2);
            } else {
                throw new IllegalArgumentException(("Star projections in type arguments are not allowed, but had " + type).toString());
            }
        }
        List typeArguments = (List) destination$iv$iv;
        if (typeArguments.isEmpty()) {
            result = SerializersKt.serializerOrNull(rootClass);
            if (result == null) {
                result = SerializersModule.getContextual$default($this$serializerByKTypeImpl, rootClass, (List) null, 2, (Object) null);
            }
        } else {
            result = builtinSerializer$SerializersKt__SerializersKt($this$serializerByKTypeImpl, typeArguments, rootClass, failOnMissingTypeArgSerializer);
        }
        if (result == null) {
            result = null;
        }
        if (result != null) {
            return nullable$SerializersKt__SerializersKt(result, isNullable);
        }
        return null;
    }

    private static final KSerializer<? extends Object> builtinSerializer$SerializersKt__SerializersKt(SerializersModule $this$builtinSerializer, List<? extends KType> typeArguments, KClass<Object> rootClass, boolean failOnMissingTypeArgSerializer) {
        List serializers;
        if (failOnMissingTypeArgSerializer) {
            Iterable<KType> $this$map$iv = typeArguments;
            Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
            for (KType p0 : $this$map$iv) {
                destination$iv$iv.add(SerializersKt.serializer($this$builtinSerializer, p0));
            }
            serializers = (List) destination$iv$iv;
        } else {
            Iterable<KType> $this$map$iv2 = typeArguments;
            Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
            for (KType it : $this$map$iv2) {
                KSerializer<Object> serializerOrNull = SerializersKt.serializerOrNull($this$builtinSerializer, it);
                if (serializerOrNull == null) {
                    return null;
                }
                destination$iv$iv2.add(serializerOrNull);
            }
            serializers = (List) destination$iv$iv2;
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Collection.class)) ? true : Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(List.class)) ? true : Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(List.class)) ? true : Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(ArrayList.class))) {
            return new ArrayListSerializer<>((KSerializer) serializers.get(0));
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(HashSet.class))) {
            return new HashSetSerializer<>((KSerializer) serializers.get(0));
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Set.class)) ? true : Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Set.class)) ? true : Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(LinkedHashSet.class))) {
            return new LinkedHashSetSerializer<>((KSerializer) serializers.get(0));
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(HashMap.class))) {
            return new HashMapSerializer<>((KSerializer) serializers.get(0), (KSerializer) serializers.get(1));
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Map.class)) ? true : Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Map.class)) ? true : Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(LinkedHashMap.class))) {
            return new LinkedHashMapSerializer<>((KSerializer) serializers.get(0), (KSerializer) serializers.get(1));
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Map.Entry.class))) {
            return BuiltinSerializersKt.MapEntrySerializer((KSerializer) serializers.get(0), (KSerializer) serializers.get(1));
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Pair.class))) {
            return BuiltinSerializersKt.PairSerializer((KSerializer) serializers.get(0), (KSerializer) serializers.get(1));
        }
        if (Intrinsics.areEqual((Object) rootClass, (Object) Reflection.getOrCreateKotlinClass(Triple.class))) {
            return BuiltinSerializersKt.TripleSerializer((KSerializer) serializers.get(0), (KSerializer) serializers.get(1), (KSerializer) serializers.get(2));
        }
        if (PlatformKt.isReferenceArray(rootClass)) {
            KClassifier classifier = ((KType) typeArguments.get(0)).getClassifier();
            if (classifier != null) {
                return BuiltinSerializersKt.ArraySerializer((KClass) classifier, (KSerializer) serializers.get(0));
            }
            throw new NullPointerException("null cannot be cast to non-null type kotlin.reflect.KClass<kotlin.Any>");
        }
        Object[] array = serializers.toArray(new KSerializer[0]);
        if (array != null) {
            KSerializer[] args = (KSerializer[]) array;
            KSerializer<? extends Object> constructSerializerForGivenTypeArgs = PlatformKt.constructSerializerForGivenTypeArgs(rootClass, (KSerializer<Object>[]) (KSerializer[]) Arrays.copyOf(args, args.length));
            if (constructSerializerForGivenTypeArgs == null) {
                return SerializersKt.reflectiveOrContextual($this$builtinSerializer, rootClass, serializers);
            }
            return constructSerializerForGivenTypeArgs;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
    }

    public static final <T> KSerializer<T> reflectiveOrContextual(SerializersModule $this$reflectiveOrContextual, KClass<T> kClass, List<? extends KSerializer<Object>> typeArgumentsSerializers) {
        Intrinsics.checkNotNullParameter($this$reflectiveOrContextual, "<this>");
        Intrinsics.checkNotNullParameter(kClass, "kClass");
        Intrinsics.checkNotNullParameter(typeArgumentsSerializers, "typeArgumentsSerializers");
        KSerializer<T> serializerOrNull = SerializersKt.serializerOrNull(kClass);
        return serializerOrNull == null ? $this$reflectiveOrContextual.getContextual(kClass, typeArgumentsSerializers) : serializerOrNull;
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializer(KClass<T> $this$serializer) {
        Intrinsics.checkNotNullParameter($this$serializer, "<this>");
        KSerializer<T> serializerOrNull = SerializersKt.serializerOrNull($this$serializer);
        if (serializerOrNull != null) {
            return serializerOrNull;
        }
        Platform_commonKt.serializerNotRegistered($this$serializer);
        throw new KotlinNothingValueException();
    }

    @InternalSerializationApi
    public static final <T> KSerializer<T> serializerOrNull(KClass<T> $this$serializerOrNull) {
        Intrinsics.checkNotNullParameter($this$serializerOrNull, "<this>");
        KSerializer<T> compiledSerializerImpl = PlatformKt.compiledSerializerImpl($this$serializerOrNull);
        return compiledSerializerImpl == null ? PrimitivesKt.builtinSerializerOrNull($this$serializerOrNull) : compiledSerializerImpl;
    }

    private static final <T> KSerializer<T> nullable$SerializersKt__SerializersKt(KSerializer<T> $this$nullable, boolean shouldBeNullable) {
        if (shouldBeNullable) {
            return BuiltinSerializersKt.getNullable($this$nullable);
        }
        return $this$nullable;
    }
}
