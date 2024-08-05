package org.example.base.stream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.GZIPOutputStream;

public class TestGzip {
    private static void gzip(String path, String newPath) throws Exception {
        FileInputStream fi = new FileInputStream(path);
        byte[] bytes = new byte[1024];
        int len = 0;
        FileOutputStream fo = new FileOutputStream(newPath);
        GZIPOutputStream out = new GZIPOutputStream(fo);
        while ((len = fi.read(bytes)) != -1) {
            out.write(bytes, 0, len);
            out.flush();
        }
        out.close();
        fi.close();
    }

    private static void move(String path, String newPath) throws Exception {
        File newFile = new File(newPath);
        newFile.delete();
        File file = new File(path);
        file.renameTo(newFile);
    }

    public static void main1(String[] args) throws Exception {
        String path = "D:\\IdeaProjects\\Viewer\\PhoenixServer\\wabapp\\phoenix\\pdfs\\minified\\" +
                "web\\pdf.viewer.js";
        String newPath = "C:\\Users\\DB-User\\Desktop\\" +
                "pdf.viewer.js";
        gzip(path, newPath);
        move(newPath, path);

        String path1 = "D:\\IdeaProjects\\Viewer\\PhoenixServer\\wabapp\\phoenix\\pdfs\\minified\\" +
                "build\\pdf.worker.js";
        String newPath1 = "C:\\Users\\DB-User\\Desktop\\" +
                "pdf.worker.js";
        gzip(path1, newPath1);
        move(newPath1, path1);
    }

    public static void main2(String[] args) {
        String path = "D:\\work\\temp\\WebViewerFiles\\eCTD-Sample\\3 Grouped\\202022";
        path = path.replace("\\", "/");
        String fullPath = "local" + path.replace("".replace("\\", "/"), "");
        System.out.println("/" + fullPath);
    }

    public static void main(String[] args) throws Exception {
        String path1 = "C:\\Users\\DB-User\\Desktop\\app.js";
        String newPath1 = "C:\\Users\\DB-User\\Desktop\\app1.js";
        gzip(path1, newPath1);
    }
}
