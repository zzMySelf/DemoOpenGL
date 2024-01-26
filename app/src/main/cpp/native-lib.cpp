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