package com.baidu.searchbox.userassetsaggr.container;

import com.baidu.pyramid.annotation.tekes.StableApi;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0013\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007J\u000e\u0010\u0014\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u00020\u00078\u0006XT¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/baidu/searchbox/userassetsaggr/container/WenkuDocTypeUtils;", "", "()V", "KEY_DOC_TYPE", "", "KEY_EXT_DATA", "RESOURCE_TYPE_CAD", "", "RESOURCE_TYPE_DOC", "RESOURCE_TYPE_EPUB", "RESOURCE_TYPE_PDF", "RESOURCE_TYPE_PPT", "RESOURCE_TYPE_TXT", "RESOURCE_TYPE_UMD", "RESOURCE_TYPE_UNKNOWN", "RESOURCE_TYPE_VSD", "RESOURCE_TYPE_XLS", "getDocCoverRes", "docType", "getDocTagDrawableId", "getDocTagText", "lib-favorHis-base_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: WenkuDocTypeUtils.kt */
public final class WenkuDocTypeUtils {
    public static final WenkuDocTypeUtils INSTANCE = new WenkuDocTypeUtils();
    @StableApi
    public static final String KEY_DOC_TYPE = "doctype";
    @StableApi
    public static final String KEY_EXT_DATA = "extdata";
    @StableApi
    public static final int RESOURCE_TYPE_CAD = 29;
    @StableApi
    public static final int RESOURCE_TYPE_DOC = 21;
    @StableApi
    public static final int RESOURCE_TYPE_EPUB = 27;
    @StableApi
    public static final int RESOURCE_TYPE_PDF = 24;
    @StableApi
    public static final int RESOURCE_TYPE_PPT = 23;
    @StableApi
    public static final int RESOURCE_TYPE_TXT = 25;
    @StableApi
    public static final int RESOURCE_TYPE_UMD = 28;
    @StableApi
    public static final int RESOURCE_TYPE_UNKNOWN = -1;
    @StableApi
    public static final int RESOURCE_TYPE_VSD = 26;
    @StableApi
    public static final int RESOURCE_TYPE_XLS = 22;

    private WenkuDocTypeUtils() {
    }

    public final int getDocCoverRes(int docType) {
        switch (docType) {
            case 21:
                return R.drawable.favor_doc_cover_doc;
            case 22:
                return R.drawable.favor_doc_cover_xls;
            case 23:
                return R.drawable.favor_doc_cover_ppt;
            case 24:
                return R.drawable.favor_doc_cover_pdf;
            case 25:
                return R.drawable.favor_doc_cover_txt;
            case 26:
                return R.drawable.favor_doc_cover_vsd;
            case 27:
                return R.drawable.favor_doc_cover_epub;
            case 28:
                return R.drawable.favor_doc_cover_epub;
            case 29:
                return R.drawable.favor_doc_cover_cad;
            default:
                return R.drawable.favor_doc_cover_unknow;
        }
    }

    public final int getDocTagText(int docType) {
        switch (docType) {
            case 21:
                return R.string.user_assets_doc_type_word;
            case 22:
                return R.string.user_assets_doc_type_xls;
            case 23:
                return R.string.user_assets_doc_type_ppt;
            case 24:
                return R.string.user_assets_doc_type_pdf;
            case 25:
                return R.string.user_assets_doc_type_txt;
            case 26:
                return R.string.user_assets_doc_type_vsd;
            case 27:
                return R.string.user_assets_doc_type_epub;
            case 28:
                return R.string.user_assets_doc_type_umd;
            case 29:
                return R.string.user_assets_doc_type_cad;
            default:
                return R.string.user_assets_doc_type_other;
        }
    }

    public final int getDocTagDrawableId(int docType) {
        switch (docType) {
            case 21:
                return R.drawable.favor_doc_type_tag_doc;
            case 22:
                return R.drawable.favor_doc_type_tag_xls;
            case 23:
                return R.drawable.favor_doc_type_tag_ppt;
            case 24:
                return R.drawable.favor_doc_type_tag_pdf;
            case 25:
                return R.drawable.favor_doc_type_tag_txt;
            case 26:
                return R.drawable.favor_doc_type_tag_vsd;
            case 27:
                return R.drawable.favor_doc_type_tag_epub;
            case 28:
                return R.drawable.favor_doc_type_tag_umd;
            case 29:
                return R.drawable.favor_doc_type_tag_cad;
            default:
                return R.drawable.favor_doc_type_tag_unknow;
        }
    }
}
