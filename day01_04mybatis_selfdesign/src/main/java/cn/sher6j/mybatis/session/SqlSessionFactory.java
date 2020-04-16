package cn.sher6j.mybatis.session;

/**
 * @author sher6j
 * @create 2020-04-11-10:59
 */
public interface SqlSessionFactory {
    /**
     * 用于打开一个新的SqlSession对象
     * @return
     */
    SqlSession openSession();
}
