package com.manager.service.impl;

import com.manager.dao.HouseMapper;
import com.manager.pojo.UserHouse;
import com.manager.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 14:43
 */
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Override
    public List<UserHouse> selectByUserId(Integer userId) {
        return houseMapper.selectByUserId(userId);
    }

    @Override
    public Integer saveHouse(UserHouse userHouse) {
        return houseMapper.save(userHouse);
    }

    @Override
    public Integer updateHouse(UserHouse userHouse) {
        return null;
    }

    @Override
    public Integer deleteHouse(Integer id) {
        return null;
    }
}
