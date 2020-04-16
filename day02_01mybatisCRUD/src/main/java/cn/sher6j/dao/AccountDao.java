package cn.sher6j.dao;

import cn.sher6j.domain.Account;
import cn.sher6j.domain.AccountUser;

import java.util.List;

/**
 * 账户的持久层接口
 * @author sher6j
 * @create 2020-04-12-17:24
 */
public interface AccountDao {
    /**
     * 查询所以账户
     * @return
     */
    List<Account> findAll();

    /**
     * 查询所有账户，并且带有账户对应用户的用户名称和地址信息
     * @return
     */
    List<AccountUser> findAllAccount();
}
