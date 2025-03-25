//
// Created by zhangyelei on 2025/3/25.
//
#include <android/bitmap.h>
#include <opencv2/opencv.hpp>

using namespace cv;

#ifndef DEMOOPENGL_OPENCVUTIL_H
#define DEMOOPENGL_OPENCVUTIL_H

cv::Mat addRoundedCorners(cv::Mat &src, int cornerRadius, int shadowSize) {
    // 获取图像的宽高
    int h = src.rows;
    int w = src.cols;

    // 创建带Alpha通道的透明遮罩
    Mat mask(src.size(), CV_8UC4, Scalar(0, 0, 0, 0));  // 黑色透明图像

    // 在四个角处绘制圆形遮罩
    // 左上角圆角
    ellipse(mask, Point(cornerRadius, cornerRadius), Size(cornerRadius, cornerRadius), 0, 180, 270, Scalar(255, 255, 255, 255), -1);
    // 右上角圆角
    ellipse(mask, Point(w - cornerRadius, cornerRadius), Size(cornerRadius, cornerRadius), 0, 270, 360, Scalar(255, 255, 255, 255), -1);
    // 左下角圆角
    ellipse(mask, Point(cornerRadius, h - cornerRadius), Size(cornerRadius, cornerRadius), 0, 90, 180, Scalar(255, 255, 255, 255), -1);
    // 右下角圆角
    ellipse(mask, Point(w - cornerRadius, h - cornerRadius), Size(cornerRadius, cornerRadius), 0, 0, 90, Scalar(255, 255, 255, 255), -1);

    // 通过矩形去除圆角之间的区域
    rectangle(mask, Point(cornerRadius, 0), Point(w - cornerRadius, h), Scalar(255, 255, 255, 255), -1);
    rectangle(mask, Point(0, cornerRadius), Point(w, h - cornerRadius), Scalar(255, 255, 255, 255), -1);

    // 将源图像转换为 BGRA 类型以便处理Alpha通道
    Mat result;
    cvtColor(src, result, COLOR_BGR2BGRA);

    // 使用遮罩的 Alpha 通道合成图像
    Mat result_with_mask;
    bitwise_and(result, mask, result_with_mask);
    return result_with_mask;
}

#endif //DEMOOPENGL_OPENCVUTIL_H
