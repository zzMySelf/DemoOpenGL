package com.google.zxing.searchbox.qrcode.encoder;

import com.baidu.netdisk.cloudfile.constant.NetdiskErrorCode;
import com.baidu.swan.apps.process.messaging.service.SwanAppMessengerService;
import com.google.zxing.searchbox.WriterException;
import com.google.zxing.searchbox.common.BitArray;
import com.google.zxing.searchbox.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.searchbox.qrcode.decoder.Version;

final class MatrixUtil {
    private static final int[][] POSITION_ADJUSTMENT_PATTERN = {new int[]{1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 0, 1, 0, 1}, new int[]{1, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1}};
    private static final int[][] POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE = {new int[]{-1, -1, -1, -1, -1, -1, -1}, new int[]{6, 18, -1, -1, -1, -1, -1}, new int[]{6, 22, -1, -1, -1, -1, -1}, new int[]{6, 26, -1, -1, -1, -1, -1}, new int[]{6, 30, -1, -1, -1, -1, -1}, new int[]{6, 34, -1, -1, -1, -1, -1}, new int[]{6, 22, 38, -1, -1, -1, -1}, new int[]{6, 24, 42, -1, -1, -1, -1}, new int[]{6, 26, 46, -1, -1, -1, -1}, new int[]{6, 28, 50, -1, -1, -1, -1}, new int[]{6, 30, 54, -1, -1, -1, -1}, new int[]{6, 32, 58, -1, -1, -1, -1}, new int[]{6, 34, 62, -1, -1, -1, -1}, new int[]{6, 26, 46, 66, -1, -1, -1}, new int[]{6, 26, 48, 70, -1, -1, -1}, new int[]{6, 26, 50, 74, -1, -1, -1}, new int[]{6, 30, 54, 78, -1, -1, -1}, new int[]{6, 30, 56, 82, -1, -1, -1}, new int[]{6, 30, 58, 86, -1, -1, -1}, new int[]{6, 34, 62, 90, -1, -1, -1}, new int[]{6, 28, 50, 72, 94, -1, -1}, new int[]{6, 26, 50, 74, 98, -1, -1}, new int[]{6, 30, 54, 78, 102, -1, -1}, new int[]{6, 28, 54, 80, 106, -1, -1}, new int[]{6, 32, 58, 84, 110, -1, -1}, new int[]{6, 30, 58, 86, 114, -1, -1}, new int[]{6, 34, 62, 90, 118, -1, -1}, new int[]{6, 26, 50, 74, 98, 122, -1}, new int[]{6, 30, 54, 78, 102, 126, -1}, new int[]{6, 26, 52, 78, 104, 130, -1}, new int[]{6, 30, 56, 82, 108, SwanAppMessengerService.ServerToClient.MSG_CLEAN_ACCREDIT_NODE, -1}, new int[]{6, 34, 60, 86, 112, 138, -1}, new int[]{6, 30, 58, 86, 114, NetdiskErrorCode.NO_OPERATE_PERMISSION, -1}, new int[]{6, 34, 62, 90, 118, 146, -1}, new int[]{6, 30, 54, 78, 102, 126, 150}, new int[]{6, 24, 50, 76, 102, 128, 154}, new int[]{6, 28, 54, 80, 106, 132, 158}, new int[]{6, 32, 58, 84, 110, 136, 162}, new int[]{6, 26, 54, 82, 110, 138, 166}, new int[]{6, 30, 58, 86, 114, NetdiskErrorCode.NO_OPERATE_PERMISSION, 170}};
    private static final int[][] POSITION_DETECTION_PATTERN = {new int[]{1, 1, 1, 1, 1, 1, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 1, 1, 1, 0, 1}, new int[]{1, 0, 0, 0, 0, 0, 1}, new int[]{1, 1, 1, 1, 1, 1, 1}};
    private static final int[][] TYPE_INFO_COORDINATES = {new int[]{8, 0}, new int[]{8, 1}, new int[]{8, 2}, new int[]{8, 3}, new int[]{8, 4}, new int[]{8, 5}, new int[]{8, 7}, new int[]{8, 8}, new int[]{7, 8}, new int[]{5, 8}, new int[]{4, 8}, new int[]{3, 8}, new int[]{2, 8}, new int[]{1, 8}, new int[]{0, 8}};
    private static final int TYPE_INFO_MASK_PATTERN = 21522;
    private static final int TYPE_INFO_POLY = 1335;
    private static final int VERSION_INFO_POLY = 7973;

    private MatrixUtil() {
    }

