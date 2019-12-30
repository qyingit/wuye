package com.manager.pojo.wechat;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;

import java.util.List;

/**
 * 类描述：
 *
 * @author weiqiang
 * @Since 2019/05/08 17:24
 */
@Data
public class WeixinUserInfoVO {
    private Integer subscribe;
    private String openid;
    private String nickname;
    /**
     * 性别  公众号用sex表示
     */
    private Integer sex;
    /**
     * 性别 小程序用gender表示
     */
    private Integer gender;
    private String language;
    private String city;
    private String province;
    private String country;
    /**
     * 用户头像  公众号用headimgurl表示
     */
    private String headimgurl;
    /**
     * 用户头像  小程序用avatarUrl表示
     */
    private String avatarUrl;
    @JSONField(name="subscribe_time")
    private String subscribeTime;
    private String unionid;
    private String remark;
    private Integer groupid;
    @JSONField(name="tagid_list")
    private List<Integer> tagidList;
    @JSONField(name="subscribe_scene")
    private String subscribeScene;
    @JSONField(name="qr_scene")
    private Integer qrScene;
    @JSONField(name="qr_scene_str")
    private String qrSceneStr;
}
