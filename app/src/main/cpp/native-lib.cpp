#include <jni.h>
#include <string>
#include <MyGLRenderContext.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_baidu_demoopengl_opengl_MainActivity_stringFromJNI(
        JNIEnv *env,
        jobject /* this */) {
    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnInit(JNIEnv *env, jobject thiz) {
    MyGLRenderContext::getInstance();
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnUnInit(JNIEnv *env, jobject thiz) {
    MyGLRenderContext::destroyInstance();
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1SetImageData(JNIEnv *env, jobject thiz, jint format, jint width, jint height, jbyteArray imageData) {
    int len = env->GetArrayLength(imageData);
    auto *buf = new uint8_t[len];
    env->GetByteArrayRegion(imageData, 0, len, reinterpret_cast<jbyte *>(buf));
    MyGLRenderContext::getInstance()->setImageData(format, width, height, buf);
    delete[] buf;
    env->DeleteLocalRef(imageData);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1Set2ImageData(JNIEnv *env, jobject thiz,
                                                                      jint format0, jint width0, jint height0, jbyteArray imageData0,
                                                                      jint format1, jint width1, jint height1, jbyteArray imageData1) {
    uint8_t *buf0 = nullptr;
    uint8_t *buf1 = nullptr;

    if (imageData0 != nullptr) {
        int len0 = env->GetArrayLength(imageData0);
        buf0 = new uint8_t[len0];
        env->GetByteArrayRegion(imageData0, 0, len0, reinterpret_cast<jbyte *>(buf0));
    }

    if (imageData1 != nullptr) {
        int len1 = env->GetArrayLength(imageData1);
        buf1 = new uint8_t[len1];
        env->GetByteArrayRegion(imageData1, 0, len1, reinterpret_cast<jbyte *>(buf1));
    }

    MyGLRenderContext::getInstance()->setImageData(format0, width0, height0, buf0,
                                                   format1, width1, height1, buf1);

    delete[] buf0;
    env->DeleteLocalRef(imageData0);
    delete[] buf1;
    env->DeleteLocalRef(imageData1);

}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnSurfaceCreated(JNIEnv *env, jobject thiz) {
    MyGLRenderContext::getInstance()->onSurfaceCreated();
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnSurfaceChanged(JNIEnv *env, jobject thiz, jint width, jint height) {
    MyGLRenderContext::getInstance()->onSurfaceChanged(width, height);
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnDrawFrame(JNIEnv *env, jobject thiz) {
    MyGLRenderContext::getInstance()->onDrawFrame();
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1SetRenderType(JNIEnv *env, jobject thiz, jint type) {
    MyGLRenderContext::getInstance()->setRenderType(type);
}