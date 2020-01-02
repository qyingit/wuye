package com.manager.service.impl;

import com.manager.dao.ComplaintMapper;
import com.manager.service.ComplaintService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 17:03
 */
@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    private ComplaintMapper complaintMapper;

    @Override
    public void saveComplaint(Long userId, String complaint) {
        complaintMapper.save(userId,complaint);
    }
}
