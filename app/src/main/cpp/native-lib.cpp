#include <jni.h>
#include <string>
extern "C" {
#include "bsdiff.c"
#include "bspatch.c"


JNIEXPORT jstring JNICALL
Java_com_example_a021054970_incrupdate_PathUtils_stringFromJNI(JNIEnv *env, jobject instance) {

    std::string hello = "Hello from C++";
    return env->NewStringUTF(hello.c_str());
}

JNIEXPORT jint JNICALL
Java_com_example_a021054970_incrupdate_PathUtils_diff(JNIEnv *env, jclass type, jstring newpath_,
                                                      jstring oldpath_, jstring patch_) {
    int argc = 4;
    char *argv[argc];
    argv[0] = "bsdiff";
    argv[1] = (char *) env->GetStringUTFChars(oldpath_, 0);
    argv[2] = (char *) env->GetStringUTFChars(newpath_, 0);
    argv[3] = (char *) env->GetStringUTFChars(patch_, 0);

    bs_cf(argc, argv);

    env->ReleaseStringUTFChars(newpath_, argv[1]);
    env->ReleaseStringUTFChars(oldpath_, argv[2]);
    env->ReleaseStringUTFChars(patch_, argv[3]);
    return 1;
}

JNIEXPORT jint JNICALL
Java_com_example_a021054970_incrupdate_PathUtils_patch(JNIEnv *env, jclass type, jstring newpath_,
                                                       jstring oldpath_, jstring patch_) {
    int argc = 4;
    char *argv[argc];
    argv[0] = "bspatch";
    argv[1] = (char *) env->GetStringUTFChars(oldpath_, 0);
    argv[2] = (char *) env->GetStringUTFChars(newpath_, 0);
    argv[3] = (char *) env->GetStringUTFChars(patch_, 0);

    bs_hp(argc, argv);
    env->ReleaseStringUTFChars(newpath_, argv[1]);
    env->ReleaseStringUTFChars(oldpath_, argv[2]);
    env->ReleaseStringUTFChars(patch_, argv[3]);
    return 1;
}
}