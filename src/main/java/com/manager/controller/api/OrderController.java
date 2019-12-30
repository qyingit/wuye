package com.manager.controller.api;

import com.manager.response.ResponseDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 15:10
 */
@Controller
@RequestMapping("/order")
public class OrderController {

    @RequestMapping("/getOrdersByStatus")
    public ResponseDTO getOrderByStatus(Integer status){
        return ResponseDTO.success();
    }

    @RequestMapping("/getOrderById")
    public ResponseDTO getOrderById(Integer orderId){
        return ResponseDTO.success();
    }
}
