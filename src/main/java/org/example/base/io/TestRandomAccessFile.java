package org.example.base.io;

import java.io.File;
import java.io.RandomAccessFile;

/**
 * JNIEXPORT void JNICALL
 * Java_java_io_FileOutputStream_open0(JNIEnv *env, jobject this,
 *                                     jstring path, jboolean append) {
 *     fileOpen(env, this, path, fos_fd,
 *              O_WRONLY | O_CREAT | (append ? O_APPEND : O_TRUNC));
 * }
 */

public class TestRandomAccessFile {
    public static void main(String[] args) throws Exception {
        File file =new File("C:\\Users\\suxiaohan\\Desktop\\1111\\3.txt");
        if (!file.exists()) {
            File parent = file.getParentFile();
            if (!parent.exists()) {
                parent.mkdirs();
            }
        }
        RandomAccessFile accessFile = new RandomAccessFile(file,"rw");
        accessFile.write(Long.valueOf("1111").toString().getBytes());
    }
}
