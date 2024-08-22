package com.tera.scan.filetype;

import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.baidu.aiscan.R;
import com.baidu.android.util.io.DocumentOpenUtil;
import java.util.regex.Pattern;

public enum FileType {
    IMAGE(R.drawable.icon_list_image, R.color.thumb_image, R.string.type_pic),
    VIDEO(R.drawable.icon_list_videofile, R.color.thumb_video, R.string.type_video),
    MUSIC(R.drawable.icon_list_audiofile, R.color.thumb_music, R.string.type_audio),
    DOCS(R.drawable.icon_list_doc, R.color.thumb_doc, R.string.type_document),
    DOC(R.drawable.icon_list_doc, R.color.thumb_doc, R.string.feed_type_doc),
    EXCEL(R.drawable.icon_list_excel, R.color.thumb_xls, R.string.feed_type_xls),
    TXT(R.drawable.icon_list_txtfile, R.color.thumb_txt, R.string.feed_type_txt),
    PPT(R.drawable.icon_list_ppt, R.color.thumb_ppt, R.string.feed_type_ppt),
    PDF(R.drawable.icon_list_pdf, R.color.thumb_pdf, R.string.feed_type_pdf),
    HTML(R.drawable.icon_list_html, R.color.thumb_html, R.string.feed_type_html),
    VSD(R.drawable.icon_list_visio, R.color.thumb_vsd, R.string.feed_type_vsd),
    VCF(R.drawable.fitype_icon_vcf, R.color.thumb_vcf, R.string.feed_type_vcf),
    BT(R.drawable.icon_list_bt, R.color.thumb_bt, R.string.feed_type_bt),
    APK(R.drawable.icon_list_apk, R.color.thumb_apk, R.string.type_app),
    ZIP(R.drawable.icon_list_compressfile, R.color.thumb_zip, R.string.feed_type_zip),
    EPUB(R.drawable.icon_list_epub, R.color.thumb_epub, R.string.feed_type_epub),
    PAND(R.drawable.icon_list_pand, R.color.thumb_doc, R.string.type_wp_document),
    CAD(R.drawable.icon_list_cad, R.color.thumb_cad, R.string.type_cad),
    PSD(R.drawable.icon_list_psd, R.color.thumb_cad, R.string.type_psd),
    EXE(R.drawable.icon_list_exe, R.color.thumb_exe, R.string.type_exe),
    KEYNOTE(R.drawable.icon_list_keynote, R.color.thumb_keynote, R.string.type_keynote),
    PAGES(R.drawable.icon_list_pages, R.color.thumb_pages, R.string.type_pages),
    NUMBERS(R.drawable.icon_list_numbers, R.color.thumb_numbers, R.string.type_numbers),
    MARKDOWN(R.drawable.icon_list_numbers, R.color.thumb_numbers, R.string.type_numbers),
    UNKONW(R.drawable.fitype_icon_other, R.color.thumb_unknow, R.string.feed_type_file),
    FOLDER(R.drawable.icon_list_folder, R.color.thumb_unknow, R.string.type_folder);
    
