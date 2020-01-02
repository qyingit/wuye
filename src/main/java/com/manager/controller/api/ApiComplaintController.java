package com.manager.controller.api;

import com.manager.response.ResponseDTO;
import com.manager.service.ComplaintService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 17:51
 */
@RequestMapping("/api/complaint")
@Controller
public class ApiComplaintController {

    @Autowired
    private ComplaintService complaintService;

    @RequestMapping("/add")
    public ResponseDTO saveComplaint(String complaint){
        Long userId = 0l ;
        complaintService.saveComplaint(userId, complaint);
        return ResponseDTO.success();
    }
}
