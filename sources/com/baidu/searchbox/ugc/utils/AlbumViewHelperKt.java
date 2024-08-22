package com.baidu.searchbox.ugc.utils;

import com.baidu.searchbox.ugc.model.ImageStruct;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001\u001a\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\u0001\u001a\u000e\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u000b¨\u0006\f"}, d2 = {"isMultiChoiceMax", "", "isHalfAlbum", "ubcAiCreativeEnterViewAction", "", "sourceFrom", "", "type", "isFullAlbum", "ubcPreviewDoneClk", "value", "", "lib-ugc-album_debug"}, k = 2, mv = {1, 6, 0}, xi = 48)
/* compiled from: AlbumViewHelper.kt */
public final class AlbumViewHelperKt {
    public static final void ubcAiCreativeEnterViewAction(String sourceFrom, String type, boolean isFullAlbum) {
        UgcUBCUtils.ubcUgcPublishBehavior("publish_editor", sourceFrom, type, isFullAlbum ? "1" : "2", (JSONObject) null);
    }

    public static final void ubcPreviewDoneClk(int value) {
        UgcUBCUtils.ugcPhotoPreviewFinishClkStatistics(value);
    }

    public static final boolean isMultiChoiceMax(boolean isHalfAlbum) {
        if (isHalfAlbum) {
            List maxedList = new ArrayList(SelectUtil.getCurrentAlbumSelectedImages());
            ArrayList<ImageStruct> selectedImages = SelectUtil.getSelectedImages();
            Intrinsics.checkNotNullExpressionValue(selectedImages, "getSelectedImages()");
            maxedList.retainAll(selectedImages);
            if (((SelectUtil.getSelectedCount() - maxedList.size()) + SelectUtil.getCurrentAlbumSelectedImagesCount()) - SelectUtil.getRemovedFromCurSelectedImagesCount() >= SelectUtil.maxSelected) {
                return true;
            }
            return false;
        } else if (SelectUtil.getSelectedCount() + SelectUtil.getCurrentAlbumSelectedImagesCount() >= SelectUtil.maxSelected) {
            return true;
        } else {
            return false;
        }
    }
}
