package com.example.a021054970.incrupdate;

public class PathUtils {

    static {
        System.loadLibrary("native-lib");
    }

    public native static String stringFromJNI();

    public native static int diff(String newpath, String oldpath, String patch);

    public native static int patch(String newpath, String oldpath, String patch);
}
