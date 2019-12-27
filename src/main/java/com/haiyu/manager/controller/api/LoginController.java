package com.haiyu.manager.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/26 22:25
 */
@Controller
@RequestMapping("api")
public class LoginController {

    @RequestMapping("/login")
    public String login(String code){

        return null;
    }
}