    static void clearMatrix(ByteMatrix matrix) {
        matrix.clear((byte) -1);
    }

    static void buildMatrix(BitArray dataBits, ErrorCorrectionLevel ecLevel, Version version, int maskPattern, ByteMatrix matrix) throws WriterException {
        clearMatrix(matrix);
        embedBasicPatterns(version, matrix);
        embedTypeInfo(ecLevel, maskPattern, matrix);
        maybeEmbedVersionInfo(version, matrix);
        embedDataBits(dataBits, maskPattern, matrix);
    }

    static void embedBasicPatterns(Version version, ByteMatrix matrix) throws WriterException {
        embedPositionDetectionPatternsAndSeparators(matrix);
        embedDarkDotAtLeftBottomCorner(matrix);
        maybeEmbedPositionAdjustmentPatterns(version, matrix);
        embedTimingPatterns(matrix);
    }

    static void embedTypeInfo(ErrorCorrectionLevel ecLevel, int maskPattern, ByteMatrix matrix) throws WriterException {
        BitArray typeInfoBits = new BitArray();
        makeTypeInfoBits(ecLevel, maskPattern, typeInfoBits);
        for (int i2 = 0; i2 < typeInfoBits.getSize(); i2++) {
            boolean bit = typeInfoBits.get((typeInfoBits.getSize() - 1) - i2);
            int[] iArr = TYPE_INFO_COORDINATES[i2];
            matrix.set(iArr[0], iArr[1], bit);
            if (i2 < 8) {
                matrix.set((matrix.getWidth() - i2) - 1, 8, bit);
            } else {
                matrix.set(8, (matrix.getHeight() - 7) + (i2 - 8), bit);
            }
        }
    }

    static void maybeEmbedVersionInfo(Version version, ByteMatrix matrix) throws WriterException {
        if (version.getVersionNumber() >= 7) {
            BitArray versionInfoBits = new BitArray();
            makeVersionInfoBits(version, versionInfoBits);
            int bitIndex = 17;
            for (int i2 = 0; i2 < 6; i2++) {
                for (int j2 = 0; j2 < 3; j2++) {
                    boolean bit = versionInfoBits.get(bitIndex);
                    bitIndex--;
                    matrix.set(i2, (matrix.getHeight() - 11) + j2, bit);
                    matrix.set((matrix.getHeight() - 11) + j2, i2, bit);
                }
            }
        }
    }

    static void embedDataBits(BitArray dataBits, int maskPattern, ByteMatrix matrix) throws WriterException {
        boolean bit;
        int bitIndex = 0;
        int direction = -1;
        int x = matrix.getWidth() - 1;
        int y = matrix.getHeight() - 1;
        while (x > 0) {
            if (x == 6) {
                x--;
            }
            while (y >= 0 && y < matrix.getHeight()) {
                for (int i2 = 0; i2 < 2; i2++) {
                    int xx = x - i2;
                    if (isEmpty(matrix.get(xx, y))) {
                        if (bitIndex < dataBits.getSize()) {
                            bit = dataBits.get(bitIndex);
                            bitIndex++;
                        } else {
                            bit = false;
                        }
                        if (maskPattern != -1 && MaskUtil.getDataMaskBit(maskPattern, xx, y)) {
                            bit = !bit;
                        }
                        matrix.set(xx, y, bit);
                    }
                }
                y += direction;
            }
            direction = -direction;
            y += direction;
            x -= 2;
        }
        if (bitIndex != dataBits.getSize()) {
            throw new WriterException("Not all bits consumed: " + bitIndex + '/' + dataBits.getSize());
        }
    }

    static int findMSBSet(int value) {
        int numDigits = 0;
        while (value != 0) {
            value >>>= 1;
            numDigits++;
        }
        return numDigits;
    }

    static int calculateBCHCode(int value, int poly) {
        int msbSetInPoly = findMSBSet(poly);
        int value2 = value << (msbSetInPoly - 1);
        while (findMSBSet(value2) >= msbSetInPoly) {
            value2 ^= poly << (findMSBSet(value2) - msbSetInPoly);
        }
        return value2;
    }

    static void makeTypeInfoBits(ErrorCorrectionLevel ecLevel, int maskPattern, BitArray bits) throws WriterException {
        if (QRCode.isValidMaskPattern(maskPattern)) {
            int typeInfo = (ecLevel.getBits() << 3) | maskPattern;
            bits.appendBits(typeInfo, 5);
            bits.appendBits(calculateBCHCode(typeInfo, TYPE_INFO_POLY), 10);
            BitArray maskBits = new BitArray();
            maskBits.appendBits(TYPE_INFO_MASK_PATTERN, 15);
            bits.xor(maskBits);
            if (bits.getSize() != 15) {
                throw new WriterException("should not happen but we got: " + bits.getSize());
            }
            return;
        }
        throw new WriterException("Invalid mask pattern");
    }

