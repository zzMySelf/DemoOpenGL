package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import java.io.DataOutput;

@GwtIncompatible
public interface ByteArrayDataOutput extends DataOutput {
    byte[] toByteArray();

    void write(int i2);

    void write(byte[] bArr);

    void write(byte[] bArr, int i2, int i3);

    void writeBoolean(boolean z);

    void writeByte(int i2);

    @Deprecated
    void writeBytes(String str);

    void writeChar(int i2);

    void writeChars(String str);

    void writeDouble(double d);

    void writeFloat(float f);

    void writeInt(int i2);

    void writeLong(long j);

    void writeShort(int i2);

    void writeUTF(String str);
}
