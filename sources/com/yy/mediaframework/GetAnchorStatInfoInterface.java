package com.yy.mediaframework;

public class GetAnchorStatInfoInterface {

    public interface IGetImageFilterInfo {
        float onGetBeautyLevel();

        float onGetFaceLiftLevel();

        boolean onGetHasBeauty();

        boolean onGetHasDynamicSticker();

        boolean onGetHasFaceLift();

        boolean onGetHasSticker();
    }
}
