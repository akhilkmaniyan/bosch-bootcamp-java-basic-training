public class HelloWorldJNI {
    // Declare a native method
    public native void sayHello();

    // Load the native library
    static {
        System.loadLibrary("helloworld");
    }

    public static void main(String[] args) {
        new HelloWorldJNI().sayHello();
    }
}
