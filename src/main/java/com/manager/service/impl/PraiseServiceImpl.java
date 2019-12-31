package com.manager.service.impl;

import com.manager.dao.PraiseMapper;
import com.manager.service.PraiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 17:01
 */
@Service
public class PraiseServiceImpl implements PraiseService {

    @Autowired
    private PraiseMapper praiseMapper;
}
