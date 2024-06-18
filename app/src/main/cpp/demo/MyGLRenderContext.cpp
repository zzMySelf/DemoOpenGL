//
// Created by zhangyelei on 2024/1/25.
//

#include "MyGLRenderContext.h"
#include "util/Logger.h"
#include "util/ImageDef.h"

MyGLRenderContext* MyGLRenderContext::m_pContext = nullptr;

MyGLRenderContext::MyGLRenderContext() {
}

MyGLRenderContext::~MyGLRenderContext() {
    if (m_Sample) {
        m_Sample->destroy();
        m_Sample = nullptr;
    }
}

void MyGLRenderContext::setRenderType(int paramType) {
    if (paramType == SAMPLE_TYPE_KEY_TRIANGLE) {
        m_Sample = new TriangleSample();
    } else if (paramType == SAMPLE_TYPE_KEY_TEXTURE_MAP) {
        m_Sample = new TextureMapSample();
    }else if (paramType == SAMPLE_TYPE_KEY_TEXTURE) {
        m_Sample = new TextureSample();
    }
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

void MyGLRenderContext::setImageData(int format0, int width0, int height0, uint8_t *pData0,
                                     int format1, int width1, int height1, uint8_t *pData1) {
    NativeImage nativeImage0;
    if (pData0 != nullptr) {
        nativeImage0.format = format0;
        nativeImage0.width = width0;
        nativeImage0.height = height0;
        nativeImage0.ppPlane[0] = pData0;

        switch (format0) {
            case IMAGE_FORMAT_NV12:
            case IMAGE_FORMAT_NV21:
                nativeImage0.ppPlane[1] = nativeImage0.ppPlane[0] + width0 + height0;
                break;
            case IMAGE_FORMAT_I420:
                nativeImage0.ppPlane[1] = nativeImage0.ppPlane[0] + width0 + height0;
                nativeImage0.ppPlane[2] = nativeImage0.ppPlane[0] + (width0 * height0 / 4);
                break;
            default:
                break;

        }
    }
    NativeImage nativeImage1;
    if (pData1 != nullptr) {
        nativeImage1.format = format1;
        nativeImage1.width = width1;
        nativeImage1.height = height1;
        nativeImage1.ppPlane[0] = pData1;

        switch (format1) {
            case IMAGE_FORMAT_NV12:
            case IMAGE_FORMAT_NV21:
                nativeImage1.ppPlane[1] = nativeImage1.ppPlane[0] + width1 + height1;
                break;
            case IMAGE_FORMAT_I420:
                nativeImage1.ppPlane[1] = nativeImage1.ppPlane[0] + width1 + height1;
                nativeImage1.ppPlane[2] = nativeImage1.ppPlane[0] + (width1 * height1 / 4);
                break;
            default:
                break;

        }
    }

    if (nativeImage1.isValid()) {
        if (m_Sample) {
            m_Sample->loadImage(&nativeImage0, &nativeImage1);
        }
    } else {
        if (m_Sample) {
            m_Sample->loadImage(&nativeImage0);
        }
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
    if (m_Sample != nullptr) {
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

