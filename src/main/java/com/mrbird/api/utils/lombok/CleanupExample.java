package com.mrbird.api.utils.lombok;

import lombok.Cleanup;

import java.io.*;

/**
 * @Description
 * @Author: liucq
 * @Date: 2019/4/29
 */
public class CleanupExample {

    public static void main(String[] args) throws IOException {
        @Cleanup InputStream in = new FileInputStream(args[0]);
        @Cleanup OutputStream out = new FileOutputStream(args[1]);
        byte[] b = new byte[10000];
        while (true) {
            int r = in.read(b);
            if (r == -1) {
                break;
            }
            out.write(b, 0, r);
        }
    }
}
