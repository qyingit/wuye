package com.manager.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 17:06
 */

@Repository
public interface ComplaintMapper {
    void save(@Param("userId") Long userId, @Param("complaint") String complaint);
}
