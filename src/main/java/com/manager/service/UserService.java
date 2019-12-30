package com.manager.service;

import com.manager.pojo.User;
import com.manager.dto.UserSearchDTO;
import com.manager.response.PageDataResult;

import java.util.Map;


/**
 * @Title: AdminUserService
 * @Description:
 * @author: youqing
 * @version: 1.0
 * @date: 2018/11/21 11:04
 */
public interface UserService {

    PageDataResult getUserList(UserSearchDTO userSearch, Integer pageNum, Integer pageSize);

    Map<String,Object> addUser(User user);

    Map<String,Object> updateUser(User user);

    User getUserById(Integer id);

    User findByUserName(String userName);

    int updatePwd(String userName,String password);

    Map<String, Object> delUser(Integer id,Integer status);

    Map<String, Object> recoverUser(Integer id,Integer status);

    User getuserByOpenId(String openId);
}
