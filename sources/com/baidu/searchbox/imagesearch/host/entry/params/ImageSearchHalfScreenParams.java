package com.baidu.searchbox.imagesearch.host.entry.params;

import com.baidu.searchbox.qrcode.ui.model.CategoryModel;

public class ImageSearchHalfScreenParams {
    /* access modifiers changed from: private */
    public String category = CategoryModel.TYPE_GENERAL;
    /* access modifiers changed from: private */
    public String from;
    /* access modifiers changed from: private */
    public String halfResultUrl = "";
    /* access modifiers changed from: private */
    public boolean homeBackVisible = true;
    /* access modifiers changed from: private */
    public String imageUri;
    /* access modifiers changed from: private */
    public String intentCategory = "";
    /* access modifiers changed from: private */
    public String sceneCategory = "";

    public String getFrom() {
        return this.from;
    }

    public void setFrom(String from2) {
        this.from = from2;
    }

    public String getImageUri() {
        return this.imageUri;
    }

    public void setImageUri(String imageUri2) {
        this.imageUri = imageUri2;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String category2) {
        this.category = category2;
    }

    public void setIntentCategory(String intentCategory2) {
        this.intentCategory = intentCategory2;
    }

    public String getIntentCategory() {
        return this.intentCategory;
    }

    public void setSceneCategory(String sceneCategory2) {
        this.sceneCategory = sceneCategory2;
    }

    public String getSceneCategory() {
        return this.sceneCategory;
    }

    public void setHalfResultUrl(String halfResultUrl2) {
        this.halfResultUrl = halfResultUrl2;
    }

    public String getHalfResultUrl() {
        return this.halfResultUrl;
    }

    public void setHomeBackVisible(boolean homeBackVisible2) {
        this.homeBackVisible = homeBackVisible2;
    }

    public boolean getHomeBackVisible() {
        return this.homeBackVisible;
    }

    public static class Builder {
        private ImageSearchHalfScreenParams mImageSearchHalfScreenParams = new ImageSearchHalfScreenParams();

        public Builder setFrom(String from) {
            String unused = this.mImageSearchHalfScreenParams.from = from;
            return this;
        }

        public Builder setImageUri(String imageUri) {
            String unused = this.mImageSearchHalfScreenParams.imageUri = imageUri;
            return this;
        }

        public Builder setCategory(String category) {
            String unused = this.mImageSearchHalfScreenParams.category = category;
            return this;
        }

        public Builder setIntentCategory(String intentCategory) {
            String unused = this.mImageSearchHalfScreenParams.intentCategory = intentCategory;
            return this;
        }

        public Builder setSceneCategory(String sceneCategory) {
            String unused = this.mImageSearchHalfScreenParams.sceneCategory = sceneCategory;
            return this;
        }

        public Builder setHalfResultUrl(String halfResultUrl) {
            String unused = this.mImageSearchHalfScreenParams.halfResultUrl = halfResultUrl;
            return this;
        }

        public Builder setHomeBackVisible(boolean homeBackVisible) {
            boolean unused = this.mImageSearchHalfScreenParams.homeBackVisible = homeBackVisible;
            return this;
        }

        public ImageSearchHalfScreenParams build() {
            return this.mImageSearchHalfScreenParams;
        }
    }
}
