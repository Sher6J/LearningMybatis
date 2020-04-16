package cn.sher6j.dao;

import cn.sher6j.domain.Role;

import java.util.List;

/**
 * @author sher6j
 * @create 2020-04-12-19:06
 */
public interface RoleDao {

    /**
     * 查询所有角色
     * @return
     */
    List<Role> findAll();

    /**
     * 查询所有角色并包含该角色的用户
     * @return
     */
    List<Role> findAllAndUser();
}
