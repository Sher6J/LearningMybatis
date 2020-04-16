package cn.sher6j.test;

import cn.sher6j.dao.AccountDao;
import cn.sher6j.domain.Account;
import cn.sher6j.domain.AccountUser;
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
 * @create 2020-04-12-17:29
 */
public class AccountTest {

    private InputStream is;
    private SqlSession session;
    private AccountDao accountDao;

    @Before//用于在测试方法执行之前执行
    public void init() throws Exception{
        //1.读取字节文件，生成字节输入流
        is = Resources.getResourceAsStream("SqlMapConfig.xml");
        //2.获取SqlSessionFactory对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(is);
        //3.获取SqlSession对象
        session = factory.openSession();
        //4.获取dao的代理对象
        accountDao = session.getMapper(AccountDao.class);
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
        List<Account> accounts = accountDao.findAll();
//        accounts.forEach(System.out::println);
        for (Account account : accounts) {
            System.out.println("-------每个account的信息-------");
            System.out.println(account);
            System.out.println(account.getUser());
        }
    }


    /**
     * 查询所有账户，同时包含用户名称和地址
     */
    @Test
    public void findAllAccount() {
        List<AccountUser> accounts = accountDao.findAllAccount();
        accounts.forEach(System.out::println);
    }
}
