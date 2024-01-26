//
// Created by zhangyelei on 2024/1/25.
//

#include "MyGLRenderContext.h"
#include "Logger.h"

MyGLRenderContext* MyGLRenderContext::m_pContext = nullptr;

MyGLRenderContext::MyGLRenderContext() {

}

MyGLRenderContext::~MyGLRenderContext() {

}

void MyGLRenderContext::setImageData(int format, int width, int height, uint8_t *pData) {

}

void MyGLRenderContext::printLog() {

}

void MyGLRenderContext::onDrawFrame() {

}

void MyGLRenderContext::onSurfaceChanged(int width, int height) {

}

void MyGLRenderContext::onSurfaceCreated() {

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


