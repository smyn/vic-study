package com.newegg.pr.base.util;

import org.springframework.core.io.ClassPathResource;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/**
 * @author vic
 * @date 9/2/2021 1:16 PM
 * @description 文件公共的Util
 */
public class FileUtil {

    public static String read2String(String path) throws IOException {
        return read2String(path, StandardCharsets.UTF_8);
    }

    public static String read2String(String path, Charset charset) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(new File(path));
        return read2String(fileInputStream,charset);
    }

    /**
     * 字符串转为InputStream
     * @param content
     * @param charset
     * @return
     */
    public static  InputStream string2InputStream(String content,Charset charset){
        return new ByteArrayInputStream(content.getBytes(charset));
    }

    /**
     * InputStream
     * @param content
     * @return
     */
    public static  InputStream string2InputStream(String content){
        return new ByteArrayInputStream(content.getBytes(StandardCharsets.UTF_8));
    }

    /**
     * 如果文件不存在则创建
     * @param path
     */
    public static void createDictionaryIfNotExists(String path){
        File file = new File(path);
        if(!file.exists()){
            file.setWritable(true,false);
            file.mkdirs();
        }
    }

    public static byte[] readBytesFromFile(String filePath) {
        FileInputStream fileInputStream = null;
        byte[] bytesArray = null;
        try {
            File file = new File(filePath);
            bytesArray = new byte[(int) file.length()];
            fileInputStream = new FileInputStream(file);
            fileInputStream.read(bytesArray);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return bytesArray;
    }

    public static String getFileName(String path){
        File file = new File(path);
        return file.getName();
    }

    public static InputStream getResourceFileStream(String filePath) throws Exception{
        ClassPathResource resource = new ClassPathResource(filePath);
        return resource.getInputStream();
    }

    public static String getResourceFile(String filePath) throws Exception{
        InputStream inputStream = getResourceFileStream(filePath);
        return read2String(inputStream,StandardCharsets.UTF_8);
    }

    public  static String read2String(InputStream inputStream,Charset charset) throws IOException{
        byte[] buffer = new byte[10];
        StringBuilder sb = new StringBuilder();
        while (inputStream.read(buffer) != -1) {
            sb.append(new String(buffer, charset));
            buffer = new byte[10];
        }
        inputStream.close();
        return sb.toString();
    }



}
