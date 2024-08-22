package kotlinx.serialization.json.internal;

import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\f\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\u0003H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0010\u0010\n\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0016J\b\u0010\u0012\u001a\u00020\u0010H\u0016J\b\u0010\u0013\u001a\u00020\bH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0014"}, d2 = {"Lkotlinx/serialization/json/internal/StringJsonLexer;", "Lkotlinx/serialization/json/internal/AbstractJsonLexer;", "source", "", "(Ljava/lang/String;)V", "getSource", "()Ljava/lang/String;", "canConsumeValue", "", "consumeKeyString", "consumeNextToken", "", "", "expected", "", "prefetchOrEof", "", "position", "skipWhitespaces", "tryConsumeComma", "kotlinx-serialization-json"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: StringJsonLexer.kt */
public final class StringJsonLexer extends AbstractJsonLexer {
    private final String source;

    public StringJsonLexer(String source2) {
        Intrinsics.checkNotNullParameter(source2, "source");
        this.source = source2;
    }

    /* access modifiers changed from: protected */
    public String getSource() {
        return this.source;
    }

    public int prefetchOrEof(int position) {
        if (position < getSource().length()) {
            return position;
        }
        return -1;
    }

    public byte consumeNextToken() {
        String source2 = getSource();
        while (this.currentPosition != -1 && this.currentPosition < source2.length()) {
            int i2 = this.currentPosition;
            this.currentPosition = i2 + 1;
            byte tc = AbstractJsonLexerKt.charToTokenClass(source2.charAt(i2));
            if (tc != 3) {
                return tc;
            }
        }
        return 10;
    }

    public boolean tryConsumeComma() {
        int current = skipWhitespaces();
        if (current == getSource().length() || current == -1 || getSource().charAt(current) != ',') {
            return false;
        }
        this.currentPosition++;
        int i2 = this.currentPosition;
        return true;
    }

    public boolean canConsumeValue() {
        int current = this.currentPosition;
        if (current == -1) {
            return false;
        }
        while (current < getSource().length()) {
            char c2 = getSource().charAt(current);
            if (c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9) {
                current++;
            } else {
                this.currentPosition = current;
                return isValidValueStart(c2);
            }
        }
        this.currentPosition = current;
        return false;
    }

    public int skipWhitespaces() {
        int current = this.currentPosition;
        if (current == -1) {
            return current;
        }
        while (current < getSource().length() && ((c = getSource().charAt(current)) == ' ' || c == 10 || c == 13 || c == 9)) {
            current++;
        }
        this.currentPosition = current;
        return current;
    }

    public void consumeNextToken(char expected) {
        if (this.currentPosition == -1) {
            unexpectedToken(expected);
        }
        String source2 = getSource();
        while (this.currentPosition < source2.length()) {
            int i2 = this.currentPosition;
            this.currentPosition = i2 + 1;
            char c2 = source2.charAt(i2);
            if (!(c2 == ' ' || c2 == 10 || c2 == 13 || c2 == 9)) {
                if (c2 != expected) {
                    unexpectedToken(expected);
                } else {
                    return;
                }
            }
        }
        unexpectedToken(expected);
    }

    public String consumeKeyString() {
        consumeNextToken('\"');
        int current = this.currentPosition;
        int closingQuote = StringsKt.indexOf$default((CharSequence) getSource(), '\"', current, false, 4, (Object) null);
        if (closingQuote != -1) {
            for (int i2 = current; i2 < closingQuote; i2++) {
                if (getSource().charAt(i2) == '\\') {
                    return consumeString(getSource(), this.currentPosition, i2);
                }
            }
            this.currentPosition = closingQuote + 1;
            String substring = getSource().substring(current, closingQuote);
            Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return substring;
        }
        fail$kotlinx_serialization_json((byte) 1);
        throw new KotlinNothingValueException();
    }
}
