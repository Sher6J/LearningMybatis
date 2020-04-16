package cn.sher6j.dao;

import cn.sher6j.domain.User;
import cn.sher6j.mybatis.annotation.Select;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-11-8:37
 */
public interface UserDao {
    /**
     * 查询所有操作
     */
    @Select("select * from user")
    List<User> findAll();
}
