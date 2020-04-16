package cn.sher6j.dao.impl;

import cn.sher6j.dao.UserDao;
import cn.sher6j.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-11-9:20
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    /*
    把默认构造函数覆盖掉，则创建的时候一定会有factory
     */
    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1.使用工厂创建SqlSession对象
        SqlSession session = factory.openSession();
        //2.使用session执行查询所有方法 3.返回查询结果
        List<User> users = session.selectList("cn.sher6j.dao.UserDao.findAll");
        session.close();
        return users;
    }
}
