package kotlinx.serialization.json.internal;

import com.baidu.searchbox.datadebug.constant.DataType;
import com.baidu.searchbox.novel.main.youth.NovelMainFeedTabLayout;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.PrimitiveKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.descriptors.StructureKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.internal.NamedValueDecoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonArray;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonLiteral;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0001\n\u0000\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b2\u0018\u00002\u00020\u00012\u00020\u0002B\u0017\b\u0004\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0019\u001a\u00020\u0017H\u0014J\u0010\u0010\u001a\u001a\u00020\u00062\u0006\u0010\u001b\u001a\u00020\u0017H$J\b\u0010\u001c\u001a\u00020\u0006H\u0002J\b\u0010\u001d\u001a\u00020\u0006H\u0016J\b\u0010\u001e\u001a\u00020\u001fH\u0016J!\u0010 \u001a\u0002H!\"\u0004\b\u0000\u0010!2\f\u0010\"\u001a\b\u0012\u0004\u0012\u0002H!0#H\u0016¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010&\u001a\u00020'2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010*\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u0010,\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u0015H\u0014J\u0010\u0010/\u001a\u0002002\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0018\u00101\u001a\u0002022\u0006\u0010\u001b\u001a\u00020\u00172\u0006\u00103\u001a\u00020\u0015H\u0014J\u0010\u00104\u001a\u00020-2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00105\u001a\u0002062\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u00107\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0012\u00108\u001a\u0004\u0018\u0001092\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010:\u001a\u00020;2\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010<\u001a\u00020\u00172\u0006\u0010\u001b\u001a\u00020\u0017H\u0014J\u0010\u0010=\u001a\u00020>2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010?\u001a\u00020@2\u0006\u0010\u001b\u001a\u00020\u0017H\u0004J\u0010\u0010A\u001a\u0002092\u0006\u0010B\u001a\u00020\u0017H\u0002J\u0014\u0010C\u001a\u00020D*\u00020@2\u0006\u0010E\u001a\u00020\u0017H\u0002J?\u0010B\u001a\u0002H!\"\b\b\u0000\u0010!*\u00020F*\u00020@2\u0006\u0010B\u001a\u00020\u00172\u0019\u0010G\u001a\u0015\u0012\u0004\u0012\u00020@\u0012\u0006\u0012\u0004\u0018\u0001H!0H¢\u0006\u0002\bIH\b¢\u0006\u0002\u0010JR\u0010\u0010\b\u001a\u00020\t8\u0004X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011\u0001\u0003KLM¨\u0006N"}, d2 = {"Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "Lkotlinx/serialization/internal/NamedValueDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonElement;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonElement;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "getValue", "()Lkotlinx/serialization/json/JsonElement;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "composeName", "", "parentName", "childName", "currentElement", "tag", "currentObject", "decodeJsonElement", "decodeNotNullMark", "", "decodeSerializableValue", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeTaggedBoolean", "decodeTaggedByte", "", "decodeTaggedChar", "", "decodeTaggedDouble", "", "decodeTaggedEnum", "", "enumDescriptor", "decodeTaggedFloat", "", "decodeTaggedInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeTaggedInt", "decodeTaggedLong", "", "decodeTaggedNotNullMark", "decodeTaggedNull", "", "decodeTaggedShort", "", "decodeTaggedString", "endStructure", "", "getPrimitiveValue", "Lkotlinx/serialization/json/JsonPrimitive;", "unparsedPrimitive", "primitive", "asLiteral", "Lkotlinx/serialization/json/JsonLiteral;", "type", "", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "(Lkotlinx/serialization/json/JsonPrimitive;Ljava/lang/String;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "Lkotlinx/serialization/json/internal/JsonPrimitiveDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/JsonTreeListDecoder;", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TreeJsonDecoder.kt */
abstract class AbstractJsonTreeDecoder extends NamedValueDecoder implements JsonDecoder {
    protected final JsonConfiguration configuration;
    private final Json json;
    private final JsonElement value;

    public /* synthetic */ AbstractJsonTreeDecoder(Json json2, JsonElement jsonElement, DefaultConstructorMarker defaultConstructorMarker) {
        this(json2, jsonElement);
    }

    /* access modifiers changed from: protected */
    public abstract JsonElement currentElement(String str);

    public Json getJson() {
        return this.json;
    }

    public JsonElement getValue() {
        return this.value;
    }

    private AbstractJsonTreeDecoder(Json json2, JsonElement value2) {
        this.json = json2;
        this.value = value2;
        this.configuration = getJson().getConfiguration();
    }

    public SerializersModule getSerializersModule() {
        return getJson().getSerializersModule();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = currentElement(r0);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final kotlinx.serialization.json.JsonElement currentObject() {
        /*
            r2 = this;
            java.lang.Object r0 = r2.getCurrentTagOrNull()
            java.lang.String r0 = (java.lang.String) r0
            if (r0 == 0) goto L_0x000f
            r1 = 0
            kotlinx.serialization.json.JsonElement r0 = r2.currentElement(r0)
            if (r0 != 0) goto L_0x0013
        L_0x000f:
            kotlinx.serialization.json.JsonElement r0 = r2.getValue()
        L_0x0013:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.serialization.json.internal.AbstractJsonTreeDecoder.currentObject():kotlinx.serialization.json.JsonElement");
    }

    public JsonElement decodeJsonElement() {
        return currentObject();
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        return PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializer);
    }

    /* access modifiers changed from: protected */
    public String composeName(String parentName, String childName) {
        Intrinsics.checkNotNullParameter(parentName, "parentName");
        Intrinsics.checkNotNullParameter(childName, "childName");
        return childName;
    }

    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        CompositeDecoder compositeDecoder;
        SerialDescriptor serialDescriptor = descriptor;
        Intrinsics.checkNotNullParameter(serialDescriptor, "descriptor");
        JsonElement currentObject = currentObject();
        SerialKind kind = descriptor.getKind();
        if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.LIST.INSTANCE) ? true : kind instanceof PolymorphicKind) {
            Json json2 = getJson();
            if (currentObject instanceof JsonArray) {
                return new JsonTreeListDecoder(json2, (JsonArray) currentObject);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        } else if (Intrinsics.areEqual((Object) kind, (Object) StructureKind.MAP.INSTANCE)) {
            Json $this$selectMapMode$iv = getJson();
            SerialDescriptor keyDescriptor$iv = WriteModeKt.carrierDescriptor(serialDescriptor.getElementDescriptor(0), $this$selectMapMode$iv.getSerializersModule());
            SerialKind keyKind$iv = keyDescriptor$iv.getKind();
            if ((keyKind$iv instanceof PrimitiveKind) || Intrinsics.areEqual((Object) keyKind$iv, (Object) SerialKind.ENUM.INSTANCE)) {
                Json json3 = getJson();
                if (currentObject instanceof JsonObject) {
                    compositeDecoder = new JsonTreeMapDecoder(json3, (JsonObject) currentObject);
                } else {
                    throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
                }
            } else if ($this$selectMapMode$iv.getConfiguration().getAllowStructuredMapKeys()) {
                Json json4 = getJson();
                if (currentObject instanceof JsonArray) {
                    compositeDecoder = new JsonTreeListDecoder(json4, (JsonArray) currentObject);
                } else {
                    throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonArray.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
                }
            } else {
                throw JsonExceptionsKt.InvalidKeyKindException(keyDescriptor$iv);
            }
            return compositeDecoder;
        } else {
            Json json5 = getJson();
            if (currentObject instanceof JsonObject) {
                return new JsonTreeDecoder(json5, (JsonObject) currentObject, (String) null, (SerialDescriptor) null, 12, (DefaultConstructorMarker) null);
            }
            throw JsonExceptionsKt.JsonDecodingException(-1, "Expected " + Reflection.getOrCreateKotlinClass(JsonObject.class) + " as the serialized body of " + descriptor.getSerialName() + ", but had " + Reflection.getOrCreateKotlinClass(currentObject.getClass()));
        }
    }

    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    public boolean decodeNotNullMark() {
        return !(currentObject() instanceof JsonNull);
    }

    /* access modifiers changed from: protected */
    public final JsonPrimitive getPrimitiveValue(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonElement currentElement = currentElement(tag);
        JsonPrimitive jsonPrimitive = currentElement instanceof JsonPrimitive ? (JsonPrimitive) currentElement : null;
        if (jsonPrimitive != null) {
            return jsonPrimitive;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Expected JsonPrimitive at " + tag + ", found " + currentElement, currentObject().toString());
    }

    /* access modifiers changed from: protected */
    public int decodeTaggedEnum(String tag, SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow$default(enumDescriptor, getJson(), getPrimitiveValue(tag).getContent(), (String) null, 4, (Object) null);
    }

    /* access modifiers changed from: protected */
    public Void decodeTaggedNull(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return null;
    }

    /* access modifiers changed from: protected */
    public boolean decodeTaggedNotNullMark(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return currentElement(tag) != JsonNull.INSTANCE;
    }

    /* Debug info: failed to restart local var, previous not found, register: 8 */
    /* access modifiers changed from: protected */
    public boolean decodeTaggedBoolean(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive value2 = getPrimitiveValue(tag);
        if (getJson().getConfiguration().isLenient() || !asLiteral(value2, DataType.BOOLEAN).isString()) {
            try {
                Boolean booleanOrNull = JsonElementKt.getBooleanOrNull(value2);
                if (booleanOrNull != null) {
                    return booleanOrNull.booleanValue();
                }
                throw new IllegalArgumentException();
            } catch (IllegalArgumentException e2) {
                unparsedPrimitive(DataType.BOOLEAN);
                throw new KotlinNothingValueException();
            }
        } else {
            throw JsonExceptionsKt.JsonDecodingException(-1, "Boolean literal for key '" + tag + "' should be unquoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", currentObject().toString());
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 9 */
    /* access modifiers changed from: protected */
    public byte decodeTaggedByte(String tag) {
        Byte b2;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int result = JsonElementKt.getInt(getPrimitiveValue(tag));
            boolean z = false;
            if (-128 <= result && result <= 127) {
                z = true;
            }
            if (z) {
                b2 = Byte.valueOf((byte) result);
            } else {
                b2 = null;
            }
            if (b2 != null) {
                return b2.byteValue();
            }
            unparsedPrimitive("byte");
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive("byte");
            throw new KotlinNothingValueException();
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 9 */
    /* access modifiers changed from: protected */
    public short decodeTaggedShort(String tag) {
        Short sh;
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            int result = JsonElementKt.getInt(getPrimitiveValue(tag));
            boolean z = false;
            if (-32768 <= result && result <= 32767) {
                z = true;
            }
            if (z) {
                sh = Short.valueOf((short) result);
            } else {
                sh = null;
            }
            if (sh != null) {
                return sh.shortValue();
            }
            unparsedPrimitive(NovelMainFeedTabLayout.SHORT);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive(NovelMainFeedTabLayout.SHORT);
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    public int decodeTaggedInt(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return JsonElementKt.getInt(getPrimitiveValue(tag));
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive("int");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    public long decodeTaggedLong(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return JsonElementKt.getLong(getPrimitiveValue(tag));
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive("long");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    public float decodeTaggedFloat(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            float result = JsonElementKt.getFloat(getPrimitiveValue(tag));
            if (!getJson().getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!(!Float.isInfinite(result) && !Float.isNaN(result))) {
                    throw JsonExceptionsKt.InvalidFloatingPointDecoded(Float.valueOf(result), tag, currentObject().toString());
                }
            }
            return result;
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive("float");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    public double decodeTaggedDouble(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            double result = JsonElementKt.getDouble(getPrimitiveValue(tag));
            if (!getJson().getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!(!Double.isInfinite(result) && !Double.isNaN(result))) {
                    throw JsonExceptionsKt.InvalidFloatingPointDecoded(Double.valueOf(result), tag, currentObject().toString());
                }
            }
            return result;
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive("double");
            throw new KotlinNothingValueException();
        }
    }

    /* access modifiers changed from: protected */
    public char decodeTaggedChar(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        try {
            return StringsKt.single(getPrimitiveValue(tag).getContent());
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive("char");
            throw new KotlinNothingValueException();
        }
    }

    /* Debug info: failed to restart local var, previous not found, register: 3 */
    private final <T> T primitive(JsonPrimitive $this$primitive, String primitive, Function1<? super JsonPrimitive, ? extends T> block) {
        try {
            T invoke = block.invoke($this$primitive);
            if (invoke != null) {
                return invoke;
            }
            unparsedPrimitive(primitive);
            throw new KotlinNothingValueException();
        } catch (IllegalArgumentException e2) {
            unparsedPrimitive(primitive);
            throw new KotlinNothingValueException();
        }
    }

    private final Void unparsedPrimitive(String primitive) {
        throw JsonExceptionsKt.JsonDecodingException(-1, "Failed to parse '" + primitive + '\'', currentObject().toString());
    }

    /* access modifiers changed from: protected */
    public String decodeTaggedString(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        JsonPrimitive value2 = getPrimitiveValue(tag);
        if (!getJson().getConfiguration().isLenient() && !asLiteral(value2, "string").isString()) {
            throw JsonExceptionsKt.JsonDecodingException(-1, "String literal for key '" + tag + "' should be quoted.\nUse 'isLenient = true' in 'Json {}` builder to accept non-compliant JSON.", currentObject().toString());
        } else if (!(value2 instanceof JsonNull)) {
            return value2.getContent();
        } else {
            throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' value instead of string literal", currentObject().toString());
        }
    }

    private final JsonLiteral asLiteral(JsonPrimitive $this$asLiteral, String type) {
        JsonLiteral jsonLiteral = $this$asLiteral instanceof JsonLiteral ? (JsonLiteral) $this$asLiteral : null;
        if (jsonLiteral != null) {
            return jsonLiteral;
        }
        throw JsonExceptionsKt.JsonDecodingException(-1, "Unexpected 'null' when " + type + " was expected");
    }

    /* access modifiers changed from: protected */
    public Decoder decodeTaggedInline(String tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor)) {
            return new JsonDecoderForUnsignedTypes(new StringJsonLexer(getPrimitiveValue(tag).getContent()), getJson());
        }
        return super.decodeTaggedInline(tag, inlineDescriptor);
    }
}
