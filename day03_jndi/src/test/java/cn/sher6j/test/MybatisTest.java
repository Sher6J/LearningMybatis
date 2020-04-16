package cn.sher6j.test;

import cn.sher6j.dao.UserDao;
import cn.sher6j.domain.QueryVo;
import cn.sher6j.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 测试mybatis的CRUD操作
 * @author sher6j
 * @create 2020-04-11-16:13
 */
public class MybatisTest {

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
     * 测试查询所有
     */
    @Test
    public void findAll() {
//        //1.读取字节文件，生成字节输入流
//        InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
//        //2.获取SqlSessionFactory对象
//        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
//        //3.获取SqlSession对象
//        SqlSession session = factory.openSession();
//        //4.获取dao的代理对象
//        UserDao userDao = session.getMapper(UserDao.class);
        //5.执行查询所有方法
        List<User> users = userDao.findAll();
        users.forEach(System.out::println);
        //6.释放资源
//        session.close();
//        is.close();
    }

    /**
     * 测试保存用户数据操作
     */
    @Test
    public void saveUser() {
        User user = new User();
        user.setUsername("老王");
        user.setAddress("黑龙江省哈尔滨市");
        user.setBirthday(new Date());
        user.setSex("女");
        System.out.println("保存前：" + user);

        //5.执行保存方法
        userDao.saveUser(user);
        System.out.println("保存后：" + user);
    }

    /**
     * 测试更行用户数据操作
     */
    @Test
    public void updateUser() throws ParseException {
        User user = new User();
        user.setId(50);
        user.setUsername("六甲1");
        user.setAddress("黑龙江省哈尔滨市1");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        user.setBirthday(sdf.parse("1997-11-26"));
        user.setSex("男");

        //5.执行更新方法
        userDao.updateUser(user);
    }

    /**
     * 测试删除用户数据操作
     */
    @Test
    public void deleteUser() throws ParseException {
        //5.执行删除方法
        userDao.deleteUser(48);
    }

    /**
     * 测试根据ID查找用户数据操作
     */
    @Test
    public void findById() throws ParseException {
        //5.执行查询一个方法
        User user = userDao.findById(50);
        System.out.println(user);
    }

    /**
     * 测试模糊查询操作
     */
    @Test
    public void findByName() throws ParseException {
        //5.执行模糊查询方法
        List<User> users = userDao.findByName("%王%");
        users.forEach(System.out::println);
    }

    /**
     * 测试查询总记录条数
     */
    @Test
    public void findTotal() throws ParseException {
        //5.执行查询一个方法
        int total = userDao.findTotal();
        System.out.println("共有记录" + total + "条");
    }

    /**
     * 测试根据QueryVo查询操作
     */
    @Test
    public void findUserByVo() {
        QueryVo vo  = new QueryVo();
        User user = new User();
        user.setUsername("%王%");
        vo.setUser(user);
        //5.执行模糊查询方法
        List<User> users = userDao.findUserByVo(vo);
        users.forEach(System.out::println);
    }

    /**
     * 测试根据条件查询此操作
     */
    @Test
    public void findByCondition() {
        User u = new User();
        u.setUsername("老王");
        u.setSex("男");
        List<User> users = userDao.findByCondition(u);
        users.forEach(System.out::println);
    }

    /**
     * 测试根据QueryVo中ids查询此操作
     */
    @Test
    public void findUserInIds() {
        QueryVo vo = new QueryVo();
        List<Integer> list = new ArrayList<>();
        list.add(50);
        list.add(51);
        list.add(52);
        list.add(53);
        vo.setIds(list);
        List<User> users = userDao.findUserInIds(vo);
        users.forEach(System.out::println);
    }

}
