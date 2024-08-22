package kotlinx.serialization.json.internal;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.descriptors.PolymorphicKind;
import kotlinx.serialization.descriptors.SerialDescriptor;
import kotlinx.serialization.descriptors.SerialKind;
import kotlinx.serialization.encoding.CompositeDecoder;
import kotlinx.serialization.internal.JsonInternalDependenciesKt;
import kotlinx.serialization.json.Json;
import kotlinx.serialization.json.JsonElement;
import kotlinx.serialization.json.JsonElementKt;
import kotlinx.serialization.json.JsonNull;
import kotlinx.serialization.json.JsonObject;
import kotlinx.serialization.json.JsonPrimitive;
import kotlinx.serialization.json.JsonSchemaCacheKt;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\b\u0012\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nJ\u0018\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\tH\u0016J \u0010\u0016\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u0007H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0017\u001a\u00020\u0007H\u0014J\u0010\u0010\u001a\u001a\u00020\u000e2\u0006\u0010\u0012\u001a\u00020\tH\u0016J\b\u0010\u001b\u001a\u00020\fH\u0016J\u0018\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000eH\u0014J\u0010\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0012\u001a\u00020\tH\u0016R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010¨\u0006 "}, d2 = {"Lkotlinx/serialization/json/internal/JsonTreeDecoder;", "Lkotlinx/serialization/json/internal/AbstractJsonTreeDecoder;", "json", "Lkotlinx/serialization/json/Json;", "value", "Lkotlinx/serialization/json/JsonObject;", "polyDiscriminator", "", "polyDescriptor", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/json/JsonObject;Ljava/lang/String;Lkotlinx/serialization/descriptors/SerialDescriptor;)V", "forceNull", "", "position", "", "getValue", "()Lkotlinx/serialization/json/JsonObject;", "absenceIsNull", "descriptor", "index", "beginStructure", "Lkotlinx/serialization/encoding/CompositeDecoder;", "coerceInputValue", "tag", "currentElement", "Lkotlinx/serialization/json/JsonElement;", "decodeElementIndex", "decodeNotNullMark", "elementName", "desc", "endStructure", "", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: TreeJsonDecoder.kt */
class JsonTreeDecoder extends AbstractJsonTreeDecoder {
    private boolean forceNull;
    private final SerialDescriptor polyDescriptor;
    private final String polyDiscriminator;
    private int position;
    private final JsonObject value;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JsonTreeDecoder(Json json, JsonObject jsonObject, String str, SerialDescriptor serialDescriptor, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(json, jsonObject, (i2 & 4) != 0 ? null : str, (i2 & 8) != 0 ? null : serialDescriptor);
    }

