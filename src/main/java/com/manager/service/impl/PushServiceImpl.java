package com.manager.service.impl;

import com.manager.service.PushService;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @author qying
 * @since 2020/01/02 10:38
 */
@Service
public class PushServiceImpl implements PushService {


    public Boolean pushMessToWechat(){
        return true;
    }

}
