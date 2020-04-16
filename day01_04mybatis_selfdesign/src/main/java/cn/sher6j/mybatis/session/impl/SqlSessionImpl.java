package cn.sher6j.mybatis.session.impl;

import cn.sher6j.mybatis.cfg.Configuration;
import cn.sher6j.mybatis.session.SqlSession;
import cn.sher6j.mybatis.session.proxy.MapperProxy;
import cn.sher6j.mybatis.utils.DataSourceUtil;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * SqlSession接口的实现类
 * @author sher6j
 * @create 2020-04-11-11:32
 */
public class SqlSessionImpl implements SqlSession {

    private Configuration cfg;

    private Connection conn;

    public SqlSessionImpl(Configuration cfg) {
        this.cfg = cfg;
        conn = DataSourceUtil.getConnection(cfg);
    }

    /**
     * 用于创建代理对象
     * @param daoInterfaceClass dao的接口字节码
     * @param <T>
     * @return
     */
    @Override
    public <T> T getMapper(Class<T> daoInterfaceClass) {
        //三个参数：代理谁用谁的类加载器，代理谁用谁的接口，如何代理
        Object o = Proxy.newProxyInstance(daoInterfaceClass.getClassLoader(),
                new Class[]{daoInterfaceClass}, new MapperProxy(cfg.getMappers(), conn));
        return (T) o;

    }

    /**
     * 用于释放资源
     */
    @Override
    public void close() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
