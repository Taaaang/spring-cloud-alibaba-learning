package pers.tang.business.user.api;

import pers.tang.business.user.api.entity.User;

/**
 * 提供用户相关操作
 */
public interface IUserService {

    /**
     * 查询用户信息
     * @param userId 用户编号
     * @return 用户信息
     */
    User getUser(Integer userId);

}


