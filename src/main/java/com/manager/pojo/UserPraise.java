package com.manager.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/30 16:24
 */
@Data
@Table(name = "user_praise")
public class UserPraise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 用户Id
     */
    @Column(name = "user_id")
    private Integer userId;

    /**
     * 房屋名称
     */
    @Column(name = "praise_desc")
    private String praiseDesc;
}
