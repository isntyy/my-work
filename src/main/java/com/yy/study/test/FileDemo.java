package com.yy.study.test;

import java.io.*;

/**
 * @author wyy
 * @since 2020-03-17 21:37
 */
public class FileDemo {

    public static void main(String[] args) throws Exception {
        write();
        read();
    }

    /**
     * 字节流写文件
     */
    public static void write() throws Exception {
        File file = new File("G:\\a.txt");
        OutputStream os = new FileOutputStream(file);
        os.write("啊哈哈哈".getBytes());
        os.close();
    }

    /**
     * 字节流读文件
     *
     * @throws Exception
     */
    public static void read() throws Exception {
        File file = new File("G:\\a.txt");
        InputStream is = new FileInputStream(file);
        byte[] bytes = new byte[1024];
        int len = -1;
        StringBuffer buffer = new StringBuffer();
        // is.read(bytes) 是将读取到的字节写入数组，返回的是读取到的字节长度
        while ((len = (is.read(bytes))) != -1) {
            buffer.append(new String(bytes));
        }
        System.out.println(buffer);
        is.close();
    }
}
