package com.manager.controller.admin.system;

import com.manager.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 17:50
 */
@Controller
public class ReportController {

    @Autowired
    private ReportService reportService;
}
