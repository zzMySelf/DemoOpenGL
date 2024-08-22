package kotlinx.serialization.internal;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.InternalSerializationApi;
import kotlinx.serialization.SerializationException;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.encoding.CompositeEncoder;
import kotlinx.serialization.encoding.Encoder;
import kotlinx.serialization.modules.SerializersModule;
import kotlinx.serialization.modules.SerializersModuleKt;

@Metadata(d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b%\b'\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u000e\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u001e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001cJ\u001e\u0010\u001d\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u001cJ\u000e\u0010\u001e\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001fJ\u001e\u0010 \u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u001fJ\u000e\u0010!\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\"J\u001e\u0010#\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\"J\u0018\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0002J\u0016\u0010&\u001a\u00020\u00152\u0006\u0010'\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010(\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020)J\u001e\u0010*\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020)J\u000e\u0010+\u001a\u00020\u00022\u0006\u0010,\u001a\u00020\u0013J\u0016\u0010-\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010.\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u001aJ\u001e\u0010/\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020\u001aJ\u000e\u00100\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u000201J\u001e\u00102\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u000201J\u0006\u00103\u001a\u00020\u0015J\b\u00104\u001a\u00020\u0015H\u0016J?\u00105\u001a\u00020\u0015\"\b\b\u0001\u00106*\u0002072\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00108\u001a\b\u0012\u0004\u0012\u0002H6092\b\u0010\u0016\u001a\u0004\u0018\u0001H6H\u0016¢\u0006\u0002\u0010:J9\u0010;\u001a\u00020\u0015\"\u0004\b\u0001\u001062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\f\u00108\u001a\b\u0012\u0004\u0012\u0002H6092\u0006\u0010\u0016\u001a\u0002H6H\u0016¢\u0006\u0002\u0010:J\u000e\u0010<\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020=J\u001e\u0010>\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020=J\u000e\u0010?\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020@J\u001e\u0010A\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u0016\u001a\u00020@J\u001d\u0010B\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u0017H\u0014¢\u0006\u0002\u0010DJ\u001d\u0010E\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u001cH\u0014¢\u0006\u0002\u0010FJ\u001d\u0010G\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u001fH\u0014¢\u0006\u0002\u0010HJ\u001d\u0010I\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\"H\u0014¢\u0006\u0002\u0010JJ%\u0010K\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010'\u001a\u00020\u00132\u0006\u0010L\u001a\u00020\u001aH\u0014¢\u0006\u0002\u0010MJ\u001d\u0010N\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020)H\u0014¢\u0006\u0002\u0010OJ\u001d\u0010P\u001a\u00020\u00022\u0006\u0010C\u001a\u00028\u00002\u0006\u0010,\u001a\u00020\u0013H\u0014¢\u0006\u0002\u0010QJ\u001d\u0010R\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u001aH\u0014¢\u0006\u0002\u0010SJ\u001d\u0010T\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u000201H\u0014¢\u0006\u0002\u0010UJ\u0015\u0010V\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u0000H\u0014¢\u0006\u0002\u0010WJ\u001d\u0010X\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020=H\u0014¢\u0006\u0002\u0010YJ\u001d\u0010Z\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020@H\u0014¢\u0006\u0002\u0010[J\u001d\u0010\\\u001a\u00020\u00152\u0006\u0010C\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u000207H\u0014¢\u0006\u0002\u0010]J\u0010\u0010^\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013H\u0014J\u000e\u0010_\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0013J\r\u0010`\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u0007J\u0015\u0010a\u001a\u00020\u00152\u0006\u0010b\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010WJ\u0019\u0010c\u001a\u00028\u0000*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH$¢\u0006\u0002\u0010dR\u0014\u0010\u0005\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0016\u0010\b\u001a\u0004\u0018\u00018\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\u0007R\u0014\u0010\n\u001a\u00020\u000b8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001e\u0010\u000e\u001a\u0012\u0012\u0004\u0012\u00028\u00000\u000fj\b\u0012\u0004\u0012\u00028\u0000`\u0010X\u0004¢\u0006\u0002\n\u0000¨\u0006e"}, d2 = {"Lkotlinx/serialization/internal/TaggedEncoder;", "Tag", "Lkotlinx/serialization/encoding/Encoder;", "Lkotlinx/serialization/encoding/CompositeEncoder;", "()V", "currentTag", "getCurrentTag", "()Ljava/lang/Object;", "currentTagOrNull", "getCurrentTagOrNull", "serializersModule", "Lkotlinx/serialization/modules/SerializersModule;", "getSerializersModule", "()Lkotlinx/serialization/modules/SerializersModule;", "tagStack", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "beginStructure", "descriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "encodeBoolean", "", "value", "", "encodeBooleanElement", "index", "", "encodeByte", "", "encodeByteElement", "encodeChar", "", "encodeCharElement", "encodeDouble", "", "encodeDoubleElement", "encodeElement", "desc", "encodeEnum", "enumDescriptor", "encodeFloat", "", "encodeFloatElement", "encodeInline", "inlineDescriptor", "encodeInlineElement", "encodeInt", "encodeIntElement", "encodeLong", "", "encodeLongElement", "encodeNotNullMark", "encodeNull", "encodeNullableSerializableElement", "T", "", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/descriptors/SerialDescriptor;ILkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;)V", "encodeSerializableElement", "encodeShort", "", "encodeShortElement", "encodeString", "", "encodeStringElement", "encodeTaggedBoolean", "tag", "(Ljava/lang/Object;Z)V", "encodeTaggedByte", "(Ljava/lang/Object;B)V", "encodeTaggedChar", "(Ljava/lang/Object;C)V", "encodeTaggedDouble", "(Ljava/lang/Object;D)V", "encodeTaggedEnum", "ordinal", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;I)V", "encodeTaggedFloat", "(Ljava/lang/Object;F)V", "encodeTaggedInline", "(Ljava/lang/Object;Lkotlinx/serialization/descriptors/SerialDescriptor;)Lkotlinx/serialization/encoding/Encoder;", "encodeTaggedInt", "(Ljava/lang/Object;I)V", "encodeTaggedLong", "(Ljava/lang/Object;J)V", "encodeTaggedNull", "(Ljava/lang/Object;)V", "encodeTaggedShort", "(Ljava/lang/Object;S)V", "encodeTaggedString", "(Ljava/lang/Object;Ljava/lang/String;)V", "encodeTaggedValue", "(Ljava/lang/Object;Ljava/lang/Object;)V", "endEncode", "endStructure", "popTag", "pushTag", "name", "getTag", "(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Ljava/lang/Object;", "kotlinx-serialization-core"}, k = 1, mv = {1, 6, 0}, xi = 48)
@InternalSerializationApi
/* compiled from: Tagged.kt */
public abstract class TaggedEncoder<Tag> implements Encoder, CompositeEncoder {
    private final ArrayList<Tag> tagStack = new ArrayList<>();

    /* access modifiers changed from: protected */
    public abstract Tag getTag(SerialDescriptor serialDescriptor, int i2);

    public CompositeEncoder beginCollection(SerialDescriptor descriptor, int collectionSize) {
        return Encoder.DefaultImpls.beginCollection(this, descriptor, collectionSize);
    }

    @ExperimentalSerializationApi
    public <T> void encodeNullableSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        Encoder.DefaultImpls.encodeNullableSerializableValue(this, serializer, value);
    }

    public <T> void encodeSerializableValue(SerializationStrategy<? super T> serializer, T value) {
        Encoder.DefaultImpls.encodeSerializableValue(this, serializer, value);
    }

    @ExperimentalSerializationApi
    public boolean shouldEncodeElementDefault(SerialDescriptor descriptor, int index) {
        return CompositeEncoder.DefaultImpls.shouldEncodeElementDefault(this, descriptor, index);
    }

    public SerializersModule getSerializersModule() {
        return SerializersModuleKt.getEmptySerializersModule();
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedValue(Tag tag, Object value) {
        Intrinsics.checkNotNullParameter(value, "value");
        throw new SerializationException("Non-serializable " + Reflection.getOrCreateKotlinClass(value.getClass()) + " is not supported by " + Reflection.getOrCreateKotlinClass(getClass()) + " encoder");
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedNull(Tag tag) {
        throw new SerializationException("null is not supported");
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedInt(Tag tag, int value) {
        encodeTaggedValue(tag, Integer.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedByte(Tag tag, byte value) {
        encodeTaggedValue(tag, Byte.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedShort(Tag tag, short value) {
        encodeTaggedValue(tag, Short.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedLong(Tag tag, long value) {
        encodeTaggedValue(tag, Long.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedFloat(Tag tag, float value) {
        encodeTaggedValue(tag, Float.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedDouble(Tag tag, double value) {
        encodeTaggedValue(tag, Double.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedBoolean(Tag tag, boolean value) {
        encodeTaggedValue(tag, Boolean.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedChar(Tag tag, char value) {
        encodeTaggedValue(tag, Character.valueOf(value));
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedString(Tag tag, String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedValue(tag, value);
    }

    /* access modifiers changed from: protected */
    public void encodeTaggedEnum(Tag tag, SerialDescriptor enumDescriptor, int ordinal) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeTaggedValue(tag, Integer.valueOf(ordinal));
    }

    /* access modifiers changed from: protected */
    public Encoder encodeTaggedInline(Tag tag, SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        pushTag(tag);
        return this;
    }

    public final Encoder encodeInline(SerialDescriptor inlineDescriptor) {
        Intrinsics.checkNotNullParameter(inlineDescriptor, "inlineDescriptor");
        return encodeTaggedInline(popTag(), inlineDescriptor);
    }

    private final boolean encodeElement(SerialDescriptor desc, int index) {
        pushTag(getTag(desc, index));
        return true;
    }

    public final void encodeNotNullMark() {
    }

    public void encodeNull() {
        encodeTaggedNull(popTag());
    }

    public final void encodeBoolean(boolean value) {
        encodeTaggedBoolean(popTag(), value);
    }

    public final void encodeByte(byte value) {
        encodeTaggedByte(popTag(), value);
    }

    public final void encodeShort(short value) {
        encodeTaggedShort(popTag(), value);
    }

    public final void encodeInt(int value) {
        encodeTaggedInt(popTag(), value);
    }

    public final void encodeLong(long value) {
        encodeTaggedLong(popTag(), value);
    }

    public final void encodeFloat(float value) {
        encodeTaggedFloat(popTag(), value);
    }

    public final void encodeDouble(double value) {
        encodeTaggedDouble(popTag(), value);
    }

    public final void encodeChar(char value) {
        encodeTaggedChar(popTag(), value);
    }

    public final void encodeString(String value) {
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(popTag(), value);
    }

    public final void encodeEnum(SerialDescriptor enumDescriptor, int index) {
        Intrinsics.checkNotNullParameter(enumDescriptor, "enumDescriptor");
        encodeTaggedEnum(popTag(), enumDescriptor, index);
    }

    public CompositeEncoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return this;
    }

    public final void endStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.tagStack.isEmpty()) {
            popTag();
        }
        endEncode(descriptor);
    }

    /* access modifiers changed from: protected */
    public void endEncode(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
    }

    public final void encodeBooleanElement(SerialDescriptor descriptor, int index, boolean value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedBoolean(getTag(descriptor, index), value);
    }

    public final void encodeByteElement(SerialDescriptor descriptor, int index, byte value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedByte(getTag(descriptor, index), value);
    }

    public final void encodeShortElement(SerialDescriptor descriptor, int index, short value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedShort(getTag(descriptor, index), value);
    }

    public final void encodeIntElement(SerialDescriptor descriptor, int index, int value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedInt(getTag(descriptor, index), value);
    }

    public final void encodeLongElement(SerialDescriptor descriptor, int index, long value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedLong(getTag(descriptor, index), value);
    }

    public final void encodeFloatElement(SerialDescriptor descriptor, int index, float value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedFloat(getTag(descriptor, index), value);
    }

    public final void encodeDoubleElement(SerialDescriptor descriptor, int index, double value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedDouble(getTag(descriptor, index), value);
    }

    public final void encodeCharElement(SerialDescriptor descriptor, int index, char value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        encodeTaggedChar(getTag(descriptor, index), value);
    }

    public final void encodeStringElement(SerialDescriptor descriptor, int index, String value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(value, "value");
        encodeTaggedString(getTag(descriptor, index), value);
    }

    public final Encoder encodeInlineElement(SerialDescriptor descriptor, int index) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        return encodeTaggedInline(getTag(descriptor, index), descriptor.getElementDescriptor(index));
    }

    public <T> void encodeSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeSerializableValue(serializer, value);
        }
    }

    public <T> void encodeNullableSerializableElement(SerialDescriptor descriptor, int index, SerializationStrategy<? super T> serializer, T value) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        if (encodeElement(descriptor, index)) {
            encodeNullableSerializableValue(serializer, value);
        }
    }

    /* access modifiers changed from: protected */
    public final Tag getCurrentTag() {
        return CollectionsKt.last(this.tagStack);
    }

    /* access modifiers changed from: protected */
    public final Tag getCurrentTagOrNull() {
        return CollectionsKt.lastOrNull(this.tagStack);
    }

    /* access modifiers changed from: protected */
    public final void pushTag(Tag name) {
        this.tagStack.add(name);
    }

    /* access modifiers changed from: protected */
    public final Tag popTag() {
        if (!this.tagStack.isEmpty()) {
            ArrayList<Tag> arrayList = this.tagStack;
            return arrayList.remove(CollectionsKt.getLastIndex(arrayList));
        }
        throw new SerializationException("No tag in stack for requested element");
    }
}
