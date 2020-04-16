package cn.sher6j.test;

import cn.sher6j.dao.UserDao;
import cn.sher6j.dao.impl.UserDaoImpl;
import cn.sher6j.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

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
        //3. 使用工厂创建dao对象
        UserDao userDao = new UserDaoImpl(factory);

        //3. 使用工厂生产一个SqlSession对象
//        SqlSession session = factory.openSession();
        /*
        自己写实现类，则不再需要代理对象
         */
        //4. 使用SqlSession创建Dao接口的代理对象
//        UserDao userDao = session.getMapper(UserDao.class);

        //5. 使用代理对象执行方法
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
        //6. 释放资源
        is.close();
    }
}
