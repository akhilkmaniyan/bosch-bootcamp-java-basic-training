#include <jni.h>
#include <iostream>
#include "HelloWorldJNI.h"
using namespace std;

JNIEXPORT void JNICALL Java_HelloWorldJNI_sayHello(JNIEnv *env, jobject obj) {
 std::cout <<"Hello from c++" << std::endl;
}
