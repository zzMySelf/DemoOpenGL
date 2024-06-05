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
            "layout(location = 0) in vec4 vPosition;  \n"
//            "out vec4 vertexColor;                    \n"
            "void main()                              \n"
            "{                                        \n"
            "   gl_Position = vPosition;              \n"
//            "   vertexColor = vec4(0.5, 0.0, 0.0, 1.0);              \n"
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
            "uniform vec4 ourColor;                       \n"
//            "in vec4 vertexColor;                         \n"
            "void main()                                  \n"
            "{                                            \n"
//            "   ourColor = vertexColor;                 \n"
            "   fragColor = ourColor;  \n"
            "}                                            \n";

    m_ProgramObj = GLUtils::CreateProgram(vShaderStr, fShaderStr, m_VertexShader, m_FragmentShader);


    /**
     * 创建一个VAO
     */
    glGenVertexArrays(1, &VAO0);
    glGenVertexArrays(1, &VAO1);

    glBindVertexArray(VAO0);
    /**
     * 创建VBO
     */
    glGenBuffers(1, &vbo0);

    // 顶点缓冲对象的缓冲类型是GL_ARRAY_BUFFER
    glBindBuffer(GL_ARRAY_BUFFER, vbo0);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices0), vertices0, GL_STATIC_DRAW);
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 3 * sizeof(float), (void*)nullptr);
    glEnableVertexAttribArray(0);

    glBindVertexArray(VAO1);
    glGenBuffers(1, &vbo1);
    glBindBuffer(GL_ARRAY_BUFFER, vbo1);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices1), vertices1, GL_STATIC_DRAW);
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, (void*)nullptr);
    glEnableVertexAttribArray(0);
}

void TriangleSample::draw(int screenW, int screenH) {
    // 如果为 0，表示没有有效的 OpenGL 着色器程序对象
    if (m_ProgramObj == 0) {
        return;
    }
    glUseProgram(m_ProgramObj);

    float value = colorValueAtTime();
    int vertexColorLocation = glGetUniformLocation(m_ProgramObj, "ourColor");
    if (vertexColorLocation != -1 ){
        glUniform4f(vertexColorLocation, 0.0f, value, 0.0f, 1.0f);
    }

    glBindVertexArray(VAO0);
    glDrawArrays(GL_TRIANGLES, 0, 6);

    glBindVertexArray(VAO1);
    glDrawArrays(GL_TRIANGLES, 0, 3);




//
//    /**
//     * 绘制第二个三角形  将不同的VBO绑定到GL_ARRAY_BUFFER目标上，并复制新的数据。
//     */
//    glBindBuffer(GL_ARRAY_BUFFER, vbo1);
//    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 0, (void*)nullptr);
//    glDrawArrays(GL_TRIANGLES, 0, 3);
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
