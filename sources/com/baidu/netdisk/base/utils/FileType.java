package com.baidu.netdisk.base.utils;

import android.text.TextUtils;
import java.util.regex.Pattern;

public enum FileType {
    IMAGE,
    VIDEO,
    MUSIC,
    DOCS,
    DOC,
    EXCEL,
    TXT,
    PPT,
    PDF,
    HTML,
    VSD,
    VCF,
    BT,
    APK,
    ZIP,
    UNKONW,
    FOLDER;
    
    private static final Pattern APK_PATTERN = null;
    private static final Pattern APP_PATTERN = null;
    private static final Pattern BT_PATTERN = null;
    private static final Pattern DOC_PATTERN = null;
    private static final Pattern EXCEL_PATTERN = null;
    private static final Pattern HTML_PATTERN = null;
    private static final Pattern IMAGE_PATTERN = null;
    private static final Pattern MUSIC_PATTERN = null;
    private static final Pattern MUSIC_PLAY_PATTERN = null;
    private static final Pattern NOVEL_PATTERN = null;
    private static final Pattern PDF_PATTERN = null;
    private static final Pattern PPT_PATTERN = null;
    private static final Pattern TXT_PATTERN = null;
    private static final Pattern VCF_PATTERN = null;
    private static final Pattern VIDEO_PATTERN = null;
    private static final Pattern VSD_PATTERN = null;
    private static final Pattern WORD_PATTERN = null;
    private static final Pattern ZIP_PATTERN = null;

    static {
        VIDEO_PATTERN = Pattern.compile("\\.(?i)(flv|mpeg4|mpeg2|3gp|rm|mov|rmvb|mkv|wmv|avi|f4v|mp4|m3u8|m3u|asf|3g2|mj2|mpeg|ts|m4v|webm|swf|dat|divx|wmx|wm|mpg|mpga|qt|wmz|wmd|wvx)$");
        MUSIC_PATTERN = Pattern.compile("\\.(?i)(aac|mp3|flac|wma|wav|mid|amr|asf|asx|ra|aac\\+|eaac\\+|midi|mp2|ogg|aif|mpega|ra|m4a)$");
        MUSIC_PLAY_PATTERN = Pattern.compile("\\.(?i)(aac|mp3|flac|wma|wav|amr|asf|asx|ra|aac\\+|eaac\\+|mp2|ogg|aif|mpega|m4a|3gpp|ac3|ape|m2a|ram)$");
        ZIP_PATTERN = Pattern.compile("\\.(?i)(zip|rar|7z|gz|tgz|tar)$");
        DOC_PATTERN = Pattern.compile("\\.(?i)(doc|docx|xls|xlsx|ppt|pptx|xlt|xltx|pdf|dot|dotx|txt|epub|ods|xhtml|rtf|ots|odm|odt|html|umd|chm|pages|numbers|potx|pps|ppsx|pot|key)$");
        WORD_PATTERN = Pattern.compile("\\.(?i)(doc|docx|dot|dotx|rtf|ots|odm|odt|pages)$");
        EXCEL_PATTERN = Pattern.compile("\\.(?i)(xls|xlsx|xlt|xltx|ots|ods|csv|numbers)$");
        PPT_PATTERN = Pattern.compile("\\.(?i)(ppt|pptx|potx|pps|ppsx|pot|key)$");
        HTML_PATTERN = Pattern.compile("\\.(?i)(html|htm|xhtml)$");
        PDF_PATTERN = Pattern.compile("\\.(?i)(pdf)$");
        TXT_PATTERN = Pattern.compile("\\.(?i)(txt)$");
        VCF_PATTERN = Pattern.compile("\\.(?i)(vcf)$");
        VSD_PATTERN = Pattern.compile("\\.(?i)(vsd)$");
        BT_PATTERN = Pattern.compile("\\.(?i)(torrent)$");
        APK_PATTERN = Pattern.compile("\\.(?i)(apk)$");
        APP_PATTERN = Pattern.compile("\\.(?i)(apk|exe|msi)$");
        IMAGE_PATTERN = Pattern.compile("\\.(?i)(png|jpeg|jpg|gif|bmp|cur|svg|svgz|tif|tiff|ico|jpe|webp|heic|heif|avci|livp)$");
        NOVEL_PATTERN = Pattern.compile("\\.(?i)(txt|epub)$");
    }

    public static boolean isWhat(String name, Pattern pattern) {
        if (TextUtils.isEmpty(name) || !pattern.matcher(name).find()) {
            return false;
        }
        return true;
    }

    public static boolean isImage(String name) {
        if (TextUtils.isEmpty(name) || !IMAGE_PATTERN.matcher(name).find()) {
            return false;
        }
        return true;
    }

    public static boolean isDoc(String name) {
        if (TextUtils.isEmpty(name) || !DOC_PATTERN.matcher(name).find()) {
            return false;
        }
        return true;
    }

    public static boolean isMusic(String name) {
        if (TextUtils.isEmpty(name) || !MUSIC_PATTERN.matcher(name).find()) {
            return false;
        }
        return true;
    }

    public static boolean isCanPlayMusic(String name) {
        if (TextUtils.isEmpty(name) || !MUSIC_PLAY_PATTERN.matcher(name).find()) {
            return false;
        }
        return true;
    }

    public static boolean isVideo(String name) {
        if (TextUtils.isEmpty(name) || !VIDEO_PATTERN.matcher(name).find()) {
            return false;
        }
        return true;
    }

    public static boolean isZipFile(String filePath) {
        if (TextUtils.isEmpty(filePath) || !ZIP_PATTERN.matcher(filePath).find()) {
            return false;
        }
        return true;
    }

    public static boolean isApp(String filePath) {
        if (TextUtils.isEmpty(filePath) || !APP_PATTERN.matcher(filePath).find()) {
            return false;
        }
        return true;
    }

    public static boolean isImageOrVideo(String name) {
        if (TextUtils.isEmpty(name)) {
            return false;
        }
        if (isImage(name) || isVideo(name)) {
            return true;
        }
        return false;
    }

    public static boolean isNovel(String name) {
        if (TextUtils.isEmpty(name) || !NOVEL_PATTERN.matcher(name).find()) {
            return false;
        }
        return true;
    }

    public boolean isVideo() {
        return this == VIDEO;
    }

    public static FileType getType(String fileName, boolean isDir) {
        if (isDir) {
            return FOLDER;
        }
        if (isImage(fileName)) {
            return IMAGE;
        }
        if (isMusic(fileName)) {
            return MUSIC;
        }
        if (isVideo(fileName)) {
            return VIDEO;
        }
        if (isZipFile(fileName)) {
            return ZIP;
        }
        if (isWhat(fileName, WORD_PATTERN)) {
            return DOC;
        }
        if (isWhat(fileName, EXCEL_PATTERN)) {
            return EXCEL;
        }
        if (isWhat(fileName, PPT_PATTERN)) {
            return PPT;
        }
        if (isWhat(fileName, HTML_PATTERN)) {
            return HTML;
        }
        if (isWhat(fileName, PDF_PATTERN)) {
            return PDF;
        }
        if (isWhat(fileName, TXT_PATTERN)) {
            return TXT;
        }
        if (isWhat(fileName, VCF_PATTERN)) {
            return VCF;
        }
        if (isWhat(fileName, VSD_PATTERN)) {
            return VSD;
        }
        if (isWhat(fileName, BT_PATTERN)) {
            return BT;
        }
        if (isWhat(fileName, APK_PATTERN)) {
            return APK;
        }
        if (isWhat(fileName, DOC_PATTERN)) {
            return DOC;
        }
        return UNKONW;
    }
}
