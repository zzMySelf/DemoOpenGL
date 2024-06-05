//
// Created by zhangyelei on 2024/1/26.
//

#ifndef DEMOOPENGL_TRIANGLESAMPLE_H
#define DEMOOPENGL_TRIANGLESAMPLE_H

#include "util/GLUtils.h"
#include "GLSampleBase.h"


class TriangleSample : public GLSampleBase{
public:
    TriangleSample();

    ~TriangleSample();

    virtual void init();

    virtual void draw(int screenW, int screenH);

    virtual void destroy();

    float colorValueAtTime();

private:
    unsigned int VAO0;
    unsigned int VAO1;
    unsigned int VAO2;
    unsigned int vbo0;
    unsigned int vbo1;
    unsigned int vbo2;

    float colorValue = 0.25f;
};


#endif //DEMOOPENGL_TRIANGLESAMPLE_H
