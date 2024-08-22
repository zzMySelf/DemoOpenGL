package com.google.common.hash;

import com.google.common.annotations.Beta;
import com.google.common.base.Preconditions;
import java.io.OutputStream;
import java.io.Serializable;
import java.nio.charset.Charset;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

@Beta
public final class Funnels {

    public enum ByteArrayFunnel implements Funnel<byte[]> {
        INSTANCE;

        public String toString() {
            return "Funnels.byteArrayFunnel()";
        }

        public void funnel(byte[] bArr, PrimitiveSink primitiveSink) {
            primitiveSink.putBytes(bArr);
        }
    }

    public enum IntegerFunnel implements Funnel<Integer> {
        INSTANCE;

        public String toString() {
            return "Funnels.integerFunnel()";
        }

        public void funnel(Integer num, PrimitiveSink primitiveSink) {
            primitiveSink.putInt(num.intValue());
        }
    }

    public enum LongFunnel implements Funnel<Long> {
        INSTANCE;

        public String toString() {
            return "Funnels.longFunnel()";
        }

        public void funnel(Long l, PrimitiveSink primitiveSink) {
            primitiveSink.putLong(l.longValue());
        }
    }

    public static class SequentialFunnel<E> implements Funnel<Iterable<? extends E>>, Serializable {
        public final Funnel<E> elementFunnel;

        public SequentialFunnel(Funnel<E> funnel) {
            this.elementFunnel = (Funnel) Preconditions.checkNotNull(funnel);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof SequentialFunnel) {
                return this.elementFunnel.equals(((SequentialFunnel) obj).elementFunnel);
            }
            return false;
        }

        public int hashCode() {
            return SequentialFunnel.class.hashCode() ^ this.elementFunnel.hashCode();
        }

        public String toString() {
            return "Funnels.sequentialFunnel(" + this.elementFunnel + ")";
        }

        public void funnel(Iterable<? extends E> iterable, PrimitiveSink primitiveSink) {
            for (Object funnel : iterable) {
                this.elementFunnel.funnel(funnel, primitiveSink);
            }
        }
    }

    public static class SinkAsStream extends OutputStream {
        public final PrimitiveSink sink;

        public SinkAsStream(PrimitiveSink primitiveSink) {
            this.sink = (PrimitiveSink) Preconditions.checkNotNull(primitiveSink);
        }

        public String toString() {
            return "Funnels.asOutputStream(" + this.sink + ")";
        }

        public void write(int i2) {
            this.sink.putByte((byte) i2);
        }

        public void write(byte[] bArr) {
            this.sink.putBytes(bArr);
        }

        public void write(byte[] bArr, int i2, int i3) {
            this.sink.putBytes(bArr, i2, i3);
        }
    }

    public static class StringCharsetFunnel implements Funnel<CharSequence>, Serializable {
        public final Charset charset;

        public static class SerializedForm implements Serializable {
            public static final long serialVersionUID = 0;
            public final String charsetCanonicalName;

            public SerializedForm(Charset charset) {
                this.charsetCanonicalName = charset.name();
            }

            private Object readResolve() {
                return Funnels.stringFunnel(Charset.forName(this.charsetCanonicalName));
            }
        }

        public StringCharsetFunnel(Charset charset2) {
            this.charset = (Charset) Preconditions.checkNotNull(charset2);
        }

        public boolean equals(@NullableDecl Object obj) {
            if (obj instanceof StringCharsetFunnel) {
                return this.charset.equals(((StringCharsetFunnel) obj).charset);
            }
            return false;
        }

        public int hashCode() {
            return StringCharsetFunnel.class.hashCode() ^ this.charset.hashCode();
        }

        public String toString() {
            return "Funnels.stringFunnel(" + this.charset.name() + ")";
        }

        public Object writeReplace() {
            return new SerializedForm(this.charset);
        }

        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putString(charSequence, this.charset);
        }
    }

    public enum UnencodedCharsFunnel implements Funnel<CharSequence> {
        INSTANCE;

        public String toString() {
            return "Funnels.unencodedCharsFunnel()";
        }

        public void funnel(CharSequence charSequence, PrimitiveSink primitiveSink) {
            primitiveSink.putUnencodedChars(charSequence);
        }
    }

    public static OutputStream asOutputStream(PrimitiveSink primitiveSink) {
        return new SinkAsStream(primitiveSink);
    }

    public static Funnel<byte[]> byteArrayFunnel() {
        return ByteArrayFunnel.INSTANCE;
    }

    public static Funnel<Integer> integerFunnel() {
        return IntegerFunnel.INSTANCE;
    }

    public static Funnel<Long> longFunnel() {
        return LongFunnel.INSTANCE;
    }

    public static <E> Funnel<Iterable<? extends E>> sequentialFunnel(Funnel<E> funnel) {
        return new SequentialFunnel(funnel);
    }

    public static Funnel<CharSequence> stringFunnel(Charset charset) {
        return new StringCharsetFunnel(charset);
    }

    public static Funnel<CharSequence> unencodedCharsFunnel() {
        return UnencodedCharsFunnel.INSTANCE;
    }
}
