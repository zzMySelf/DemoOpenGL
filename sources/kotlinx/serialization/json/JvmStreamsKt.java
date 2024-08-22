package kotlinx.serialization.json;

import androidx.exifinterface.media.ExifInterface;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KType;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import kotlinx.serialization.DeserializationStrategy;
import kotlinx.serialization.ExperimentalSerializationApi;
import kotlinx.serialization.SerializationStrategy;
import kotlinx.serialization.SerializersKt;
import kotlinx.serialization.json.internal.JsonIteratorKt;
import kotlinx.serialization.json.internal.JsonStringBuilder;
import kotlinx.serialization.json.internal.JsonToWriterStringBuilder;
import kotlinx.serialization.json.internal.ReaderJsonLexer;
import kotlinx.serialization.json.internal.StreamingJsonDecoder;
import kotlinx.serialization.json.internal.StreamingJsonEncoder;
import kotlinx.serialization.json.internal.WriteMode;
import kotlinx.serialization.modules.SerializersModule;

@Metadata(d1 = {"\u0000<\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\"\u0010\u0000\u001a\u0002H\u0001\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\b¢\u0006\u0002\u0010\u0005\u001a-\u0010\u0000\u001a\u0002H\u0001\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\u0006\u0010\u0003\u001a\u00020\u0004H\u0007¢\u0006\u0002\u0010\b\u001a8\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00072\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007\u001a-\u0010\t\u001a\b\u0012\u0004\u0012\u0002H\u00010\n\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u000b\u001a\u00020\fH\b\u001a*\u0010\r\u001a\u00020\u000e\"\u0006\b\u0000\u0010\u0001\u0018\u0001*\u00020\u00022\u0006\u0010\u000f\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\b¢\u0006\u0002\u0010\u0011\u001a5\u0010\r\u001a\u00020\u000e\"\u0004\b\u0000\u0010\u0001*\u00020\u00022\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00132\u0006\u0010\u000f\u001a\u0002H\u00012\u0006\u0010\u0003\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0014¨\u0006\u0015"}, d2 = {"decodeFromStream", "T", "Lkotlinx/serialization/json/Json;", "stream", "Ljava/io/InputStream;", "(Lkotlinx/serialization/json/Json;Ljava/io/InputStream;)Ljava/lang/Object;", "deserializer", "Lkotlinx/serialization/DeserializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/DeserializationStrategy;Ljava/io/InputStream;)Ljava/lang/Object;", "decodeToSequence", "Lkotlin/sequences/Sequence;", "format", "Lkotlinx/serialization/json/DecodeSequenceMode;", "encodeToStream", "", "value", "Ljava/io/OutputStream;", "(Lkotlinx/serialization/json/Json;Ljava/lang/Object;Ljava/io/OutputStream;)V", "serializer", "Lkotlinx/serialization/SerializationStrategy;", "(Lkotlinx/serialization/json/Json;Lkotlinx/serialization/SerializationStrategy;Ljava/lang/Object;Ljava/io/OutputStream;)V", "kotlinx-serialization-json"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: JvmStreams.kt */
public final class JvmStreamsKt {
    @ExperimentalSerializationApi
    public static final <T> void encodeToStream(Json $this$encodeToStream, SerializationStrategy<? super T> serializer, T value, OutputStream stream) {
        Intrinsics.checkNotNullParameter($this$encodeToStream, "<this>");
        Intrinsics.checkNotNullParameter(serializer, "serializer");
        Intrinsics.checkNotNullParameter(stream, "stream");
        JsonToWriterStringBuilder result = new JsonToWriterStringBuilder(stream, (Charset) null, 2, (DefaultConstructorMarker) null);
        try {
            new StreamingJsonEncoder((JsonStringBuilder) result, $this$encodeToStream, WriteMode.OBJ, new JsonEncoder[WriteMode.values().length]).encodeSerializableValue(serializer, value);
        } finally {
            result.release();
        }
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> void encodeToStream(Json $this$encodeToStream, T value, OutputStream stream) {
        Intrinsics.checkNotNullParameter($this$encodeToStream, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        SerializersModule $this$serializer$iv = $this$encodeToStream.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        encodeToStream($this$encodeToStream, SerializersKt.serializer($this$serializer$iv, (KType) null), value, stream);
    }

    @ExperimentalSerializationApi
    public static final <T> T decodeFromStream(Json $this$decodeFromStream, DeserializationStrategy<T> deserializer, InputStream stream) {
        Intrinsics.checkNotNullParameter($this$decodeFromStream, "<this>");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(stream, "stream");
        ReaderJsonLexer lexer = new ReaderJsonLexer(stream, (Charset) null, 2, (DefaultConstructorMarker) null);
        Object result = new StreamingJsonDecoder($this$decodeFromStream, WriteMode.OBJ, lexer, deserializer.getDescriptor()).decodeSerializableValue(deserializer);
        lexer.expectEof();
        return result;
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> T decodeFromStream(Json $this$decodeFromStream, InputStream stream) {
        Intrinsics.checkNotNullParameter($this$decodeFromStream, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        SerializersModule $this$serializer$iv = $this$decodeFromStream.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        return decodeFromStream($this$decodeFromStream, SerializersKt.serializer($this$serializer$iv, (KType) null), stream);
    }

    public static /* synthetic */ Sequence decodeToSequence$default(Json json, InputStream inputStream, DeserializationStrategy deserializationStrategy, DecodeSequenceMode decodeSequenceMode, int i2, Object obj) {
        if ((i2 & 4) != 0) {
            decodeSequenceMode = DecodeSequenceMode.AUTO_DETECT;
        }
        return decodeToSequence(json, inputStream, deserializationStrategy, decodeSequenceMode);
    }

    @ExperimentalSerializationApi
    public static final <T> Sequence<T> decodeToSequence(Json $this$decodeToSequence, InputStream stream, DeserializationStrategy<T> deserializer, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeToSequence, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(deserializer, "deserializer");
        Intrinsics.checkNotNullParameter(format, "format");
        return SequencesKt.constrainOnce(new JvmStreamsKt$decodeToSequence$$inlined$Sequence$1(JsonIteratorKt.JsonIterator(format, $this$decodeToSequence, new ReaderJsonLexer(stream, (Charset) null, 2, (DefaultConstructorMarker) null), deserializer)));
    }

    public static /* synthetic */ Sequence decodeToSequence$default(Json $this$decodeToSequence_u24default, InputStream stream, DecodeSequenceMode format, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            format = DecodeSequenceMode.AUTO_DETECT;
        }
        Intrinsics.checkNotNullParameter($this$decodeToSequence_u24default, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule $this$serializer$iv = $this$decodeToSequence_u24default.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        return decodeToSequence($this$decodeToSequence_u24default, stream, SerializersKt.serializer($this$serializer$iv, (KType) null), format);
    }

    @ExperimentalSerializationApi
    public static final /* synthetic */ <T> Sequence<T> decodeToSequence(Json $this$decodeToSequence, InputStream stream, DecodeSequenceMode format) {
        Intrinsics.checkNotNullParameter($this$decodeToSequence, "<this>");
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(format, "format");
        SerializersModule $this$serializer$iv = $this$decodeToSequence.getSerializersModule();
        Intrinsics.reifiedOperationMarker(6, ExifInterface.GPS_DIRECTION_TRUE);
        return decodeToSequence($this$decodeToSequence, stream, SerializersKt.serializer($this$serializer$iv, (KType) null), format);
    }
}
