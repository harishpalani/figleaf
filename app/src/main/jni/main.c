#include <jni.h>

extern unsigned char figleaf_process_image(char *input_filename, char *output_filename, char *passphrase, int mode, int blocksize);

JNIEXPORT unsigned char JNICALL Java_com_horaapps_leafpic_ImageFragment_getJPEGByteArray (JNIEnv *env, jobject o, char *input_filename, char *output_filename, char *passphrase, int mode, int blocksize) {
    return figleaf_process_image(input_filename, output_filename, passphrase, mode, blocksize);
}