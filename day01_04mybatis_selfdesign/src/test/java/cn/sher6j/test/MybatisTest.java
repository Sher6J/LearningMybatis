package cn.sher6j.test;

import cn.sher6j.dao.UserDao;
import cn.sher6j.domain.User;
import cn.sher6j.mybatis.io.Resources;
import cn.sher6j.mybatis.session.SqlSession;
import cn.sher6j.mybatis.session.SqlSessionFactory;
import cn.sher6j.mybatis.session.SqlSessionFactoryBuilder;
//import org.apache.ibatis.io.Resources;
//import org.apache.ibatis.session.SqlSession;
//import org.apache.ibatis.session.SqlSessionFactory;
//import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-11-8:57
 * mybatis的入门案例
 */
public class MybatisTest {
    /**
     * 入门案例
     * @param args
     */
    public static void main(String[] args) throws Exception {
        //1. 读取配置文件
        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2. 创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(is);//SqlSessionFactory是个接口，不可以直接new对象
        //3. 使用工厂生产一个SqlSession对象
        SqlSession session = factory.openSession();
        //4. 使用SqlSession创建Dao接口的代理对象
        UserDao userDao = session.getMapper(UserDao.class);
        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
        //6. 释放资源
        session.close();
        is.close();
    }
}
