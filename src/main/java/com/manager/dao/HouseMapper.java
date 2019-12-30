package com.manager.dao;

import com.manager.pojo.UserHouse;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 14:45
 */

@Repository
public interface HouseMapper {
    List<UserHouse> selectByUserId(Integer userId);

    Integer save(UserHouse userHouse);
}
