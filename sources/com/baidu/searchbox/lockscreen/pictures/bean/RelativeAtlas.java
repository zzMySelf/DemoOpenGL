package com.baidu.searchbox.lockscreen.pictures.bean;

import com.baidu.searchbox.lockscreen.pictures.model.AtlasItemPhotoRelative;
import java.util.List;

public class RelativeAtlas implements IAtlas {
    public List<AtlasItemPhotoRelative> mItemList;

    public RelativeAtlas(List<AtlasItemPhotoRelative> list) {
        this.mItemList = list;
    }
}
