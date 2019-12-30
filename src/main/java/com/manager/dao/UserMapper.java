package com.manager.dao;


import com.manager.dto.AdminUserDTO;
import com.manager.pojo.User;
import com.manager.dto.UserSearchDTO;
import tk.mapper.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper extends MyMapper<User> {

    List<AdminUserDTO> getUserList(UserSearchDTO userSearchDTO);

    User getUserByUserName(@Param("sysUserName")String sysUserName, @Param("id") Integer id);

    int updateUserStatus(@Param("id") Integer id,@Param("status") Integer status);

    int updateUser(User user);

    User findByUserName(@Param("userName") String userName);

    int updatePwd(@Param("userName") String userName,@Param("password") String password);

    User selectByOpenId(@Param("openId")String openId);
}