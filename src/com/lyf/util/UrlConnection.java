package com.lyf.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by a1996_000 on 2017/7/11.
 */
//在线文件的下载
public class UrlConnection {
    /*
 * 根据URL在线文件的下载
 *
 * @param	文件的全路径地址
 * @param   文件存放的本地路径的地址
 *
 */
    public static void downloadNet(String source, String target) {
        // 下载网络文件
        int bytesum = 0;
        int byteread = 0;

        try {

            URL url = new URL(source);
            URLConnection conn = url.openConnection();
            InputStream inStream = conn.getInputStream();
            target += "/" + source.substring(source.lastIndexOf("/") + 1);
            FileOutputStream fs = new FileOutputStream(target);

            byte[] buffer = new byte[1204];
            while ((byteread = inStream.read(buffer)) != -1) {
                bytesum += byteread;
                fs.write(buffer, 0, byteread);
            }
            System.out.println("下载 " + target + " 完成!");
            fs.close();
            inStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        // 根据网页地址和网页的编码集 获取网页的内容
        String urls="https://github.com/liyunfengfengfeng/note/blob/dev/src/com/lyf/resume/picture/%E6%9D%8E%E4%BA%91%E5%B3%B0.jpg";
        String[] url = urls.split("--");
        for (int i = 0; i < url.length; i++) {
            downloadNet(url[i], "e:\\test");
        }
    }
}
