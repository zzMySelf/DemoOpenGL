package com.airbnb.lottie.parser.moshi;

import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

final class JsonScope {
    static final int CLOSED = 8;
    static final int DANGLING_NAME = 4;
    static final int EMPTY_ARRAY = 1;
    static final int EMPTY_DOCUMENT = 6;
    static final int EMPTY_OBJECT = 3;
    static final int NONEMPTY_ARRAY = 2;
    static final int NONEMPTY_DOCUMENT = 7;
    static final int NONEMPTY_OBJECT = 5;

    private JsonScope() {
    }

    static String getPath(int stackSize, int[] stack, String[] pathNames, int[] pathIndices) {
        StringBuilder result = new StringBuilder().append('$');
        for (int i2 = 0; i2 < stackSize; i2++) {
            switch (stack[i2]) {
                case 1:
                case 2:
                    result.append(AbstractJsonLexerKt.BEGIN_LIST).append(pathIndices[i2]).append(AbstractJsonLexerKt.END_LIST);
                    break;
                case 3:
                case 4:
                case 5:
                    result.append('.');
                    if (pathNames[i2] == null) {
                        break;
                    } else {
                        result.append(pathNames[i2]);
                        break;
                    }
            }
        }
        return result.toString();
    }
}
