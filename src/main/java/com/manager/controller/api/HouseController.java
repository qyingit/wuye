package com.manager.controller.api;

import com.manager.pojo.UserHouse;
import com.manager.response.ResponseDTO;
import com.manager.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 15:01
 */
@Controller
@RequestMapping("/adress")
public class HouseController {

    @Autowired
    private HouseService houseService;


    @RequestMapping("get")
    public ResponseDTO<List<UserHouse>> getUserAddress(Integer userId){
        List<UserHouse> userHouses = houseService.selectByUserId(userId);
        return ResponseDTO.success(userHouses);
    }

    @RequestMapping("/save")
    public ResponseDTO saveUserAddress(UserHouse userHouse){
        Integer houseId = houseService.saveHouse(userHouse);
        return ResponseDTO.success(houseId);
    }

    @RequestMapping("/update")
    public ResponseDTO updateUserAddress(UserHouse userHouse){
        Integer houseId = houseService.updateHouse(userHouse);
        return ResponseDTO.success(houseId);
    }


    @RequestMapping("/delete")
    public ResponseDTO deleteUserAddress(Integer id){
        Integer houseId = houseService.deleteHouse(id);
        return ResponseDTO.success(houseId);
    }

}
