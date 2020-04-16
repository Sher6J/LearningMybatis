package cn.sher6j.mybatis.session.impl;

import cn.sher6j.mybatis.cfg.Configuration;
import cn.sher6j.mybatis.session.SqlSession;
import cn.sher6j.mybatis.session.SqlSessionFactory;

/**
 * SqlSessionFactory接口的实现类
 * @author sher6j
 * @create 2020-04-11-11:29
 */
public class SqlSessionFactoryImpl implements SqlSessionFactory {

    private Configuration cfg;

    public SqlSessionFactoryImpl(Configuration cfg) {
        this.cfg = cfg;
    }

    /**
     * 用于创建一个新的操作数据库对象
     * @return
     */
    @Override
    public SqlSession openSession() {
        return new SqlSessionImpl(cfg);
    }
}
