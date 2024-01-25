//
// Created by zhangyelei on 2024/1/25.
//

#ifndef DEMOOPENGL_MYGLRENDERCONTEXT_H
#define DEMOOPENGL_MYGLRENDERCONTEXT_H


class MyGLRenderContext {
public:

    MyGLRenderContext();

    ~MyGLRenderContext();

    void printLog();

private:

    void setImageData(int format);

};


#endif //DEMOOPENGL_MYGLRENDERCONTEXT_H
