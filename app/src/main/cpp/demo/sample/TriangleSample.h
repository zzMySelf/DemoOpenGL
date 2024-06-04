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

    unsigned int VAO0;
    unsigned int VAO1;
    unsigned int vbo0;
    unsigned int vbo1;
};


#endif //DEMOOPENGL_TRIANGLESAMPLE_H