    public static final Pattern APK_PATTERN = null;
    public static final Pattern APP_PATTERN = null;
    public static final Pattern BT_PATTERN = null;
    public static final Pattern CAD_PATTERN = null;
    public static final Pattern DOC_OTHER = null;
    public static final String[] DOC_OTHER_SUFFIX = null;
    public static final Pattern DOC_PATTERN = null;
    public static final String[] DOC_SUFFIX = null;
    public static final Pattern EPUB_PATTERN = null;
    public static final Pattern EXCEL_PATTERN = null;
    public static final String[] EXCEL_SUFFIX = null;
    public static final Pattern EXE_PATTERN = null;
    public static final Pattern F7Z_PATTERN = null;
    public static final Pattern FORBID_PREVIEW_PATTERN = null;
    public static final Pattern GIF_PATTERN = null;
    public static final String GIF_PATTERN_SUFFIX = ".gif";
    public static final Pattern HTML_PATTERN = null;
    public static final Pattern IMAGE_JPEG_PATTERN = null;
    public static final Pattern IMAGE_JPG_PATTERN = null;
    public static final Pattern IMAGE_LIVP_PATTERN = null;
    public static final String IMAGE_LIVP_SUFFIX = ".livp";
    public static final Pattern IMAGE_PATTERN = null;
    public static final Pattern IMAGE_PNG_PATTERN = null;
    public static final Pattern KEYNOTE_PATTERN = null;
    public static final Pattern MARKDOWN_PATTERN = null;
    public static final Pattern MINI_DOC_PATTERN = null;
    public static final Pattern MUSIC_PATTERN = null;
    public static final Pattern MUSIC_PLAY_PATTERN = null;
    public static final String[] MUSIC_SUFFIX = null;
    public static final Pattern NOVEL_PATTERN = null;
    public static final Pattern NUMBERS_PATTERN = null;
    public static final Pattern PAGES_PATTERN = null;
    public static final Pattern PAN_WORD_PATTERN = null;
    public static final Pattern PDF_PATTERN = null;
    public static final String[] PDF_SUFFIX = null;
    public static final Pattern PPT_PATTERN = null;
    public static final String[] PPT_SUFFIX = null;
    public static final Pattern PROGRAMMING_PATTERN = null;
    public static final Pattern PSD_PATTERN = null;
    public static final Pattern TXT_PATTERN = null;
    public static final String[] TXT_SUFFIX = null;
    public static final Pattern VCF_PATTERN = null;
    public static final Pattern VIDEO_PATTERN = null;
    public static final String[] VIDEO_SUFFIX = null;
    public static final Pattern VSD_PATTERN = null;
    public static final Pattern WORD_PATTERN = null;
    public static final String[] WORD_SUFFIX = null;
    public static final Pattern ZIP_OR_RAR_PATTERN = null;
    public static final Pattern ZIP_PATTERN = null;
    public int mResourceIdList;
    public int mResourceIdSmall;
    public int mResourceIdString;
    public int mResourceIdThumb;
    public int mResourceIdThumbColor;

