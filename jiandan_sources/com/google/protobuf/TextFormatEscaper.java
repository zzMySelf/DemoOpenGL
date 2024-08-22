package com.google.protobuf;

import com.baidu.android.common.others.IStringUtil;

public final class TextFormatEscaper {

    public interface ByteSequence {
        byte byteAt(int i2);

        int size();
    }

    public static String escapeBytes(ByteSequence byteSequence) {
        StringBuilder sb = new StringBuilder(byteSequence.size());
        for (int i2 = 0; i2 < byteSequence.size(); i2++) {
            byte byteAt = byteSequence.byteAt(i2);
            if (byteAt == 34) {
                sb.append("\\\"");
            } else if (byteAt == 39) {
                sb.append("\\'");
            } else if (byteAt != 92) {
                switch (byteAt) {
                    case 7:
                        sb.append("\\a");
                        break;
                    case 8:
                        sb.append("\\b");
                        break;
                    case 9:
                        sb.append("\\t");
                        break;
                    case 10:
                        sb.append("\\n");
                        break;
                    case 11:
                        sb.append("\\v");
                        break;
                    case 12:
                        sb.append("\\f");
                        break;
                    case 13:
                        sb.append("\\r");
                        break;
                    default:
                        if (byteAt >= 32 && byteAt <= 126) {
                            sb.append((char) byteAt);
                            break;
                        } else {
                            sb.append('\\');
                            sb.append((char) (((byteAt >>> 6) & 3) + 48));
                            sb.append((char) (((byteAt >>> 3) & 7) + 48));
                            sb.append((char) ((byteAt & 7) + 48));
                            break;
                        }
                        break;
                }
            } else {
                sb.append("\\\\");
            }
        }
        return sb.toString();
    }

    public static String escapeDoubleQuotesAndBackslashes(String str) {
        return str.replace(IStringUtil.WINDOWS_FOLDER_SEPARATOR, "\\\\").replace("\"", "\\\"");
    }

    public static String escapeText(String str) {
        return escapeBytes(ByteString.copyFromUtf8(str));
    }

    public static String escapeBytes(final ByteString byteString) {
        return escapeBytes((ByteSequence) new ByteSequence() {
            public byte byteAt(int i2) {
                return byteString.byteAt(i2);
            }

            public int size() {
                return byteString.size();
            }
        });
    }

    public static String escapeBytes(final byte[] bArr) {
        return escapeBytes((ByteSequence) new ByteSequence() {
            public byte byteAt(int i2) {
                return bArr[i2];
            }

            public int size() {
                return bArr.length;
            }
        });
    }
}
