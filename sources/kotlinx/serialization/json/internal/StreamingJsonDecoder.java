package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.MissingFieldException;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.AbstractDecoder;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.encoding.Decoder;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonConfiguration;
import kotlinx.serialization.json.JsonDecoder;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000¨\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0010\u0018\u00002\u00020\u00012\u00020\u0002B%\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000fH\u0002J\b\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020!H\u0016J\b\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020%H\u0016J\u0010\u0010&\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010'\u001a\u00020\u000f2\u0006\u0010(\u001a\u00020\nH\u0016J\b\u0010)\u001a\u00020*H\u0016J\u0010\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\nH\u0016J\b\u0010.\u001a\u00020\u000fH\u0016J\b\u0010/\u001a\u000200H\u0016J\b\u00101\u001a\u00020\u000fH\u0002J\b\u00102\u001a\u000203H\u0016J\b\u00104\u001a\u00020\u000fH\u0002J\b\u00105\u001a\u00020\u001dH\u0016J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\u0010\u00108\u001a\u00020\u000f2\u0006\u0010\t\u001a\u00020\nH\u0002J;\u00109\u001a\u0002H:\"\u0004\b\u0000\u0010:2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u000f2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<2\b\u0010=\u001a\u0004\u0018\u0001H:H\u0016¢\u0006\u0002\u0010>J!\u0010?\u001a\u0002H:\"\u0004\b\u0000\u0010:2\f\u0010;\u001a\b\u0012\u0004\u0012\u0002H:0<H\u0016¢\u0006\u0002\u0010@J\b\u0010A\u001a\u00020BH\u0016J\b\u0010C\u001a\u00020DH\u0016J\b\u0010E\u001a\u00020DH\u0002J\u0010\u0010F\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010G\u001a\u00020\u001d2\u0006\u0010H\u001a\u00020DH\u0002J\u0010\u0010I\u001a\u00020\u001b2\u0006\u0010\t\u001a\u00020\nH\u0002R\u000e\u0010\f\u001a\u00020\rX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0010\u0010\u0007\u001a\u00020\b8\u0000X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\u00020\u0015X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017¨\u0006J"}, d2 = {"Lkotlinx/serialization/json/internal/StreamingJsonDecoder;", "Lkotlinx/serialization/json/JsonDecoder;", "Lkotlinx/serialization/encoding/AbstractDecoder;", "json", "Lkotlinx/serialization/json/Json;", "mode", "Lkotlinx/serialization/json/internal/WriteMode;", "lexer", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/internal/WriteMode;Lkotlinx/serialization/json/internal/AbstractJsonLexer;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "configuration", "Lkotlinx/serialization/json/JsonConfiguration;", "currentIndex", "", "elementMarker", "Lkotlinx/serialization/json/internal/JsonElementMarker;", "getJson", "()Lkotlinx/serialization/json/Json;", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "checkLeadingComma", "", "coerceInputValue", "", "index", "decodeBoolean", "decodeByte", "", "decodeChar", "", "decodeDouble", "", "decodeElementIndex", "decodeEnum", "enumDescriptor", "decodeFloat", "", "decodeInline", "Lkotlinx/serialization/encoding/Decoder;", "inlineDescriptor", "decodeInt", "decodeJsonElement", "Lkotlinx/serialization/json/JsonElement;", "decodeListIndex", "decodeLong", "", "decodeMapIndex", "decodeNotNullMark", "decodeNull", "", "decodeObjectIndex", "decodeSerializableElement", "T", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "previousValue", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/DeserializationStrategy;Ljava/lang/Object;)Ljava/lang/Object;", "decodeSerializableValue", "(Lkotlinx/serialization/DeserializationStrategy;)Ljava/lang/Object;", "decodeShort", "", "decodeString", "", "decodeStringKey", "endStructure", "handleUnknown", "key", "skipLeftoverElements", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StreamingJsonDecoder.kt */
public class StreamingJsonDecoder extends AbstractDecoder implements JsonDecoder {
    private final JsonConfiguration configuration;
    private int currentIndex = -1;
    private final JsonElementMarker elementMarker;
    private final Json json;
    public final AbstractJsonLexer lexer;
    private final WriteMode mode;
    private final SerializersModule serializersModule;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: StreamingJsonDecoder.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WriteMode.values().length];
            iArr[WriteMode.LIST.ordinal()] = 1;
            iArr[WriteMode.MAP.ordinal()] = 2;
            iArr[WriteMode.POLY_OBJ.ordinal()] = 3;
            iArr[WriteMode.OBJ.ordinal()] = 4;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Json getJson() {
        return this.json;
    }

    public StreamingJsonDecoder(Json json2, WriteMode mode2, AbstractJsonLexer lexer2, SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(json2, "json");
        Intrinsics.checkNotNullParameter(mode2, "mode");
        Intrinsics.checkNotNullParameter(lexer2, "lexer");
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        this.json = json2;
        this.mode = mode2;
        this.lexer = lexer2;
        this.serializersModule = json2.getSerializersModule();
        JsonConfiguration configuration2 = json2.getConfiguration();
        this.configuration = configuration2;
        this.elementMarker = configuration2.getExplicitNulls() ? null : new JsonElementMarker(descriptor);
    }

    public SerializersModule getSerializersModule() {
        return this.serializersModule;
    }

    public JsonElement decodeJsonElement() {
        return new JsonTreeReader(this.json.getConfiguration(), this.lexer).read();
    }

    public <T> T decodeSerializableValue(DeserializationStrategy<T> deserializer) {
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        try {
            return PolymorphicKt.decodeSerializableValuePolymorphic(this, deserializer);
        } catch (MissingFieldException e2) {
            throw new MissingFieldException(e2.getMessage() + " at path: " + this.lexer.path.getPath(), (Throwable) e2);
        }
    }

    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        StreamingJsonDecoder streamingJsonDecoder;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        WriteMode newMode = WriteModeKt.switchMode(this.json, descriptor);
        this.lexer.path.pushDescriptor(descriptor);
        this.lexer.consumeNextToken(newMode.begin);
        checkLeadingComma();
        switch (WhenMappings.$EnumSwitchMapping$0[newMode.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return new StreamingJsonDecoder(this.json, newMode, this.lexer, descriptor);
            default:
                if (this.mode != newMode || !this.json.getConfiguration().getExplicitNulls()) {
                    streamingJsonDecoder = new StreamingJsonDecoder(this.json, newMode, this.lexer, descriptor);
                } else {
                    streamingJsonDecoder = this;
                }
                return streamingJsonDecoder;
        }
    }

    public void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (this.json.getConfiguration().getIgnoreUnknownKeys() && descriptor.getElementsCount() == 0) {
            skipLeftoverElements(descriptor);
        }
        this.lexer.consumeNextToken(this.mode.end);
        this.lexer.path.popDescriptor();
    }

    private final void skipLeftoverElements(SerialDescriptor descriptor) {
        do {
        } while (decodeElementIndex(descriptor) != -1);
    }

    public boolean decodeNotNullMark() {
        JsonElementMarker jsonElementMarker = this.elementMarker;
        return !(jsonElementMarker != null ? jsonElementMarker.isUnmarkedNull$kotlinx_serialization_json() : false) && this.lexer.tryConsumeNotNull();
    }

    public Void decodeNull() {
        return null;
    }

    private final void checkLeadingComma() {
        if (this.lexer.peekNextToken() == 4) {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public <T> T decodeSerializableElement(SerialDescriptor descriptor, int index, DeserializationStrategy<T> deserializer, T previousValue) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        boolean isMapKey = this.mode == WriteMode.MAP && (index & 1) == 0;
        if (isMapKey) {
            this.lexer.path.resetCurrentMapKey();
        }
        Object value = super.decodeSerializableElement(descriptor, index, deserializer, previousValue);
        if (isMapKey) {
            this.lexer.path.updateCurrentMapKey(value);
        }
        return value;
    }

    public int decodeElementIndex(SerialDescriptor descriptor) {
        int index;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        switch (WhenMappings.$EnumSwitchMapping$0[this.mode.ordinal()]) {
            case 2:
                index = decodeMapIndex();
                break;
            case 4:
                index = decodeObjectIndex(descriptor);
                break;
            default:
                index = decodeListIndex();
                break;
        }
        if (this.mode != WriteMode.MAP) {
            this.lexer.path.updateDescriptorIndex(index);
        }
        return index;
    }

    private final int decodeMapIndex() {
        boolean hasComma = false;
        int i2 = this.currentIndex;
        boolean decodingKey = i2 % 2 != 0;
        if (!decodingKey) {
            this.lexer.consumeNextToken((char) AbstractJsonLexerKt.COLON);
        } else if (i2 != -1) {
            hasComma = this.lexer.tryConsumeComma();
        }
        if (this.lexer.canConsumeValue()) {
            if (decodingKey) {
                if (this.currentIndex == -1) {
                    AbstractJsonLexer this_$iv = this.lexer;
                    boolean condition$iv = !hasComma;
                    int position$iv = this_$iv.currentPosition;
                    if (!condition$iv) {
                        AbstractJsonLexer.fail$default(this_$iv, "Unexpected trailing comma", position$iv, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                } else {
                    AbstractJsonLexer this_$iv2 = this.lexer;
                    int position$iv2 = this_$iv2.currentPosition;
                    if (!hasComma) {
                        AbstractJsonLexer.fail$default(this_$iv2, "Expected comma after the key-value pair", position$iv2, (String) null, 4, (Object) null);
                        throw new KotlinNothingValueException();
                    }
                }
            }
            int i3 = this.currentIndex + 1;
            this.currentIndex = i3;
            return i3;
        } else if (!hasComma) {
            return -1;
        } else {
            AbstractJsonLexer.fail$default(this.lexer, "Expected '}', but had ',' instead", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    private final boolean coerceInputValue(SerialDescriptor descriptor, int index) {
        String enumValue$iv;
        Json $this$tryCoerceValue$iv = this.json;
        SerialDescriptor elementDescriptor$iv = descriptor.getElementDescriptor(index);
        if (!elementDescriptor$iv.isNullable() && (this.lexer.tryConsumeNotNull() ^ 1) != 0) {
            return true;
        }
        if (!Intrinsics.areEqual((Object) elementDescriptor$iv.getKind(), (Object) SerialKind.ENUM.INSTANCE) || (enumValue$iv = this.lexer.peekString(this.configuration.isLenient())) == null || JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue$iv, enumValue$iv) != -3) {
            return false;
        }
        this.lexer.consumeString();
        return true;
    }

    private final int decodeObjectIndex(SerialDescriptor descriptor) {
        boolean isUnknown;
        boolean hasComma = this.lexer.tryConsumeComma();
        while (this.lexer.canConsumeValue()) {
            hasComma = false;
            String key = decodeStringKey();
            this.lexer.consumeNextToken((char) AbstractJsonLexerKt.COLON);
            int index = JsonNamesMapKt.getJsonNameIndex(descriptor, this.json, key);
            if (index == -3) {
                isUnknown = true;
            } else if (!this.configuration.getCoerceInputValues() || !coerceInputValue(descriptor, index)) {
                JsonElementMarker jsonElementMarker = this.elementMarker;
                if (jsonElementMarker != null) {
                    jsonElementMarker.mark$kotlinx_serialization_json(index);
                }
                return index;
            } else {
                hasComma = this.lexer.tryConsumeComma();
                isUnknown = false;
            }
            if (isUnknown) {
                hasComma = handleUnknown(key);
            }
        }
        if (!hasComma) {
            JsonElementMarker jsonElementMarker2 = this.elementMarker;
            if (jsonElementMarker2 != null) {
                return jsonElementMarker2.nextUnmarkedIndex$kotlinx_serialization_json();
            }
            return -1;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final boolean handleUnknown(String key) {
        if (this.configuration.getIgnoreUnknownKeys()) {
            this.lexer.skipElement(this.configuration.isLenient());
        } else {
            this.lexer.failOnUnknownKey(key);
        }
        return this.lexer.tryConsumeComma();
    }

    private final int decodeListIndex() {
        boolean hasComma = this.lexer.tryConsumeComma();
        if (this.lexer.canConsumeValue()) {
            int i2 = this.currentIndex;
            if (i2 == -1 || hasComma) {
                int i3 = i2 + 1;
                this.currentIndex = i3;
                return i3;
            }
            AbstractJsonLexer.fail$default(this.lexer, "Expected end of the array or comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        } else if (!hasComma) {
            return -1;
        } else {
            AbstractJsonLexer.fail$default(this.lexer, "Unexpected trailing comma", 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public boolean decodeBoolean() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeBooleanLenient();
        }
        return this.lexer.consumeBoolean();
    }

    public byte decodeByte() {
        long value = this.lexer.consumeNumericLiteral();
        if (value == ((long) ((byte) ((int) value)))) {
            return (byte) ((int) value);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse byte for input '" + value + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public short decodeShort() {
        long value = this.lexer.consumeNumericLiteral();
        if (value == ((long) ((short) ((int) value)))) {
            return (short) ((int) value);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse short for input '" + value + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public int decodeInt() {
        long value = this.lexer.consumeNumericLiteral();
        if (value == ((long) ((int) value))) {
            return (int) value;
        }
        AbstractJsonLexer.fail$default(this.lexer, "Failed to parse int for input '" + value + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    public long decodeLong() {
        return this.lexer.consumeNumericLiteral();
    }

    public float decodeFloat() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String expectedType$iv = "float";
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            float result = Float.parseFloat(input$iv);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!(!Float.isInfinite(result) && !Float.isNaN(result))) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Float.valueOf(result));
                    throw new KotlinNothingValueException();
                }
            }
            return result;
        } catch (IllegalArgumentException e2) {
            IllegalArgumentException illegalArgumentException = e2;
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type '" + expectedType$iv + "' for input '" + input$iv + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public double decodeDouble() {
        AbstractJsonLexer $this$parseString$iv = this.lexer;
        String input$iv = $this$parseString$iv.consumeStringLenient();
        try {
            double result = Double.parseDouble(input$iv);
            if (!this.json.getConfiguration().getAllowSpecialFloatingPointValues()) {
                if (!(!Double.isInfinite(result) && !Double.isNaN(result))) {
                    JsonExceptionsKt.throwInvalidFloatingPointDecoded(this.lexer, Double.valueOf(result));
                    throw new KotlinNothingValueException();
                }
            }
            return result;
        } catch (IllegalArgumentException e2) {
            IllegalArgumentException illegalArgumentException = e2;
            AbstractJsonLexer.fail$default($this$parseString$iv, "Failed to parse type '" + "double" + "' for input '" + input$iv + '\'', 0, (String) null, 6, (Object) null);
            throw new KotlinNothingValueException();
        }
    }

    public char decodeChar() {
        String string = this.lexer.consumeStringLenient();
        if (string.length() == 1) {
            return string.charAt(0);
        }
        AbstractJsonLexer.fail$default(this.lexer, "Expected single char, but got '" + string + '\'', 0, (String) null, 6, (Object) null);
        throw new KotlinNothingValueException();
    }

    private final String decodeStringKey() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeKeyString();
    }

    public String decodeString() {
        if (this.configuration.isLenient()) {
            return this.lexer.consumeStringLenientNotNull();
        }
        return this.lexer.consumeString();
    }

    public Decoder decodeInline(SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        if (StreamingJsonEncoderKt.isUnsignedNumber(inlineDescriptor)) {
            return new JsonDecoderForUnsignedTypes(this.lexer, this.json);
        }
        return super.decodeInline(inlineDescriptor);
    }

    public int decodeEnum(SerialDescriptor enumDescriptor) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        return JsonNamesMapKt.getJsonNameIndexOrThrow(enumDescriptor, this.json, decodeString(), " at path " + this.lexer.path.getPath());
    }
}
