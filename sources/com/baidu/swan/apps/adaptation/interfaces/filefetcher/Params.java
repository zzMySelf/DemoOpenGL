package com.baidu.swan.apps.adaptation.interfaces.filefetcher;

import android.os.Bundle;
import com.baidu.swan.apps.launch.model.property.Properties;
import java.util.HashMap;
import java.util.Map;

public final class Params extends Properties<Params> {

    public interface Keys {
        public static final String FILE_CANCEL_TAG = Properties.joinPrefix(_PREFIX, "file_cancel_tag");
        public static final String FILE_HEAD_MAP = Properties.joinPrefix(_PREFIX, "file_head_map");
        public static final String FILE_SAVE_PATH = Properties.joinPrefix(_PREFIX, "file_save_path");
        public static final String FILE_SUFFIX = Properties.joinPrefix(_PREFIX, "file_suffix");
        public static final String FILE_URL = Properties.joinPrefix(_PREFIX, "file_url");
        public static final String IMAGE_SAVE_GALLERY = Properties.joinPrefix(_PREFIX, "image_save_gallery");
        public static final String _PREFIX = "SwanFileFetcher.Params";
    }

    public Params self() {
        return this;
    }

    public Params fileUrl(String fileUrl) {
        return (Params) putString(Keys.FILE_URL, fileUrl);
    }

    public String fileUrl() {
        return getString(Keys.FILE_URL);
    }

    public boolean containsFileUrl() {
        return containsKey(Keys.FILE_URL);
    }

    public Params fileSavePath(String fileSavePath) {
        return (Params) putString(Keys.FILE_SAVE_PATH, fileSavePath);
    }

    public String fileSavePath() {
        return getString(Keys.FILE_SAVE_PATH);
    }

    public Params fileSuffix(String fileSuffix) {
        return (Params) putString(Keys.FILE_SUFFIX, fileSuffix);
    }

    public String fileSuffix() {
        return getString(Keys.FILE_SUFFIX);
    }

    public boolean containsFileSavePath() {
        return containsKey(Keys.FILE_SAVE_PATH);
    }

    public Params fileDownloadHeadMap(Map<String, String> headMap) {
        Bundle bundle = new Bundle();
        if (headMap != null && !headMap.isEmpty()) {
            for (Map.Entry<String, String> entry : headMap.entrySet()) {
                bundle.putString(entry.getKey(), entry.getValue());
            }
        }
        return (Params) putBundle(Keys.FILE_HEAD_MAP, bundle);
    }

    public HashMap<String, String> fileDownloadHeadMap() {
        Bundle bundle = getBundle(Keys.FILE_HEAD_MAP);
        HashMap<String, String> map = new HashMap<>();
        if (bundle != null && !bundle.isEmpty()) {
            for (String key : bundle.keySet()) {
                map.put(key, bundle.getString(key));
            }
        }
        return map;
    }

    public boolean containsFileHeadMap() {
        return containsKey(Keys.FILE_HEAD_MAP);
    }

    public Params imageSaveGallery(boolean isSaveGallery) {
        return (Params) putBoolean(Keys.IMAGE_SAVE_GALLERY, isSaveGallery);
    }

    public Boolean imageSaveGallery() {
        return Boolean.valueOf(getBoolean(Keys.IMAGE_SAVE_GALLERY));
    }

    public boolean containsImageSaveGallery() {
        return containsKey(Keys.IMAGE_SAVE_GALLERY);
    }

    public Params cancelTag(String cancleTag) {
        return (Params) putString(Keys.FILE_CANCEL_TAG, cancleTag);
    }

    public String cancelTag() {
        return getString(Keys.FILE_CANCEL_TAG);
    }

    public boolean containsCancelTag() {
        return containsKey(Keys.FILE_CANCEL_TAG);
    }
}
