package com.shockwave.pdfium;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.RectF;
import android.os.ParcelFileDescriptor;
import android.view.Surface;
import com.shockwave.pdfium.PdfDocument;
import com.shockwave.pdfium.util.Size;
import java.io.FileDescriptor;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class PdfiumCore {
    public static final int CONTENT_MAX_RECURSIVE_DEPTH = 100;
    public static final Class FD_CLASS = FileDescriptor.class;
    public static final String FD_FIELD_NAME = "descriptor";
    public static final String GLOBAL_CONFIG_KEY_SO_PATH = "key_plugin_pdf_so_download_path";
    public static final Object LOCK = new Object();
    public static final String TAG = "com.shockwave.pdfium.PdfiumCore";
    public static boolean isSoInit = false;
    public static Field mFdField = null;
    public static boolean soExists = false;
    public int mCurrentDpi;

    static {
        initPdfSo();
    }

    public PdfiumCore(Context context) {
        this.mCurrentDpi = context.getResources().getDisplayMetrics().densityDpi;
        if (!isSoInit) {
            initPdfSo();
        }
    }

    public static int getNumFd(ParcelFileDescriptor parcelFileDescriptor) {
        try {
            if (mFdField == null) {
                Field declaredField = FD_CLASS.getDeclaredField(FD_FIELD_NAME);
                mFdField = declaredField;
                declaredField.setAccessible(true);
            }
            return mFdField.getInt(parcelFileDescriptor.getFileDescriptor());
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return -1;
        } catch (IllegalAccessException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    public static void initPdfSo() {
        try {
            System.loadLibrary("c++_shared");
            System.loadLibrary("modpng");
            System.loadLibrary("modft2");
            System.loadLibrary("modpdfium");
            System.loadLibrary("jniPdfium");
        } catch (UnsatisfiedLinkError e) {
            "Native libraries failed to load - " + e;
        }
    }

    private native void nativeCloseDocument(long j);

    private native void nativeClosePage(long j);

    private native void nativeClosePages(long[] jArr);

    private native long nativeGetBookmarkDestIndex(long j, long j2);

    private native String nativeGetBookmarkTitle(long j);

    private native Integer nativeGetDestPageIndex(long j, long j2);

    private native String nativeGetDocumentMetaText(long j, String str);

    private native Long nativeGetFirstChildBookmark(long j, Long l);

    private native RectF nativeGetLinkRect(long j);

    private native String nativeGetLinkURI(long j, long j2);

    private native int nativeGetPageCount(long j);

    private native int nativeGetPageHeightPixel(long j, int i2);

    private native int nativeGetPageHeightPoint(long j);

    private native long[] nativeGetPageLinks(long j);

    private native Size nativeGetPageSizeByIndex(long j, int i2, int i3);

    private native int nativeGetPageWidthPixel(long j, int i2);

    private native int nativeGetPageWidthPoint(long j);

    private native Long nativeGetSiblingBookmark(long j, long j2);

    private native long nativeLoadPage(long j, int i2);

    private native long[] nativeLoadPages(long j, int i2, int i3);

    private native long nativeOpenDocument(int i2, String str);

    private native long nativeOpenMemDocument(byte[] bArr, String str);

    private native Point nativePageCoordsToDevice(long j, int i2, int i3, int i4, int i5, int i6, double d, double d2);

    private native void nativeRenderPage(long j, Surface surface, int i2, int i3, int i4, int i5, int i6, boolean z);

    private native void nativeRenderPageBitmap(long j, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6, boolean z);

    private void recursiveGetBookmark(List<PdfDocument.Bookmark> list, PdfDocument pdfDocument, long j, int i2) {
        PdfDocument.Bookmark bookmark = new PdfDocument.Bookmark();
        bookmark.mNativePtr = j;
        bookmark.title = nativeGetBookmarkTitle(j);
        bookmark.pageIdx = nativeGetBookmarkDestIndex(pdfDocument.mNativeDocPtr, j);
        list.add(bookmark);
        Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.mNativeDocPtr, Long.valueOf(j));
        if (nativeGetFirstChildBookmark != null && i2 < 100) {
            recursiveGetBookmark(bookmark.getChildren(), pdfDocument, nativeGetFirstChildBookmark.longValue(), i2 + 1);
        }
        Long nativeGetSiblingBookmark = nativeGetSiblingBookmark(pdfDocument.mNativeDocPtr, j);
        if (nativeGetSiblingBookmark != null && i2 < 100) {
            recursiveGetBookmark(list, pdfDocument, nativeGetSiblingBookmark.longValue(), i2 + 1);
        }
    }

    public void closeDocument(PdfDocument pdfDocument) {
        synchronized (LOCK) {
            for (Integer num : pdfDocument.mNativePagesPtr.keySet()) {
                nativeClosePage(pdfDocument.mNativePagesPtr.get(num).longValue());
            }
            pdfDocument.mNativePagesPtr.clear();
            nativeCloseDocument(pdfDocument.mNativeDocPtr);
            if (pdfDocument.parcelFileDescriptor != null) {
                try {
                    pdfDocument.parcelFileDescriptor.close();
                } catch (IOException unused) {
                }
                pdfDocument.parcelFileDescriptor = null;
            }
        }
    }

    public void closePage(PdfDocument pdfDocument, int i2) {
        synchronized (LOCK) {
            if (pdfDocument.mNativePagesPtr.containsKey(Integer.valueOf(i2))) {
                Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2));
                if (l != null) {
                    nativeClosePage(l.longValue());
                }
                pdfDocument.mNativePagesPtr.remove(Integer.valueOf(i2));
            }
        }
    }

    public PdfDocument.Meta getDocumentMeta(PdfDocument pdfDocument) {
        PdfDocument.Meta meta;
        synchronized (LOCK) {
            meta = new PdfDocument.Meta();
            meta.title = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Title");
            meta.author = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Author");
            meta.subject = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Subject");
            meta.keywords = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Keywords");
            meta.creator = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Creator");
            meta.producer = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "Producer");
            meta.creationDate = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "CreationDate");
            meta.modDate = nativeGetDocumentMetaText(pdfDocument.mNativeDocPtr, "ModDate");
        }
        return meta;
    }

    public int getPageCount(PdfDocument pdfDocument) {
        int nativeGetPageCount;
        synchronized (LOCK) {
            nativeGetPageCount = nativeGetPageCount(pdfDocument.mNativeDocPtr);
        }
        return nativeGetPageCount;
    }

    public int getPageHeight(PdfDocument pdfDocument, int i2) {
        synchronized (LOCK) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2));
            if (l == null) {
                return 0;
            }
            int nativeGetPageHeightPixel = nativeGetPageHeightPixel(l.longValue(), this.mCurrentDpi);
            return nativeGetPageHeightPixel;
        }
    }

    public int getPageHeightPoint(PdfDocument pdfDocument, int i2) {
        synchronized (LOCK) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2));
            if (l == null) {
                return 0;
            }
            int nativeGetPageHeightPoint = nativeGetPageHeightPoint(l.longValue());
            return nativeGetPageHeightPoint;
        }
    }

    public List<PdfDocument.Link> getPageLinks(PdfDocument pdfDocument, int i2) {
        synchronized (LOCK) {
            ArrayList arrayList = new ArrayList();
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2));
            if (l == null) {
                return arrayList;
            }
            for (long j : nativeGetPageLinks(l.longValue())) {
                Integer nativeGetDestPageIndex = nativeGetDestPageIndex(pdfDocument.mNativeDocPtr, j);
                String nativeGetLinkURI = nativeGetLinkURI(pdfDocument.mNativeDocPtr, j);
                RectF nativeGetLinkRect = nativeGetLinkRect(j);
                if (!(nativeGetLinkRect == null || (nativeGetDestPageIndex == null && nativeGetLinkURI == null))) {
                    arrayList.add(new PdfDocument.Link(nativeGetLinkRect, nativeGetDestPageIndex, nativeGetLinkURI));
                }
            }
            return arrayList;
        }
    }

    public Size getPageSize(PdfDocument pdfDocument, int i2) {
        Size nativeGetPageSizeByIndex;
        synchronized (LOCK) {
            nativeGetPageSizeByIndex = nativeGetPageSizeByIndex(pdfDocument.mNativeDocPtr, i2, this.mCurrentDpi);
        }
        return nativeGetPageSizeByIndex;
    }

    public int getPageWidth(PdfDocument pdfDocument, int i2) {
        synchronized (LOCK) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2));
            if (l == null) {
                return 0;
            }
            int nativeGetPageWidthPixel = nativeGetPageWidthPixel(l.longValue(), this.mCurrentDpi);
            return nativeGetPageWidthPixel;
        }
    }

    public int getPageWidthPoint(PdfDocument pdfDocument, int i2) {
        synchronized (LOCK) {
            Long l = pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2));
            if (l == null) {
                return 0;
            }
            int nativeGetPageWidthPoint = nativeGetPageWidthPoint(l.longValue());
            return nativeGetPageWidthPoint;
        }
    }

    public List<PdfDocument.Bookmark> getTableOfContents(PdfDocument pdfDocument) {
        ArrayList arrayList;
        synchronized (LOCK) {
            arrayList = new ArrayList();
            Long nativeGetFirstChildBookmark = nativeGetFirstChildBookmark(pdfDocument.mNativeDocPtr, (Long) null);
            if (nativeGetFirstChildBookmark != null) {
                recursiveGetBookmark(arrayList, pdfDocument, nativeGetFirstChildBookmark.longValue(), 0);
            }
        }
        return arrayList;
    }

    public boolean isSoExists() {
        return soExists;
    }

    public Point mapPageCoordsToDevice(PdfDocument pdfDocument, int i2, int i3, int i4, int i5, int i6, int i7, double d, double d2) {
        return nativePageCoordsToDevice(pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2)).longValue(), i3, i4, i5, i6, i7, d, d2);
    }

    public RectF mapRectToDevice(PdfDocument pdfDocument, int i2, int i3, int i4, int i5, int i6, int i7, RectF rectF) {
        RectF rectF2 = rectF;
        Point mapPageCoordsToDevice = mapPageCoordsToDevice(pdfDocument, i2, i3, i4, i5, i6, i7, (double) rectF2.left, (double) rectF2.top);
        Point mapPageCoordsToDevice2 = mapPageCoordsToDevice(pdfDocument, i2, i3, i4, i5, i6, i7, (double) rectF2.right, (double) rectF2.bottom);
        return new RectF((float) mapPageCoordsToDevice.x, (float) mapPageCoordsToDevice.y, (float) mapPageCoordsToDevice2.x, (float) mapPageCoordsToDevice2.y);
    }

    public PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor) throws IOException {
        return newDocument(parcelFileDescriptor, (String) null);
    }

    public long openPage(PdfDocument pdfDocument, int i2) {
        long nativeLoadPage;
        synchronized (LOCK) {
            nativeLoadPage = nativeLoadPage(pdfDocument.mNativeDocPtr, i2);
            pdfDocument.mNativePagesPtr.put(Integer.valueOf(i2), Long.valueOf(nativeLoadPage));
        }
        return nativeLoadPage;
    }

    public void renderPage(PdfDocument pdfDocument, Surface surface, int i2, int i3, int i4, int i5, int i6) {
        renderPage(pdfDocument, surface, i2, i3, i4, i5, i6, false);
    }

    public void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6) {
        renderPageBitmap(pdfDocument, bitmap, i2, i3, i4, i5, i6, false);
    }

    public PdfDocument newDocument(ParcelFileDescriptor parcelFileDescriptor, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        pdfDocument.parcelFileDescriptor = parcelFileDescriptor;
        synchronized (LOCK) {
            pdfDocument.mNativeDocPtr = nativeOpenDocument(getNumFd(parcelFileDescriptor), str);
        }
        return pdfDocument;
    }

    public void renderPage(PdfDocument pdfDocument, Surface surface, int i2, int i3, int i4, int i5, int i6, boolean z) {
        synchronized (LOCK) {
            try {
                try {
                    nativeRenderPage(pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2)).longValue(), surface, this.mCurrentDpi, i3, i4, i5, i6, z);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public void renderPageBitmap(PdfDocument pdfDocument, Bitmap bitmap, int i2, int i3, int i4, int i5, int i6, boolean z) {
        synchronized (LOCK) {
            try {
                try {
                    nativeRenderPageBitmap(pdfDocument.mNativePagesPtr.get(Integer.valueOf(i2)).longValue(), bitmap, this.mCurrentDpi, i3, i4, i5, i6, z);
                } catch (Exception e) {
                    e = e;
                }
            } catch (Exception e2) {
                e = e2;
                try {
                    e.printStackTrace();
                } catch (Throwable th2) {
                    th = th2;
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                throw th;
            }
        }
    }

    public long[] openPage(PdfDocument pdfDocument, int i2, int i3) {
        long[] nativeLoadPages;
        synchronized (LOCK) {
            nativeLoadPages = nativeLoadPages(pdfDocument.mNativeDocPtr, i2, i3);
            int length = nativeLoadPages.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    break;
                }
                long j = nativeLoadPages[i4];
                if (i2 > i3) {
                    break;
                }
                pdfDocument.mNativePagesPtr.put(Integer.valueOf(i2), Long.valueOf(j));
                i2++;
                i4++;
            }
        }
        return nativeLoadPages;
    }

    public PdfDocument newDocument(byte[] bArr) throws IOException {
        return newDocument(bArr, (String) null);
    }

    public PdfDocument newDocument(byte[] bArr, String str) throws IOException {
        PdfDocument pdfDocument = new PdfDocument();
        synchronized (LOCK) {
            pdfDocument.mNativeDocPtr = nativeOpenMemDocument(bArr, str);
        }
        return pdfDocument;
    }
}
