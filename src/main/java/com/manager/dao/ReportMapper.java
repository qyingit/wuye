package com.manager.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 17:05
 */

@Repository
public interface ReportMapper {
    void save(@Param("userId") Long userId,@Param("report") String report);
}