    /* access modifiers changed from: public */
    static {
        FORBID_PREVIEW_PATTERN = Pattern.compile("\\.(?i)(swf)$");
        VIDEO_PATTERN = Pattern.compile("\\.(?i)(flv|mpeg4|mpeg2|3gp|rm|mov|rmvb|mkv|wmv|avi|f4v|mp4|m3u8|m3u|asf|3g2|mj2|mpeg|ts|m4v|webm|dat|divx|wmx|wm|mpg|mpga|qt|wmz|wmd|wvx|mts|m2ts|vob)$");
        MUSIC_PATTERN = Pattern.compile("\\.(?i)(aac|mp3|flac|wma|wav|mid|amr|asx|ra|aac\\+|eaac\\+|midi|mp2|ogg|aif|mpega|ra|m4a)$");
        MUSIC_PLAY_PATTERN = Pattern.compile("\\.(?i)(aac|mp3|flac|wma|wav|amr|asx|ra|aac\\+|eaac\\+|mp2|ogg|aif|mpega|m4a|3gpp|ac3|ape|m2a|ram)$");
        MUSIC_SUFFIX = new String[]{"aac", "mp3", "wav", "wma", "amr", "asx", "aac+", "eaac+", "mp2", "ogg", "aif", "mpega", "m4a", "3gpp", "ac3", "ape", "m2a", "ram", "flac"};
        VIDEO_SUFFIX = new String[]{"flv", "mpeg4", "mpeg2", "3gp", "rm", "mov", "rmvb", "mkv", "wmv", "avi", "f4v", "mp4", "m3u8", "webm", "dat", "divx", "wmx", "wm", "mpg", "mpga", "qt", "wmz", "wmd", "wvx", "m3u", "asf", "3g2", "mj2", "mpeg", "ts", "m4v", "mts", "m2ts", "vob"};
        WORD_SUFFIX = new String[]{DocumentOpenUtil.DOC, DocumentOpenUtil.DOCX, "dot", "dotx", "rtf", "ots", "odm", "odt", NotificationCompat.WearableExtender.KEY_PAGES, "pand"};
        EXCEL_SUFFIX = new String[]{DocumentOpenUtil.XLS, DocumentOpenUtil.XLSX, "xlt", "xltx", "ots", "ods", "csv", "numbers"};
        PPT_SUFFIX = new String[]{DocumentOpenUtil.PPT, DocumentOpenUtil.PPTX, "potx", "pps", "ppsx", "pot", "key"};
        PDF_SUFFIX = new String[]{"pdf"};
        TXT_SUFFIX = new String[]{DocumentOpenUtil.TXT};
        DOC_OTHER_SUFFIX = new String[]{"epub", "ods", "xhtml", "ots", "odm", "odt", "html", "umd", "chm"};
        DOC_SUFFIX = new String[]{DocumentOpenUtil.DOC, DocumentOpenUtil.DOCX, DocumentOpenUtil.XLS, DocumentOpenUtil.XLSX, DocumentOpenUtil.PPT, DocumentOpenUtil.PPTX, "xlt", "xltx", "pdf", "dot", "dotx", DocumentOpenUtil.TXT, "epub", "ods", "xhtml", "rtf", "ots", "odm", "odt", "html", "umd", "chm", NotificationCompat.WearableExtender.KEY_PAGES, "numbers", "potx", "pps", "ppsx", "pot", "key", "pand"};
        ZIP_PATTERN = Pattern.compile("\\.(?i)(zip|rar|7z|gz|tgz|tar)$");
        ZIP_OR_RAR_PATTERN = Pattern.compile("\\.(?i)(zip|rar|7z)$");
        F7Z_PATTERN = Pattern.compile("\\.(?i)(7z)$");
        DOC_PATTERN = Pattern.compile("\\.(?i)(doc|docx|xls|xlsx|ppt|pptx|xlt|xltx|pdf|dot|dotx|txt|epub|ods|xhtml|rtf|ots|odm|odt|html|umd|chm|pages|numbers|potx|pps|ppsx|pot|key)$");
        MINI_DOC_PATTERN = Pattern.compile("\\.(?i)(doc|docx|pdf)$");
        WORD_PATTERN = Pattern.compile("\\.(?i)(doc|docx|dot|dotx|rtf|ots|odm|odt|pages)$");
        EXCEL_PATTERN = Pattern.compile("\\.(?i)(xls|xlsx|xlt|xltx|ots|ods|csv|numbers)$");
        PPT_PATTERN = Pattern.compile("\\.(?i)(ppt|pptx|potx|pps|ppsx|pot|key)$");
        HTML_PATTERN = Pattern.compile("\\.(?i)(html|htm|xhtml|mht)$");
        PDF_PATTERN = Pattern.compile("\\.(?i)(pdf)$");
        TXT_PATTERN = Pattern.compile("\\.(?i)(txt)$");
        DOC_OTHER = Pattern.compile("\\.(?i)(epub|ods|xhtml|rtf|ots|odm|odt|html|umd|chm)$");
        EPUB_PATTERN = Pattern.compile("\\.(?i)(epub)$");
        VCF_PATTERN = Pattern.compile("\\.(?i)(vcf)$");
        VSD_PATTERN = Pattern.compile("\\.(?i)(vsd)$");
        BT_PATTERN = Pattern.compile("\\.(?i)(torrent)$");
        APK_PATTERN = Pattern.compile("\\.(?i)(apk)$");
        APP_PATTERN = Pattern.compile("\\.(?i)(apk|exe|msi)$");
        IMAGE_PATTERN = Pattern.compile("\\.(?i)(png|jpeg|jpg|gif|bmp|cur|svg|svgz|tif|tiff|ico|jpe|webp|heic|heif|avci|livp)$");
        GIF_PATTERN = Pattern.compile("\\.(?i)(gif)$");
        IMAGE_LIVP_PATTERN = Pattern.compile("\\.(?i)(livp)$");
        IMAGE_PNG_PATTERN = Pattern.compile("\\.(?i)(png)$");
        IMAGE_JPG_PATTERN = Pattern.compile("\\.(?i)(jpg)$");
        IMAGE_JPEG_PATTERN = Pattern.compile("\\.(?i)(jpeg)$");
        NOVEL_PATTERN = Pattern.compile("\\.(?i)(txt|epub)$");
        PAN_WORD_PATTERN = Pattern.compile("\\.(?i)(PanD)$");
        EXE_PATTERN = Pattern.compile("\\.(?i)(exe)$");
        CAD_PATTERN = Pattern.compile("\\.(?i)(dwg)$");
        PSD_PATTERN = Pattern.compile("\\.(?i)(psd)$");
        KEYNOTE_PATTERN = Pattern.compile("\\.(?i)(keynote|key)$");
        PAGES_PATTERN = Pattern.compile("\\.(?i)(pages)$");
        NUMBERS_PATTERN = Pattern.compile("\\.(?i)(numbers)$");
        MARKDOWN_PATTERN = Pattern.compile("\\.(?i)(md)$");
        PROGRAMMING_PATTERN = Pattern.compile("\\.(?i)(as|sh|c|cpp|h|cs|asp|css|pas|diff|patch|erl|groovy|java|jsp|js|json|pl|php|py|rb|sass|scss|scala|sql|vb|xml|xhtml|html|less|lua|go|bat|wml|cc|ejs|vue|jsx|yml)$");
    }

