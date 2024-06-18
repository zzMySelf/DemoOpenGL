//
// Created by zhangyelei on 2024/6/14.
//

#include "TextureSample.h"

float vertices[] = {
        //     ---- 位置 ----       ---- 颜色 ----     - 纹理坐标 -
        0.5f, 0.5f, 0.0f,       1.0f, 0.0f, 0.0f,       1.0f, 1.0f,   // 右上
        0.5f, -0.5f, 0.0f,      0.0f, 1.0f, 0.0f,   1.0f, 0.0f,   // 右下
        -0.5f, -0.5f, 0.0f,     0.0f, 0.0f, 1.0f,       0.0f, 0.0f,   // 左下
        -0.5f, 0.5f, 0.0f,      1.0f, 1.0f, 0.0f,        0.0f, 1.0f    // 左上
};

unsigned int indices[] = {
        0, 1, 3, // first triangle
        1, 2, 3  // second triangle
};

TextureSample::TextureSample() {

}

TextureSample::~TextureSample() {

}

void TextureSample::loadImage(NativeImage *pImage) {
    Logger::d("TextureSample", "loadImage");
    if (pImage) {
        renderImage.width = pImage->width;
        renderImage.height = pImage->height;
        renderImage.format = pImage->format;
        NativeImageUtil::CopyNativeImage(pImage, &renderImage);
    }
}

void TextureSample::init() {
    Logger::d("TextureSample", "init");
    shader = new Shader(APP_FILE_PATH"V_TextureSample.glsl", APP_FILE_PATH"F_TextureSample.glsl");

    glGenVertexArrays(1, &VAO);
    glGenBuffers(1, &VBO);
    glGenBuffers(1, &EBO);

    glBindVertexArray(VAO);

    glBindBuffer(GL_ARRAY_BUFFER, VBO);
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

    glBindBuffer(GL_ELEMENT_ARRAY_BUFFER, EBO);
    glBufferData(GL_ELEMENT_ARRAY_BUFFER, sizeof(indices), indices, GL_STATIC_DRAW);

    // 顶点
    glVertexAttribPointer(0, 3, GL_FLOAT, GL_FALSE, 8* sizeof(float ), nullptr);
    glEnableVertexAttribArray(0);
    // 颜色
    glVertexAttribPointer(1, 3, GL_FLOAT, GL_FALSE, 8* sizeof(float ), (void*)(3 * sizeof(float)));
    glEnableVertexAttribArray(1);
    // 纹理坐标
    glVertexAttribPointer(2, 2, GL_FLOAT, GL_FALSE, 8* sizeof(float ), (void*)(6 * sizeof(float)));
    glEnableVertexAttribArray(2);

    glGenTextures(1, &textureId);
    glBindTexture(GL_TEXTURE_2D, textureId);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexImage2D(GL_TEXTURE_2D,
                 0,
                 GL_RGBA,
                 renderImage.width,
                 renderImage.height,
                 0,
                 GL_RGBA,
                 GL_UNSIGNED_BYTE,
                 renderImage.ppPlane[0]);

    glGenTextures(1, &textureId1);
    glBindTexture(GL_TEXTURE_2D, textureId1);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_REPEAT);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_REPEAT);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
    glTexParameterf(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);
    glTexImage2D(GL_TEXTURE_2D,
                 0,
                 GL_RGBA,
                 renderImage.width,
                 renderImage.height,
                 0,
                 GL_RGBA,
                 GL_UNSIGNED_BYTE,
                 renderImage.ppPlane[0]);
//    glGenerateMipmap(GL_TEXTURE_2D);

    shader->use();
    shader->setInt("texture0", 0);
    shader->setInt("texture1", 1);

}

void TextureSample::draw(int screenW, int screenH) {
    if (!shader) {
        return;
    }
    glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
    glClear(GL_COLOR_BUFFER_BIT);

    shader->use();
    glActiveTexture(GL_TEXTURE0);
    glBindTexture(GL_TEXTURE_2D, textureId);

    glActiveTexture(GL_TEXTURE1);
    glBindTexture(GL_TEXTURE_2D, textureId1);

    glBindVertexArray(VAO);
    glDrawElements(GL_TRIANGLES, 6, GL_UNSIGNED_INT, 0);
}

void TextureSample::destroy() {
    glDeleteVertexArrays(1, &VAO);
    glDeleteBuffers(1, &VBO);
    glDeleteBuffers(1, &EBO);
    if (shader) {
        glDeleteProgram(shader->getProgramId());
        shader = nullptr;
    }
    NativeImageUtil::FreeNativeImage(&renderImage);
}
