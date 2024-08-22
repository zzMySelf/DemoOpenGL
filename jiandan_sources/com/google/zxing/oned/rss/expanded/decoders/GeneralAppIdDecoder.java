package com.google.zxing.oned.rss.expanded.decoders;

import com.alipay.sdk.m.n.a;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.sapi2.views.logindialog.QuickLoginDialog;
import com.baidu.wallet.lightapp.business.LightappBusinessClient;
import com.google.common.base.Ascii;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import kotlin.text.Typography;
import org.apache.commons.lang3.text.ExtendedMessageFormat;

public final class GeneralAppIdDecoder {
    public final StringBuilder buffer = new StringBuilder();
    public final CurrentParsingState current = new CurrentParsingState();
    public final BitArray information;

    public GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    private DecodedChar decodeAlphanumeric(int i2) {
        char c;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i2 + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i2 + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 6);
        if (extractNumericValueFromBitArray2 >= 32 && extractNumericValueFromBitArray2 < 58) {
            return new DecodedChar(i2 + 6, (char) (extractNumericValueFromBitArray2 + 33));
        }
        switch (extractNumericValueFromBitArray2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(extractNumericValueFromBitArray2)));
        }
        return new DecodedChar(i2 + 6, c);
    }

    private DecodedChar decodeIsoIec646(int i2) throws FormatException {
        char c;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i2 + 5, '$');
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i2 + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 7);
        if (extractNumericValueFromBitArray2 >= 64 && extractNumericValueFromBitArray2 < 90) {
            return new DecodedChar(i2 + 7, (char) (extractNumericValueFromBitArray2 + 1));
        }
        if (extractNumericValueFromBitArray2 >= 90 && extractNumericValueFromBitArray2 < 116) {
            return new DecodedChar(i2 + 7, (char) (extractNumericValueFromBitArray2 + 7));
        }
        switch (extractNumericValueFromBitArray(i2, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = '\"';
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = Typography.amp;
                break;
            case 236:
                c = ExtendedMessageFormat.QUOTE;
                break;
            case 237:
                c = '(';
                break;
            case QuickLoginDialog.HEIGHT_ONEKEY:
                c = ')';
                break;
            case 239:
                c = '*';
                break;
            case AuthorityState.STATE_ERROR_NETWORK:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case LightappBusinessClient.REQUEST_PERMISSION_SELECT_PHONE_FROM_ADDRESSBOOK:
                c = '.';
                break;
            case LightappBusinessClient.REQUEST_PERMISSION_RECORDAUDIO:
                c = '/';
                break;
            case LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_FACE:
                c = ':';
                break;
            case LightappBusinessClient.REQUEST_PERMISSION_CAMERA_AND_WRITE_EXTERNAL_STORGE_SENSE:
                c = ';';
                break;
            case LightappBusinessClient.REQUEST_PERMISSION_UNIVERSAL_SET:
                c = Typography.less;
                break;
            case LightappBusinessClient.REQUEST_PERMISSION_SAVE_PIC:
                c = a.h;
                break;
            case 249:
                c = Typography.greater;
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = Ascii.CASE_MASK;
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new DecodedChar(i2 + 8, c);
    }

    private DecodedNumeric decodeNumeric(int i2) throws FormatException {
        int i3 = i2 + 7;
        if (i3 > this.information.getSize()) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 4);
            if (extractNumericValueFromBitArray == 0) {
                return new DecodedNumeric(this.information.getSize(), 10, 10);
            }
            return new DecodedNumeric(this.information.getSize(), extractNumericValueFromBitArray - 1, 10);
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 7) - 8;
        return new DecodedNumeric(i3, extractNumericValueFromBitArray2 / 11, extractNumericValueFromBitArray2 % 11);
    }

    private boolean isAlphaOr646ToNumericLatch(int i2) {
        int i3 = i2 + 3;
        if (i3 > this.information.getSize()) {
            return false;
        }
        while (i2 < i3) {
            if (this.information.get(i2)) {
                return false;
            }
            i2++;
        }
        return true;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i2) {
        int i3;
        if (i2 + 1 > this.information.getSize()) {
            return false;
        }
        int i4 = 0;
        while (i4 < 5 && (i3 = i4 + i2) < this.information.getSize()) {
            if (i4 == 2) {
                if (!this.information.get(i2 + 2)) {
                    return false;
                }
            } else if (this.information.get(i3)) {
                return false;
            }
            i4++;
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i2) {
        int i3;
        if (i2 + 1 > this.information.getSize()) {
            return false;
        }
        int i4 = 0;
        while (i4 < 4 && (i3 = i4 + i2) < this.information.getSize()) {
            if (this.information.get(i3)) {
                return false;
            }
            i4++;
        }
        return true;
    }

    private boolean isStillAlpha(int i2) {
        int extractNumericValueFromBitArray;
        if (i2 + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 5);
        if (extractNumericValueFromBitArray2 >= 5 && extractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i2 + 6 <= this.information.getSize() && (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 6)) >= 16 && extractNumericValueFromBitArray < 63) {
            return true;
        }
        return false;
    }

    private boolean isStillIsoIec646(int i2) {
        int extractNumericValueFromBitArray;
        if (i2 + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i2, 5);
        if (extractNumericValueFromBitArray2 >= 5 && extractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i2 + 7 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i2, 7);
        if (extractNumericValueFromBitArray3 >= 64 && extractNumericValueFromBitArray3 < 116) {
            return true;
        }
        if (i2 + 8 <= this.information.getSize() && (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i2, 8)) >= 232 && extractNumericValueFromBitArray < 253) {
            return true;
        }
        return false;
    }

    private boolean isStillNumeric(int i2) {
        if (i2 + 7 <= this.information.getSize()) {
            int i3 = i2;
            while (true) {
                int i4 = i2 + 3;
                if (i3 >= i4) {
                    return this.information.get(i4);
                }
                if (this.information.get(i3)) {
                    return true;
                }
                i3++;
            }
        } else if (i2 + 4 <= this.information.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    private BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.getPosition())) {
            DecodedChar decodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
            this.current.setPosition(decodeAlphanumeric.getNewPosition());
            if (decodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setIsoIec646();
        }
        return new BlockParsedResult(false);
    }

    private DecodedInformation parseBlocks() throws FormatException {
        boolean z;
        BlockParsedResult blockParsedResult;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                blockParsedResult = parseAlphaBlock();
                z = blockParsedResult.isFinished();
            } else if (this.current.isIsoIec646()) {
                blockParsedResult = parseIsoIec646Block();
                z = blockParsedResult.isFinished();
            } else {
                blockParsedResult = parseNumericBlock();
                z = blockParsedResult.isFinished();
            }
            if (!(position != this.current.getPosition()) && !z) {
                break;
            }
        } while (!z);
        return blockParsedResult.getDecodedInformation();
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        while (isStillIsoIec646(this.current.getPosition())) {
            DecodedChar decodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
            this.current.setPosition(decodeIsoIec646.getNewPosition());
            if (decodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setAlpha();
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
        DecodedInformation decodedInformation;
        while (isStillNumeric(this.current.getPosition())) {
            DecodedNumeric decodeNumeric = decodeNumeric(this.current.getPosition());
            this.current.setPosition(decodeNumeric.getNewPosition());
            if (decodeNumeric.isFirstDigitFNC1()) {
                if (decodeNumeric.isSecondDigitFNC1()) {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
                } else {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodeNumeric.getSecondDigit());
                }
                return new BlockParsedResult(decodedInformation, true);
            }
            this.buffer.append(decodeNumeric.getFirstDigit());
            if (decodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
            this.current.setAlpha();
            this.current.incrementPosition(4);
        }
        return new BlockParsedResult(false);
    }

    public String decodeAllCodes(StringBuilder sb, int i2) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i2, str);
            String parseFieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString());
            if (parseFieldsInGeneralPurpose != null) {
                sb.append(parseFieldsInGeneralPurpose);
            }
            String valueOf = decodeGeneralPurposeField.isRemaining() ? String.valueOf(decodeGeneralPurposeField.getRemainingValue()) : null;
            if (i2 == decodeGeneralPurposeField.getNewPosition()) {
                return sb.toString();
            }
            i2 = decodeGeneralPurposeField.getNewPosition();
            str = valueOf;
        }
    }

    public DecodedInformation decodeGeneralPurposeField(int i2, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i2);
        DecodedInformation parseBlocks = parseBlocks();
        if (parseBlocks == null || !parseBlocks.isRemaining()) {
            return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
        }
        return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), parseBlocks.getRemainingValue());
    }

    public int extractNumericValueFromBitArray(int i2, int i3) {
        return extractNumericValueFromBitArray(this.information, i2, i3);
    }

    public static int extractNumericValueFromBitArray(BitArray bitArray, int i2, int i3) {
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            if (bitArray.get(i2 + i5)) {
                i4 |= 1 << ((i3 - i5) - 1);
            }
        }
        return i4;
    }
}
