package com.manager.pojo;

import lombok.Data;

import javax.persistence.*;

/**
 * 类描述：
 *
 * @author qying
 * @since 2019/12/27 15:04
 */
@Data
@Table(name = "user_house")
public class UserHouse {

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
    @Column(name = "house_name")
    private String houseName;

}
