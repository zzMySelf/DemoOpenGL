package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.LinkedList;

public final class State {
    public static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    public final int binaryShiftByteCount;
    public final int bitCount;
    public final int mode;
    public final Token token;

    public State(Token token2, int i2, int i3, int i4) {
        this.token = token2;
        this.mode = i2;
        this.binaryShiftByteCount = i3;
        this.bitCount = i4;
    }

    public State addBinaryShiftChar(int i2) {
        Token token2 = this.token;
        int i3 = this.mode;
        int i4 = this.bitCount;
        if (i3 == 4 || i3 == 2) {
            int i5 = HighLevelEncoder.LATCH_TABLE[i3][0];
            int i6 = 65535 & i5;
            int i7 = i5 >> 16;
            token2 = token2.add(i6, i7);
            i4 += i7;
            i3 = 0;
        }
        int i8 = this.binaryShiftByteCount;
        State state = new State(token2, i3, this.binaryShiftByteCount + 1, i4 + ((i8 == 0 || i8 == 31) ? 18 : i8 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i2 + 1) : state;
    }

    public State endBinaryShift(int i2) {
        int i3 = this.binaryShiftByteCount;
        if (i3 == 0) {
            return this;
        }
        return new State(this.token.addBinaryShift(i2 - i3, i3), this.mode, 0, this.bitCount);
    }

    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    public int getBitCount() {
        return this.bitCount;
    }

    public int getMode() {
        return this.mode;
    }

    public Token getToken() {
        return this.token;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        int i2;
        int i3 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i4 = state.binaryShiftByteCount;
        if (i4 > 0 && ((i2 = this.binaryShiftByteCount) == 0 || i2 > i4)) {
            i3 += 10;
        }
        return i3 <= state.bitCount;
    }

    public State latchAndAppend(int i2, int i3) {
        int i4 = this.bitCount;
        Token token2 = this.token;
        int i5 = this.mode;
        if (i2 != i5) {
            int i6 = HighLevelEncoder.LATCH_TABLE[i5][i2];
            int i7 = 65535 & i6;
            int i8 = i6 >> 16;
            token2 = token2.add(i7, i8);
            i4 += i8;
        }
        int i9 = i2 == 2 ? 4 : 5;
        return new State(token2.add(i3, i9), i2, 0, i4 + i9);
    }

    public State shiftAndAppend(int i2, int i3) {
        Token token2 = this.token;
        int i4 = this.mode == 2 ? 4 : 5;
        return new State(token2.add(HighLevelEncoder.SHIFT_TABLE[this.mode][i2], i4).add(i3, 5), this.mode, 0, this.bitCount + i4 + 5);
    }

    public BitArray toBitArray(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList<>();
        for (Token token2 = endBinaryShift(bArr.length).token; token2 != null; token2 = token2.getPrevious()) {
            linkedList.addFirst(token2);
        }
        BitArray bitArray = new BitArray();
        for (Token appendTo : linkedList) {
            appendTo.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)});
    }
}
