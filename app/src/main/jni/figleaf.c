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

extern unsigned char figleaf_process_image(char *input_filename, char *output_filename, char *passphrase,
                                           int mode, int blocksize);

JNIEXPORT jbyteArray JNICALL Java_com_horaapps_leafpic_MainActivity_getJPEGByteArray (JNIEnv *env, jobject o) {
    jbyte a[] = {1,2,3,4,5,6};
    jbyteArray ret = (*env)->NewByteArray(env, 6);
    (*env)->SetByteArrayRegion (env, ret, 0, 6, a);
    return ret;
}

JNIEXPORT unsigned char JNICALL Java_com_horaapps_leafpic_Fragments_ImageFragment_getJPEGByteArray(JNIEnv *env, jobject o, char *input_filename, char *output_filename, char *passphrase, int mode, int blocksize) {
    return figleaf_process_image(input_filename, output_filename, passphrase, mode, blocksize);
}