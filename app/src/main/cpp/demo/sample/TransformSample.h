//
// Created by zhangyelei on 2024/6/19.
//

#ifndef DEMOOPENGL_TRANSFORMSAMPLE_H
#define DEMOOPENGL_TRANSFORMSAMPLE_H


#include "util/GLUtils.h"
#include "GLSampleBase.h"
#include "Shader.h"
#include "glm/gtc/matrix_transform.hpp"

class TransformSample : public GLSampleBase{
public:

    TransformSample();

    ~TransformSample();

    virtual void loadImage(NativeImage *pImage0, NativeImage *pImage1);

    virtual void init();

    virtual void draw(int screenW, int screenH);

    virtual void destroy();

private:
    NativeImage renderImage0;
    NativeImage renderImage1;

    GLuint textureId;
    GLuint textureId1;
    GLuint programObj;
    Shader *shader = nullptr;

    unsigned int VAO;
    unsigned int VBO;
    unsigned int EBO;
};


#endif //DEMOOPENGL_TRANSFORMSAMPLE_H
