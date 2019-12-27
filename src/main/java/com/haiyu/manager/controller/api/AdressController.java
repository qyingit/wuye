package com.haiyu.manager.controller.api;

import com.haiyu.manager.pojo.BaseAddress;
import com.haiyu.manager.response.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 15:01
 */
@Controller
@RequestMapping("/adress")
public class AdressController {


    @RequestMapping("get")
    public ResponseDTO<BaseAddress> getUserAddress(){
        return ResponseDTO.success(new BaseAddress());
    }

    @RequestMapping("/save")
    public ResponseDTO SaveUserAddress(){
        return ResponseDTO.success();
    }
}
