package cn.sher6j.dao;

import cn.sher6j.domain.User;

import java.util.List;

/**
 * 用户的持久层接口
 * @author sher6j
 * @create 2020-04-11-16:07
 */
public interface UserDao {
    /**
     * 查询所有用户
     * @return
     */
    List<User> findAll();

    /**
     * 保存用户数据方法
     * @param user
     */
    void saveUser(User user);

    /**
     * 更新用户
     * @param user
     */
    void updateUser(User user);

    /**
     * 根据ID删除用户
     * @param userId
     */
    void deleteUser(Integer userId);

    /**
     * 根据ID查询
     * @param userId
     * @return
     */
    User findById(Integer userId);

    /**
     * 根据名称模糊查询
     * @param name
     * @return
     */
    List<User> findByName(String name);

    /**
     * 查询总用户数
     * @return
     */
    int findTotal();


}
