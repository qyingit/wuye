package com.manager.service.impl;

import com.manager.dao.ReportMapper;
import com.manager.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 17:03
 */
@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private ReportMapper reportMapper;
}
