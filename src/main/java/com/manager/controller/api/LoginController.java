package com.manager.controller.api;

import com.manager.pojo.User;
import com.manager.pojo.wechat.WeixinPersonalAccessTokenVO;
import com.manager.pojo.wechat.WeixinUserInfoVO;
import com.manager.response.ResponseDTO;
import com.manager.service.UserService;
import com.manager.util.WeixinManagerServiceUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/26 22:25
 */
@Controller
@RequestMapping("/api")
@Slf4j
public class LoginController {

    private static final String TAG = "微信LoginController";
    private static final String  appId = "appId";
    private static final String  sec = "sec";

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public ResponseDTO login(String code, HttpServletRequest request, HttpServletResponse response){
        WeixinPersonalAccessTokenVO personalToken = WeixinManagerServiceUtil.getPersonalAccessToken(appId, sec, code);

        if (Objects.isNull(personalToken) || personalToken.getOpenid() == null) {
            log.error("{}获取openid失败,code:{},响应结果response:{}",TAG, code, personalToken);
            return ResponseDTO.fail("获取openid失败！");
        }

        User user = userService.getuserByOpenId(personalToken.getOpenid());
        if (Objects.isNull(user)) {
            WeixinUserInfoVO weixinUserInfo = WeixinManagerServiceUtil.getWeixinUserInfo(personalToken.getOpenid(), appId, sec);
            user = new User();
            user.setRoleId(1);
            user.setSysUserName(weixinUserInfo.getNickname());
            userService.addUser(user);
        }

        return ResponseDTO.success(user.getId());
    }

    @RequestMapping("/updateUser")
    public ResponseDTO login1(String code, HttpServletRequest request, HttpServletResponse response){
        WeixinPersonalAccessTokenVO personalToken = WeixinManagerServiceUtil.getPersonalAccessToken(appId, sec, code);

        if (Objects.isNull(personalToken) || personalToken.getOpenid() == null) {
            log.error("{}获取openid失败,code:{},响应结果response:{}",TAG, code, personalToken);
            return ResponseDTO.fail("获取openid失败！");
        }

        User user = userService.getuserByOpenId(personalToken.getOpenid());
        if (Objects.isNull(user)) {
            WeixinUserInfoVO weixinUserInfo = WeixinManagerServiceUtil.getWeixinUserInfo(personalToken.getOpenid(), appId, sec);
            user = new User();
            user.setRoleId(1);
            user.setSysUserName(weixinUserInfo.getNickname());
            userService.addUser(user);
        }

        return ResponseDTO.success(user.getId());
    }


}
