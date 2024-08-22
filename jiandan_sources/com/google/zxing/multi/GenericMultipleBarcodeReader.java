package com.google.zxing.multi;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.Reader;
import com.google.zxing.ReaderException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class GenericMultipleBarcodeReader implements MultipleBarcodeReader {
    public static final int MAX_DEPTH = 4;
    public static final int MIN_DIMENSION_TO_RECUR = 100;
    public final Reader delegate;

    public GenericMultipleBarcodeReader(Reader reader) {
        this.delegate = reader;
    }

    private void doDecodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map, List<Result> list, int i2, int i3, int i4) {
        boolean z;
        float f;
        float f2;
        int i5;
        int i6;
        BinaryBitmap binaryBitmap2 = binaryBitmap;
        int i7 = i2;
        int i8 = i3;
        int i9 = i4;
        if (i9 <= 4) {
            try {
                Result decode = this.delegate.decode(binaryBitmap2, map);
                Iterator<Result> it = list.iterator();
                while (true) {
                    if (it.hasNext()) {
                        if (it.next().getText().equals(decode.getText())) {
                            z = true;
                            break;
                        }
                    } else {
                        z = false;
                        break;
                    }
                }
                if (!z) {
                    list.add(translateResultPoints(decode, i7, i8));
                } else {
                    List<Result> list2 = list;
                }
                ResultPoint[] resultPoints = decode.getResultPoints();
                if (resultPoints != null && resultPoints.length != 0) {
                    int width = binaryBitmap.getWidth();
                    int height = binaryBitmap.getHeight();
                    float f3 = (float) width;
                    float f4 = (float) height;
                    float f5 = 0.0f;
                    float f6 = 0.0f;
                    for (ResultPoint resultPoint : resultPoints) {
                        if (resultPoint != null) {
                            float x = resultPoint.getX();
                            float y = resultPoint.getY();
                            if (x < f3) {
                                f3 = x;
                            }
                            if (y < f4) {
                                f4 = y;
                            }
                            if (x > f5) {
                                f5 = x;
                            }
                            if (y > f6) {
                                f6 = y;
                            }
                        }
                    }
                    if (f3 > 100.0f) {
                        f = f5;
                        f2 = f4;
                        i6 = height;
                        i5 = width;
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, (int) f3, height), map, list, i2, i3, i9 + 1);
                    } else {
                        f = f5;
                        f2 = f4;
                        i6 = height;
                        i5 = width;
                    }
                    if (f2 > 100.0f) {
                        doDecodeMultiple(binaryBitmap2.crop(0, 0, i5, (int) f2), map, list, i2, i3, i9 + 1);
                    }
                    float f7 = f;
                    if (f7 < ((float) (i5 - 100))) {
                        int i10 = (int) f7;
                        doDecodeMultiple(binaryBitmap2.crop(i10, 0, i5 - i10, i6), map, list, i7 + i10, i3, i9 + 1);
                    }
                    if (f6 < ((float) (i6 - 100))) {
                        int i11 = (int) f6;
                        doDecodeMultiple(binaryBitmap2.crop(0, i11, i5, i6 - i11), map, list, i2, i8 + i11, i9 + 1);
                    }
                }
            } catch (ReaderException unused) {
            }
        }
    }

    public static Result translateResultPoints(Result result, int i2, int i3) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints == null) {
            return result;
        }
        ResultPoint[] resultPointArr = new ResultPoint[resultPoints.length];
        for (int i4 = 0; i4 < resultPoints.length; i4++) {
            ResultPoint resultPoint = resultPoints[i4];
            if (resultPoint != null) {
                resultPointArr[i4] = new ResultPoint(resultPoint.getX() + ((float) i2), resultPoint.getY() + ((float) i3));
            }
        }
        Result result2 = new Result(result.getText(), result.getRawBytes(), result.getNumBits(), resultPointArr, result.getBarcodeFormat(), result.getTimestamp());
        result2.putAllMetadata(result.getResultMetadata());
        return result2;
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap) throws NotFoundException {
        return decodeMultiple(binaryBitmap, (Map<DecodeHintType, ?>) null);
    }

    public Result[] decodeMultiple(BinaryBitmap binaryBitmap, Map<DecodeHintType, ?> map) throws NotFoundException {
        ArrayList arrayList = new ArrayList();
        doDecodeMultiple(binaryBitmap, map, arrayList, 0, 0, 0);
        if (!arrayList.isEmpty()) {
            return (Result[]) arrayList.toArray(new Result[arrayList.size()]);
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
