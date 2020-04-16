package cn.sher6j.mybatis.io;

import java.io.InputStream;

/**
 * 使用类加载器读取配置文件的类
 * @author sher6j
 * @create 2020-04-11-10:55
 *
 */
public class Resources {

    /**
     * 根据传入的参数，获取一个字节输入流
     * @param filePath
     * @return
     */
    public static InputStream getResourceAsStream(String filePath) {
        //1.获取当前类的字节码
        //2.获取该字节码的类加载器
        //3.根据类加载器读取配置
        return Resources.class.getClassLoader().getResourceAsStream(filePath);
    }
}
