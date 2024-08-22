package com.google.zxing.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;

public final class Base256Encoder implements Encoder {
    public static char randomize255State(char c, int i2) {
        int i3 = c + ((i2 * 149) % 255) + 1;
        return i3 <= 255 ? (char) i3 : (char) (i3 + InputDeviceCompat.SOURCE_ANY);
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            sb.append(encoderContext.getCurrentChar());
            encoderContext.pos++;
            if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                encoderContext.signalEncoderChange(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int codewordCount = encoderContext.getCodewordCount() + length + 1;
        encoderContext.updateSymbolInfo(codewordCount);
        boolean z = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount > 0;
        if (encoderContext.hasMoreCharacters() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: ".concat(String.valueOf(length)));
            }
        }
        int length2 = sb.length();
        for (int i2 = 0; i2 < length2; i2++) {
            encoderContext.writeCodeword(randomize255State(sb.charAt(i2), encoderContext.getCodewordCount() + 1));
        }
    }

    public int getEncodingMode() {
        return 5;
    }
}