    /* access modifiers changed from: public */
    FileType(int i2, int i3, int i4) {
        this.mResourceIdList = i2;
        this.mResourceIdThumbColor = i3;
        this.mResourceIdString = i4;
    }

    public static String getFileSelection(String str, String[] strArr) {
        StringBuilder sb = new StringBuilder();
        if (strArr != null) {
            for (int i2 = 0; i2 < strArr.length; i2++) {
                if (i2 < strArr.length - 1) {
                    sb.append(str + " LIKE '%." + strArr[i2] + "' OR ");
                } else {
                    sb.append(str + " LIKE '%." + strArr[i2] + "'");
                }
            }
        }
        return sb.toString();
    }

    public static int getListDrawableId(String str) {
        return getType(str, false).mResourceIdList;
    }

    public static FileType getType(String str, boolean z) {
        if (z) {
            return FOLDER;
        }
        if (isImage(str)) {
            return IMAGE;
        }
        if (isMusic(str)) {
            return MUSIC;
        }
        if (isVideo(str)) {
            return VIDEO;
        }
        if (isZipFile(str)) {
            return ZIP;
        }
        if (isWhat(str, WORD_PATTERN)) {
            return DOC;
        }
        if (isWhat(str, EXCEL_PATTERN)) {
            return EXCEL;
        }
        if (isWhat(str, PPT_PATTERN)) {
            return PPT;
        }
        if (isWhat(str, HTML_PATTERN)) {
            return HTML;
        }
        if (isWhat(str, PDF_PATTERN)) {
            return PDF;
        }
        if (isWhat(str, TXT_PATTERN)) {
            return TXT;
        }
        if (isWhat(str, VCF_PATTERN)) {
            return VCF;
        }
        if (isWhat(str, VSD_PATTERN)) {
            return VSD;
        }
        if (isWhat(str, BT_PATTERN)) {
            return BT;
        }
        if (isWhat(str, APK_PATTERN)) {
            return APK;
        }
        if (isWhat(str, EPUB_PATTERN)) {
            return EPUB;
        }
        if (isWhat(str, DOC_PATTERN)) {
            return DOC;
        }
        if (isWhat(str, PAN_WORD_PATTERN)) {
            return PAND;
        }
        if (isWhat(str, EXE_PATTERN)) {
            return EXE;
        }
        if (isWhat(str, CAD_PATTERN)) {
            return CAD;
        }
        if (isWhat(str, PSD_PATTERN)) {
            return PSD;
        }
        if (isWhat(str, KEYNOTE_PATTERN)) {
            return KEYNOTE;
        }
        if (isWhat(str, PAGES_PATTERN)) {
            return PAGES;
        }
        if (isWhat(str, NUMBERS_PATTERN)) {
            return NUMBERS;
        }
        return UNKONW;
    }

    public static boolean is7zFile(String str) {
        return isWhat(str, F7Z_PATTERN);
    }

    public static boolean isApk(String str) {
        return isWhat(str, APK_PATTERN);
    }

    public static boolean isApp(String str) {
        return isWhat(str, APP_PATTERN);
    }

    public static boolean isBT(String str) {
        return !TextUtils.isEmpty(str) && BT_PATTERN.matcher(str).find();
    }

    public static boolean isCanPlayMusic(String str) {
        return isWhat(str, MUSIC_PLAY_PATTERN);
    }

