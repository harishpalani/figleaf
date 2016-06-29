/*
#include <android/bitmap.h>
JNIEXPORT jbyteArray JNICALL Java_com_horaapps_leafpic_Fragments_ImageFragment_getJPEGByteArray (JNIEnv *env, jobject o, jbyteArray a) {

    AndroidBitmapInfo androidBitmapInfo;
    void* pixels;
    AndroidBitmap_getInfo(env, bitmap, &androidBitmapInfo);
    AndroidBitmap_lockPixels(env, bitmap, &pixels);
    unsigned char* pixelsChar = (unsigned char*) pixels;

    return a;
}
*/

#include <jni.h>

JNIEXPORT jbyteArray JNICALL Java_com_horaapps_leafpic_MainActivity_getJPEGByteArray (JNIEnv *env, jobject o) {
    jbyte a[] = {1,2,3,4,5,6};
    jbyteArray ret = (*env)->NewByteArray(env, 6);
    (*env)->SetByteArrayRegion (env, ret, 0, 6, a);
    return ret;
}

JNIEXPORT jbyteArray JNICALL Java_com_horaapps_leafpic_Fragments_ImageFragment_getJPEGByteArray (JNIEnv *env, jobject o, jbyteArray a) {
    return a;
}