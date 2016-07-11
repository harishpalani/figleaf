#include <jni.h>

JNIEXPORT jbyteArray JNICALL Java_com_horaapps_leafpic_Fragments_ImageFragment_getJPEGByteArray(JNIEnv *env, jobject o) {
    jbyte a[] = {1,2,3,4,5,6};
    jbyteArray ret = (*env)->NewByteArray(env, 6);
    (*env)->SetByteArrayRegion (env, ret, 0, 6, a);
    return ret;
}