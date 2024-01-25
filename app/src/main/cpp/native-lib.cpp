#include <jni.h>
#include <string>
#include <MyGLRenderContext.h>

extern "C" JNIEXPORT jstring JNICALL
Java_com_baidu_demoopengl_opengl_MainActivity_stringFromJNI(
        JNIEnv* env,
        jobject /* this */) {
    std::string hello = "Hello from C++";

    MyGLRenderContext renderContext = MyGLRenderContext();
    renderContext.printLog();

    return env->NewStringUTF(hello.c_str());
}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnInit(JNIEnv *env, jobject thiz) {

}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnUnInit(JNIEnv *env, jobject thiz) {

}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1SetImageData(JNIEnv *env, jobject thiz, jint format, jint width, jint height, jbyteArray bytes) {

}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnSurfaceCreated(JNIEnv *env, jobject thiz) {

}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnSurfaceChanged(JNIEnv *env, jobject thiz, jint width, jint height) {

}
extern "C"
JNIEXPORT void JNICALL
Java_com_baidu_demoopengl_opengl_MyNativeRender_native_1OnDrawFrame(JNIEnv *env, jobject thiz) {

}