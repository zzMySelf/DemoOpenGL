//
// Created by zhangyelei on 2024/1/25.
//

#ifndef DEMOOPENGL_MYGLRENDERCONTEXT_H
#define DEMOOPENGL_MYGLRENDERCONTEXT_H

#include <cstdint>
#include <GLES3/gl3.h>
#include "sample/TriangleSample.h"
#include "sample/TextureMapSample.h"

class MyGLRenderContext {
public:

    static MyGLRenderContext* getInstance();

    static MyGLRenderContext* destroyInstance();

    ~MyGLRenderContext();

    void setImageData(int format, int width, int height, uint8_t *pData);

    void onSurfaceCreated();

    void onSurfaceChanged(int width, int height);

    void onDrawFrame();

    void setRenderType(int paramType);

private:

    MyGLRenderContext();

    static MyGLRenderContext* m_pContext;

    GLSampleBase* m_Sample = nullptr;
    int m_ScreenW = 0;
    int m_ScreenH = 0;
};


#endif //DEMOOPENGL_MYGLRENDERCONTEXT_H
