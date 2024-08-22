package com.baidu.detector;

import com.baidu.detector.detection.CharUtils;
import com.baidu.detector.detection.InputTextReader;
import java.util.Stack;

class UrlUtil {
    protected static String decode(String url) {
        StringBuilder stringBuilder = new StringBuilder(url);
        Stack<Integer> nonDecodedPercentIndices = new Stack<>();
        int i2 = 0;
        while (i2 < stringBuilder.length() - 2) {
            if (stringBuilder.charAt(i2) == '%') {
                if (!CharUtils.isHex(stringBuilder.charAt(i2 + 1)) || !CharUtils.isHex(stringBuilder.charAt(i2 + 2))) {
                    nonDecodedPercentIndices.add(Integer.valueOf(i2));
                } else {
                    char decodedChar = String.format("%s", new Object[]{Character.valueOf((char) Short.parseShort(stringBuilder.substring(i2 + 1, i2 + 3), 16))}).charAt(0);
                    stringBuilder.delete(i2, i2 + 3);
                    stringBuilder.insert(i2, decodedChar);
                    if (decodedChar == '%') {
                        i2--;
                    } else if (!nonDecodedPercentIndices.isEmpty() && CharUtils.isHex(decodedChar) && CharUtils.isHex(stringBuilder.charAt(i2 - 1)) && i2 - nonDecodedPercentIndices.peek().intValue() == 2) {
                        i2 = nonDecodedPercentIndices.pop().intValue() - 1;
                    } else if (!nonDecodedPercentIndices.isEmpty() && i2 == stringBuilder.length() - 2) {
                        i2 = nonDecodedPercentIndices.pop().intValue() - 1;
                    }
                }
            }
            i2++;
        }
        return stringBuilder.toString();
    }

    protected static String removeSpecialSpaces(String urlPart) {
        StringBuilder stringBuilder = new StringBuilder(urlPart);
        for (int i2 = 0; i2 < stringBuilder.length(); i2++) {
            if (CharUtils.isWhiteSpace(stringBuilder.charAt(i2))) {
                stringBuilder.deleteCharAt(i2);
            }
        }
        return stringBuilder.toString();
    }

    protected static String encode(String url) {
        StringBuilder encoder = new StringBuilder();
        for (char chr : url.toCharArray()) {
            byte chrByte = (byte) chr;
            if (chrByte <= 32 || chrByte >= Byte.MAX_VALUE || chr == '#' || chr == '%') {
                encoder.append(String.format("%%%02X", new Object[]{Byte.valueOf(chrByte)}));
            } else {
                encoder.append(chr);
            }
        }
        return encoder.toString();
    }

    protected static String removeExtraDots(String host) {
        StringBuilder stringBuilder = new StringBuilder();
        InputTextReader reader = new InputTextReader(host);
        while (!reader.eof()) {
            char curr = reader.read();
            stringBuilder.append(curr);
            if (curr == '.') {
                char possibleDot = curr;
                while (possibleDot == '.' && !reader.eof()) {
                    possibleDot = reader.read();
                }
                if (possibleDot != '.') {
                    stringBuilder.append(possibleDot);
                }
            }
        }
        if (stringBuilder.length() > 0 && stringBuilder.charAt(stringBuilder.length() - 1) == '.') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        if (stringBuilder.length() > 0 && stringBuilder.charAt(0) == '.') {
            stringBuilder.deleteCharAt(0);
        }
        return stringBuilder.toString();
    }

    private UrlUtil() {
    }
}
