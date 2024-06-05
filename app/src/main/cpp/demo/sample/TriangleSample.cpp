//
// Created by zhangyelei on 2024/1/26.
//

#include "TriangleSample.h"

/**
 * 配置顶点属性。在这里，它指定了顶点属性索引为 0（因为参数为 0），
 * 包含三个浮点数（size 参数为 3），每个浮点数占用 4 个字节（type 参数为 GL_FLOAT），
 * 不需要进行归一化处理（normalized 参数为 GL_FALSE），
 * 顶点数组中相邻两个顶点的间隔为 0（stride 参数为 0），
 * 并且使用的是顶点数组 vVertices。
 *
 *  @param index layout(location = 0)定义了position顶点属性的位置值(Location)
 *  @param size 顶点属性大小
 *  @param type 数据类型
 *  @param normalized 是否希望数据被标准化
 *  @param Stride 连续的顶点属性组之间的间隔
 *  @param pointer 位置数据在VBO中起始位置的偏移量
 */
// glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * sizeof(float), (void*)nullptr);

// 定义了三个顶点的坐标。每个顶点包含三个浮点数，分别表示 x、y、z 坐标。
GLfloat  vertices0[] = {
        0.0f,  1.0f, 0.0f,
        -0.5f, -0.5f, 0.0f,
        0.5f, -0.5f, 0.0f,
        // 第二个
        0.0f,  -1.0f, 0.0f,
        -0.5f, -0.5f, 0.0f,
        0.5f, -0.5f, 0.0f,
};
GLfloat  vertices1[] = {
        -1.0f,  1.0f, 0.0f,
        -1.0f, 0.0f, 0.0f,
        0.0f, 0.0f, 0.0f,
};

GLfloat  vertices2[] = {
        0.5f, -0.5f, 0.0f,  1.0f, 0.0f, 1.0f,  // bottom right
        -0.5f, -0.5f, 0.0f,  0.0f, 1.0f, 0.0f,  // bottom left
        0.0f,  0.5f, 0.0f,  0.0f, 0.0f, 1.0f   // top
};

TriangleSample::TriangleSample() {

}

TriangleSample::~TriangleSample() {
    if (m_ProgramObj) {
        glDeleteProgram(m_ProgramObj);
    }
}

void TriangleSample::init() {
    /**
     * 配置顶点着色器
     * 1、gl_Position 包含1-4个 float分量，可以通过vec3 vec4 区分出来
     * 2、in 代表输入变量
     */
    char vShaderStr[] =
            "#version 300 es                          \n"
            "layout(location = 0) in vec3 aPos;  \n"
            "layout(location = 1) in vec3 aColor;  \n"
            "out vec3 ourColor;  \n"
            "void main()                              \n"
            "{                                        \n"
            "   gl_Position = vec4(aPos, 1.0);              \n"
            "   ourColor = aColor;              \n"
            "}                                        \n";

    /**
     * 配置片元着色器
     *
     * RGBA：红绿蓝-alpha透明度
     * 1、out代表输出变量 表示最终的输出颜色
     */
    char fShaderStr[] =
            "#version 300 es                              \n"
            "precision mediump float;                     \n"
            "out vec4 fragColor;                          \n"
            "in vec3 ourColor;                       \n"
            "void main()                                  \n"
            "{                                            \n"
            "   fragColor = vec4(ourColor, 1.0);            \n"
            "}                                            \n";

    m_ProgramObj = GLUtils::CreateProgram(vShaderStr, fShaderStr, m_VertexShader, m_FragmentShader);


    /**
     * 创建一个VAO
     */
    glGenVertexArrays(1, &VAO2);
    glGenBuffers(1, &vbo2);
    glBindVertexArray(VAO2);

    glBindBuffer(GL_ARRAY_BUFFER, vbo2);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices2), vertices2, GL_STATIC_DRAW);

    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void*)nullptr);
    glEnableVertexAttribArray(0);
    // 颜色属性
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 6 * sizeof(float), (void*)(3* sizeof(float)));
    glEnableVertexAttribArray(1);
}

void TriangleSample::draw(int screenW, int screenH) {
    if (m_ProgramObj == 0) {
        return;
    }
    glUseProgram(m_ProgramObj);
    glDrawArrays(GL_TRIANGLES, 0, 3);
}

void TriangleSample::destroy() {
    if (m_ProgramObj) {
        glDeleteProgram(m_ProgramObj);
        m_ProgramObj = GL_NONE;
    }
}


float TriangleSample::colorValueAtTime() {
    if (colorValue > 0.85f) {
        colorValue = 0.15f;
    }
    colorValue += 0.005f;
    return colorValue;
}
