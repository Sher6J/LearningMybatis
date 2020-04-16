package cn.sher6j.dao;

import cn.sher6j.domain.User;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-11-8:37
 */
public interface UserDao {
    /**
     * 查询所有操作
     */
    List<User> findAll();
}
