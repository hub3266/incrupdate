package com.example.a021054970.incrupdate;

public class PathUtils {

    static {
        System.loadLibrary("native-lib");
    }

    public native static String stringFromJNI();
    /**
     * 对apk进行拆分
     * @param newpath 新版本的apk
     * @param oldpath 旧版本的apk
     * @param patch 生成的差异包
     * @return
     */
    public native static int diff(String newpath, String oldpath, String patch);

    /**
     * 对apk进行合并
     * @param newpath 生成新版本的apk
     * @param oldpath 旧版本的apk
     * @param patch 差异包
     * @return
     */
    public native static int patch(String newpath, String oldpath, String patch);
}
