package kotlinx.serialization.json.internal;

import kotlin.Metadata;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0019\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\bH\u0002J\b\u0010\u0011\u001a\u00020\bH\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lkotlinx/serialization/json/internal/CharMappings;", "", "()V", "CHAR_TO_TOKEN", "", "ESCAPE_2_CHAR", "", "initC2ESC", "", "c", "", "esc", "", "initC2TC", "cl", "", "initCharToToken", "initEscape", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: AbstractJsonLexer.kt */
public final class CharMappings {
    public static final byte[] CHAR_TO_TOKEN = new byte[126];
    public static final char[] ESCAPE_2_CHAR = new char[117];
    public static final CharMappings INSTANCE;

    private CharMappings() {
    }

    static {
        CharMappings charMappings = new CharMappings();
        INSTANCE = charMappings;
        charMappings.initEscape();
        charMappings.initCharToToken();
    }

    private final void initEscape() {
        for (int i2 = 0; i2 < 32; i2++) {
            initC2ESC(i2, (char) AbstractJsonLexerKt.UNICODE_ESC);
        }
        initC2ESC(8, 'b');
        initC2ESC(9, 't');
        initC2ESC(10, 'n');
        initC2ESC(12, 'f');
        initC2ESC(13, 'r');
        initC2ESC('/', '/');
        initC2ESC('\"', '\"');
        initC2ESC((char) AbstractJsonLexerKt.STRING_ESC, (char) AbstractJsonLexerKt.STRING_ESC);
    }

    private final void initCharToToken() {
        for (int i2 = 0; i2 < 33; i2++) {
            initC2TC(i2, Byte.MAX_VALUE);
        }
        initC2TC(9, (byte) 3);
        initC2TC(10, (byte) 3);
        initC2TC(13, (byte) 3);
        initC2TC(32, (byte) 3);
        initC2TC((char) AbstractJsonLexerKt.COMMA, (byte) 4);
        initC2TC((char) AbstractJsonLexerKt.COLON, (byte) 5);
        initC2TC((char) AbstractJsonLexerKt.BEGIN_OBJ, (byte) 6);
        initC2TC((char) AbstractJsonLexerKt.END_OBJ, (byte) 7);
        initC2TC((char) AbstractJsonLexerKt.BEGIN_LIST, (byte) 8);
        initC2TC((char) AbstractJsonLexerKt.END_LIST, (byte) 9);
        initC2TC('\"', (byte) 1);
        initC2TC((char) AbstractJsonLexerKt.STRING_ESC, (byte) 2);
    }

    private final void initC2ESC(int c2, char esc) {
        if (esc != 'u') {
            ESCAPE_2_CHAR[esc] = (char) c2;
        }
    }

    private final void initC2ESC(char c2, char esc) {
        initC2ESC((int) c2, esc);
    }

    private final void initC2TC(int c2, byte cl) {
        CHAR_TO_TOKEN[c2] = cl;
    }

    private final void initC2TC(char c2, byte cl) {
        initC2TC((int) c2, cl);
    }
}