    static void makeVersionInfoBits(Version version, BitArray bits) throws WriterException {
        bits.appendBits(version.getVersionNumber(), 6);
        bits.appendBits(calculateBCHCode(version.getVersionNumber(), VERSION_INFO_POLY), 12);
        if (bits.getSize() != 18) {
            throw new WriterException("should not happen but we got: " + bits.getSize());
        }
    }

    private static boolean isEmpty(int value) {
        return value == -1;
    }

    private static void embedTimingPatterns(ByteMatrix matrix) {
        for (int i2 = 8; i2 < matrix.getWidth() - 8; i2++) {
            int bit = (i2 + 1) % 2;
            if (isEmpty(matrix.get(i2, 6))) {
                matrix.set(i2, 6, bit);
            }
            if (isEmpty(matrix.get(6, i2))) {
                matrix.set(6, i2, bit);
            }
        }
    }

    private static void embedDarkDotAtLeftBottomCorner(ByteMatrix matrix) throws WriterException {
        if (matrix.get(8, matrix.getHeight() - 8) != 0) {
            matrix.set(8, matrix.getHeight() - 8, 1);
            return;
        }
        throw new WriterException();
    }

    private static void embedHorizontalSeparationPattern(int xStart, int yStart, ByteMatrix matrix) throws WriterException {
        int x = 0;
        while (x < 8) {
            if (isEmpty(matrix.get(xStart + x, yStart))) {
                matrix.set(xStart + x, yStart, 0);
                x++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void embedVerticalSeparationPattern(int xStart, int yStart, ByteMatrix matrix) throws WriterException {
        int y = 0;
        while (y < 7) {
            if (isEmpty(matrix.get(xStart, yStart + y))) {
                matrix.set(xStart, yStart + y, 0);
                y++;
            } else {
                throw new WriterException();
            }
        }
    }

    private static void embedPositionAdjustmentPattern(int xStart, int yStart, ByteMatrix matrix) {
        for (int y = 0; y < 5; y++) {
            for (int x = 0; x < 5; x++) {
                matrix.set(xStart + x, yStart + y, POSITION_ADJUSTMENT_PATTERN[y][x]);
            }
        }
    }

    private static void embedPositionDetectionPattern(int xStart, int yStart, ByteMatrix matrix) {
        for (int y = 0; y < 7; y++) {
            for (int x = 0; x < 7; x++) {
                matrix.set(xStart + x, yStart + y, POSITION_DETECTION_PATTERN[y][x]);
            }
        }
    }

    private static void embedPositionDetectionPatternsAndSeparators(ByteMatrix matrix) throws WriterException {
        int pdpWidth = POSITION_DETECTION_PATTERN[0].length;
        embedPositionDetectionPattern(0, 0, matrix);
        embedPositionDetectionPattern(matrix.getWidth() - pdpWidth, 0, matrix);
        embedPositionDetectionPattern(0, matrix.getWidth() - pdpWidth, matrix);
        embedHorizontalSeparationPattern(0, 8 - 1, matrix);
        embedHorizontalSeparationPattern(matrix.getWidth() - 8, 8 - 1, matrix);
        embedHorizontalSeparationPattern(0, matrix.getWidth() - 8, matrix);
        embedVerticalSeparationPattern(7, 0, matrix);
        embedVerticalSeparationPattern((matrix.getHeight() - 7) - 1, 0, matrix);
        embedVerticalSeparationPattern(7, matrix.getHeight() - 7, matrix);
    }

    private static void maybeEmbedPositionAdjustmentPatterns(Version version, ByteMatrix matrix) {
        if (version.getVersionNumber() >= 2) {
            int index = version.getVersionNumber() - 1;
            int[][] iArr = POSITION_ADJUSTMENT_PATTERN_COORDINATE_TABLE;
            int[] coordinates = iArr[index];
            int numCoordinates = iArr[index].length;
            for (int i2 = 0; i2 < numCoordinates; i2++) {
                for (int j2 = 0; j2 < numCoordinates; j2++) {
                    int y = coordinates[i2];
                    int x = coordinates[j2];
                    if (!(x == -1 || y == -1 || !isEmpty(matrix.get(x, y)))) {
                        embedPositionAdjustmentPattern(x - 2, y - 2, matrix);
                    }
                }
            }
        }
    }
}
