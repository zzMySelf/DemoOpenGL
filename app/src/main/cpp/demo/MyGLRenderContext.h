//
// Created by zhangyelei on 2024/1/25.
//

#ifndef DEMOOPENGL_MYGLRENDERCONTEXT_H
#define DEMOOPENGL_MYGLRENDERCONTEXT_H

#include <cstdint>

class MyGLRenderContext {
public:

    static MyGLRenderContext* getInstance();

    static MyGLRenderContext* destroyInstance();

    ~MyGLRenderContext();

    void printLog();

    void setImageData(int format, int width, int height, uint8_t *pData);

    void onSurfaceCreated();

    void onSurfaceChanged(int width, int height);

    void onDrawFrame();

private:

    MyGLRenderContext();

    static MyGLRenderContext* m_pContext;
};


#endif //DEMOOPENGL_MYGLRENDERCONTEXT_H
