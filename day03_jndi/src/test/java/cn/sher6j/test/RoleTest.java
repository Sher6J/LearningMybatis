package cn.sher6j.test;

import cn.sher6j.dao.RoleDao;
import cn.sher6j.dao.UserDao;
import cn.sher6j.domain.Role;
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
 * @create 2020-04-12-19:10
 */
public class RoleTest {

    private InputStream is;
    private SqlSession session;
    private RoleDao roleDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        //1.读取字节文件，生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取SqlSession对象
        session = factory.openSession();
        //4.获取dao的代理对象
        roleDao = session.getMapper(RoleDao.class);
    }

    @After//用于在测试方法执行之后执行
    public void destroy() throws Exception{
        //提交事务
        session.commit();
        //6.释放资源
        session.close();
        is.close();
    }


    @Test
    public void findAll() {
        List<Role> roles = roleDao.findAll();
        roles.forEach(System.out::println);
    }

    @Test
    public void findAllAndUser() {
        List<Role> roles = roleDao.findAllAndUser();
        for (Role r : roles) {
            System.out.println("------显示角色信息--------");
            System.out.println(r);
            System.out.println(r.getUsers());
        }
    }
}
