//
// Created by zhangyelei on 2024/6/14.
//

#ifndef DEMOOPENGL_TEXTURESAMPLE_H
#define DEMOOPENGL_TEXTURESAMPLE_H

#include <GLES3/gl3.h>
#include "util/ImageDef.h"
#include "util/GLUtils.h"
#include "util/Logger.h"
#include "GLSampleBase.h"
#include "Shader.h"

class TextureSample : public GLSampleBase{
public:
    TextureSample();

    ~TextureSample();

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


#endif //DEMOOPENGL_TEXTURESAMPLE_H
