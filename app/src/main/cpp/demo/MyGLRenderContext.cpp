//
// Created by zhangyelei on 2024/1/25.
//

#include "MyGLRenderContext.h"
#include "util/Logger.h"
#include "util/ImageDef.h"

MyGLRenderContext* MyGLRenderContext::m_pContext = nullptr;

MyGLRenderContext::MyGLRenderContext() {
//    m_Sample = new TriangleSample();
    m_Sample = new TextureMapSample();
}

MyGLRenderContext::~MyGLRenderContext() {

}

void MyGLRenderContext::setImageData(int format, int width, int height, uint8_t *pData) {
    NativeImage nativeImage;
    nativeImage.format = format;
    nativeImage.width = width;
    nativeImage.height = height;
    nativeImage.ppPlane[0] = pData;

    switch (format) {
        case IMAGE_FORMAT_NV12:
        case IMAGE_FORMAT_NV21:
            nativeImage.ppPlane[1] = nativeImage.ppPlane[0] + width + height;
            break;
        case IMAGE_FORMAT_I420:
            nativeImage.ppPlane[1] = nativeImage.ppPlane[0] + width + height;
            nativeImage.ppPlane[2] = nativeImage.ppPlane[0] + (width * height / 4);
            break;
        default:
            break;

    }
    if (m_Sample) {
        m_Sample->loadImage(&nativeImage);
    }
}

void MyGLRenderContext::onDrawFrame() {
    glClear(GL_DEPTH_BUFFER_BIT | GL_COLOR_BUFFER_BIT);
    if (m_Sample) {
        m_Sample->draw(m_ScreenW, m_ScreenH);
    }
}

void MyGLRenderContext::onSurfaceChanged(int width, int height) {
    glViewport(0, 0, width, height);
    m_ScreenW = width;
    m_ScreenH = height;
}

void MyGLRenderContext::onSurfaceCreated() {
    glClearColor(1.0f,1.0f,1.0f, 1.0f);
    if (m_Sample) {
        m_Sample->init();
    }
}

MyGLRenderContext *MyGLRenderContext::getInstance() {
    if (m_pContext == nullptr) {
        m_pContext = new MyGLRenderContext();
    }
    return m_pContext;
}

MyGLRenderContext *MyGLRenderContext::destroyInstance() {
    if (m_pContext) {
        delete m_pContext;
        m_pContext = nullptr;
    }
}

