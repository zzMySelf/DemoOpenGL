package com.google.zxing.datamatrix.encoder;

import com.google.common.xml.XmlEscapers;

public final class EdifactEncoder implements Encoder {
    public static void encodeChar(char c, StringBuilder sb) {
        if (c >= ' ' && c <= '?') {
            sb.append(c);
        } else if (c < '@' || c > '^') {
            HighLevelEncoder.illegalCharacter(c);
        } else {
            sb.append((char) (c - '@'));
        }
    }

    public static String encodeToCodewords(CharSequence charSequence, int i2) {
        int length = charSequence.length() - i2;
        if (length != 0) {
            char charAt = charSequence.charAt(i2);
            char c = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i2 + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i2 + 2) : 0;
            if (length >= 4) {
                c = charSequence.charAt(i2 + 3);
            }
            int i3 = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c;
            char c2 = (char) ((i3 >> 8) & 255);
            char c3 = (char) (i3 & 255);
            StringBuilder sb = new StringBuilder(3);
            sb.append((char) ((i3 >> 16) & 255));
            if (length >= 2) {
                sb.append(c2);
            }
            if (length >= 3) {
                sb.append(c3);
            }
            return sb.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    public static void handleEOD(EncoderContext encoderContext, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z = true;
                if (length == 1) {
                    encoderContext.updateSymbolInfo();
                    int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                    int remainingCharacters = encoderContext.getRemainingCharacters();
                    if (remainingCharacters > dataCapacity) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + 1);
                        dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                    }
                    if (remainingCharacters <= dataCapacity && dataCapacity <= 2) {
                        encoderContext.signalEncoderChange(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i2 = length - 1;
                    String encodeToCodewords = encodeToCodewords(charSequence, 0);
                    if (!(!encoderContext.hasMoreCharacters()) || i2 > 2) {
                        z = false;
                    }
                    if (i2 <= 2) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i2);
                        if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                            encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
                            z = false;
                        }
                    }
                    if (z) {
                        encoderContext.resetSymbolInfo();
                        encoderContext.pos -= i2;
                    } else {
                        encoderContext.writeCodewords(encodeToCodewords);
                    }
                    encoderContext.signalEncoderChange(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            encoderContext.signalEncoderChange(0);
        }
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            encodeChar(encoderContext.getCurrentChar(), sb);
            encoderContext.pos++;
            if (sb.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb, 0));
                sb.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb.append(XmlEscapers.MAX_ASCII_CONTROL_CHAR);
        handleEOD(encoderContext, sb);
    }

    public int getEncodingMode() {
        return 4;
    }
}
