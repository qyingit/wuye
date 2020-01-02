package com.manager.controller.api;

import com.manager.response.ResponseDTO;
import com.manager.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 17:50
 */
@Controller
public class ApiReportController {

    @Autowired
    private ReportService reportService;

    @RequestMapping("/add")
    public ResponseDTO saveReport(String report){
        Long userId = 0l;
        reportService.saveReport(userId, report);
        return ResponseDTO.success();
    }
}
