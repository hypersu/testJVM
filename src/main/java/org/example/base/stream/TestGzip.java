package org.example.base.stream;

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

    public static void main(String[] args) throws Exception {
        String path = "D:\\IdeaProjects\\Viewer\\PhoenixServer\\wabapp\\phoenix\\pdfs\\minified\\" +
                "web\\pdf.viewer.js";
        String newPath = "C:\\Users\\ABC\\Desktop\\" +
                "pdf.viewer.js";
        gzip(path, newPath);

        String path1 = "D:\\IdeaProjects\\Viewer\\PhoenixServer\\wabapp\\phoenix\\pdfs\\minified\\" +
                "build\\pdf.worker.js";
        String newPath1 = "C:\\Users\\ABC\\Desktop\\" +
                "pdf.worker.js";
        gzip(path1, newPath1);
    }
}
