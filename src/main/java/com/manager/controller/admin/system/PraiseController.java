package com.manager.controller.admin.system;

import com.manager.service.PraiseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 17:49
 */
@Controller
@RequestMapping("/api/prise")
@Slf4j
public class PraiseController {

    @Autowired
    private PraiseService praiseService;
}
