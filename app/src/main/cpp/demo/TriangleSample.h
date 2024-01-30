//
// Created by zhangyelei on 2024/1/26.
//

#ifndef DEMOOPENGL_TRIANGLESAMPLE_H
#define DEMOOPENGL_TRIANGLESAMPLE_H

#include "util/GLUtils.h"


class TriangleSample {
public:
    TriangleSample();

    ~TriangleSample();

    void init();

    void draw();

private:
    GLuint m_VertexShader;
    GLuint m_FragmentShader;
    GLuint m_ProgramObj;
};


#endif //DEMOOPENGL_TRIANGLESAMPLE_H
