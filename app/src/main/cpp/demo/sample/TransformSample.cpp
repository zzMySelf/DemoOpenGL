//
// Created by zhangyelei on 2024/6/19.
//

#include "TransformSample.h"
#include "gtc/type_ptr.hpp"

float vertices3[] = {
        //     ---- 位置 ----       ---- 颜色 ----     - 纹理坐标 -
        0.5f, 0.5f, 0.0f,       1.0f, 1.0f,   // 右上
        0.5f, -0.5f, 0.0f,      1.0f, 0.0f,   // 右下
        -0.5f, -0.5f, 0.0f,      0.0f, 0.0f,   // 左下
        -0.5f, 0.5f, 0.0f,   0.0f, 1.0f    // 左上
};

unsigned int indices3[] = {
        0, 1, 3, // first triangle
        1, 2, 3  // second triangle
};

TransformSample::TransformSample() {

}

TransformSample::~TransformSample() {

}

void TransformSample::loadImage(NativeImage *pImage0, NativeImage *pImage1) {
    GLSampleBase::loadImage(pImage0, pImage1);
    if (pImage0) {
        renderImage0.width = pImage0->width;
        renderImage0.height = pImage0->height;
        renderImage0.format = pImage0->format;
        NativeImageUtil::CopyNativeImage(pImage0, &renderImage0);
    }
    if (pImage1) {
        renderImage1.width = pImage1->width;
        renderImage1.height = pImage1->height;
        renderImage1.format = pImage1->format;
        NativeImageUtil::CopyNativeImage(pImage1, &renderImage1);
    }
}

void TransformSample::init() {
    shader = new Shader(APP_FILE_PATH"V_TransformSample.glsl", APP_FILE_PATH"F_TransformSample.glsl");

    glGenVertexArrays(1, &VAO);
    glGenBuffers(1, &VBO);
    glGenBuffers(1, &EBO);

    glBindVertexArray(VAO);

    glBindBuffer(GL_ARRAY_BUFFER, VBO);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices3), vertices3, GL_STATIC_DRAW);

    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices3), indices3, GL_STATIC_DRAW);

    // 顶点
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 5 * sizeof(float), nullptr);
    glEnableVertexAttribArray(0);
    // 纹理坐标
    glVertexAttribPointer(1, 2, GL_FLOAT, GL_FALSE, 5 * sizeof(float), (void *) (3 * sizeof(float)));
    glEnableVertexAttribArray(1);

    glGenTextures(1, &textureId);
    glBindTexture(GL_TEXTURE_2D, textureId);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexImage2D(GL_TEXTURE_2D,
                 0,
                 GL_RGBA,
                 renderImage0.width,
                 renderImage0.height,
                 0,
                 GL_RGBA,
                 GL_UNSIGNED_BYTE,
                 renderImage0.ppPlane[0]);

    glGenTextures(1, &textureId1);
    glBindTexture(GL_TEXTURE_2D, textureId1);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexImage2D(GL_TEXTURE_2D,
                 0,
                 GL_RGBA,
                 renderImage1.width,
                 renderImage1.height,
                 0,
                 GL_RGBA,
                 GL_UNSIGNED_BYTE,
                 renderImage1.ppPlane[0]);
//    glGenerateMipmap(GL_TEXTURE_2D);

    shader->use();
    shader->setInt("texture0", 0);
    shader->setInt("texture1", 1);
    shader->setFloat("mixValue", 0.8f);

    glm::mat4 trans;
    trans = glm::translate(trans, glm::vec3(0.5f, -0.5f, 0.0f));
    trans = glm::rotate(trans, glm::radians(45.0f), glm::vec3(0.0, 0.0, 1.0));
    trans = glm::scale(trans, glm::vec3(0.5, 0.5, 0.5));

    GLint transformLoc = glGetUniformLocation(shader->getProgramId(), "transform");
    glUniformMatrix4fv(transformLoc, 1, GL_FALSE, glm::value_ptr(trans));
}

void TransformSample::draw(int screenW, int screenH) {
    if (!shader) {
        return;
    }
    glClearColor(0.2f, 0.3f, 0.3f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT);

    shader->use();
    glActiveTexture(GL_TEXTURE0);
    glBindTexture(GL_TEXTURE_2D, textureId);

    glActiveTexture(GL_TEXTURE1);
    glBindTexture(GL_TEXTURE_2D, textureId1);

    glBindVertexArray(VAO);
    glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
}

void TransformSample::destroy() {
    glDeleteVertexArrays(1, &VAO);
    glDeleteBuffers(1, &VBO);
    glDeleteBuffers(1, &EBO);
    if (shader) {
        glDeleteProgram(shader->getProgramId());
        shader = nullptr;
    }
    NativeImageUtil::FreeNativeImage(&renderImage0);
    NativeImageUtil::FreeNativeImage(&renderImage1);
}