    public static boolean isDoc(String str) {
        return isWhat(str, MINI_DOC_PATTERN);
    }

    public static boolean isDwgFile(String str) {
        return isWhat(str, CAD_PATTERN);
    }

    public static boolean isEpub(String str) {
        return isWhat(str, EPUB_PATTERN);
    }

    public static boolean isExcel(String str) {
        return isWhat(str, EXCEL_PATTERN);
    }

    public static boolean isForbidPreview(String str) {
        return isWhat(str, FORBID_PREVIEW_PATTERN);
    }

    public static boolean isGif(String str) {
        return isWhat(str, GIF_PATTERN);
    }

    public static boolean isGraphFile(String str) {
        return isWhat(str, CAD_PATTERN) || isWhat(str, PSD_PATTERN);
    }

    public static boolean isHtml(String str) {
        return isWhat(str, HTML_PATTERN);
    }

    public static boolean isImage(String str) {
        return isWhat(str, IMAGE_PATTERN);
    }

    public static boolean isImageOrVideo(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (isImage(str) || isVideo(str)) {
            return true;
        }
        return false;
    }

    public static boolean isJPEG(String str) {
        return isWhat(str, IMAGE_JPEG_PATTERN);
    }

    public static boolean isJPG(String str) {
        return isWhat(str, IMAGE_JPG_PATTERN);
    }

    public static boolean isLivp(String str) {
        return isWhat(str, IMAGE_LIVP_PATTERN);
    }

    public static boolean isMarkdown(String str) {
        return isWhat(str, MARKDOWN_PATTERN);
    }

    public static boolean isMiniDoc(String str) {
        return isWhat(str, MINI_DOC_PATTERN);
    }

    public static boolean isMusic(String str) {
        return isWhat(str, MUSIC_PATTERN);
    }

    public static boolean isNovel(String str) {
        return isWhat(str, NOVEL_PATTERN);
    }

    public static boolean isOtherDoc(String str) {
        return isWhat(str, DOC_OTHER);
    }

    public static boolean isPDF(String str) {
        return isWhat(str, PDF_PATTERN);
    }

    public static boolean isPNG(String str) {
        return isWhat(str, IMAGE_PNG_PATTERN);
    }

    public static boolean isPand(String str) {
        return isWhat(str, PAN_WORD_PATTERN);
    }

    public static boolean isPdf(String str) {
        return isWhat(str, PDF_PATTERN);
    }

    public static boolean isPpt(String str) {
        return isWhat(str, PPT_PATTERN);
    }

    public static boolean isProgramming(String str) {
        return isWhat(str, PROGRAMMING_PATTERN);
    }

    public static boolean isPsdFile(String str) {
        return isWhat(str, PSD_PATTERN);
    }

    public static boolean isSimpleGif(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.endsWith(GIF_PATTERN_SUFFIX);
        }
        return false;
    }

    public static boolean isSimpleLivp(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.endsWith(IMAGE_LIVP_SUFFIX);
        }
        return false;
    }

    public static boolean isTxt(String str) {
        return isWhat(str, TXT_PATTERN);
    }

    public static boolean isVcf(String str) {
        return isWhat(str, VCF_PATTERN);
    }

    public static boolean isVideo(String str) {
        return isWhat(str, VIDEO_PATTERN);
    }

    public static boolean isVsd(String str) {
        return isWhat(str, VSD_PATTERN);
    }

    public static boolean isWhat(String str, Pattern pattern) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return pattern.matcher(str).find();
    }

    public static boolean isWord(String str) {
        return isWhat(str, WORD_PATTERN);
    }

    public static boolean isZipFile(String str) {
        return isWhat(str, ZIP_PATTERN);
    }

    public static boolean isZipOrRarFile(String str) {
        return isWhat(str, ZIP_OR_RAR_PATTERN);
    }

    public boolean isMedia() {
        return this == VIDEO || this == MUSIC || this == IMAGE;
    }

    public static int getListDrawableId(String str, boolean z) {
        return getType(str, z).mResourceIdList;
    }

    public boolean isImage() {
        return this == IMAGE;
    }

    public boolean isPand() {
        return this == PAND;
    }

    public boolean isVideo() {
        return this == VIDEO;
    }
}
