package com.manager.service;


import com.manager.pojo.UserHouse;

import java.util.List;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 14:43
 */
public interface HouseService {

    List<UserHouse> selectByUserId(Integer user_Id);

    Integer saveHouse(UserHouse userHouse);

    Integer updateHouse(UserHouse userHouse);

    Integer deleteHouse(Integer id);
}
