package com.baidu.searchbox.upload.provider;

import com.baidu.searchbox.ugc.upload.VideoModel;
import com.baidu.searchbox.upload.provider.listener.UploadImageListener;
import com.baidu.searchbox.upload.provider.listener.UploadVideoListener;
import java.util.List;

public interface IUploadInterface {
    public static final IUploadInterface EMPTY = new IUploadInterface() {
        public void upLoadImage(String path, UploadImageListener listener) {
        }

        public void upLoadImage(List<String> list, String authorUrl, UploadImageListener listener) {
        }

        public void upLoadImage(List<String> list, UploadImageListener listener) {
        }

        public void upLoadVideo(VideoModel videoModel, UploadVideoListener listener) {
        }

        public void stopUpload() {
        }

        public void releaseUploadManager() {
        }

        public String requestPublisherToken(List<String> list, boolean isVideo, int sourceType, String from) {
            return null;
        }

        public void setSTSFrom(String stsFrom) {
        }
    };
    public static final String FROM_COMMENT = "comment";
    public static final String FROM_UGC = "ugc";

    void releaseUploadManager();

    String requestPublisherToken(List<String> list, boolean z, int i2, String str);

    void setSTSFrom(String str);

    void stopUpload();

    void upLoadImage(String str, UploadImageListener uploadImageListener);

    void upLoadImage(List<String> list, UploadImageListener uploadImageListener);

    void upLoadImage(List<String> list, String str, UploadImageListener uploadImageListener);

    void upLoadVideo(VideoModel videoModel, UploadVideoListener uploadVideoListener);

    public static final class Impl {
        private static IUploadInterface sUgcProvider = UploadProviderManager.getUploadProvider();

        private Impl() {
        }

        public static IUploadInterface get() {
            if (sUgcProvider == null) {
                sUgcProvider = IUploadInterface.EMPTY;
            }
            return sUgcProvider;
        }
    }
}
