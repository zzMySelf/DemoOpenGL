//
// Created by zhangyelei on 2024/6/5.
//

#ifndef DEMOOPENGL_GLSAMPLEBASE_H
#define DEMOOPENGL_GLSAMPLEBASE_H


#include "util/ImageDef.h"
#include "util/GLUtils.h"

#define SAMPLE_TYPE                             200
#define SAMPLE_TYPE_KEY_TRIANGLE                SAMPLE_TYPE + 0
#define SAMPLE_TYPE_KEY_TEXTURE_MAP             SAMPLE_TYPE_KEY_TRIANGLE + 1
#define SAMPLE_TYPE_KEY_TEXTURE                 SAMPLE_TYPE_KEY_TEXTURE_MAP + 1

#define APP_FILE_PATH "/sdcard/Android/data/com.baidu.demoopengl/files/"

class GLSampleBase
{
public:
    GLSampleBase()
    {
        m_ProgramObj = 0;
        m_VertexShader = 0;
        m_FragmentShader = 0;

        m_SurfaceWidth = 0;
        m_SurfaceHeight = 0;

    }

    virtual ~GLSampleBase()
    {

    }

    virtual void loadImage(NativeImage *pImage)
    {};

    virtual void loadMultiImageWithIndex(int index, NativeImage *pImage)
    {};

    virtual void loadShortArrData(short *const pShortArr, int arrSize)
    {}

    virtual void updateTransformMatrix(float rotateX, float rotateY, float scaleX, float scaleY)
    {}

    virtual void setTouchLocation(float x, float y)
    {}

    virtual void setGravityXY(float x, float y)
    {}

    virtual void init() = 0;

    virtual void draw(int screenW, int screenH) = 0;

    virtual void destroy() = 0;

protected:
    GLuint m_VertexShader;
    GLuint m_FragmentShader;
    GLuint m_ProgramObj;
    int m_SurfaceWidth;
    int m_SurfaceHeight;
};


#endif //DEMOOPENGL_GLSAMPLEBASE_H