    public JsonObject getValue() {
        return this.value;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public JsonTreeDecoder(Json json, JsonObject value2, String polyDiscriminator2, SerialDescriptor polyDescriptor2) {
        super(json, value2, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(json, "json");
        Intrinsics.checkNotNullParameter(value2, "value");
        this.value = value2;
        this.polyDiscriminator = polyDiscriminator2;
        this.polyDescriptor = polyDescriptor2;
    }

    private final boolean coerceInputValue(SerialDescriptor descriptor, int index, String tag) {
        Json $this$tryCoerceValue_u24default$iv = getJson();
        SerialDescriptor elementDescriptor$iv = descriptor.getElementDescriptor(index);
        if (!elementDescriptor$iv.isNullable() && (currentElement(tag) instanceof JsonNull) != 0) {
            return true;
        }
        if (Intrinsics.areEqual((Object) elementDescriptor$iv.getKind(), (Object) SerialKind.ENUM.INSTANCE)) {
            JsonElement currentElement = currentElement(tag);
            String enumValue$iv = null;
            JsonPrimitive jsonPrimitive = currentElement instanceof JsonPrimitive ? (JsonPrimitive) currentElement : null;
            if (jsonPrimitive != null) {
                enumValue$iv = JsonElementKt.getContentOrNull(jsonPrimitive);
            }
            if (enumValue$iv == null) {
                return false;
            }
            if (JsonNamesMapKt.getJsonNameIndex(elementDescriptor$iv, $this$tryCoerceValue_u24default$iv, enumValue$iv) == -3) {
                return true;
            }
        }
        return false;
    }

    public int decodeElementIndex(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        while (this.position < descriptor.getElementsCount()) {
            int i2 = this.position;
            this.position = i2 + 1;
            String name = getTag(descriptor, i2);
            int index = this.position - 1;
            this.forceNull = false;
            if ((getValue().containsKey(name) || absenceIsNull(descriptor, index)) && (!this.configuration.getCoerceInputValues() || !coerceInputValue(descriptor, index, name))) {
                return index;
            }
        }
        return -1;
    }

    private final boolean absenceIsNull(SerialDescriptor descriptor, int index) {
        boolean z = !getJson().getConfiguration().getExplicitNulls() && !descriptor.isElementOptional(index) && descriptor.getElementDescriptor(index).isNullable();
        this.forceNull = z;
        return z;
    }

    public boolean decodeNotNullMark() {
        return !this.forceNull && super.decodeNotNullMark();
    }

    /* access modifiers changed from: protected */
    public String elementName(SerialDescriptor desc, int index) {
        Object obj;
        boolean z;
        Intrinsics.checkNotNullParameter(desc, "desc");
        String mainName = desc.getElementName(index);
        if (!this.configuration.getUseAlternativeNames() || getValue().keySet().contains(mainName)) {
            return mainName;
        }
        Map alternativeNamesMap = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).getOrPut(desc, JsonNamesMapKt.getJsonAlternativeNamesKey(), new JsonTreeDecoder$elementName$alternativeNamesMap$1(desc));
        Iterator it = getValue().keySet().iterator();
        while (true) {
            if (!it.hasNext()) {
                obj = null;
                break;
            }
            obj = it.next();
            Integer num = (Integer) alternativeNamesMap.get((String) obj);
            if (num != null && num.intValue() == index) {
                z = true;
                continue;
            } else {
                z = false;
                continue;
            }
            if (z) {
                break;
            }
        }
        String nameInObject = (String) obj;
        return nameInObject == null ? mainName : nameInObject;
    }

    /* access modifiers changed from: protected */
    public JsonElement currentElement(String tag) {
        Intrinsics.checkNotNullParameter(tag, "tag");
        return (JsonElement) MapsKt.getValue(getValue(), tag);
    }

    public CompositeDecoder beginStructure(SerialDescriptor descriptor) {
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (descriptor == this.polyDescriptor) {
            return this;
        }
        return super.beginStructure(descriptor);
    }

    public void endStructure(SerialDescriptor descriptor) {
        Set names;
        Intrinsics.checkNotNullParameter(descriptor, "descriptor");
        if (!this.configuration.getIgnoreUnknownKeys() && !(descriptor.getKind() instanceof PolymorphicKind)) {
            if (!this.configuration.getUseAlternativeNames()) {
                names = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
            } else {
                Set jsonCachedSerialNames = JsonInternalDependenciesKt.jsonCachedSerialNames(descriptor);
                Map map = (Map) JsonSchemaCacheKt.getSchemaCache(getJson()).get(descriptor, JsonNamesMapKt.getJsonAlternativeNamesKey());
                Set keySet = map != null ? map.keySet() : null;
                if (keySet == null) {
                    keySet = SetsKt.emptySet();
                }
                names = SetsKt.plus(jsonCachedSerialNames, keySet);
            }
            for (String key : getValue().keySet()) {
                if (!names.contains(key) && !Intrinsics.areEqual((Object) key, (Object) this.polyDiscriminator)) {
                    throw JsonExceptionsKt.UnknownKeyException(key, getValue().toString());
                }
            }
        }
    }
}
