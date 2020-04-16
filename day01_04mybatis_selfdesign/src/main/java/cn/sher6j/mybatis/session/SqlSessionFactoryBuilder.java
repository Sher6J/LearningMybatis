package cn.sher6j.mybatis.session;

import cn.sher6j.mybatis.cfg.Configuration;
import cn.sher6j.mybatis.session.impl.SqlSessionFactoryImpl;
import cn.sher6j.mybatis.utils.XMLConfigBuilder;

import java.io.InputStream;

/**
 * 用于创建一个SqlSessionFactory对象
 * @author sher6j
 * @create 2020-04-11-10:59
 */
public class SqlSessionFactoryBuilder {

    /**
     * 根据参数的字节输入流构建一个SqlSessionFactory工厂
     * @param config
     * @return
     */
    public SqlSessionFactory build(InputStream config) {
        Configuration cfg = XMLConfigBuilder.loadConfiguration(config);
        return new SqlSessionFactoryImpl(cfg);
    }
}
