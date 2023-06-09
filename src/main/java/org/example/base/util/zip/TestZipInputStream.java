package org.example.base.util.zip;

import java.io.FileInputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class TestZipInputStream {
    public static void main(String[] args) throws Exception {
        // 必须是使用deflate压缩格式
        FileInputStream in = new FileInputStream("C:\\Users\\suxiaohan\\Desktop\\wind-vue.jar");
        ZipInputStream zip = new ZipInputStream(in);
        ZipEntry zipEntry;
        while ((zipEntry = zip.getNextEntry()) != null) {
            System.out.println("Reading " + zipEntry.getName());
            System.out.println("Reading " + zipEntry.getMethod());
            byte[] buffer = new byte[1024];
            int length;
            while ((length = zip.read(buffer)) > 0) {
            }
            System.out.println();
            zip.closeEntry();
        }
    }
}
