package cn.sher6j.dao.impl;

import cn.sher6j.dao.UserDao;
import cn.sher6j.domain.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-11-19:18
 */
public class UserDaoImpl implements UserDao {

    private SqlSessionFactory factory;

    public UserDaoImpl(SqlSessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public List<User> findAll() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法实现查询列表
        /*配置文件的namespace+方法名*/
        List<User> users = session.selectList("cn.sher6j.dao.UserDao.findAll");//参数就是能获取配置信息的key
        //3.释放资源
        session.close();
        return users;
    }

    @Override
    public void saveUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.insert("cn.sher6j.dao.UserDao.saveUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    @Override
    public void updateUser(User user) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.update("cn.sher6j.dao.UserDao.updateUser", user);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();

    }

    @Override
    public void deleteUser(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用方法实现保存
        session.update("cn.sher6j.dao.UserDao.deleteUser", userId);
        //3.提交事务
        session.commit();
        //4.释放资源
        session.close();
    }

    @Override
    public User findById(Integer userId) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法实现查询一个
        /*配置文件的namespace+方法名*/
        User user = session.selectOne("cn.sher6j.dao.UserDao.findById", userId);
        //3.释放资源
        session.close();
        return user;
    }

    @Override
    public List<User> findByName(String name) {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法实现查询一个
        /*配置文件的namespace+方法名*/
        List<User> users = session.selectList("cn.sher6j.dao.UserDao.findByName", name);
        //3.释放资源
        session.close();
        return users;
    }

    @Override
    public int findTotal() {
        //1.根据factory获取SqlSession对象
        SqlSession session = factory.openSession();
        //2.调用SqlSession中的方法实现查询一个
        /*配置文件的namespace+方法名*/
        Integer count = session.selectOne("cn.sher6j.dao.UserDao.findTotal");
        //3.释放资源
        session.close();
        return count;
    }
}
