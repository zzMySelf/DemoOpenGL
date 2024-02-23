//
// Created by zhangyelei on 2024/2/23.
//

#ifndef DEMOOPENGL_TEXTUREMAPSAMPLE_H
#define DEMOOPENGL_TEXTUREMAPSAMPLE_H


#include <GLES3/gl3.h>
#include "util/ImageDef.h"
#include "util/GLUtils.h"
#include "util/Logger.h"

class TextureMapSample {
public:
    TextureMapSample();

    ~TextureMapSample();

    void loadImage(NativeImage *pImage);

    void init();

    void draw(int screenW, int screenH);

    void destory();

private:
    GLuint m_TextureId;
    GLuint m_SamplerLoc;
    NativeImage m_RenderImage;

    GLuint m_VertexShader;
    GLuint m_FragmentShader;
    GLuint m_ProgramObj;
};


#endif //DEMOOPENGL_TEXTUREMAPSAMPLE_H
