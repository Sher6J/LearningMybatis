package cn.sher6j.test;

import cn.sher6j.dao.UserDao;
import cn.sher6j.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-12-18:44
 */
public class UserTest {

    private InputStream is;
    private SqlSession session;
    private UserDao userDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        //1.读取字节文件，生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取SqlSession对象
        session = factory.openSession();
        //4.获取dao的代理对象
        userDao = session.getMapper(UserDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception{
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        is.close();
    }


    /**
     * 测试查询所有用户，同时获取到用户下所有账户的信息
     */
    @Test
    public void findUserAndAllAccount() {
        List<User> users = userDao.findUserAndAllAccount();
        for (User user : users) {
            System.out.println("----------每个用户的信息-------------");
            System.out.println(user);
            System.out.println(user.getAccounts());
        }
    }

    @Test
    public void findAndAllRoles() {
        List<User> users = userDao.findAndAllRoles();
        for (User user : users) {
            System.out.println("----------每个用户的信息-------------");
            System.out.println(user);
            System.out.println(user.getRoles());
        }
    }
}
