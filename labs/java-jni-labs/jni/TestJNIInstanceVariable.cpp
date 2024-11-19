#include <jni.h>
#include <iostream>
#include "TestJNIInstanceVariable.h"

 using namespace std;

JNIEXPORT void JNICALL Java_TestJNIInstanceVariable_modifyInstanceVariable
          (JNIEnv *env, jobject thisObj) {
    // Get a reference to this object's class
    jclass thisClass = env->GetObjectClass(thisObj);

    // Get the Field ID of the instance variable "number"
    jfieldID fidNumber = env->GetFieldID(thisClass, "number", "I");
    if (fidNumber == NULL) {
        std::cout << "Field 'number' not found!" << std::endl;
        return;
    }

    // Get the int value of "number"
    jint number = env->GetIntField(thisObj, fidNumber);
    std::cout << "The value = %d" << number << std::endl;

    // Change the variable
    number = 99;
    env->SetIntField(thisObj, fidNumber, number);

    // Get the Field ID of the instance variable "message"
    jfieldID fidMessage = env->GetFieldID(thisClass, "message", "Ljava/lang/String;");
    if (fidMessage == NULL) {
        std::cout << "Field 'message' not found!" << std::endl;
        return;
    }

    // Get the object (String) given the Field ID
    jstring message = (jstring)env->GetObjectField(thisObj, fidMessage);

    // Create a C-string from the JNI String
    const char *cStr = env->GetStringUTFChars(message, NULL);
    if (cStr == NULL) {
        std::cout << "Failed to get C-string from JNI string!" << std::endl;
        return;
    }

    std::cout << "The string value is: " << cStr << std::endl;
    env->ReleaseStringUTFChars(message, cStr);

    // Create a new C-string and assign it to the JNI string
    message = env->NewStringUTF("Hello from C++");
    if (message == NULL) {
        std::cout << "Failed to create new JNI string!" << std::endl;
        return;
    }

    // Modify the instance variable "message"
    env->SetObjectField(thisObj, fidMessage, message);
}