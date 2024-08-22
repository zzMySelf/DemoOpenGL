package com.baidu.netdisk.backup.constant;

import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00020\u00012\u0006\u0010\b\u001a\u00020\tH\u0000\u001a\u0012\u0010\n\u001a\u0004\u0018\u00010\t2\u0006\u0010\u000b\u001a\u00020\u0002H\u0000\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000\"\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"SUFFIXES_EXCEL", "", "", "SUFFIXES_PDF", "SUFFIXES_PPT", "SUFFIXES_TXT", "SUFFIXES_WORD", "getDocumentSuffixes", "type", "Lcom/baidu/netdisk/backup/constant/DocumentBackupType;", "getDocumentTypeBySuffix", "suffix", "BaiduNetDiskModules_BackUp_release"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: DocumentBackupType.kt */
public final class DocumentBackupTypeKt {
    private static final Set<String> SUFFIXES_EXCEL = SetsKt.setOf("xls", "xlsx", "numbers");
    private static final Set<String> SUFFIXES_PDF = SetsKt.setOf("pdf");
    private static final Set<String> SUFFIXES_PPT = SetsKt.setOf("ppt", "pptx", "key");
    private static final Set<String> SUFFIXES_TXT = SetsKt.setOf("txt");
    private static final Set<String> SUFFIXES_WORD = SetsKt.setOf("doc", "docx", "pages");

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    /* compiled from: DocumentBackupType.kt */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DocumentBackupType.values().length];
            iArr[DocumentBackupType.PDF.ordinal()] = 1;
            iArr[DocumentBackupType.WORD.ordinal()] = 2;
            iArr[DocumentBackupType.EXCEL.ordinal()] = 3;
            iArr[DocumentBackupType.PPT.ordinal()] = 4;
            iArr[DocumentBackupType.TXT.ordinal()] = 5;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public static final Set<String> getDocumentSuffixes(DocumentBackupType type) {
        Intrinsics.checkNotNullParameter(type, "type");
        switch (WhenMappings.$EnumSwitchMapping$0[type.ordinal()]) {
            case 1:
                return SUFFIXES_PDF;
            case 2:
                return SUFFIXES_WORD;
            case 3:
                return SUFFIXES_EXCEL;
            case 4:
                return SUFFIXES_PPT;
            case 5:
                return SUFFIXES_TXT;
            default:
                return SetsKt.emptySet();
        }
    }

    public static final DocumentBackupType getDocumentTypeBySuffix(String suffix) {
        Intrinsics.checkNotNullParameter(suffix, "suffix");
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault()");
        String suffixLower = suffix.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(suffixLower, "this as java.lang.String).toLowerCase(locale)");
        if (SUFFIXES_PDF.contains(suffixLower)) {
            return DocumentBackupType.PDF;
        }
        if (SUFFIXES_WORD.contains(suffixLower)) {
            return DocumentBackupType.WORD;
        }
        if (SUFFIXES_EXCEL.contains(suffixLower)) {
            return DocumentBackupType.EXCEL;
        }
        if (SUFFIXES_PPT.contains(suffixLower)) {
            return DocumentBackupType.PPT;
        }
        if (SUFFIXES_TXT.contains(suffixLower)) {
            return DocumentBackupType.TXT;
        }
        return null;
    }
}
